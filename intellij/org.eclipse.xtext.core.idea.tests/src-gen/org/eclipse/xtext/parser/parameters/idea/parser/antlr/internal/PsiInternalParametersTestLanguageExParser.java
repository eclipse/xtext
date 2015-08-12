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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:52:1: entryRuleParserRuleFragmentsEx : ruleParserRuleFragmentsEx EOF ;
    public final void entryRuleParserRuleFragmentsEx() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:52:31: ( ruleParserRuleFragmentsEx EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:53:2: ruleParserRuleFragmentsEx EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParserRuleFragmentsExElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParserRuleFragmentsEx_in_entryRuleParserRuleFragmentsEx54);
            ruleParserRuleFragmentsEx();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRuleFragmentsEx57); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:58:1: ruleParserRuleFragmentsEx : ruleParserRuleParameters ;
    public final void ruleParserRuleFragmentsEx() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:58:26: ( ruleParserRuleParameters )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:59:2: ruleParserRuleParameters
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getParserRuleFragmentsEx_ParserRuleParametersParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_ruleParserRuleParameters_in_ruleParserRuleFragmentsEx69);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:69:1: entryRuleParserRuleParameters : ruleParserRuleParameters EOF ;
    public final void entryRuleParserRuleParameters() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:69:30: ( ruleParserRuleParameters EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:70:2: ruleParserRuleParameters EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParserRuleParametersElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParserRuleParameters_in_entryRuleParserRuleParameters85);
            ruleParserRuleParameters();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRuleParameters88); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:75:1: ruleParserRuleParameters : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:75:25: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:76:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:76:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:77:3: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:77:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:78:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getParserRuleParameters_ParserRuleParametersAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:83:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:84:4: (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:84:4: (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:85:5: otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleParserRuleParameters133); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:92:5: ( (lv_scenario_2_0= ruleScenario1[true] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:93:6: (lv_scenario_2_0= ruleScenario1[true] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:93:6: (lv_scenario_2_0= ruleScenario1[true] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:94:7: lv_scenario_2_0= ruleScenario1[true]
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario1ParserRuleCall_1_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario1_in_ruleParserRuleParameters170);
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:105:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:105:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:106:5: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitTwoKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleParserRuleParameters225); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:113:5: ( (lv_scenario_4_0= ruleScenario1[false] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:114:6: (lv_scenario_4_0= ruleScenario1[false] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:114:6: (lv_scenario_4_0= ruleScenario1[false] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:115:7: lv_scenario_4_0= ruleScenario1[false]
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario1ParserRuleCall_1_1_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario1_in_ruleParserRuleParameters262);
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:126:4: (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:126:4: (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:127:5: otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitThreeKeyword_1_2_0ElementType());
                      				
                    }
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParserRuleParameters317); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_5);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:134:5: ( (lv_scenario_6_0= ruleScenario2[true] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:135:6: (lv_scenario_6_0= ruleScenario2[true] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:135:6: (lv_scenario_6_0= ruleScenario2[true] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:136:7: lv_scenario_6_0= ruleScenario2[true]
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_2_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters354);
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:147:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:147:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:148:5: otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitFourKeyword_1_3_0ElementType());
                      				
                    }
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParserRuleParameters409); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_7);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:155:5: ( (lv_scenario_8_0= ruleScenario2[false] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:156:6: (lv_scenario_8_0= ruleScenario2[false] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:156:6: (lv_scenario_8_0= ruleScenario2[false] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:157:7: lv_scenario_8_0= ruleScenario2[false]
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_3_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters446);
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:168:4: ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:168:4: ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:169:5: ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:178:5: (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:179:6: otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitFiveKeyword_1_4_0_0ElementType());
                      					
                    }
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParserRuleParameters576); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_9);
                      					
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:186:6: ( (lv_scenario_10_0= ruleScenario2[true] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:187:7: (lv_scenario_10_0= ruleScenario2[true] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:187:7: (lv_scenario_10_0= ruleScenario2[true] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:188:8: lv_scenario_10_0= ruleScenario2[true]
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_4_0_1_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters618);
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:200:4: ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:200:4: ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:201:5: ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:210:5: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:211:6: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitSixKeyword_1_5_0_0ElementType());
                      					
                    }
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParserRuleParameters757); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_11);
                      					
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:218:6: ( (lv_scenario_12_0= ruleScenario2[false] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:219:7: (lv_scenario_12_0= ruleScenario2[false] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:219:7: (lv_scenario_12_0= ruleScenario2[false] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:220:8: lv_scenario_12_0= ruleScenario2[false]
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_5_0_1_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters799);
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:232:4: (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:232:4: (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:233:5: otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitSevenKeyword_1_6_0ElementType());
                      				
                    }
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleParserRuleParameters863); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_13);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:240:5: ( (lv_scenario_14_0= ruleScenario3[true] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:241:6: (lv_scenario_14_0= ruleScenario3[true] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:241:6: (lv_scenario_14_0= ruleScenario3[true] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:242:7: lv_scenario_14_0= ruleScenario3[true]
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario3ParserRuleCall_1_6_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario3_in_ruleParserRuleParameters900);
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:253:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:253:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:254:5: otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitEightKeyword_1_7_0ElementType());
                      				
                    }
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleParserRuleParameters955); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_15);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:261:5: ( (lv_scenario_16_0= ruleScenario3[false] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:262:6: (lv_scenario_16_0= ruleScenario3[false] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:262:6: (lv_scenario_16_0= ruleScenario3[false] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:263:7: lv_scenario_16_0= ruleScenario3[false]
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario3ParserRuleCall_1_7_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario3_in_ruleParserRuleParameters992);
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:274:4: (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:274:4: (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:275:5: otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitNineKeyword_1_8_0ElementType());
                      				
                    }
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleParserRuleParameters1047); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_17);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:282:5: ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:283:6: ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:283:6: ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:284:7: ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:288:7: (lv_scenario_18_0= ruleScenario4[true] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:289:8: lv_scenario_18_0= ruleScenario4[true]
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4ParserRuleCall_1_8_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_ruleParserRuleParameters1130);
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:299:6: ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:299:6: ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:300:7: ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:300:7: ( (lv_scenario_19_0= ruleScenario2[true] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:301:8: (lv_scenario_19_0= ruleScenario2[true] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:301:8: (lv_scenario_19_0= ruleScenario2[true] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:302:9: lv_scenario_19_0= ruleScenario2[true]
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_8_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters1212);
                            ruleScenario2(true);

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:311:7: (otherlv_20= 'keyword' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:312:8: otherlv_20= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_8_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters1268); if (state.failed) return ;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:324:4: (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:324:4: (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:325:5: otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitZeroKeyword_1_9_0ElementType());
                      				
                    }
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParserRuleParameters1332); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_21);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:332:5: ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==20) ) {
                        int LA4_1 = input.LA(2);

                        if ( (LA4_1==20) ) {
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:333:6: ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:333:6: ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:334:7: ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:338:7: (lv_scenario_22_0= ruleScenario4[true] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:339:8: lv_scenario_22_0= ruleScenario4[true]
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4ParserRuleCall_1_9_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_ruleParserRuleParameters1415);
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:349:6: ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:349:6: ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:350:7: ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:350:7: ( (lv_scenario_23_0= ruleScenario2[false] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:351:8: (lv_scenario_23_0= ruleScenario2[false] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:351:8: (lv_scenario_23_0= ruleScenario2[false] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:352:9: lv_scenario_23_0= ruleScenario2[false]
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_9_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters1497);
                            ruleScenario2(false);

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:361:7: (otherlv_24= 'keyword' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:362:8: otherlv_24= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_9_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters1553); if (state.failed) return ;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:374:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:374:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:375:5: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitOneKeyword_1_10_0ElementType());
                      				
                    }
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParserRuleParameters1617); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_25);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:382:5: ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==20) ) {
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
                    else if ( (LA6_0==RULE_ID) ) {
                        int LA6_2 = input.LA(2);

                        if ( (LA6_2==20) ) {
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:383:6: ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:383:6: ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:384:7: ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:388:7: (lv_scenario_26_0= ruleScenario4[false] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:389:8: lv_scenario_26_0= ruleScenario4[false]
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4ParserRuleCall_1_10_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_ruleParserRuleParameters1700);
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:399:6: ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:399:6: ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:400:7: ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:400:7: ( (lv_scenario_27_0= ruleScenario2[true] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:401:8: (lv_scenario_27_0= ruleScenario2[true] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:401:8: (lv_scenario_27_0= ruleScenario2[true] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:402:9: lv_scenario_27_0= ruleScenario2[true]
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_10_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters1782);
                            ruleScenario2(true);

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:411:7: (otherlv_28= 'keyword' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:412:8: otherlv_28= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_10_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_28=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters1838); if (state.failed) return ;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:424:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:424:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:425:5: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParserRuleParameters_NumberSignDigitOneDigitTwoKeyword_1_11_0ElementType());
                      				
                    }
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleParserRuleParameters1902); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_29);
                      				
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:432:5: ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==20) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==20) ) {
                            int LA8_3 = input.LA(3);

                            if ( (synpred6_PsiInternalParametersTestLanguageEx()) ) {
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

                            if ( (synpred6_PsiInternalParametersTestLanguageEx()) ) {
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:433:6: ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:433:6: ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:434:7: ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:438:7: (lv_scenario_30_0= ruleScenario4[false] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:439:8: lv_scenario_30_0= ruleScenario4[false]
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario4ParserRuleCall_1_11_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_ruleParserRuleParameters1985);
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:449:6: ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:449:6: ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:450:7: ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )?
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:450:7: ( (lv_scenario_31_0= ruleScenario2[false] ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:451:8: (lv_scenario_31_0= ruleScenario2[false] )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:451:8: (lv_scenario_31_0= ruleScenario2[false] )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:452:9: lv_scenario_31_0= ruleScenario2[false]
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParserRuleParameters_ScenarioScenario2ParserRuleCall_1_11_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters2067);
                            ruleScenario2(false);

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:461:7: (otherlv_32= 'keyword' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:462:8: otherlv_32= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParserRuleParameters_KeywordKeyword_1_11_1_1_1ElementType());
                                      							
                                    }
                                    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters2123); if (state.failed) return ;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:478:1: entryRuleScenario1 : ruleScenario1[false] EOF ;
    public final void entryRuleScenario1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:478:19: ( ruleScenario1[false] EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:479:2: ruleScenario1[false] EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_in_entryRuleScenario12179);
            ruleScenario1(false);

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario12183); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:484:1: ruleScenario1[boolean p_Param] : ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) ) ;
    public final void ruleScenario1(boolean p_Param) throws RecognitionException {
        Token lv_first_0_0=null;
        Token lv_second_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:485:1: ( ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:486:2: ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:486:2: ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:487:3: ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:487:3: ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:488:4: {...}? => ( ( (lv_first_0_0= RULE_ID ) ) )
                    {
                    if ( ! p_Param ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "ruleScenario1", "p_Param");
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:488:16: ( ( (lv_first_0_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:488:17: ( (lv_first_0_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:488:17: ( (lv_first_0_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:489:5: (lv_first_0_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:489:5: (lv_first_0_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:490:6: lv_first_0_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getScenario1_FirstIDTerminalRuleCall_0_0_0ElementType());
                      					
                    }
                    lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleScenario12229); if (state.failed) return ;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:502:3: ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:502:3: ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:503:4: {...}? => ( ( (lv_second_1_0= RULE_ID ) ) )
                    {
                    if ( p_Param ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "ruleScenario1", "!p_Param");
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:503:17: ( ( (lv_second_1_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:503:18: ( (lv_second_1_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:503:18: ( (lv_second_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:504:5: (lv_second_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:504:5: (lv_second_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:505:6: lv_second_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getScenario1_SecondIDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    lv_second_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleScenario12298); if (state.failed) return ;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:520:1: entryRuleScenario2 : ruleScenario2[false] EOF ;
    public final void entryRuleScenario2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:520:19: ( ruleScenario2[false] EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:521:2: ruleScenario2[false] EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario2ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_entryRuleScenario22341);
            ruleScenario2(false);

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario22345); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:526:1: ruleScenario2[boolean p_AllowKeyword] : ( (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] ) ) ;
    public final void ruleScenario2(boolean p_AllowKeyword) throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:527:1: ( ( (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:528:2: ( (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:528:2: ( (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:529:3: (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:529:3: (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:530:4: lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword]
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getScenario2_FirstIdOrKeywordParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_ruleScenario22373);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:542:1: entryRuleScenario3 : ruleScenario3[false] EOF ;
    public final void entryRuleScenario3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:542:19: ( ruleScenario3[false] EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:543:2: ruleScenario3[false] EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario3ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario3_in_entryRuleScenario32399);
            ruleScenario3(false);

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario32403); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:548:1: ruleScenario3[boolean p_AllowKeyword] : ( ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final void ruleScenario3(boolean p_AllowKeyword) throws RecognitionException {
        Token lv_second_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:549:1: ( ( ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:550:2: ( ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:550:2: ( ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred7_PsiInternalParametersTestLanguageEx(p_AllowKeyword)) ) {
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
            else if ( (LA11_0==RULE_ID) && (synpred7_PsiInternalParametersTestLanguageEx(p_AllowKeyword))) {
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:551:3: ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:551:3: ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:552:4: ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:556:4: (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:557:5: lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword]
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getScenario3_FirstIdOrKeywordParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_ruleScenario32462);
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:567:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:567:3: ( (lv_second_1_0= 'keyword' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:568:4: (lv_second_1_0= 'keyword' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:568:4: (lv_second_1_0= 'keyword' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:569:5: lv_second_1_0= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getScenario3_SecondKeywordKeyword_1_0ElementType());
                      				
                    }
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleScenario32509); if (state.failed) return ;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:582:1: entryRuleScenario4 : ruleScenario4[false] EOF ;
    public final void entryRuleScenario4() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:582:19: ( ruleScenario4[false] EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:583:2: ruleScenario4[false] EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario4ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_entryRuleScenario42540);
            ruleScenario4(false);

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario42544); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:588:1: ruleScenario4[boolean p_AllowKeyword] : ( ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= 'keyword' ) ;
    public final void ruleScenario4(boolean p_AllowKeyword) throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:589:1: ( ( ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= 'keyword' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:590:2: ( ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= 'keyword' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:590:2: ( ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= 'keyword' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:591:3: ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= 'keyword'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:591:3: ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:592:4: ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:596:4: (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:597:5: lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword]
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getScenario4_SecondIdOrKeywordParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_ruleScenario42603);
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
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleScenario42629); if (state.failed) return ;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:617:1: entryRuleIdOrKeyword : ruleIdOrKeyword[false] EOF ;
    public final void entryRuleIdOrKeyword() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:617:21: ( ruleIdOrKeyword[false] EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:618:2: ruleIdOrKeyword[false] EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIdOrKeywordElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_entryRuleIdOrKeyword2649);
            ruleIdOrKeyword(false);

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdOrKeyword2653); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:623:1: ruleIdOrKeyword[boolean p_Keyword] : ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID ) ;
    public final void ruleIdOrKeyword(boolean p_Keyword) throws RecognitionException {
        Token kw=null;
        Token this_ID_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:624:1: ( ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:625:2: ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:625:2: ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:626:3: ({...}? => (kw= 'keyword' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:626:3: ({...}? => (kw= 'keyword' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:627:4: {...}? => (kw= 'keyword' )
                    {
                    if ( ! p_Keyword ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "ruleIdOrKeyword", "p_Keyword");
                    }
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:627:18: (kw= 'keyword' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:627:19: kw= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getIdOrKeyword_KeywordKeyword_0_0ElementType());
                      			
                    }
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleIdOrKeyword2684); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:637:3: this_ID_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrKeyword_IDTerminalRuleCall_1ElementType());
                      		
                    }
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdOrKeyword2716); if (state.failed) return ;
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

    // $ANTLR start synpred1_PsiInternalParametersTestLanguageEx
    public final void synpred1_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:169:5: ( ( '#5' ( ( ruleScenario2[true] ) ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:169:6: ( '#5' ( ( ruleScenario2[true] ) ) )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:169:6: ( '#5' ( ( ruleScenario2[true] ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:170:6: '#5' ( ( ruleScenario2[true] ) )
        {
        match(input,15,FollowSets000.FOLLOW_15_in_synpred1_PsiInternalParametersTestLanguageEx501); if (state.failed) return ;
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:171:6: ( ( ruleScenario2[true] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:172:7: ( ruleScenario2[true] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:172:7: ( ruleScenario2[true] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:173:8: ruleScenario2[true]
        {
        pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_synpred1_PsiInternalParametersTestLanguageEx525);
        ruleScenario2(true);

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
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:201:5: ( ( '#6' ( ( ruleScenario2[false] ) ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:201:6: ( '#6' ( ( ruleScenario2[false] ) ) )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:201:6: ( '#6' ( ( ruleScenario2[false] ) ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:202:6: '#6' ( ( ruleScenario2[false] ) )
        {
        match(input,16,FollowSets000.FOLLOW_16_in_synpred2_PsiInternalParametersTestLanguageEx682); if (state.failed) return ;
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:203:6: ( ( ruleScenario2[false] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:204:7: ( ruleScenario2[false] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:204:7: ( ruleScenario2[false] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:205:8: ruleScenario2[false]
        {
        pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_synpred2_PsiInternalParametersTestLanguageEx706);
        ruleScenario2(false);

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
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:284:7: ( ( ruleIdOrKeyword[true] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:284:8: ( ruleIdOrKeyword[true] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:284:8: ( ruleIdOrKeyword[true] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:285:8: ruleIdOrKeyword[true]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred3_PsiInternalParametersTestLanguageEx1084);
        ruleIdOrKeyword(true);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_PsiInternalParametersTestLanguageEx

    // $ANTLR start synpred4_PsiInternalParametersTestLanguageEx
    public final void synpred4_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:334:7: ( ( ruleIdOrKeyword[true] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:334:8: ( ruleIdOrKeyword[true] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:334:8: ( ruleIdOrKeyword[true] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:335:8: ruleIdOrKeyword[true]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred4_PsiInternalParametersTestLanguageEx1369);
        ruleIdOrKeyword(true);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_PsiInternalParametersTestLanguageEx

    // $ANTLR start synpred5_PsiInternalParametersTestLanguageEx
    public final void synpred5_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:384:7: ( ( ruleIdOrKeyword[false] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:384:8: ( ruleIdOrKeyword[false] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:384:8: ( ruleIdOrKeyword[false] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:385:8: ruleIdOrKeyword[false]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred5_PsiInternalParametersTestLanguageEx1654);
        ruleIdOrKeyword(false);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_PsiInternalParametersTestLanguageEx

    // $ANTLR start synpred6_PsiInternalParametersTestLanguageEx
    public final void synpred6_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:434:7: ( ( ruleIdOrKeyword[false] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:434:8: ( ruleIdOrKeyword[false] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:434:8: ( ruleIdOrKeyword[false] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:435:8: ruleIdOrKeyword[false]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred6_PsiInternalParametersTestLanguageEx1939);
        ruleIdOrKeyword(false);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_PsiInternalParametersTestLanguageEx

    // $ANTLR start synpred7_PsiInternalParametersTestLanguageEx
    public final void synpred7_PsiInternalParametersTestLanguageEx_fragment(boolean p_AllowKeyword) throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:552:4: ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:552:5: ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] )
        {
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:552:5: ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] )
        // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/parameters/idea/parser/antlr/internal/PsiInternalParametersTestLanguageEx.g:553:5: ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred7_PsiInternalParametersTestLanguageEx2431);
        ruleIdOrKeyword(p_AllowKeyword);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_PsiInternalParametersTestLanguageEx

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
    public final boolean synpred7_PsiInternalParametersTestLanguageEx(boolean p_AllowKeyword) {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PsiInternalParametersTestLanguageEx_fragment(p_AllowKeyword); // can never throw exception
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
            return "83:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( '#5' ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= 'keyword' )? ) ) ) )";
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
        public static final BitSet FOLLOW_ruleParserRuleFragmentsEx_in_entryRuleParserRuleFragmentsEx54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRuleFragmentsEx57 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRuleParameters_in_ruleParserRuleFragmentsEx69 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRuleParameters_in_entryRuleParserRuleParameters85 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRuleParameters88 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleParserRuleParameters133 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleScenario1_in_ruleParserRuleParameters170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleParserRuleParameters225 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleScenario1_in_ruleParserRuleParameters262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleParserRuleParameters317 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleParserRuleParameters409 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParserRuleParameters576 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleParserRuleParameters757 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleParserRuleParameters863 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario3_in_ruleParserRuleParameters900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleParserRuleParameters955 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario3_in_ruleParserRuleParameters992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleParserRuleParameters1047 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario4_in_ruleParserRuleParameters1130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters1212 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters1268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleParserRuleParameters1332 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario4_in_ruleParserRuleParameters1415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters1497 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters1553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleParserRuleParameters1617 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario4_in_ruleParserRuleParameters1700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters1782 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters1838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleParserRuleParameters1902 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario4_in_ruleParserRuleParameters1985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters2067 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters2123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_in_entryRuleScenario12179 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario12183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleScenario12229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleScenario12298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_entryRuleScenario22341 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario22345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_ruleScenario22373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario3_in_entryRuleScenario32399 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario32403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_ruleScenario32462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleScenario32509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario4_in_entryRuleScenario42540 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario42544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_ruleScenario42603 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleScenario42629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_entryRuleIdOrKeyword2649 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdOrKeyword2653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleIdOrKeyword2684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdOrKeyword2716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_synpred1_PsiInternalParametersTestLanguageEx501 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_in_synpred1_PsiInternalParametersTestLanguageEx525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_synpred2_PsiInternalParametersTestLanguageEx682 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario2_in_synpred2_PsiInternalParametersTestLanguageEx706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred3_PsiInternalParametersTestLanguageEx1084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred4_PsiInternalParametersTestLanguageEx1369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred5_PsiInternalParametersTestLanguageEx1654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred6_PsiInternalParametersTestLanguageEx1939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred7_PsiInternalParametersTestLanguageEx2431 = new BitSet(new long[]{0x0000000000000002L});
    }


}