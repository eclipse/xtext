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
    // PsiInternalParametersTestLanguageEx.g:52:1: entryRuleParserRuleParameters returns [Boolean current=false] : iv_ruleParserRuleParameters= ruleParserRuleParameters EOF ;
    public final Boolean entryRuleParserRuleParameters() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParserRuleParameters = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:52:62: (iv_ruleParserRuleParameters= ruleParserRuleParameters EOF )
            // PsiInternalParametersTestLanguageEx.g:53:2: iv_ruleParserRuleParameters= ruleParserRuleParameters EOF
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
    // PsiInternalParametersTestLanguageEx.g:59:1: ruleParserRuleParameters returns [Boolean current=false] : this_ParserRuleParameters_0= superParserRuleParameters ;
    public final Boolean ruleParserRuleParameters() throws RecognitionException {
        Boolean current = false;

        Boolean this_ParserRuleParameters_0 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:60:1: (this_ParserRuleParameters_0= superParserRuleParameters )
            // PsiInternalParametersTestLanguageEx.g:61:2: this_ParserRuleParameters_0= superParserRuleParameters
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getParserRuleParameters_ParserRuleParametersParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ParserRuleParameters_0=superParserRuleParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_ParserRuleParameters_0;
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
        return current;
    }
    // $ANTLR end "ruleParserRuleParameters"


    // $ANTLR start "entryRuleScenario1"
    // PsiInternalParametersTestLanguageEx.g:72:1: entryRuleScenario1 returns [Boolean current=false] : iv_ruleScenario1= ruleScenario1 EOF ;
    public final Boolean entryRuleScenario1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleScenario1 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:72:51: (iv_ruleScenario1= ruleScenario1 EOF )
            // PsiInternalParametersTestLanguageEx.g:73:2: iv_ruleScenario1= ruleScenario1 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario1ElementType()); 
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
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario1"


    // $ANTLR start "ruleScenario1"
    // PsiInternalParametersTestLanguageEx.g:79:1: ruleScenario1 returns [Boolean current=false] : this_Scenario1_0= superScenario1 ;
    public final Boolean ruleScenario1() throws RecognitionException {
        Boolean current = false;

        Boolean this_Scenario1_0 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:80:1: (this_Scenario1_0= superScenario1 )
            // PsiInternalParametersTestLanguageEx.g:81:2: this_Scenario1_0= superScenario1
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getScenario1_Scenario1ParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Scenario1_0=superScenario1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_Scenario1_0;
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
        return current;
    }
    // $ANTLR end "ruleScenario1"


    // $ANTLR start "norm1_Scenario1"
    // PsiInternalParametersTestLanguageEx.g:93:1: norm1_Scenario1 returns [Boolean current=false] : this_Scenario1_0= normSuper1_Scenario1 ;
    public final Boolean norm1_Scenario1() throws RecognitionException {
        Boolean current = false;

        Boolean this_Scenario1_0 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:94:1: (this_Scenario1_0= normSuper1_Scenario1 )
            // PsiInternalParametersTestLanguageEx.g:95:2: this_Scenario1_0= normSuper1_Scenario1
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getScenario1_Scenario1ParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Scenario1_0=normSuper1_Scenario1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_Scenario1_0;
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
        return current;
    }
    // $ANTLR end "norm1_Scenario1"


    // $ANTLR start "entrySuperParserRuleParameters"
    // PsiInternalParametersTestLanguageEx.g:106:1: entrySuperParserRuleParameters returns [Boolean current=false] : iv_superParserRuleParameters= superParserRuleParameters EOF ;
    public final Boolean entrySuperParserRuleParameters() throws RecognitionException {
        Boolean current = false;

        Boolean iv_superParserRuleParameters = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:106:63: (iv_superParserRuleParameters= superParserRuleParameters EOF )
            // PsiInternalParametersTestLanguageEx.g:107:2: iv_superParserRuleParameters= superParserRuleParameters EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParametersElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_superParserRuleParameters=superParserRuleParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_superParserRuleParameters; 
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
    // $ANTLR end "entrySuperParserRuleParameters"


    // $ANTLR start "superParserRuleParameters"
    // PsiInternalParametersTestLanguageEx.g:113:1: superParserRuleParameters returns [Boolean current=false] : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) ;
    public final Boolean superParserRuleParameters() throws RecognitionException {
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
            // PsiInternalParametersTestLanguageEx.g:114:1: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) )
            // PsiInternalParametersTestLanguageEx.g:115:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            {
            // PsiInternalParametersTestLanguageEx.g:115:2: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            // PsiInternalParametersTestLanguageEx.g:116:3: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )
            {
            // PsiInternalParametersTestLanguageEx.g:116:3: ()
            // PsiInternalParametersTestLanguageEx.g:117:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ParserRuleParametersAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalParametersTestLanguageEx.g:123:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // PsiInternalParametersTestLanguageEx.g:124:4: (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:124:4: (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:125:5: otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitOneKeyword_1_0_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:132:5: ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    // PsiInternalParametersTestLanguageEx.g:133:6: (lv_scenario_2_0= norm1_Scenario1 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:133:6: (lv_scenario_2_0= norm1_Scenario1 )
                    // PsiInternalParametersTestLanguageEx.g:134:7: lv_scenario_2_0= norm1_Scenario1
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario1ParserRuleCall_1_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_2_0=norm1_Scenario1();

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
                    // PsiInternalParametersTestLanguageEx.g:149:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:149:4: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:150:5: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitTwoKeyword_1_1_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:157:5: ( (lv_scenario_4_0= ruleScenario1 ) )
                    // PsiInternalParametersTestLanguageEx.g:158:6: (lv_scenario_4_0= ruleScenario1 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:158:6: (lv_scenario_4_0= ruleScenario1 )
                    // PsiInternalParametersTestLanguageEx.g:159:7: lv_scenario_4_0= ruleScenario1
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario1ParserRuleCall_1_1_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_4_0=ruleScenario1();

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
                    // PsiInternalParametersTestLanguageEx.g:174:4: (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:174:4: (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:175:5: otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitThreeKeyword_1_2_0ElementType());
                      				
                    }
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_5);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:182:5: ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    // PsiInternalParametersTestLanguageEx.g:183:6: (lv_scenario_6_0= norm1_Scenario2 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:183:6: (lv_scenario_6_0= norm1_Scenario2 )
                    // PsiInternalParametersTestLanguageEx.g:184:7: lv_scenario_6_0= norm1_Scenario2
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_2_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_6_0=norm1_Scenario2();

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
                    // PsiInternalParametersTestLanguageEx.g:199:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:199:4: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:200:5: otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitFourKeyword_1_3_0ElementType());
                      				
                    }
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_7);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:207:5: ( (lv_scenario_8_0= ruleScenario2 ) )
                    // PsiInternalParametersTestLanguageEx.g:208:6: (lv_scenario_8_0= ruleScenario2 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:208:6: (lv_scenario_8_0= ruleScenario2 )
                    // PsiInternalParametersTestLanguageEx.g:209:7: lv_scenario_8_0= ruleScenario2
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_3_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_8_0=ruleScenario2();

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
                    // PsiInternalParametersTestLanguageEx.g:224:4: ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:224:4: ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    // PsiInternalParametersTestLanguageEx.g:225:5: ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:234:5: (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:235:6: otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitFiveKeyword_1_4_0_0ElementType());
                      					
                    }
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_9);
                      					
                    }
                    // PsiInternalParametersTestLanguageEx.g:242:6: ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    // PsiInternalParametersTestLanguageEx.g:243:7: (lv_scenario_10_0= norm1_Scenario2 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:243:7: (lv_scenario_10_0= norm1_Scenario2 )
                    // PsiInternalParametersTestLanguageEx.g:244:8: lv_scenario_10_0= norm1_Scenario2
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_4_0_1_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_10_0=norm1_Scenario2();

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
                    // PsiInternalParametersTestLanguageEx.g:260:4: ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:260:4: ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    // PsiInternalParametersTestLanguageEx.g:261:5: ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:270:5: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:271:6: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) )
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitSixKeyword_1_5_0_0ElementType());
                      					
                    }
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(otherlv_11);
                      					
                    }
                    // PsiInternalParametersTestLanguageEx.g:278:6: ( (lv_scenario_12_0= ruleScenario2 ) )
                    // PsiInternalParametersTestLanguageEx.g:279:7: (lv_scenario_12_0= ruleScenario2 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:279:7: (lv_scenario_12_0= ruleScenario2 )
                    // PsiInternalParametersTestLanguageEx.g:280:8: lv_scenario_12_0= ruleScenario2
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_5_0_1_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_12_0=ruleScenario2();

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
                    // PsiInternalParametersTestLanguageEx.g:296:4: (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:296:4: (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:297:5: otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitSevenKeyword_1_6_0ElementType());
                      				
                    }
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_13);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:304:5: ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    // PsiInternalParametersTestLanguageEx.g:305:6: (lv_scenario_14_0= norm1_Scenario3 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:305:6: (lv_scenario_14_0= norm1_Scenario3 )
                    // PsiInternalParametersTestLanguageEx.g:306:7: lv_scenario_14_0= norm1_Scenario3
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario3ParserRuleCall_1_6_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_14_0=norm1_Scenario3();

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
                    // PsiInternalParametersTestLanguageEx.g:321:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:321:4: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    // PsiInternalParametersTestLanguageEx.g:322:5: otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitEightKeyword_1_7_0ElementType());
                      				
                    }
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_15);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:329:5: ( (lv_scenario_16_0= ruleScenario3 ) )
                    // PsiInternalParametersTestLanguageEx.g:330:6: (lv_scenario_16_0= ruleScenario3 )
                    {
                    // PsiInternalParametersTestLanguageEx.g:330:6: (lv_scenario_16_0= ruleScenario3 )
                    // PsiInternalParametersTestLanguageEx.g:331:7: lv_scenario_16_0= ruleScenario3
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario3ParserRuleCall_1_7_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_16_0=ruleScenario3();

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
                    // PsiInternalParametersTestLanguageEx.g:346:4: (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:346:4: (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguageEx.g:347:5: otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitNineKeyword_1_8_0ElementType());
                      				
                    }
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_17);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:354:5: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) )
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

                            if ( (synpred3_PsiInternalParametersTestLanguageEx()) ) {
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
                            // PsiInternalParametersTestLanguageEx.g:355:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            {
                            // PsiInternalParametersTestLanguageEx.g:355:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            // PsiInternalParametersTestLanguageEx.g:356:7: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:360:7: (lv_scenario_18_0= norm1_Scenario4 )
                            // PsiInternalParametersTestLanguageEx.g:361:8: lv_scenario_18_0= norm1_Scenario4
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario4ParserRuleCall_1_8_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_18_0=norm1_Scenario4();

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
                            // PsiInternalParametersTestLanguageEx.g:375:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguageEx.g:375:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? )
                            // PsiInternalParametersTestLanguageEx.g:376:7: ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguageEx.g:376:7: ( (lv_scenario_19_0= norm1_Scenario2 ) )
                            // PsiInternalParametersTestLanguageEx.g:377:8: (lv_scenario_19_0= norm1_Scenario2 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:377:8: (lv_scenario_19_0= norm1_Scenario2 )
                            // PsiInternalParametersTestLanguageEx.g:378:9: lv_scenario_19_0= norm1_Scenario2
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_8_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_19_0=norm1_Scenario2();

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

                            // PsiInternalParametersTestLanguageEx.g:391:7: (otherlv_20= 'keyword' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // PsiInternalParametersTestLanguageEx.g:392:8: otherlv_20= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_KeywordKeyword_1_8_1_1_1ElementType());
                                      							
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
                    // PsiInternalParametersTestLanguageEx.g:404:4: (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:404:4: (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguageEx.g:405:5: otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitOneDigitZeroKeyword_1_9_0ElementType());
                      				
                    }
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_21);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:412:5: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) )
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
                            // PsiInternalParametersTestLanguageEx.g:413:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            {
                            // PsiInternalParametersTestLanguageEx.g:413:6: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            // PsiInternalParametersTestLanguageEx.g:414:7: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:418:7: (lv_scenario_22_0= norm1_Scenario4 )
                            // PsiInternalParametersTestLanguageEx.g:419:8: lv_scenario_22_0= norm1_Scenario4
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario4ParserRuleCall_1_9_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_22_0=norm1_Scenario4();

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
                            // PsiInternalParametersTestLanguageEx.g:433:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguageEx.g:433:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? )
                            // PsiInternalParametersTestLanguageEx.g:434:7: ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguageEx.g:434:7: ( (lv_scenario_23_0= ruleScenario2 ) )
                            // PsiInternalParametersTestLanguageEx.g:435:8: (lv_scenario_23_0= ruleScenario2 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:435:8: (lv_scenario_23_0= ruleScenario2 )
                            // PsiInternalParametersTestLanguageEx.g:436:9: lv_scenario_23_0= ruleScenario2
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_9_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_23_0=ruleScenario2();

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

                            // PsiInternalParametersTestLanguageEx.g:449:7: (otherlv_24= 'keyword' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // PsiInternalParametersTestLanguageEx.g:450:8: otherlv_24= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_KeywordKeyword_1_9_1_1_1ElementType());
                                      							
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
                    // PsiInternalParametersTestLanguageEx.g:462:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:462:4: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguageEx.g:463:5: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitOneDigitOneKeyword_1_10_0ElementType());
                      				
                    }
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_25);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:470:5: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) )
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
                            // PsiInternalParametersTestLanguageEx.g:471:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            {
                            // PsiInternalParametersTestLanguageEx.g:471:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            // PsiInternalParametersTestLanguageEx.g:472:7: ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:476:7: (lv_scenario_26_0= ruleScenario4 )
                            // PsiInternalParametersTestLanguageEx.g:477:8: lv_scenario_26_0= ruleScenario4
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario4ParserRuleCall_1_10_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_26_0=ruleScenario4();

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
                            // PsiInternalParametersTestLanguageEx.g:491:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguageEx.g:491:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? )
                            // PsiInternalParametersTestLanguageEx.g:492:7: ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguageEx.g:492:7: ( (lv_scenario_27_0= norm1_Scenario2 ) )
                            // PsiInternalParametersTestLanguageEx.g:493:8: (lv_scenario_27_0= norm1_Scenario2 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:493:8: (lv_scenario_27_0= norm1_Scenario2 )
                            // PsiInternalParametersTestLanguageEx.g:494:9: lv_scenario_27_0= norm1_Scenario2
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_10_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_27_0=norm1_Scenario2();

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

                            // PsiInternalParametersTestLanguageEx.g:507:7: (otherlv_28= 'keyword' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // PsiInternalParametersTestLanguageEx.g:508:8: otherlv_28= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_KeywordKeyword_1_10_1_1_1ElementType());
                                      							
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
                    // PsiInternalParametersTestLanguageEx.g:520:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:520:4: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) )
                    // PsiInternalParametersTestLanguageEx.g:521:5: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_NumberSignDigitOneDigitTwoKeyword_1_11_0ElementType());
                      				
                    }
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_29);
                      				
                    }
                    // PsiInternalParametersTestLanguageEx.g:528:5: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) )
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
                            // PsiInternalParametersTestLanguageEx.g:529:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            {
                            // PsiInternalParametersTestLanguageEx.g:529:6: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            // PsiInternalParametersTestLanguageEx.g:530:7: ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:534:7: (lv_scenario_30_0= ruleScenario4 )
                            // PsiInternalParametersTestLanguageEx.g:535:8: lv_scenario_30_0= ruleScenario4
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario4ParserRuleCall_1_11_1_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_30_0=ruleScenario4();

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
                            // PsiInternalParametersTestLanguageEx.g:549:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? )
                            {
                            // PsiInternalParametersTestLanguageEx.g:549:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? )
                            // PsiInternalParametersTestLanguageEx.g:550:7: ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )?
                            {
                            // PsiInternalParametersTestLanguageEx.g:550:7: ( (lv_scenario_31_0= ruleScenario2 ) )
                            // PsiInternalParametersTestLanguageEx.g:551:8: (lv_scenario_31_0= ruleScenario2 )
                            {
                            // PsiInternalParametersTestLanguageEx.g:551:8: (lv_scenario_31_0= ruleScenario2 )
                            // PsiInternalParametersTestLanguageEx.g:552:9: lv_scenario_31_0= ruleScenario2
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getParametersTestLanguageParserRuleParameters_ScenarioScenario2ParserRuleCall_1_11_1_1_0_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_31_0=ruleScenario2();

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

                            // PsiInternalParametersTestLanguageEx.g:565:7: (otherlv_32= 'keyword' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // PsiInternalParametersTestLanguageEx.g:566:8: otherlv_32= 'keyword'
                                    {
                                    if ( state.backtracking==0 ) {

                                      								markLeaf(elementTypeProvider.getParametersTestLanguageParserRuleParameters_KeywordKeyword_1_11_1_1_1ElementType());
                                      							
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
    // $ANTLR end "superParserRuleParameters"


    // $ANTLR start "entrySuperScenario1"
    // PsiInternalParametersTestLanguageEx.g:582:1: entrySuperScenario1 returns [Boolean current=false] : iv_superScenario1= superScenario1 EOF ;
    public final Boolean entrySuperScenario1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_superScenario1 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:582:52: (iv_superScenario1= superScenario1 EOF )
            // PsiInternalParametersTestLanguageEx.g:583:2: iv_superScenario1= superScenario1 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParametersTestLanguageScenario1ElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_superScenario1=superScenario1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_superScenario1; 
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
    // $ANTLR end "entrySuperScenario1"


    // $ANTLR start "superScenario1"
    // PsiInternalParametersTestLanguageEx.g:589:1: superScenario1 returns [Boolean current=false] : ( (lv_second_0_0= RULE_ID ) ) ;
    public final Boolean superScenario1() throws RecognitionException {
        Boolean current = false;

        Token lv_second_0_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:590:1: ( ( (lv_second_0_0= RULE_ID ) ) )
            // PsiInternalParametersTestLanguageEx.g:591:2: ( (lv_second_0_0= RULE_ID ) )
            {
            // PsiInternalParametersTestLanguageEx.g:591:2: ( (lv_second_0_0= RULE_ID ) )
            // PsiInternalParametersTestLanguageEx.g:592:3: (lv_second_0_0= RULE_ID )
            {
            // PsiInternalParametersTestLanguageEx.g:592:3: (lv_second_0_0= RULE_ID )
            // PsiInternalParametersTestLanguageEx.g:593:4: lv_second_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getParametersTestLanguageScenario1_SecondIDTerminalRuleCall_1_0_0ElementType());
              			
            }
            lv_second_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
            }
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
    // $ANTLR end "superScenario1"


    // $ANTLR start "normSuper1_Scenario1"
    // PsiInternalParametersTestLanguageEx.g:612:1: normSuper1_Scenario1 returns [Boolean current=false] : ( (lv_first_0_0= RULE_ID ) ) ;
    public final Boolean normSuper1_Scenario1() throws RecognitionException {
        Boolean current = false;

        Token lv_first_0_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:613:1: ( ( (lv_first_0_0= RULE_ID ) ) )
            // PsiInternalParametersTestLanguageEx.g:614:2: ( (lv_first_0_0= RULE_ID ) )
            {
            // PsiInternalParametersTestLanguageEx.g:614:2: ( (lv_first_0_0= RULE_ID ) )
            // PsiInternalParametersTestLanguageEx.g:615:3: (lv_first_0_0= RULE_ID )
            {
            // PsiInternalParametersTestLanguageEx.g:615:3: (lv_first_0_0= RULE_ID )
            // PsiInternalParametersTestLanguageEx.g:616:4: lv_first_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getParametersTestLanguageScenario1_FirstIDTerminalRuleCall_0_0_0ElementType());
              			
            }
            lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
            }
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
    // $ANTLR end "normSuper1_Scenario1"


    // $ANTLR start "entryRuleScenario2"
    // PsiInternalParametersTestLanguageEx.g:634:1: entryRuleScenario2 returns [Boolean current=false] : iv_ruleScenario2= ruleScenario2 EOF ;
    public final Boolean entryRuleScenario2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleScenario2 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:634:51: (iv_ruleScenario2= ruleScenario2 EOF )
            // PsiInternalParametersTestLanguageEx.g:635:2: iv_ruleScenario2= ruleScenario2 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario2ElementType()); 
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
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario2"


    // $ANTLR start "ruleScenario2"
    // PsiInternalParametersTestLanguageEx.g:641:1: ruleScenario2 returns [Boolean current=false] : ( (lv_first_0_0= ruleIdOrKeyword ) ) ;
    public final Boolean ruleScenario2() throws RecognitionException {
        Boolean current = false;

        Boolean lv_first_0_0 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:642:1: ( ( (lv_first_0_0= ruleIdOrKeyword ) ) )
            // PsiInternalParametersTestLanguageEx.g:643:2: ( (lv_first_0_0= ruleIdOrKeyword ) )
            {
            // PsiInternalParametersTestLanguageEx.g:643:2: ( (lv_first_0_0= ruleIdOrKeyword ) )
            // PsiInternalParametersTestLanguageEx.g:644:3: (lv_first_0_0= ruleIdOrKeyword )
            {
            // PsiInternalParametersTestLanguageEx.g:644:3: (lv_first_0_0= ruleIdOrKeyword )
            // PsiInternalParametersTestLanguageEx.g:645:4: lv_first_0_0= ruleIdOrKeyword
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getScenario2_FirstIdOrKeywordParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=ruleIdOrKeyword();

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
    // $ANTLR end "ruleScenario2"


    // $ANTLR start "norm1_Scenario2"
    // PsiInternalParametersTestLanguageEx.g:662:1: norm1_Scenario2 returns [Boolean current=false] : ( (lv_first_0_0= norm1_IdOrKeyword ) ) ;
    public final Boolean norm1_Scenario2() throws RecognitionException {
        Boolean current = false;

        Boolean lv_first_0_0 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:663:1: ( ( (lv_first_0_0= norm1_IdOrKeyword ) ) )
            // PsiInternalParametersTestLanguageEx.g:664:2: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            {
            // PsiInternalParametersTestLanguageEx.g:664:2: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            // PsiInternalParametersTestLanguageEx.g:665:3: (lv_first_0_0= norm1_IdOrKeyword )
            {
            // PsiInternalParametersTestLanguageEx.g:665:3: (lv_first_0_0= norm1_IdOrKeyword )
            // PsiInternalParametersTestLanguageEx.g:666:4: lv_first_0_0= norm1_IdOrKeyword
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getScenario2_FirstIdOrKeywordParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=norm1_IdOrKeyword();

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
    // $ANTLR end "norm1_Scenario2"


    // $ANTLR start "entryRuleScenario3"
    // PsiInternalParametersTestLanguageEx.g:682:1: entryRuleScenario3 returns [Boolean current=false] : iv_ruleScenario3= ruleScenario3 EOF ;
    public final Boolean entryRuleScenario3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleScenario3 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:682:51: (iv_ruleScenario3= ruleScenario3 EOF )
            // PsiInternalParametersTestLanguageEx.g:683:2: iv_ruleScenario3= ruleScenario3 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario3ElementType()); 
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
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario3"


    // $ANTLR start "ruleScenario3"
    // PsiInternalParametersTestLanguageEx.g:689:1: ruleScenario3 returns [Boolean current=false] : ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final Boolean ruleScenario3() throws RecognitionException {
        Boolean current = false;

        Token lv_second_1_0=null;
        Boolean lv_first_0_0 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:690:1: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // PsiInternalParametersTestLanguageEx.g:691:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // PsiInternalParametersTestLanguageEx.g:691:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) && (synpred7_PsiInternalParametersTestLanguageEx())) {
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
                    // PsiInternalParametersTestLanguageEx.g:692:3: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:692:3: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    // PsiInternalParametersTestLanguageEx.g:693:4: ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword )
                    {
                    // PsiInternalParametersTestLanguageEx.g:697:4: (lv_first_0_0= ruleIdOrKeyword )
                    // PsiInternalParametersTestLanguageEx.g:698:5: lv_first_0_0= ruleIdOrKeyword
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getScenario3_FirstIdOrKeywordParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_0_0=ruleIdOrKeyword();

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
                    // PsiInternalParametersTestLanguageEx.g:712:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:712:3: ( (lv_second_1_0= 'keyword' ) )
                    // PsiInternalParametersTestLanguageEx.g:713:4: (lv_second_1_0= 'keyword' )
                    {
                    // PsiInternalParametersTestLanguageEx.g:713:4: (lv_second_1_0= 'keyword' )
                    // PsiInternalParametersTestLanguageEx.g:714:5: lv_second_1_0= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getScenario3_SecondKeywordKeyword_1_0ElementType());
                      				
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
    // $ANTLR end "ruleScenario3"


    // $ANTLR start "norm1_Scenario3"
    // PsiInternalParametersTestLanguageEx.g:734:1: norm1_Scenario3 returns [Boolean current=false] : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final Boolean norm1_Scenario3() throws RecognitionException {
        Boolean current = false;

        Token lv_second_1_0=null;
        Boolean lv_first_0_0 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:735:1: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // PsiInternalParametersTestLanguageEx.g:736:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // PsiInternalParametersTestLanguageEx.g:736:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'keyword' ) ) )
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
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA11_0==RULE_ID) && (synpred8_PsiInternalParametersTestLanguageEx())) {
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
                    // PsiInternalParametersTestLanguageEx.g:737:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:737:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    // PsiInternalParametersTestLanguageEx.g:738:4: ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword )
                    {
                    // PsiInternalParametersTestLanguageEx.g:742:4: (lv_first_0_0= norm1_IdOrKeyword )
                    // PsiInternalParametersTestLanguageEx.g:743:5: lv_first_0_0= norm1_IdOrKeyword
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getScenario3_FirstIdOrKeywordParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_0_0=norm1_IdOrKeyword();

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
                    // PsiInternalParametersTestLanguageEx.g:757:3: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // PsiInternalParametersTestLanguageEx.g:757:3: ( (lv_second_1_0= 'keyword' ) )
                    // PsiInternalParametersTestLanguageEx.g:758:4: (lv_second_1_0= 'keyword' )
                    {
                    // PsiInternalParametersTestLanguageEx.g:758:4: (lv_second_1_0= 'keyword' )
                    // PsiInternalParametersTestLanguageEx.g:759:5: lv_second_1_0= 'keyword'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getScenario3_SecondKeywordKeyword_1_0ElementType());
                      				
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
    // $ANTLR end "norm1_Scenario3"


    // $ANTLR start "entryRuleScenario4"
    // PsiInternalParametersTestLanguageEx.g:778:1: entryRuleScenario4 returns [Boolean current=false] : iv_ruleScenario4= ruleScenario4 EOF ;
    public final Boolean entryRuleScenario4() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleScenario4 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:778:51: (iv_ruleScenario4= ruleScenario4 EOF )
            // PsiInternalParametersTestLanguageEx.g:779:2: iv_ruleScenario4= ruleScenario4 EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getScenario4ElementType()); 
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
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario4"


    // $ANTLR start "ruleScenario4"
    // PsiInternalParametersTestLanguageEx.g:785:1: ruleScenario4 returns [Boolean current=false] : ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' ) ;
    public final Boolean ruleScenario4() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_second_0_0 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:786:1: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' ) )
            // PsiInternalParametersTestLanguageEx.g:787:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' )
            {
            // PsiInternalParametersTestLanguageEx.g:787:2: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword' )
            // PsiInternalParametersTestLanguageEx.g:788:3: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'keyword'
            {
            // PsiInternalParametersTestLanguageEx.g:788:3: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) )
            // PsiInternalParametersTestLanguageEx.g:789:4: ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword )
            {
            // PsiInternalParametersTestLanguageEx.g:793:4: (lv_second_0_0= ruleIdOrKeyword )
            // PsiInternalParametersTestLanguageEx.g:794:5: lv_second_0_0= ruleIdOrKeyword
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getScenario4_SecondIdOrKeywordParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_second_0_0=ruleIdOrKeyword();

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

              			markLeaf(elementTypeProvider.getScenario4_KeywordKeyword_1ElementType());
              		
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
    // $ANTLR end "ruleScenario4"


    // $ANTLR start "norm1_Scenario4"
    // PsiInternalParametersTestLanguageEx.g:819:1: norm1_Scenario4 returns [Boolean current=false] : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' ) ;
    public final Boolean norm1_Scenario4() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_second_0_0 = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:820:1: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' ) )
            // PsiInternalParametersTestLanguageEx.g:821:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' )
            {
            // PsiInternalParametersTestLanguageEx.g:821:2: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword' )
            // PsiInternalParametersTestLanguageEx.g:822:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'keyword'
            {
            // PsiInternalParametersTestLanguageEx.g:822:3: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) )
            // PsiInternalParametersTestLanguageEx.g:823:4: ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword )
            {
            // PsiInternalParametersTestLanguageEx.g:827:4: (lv_second_0_0= norm1_IdOrKeyword )
            // PsiInternalParametersTestLanguageEx.g:828:5: lv_second_0_0= norm1_IdOrKeyword
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getScenario4_SecondIdOrKeywordParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_second_0_0=norm1_IdOrKeyword();

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

              			markLeaf(elementTypeProvider.getScenario4_KeywordKeyword_1ElementType());
              		
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
    // $ANTLR end "norm1_Scenario4"


    // $ANTLR start "entryRuleIdOrKeyword"
    // PsiInternalParametersTestLanguageEx.g:852:1: entryRuleIdOrKeyword returns [Boolean current=false] : iv_ruleIdOrKeyword= ruleIdOrKeyword EOF ;
    public final Boolean entryRuleIdOrKeyword() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIdOrKeyword = null;


        try {
            // PsiInternalParametersTestLanguageEx.g:852:53: (iv_ruleIdOrKeyword= ruleIdOrKeyword EOF )
            // PsiInternalParametersTestLanguageEx.g:853:2: iv_ruleIdOrKeyword= ruleIdOrKeyword EOF
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
    // PsiInternalParametersTestLanguageEx.g:859:1: ruleIdOrKeyword returns [Boolean current=false] : this_ID_0= RULE_ID ;
    public final Boolean ruleIdOrKeyword() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:860:1: (this_ID_0= RULE_ID )
            // PsiInternalParametersTestLanguageEx.g:861:2: this_ID_0= RULE_ID
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
    // PsiInternalParametersTestLanguageEx.g:872:1: norm1_IdOrKeyword returns [Boolean current=false] : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final Boolean norm1_IdOrKeyword() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalParametersTestLanguageEx.g:873:1: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // PsiInternalParametersTestLanguageEx.g:874:2: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // PsiInternalParametersTestLanguageEx.g:874:2: (kw= 'keyword' | this_ID_1= RULE_ID )
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
                    // PsiInternalParametersTestLanguageEx.g:875:3: kw= 'keyword'
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
                    // PsiInternalParametersTestLanguageEx.g:883:3: this_ID_1= RULE_ID
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

    // $ANTLR start synpred1_PsiInternalParametersTestLanguageEx
    public final void synpred1_PsiInternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // PsiInternalParametersTestLanguageEx.g:225:5: ( ( '#5' ( ( norm1_Scenario2 ) ) ) )
        // PsiInternalParametersTestLanguageEx.g:225:6: ( '#5' ( ( norm1_Scenario2 ) ) )
        {
        // PsiInternalParametersTestLanguageEx.g:225:6: ( '#5' ( ( norm1_Scenario2 ) ) )
        // PsiInternalParametersTestLanguageEx.g:226:6: '#5' ( ( norm1_Scenario2 ) )
        {
        match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // PsiInternalParametersTestLanguageEx.g:227:6: ( ( norm1_Scenario2 ) )
        // PsiInternalParametersTestLanguageEx.g:228:7: ( norm1_Scenario2 )
        {
        // PsiInternalParametersTestLanguageEx.g:228:7: ( norm1_Scenario2 )
        // PsiInternalParametersTestLanguageEx.g:229:8: norm1_Scenario2
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
        // PsiInternalParametersTestLanguageEx.g:261:5: ( ( '#6' ( ( ruleScenario2 ) ) ) )
        // PsiInternalParametersTestLanguageEx.g:261:6: ( '#6' ( ( ruleScenario2 ) ) )
        {
        // PsiInternalParametersTestLanguageEx.g:261:6: ( '#6' ( ( ruleScenario2 ) ) )
        // PsiInternalParametersTestLanguageEx.g:262:6: '#6' ( ( ruleScenario2 ) )
        {
        match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
        // PsiInternalParametersTestLanguageEx.g:263:6: ( ( ruleScenario2 ) )
        // PsiInternalParametersTestLanguageEx.g:264:7: ( ruleScenario2 )
        {
        // PsiInternalParametersTestLanguageEx.g:264:7: ( ruleScenario2 )
        // PsiInternalParametersTestLanguageEx.g:265:8: ruleScenario2
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
        // PsiInternalParametersTestLanguageEx.g:356:7: ( ( norm1_IdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:356:8: ( norm1_IdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:356:8: ( norm1_IdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:357:8: norm1_IdOrKeyword
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
        // PsiInternalParametersTestLanguageEx.g:414:7: ( ( norm1_IdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:414:8: ( norm1_IdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:414:8: ( norm1_IdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:415:8: norm1_IdOrKeyword
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
        // PsiInternalParametersTestLanguageEx.g:472:7: ( ( ruleIdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:472:8: ( ruleIdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:472:8: ( ruleIdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:473:8: ruleIdOrKeyword
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
        // PsiInternalParametersTestLanguageEx.g:530:7: ( ( ruleIdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:530:8: ( ruleIdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:530:8: ( ruleIdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:531:8: ruleIdOrKeyword
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
        // PsiInternalParametersTestLanguageEx.g:693:4: ( ( ruleIdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:693:5: ( ruleIdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:693:5: ( ruleIdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:694:5: ruleIdOrKeyword
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
        // PsiInternalParametersTestLanguageEx.g:738:4: ( ( norm1_IdOrKeyword ) )
        // PsiInternalParametersTestLanguageEx.g:738:5: ( norm1_IdOrKeyword )
        {
        // PsiInternalParametersTestLanguageEx.g:738:5: ( norm1_IdOrKeyword )
        // PsiInternalParametersTestLanguageEx.g:739:5: norm1_IdOrKeyword
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
            return "123:3: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'keyword' )? ) ) ) )";
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