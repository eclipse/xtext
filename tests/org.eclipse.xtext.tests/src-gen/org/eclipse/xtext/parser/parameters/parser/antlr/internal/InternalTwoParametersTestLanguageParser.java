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


        public InternalTwoParametersTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTwoParametersTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTwoParametersTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g"; }



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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:67:1: entryRuleParserRuleParameters returns [EObject current=null] : iv_ruleParserRuleParameters= ruleParserRuleParameters EOF ;
    public final EObject entryRuleParserRuleParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleParameters = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:68:2: (iv_ruleParserRuleParameters= ruleParserRuleParameters EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:69:2: iv_ruleParserRuleParameters= ruleParserRuleParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParserRuleParametersRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParserRuleParameters_in_entryRuleParserRuleParameters75);
            iv_ruleParserRuleParameters=ruleParserRuleParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParserRuleParameters; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRuleParameters85); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:76:1: ruleParserRuleParameters returns [EObject current=null] : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario5[true, true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5[false, false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario6[true, true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario6[false, true] ) ) ) | ( ( ( '#5' ( ( ruleScenario6[true, true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario6[true, true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6[false, false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6[false, false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario7[true, true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario7[false, true] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:79:28: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario5[true, true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5[false, false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario6[true, true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario6[false, true] ) ) ) | ( ( ( '#5' ( ( ruleScenario6[true, true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario6[true, true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6[false, false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6[false, false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario7[true, true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario7[false, true] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:80:1: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario5[true, true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5[false, false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario6[true, true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario6[false, true] ) ) ) | ( ( ( '#5' ( ( ruleScenario6[true, true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario6[true, true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6[false, false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6[false, false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario7[true, true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario7[false, true] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:80:1: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario5[true, true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5[false, false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario6[true, true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario6[false, true] ) ) ) | ( ( ( '#5' ( ( ruleScenario6[true, true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario6[true, true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6[false, false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6[false, false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario7[true, true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario7[false, true] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:80:2: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario5[true, true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5[false, false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario6[true, true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario6[false, true] ) ) ) | ( ( ( '#5' ( ( ruleScenario6[true, true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario6[true, true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6[false, false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6[false, false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario7[true, true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario7[false, true] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:80:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:81:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParserRuleParametersAccess().getParserRuleParametersAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:86:2: ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario5[true, true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5[false, false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario6[true, true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario6[false, true] ) ) ) | ( ( ( '#5' ( ( ruleScenario6[true, true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario6[true, true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6[false, false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6[false, false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario7[true, true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario7[false, true] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:86:3: (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario5[true, true] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:86:3: (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario5[true, true] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:86:5: otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario5[true, true] ) )
                    {
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleParserRuleParameters133); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneKeyword_1_0_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:90:1: ( (lv_scenario_2_0= ruleScenario5[true, true] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:91:1: (lv_scenario_2_0= ruleScenario5[true, true] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:91:1: (lv_scenario_2_0= ruleScenario5[true, true] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:92:3: lv_scenario_2_0= ruleScenario5[true, true]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario5ParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario5_in_ruleParserRuleParameters154);
                    lv_scenario_2_0=ruleScenario5(true, true);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:109:6: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5[false, false] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:109:6: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5[false, false] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:109:8: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5[false, false] ) )
                    {
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleParserRuleParameters175); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitTwoKeyword_1_1_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:113:1: ( (lv_scenario_4_0= ruleScenario5[false, false] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:114:1: (lv_scenario_4_0= ruleScenario5[false, false] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:114:1: (lv_scenario_4_0= ruleScenario5[false, false] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:115:3: lv_scenario_4_0= ruleScenario5[false, false]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario5ParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario5_in_ruleParserRuleParameters196);
                    lv_scenario_4_0=ruleScenario5(false, false);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:132:6: (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario6[true, true] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:132:6: (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario6[true, true] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:132:8: otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario6[true, true] ) )
                    {
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParserRuleParameters217); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitThreeKeyword_1_2_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:136:1: ( (lv_scenario_6_0= ruleScenario6[true, true] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:137:1: (lv_scenario_6_0= ruleScenario6[true, true] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:137:1: (lv_scenario_6_0= ruleScenario6[true, true] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:138:3: lv_scenario_6_0= ruleScenario6[true, true]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario6_in_ruleParserRuleParameters238);
                    lv_scenario_6_0=ruleScenario6(true, true);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:155:6: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario6[false, true] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:155:6: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario6[false, true] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:155:8: otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario6[false, true] ) )
                    {
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParserRuleParameters259); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitFourKeyword_1_3_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:159:1: ( (lv_scenario_8_0= ruleScenario6[false, true] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:160:1: (lv_scenario_8_0= ruleScenario6[false, true] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:160:1: (lv_scenario_8_0= ruleScenario6[false, true] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:161:3: lv_scenario_8_0= ruleScenario6[false, true]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario6_in_ruleParserRuleParameters280);
                    lv_scenario_8_0=ruleScenario6(false, true);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:178:6: ( ( ( '#5' ( ( ruleScenario6[true, true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario6[true, true] ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:178:6: ( ( ( '#5' ( ( ruleScenario6[true, true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario6[true, true] ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:178:7: ( ( '#5' ( ( ruleScenario6[true, true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario6[true, true] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:183:6: (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario6[true, true] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:183:8: otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario6[true, true] ) )
                    {
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParserRuleParameters321); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitFiveKeyword_1_4_0_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:187:1: ( (lv_scenario_10_0= ruleScenario6[true, true] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:188:1: (lv_scenario_10_0= ruleScenario6[true, true] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:188:1: (lv_scenario_10_0= ruleScenario6[true, true] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:189:3: lv_scenario_10_0= ruleScenario6[true, true]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_4_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario6_in_ruleParserRuleParameters342);
                    lv_scenario_10_0=ruleScenario6(true, true);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:206:6: ( ( ( '#6' ( ( ruleScenario6[false, false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6[false, false] ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:206:6: ( ( ( '#6' ( ( ruleScenario6[false, false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6[false, false] ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:206:7: ( ( '#6' ( ( ruleScenario6[false, false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6[false, false] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:211:6: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6[false, false] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:211:8: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6[false, false] ) )
                    {
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParserRuleParameters384); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitSixKeyword_1_5_0_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:215:1: ( (lv_scenario_12_0= ruleScenario6[false, false] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:216:1: (lv_scenario_12_0= ruleScenario6[false, false] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:216:1: (lv_scenario_12_0= ruleScenario6[false, false] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:217:3: lv_scenario_12_0= ruleScenario6[false, false]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_5_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario6_in_ruleParserRuleParameters405);
                    lv_scenario_12_0=ruleScenario6(false, false);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:234:6: (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario7[true, true] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:234:6: (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario7[true, true] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:234:8: otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario7[true, true] ) )
                    {
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleParserRuleParameters427); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitSevenKeyword_1_6_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:238:1: ( (lv_scenario_14_0= ruleScenario7[true, true] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:239:1: (lv_scenario_14_0= ruleScenario7[true, true] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:239:1: (lv_scenario_14_0= ruleScenario7[true, true] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:240:3: lv_scenario_14_0= ruleScenario7[true, true]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario7ParserRuleCall_1_6_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario7_in_ruleParserRuleParameters448);
                    lv_scenario_14_0=ruleScenario7(true, true);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:257:6: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario7[false, true] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:257:6: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario7[false, true] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:257:8: otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario7[false, true] ) )
                    {
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleParserRuleParameters469); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitEightKeyword_1_7_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:261:1: ( (lv_scenario_16_0= ruleScenario7[false, true] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:262:1: (lv_scenario_16_0= ruleScenario7[false, true] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:262:1: (lv_scenario_16_0= ruleScenario7[false, true] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:263:3: lv_scenario_16_0= ruleScenario7[false, true]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario7ParserRuleCall_1_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario7_in_ruleParserRuleParameters490);
                    lv_scenario_16_0=ruleScenario7(false, true);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:280:6: (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:280:6: (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:280:8: otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? ) )
                    {
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleParserRuleParameters511); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitNineKeyword_1_8_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:284:1: ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? ) )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:284:2: ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:284:2: ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:284:3: ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:289:1: (lv_scenario_18_0= ruleScenario8[true, true] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:290:3: lv_scenario_18_0= ruleScenario8[true, true]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario8ParserRuleCall_1_8_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario8_in_ruleParserRuleParameters544);
                            lv_scenario_18_0=ruleScenario8(true, true);

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:307:6: ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:307:6: ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:307:7: ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )?
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:307:7: ( (lv_scenario_19_0= ruleScenario6[true, true] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:308:1: (lv_scenario_19_0= ruleScenario6[true, true] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:308:1: (lv_scenario_19_0= ruleScenario6[true, true] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:309:3: lv_scenario_19_0= ruleScenario6[true, true]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_8_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario6_in_ruleParserRuleParameters573);
                            lv_scenario_19_0=ruleScenario6(true, true);

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

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:325:2: (otherlv_20= 'keyword' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:325:4: otherlv_20= 'keyword'
                                    {
                                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters587); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:330:6: (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:330:6: (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:330:8: otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? ) )
                    {
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParserRuleParameters611); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitZeroKeyword_1_9_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:334:1: ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==20) ) {
                        int LA4_1 = input.LA(2);

                        if ( (LA4_1==20) ) {
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
                        else if ( (LA4_1==EOF) ) {
                            alt4=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 1, input);

                            throw nvae;
                        }
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:334:2: ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:334:2: ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:334:3: ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:339:1: (lv_scenario_22_0= ruleScenario8[true, true] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:340:3: lv_scenario_22_0= ruleScenario8[true, true]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario8ParserRuleCall_1_9_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario8_in_ruleParserRuleParameters644);
                            lv_scenario_22_0=ruleScenario8(true, true);

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:357:6: ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:357:6: ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:357:7: ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )?
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:357:7: ( (lv_scenario_23_0= ruleScenario6[false, false] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:358:1: (lv_scenario_23_0= ruleScenario6[false, false] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:358:1: (lv_scenario_23_0= ruleScenario6[false, false] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:359:3: lv_scenario_23_0= ruleScenario6[false, false]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_9_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario6_in_ruleParserRuleParameters673);
                            lv_scenario_23_0=ruleScenario6(false, false);

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

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:375:2: (otherlv_24= 'keyword' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:375:4: otherlv_24= 'keyword'
                                    {
                                    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters687); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:380:6: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:380:6: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:380:8: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? ) )
                    {
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParserRuleParameters711); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitOneKeyword_1_10_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:384:1: ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==20) ) {
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
                    else if ( (LA6_0==RULE_ID) ) {
                        int LA6_2 = input.LA(2);

                        if ( (LA6_2==20) ) {
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
                        else if ( (LA6_2==EOF) ) {
                            alt6=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:384:2: ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:384:2: ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:384:3: ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:389:1: (lv_scenario_26_0= ruleScenario8[false, false] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:390:3: lv_scenario_26_0= ruleScenario8[false, false]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario8ParserRuleCall_1_10_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario8_in_ruleParserRuleParameters744);
                            lv_scenario_26_0=ruleScenario8(false, false);

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:407:6: ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:407:6: ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:407:7: ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )?
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:407:7: ( (lv_scenario_27_0= ruleScenario6[true, true] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:408:1: (lv_scenario_27_0= ruleScenario6[true, true] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:408:1: (lv_scenario_27_0= ruleScenario6[true, true] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:409:3: lv_scenario_27_0= ruleScenario6[true, true]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_10_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario6_in_ruleParserRuleParameters773);
                            lv_scenario_27_0=ruleScenario6(true, true);

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

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:425:2: (otherlv_28= 'keyword' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:425:4: otherlv_28= 'keyword'
                                    {
                                    otherlv_28=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters787); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:430:6: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:430:6: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:430:8: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? ) )
                    {
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleParserRuleParameters811); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitTwoKeyword_1_11_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:434:1: ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==20) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==20) ) {
                            int LA8_3 = input.LA(3);

                            if ( (synpred6_InternalTwoParametersTestLanguage()) ) {
                                alt8=1;
                            }
                            else if ( (true) ) {
                                alt8=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 8, 3, input);

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
                    else if ( (LA8_0==RULE_ID) ) {
                        int LA8_2 = input.LA(2);

                        if ( (LA8_2==20) ) {
                            int LA8_3 = input.LA(3);

                            if ( (synpred6_InternalTwoParametersTestLanguage()) ) {
                                alt8=1;
                            }
                            else if ( (true) ) {
                                alt8=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 8, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA8_2==EOF) ) {
                            alt8=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 2, input);

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:434:2: ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:434:2: ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:434:3: ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:439:1: (lv_scenario_30_0= ruleScenario8[false, false] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:440:3: lv_scenario_30_0= ruleScenario8[false, false]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario8ParserRuleCall_1_11_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario8_in_ruleParserRuleParameters844);
                            lv_scenario_30_0=ruleScenario8(false, false);

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:457:6: ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:457:6: ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:457:7: ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )?
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:457:7: ( (lv_scenario_31_0= ruleScenario6[false, false] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:458:1: (lv_scenario_31_0= ruleScenario6[false, false] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:458:1: (lv_scenario_31_0= ruleScenario6[false, false] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:459:3: lv_scenario_31_0= ruleScenario6[false, false]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario6ParserRuleCall_1_11_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario6_in_ruleParserRuleParameters873);
                            lv_scenario_31_0=ruleScenario6(false, false);

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

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:475:2: (otherlv_32= 'keyword' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:475:4: otherlv_32= 'keyword'
                                    {
                                    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParserRuleParameters887); if (state.failed) return current;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:487:1: entryRuleScenario5 returns [EObject current=null] : iv_ruleScenario5= ruleScenario5[false, false] EOF ;
    public final EObject entryRuleScenario5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario5 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:488:2: (iv_ruleScenario5= ruleScenario5[false, false] EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:489:2: iv_ruleScenario5= ruleScenario5[false, false] EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario5Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario5_in_entryRuleScenario5929);
            iv_ruleScenario5=ruleScenario5(false, false);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario5; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario5940); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:496:1: ruleScenario5[boolean p_A, boolean p_B] returns [EObject current=null] : ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleScenario5(boolean p_A, boolean p_B) throws RecognitionException {
        EObject current = null;

        Token lv_first_0_0=null;
        Token lv_second_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:499:28: ( ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:500:1: ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:500:1: ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( LA10_0 == RULE_ID && ( ! p_A || ! p_B || p_A && p_B ) ) {
                int LA10_1 = input.LA(2);

                if ( p_A && p_B ) {
                    alt10=1;
                }
                else if ( ! p_A || ! p_B ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:500:2: ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:500:2: ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:500:3: {...}? => ( ( (lv_first_0_0= RULE_ID ) ) )
                    {
                    if ( ! ( p_A && p_B ) ) {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        throw new FailedPredicateException(input, "ruleScenario5", "p_A && p_B");
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:500:18: ( ( (lv_first_0_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:500:19: ( (lv_first_0_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:500:19: ( (lv_first_0_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:501:1: (lv_first_0_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:501:1: (lv_first_0_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:502:3: lv_first_0_0= RULE_ID
                    {
                    lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleScenario5988); if (state.failed) return current;
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


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:520:6: ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:520:6: ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:520:7: {...}? => ( ( (lv_second_1_0= RULE_ID ) ) )
                    {
                    if ( ! ( ! p_A || ! p_B ) ) {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        throw new FailedPredicateException(input, "ruleScenario5", "!p_A || !p_B");
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:520:24: ( ( (lv_second_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:520:25: ( (lv_second_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:520:25: ( (lv_second_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:521:1: (lv_second_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:521:1: (lv_second_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:522:3: lv_second_1_0= RULE_ID
                    {
                    lv_second_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleScenario51023); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_second_1_0, grammarAccess.getScenario5Access().getSecondIDTerminalRuleCall_1_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScenario5Rule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"second",
                              		lv_second_1_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


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
    // $ANTLR end "ruleScenario5"


    // $ANTLR start "entryRuleScenario6"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:547:1: entryRuleScenario6 returns [EObject current=null] : iv_ruleScenario6= ruleScenario6[false, false] EOF ;
    public final EObject entryRuleScenario6() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario6 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:548:2: (iv_ruleScenario6= ruleScenario6[false, false] EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:549:2: iv_ruleScenario6= ruleScenario6[false, false] EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario6Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario6_in_entryRuleScenario61067);
            iv_ruleScenario6=ruleScenario6(false, false);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario6; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario61078); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:556:1: ruleScenario6[boolean p_A, boolean p_B] returns [EObject current=null] : ( (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario6.p_A, $ruleScenario6.p_B, $ruleScenario6.p_A && $ruleScenario6.p_B] ) ) ;
    public final EObject ruleScenario6(boolean p_A, boolean p_B) throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:559:28: ( ( (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario6.p_A, $ruleScenario6.p_B, $ruleScenario6.p_A && $ruleScenario6.p_B] ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:560:1: ( (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario6.p_A, $ruleScenario6.p_B, $ruleScenario6.p_A && $ruleScenario6.p_B] ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:560:1: ( (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario6.p_A, $ruleScenario6.p_B, $ruleScenario6.p_A && $ruleScenario6.p_B] ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:561:1: (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario6.p_A, $ruleScenario6.p_B, $ruleScenario6.p_A && $ruleScenario6.p_B] )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:561:1: (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario6.p_A, $ruleScenario6.p_B, $ruleScenario6.p_A && $ruleScenario6.p_B] )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:562:3: lv_first_0_0= ruleIdOrKeyword2[$ruleScenario6.p_A, $ruleScenario6.p_B, $ruleScenario6.p_A && $ruleScenario6.p_B]
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario6Access().getFirstIdOrKeyword2ParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword2_in_ruleScenario61125);
            lv_first_0_0=ruleIdOrKeyword2(p_A, p_B, p_A && p_B);

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


    // $ANTLR start "entryRuleScenario7"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:586:1: entryRuleScenario7 returns [EObject current=null] : iv_ruleScenario7= ruleScenario7[false, false] EOF ;
    public final EObject entryRuleScenario7() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario7 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:587:2: (iv_ruleScenario7= ruleScenario7[false, false] EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:588:2: iv_ruleScenario7= ruleScenario7[false, false] EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario7Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario7_in_entryRuleScenario71161);
            iv_ruleScenario7=ruleScenario7(false, false);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario7; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario71172); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScenario7"


    // $ANTLR start "ruleScenario7"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:595:1: ruleScenario7[boolean p_A, boolean p_B] returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) )=> (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final EObject ruleScenario7(boolean p_A, boolean p_B) throws RecognitionException {
        EObject current = null;

        Token lv_second_1_0=null;
        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:598:28: ( ( ( ( ( ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) )=> (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:599:1: ( ( ( ( ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) )=> (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:599:1: ( ( ( ( ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) )=> (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred7_InternalTwoParametersTestLanguage(p_A, p_B)) ) {
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
            else if ( (LA11_0==RULE_ID) && (synpred7_InternalTwoParametersTestLanguage(p_A, p_B))) {
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:599:2: ( ( ( ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) )=> (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:599:2: ( ( ( ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) )=> (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:599:3: ( ( ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) )=> (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:604:1: (lv_first_0_0= ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:605:3: lv_first_0_0= ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScenario7Access().getFirstIdOrKeyword2ParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword2_in_ruleScenario71231);
                    lv_first_0_0=ruleIdOrKeyword2(p_A, p_B, p_A && p_B);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:622:6: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:622:6: ( (lv_second_1_0= 'keyword' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:623:1: (lv_second_1_0= 'keyword' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:623:1: (lv_second_1_0= 'keyword' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:624:3: lv_second_1_0= 'keyword'
                    {
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleScenario71256); if (state.failed) return current;
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
    // $ANTLR end "ruleScenario7"


    // $ANTLR start "entryRuleScenario8"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:645:1: entryRuleScenario8 returns [EObject current=null] : iv_ruleScenario8= ruleScenario8[false, false] EOF ;
    public final EObject entryRuleScenario8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario8 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:646:2: (iv_ruleScenario8= ruleScenario8[false, false] EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:647:2: iv_ruleScenario8= ruleScenario8[false, false] EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario8Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario8_in_entryRuleScenario81305);
            iv_ruleScenario8=ruleScenario8(false, false);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario8; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario81316); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:654:1: ruleScenario8[boolean p_A, boolean p_B] returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) )=> (lv_second_0_0= ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) ) otherlv_1= 'keyword' ) ;
    public final EObject ruleScenario8(boolean p_A, boolean p_B) throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_second_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:657:28: ( ( ( ( ( ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) )=> (lv_second_0_0= ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) ) otherlv_1= 'keyword' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:658:1: ( ( ( ( ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) )=> (lv_second_0_0= ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) ) otherlv_1= 'keyword' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:658:1: ( ( ( ( ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) )=> (lv_second_0_0= ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) ) otherlv_1= 'keyword' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:658:2: ( ( ( ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) )=> (lv_second_0_0= ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) ) otherlv_1= 'keyword'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:658:2: ( ( ( ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) )=> (lv_second_0_0= ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:658:3: ( ( ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] ) )=> (lv_second_0_0= ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:663:1: (lv_second_0_0= ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B] )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:664:3: lv_second_0_0= ruleIdOrKeyword2[$ruleScenario8.p_A, $ruleScenario8.p_B, $ruleScenario8.p_A || $ruleScenario8.p_B]
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario8Access().getSecondIdOrKeyword2ParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword2_in_ruleScenario81375);
            lv_second_0_0=ruleIdOrKeyword2(p_A, p_B, p_A || p_B);

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

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleScenario81388); if (state.failed) return current;
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


    // $ANTLR start "entryRuleIdOrKeyword2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:692:1: entryRuleIdOrKeyword2 returns [String current=null] : iv_ruleIdOrKeyword2= ruleIdOrKeyword2[false, false, false] EOF ;
    public final String entryRuleIdOrKeyword2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrKeyword2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:693:2: (iv_ruleIdOrKeyword2= ruleIdOrKeyword2[false, false, false] EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:694:2: iv_ruleIdOrKeyword2= ruleIdOrKeyword2[false, false, false] EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrKeyword2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword2_in_entryRuleIdOrKeyword21425);
            iv_ruleIdOrKeyword2=ruleIdOrKeyword2(false, false, false);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrKeyword2.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdOrKeyword21437); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:701:1: ruleIdOrKeyword2[boolean p_A, boolean p_B, boolean p_C] returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIdOrKeyword2(boolean p_A, boolean p_B, boolean p_C) throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:704:28: ( ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:705:1: ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:705:1: ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( LA12_0 == 20 && ( p_A && p_B || p_C ) ) {
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:705:2: ({...}? => (kw= 'keyword' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:705:2: ({...}? => (kw= 'keyword' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:705:3: {...}? => (kw= 'keyword' )
                    {
                    if ( ! ( p_A && p_B || p_C ) ) {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        throw new FailedPredicateException(input, "ruleIdOrKeyword2", "p_A && p_B || p_C");
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:705:25: (kw= 'keyword' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:706:2: kw= 'keyword'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleIdOrKeyword21481); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrKeyword2Access().getKeywordKeyword_0_0()); 
                          
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:713:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdOrKeyword21505); if (state.failed) return current;
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
    // $ANTLR end "ruleIdOrKeyword2"


    // $ANTLR start "entryRuleIdOrKeyword"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:736:1: entryRuleIdOrKeyword returns [String current=null] : iv_ruleIdOrKeyword= ruleIdOrKeyword[false] EOF ;
    public final String entryRuleIdOrKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrKeyword = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:737:2: (iv_ruleIdOrKeyword= ruleIdOrKeyword[false] EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:738:2: iv_ruleIdOrKeyword= ruleIdOrKeyword[false] EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrKeywordRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_entryRuleIdOrKeyword1559);
            iv_ruleIdOrKeyword=ruleIdOrKeyword(false);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrKeyword.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdOrKeyword1571); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:745:1: ruleIdOrKeyword[boolean p_Keyword] returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIdOrKeyword(boolean p_Keyword) throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:748:28: ( ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:749:1: ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:749:1: ( ({...}? => (kw= 'keyword' ) ) | this_ID_1= RULE_ID )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( LA13_0 == 20 && p_Keyword ) {
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:749:2: ({...}? => (kw= 'keyword' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:749:2: ({...}? => (kw= 'keyword' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:749:3: {...}? => (kw= 'keyword' )
                    {
                    if ( ! p_Keyword ) {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        throw new FailedPredicateException(input, "ruleIdOrKeyword", "p_Keyword");
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:749:17: (kw= 'keyword' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:750:2: kw= 'keyword'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleIdOrKeyword1615); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrKeywordAccess().getKeywordKeyword_0_0()); 
                          
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:757:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdOrKeyword1639); if (state.failed) return current;
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
    // $ANTLR end "ruleIdOrKeyword"

    // $ANTLR start synpred1_InternalTwoParametersTestLanguage
    public final void synpred1_InternalTwoParametersTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:178:7: ( ( '#5' ( ( ruleScenario6[true, true] ) ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:178:8: ( '#5' ( ( ruleScenario6[true, true] ) ) )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:178:8: ( '#5' ( ( ruleScenario6[true, true] ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:178:10: '#5' ( ( ruleScenario6[true, true] ) )
        {
        match(input,15,FollowSets000.FOLLOW_15_in_synpred1_InternalTwoParametersTestLanguage301); if (state.failed) return ;
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:179:1: ( ( ruleScenario6[true, true] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:180:1: ( ruleScenario6[true, true] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:180:1: ( ruleScenario6[true, true] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:181:1: ruleScenario6[true, true]
        {
        pushFollow(FollowSets000.FOLLOW_ruleScenario6_in_synpred1_InternalTwoParametersTestLanguage308);
        ruleScenario6(true, true);

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
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:206:7: ( ( '#6' ( ( ruleScenario6[false, false] ) ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:206:8: ( '#6' ( ( ruleScenario6[false, false] ) ) )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:206:8: ( '#6' ( ( ruleScenario6[false, false] ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:206:10: '#6' ( ( ruleScenario6[false, false] ) )
        {
        match(input,16,FollowSets000.FOLLOW_16_in_synpred2_InternalTwoParametersTestLanguage364); if (state.failed) return ;
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:207:1: ( ( ruleScenario6[false, false] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:208:1: ( ruleScenario6[false, false] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:208:1: ( ruleScenario6[false, false] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:209:1: ruleScenario6[false, false]
        {
        pushFollow(FollowSets000.FOLLOW_ruleScenario6_in_synpred2_InternalTwoParametersTestLanguage371);
        ruleScenario6(false, false);

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
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:284:3: ( ( ruleIdOrKeyword2[true, true, true || true] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:285:1: ( ruleIdOrKeyword2[true, true, true || true] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:285:1: ( ruleIdOrKeyword2[true, true, true || true] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:286:1: ruleIdOrKeyword2[true, true, true || true]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword2_in_synpred3_InternalTwoParametersTestLanguage526);
        ruleIdOrKeyword2(true, true, true || true);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalTwoParametersTestLanguage

    // $ANTLR start synpred4_InternalTwoParametersTestLanguage
    public final void synpred4_InternalTwoParametersTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:334:3: ( ( ruleIdOrKeyword2[true, true, true || true] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:335:1: ( ruleIdOrKeyword2[true, true, true || true] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:335:1: ( ruleIdOrKeyword2[true, true, true || true] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:336:1: ruleIdOrKeyword2[true, true, true || true]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword2_in_synpred4_InternalTwoParametersTestLanguage626);
        ruleIdOrKeyword2(true, true, true || true);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalTwoParametersTestLanguage

    // $ANTLR start synpred5_InternalTwoParametersTestLanguage
    public final void synpred5_InternalTwoParametersTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:384:3: ( ( ruleIdOrKeyword2[false, false, false || false] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:385:1: ( ruleIdOrKeyword2[false, false, false || false] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:385:1: ( ruleIdOrKeyword2[false, false, false || false] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:386:1: ruleIdOrKeyword2[false, false, false || false]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword2_in_synpred5_InternalTwoParametersTestLanguage726);
        ruleIdOrKeyword2(false, false, false || false);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalTwoParametersTestLanguage

    // $ANTLR start synpred6_InternalTwoParametersTestLanguage
    public final void synpred6_InternalTwoParametersTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:434:3: ( ( ruleIdOrKeyword2[false, false, false || false] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:435:1: ( ruleIdOrKeyword2[false, false, false || false] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:435:1: ( ruleIdOrKeyword2[false, false, false || false] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:436:1: ruleIdOrKeyword2[false, false, false || false]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword2_in_synpred6_InternalTwoParametersTestLanguage826);
        ruleIdOrKeyword2(false, false, false || false);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalTwoParametersTestLanguage

    // $ANTLR start synpred7_InternalTwoParametersTestLanguage
    public final void synpred7_InternalTwoParametersTestLanguage_fragment(boolean p_A, boolean p_B) throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:599:3: ( ( ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:600:1: ( ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:600:1: ( ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalTwoParametersTestLanguage.g:601:1: ruleIdOrKeyword2[$ruleScenario7.p_A, $ruleScenario7.p_B, $ruleScenario7.p_A && $ruleScenario7.p_B]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword2_in_synpred7_InternalTwoParametersTestLanguage1213);
        ruleIdOrKeyword2(p_A, p_B, p_A && p_B);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalTwoParametersTestLanguage

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
    public final boolean synpred7_InternalTwoParametersTestLanguage(boolean p_A, boolean p_B) {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalTwoParametersTestLanguage_fragment(p_A, p_B); // can never throw exception
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
            return "86:2: ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario5[true, true] ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario5[false, false] ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario6[true, true] ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario6[false, true] ) ) ) | ( ( ( '#5' ( ( ruleScenario6[true, true] ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario6[true, true] ) ) ) ) | ( ( ( '#6' ( ( ruleScenario6[false, false] ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario6[false, false] ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario7[true, true] ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario7[false, true] ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_18_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_19_0= ruleScenario6[true, true] ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword2[true, true, true || true] ) )=> (lv_scenario_22_0= ruleScenario8[true, true] ) ) | ( ( (lv_scenario_23_0= ruleScenario6[false, false] ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_26_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_27_0= ruleScenario6[true, true] ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword2[false, false, false || false] ) )=> (lv_scenario_30_0= ruleScenario8[false, false] ) ) | ( ( (lv_scenario_31_0= ruleScenario6[false, false] ) ) (otherlv_32= 'keyword' )? ) ) ) )";
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
        public static final BitSet FOLLOW_ruleParserRuleParameters_in_entryRuleParserRuleParameters75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRuleParameters85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleParserRuleParameters133 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleScenario5_in_ruleParserRuleParameters154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleParserRuleParameters175 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleScenario5_in_ruleParserRuleParameters196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleParserRuleParameters217 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario6_in_ruleParserRuleParameters238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleParserRuleParameters259 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario6_in_ruleParserRuleParameters280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParserRuleParameters321 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario6_in_ruleParserRuleParameters342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleParserRuleParameters384 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario6_in_ruleParserRuleParameters405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleParserRuleParameters427 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario7_in_ruleParserRuleParameters448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleParserRuleParameters469 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario7_in_ruleParserRuleParameters490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleParserRuleParameters511 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario8_in_ruleParserRuleParameters544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario6_in_ruleParserRuleParameters573 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleParserRuleParameters611 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario8_in_ruleParserRuleParameters644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario6_in_ruleParserRuleParameters673 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleParserRuleParameters711 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario8_in_ruleParserRuleParameters744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario6_in_ruleParserRuleParameters773 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleParserRuleParameters811 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario8_in_ruleParserRuleParameters844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario6_in_ruleParserRuleParameters873 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleParserRuleParameters887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario5_in_entryRuleScenario5929 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario5940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleScenario5988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleScenario51023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario6_in_entryRuleScenario61067 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario61078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword2_in_ruleScenario61125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario7_in_entryRuleScenario71161 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario71172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword2_in_ruleScenario71231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleScenario71256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario8_in_entryRuleScenario81305 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario81316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword2_in_ruleScenario81375 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleScenario81388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword2_in_entryRuleIdOrKeyword21425 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdOrKeyword21437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleIdOrKeyword21481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdOrKeyword21505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_entryRuleIdOrKeyword1559 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdOrKeyword1571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleIdOrKeyword1615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdOrKeyword1639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_synpred1_InternalTwoParametersTestLanguage301 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario6_in_synpred1_InternalTwoParametersTestLanguage308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_synpred2_InternalTwoParametersTestLanguage364 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleScenario6_in_synpred2_InternalTwoParametersTestLanguage371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword2_in_synpred3_InternalTwoParametersTestLanguage526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword2_in_synpred4_InternalTwoParametersTestLanguage626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword2_in_synpred5_InternalTwoParametersTestLanguage726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword2_in_synpred6_InternalTwoParametersTestLanguage826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword2_in_synpred7_InternalTwoParametersTestLanguage1213 = new BitSet(new long[]{0x0000000000000002L});
    }


}