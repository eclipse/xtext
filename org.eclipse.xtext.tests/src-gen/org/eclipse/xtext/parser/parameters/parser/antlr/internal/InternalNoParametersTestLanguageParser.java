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
import org.eclipse.xtext.parser.parameters.services.NoParametersTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalNoParametersTestLanguageParser extends AbstractInternalAntlrParser {
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


        public InternalNoParametersTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalNoParametersTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalNoParametersTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalNoParametersTestLanguage.g"; }



     	private NoParametersTestLanguageGrammarAccess grammarAccess;
     	
        public InternalNoParametersTestLanguageParser(TokenStream input, NoParametersTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ParserRuleParameters";	
       	}
       	
       	@Override
       	protected NoParametersTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleParserRuleParameters"
    // InternalNoParametersTestLanguage.g:67:1: entryRuleParserRuleParameters returns [EObject current=null] : iv_ruleParserRuleParameters= ruleParserRuleParameters EOF ;
    public final EObject entryRuleParserRuleParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleParameters = null;


        try {
            // InternalNoParametersTestLanguage.g:68:2: (iv_ruleParserRuleParameters= ruleParserRuleParameters EOF )
            // InternalNoParametersTestLanguage.g:69:2: iv_ruleParserRuleParameters= ruleParserRuleParameters EOF
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
    // InternalNoParametersTestLanguage.g:76:1: ruleParserRuleParameters returns [EObject current=null] : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) ;
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
            // InternalNoParametersTestLanguage.g:79:28: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) ) ) )
            // InternalNoParametersTestLanguage.g:80:1: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            {
            // InternalNoParametersTestLanguage.g:80:1: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) ) )
            // InternalNoParametersTestLanguage.g:80:2: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) )
            {
            // InternalNoParametersTestLanguage.g:80:2: ()
            // InternalNoParametersTestLanguage.g:81:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParserRuleParametersAccess().getParserRuleParametersAction_0(),
                          current);
                  
            }

            }

            // InternalNoParametersTestLanguage.g:86:2: ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalNoParametersTestLanguage.g:86:3: (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:86:3: (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) )
                    // InternalNoParametersTestLanguage.g:86:5: otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) )
                    {
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneKeyword_1_0_0());
                          
                    }
                    // InternalNoParametersTestLanguage.g:90:1: ( (lv_scenario_2_0= ruleScenario1_True ) )
                    // InternalNoParametersTestLanguage.g:91:1: (lv_scenario_2_0= ruleScenario1_True )
                    {
                    // InternalNoParametersTestLanguage.g:91:1: (lv_scenario_2_0= ruleScenario1_True )
                    // InternalNoParametersTestLanguage.g:92:3: lv_scenario_2_0= ruleScenario1_True
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario1_TrueParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_2_0=ruleScenario1_True();

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
                              		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario1_True");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNoParametersTestLanguage.g:109:6: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:109:6: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) )
                    // InternalNoParametersTestLanguage.g:109:8: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) )
                    {
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitTwoKeyword_1_1_0());
                          
                    }
                    // InternalNoParametersTestLanguage.g:113:1: ( (lv_scenario_4_0= ruleScenario1_False ) )
                    // InternalNoParametersTestLanguage.g:114:1: (lv_scenario_4_0= ruleScenario1_False )
                    {
                    // InternalNoParametersTestLanguage.g:114:1: (lv_scenario_4_0= ruleScenario1_False )
                    // InternalNoParametersTestLanguage.g:115:3: lv_scenario_4_0= ruleScenario1_False
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario1_FalseParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_4_0=ruleScenario1_False();

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
                              		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario1_False");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalNoParametersTestLanguage.g:132:6: (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:132:6: (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) )
                    // InternalNoParametersTestLanguage.g:132:8: otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) )
                    {
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitThreeKeyword_1_2_0());
                          
                    }
                    // InternalNoParametersTestLanguage.g:136:1: ( (lv_scenario_6_0= ruleScenario2_True ) )
                    // InternalNoParametersTestLanguage.g:137:1: (lv_scenario_6_0= ruleScenario2_True )
                    {
                    // InternalNoParametersTestLanguage.g:137:1: (lv_scenario_6_0= ruleScenario2_True )
                    // InternalNoParametersTestLanguage.g:138:3: lv_scenario_6_0= ruleScenario2_True
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2_TrueParserRuleCall_1_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_6_0=ruleScenario2_True();

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
                              		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario2_True");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalNoParametersTestLanguage.g:155:6: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:155:6: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) )
                    // InternalNoParametersTestLanguage.g:155:8: otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) )
                    {
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitFourKeyword_1_3_0());
                          
                    }
                    // InternalNoParametersTestLanguage.g:159:1: ( (lv_scenario_8_0= ruleScenario2_False ) )
                    // InternalNoParametersTestLanguage.g:160:1: (lv_scenario_8_0= ruleScenario2_False )
                    {
                    // InternalNoParametersTestLanguage.g:160:1: (lv_scenario_8_0= ruleScenario2_False )
                    // InternalNoParametersTestLanguage.g:161:3: lv_scenario_8_0= ruleScenario2_False
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2_FalseParserRuleCall_1_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_8_0=ruleScenario2_False();

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
                              		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario2_False");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalNoParametersTestLanguage.g:178:6: ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:178:6: ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) )
                    // InternalNoParametersTestLanguage.g:178:7: ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:183:6: (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) )
                    // InternalNoParametersTestLanguage.g:183:8: otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) )
                    {
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitFiveKeyword_1_4_0_0());
                          
                    }
                    // InternalNoParametersTestLanguage.g:187:1: ( (lv_scenario_10_0= ruleScenario2_True ) )
                    // InternalNoParametersTestLanguage.g:188:1: (lv_scenario_10_0= ruleScenario2_True )
                    {
                    // InternalNoParametersTestLanguage.g:188:1: (lv_scenario_10_0= ruleScenario2_True )
                    // InternalNoParametersTestLanguage.g:189:3: lv_scenario_10_0= ruleScenario2_True
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2_TrueParserRuleCall_1_4_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_10_0=ruleScenario2_True();

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
                              		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario2_True");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalNoParametersTestLanguage.g:206:6: ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:206:6: ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) )
                    // InternalNoParametersTestLanguage.g:206:7: ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:211:6: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) )
                    // InternalNoParametersTestLanguage.g:211:8: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) )
                    {
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitSixKeyword_1_5_0_0());
                          
                    }
                    // InternalNoParametersTestLanguage.g:215:1: ( (lv_scenario_12_0= ruleScenario2_False ) )
                    // InternalNoParametersTestLanguage.g:216:1: (lv_scenario_12_0= ruleScenario2_False )
                    {
                    // InternalNoParametersTestLanguage.g:216:1: (lv_scenario_12_0= ruleScenario2_False )
                    // InternalNoParametersTestLanguage.g:217:3: lv_scenario_12_0= ruleScenario2_False
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2_FalseParserRuleCall_1_5_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_12_0=ruleScenario2_False();

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
                              		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario2_False");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalNoParametersTestLanguage.g:234:6: (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:234:6: (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) )
                    // InternalNoParametersTestLanguage.g:234:8: otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) )
                    {
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitSevenKeyword_1_6_0());
                          
                    }
                    // InternalNoParametersTestLanguage.g:238:1: ( (lv_scenario_14_0= ruleScenario3_True ) )
                    // InternalNoParametersTestLanguage.g:239:1: (lv_scenario_14_0= ruleScenario3_True )
                    {
                    // InternalNoParametersTestLanguage.g:239:1: (lv_scenario_14_0= ruleScenario3_True )
                    // InternalNoParametersTestLanguage.g:240:3: lv_scenario_14_0= ruleScenario3_True
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario3_TrueParserRuleCall_1_6_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_14_0=ruleScenario3_True();

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
                              		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario3_True");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalNoParametersTestLanguage.g:257:6: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:257:6: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) )
                    // InternalNoParametersTestLanguage.g:257:8: otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) )
                    {
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitEightKeyword_1_7_0());
                          
                    }
                    // InternalNoParametersTestLanguage.g:261:1: ( (lv_scenario_16_0= ruleScenario3_False ) )
                    // InternalNoParametersTestLanguage.g:262:1: (lv_scenario_16_0= ruleScenario3_False )
                    {
                    // InternalNoParametersTestLanguage.g:262:1: (lv_scenario_16_0= ruleScenario3_False )
                    // InternalNoParametersTestLanguage.g:263:3: lv_scenario_16_0= ruleScenario3_False
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario3_FalseParserRuleCall_1_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_16_0=ruleScenario3_False();

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
                              		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario3_False");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalNoParametersTestLanguage.g:280:6: (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:280:6: (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) )
                    // InternalNoParametersTestLanguage.g:280:8: otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) )
                    {
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitNineKeyword_1_8_0());
                          
                    }
                    // InternalNoParametersTestLanguage.g:284:1: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==20) ) {
                        int LA2_1 = input.LA(2);

                        if ( (LA2_1==20) ) {
                            int LA2_3 = input.LA(3);

                            if ( (synpred3_InternalNoParametersTestLanguage()) ) {
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

                            if ( (synpred3_InternalNoParametersTestLanguage()) ) {
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
                            // InternalNoParametersTestLanguage.g:284:2: ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) )
                            {
                            // InternalNoParametersTestLanguage.g:284:2: ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) )
                            // InternalNoParametersTestLanguage.g:284:3: ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True )
                            {
                            // InternalNoParametersTestLanguage.g:289:1: (lv_scenario_18_0= ruleScenario4_True )
                            // InternalNoParametersTestLanguage.g:290:3: lv_scenario_18_0= ruleScenario4_True
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4_TrueParserRuleCall_1_8_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_18_0=ruleScenario4_True();

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
                                      		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario4_True");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalNoParametersTestLanguage.g:307:6: ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? )
                            {
                            // InternalNoParametersTestLanguage.g:307:6: ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? )
                            // InternalNoParametersTestLanguage.g:307:7: ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )?
                            {
                            // InternalNoParametersTestLanguage.g:307:7: ( (lv_scenario_19_0= ruleScenario2_True ) )
                            // InternalNoParametersTestLanguage.g:308:1: (lv_scenario_19_0= ruleScenario2_True )
                            {
                            // InternalNoParametersTestLanguage.g:308:1: (lv_scenario_19_0= ruleScenario2_True )
                            // InternalNoParametersTestLanguage.g:309:3: lv_scenario_19_0= ruleScenario2_True
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2_TrueParserRuleCall_1_8_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_19_0=ruleScenario2_True();

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
                                      		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario2_True");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalNoParametersTestLanguage.g:325:2: (otherlv_20= 'keyword' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // InternalNoParametersTestLanguage.g:325:4: otherlv_20= 'keyword'
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
                    // InternalNoParametersTestLanguage.g:330:6: (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:330:6: (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) )
                    // InternalNoParametersTestLanguage.g:330:8: otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) )
                    {
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitZeroKeyword_1_9_0());
                          
                    }
                    // InternalNoParametersTestLanguage.g:334:1: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==20) && (synpred4_InternalNoParametersTestLanguage())) {
                        alt4=1;
                    }
                    else if ( (LA4_0==RULE_ID) ) {
                        int LA4_2 = input.LA(2);

                        if ( (LA4_2==20) ) {
                            int LA4_3 = input.LA(3);

                            if ( (synpred4_InternalNoParametersTestLanguage()) ) {
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
                            // InternalNoParametersTestLanguage.g:334:2: ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) )
                            {
                            // InternalNoParametersTestLanguage.g:334:2: ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) )
                            // InternalNoParametersTestLanguage.g:334:3: ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True )
                            {
                            // InternalNoParametersTestLanguage.g:339:1: (lv_scenario_22_0= ruleScenario4_True )
                            // InternalNoParametersTestLanguage.g:340:3: lv_scenario_22_0= ruleScenario4_True
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4_TrueParserRuleCall_1_9_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_22_0=ruleScenario4_True();

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
                                      		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario4_True");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalNoParametersTestLanguage.g:357:6: ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? )
                            {
                            // InternalNoParametersTestLanguage.g:357:6: ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? )
                            // InternalNoParametersTestLanguage.g:357:7: ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )?
                            {
                            // InternalNoParametersTestLanguage.g:357:7: ( (lv_scenario_23_0= ruleScenario2_False ) )
                            // InternalNoParametersTestLanguage.g:358:1: (lv_scenario_23_0= ruleScenario2_False )
                            {
                            // InternalNoParametersTestLanguage.g:358:1: (lv_scenario_23_0= ruleScenario2_False )
                            // InternalNoParametersTestLanguage.g:359:3: lv_scenario_23_0= ruleScenario2_False
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2_FalseParserRuleCall_1_9_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_23_0=ruleScenario2_False();

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
                                      		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario2_False");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalNoParametersTestLanguage.g:375:2: (otherlv_24= 'keyword' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // InternalNoParametersTestLanguage.g:375:4: otherlv_24= 'keyword'
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
                    // InternalNoParametersTestLanguage.g:380:6: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:380:6: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) )
                    // InternalNoParametersTestLanguage.g:380:8: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) )
                    {
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitOneKeyword_1_10_0());
                          
                    }
                    // InternalNoParametersTestLanguage.g:384:1: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==20) ) {
                            int LA6_3 = input.LA(3);

                            if ( (synpred5_InternalNoParametersTestLanguage()) ) {
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
                            // InternalNoParametersTestLanguage.g:384:2: ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) )
                            {
                            // InternalNoParametersTestLanguage.g:384:2: ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) )
                            // InternalNoParametersTestLanguage.g:384:3: ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False )
                            {
                            // InternalNoParametersTestLanguage.g:389:1: (lv_scenario_26_0= ruleScenario4_False )
                            // InternalNoParametersTestLanguage.g:390:3: lv_scenario_26_0= ruleScenario4_False
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4_FalseParserRuleCall_1_10_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_26_0=ruleScenario4_False();

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
                                      		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario4_False");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalNoParametersTestLanguage.g:407:6: ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? )
                            {
                            // InternalNoParametersTestLanguage.g:407:6: ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? )
                            // InternalNoParametersTestLanguage.g:407:7: ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )?
                            {
                            // InternalNoParametersTestLanguage.g:407:7: ( (lv_scenario_27_0= ruleScenario2_True ) )
                            // InternalNoParametersTestLanguage.g:408:1: (lv_scenario_27_0= ruleScenario2_True )
                            {
                            // InternalNoParametersTestLanguage.g:408:1: (lv_scenario_27_0= ruleScenario2_True )
                            // InternalNoParametersTestLanguage.g:409:3: lv_scenario_27_0= ruleScenario2_True
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2_TrueParserRuleCall_1_10_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_27_0=ruleScenario2_True();

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
                                      		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario2_True");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalNoParametersTestLanguage.g:425:2: (otherlv_28= 'keyword' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // InternalNoParametersTestLanguage.g:425:4: otherlv_28= 'keyword'
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
                    // InternalNoParametersTestLanguage.g:430:6: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) )
                    {
                    // InternalNoParametersTestLanguage.g:430:6: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) )
                    // InternalNoParametersTestLanguage.g:430:8: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) )
                    {
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitTwoKeyword_1_11_0());
                          
                    }
                    // InternalNoParametersTestLanguage.g:434:1: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==20) ) {
                            int LA8_2 = input.LA(3);

                            if ( (synpred6_InternalNoParametersTestLanguage()) ) {
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
                            // InternalNoParametersTestLanguage.g:434:2: ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) )
                            {
                            // InternalNoParametersTestLanguage.g:434:2: ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) )
                            // InternalNoParametersTestLanguage.g:434:3: ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False )
                            {
                            // InternalNoParametersTestLanguage.g:439:1: (lv_scenario_30_0= ruleScenario4_False )
                            // InternalNoParametersTestLanguage.g:440:3: lv_scenario_30_0= ruleScenario4_False
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4_FalseParserRuleCall_1_11_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_30_0=ruleScenario4_False();

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
                                      		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario4_False");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalNoParametersTestLanguage.g:457:6: ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? )
                            {
                            // InternalNoParametersTestLanguage.g:457:6: ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? )
                            // InternalNoParametersTestLanguage.g:457:7: ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )?
                            {
                            // InternalNoParametersTestLanguage.g:457:7: ( (lv_scenario_31_0= ruleScenario2_False ) )
                            // InternalNoParametersTestLanguage.g:458:1: (lv_scenario_31_0= ruleScenario2_False )
                            {
                            // InternalNoParametersTestLanguage.g:458:1: (lv_scenario_31_0= ruleScenario2_False )
                            // InternalNoParametersTestLanguage.g:459:3: lv_scenario_31_0= ruleScenario2_False
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2_FalseParserRuleCall_1_11_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_31_0=ruleScenario2_False();

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
                                      		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.Scenario2_False");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalNoParametersTestLanguage.g:475:2: (otherlv_32= 'keyword' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // InternalNoParametersTestLanguage.g:475:4: otherlv_32= 'keyword'
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


    // $ANTLR start "entryRuleScenario1_True"
    // InternalNoParametersTestLanguage.g:487:1: entryRuleScenario1_True returns [EObject current=null] : iv_ruleScenario1_True= ruleScenario1_True EOF ;
    public final EObject entryRuleScenario1_True() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario1_True = null;


        try {
            // InternalNoParametersTestLanguage.g:488:2: (iv_ruleScenario1_True= ruleScenario1_True EOF )
            // InternalNoParametersTestLanguage.g:489:2: iv_ruleScenario1_True= ruleScenario1_True EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario1_TrueRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario1_True"


    // $ANTLR start "ruleScenario1_True"
    // InternalNoParametersTestLanguage.g:496:1: ruleScenario1_True returns [EObject current=null] : ( (lv_first_0_0= RULE_ID ) ) ;
    public final EObject ruleScenario1_True() throws RecognitionException {
        EObject current = null;

        Token lv_first_0_0=null;

         enterRule(); 
            
        try {
            // InternalNoParametersTestLanguage.g:499:28: ( ( (lv_first_0_0= RULE_ID ) ) )
            // InternalNoParametersTestLanguage.g:500:1: ( (lv_first_0_0= RULE_ID ) )
            {
            // InternalNoParametersTestLanguage.g:500:1: ( (lv_first_0_0= RULE_ID ) )
            // InternalNoParametersTestLanguage.g:501:1: (lv_first_0_0= RULE_ID )
            {
            // InternalNoParametersTestLanguage.g:501:1: (lv_first_0_0= RULE_ID )
            // InternalNoParametersTestLanguage.g:502:3: lv_first_0_0= RULE_ID
            {
            lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_first_0_0, grammarAccess.getScenario1_TrueAccess().getFirstIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScenario1_TrueRule());
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
    // $ANTLR end "ruleScenario1_True"


    // $ANTLR start "entryRuleScenario1_False"
    // InternalNoParametersTestLanguage.g:526:1: entryRuleScenario1_False returns [EObject current=null] : iv_ruleScenario1_False= ruleScenario1_False EOF ;
    public final EObject entryRuleScenario1_False() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario1_False = null;


        try {
            // InternalNoParametersTestLanguage.g:527:2: (iv_ruleScenario1_False= ruleScenario1_False EOF )
            // InternalNoParametersTestLanguage.g:528:2: iv_ruleScenario1_False= ruleScenario1_False EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario1_FalseRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario1_False"


    // $ANTLR start "ruleScenario1_False"
    // InternalNoParametersTestLanguage.g:535:1: ruleScenario1_False returns [EObject current=null] : ( (lv_second_0_0= RULE_ID ) ) ;
    public final EObject ruleScenario1_False() throws RecognitionException {
        EObject current = null;

        Token lv_second_0_0=null;

         enterRule(); 
            
        try {
            // InternalNoParametersTestLanguage.g:538:28: ( ( (lv_second_0_0= RULE_ID ) ) )
            // InternalNoParametersTestLanguage.g:539:1: ( (lv_second_0_0= RULE_ID ) )
            {
            // InternalNoParametersTestLanguage.g:539:1: ( (lv_second_0_0= RULE_ID ) )
            // InternalNoParametersTestLanguage.g:540:1: (lv_second_0_0= RULE_ID )
            {
            // InternalNoParametersTestLanguage.g:540:1: (lv_second_0_0= RULE_ID )
            // InternalNoParametersTestLanguage.g:541:3: lv_second_0_0= RULE_ID
            {
            lv_second_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_second_0_0, grammarAccess.getScenario1_FalseAccess().getSecondIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScenario1_FalseRule());
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
    // $ANTLR end "ruleScenario1_False"


    // $ANTLR start "entryRuleScenario2_True"
    // InternalNoParametersTestLanguage.g:565:1: entryRuleScenario2_True returns [EObject current=null] : iv_ruleScenario2_True= ruleScenario2_True EOF ;
    public final EObject entryRuleScenario2_True() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2_True = null;


        try {
            // InternalNoParametersTestLanguage.g:566:2: (iv_ruleScenario2_True= ruleScenario2_True EOF )
            // InternalNoParametersTestLanguage.g:567:2: iv_ruleScenario2_True= ruleScenario2_True EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario2_TrueRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario2_True"


    // $ANTLR start "ruleScenario2_True"
    // InternalNoParametersTestLanguage.g:574:1: ruleScenario2_True returns [EObject current=null] : ( (lv_first_0_0= ruleIdOrKeyword_True ) ) ;
    public final EObject ruleScenario2_True() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // InternalNoParametersTestLanguage.g:577:28: ( ( (lv_first_0_0= ruleIdOrKeyword_True ) ) )
            // InternalNoParametersTestLanguage.g:578:1: ( (lv_first_0_0= ruleIdOrKeyword_True ) )
            {
            // InternalNoParametersTestLanguage.g:578:1: ( (lv_first_0_0= ruleIdOrKeyword_True ) )
            // InternalNoParametersTestLanguage.g:579:1: (lv_first_0_0= ruleIdOrKeyword_True )
            {
            // InternalNoParametersTestLanguage.g:579:1: (lv_first_0_0= ruleIdOrKeyword_True )
            // InternalNoParametersTestLanguage.g:580:3: lv_first_0_0= ruleIdOrKeyword_True
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario2_TrueAccess().getFirstIdOrKeyword_TrueParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=ruleIdOrKeyword_True();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScenario2_TrueRule());
              	        }
                     		set(
                     			current, 
                     			"first",
                      		lv_first_0_0, 
                      		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.IdOrKeyword_True");
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
    // $ANTLR end "ruleScenario2_True"


    // $ANTLR start "entryRuleScenario2_False"
    // InternalNoParametersTestLanguage.g:604:1: entryRuleScenario2_False returns [EObject current=null] : iv_ruleScenario2_False= ruleScenario2_False EOF ;
    public final EObject entryRuleScenario2_False() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2_False = null;


        try {
            // InternalNoParametersTestLanguage.g:605:2: (iv_ruleScenario2_False= ruleScenario2_False EOF )
            // InternalNoParametersTestLanguage.g:606:2: iv_ruleScenario2_False= ruleScenario2_False EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario2_FalseRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario2_False"


    // $ANTLR start "ruleScenario2_False"
    // InternalNoParametersTestLanguage.g:613:1: ruleScenario2_False returns [EObject current=null] : ( (lv_first_0_0= ruleIdOrKeyword_False ) ) ;
    public final EObject ruleScenario2_False() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // InternalNoParametersTestLanguage.g:616:28: ( ( (lv_first_0_0= ruleIdOrKeyword_False ) ) )
            // InternalNoParametersTestLanguage.g:617:1: ( (lv_first_0_0= ruleIdOrKeyword_False ) )
            {
            // InternalNoParametersTestLanguage.g:617:1: ( (lv_first_0_0= ruleIdOrKeyword_False ) )
            // InternalNoParametersTestLanguage.g:618:1: (lv_first_0_0= ruleIdOrKeyword_False )
            {
            // InternalNoParametersTestLanguage.g:618:1: (lv_first_0_0= ruleIdOrKeyword_False )
            // InternalNoParametersTestLanguage.g:619:3: lv_first_0_0= ruleIdOrKeyword_False
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario2_FalseAccess().getFirstIdOrKeyword_FalseParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=ruleIdOrKeyword_False();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScenario2_FalseRule());
              	        }
                     		set(
                     			current, 
                     			"first",
                      		lv_first_0_0, 
                      		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.IdOrKeyword_False");
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
    // $ANTLR end "ruleScenario2_False"


    // $ANTLR start "entryRuleScenario3_True"
    // InternalNoParametersTestLanguage.g:643:1: entryRuleScenario3_True returns [EObject current=null] : iv_ruleScenario3_True= ruleScenario3_True EOF ;
    public final EObject entryRuleScenario3_True() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario3_True = null;


        try {
            // InternalNoParametersTestLanguage.g:644:2: (iv_ruleScenario3_True= ruleScenario3_True EOF )
            // InternalNoParametersTestLanguage.g:645:2: iv_ruleScenario3_True= ruleScenario3_True EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario3_TrueRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario3_True"


    // $ANTLR start "ruleScenario3_True"
    // InternalNoParametersTestLanguage.g:652:1: ruleScenario3_True returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final EObject ruleScenario3_True() throws RecognitionException {
        EObject current = null;

        Token lv_second_1_0=null;
        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // InternalNoParametersTestLanguage.g:655:28: ( ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // InternalNoParametersTestLanguage.g:656:1: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // InternalNoParametersTestLanguage.g:656:1: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                int LA10_1 = input.LA(2);

                if ( (synpred7_InternalNoParametersTestLanguage()) ) {
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
            else if ( (LA10_0==RULE_ID) && (synpred7_InternalNoParametersTestLanguage())) {
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
                    // InternalNoParametersTestLanguage.g:656:2: ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) )
                    {
                    // InternalNoParametersTestLanguage.g:656:2: ( ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True ) )
                    // InternalNoParametersTestLanguage.g:656:3: ( ( ruleIdOrKeyword_True ) )=> (lv_first_0_0= ruleIdOrKeyword_True )
                    {
                    // InternalNoParametersTestLanguage.g:661:1: (lv_first_0_0= ruleIdOrKeyword_True )
                    // InternalNoParametersTestLanguage.g:662:3: lv_first_0_0= ruleIdOrKeyword_True
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScenario3_TrueAccess().getFirstIdOrKeyword_TrueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_0_0=ruleIdOrKeyword_True();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScenario3_TrueRule());
                      	        }
                             		set(
                             			current, 
                             			"first",
                              		lv_first_0_0, 
                              		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.IdOrKeyword_True");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNoParametersTestLanguage.g:679:6: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // InternalNoParametersTestLanguage.g:679:6: ( (lv_second_1_0= 'keyword' ) )
                    // InternalNoParametersTestLanguage.g:680:1: (lv_second_1_0= 'keyword' )
                    {
                    // InternalNoParametersTestLanguage.g:680:1: (lv_second_1_0= 'keyword' )
                    // InternalNoParametersTestLanguage.g:681:3: lv_second_1_0= 'keyword'
                    {
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_second_1_0, grammarAccess.getScenario3_TrueAccess().getSecondKeywordKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScenario3_TrueRule());
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
    // $ANTLR end "ruleScenario3_True"


    // $ANTLR start "entryRuleScenario3_False"
    // InternalNoParametersTestLanguage.g:702:1: entryRuleScenario3_False returns [EObject current=null] : iv_ruleScenario3_False= ruleScenario3_False EOF ;
    public final EObject entryRuleScenario3_False() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario3_False = null;


        try {
            // InternalNoParametersTestLanguage.g:703:2: (iv_ruleScenario3_False= ruleScenario3_False EOF )
            // InternalNoParametersTestLanguage.g:704:2: iv_ruleScenario3_False= ruleScenario3_False EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario3_FalseRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario3_False"


    // $ANTLR start "ruleScenario3_False"
    // InternalNoParametersTestLanguage.g:711:1: ruleScenario3_False returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) ) | ( (lv_second_1_0= 'keyword' ) ) ) ;
    public final EObject ruleScenario3_False() throws RecognitionException {
        EObject current = null;

        Token lv_second_1_0=null;
        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // InternalNoParametersTestLanguage.g:714:28: ( ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) ) | ( (lv_second_1_0= 'keyword' ) ) ) )
            // InternalNoParametersTestLanguage.g:715:1: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            {
            // InternalNoParametersTestLanguage.g:715:1: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) ) | ( (lv_second_1_0= 'keyword' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) && (synpred8_InternalNoParametersTestLanguage())) {
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
                    // InternalNoParametersTestLanguage.g:715:2: ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) )
                    {
                    // InternalNoParametersTestLanguage.g:715:2: ( ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False ) )
                    // InternalNoParametersTestLanguage.g:715:3: ( ( ruleIdOrKeyword_False ) )=> (lv_first_0_0= ruleIdOrKeyword_False )
                    {
                    // InternalNoParametersTestLanguage.g:720:1: (lv_first_0_0= ruleIdOrKeyword_False )
                    // InternalNoParametersTestLanguage.g:721:3: lv_first_0_0= ruleIdOrKeyword_False
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScenario3_FalseAccess().getFirstIdOrKeyword_FalseParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_0_0=ruleIdOrKeyword_False();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScenario3_FalseRule());
                      	        }
                             		set(
                             			current, 
                             			"first",
                              		lv_first_0_0, 
                              		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.IdOrKeyword_False");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNoParametersTestLanguage.g:738:6: ( (lv_second_1_0= 'keyword' ) )
                    {
                    // InternalNoParametersTestLanguage.g:738:6: ( (lv_second_1_0= 'keyword' ) )
                    // InternalNoParametersTestLanguage.g:739:1: (lv_second_1_0= 'keyword' )
                    {
                    // InternalNoParametersTestLanguage.g:739:1: (lv_second_1_0= 'keyword' )
                    // InternalNoParametersTestLanguage.g:740:3: lv_second_1_0= 'keyword'
                    {
                    lv_second_1_0=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_second_1_0, grammarAccess.getScenario3_FalseAccess().getSecondKeywordKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScenario3_FalseRule());
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
    // $ANTLR end "ruleScenario3_False"


    // $ANTLR start "entryRuleScenario4_True"
    // InternalNoParametersTestLanguage.g:761:1: entryRuleScenario4_True returns [EObject current=null] : iv_ruleScenario4_True= ruleScenario4_True EOF ;
    public final EObject entryRuleScenario4_True() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario4_True = null;


        try {
            // InternalNoParametersTestLanguage.g:762:2: (iv_ruleScenario4_True= ruleScenario4_True EOF )
            // InternalNoParametersTestLanguage.g:763:2: iv_ruleScenario4_True= ruleScenario4_True EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario4_TrueRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario4_True"


    // $ANTLR start "ruleScenario4_True"
    // InternalNoParametersTestLanguage.g:770:1: ruleScenario4_True returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword' ) ;
    public final EObject ruleScenario4_True() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_second_0_0 = null;


         enterRule(); 
            
        try {
            // InternalNoParametersTestLanguage.g:773:28: ( ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword' ) )
            // InternalNoParametersTestLanguage.g:774:1: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword' )
            {
            // InternalNoParametersTestLanguage.g:774:1: ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword' )
            // InternalNoParametersTestLanguage.g:774:2: ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) ) otherlv_1= 'keyword'
            {
            // InternalNoParametersTestLanguage.g:774:2: ( ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True ) )
            // InternalNoParametersTestLanguage.g:774:3: ( ( ruleIdOrKeyword_True ) )=> (lv_second_0_0= ruleIdOrKeyword_True )
            {
            // InternalNoParametersTestLanguage.g:779:1: (lv_second_0_0= ruleIdOrKeyword_True )
            // InternalNoParametersTestLanguage.g:780:3: lv_second_0_0= ruleIdOrKeyword_True
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario4_TrueAccess().getSecondIdOrKeyword_TrueParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_second_0_0=ruleIdOrKeyword_True();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScenario4_TrueRule());
              	        }
                     		set(
                     			current, 
                     			"second",
                      		lv_second_0_0, 
                      		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.IdOrKeyword_True");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScenario4_TrueAccess().getKeywordKeyword_1());
                  
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
    // $ANTLR end "ruleScenario4_True"


    // $ANTLR start "entryRuleScenario4_False"
    // InternalNoParametersTestLanguage.g:808:1: entryRuleScenario4_False returns [EObject current=null] : iv_ruleScenario4_False= ruleScenario4_False EOF ;
    public final EObject entryRuleScenario4_False() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario4_False = null;


        try {
            // InternalNoParametersTestLanguage.g:809:2: (iv_ruleScenario4_False= ruleScenario4_False EOF )
            // InternalNoParametersTestLanguage.g:810:2: iv_ruleScenario4_False= ruleScenario4_False EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario4_FalseRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario4_False"


    // $ANTLR start "ruleScenario4_False"
    // InternalNoParametersTestLanguage.g:817:1: ruleScenario4_False returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword' ) ;
    public final EObject ruleScenario4_False() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_second_0_0 = null;


         enterRule(); 
            
        try {
            // InternalNoParametersTestLanguage.g:820:28: ( ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword' ) )
            // InternalNoParametersTestLanguage.g:821:1: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword' )
            {
            // InternalNoParametersTestLanguage.g:821:1: ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword' )
            // InternalNoParametersTestLanguage.g:821:2: ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) ) otherlv_1= 'keyword'
            {
            // InternalNoParametersTestLanguage.g:821:2: ( ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False ) )
            // InternalNoParametersTestLanguage.g:821:3: ( ( ruleIdOrKeyword_False ) )=> (lv_second_0_0= ruleIdOrKeyword_False )
            {
            // InternalNoParametersTestLanguage.g:826:1: (lv_second_0_0= ruleIdOrKeyword_False )
            // InternalNoParametersTestLanguage.g:827:3: lv_second_0_0= ruleIdOrKeyword_False
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario4_FalseAccess().getSecondIdOrKeyword_FalseParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_second_0_0=ruleIdOrKeyword_False();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScenario4_FalseRule());
              	        }
                     		set(
                     			current, 
                     			"second",
                      		lv_second_0_0, 
                      		"org.eclipse.xtext.parser.parameters.NoParametersTestLanguage.IdOrKeyword_False");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScenario4_FalseAccess().getKeywordKeyword_1());
                  
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
    // $ANTLR end "ruleScenario4_False"


    // $ANTLR start "entryRuleIdOrKeyword_True"
    // InternalNoParametersTestLanguage.g:855:1: entryRuleIdOrKeyword_True returns [String current=null] : iv_ruleIdOrKeyword_True= ruleIdOrKeyword_True EOF ;
    public final String entryRuleIdOrKeyword_True() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrKeyword_True = null;


        try {
            // InternalNoParametersTestLanguage.g:856:2: (iv_ruleIdOrKeyword_True= ruleIdOrKeyword_True EOF )
            // InternalNoParametersTestLanguage.g:857:2: iv_ruleIdOrKeyword_True= ruleIdOrKeyword_True EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrKeyword_TrueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdOrKeyword_True=ruleIdOrKeyword_True();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrKeyword_True.getText(); 
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
    // $ANTLR end "entryRuleIdOrKeyword_True"


    // $ANTLR start "ruleIdOrKeyword_True"
    // InternalNoParametersTestLanguage.g:864:1: ruleIdOrKeyword_True returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIdOrKeyword_True() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalNoParametersTestLanguage.g:867:28: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // InternalNoParametersTestLanguage.g:868:1: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // InternalNoParametersTestLanguage.g:868:1: (kw= 'keyword' | this_ID_1= RULE_ID )
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
                    // InternalNoParametersTestLanguage.g:869:2: kw= 'keyword'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrKeyword_TrueAccess().getKeywordKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalNoParametersTestLanguage.g:875:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_1, grammarAccess.getIdOrKeyword_TrueAccess().getIDTerminalRuleCall_1()); 
                          
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
    // $ANTLR end "ruleIdOrKeyword_True"


    // $ANTLR start "entryRuleIdOrKeyword_False"
    // InternalNoParametersTestLanguage.g:890:1: entryRuleIdOrKeyword_False returns [String current=null] : iv_ruleIdOrKeyword_False= ruleIdOrKeyword_False EOF ;
    public final String entryRuleIdOrKeyword_False() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrKeyword_False = null;


        try {
            // InternalNoParametersTestLanguage.g:891:2: (iv_ruleIdOrKeyword_False= ruleIdOrKeyword_False EOF )
            // InternalNoParametersTestLanguage.g:892:2: iv_ruleIdOrKeyword_False= ruleIdOrKeyword_False EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrKeyword_FalseRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdOrKeyword_False=ruleIdOrKeyword_False();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrKeyword_False.getText(); 
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
    // $ANTLR end "entryRuleIdOrKeyword_False"


    // $ANTLR start "ruleIdOrKeyword_False"
    // InternalNoParametersTestLanguage.g:899:1: ruleIdOrKeyword_False returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdOrKeyword_False() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalNoParametersTestLanguage.g:902:28: (this_ID_0= RULE_ID )
            // InternalNoParametersTestLanguage.g:903:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getIdOrKeyword_FalseAccess().getIDTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleIdOrKeyword_False"


    // $ANTLR start "entryRuleIdOrKeyword"
    // InternalNoParametersTestLanguage.g:934:1: entryRuleIdOrKeyword returns [String current=null] : iv_ruleIdOrKeyword= ruleIdOrKeyword EOF ;
    public final String entryRuleIdOrKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrKeyword = null;


        try {
            // InternalNoParametersTestLanguage.g:935:2: (iv_ruleIdOrKeyword= ruleIdOrKeyword EOF )
            // InternalNoParametersTestLanguage.g:936:2: iv_ruleIdOrKeyword= ruleIdOrKeyword EOF
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
    // InternalNoParametersTestLanguage.g:943:1: ruleIdOrKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdOrKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalNoParametersTestLanguage.g:946:28: (this_ID_0= RULE_ID )
            // InternalNoParametersTestLanguage.g:947:5: this_ID_0= RULE_ID
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
    // InternalNoParametersTestLanguage.g:963:1: norm1_IdOrKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken norm1_IdOrKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalNoParametersTestLanguage.g:966:28: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // InternalNoParametersTestLanguage.g:967:1: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // InternalNoParametersTestLanguage.g:967:1: (kw= 'keyword' | this_ID_1= RULE_ID )
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
                    // InternalNoParametersTestLanguage.g:968:2: kw= 'keyword'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrKeywordAccess().getKeywordKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalNoParametersTestLanguage.g:974:10: this_ID_1= RULE_ID
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

    // $ANTLR start synpred1_InternalNoParametersTestLanguage
    public final void synpred1_InternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalNoParametersTestLanguage.g:178:7: ( ( '#5' ( ( ruleScenario2_True ) ) ) )
        // InternalNoParametersTestLanguage.g:178:8: ( '#5' ( ( ruleScenario2_True ) ) )
        {
        // InternalNoParametersTestLanguage.g:178:8: ( '#5' ( ( ruleScenario2_True ) ) )
        // InternalNoParametersTestLanguage.g:178:10: '#5' ( ( ruleScenario2_True ) )
        {
        match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // InternalNoParametersTestLanguage.g:179:1: ( ( ruleScenario2_True ) )
        // InternalNoParametersTestLanguage.g:180:1: ( ruleScenario2_True )
        {
        // InternalNoParametersTestLanguage.g:180:1: ( ruleScenario2_True )
        // InternalNoParametersTestLanguage.g:181:1: ruleScenario2_True
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
    // $ANTLR end synpred1_InternalNoParametersTestLanguage

    // $ANTLR start synpred2_InternalNoParametersTestLanguage
    public final void synpred2_InternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalNoParametersTestLanguage.g:206:7: ( ( '#6' ( ( ruleScenario2_False ) ) ) )
        // InternalNoParametersTestLanguage.g:206:8: ( '#6' ( ( ruleScenario2_False ) ) )
        {
        // InternalNoParametersTestLanguage.g:206:8: ( '#6' ( ( ruleScenario2_False ) ) )
        // InternalNoParametersTestLanguage.g:206:10: '#6' ( ( ruleScenario2_False ) )
        {
        match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
        // InternalNoParametersTestLanguage.g:207:1: ( ( ruleScenario2_False ) )
        // InternalNoParametersTestLanguage.g:208:1: ( ruleScenario2_False )
        {
        // InternalNoParametersTestLanguage.g:208:1: ( ruleScenario2_False )
        // InternalNoParametersTestLanguage.g:209:1: ruleScenario2_False
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
    // $ANTLR end synpred2_InternalNoParametersTestLanguage

    // $ANTLR start synpred3_InternalNoParametersTestLanguage
    public final void synpred3_InternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalNoParametersTestLanguage.g:284:3: ( ( ruleIdOrKeyword_True ) )
        // InternalNoParametersTestLanguage.g:285:1: ( ruleIdOrKeyword_True )
        {
        // InternalNoParametersTestLanguage.g:285:1: ( ruleIdOrKeyword_True )
        // InternalNoParametersTestLanguage.g:286:1: ruleIdOrKeyword_True
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword_True();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalNoParametersTestLanguage

    // $ANTLR start synpred4_InternalNoParametersTestLanguage
    public final void synpred4_InternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalNoParametersTestLanguage.g:334:3: ( ( ruleIdOrKeyword_True ) )
        // InternalNoParametersTestLanguage.g:335:1: ( ruleIdOrKeyword_True )
        {
        // InternalNoParametersTestLanguage.g:335:1: ( ruleIdOrKeyword_True )
        // InternalNoParametersTestLanguage.g:336:1: ruleIdOrKeyword_True
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword_True();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalNoParametersTestLanguage

    // $ANTLR start synpred5_InternalNoParametersTestLanguage
    public final void synpred5_InternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalNoParametersTestLanguage.g:384:3: ( ( ruleIdOrKeyword_False ) )
        // InternalNoParametersTestLanguage.g:385:1: ( ruleIdOrKeyword_False )
        {
        // InternalNoParametersTestLanguage.g:385:1: ( ruleIdOrKeyword_False )
        // InternalNoParametersTestLanguage.g:386:1: ruleIdOrKeyword_False
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword_False();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalNoParametersTestLanguage

    // $ANTLR start synpred6_InternalNoParametersTestLanguage
    public final void synpred6_InternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalNoParametersTestLanguage.g:434:3: ( ( ruleIdOrKeyword_False ) )
        // InternalNoParametersTestLanguage.g:435:1: ( ruleIdOrKeyword_False )
        {
        // InternalNoParametersTestLanguage.g:435:1: ( ruleIdOrKeyword_False )
        // InternalNoParametersTestLanguage.g:436:1: ruleIdOrKeyword_False
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword_False();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalNoParametersTestLanguage

    // $ANTLR start synpred7_InternalNoParametersTestLanguage
    public final void synpred7_InternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalNoParametersTestLanguage.g:656:3: ( ( ruleIdOrKeyword_True ) )
        // InternalNoParametersTestLanguage.g:657:1: ( ruleIdOrKeyword_True )
        {
        // InternalNoParametersTestLanguage.g:657:1: ( ruleIdOrKeyword_True )
        // InternalNoParametersTestLanguage.g:658:1: ruleIdOrKeyword_True
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword_True();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalNoParametersTestLanguage

    // $ANTLR start synpred8_InternalNoParametersTestLanguage
    public final void synpred8_InternalNoParametersTestLanguage_fragment() throws RecognitionException {   
        // InternalNoParametersTestLanguage.g:715:3: ( ( ruleIdOrKeyword_False ) )
        // InternalNoParametersTestLanguage.g:716:1: ( ruleIdOrKeyword_False )
        {
        // InternalNoParametersTestLanguage.g:716:1: ( ruleIdOrKeyword_False )
        // InternalNoParametersTestLanguage.g:717:1: ruleIdOrKeyword_False
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword_False();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalNoParametersTestLanguage

    // Delegated rules

    public final boolean synpred2_InternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalNoParametersTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalNoParametersTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalNoParametersTestLanguage_fragment(); // can never throw exception
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
            return "86:2: ( (otherlv_1= '#1' ( (lv_scenario_2_0= ruleScenario1_True ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1_False ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= ruleScenario2_True ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2_False ) ) ) | ( ( ( '#5' ( ( ruleScenario2_True ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= ruleScenario2_True ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2_False ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2_False ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= ruleScenario3_True ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3_False ) ) ) | (otherlv_17= '#9' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_18_0= ruleScenario4_True ) ) | ( ( (lv_scenario_19_0= ruleScenario2_True ) ) (otherlv_20= 'keyword' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( ruleIdOrKeyword_True ) )=> (lv_scenario_22_0= ruleScenario4_True ) ) | ( ( (lv_scenario_23_0= ruleScenario2_False ) ) (otherlv_24= 'keyword' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_26_0= ruleScenario4_False ) ) | ( ( (lv_scenario_27_0= ruleScenario2_True ) ) (otherlv_28= 'keyword' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword_False ) )=> (lv_scenario_30_0= ruleScenario4_False ) ) | ( ( (lv_scenario_31_0= ruleScenario2_False ) ) (otherlv_32= 'keyword' )? ) ) ) )";
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

                        else if ( (LA9_0==15) && (synpred1_InternalNoParametersTestLanguage())) {s = 5;}

                        else if ( (LA9_0==16) && (synpred2_InternalNoParametersTestLanguage())) {s = 6;}

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