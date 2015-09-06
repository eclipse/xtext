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
import org.eclipse.xtext.parser.parameters.services.ParametersTestLanguageExGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalParametersTestLanguageExParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Keyword", "NumberSignDigitOneDigitZero", "NumberSignDigitOneDigitOne", "NumberSignDigitOneDigitTwo", "NumberSignDigitOne", "NumberSignDigitTwo", "NumberSignDigitThree", "NumberSignDigitFour", "NumberSignDigitFive", "NumberSignDigitSix", "NumberSignDigitSeven", "NumberSignDigitEight", "NumberSignDigitNine", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=17;
    public static final int NumberSignDigitNine=16;
    public static final int Keyword=4;
    public static final int NumberSignDigitEight=15;
    public static final int RULE_ANY_OTHER=23;
    public static final int NumberSignDigitOneDigitZero=5;
    public static final int NumberSignDigitSeven=14;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=21;
    public static final int NumberSignDigitThree=10;
    public static final int RULE_ML_COMMENT=20;
    public static final int NumberSignDigitOneDigitOne=6;
    public static final int RULE_STRING=19;
    public static final int NumberSignDigitOne=8;
    public static final int NumberSignDigitTwo=9;
    public static final int NumberSignDigitOneDigitTwo=7;
    public static final int RULE_INT=18;
    public static final int NumberSignDigitFour=11;
    public static final int NumberSignDigitSix=13;
    public static final int RULE_WS=22;
    public static final int NumberSignDigitFive=12;

    // delegates
    // delegators


        public InternalParametersTestLanguageExParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalParametersTestLanguageExParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalParametersTestLanguageExParser.tokenNames; }
    public String getGrammarFileName() { return "InternalParametersTestLanguageExParser.g"; }




    	private ParametersTestLanguageExGrammarAccess grammarAccess;
    	 	
    	public InternalParametersTestLanguageExParser(TokenStream input, ParametersTestLanguageExGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "ParserRuleFragmentsEx";	
    	} 
    	   	   	
    	@Override
    	protected ParametersTestLanguageExGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleParserRuleFragmentsEx"
    // InternalParametersTestLanguageExParser.g:61:1: entryRuleParserRuleFragmentsEx returns [EObject current=null] : iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF ;
    public final EObject entryRuleParserRuleFragmentsEx() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleFragmentsEx = null;


        try {
            // InternalParametersTestLanguageExParser.g:62:2: (iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF )
            // InternalParametersTestLanguageExParser.g:63:2: iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParserRuleFragmentsExRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParserRuleFragmentsEx=ruleParserRuleFragmentsEx();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParserRuleFragmentsEx; 
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
    // $ANTLR end "entryRuleParserRuleFragmentsEx"


    // $ANTLR start "ruleParserRuleFragmentsEx"
    // InternalParametersTestLanguageExParser.g:70:1: ruleParserRuleFragmentsEx returns [EObject current=null] : this_ParserRuleParameters_0= ruleParserRuleParameters ;
    public final EObject ruleParserRuleFragmentsEx() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRuleParameters_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageExParser.g:73:28: (this_ParserRuleParameters_0= ruleParserRuleParameters )
            // InternalParametersTestLanguageExParser.g:75:5: this_ParserRuleParameters_0= ruleParserRuleParameters
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getParserRuleFragmentsExAccess().getParserRuleParametersParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ParserRuleParameters_0=ruleParserRuleParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_ParserRuleParameters_0;
                      afterParserOrEnumRuleCall();
                  
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
    // $ANTLR end "ruleParserRuleFragmentsEx"


    // $ANTLR start "entryRuleParserRuleParameters"
    // InternalParametersTestLanguageExParser.g:91:1: entryRuleParserRuleParameters returns [EObject current=null] : iv_ruleParserRuleParameters= ruleParserRuleParameters EOF ;
    public final EObject entryRuleParserRuleParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleParameters = null;


        try {
            // InternalParametersTestLanguageExParser.g:92:2: (iv_ruleParserRuleParameters= ruleParserRuleParameters EOF )
            // InternalParametersTestLanguageExParser.g:93:2: iv_ruleParserRuleParameters= ruleParserRuleParameters EOF
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
    // InternalParametersTestLanguageExParser.g:100:1: ruleParserRuleParameters returns [EObject current=null] : ( () ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2 ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? ) ) ) ) ) ;
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
            // InternalParametersTestLanguageExParser.g:103:28: ( ( () ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2 ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? ) ) ) ) ) )
            // InternalParametersTestLanguageExParser.g:104:1: ( () ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2 ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? ) ) ) ) )
            {
            // InternalParametersTestLanguageExParser.g:104:1: ( () ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2 ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? ) ) ) ) )
            // InternalParametersTestLanguageExParser.g:104:2: () ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2 ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? ) ) ) )
            {
            // InternalParametersTestLanguageExParser.g:104:2: ()
            // InternalParametersTestLanguageExParser.g:105:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParserRuleParametersAccess().getParserRuleParametersAction_0(),
                          current);
                  
            }

            }

            // InternalParametersTestLanguageExParser.g:110:2: ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2 ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalParametersTestLanguageExParser.g:110:3: (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:110:3: (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    // InternalParametersTestLanguageExParser.g:111:2: otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    {
                    otherlv_1=(Token)match(input,NumberSignDigitOne,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneKeyword_1_0_0());
                          
                    }
                    // InternalParametersTestLanguageExParser.g:115:1: ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    // InternalParametersTestLanguageExParser.g:116:1: (lv_scenario_2_0= norm1_Scenario1 )
                    {
                    // InternalParametersTestLanguageExParser.g:116:1: (lv_scenario_2_0= norm1_Scenario1 )
                    // InternalParametersTestLanguageExParser.g:117:3: lv_scenario_2_0= norm1_Scenario1
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario1ParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_2_0=norm1_Scenario1();

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
                              		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario1");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguageExParser.g:134:6: (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:134:6: (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    // InternalParametersTestLanguageExParser.g:135:2: otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1 ) )
                    {
                    otherlv_3=(Token)match(input,NumberSignDigitTwo,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitTwoKeyword_1_1_0());
                          
                    }
                    // InternalParametersTestLanguageExParser.g:139:1: ( (lv_scenario_4_0= ruleScenario1 ) )
                    // InternalParametersTestLanguageExParser.g:140:1: (lv_scenario_4_0= ruleScenario1 )
                    {
                    // InternalParametersTestLanguageExParser.g:140:1: (lv_scenario_4_0= ruleScenario1 )
                    // InternalParametersTestLanguageExParser.g:141:3: lv_scenario_4_0= ruleScenario1
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario1ParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_4_0=ruleScenario1();

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
                              		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario1");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalParametersTestLanguageExParser.g:158:6: (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:158:6: (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    // InternalParametersTestLanguageExParser.g:159:2: otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    {
                    otherlv_5=(Token)match(input,NumberSignDigitThree,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitThreeKeyword_1_2_0());
                          
                    }
                    // InternalParametersTestLanguageExParser.g:163:1: ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    // InternalParametersTestLanguageExParser.g:164:1: (lv_scenario_6_0= norm1_Scenario2 )
                    {
                    // InternalParametersTestLanguageExParser.g:164:1: (lv_scenario_6_0= norm1_Scenario2 )
                    // InternalParametersTestLanguageExParser.g:165:3: lv_scenario_6_0= norm1_Scenario2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_6_0=norm1_Scenario2();

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
                              		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalParametersTestLanguageExParser.g:182:6: (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:182:6: (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    // InternalParametersTestLanguageExParser.g:183:2: otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2 ) )
                    {
                    otherlv_7=(Token)match(input,NumberSignDigitFour,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitFourKeyword_1_3_0());
                          
                    }
                    // InternalParametersTestLanguageExParser.g:187:1: ( (lv_scenario_8_0= ruleScenario2 ) )
                    // InternalParametersTestLanguageExParser.g:188:1: (lv_scenario_8_0= ruleScenario2 )
                    {
                    // InternalParametersTestLanguageExParser.g:188:1: (lv_scenario_8_0= ruleScenario2 )
                    // InternalParametersTestLanguageExParser.g:189:3: lv_scenario_8_0= ruleScenario2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_8_0=ruleScenario2();

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
                              		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalParametersTestLanguageExParser.g:206:6: ( ( ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:206:6: ( ( ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    // InternalParametersTestLanguageExParser.g:206:7: ( ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:212:6: (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    // InternalParametersTestLanguageExParser.g:213:2: otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    {
                    otherlv_9=(Token)match(input,NumberSignDigitFive,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitFiveKeyword_1_4_0_0());
                          
                    }
                    // InternalParametersTestLanguageExParser.g:217:1: ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    // InternalParametersTestLanguageExParser.g:218:1: (lv_scenario_10_0= norm1_Scenario2 )
                    {
                    // InternalParametersTestLanguageExParser.g:218:1: (lv_scenario_10_0= norm1_Scenario2 )
                    // InternalParametersTestLanguageExParser.g:219:3: lv_scenario_10_0= norm1_Scenario2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_4_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_10_0=norm1_Scenario2();

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
                              		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalParametersTestLanguageExParser.g:236:6: ( ( ( NumberSignDigitSix ( ( ruleScenario2 ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:236:6: ( ( ( NumberSignDigitSix ( ( ruleScenario2 ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    // InternalParametersTestLanguageExParser.g:236:7: ( ( NumberSignDigitSix ( ( ruleScenario2 ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:242:6: (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    // InternalParametersTestLanguageExParser.g:243:2: otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2 ) )
                    {
                    otherlv_11=(Token)match(input,NumberSignDigitSix,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitSixKeyword_1_5_0_0());
                          
                    }
                    // InternalParametersTestLanguageExParser.g:247:1: ( (lv_scenario_12_0= ruleScenario2 ) )
                    // InternalParametersTestLanguageExParser.g:248:1: (lv_scenario_12_0= ruleScenario2 )
                    {
                    // InternalParametersTestLanguageExParser.g:248:1: (lv_scenario_12_0= ruleScenario2 )
                    // InternalParametersTestLanguageExParser.g:249:3: lv_scenario_12_0= ruleScenario2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_5_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_12_0=ruleScenario2();

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
                              		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalParametersTestLanguageExParser.g:266:6: (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:266:6: (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    // InternalParametersTestLanguageExParser.g:267:2: otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    {
                    otherlv_13=(Token)match(input,NumberSignDigitSeven,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitSevenKeyword_1_6_0());
                          
                    }
                    // InternalParametersTestLanguageExParser.g:271:1: ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    // InternalParametersTestLanguageExParser.g:272:1: (lv_scenario_14_0= norm1_Scenario3 )
                    {
                    // InternalParametersTestLanguageExParser.g:272:1: (lv_scenario_14_0= norm1_Scenario3 )
                    // InternalParametersTestLanguageExParser.g:273:3: lv_scenario_14_0= norm1_Scenario3
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario3ParserRuleCall_1_6_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_14_0=norm1_Scenario3();

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
                              		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario3");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalParametersTestLanguageExParser.g:290:6: (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:290:6: (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    // InternalParametersTestLanguageExParser.g:291:2: otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3 ) )
                    {
                    otherlv_15=(Token)match(input,NumberSignDigitEight,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitEightKeyword_1_7_0());
                          
                    }
                    // InternalParametersTestLanguageExParser.g:295:1: ( (lv_scenario_16_0= ruleScenario3 ) )
                    // InternalParametersTestLanguageExParser.g:296:1: (lv_scenario_16_0= ruleScenario3 )
                    {
                    // InternalParametersTestLanguageExParser.g:296:1: (lv_scenario_16_0= ruleScenario3 )
                    // InternalParametersTestLanguageExParser.g:297:3: lv_scenario_16_0= ruleScenario3
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario3ParserRuleCall_1_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_16_0=ruleScenario3();

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
                              		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario3");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalParametersTestLanguageExParser.g:314:6: (otherlv_17= NumberSignDigitNine ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:314:6: (otherlv_17= NumberSignDigitNine ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? ) ) )
                    // InternalParametersTestLanguageExParser.g:315:2: otherlv_17= NumberSignDigitNine ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? ) )
                    {
                    otherlv_17=(Token)match(input,NumberSignDigitNine,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitNineKeyword_1_8_0());
                          
                    }
                    // InternalParametersTestLanguageExParser.g:319:1: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? ) )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==Keyword) ) {
                        int LA2_1 = input.LA(2);

                        if ( (LA2_1==Keyword) ) {
                            int LA2_3 = input.LA(3);

                            if ( (synpred3_InternalParametersTestLanguageExParser()) ) {
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

                        if ( (LA2_2==Keyword) ) {
                            int LA2_3 = input.LA(3);

                            if ( (synpred3_InternalParametersTestLanguageExParser()) ) {
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
                            // InternalParametersTestLanguageExParser.g:319:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            {
                            // InternalParametersTestLanguageExParser.g:319:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            // InternalParametersTestLanguageExParser.g:319:3: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 )
                            {
                            // InternalParametersTestLanguageExParser.g:324:1: (lv_scenario_18_0= norm1_Scenario4 )
                            // InternalParametersTestLanguageExParser.g:325:3: lv_scenario_18_0= norm1_Scenario4
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_8_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_18_0=norm1_Scenario4();

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
                                      		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario4");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalParametersTestLanguageExParser.g:342:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? )
                            {
                            // InternalParametersTestLanguageExParser.g:342:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? )
                            // InternalParametersTestLanguageExParser.g:342:7: ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )?
                            {
                            // InternalParametersTestLanguageExParser.g:342:7: ( (lv_scenario_19_0= norm1_Scenario2 ) )
                            // InternalParametersTestLanguageExParser.g:343:1: (lv_scenario_19_0= norm1_Scenario2 )
                            {
                            // InternalParametersTestLanguageExParser.g:343:1: (lv_scenario_19_0= norm1_Scenario2 )
                            // InternalParametersTestLanguageExParser.g:344:3: lv_scenario_19_0= norm1_Scenario2
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_8_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_19_0=norm1_Scenario2();

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
                                      		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalParametersTestLanguageExParser.g:360:2: (otherlv_20= Keyword )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==Keyword) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // InternalParametersTestLanguageExParser.g:361:2: otherlv_20= Keyword
                                    {
                                    otherlv_20=(Token)match(input,Keyword,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalParametersTestLanguageExParser.g:366:6: (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:366:6: (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? ) ) )
                    // InternalParametersTestLanguageExParser.g:367:2: otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? ) )
                    {
                    otherlv_21=(Token)match(input,NumberSignDigitOneDigitZero,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitZeroKeyword_1_9_0());
                          
                    }
                    // InternalParametersTestLanguageExParser.g:371:1: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==Keyword) && (synpred4_InternalParametersTestLanguageExParser())) {
                        alt4=1;
                    }
                    else if ( (LA4_0==RULE_ID) ) {
                        int LA4_2 = input.LA(2);

                        if ( (LA4_2==Keyword) ) {
                            int LA4_3 = input.LA(3);

                            if ( (synpred4_InternalParametersTestLanguageExParser()) ) {
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
                            // InternalParametersTestLanguageExParser.g:371:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            {
                            // InternalParametersTestLanguageExParser.g:371:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            // InternalParametersTestLanguageExParser.g:371:3: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 )
                            {
                            // InternalParametersTestLanguageExParser.g:376:1: (lv_scenario_22_0= norm1_Scenario4 )
                            // InternalParametersTestLanguageExParser.g:377:3: lv_scenario_22_0= norm1_Scenario4
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_9_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_22_0=norm1_Scenario4();

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
                                      		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario4");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalParametersTestLanguageExParser.g:394:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? )
                            {
                            // InternalParametersTestLanguageExParser.g:394:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? )
                            // InternalParametersTestLanguageExParser.g:394:7: ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )?
                            {
                            // InternalParametersTestLanguageExParser.g:394:7: ( (lv_scenario_23_0= ruleScenario2 ) )
                            // InternalParametersTestLanguageExParser.g:395:1: (lv_scenario_23_0= ruleScenario2 )
                            {
                            // InternalParametersTestLanguageExParser.g:395:1: (lv_scenario_23_0= ruleScenario2 )
                            // InternalParametersTestLanguageExParser.g:396:3: lv_scenario_23_0= ruleScenario2
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_9_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_23_0=ruleScenario2();

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
                                      		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalParametersTestLanguageExParser.g:412:2: (otherlv_24= Keyword )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==Keyword) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // InternalParametersTestLanguageExParser.g:413:2: otherlv_24= Keyword
                                    {
                                    otherlv_24=(Token)match(input,Keyword,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalParametersTestLanguageExParser.g:418:6: (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:418:6: (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? ) ) )
                    // InternalParametersTestLanguageExParser.g:419:2: otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? ) )
                    {
                    otherlv_25=(Token)match(input,NumberSignDigitOneDigitOne,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitOneKeyword_1_10_0());
                          
                    }
                    // InternalParametersTestLanguageExParser.g:423:1: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==Keyword) ) {
                            int LA6_3 = input.LA(3);

                            if ( (synpred5_InternalParametersTestLanguageExParser()) ) {
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
                    else if ( (LA6_0==Keyword) ) {
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
                            // InternalParametersTestLanguageExParser.g:423:2: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            {
                            // InternalParametersTestLanguageExParser.g:423:2: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            // InternalParametersTestLanguageExParser.g:423:3: ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 )
                            {
                            // InternalParametersTestLanguageExParser.g:428:1: (lv_scenario_26_0= ruleScenario4 )
                            // InternalParametersTestLanguageExParser.g:429:3: lv_scenario_26_0= ruleScenario4
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_10_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_26_0=ruleScenario4();

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
                                      		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario4");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalParametersTestLanguageExParser.g:446:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? )
                            {
                            // InternalParametersTestLanguageExParser.g:446:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? )
                            // InternalParametersTestLanguageExParser.g:446:7: ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )?
                            {
                            // InternalParametersTestLanguageExParser.g:446:7: ( (lv_scenario_27_0= norm1_Scenario2 ) )
                            // InternalParametersTestLanguageExParser.g:447:1: (lv_scenario_27_0= norm1_Scenario2 )
                            {
                            // InternalParametersTestLanguageExParser.g:447:1: (lv_scenario_27_0= norm1_Scenario2 )
                            // InternalParametersTestLanguageExParser.g:448:3: lv_scenario_27_0= norm1_Scenario2
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_10_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_27_0=norm1_Scenario2();

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
                                      		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalParametersTestLanguageExParser.g:464:2: (otherlv_28= Keyword )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==Keyword) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // InternalParametersTestLanguageExParser.g:465:2: otherlv_28= Keyword
                                    {
                                    otherlv_28=(Token)match(input,Keyword,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalParametersTestLanguageExParser.g:470:6: (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? ) ) )
                    {
                    // InternalParametersTestLanguageExParser.g:470:6: (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? ) ) )
                    // InternalParametersTestLanguageExParser.g:471:2: otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? ) )
                    {
                    otherlv_29=(Token)match(input,NumberSignDigitOneDigitTwo,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitTwoKeyword_1_11_0());
                          
                    }
                    // InternalParametersTestLanguageExParser.g:475:1: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==Keyword) ) {
                            int LA8_2 = input.LA(3);

                            if ( (synpred6_InternalParametersTestLanguageExParser()) ) {
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
                            // InternalParametersTestLanguageExParser.g:475:2: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            {
                            // InternalParametersTestLanguageExParser.g:475:2: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            // InternalParametersTestLanguageExParser.g:475:3: ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 )
                            {
                            // InternalParametersTestLanguageExParser.g:480:1: (lv_scenario_30_0= ruleScenario4 )
                            // InternalParametersTestLanguageExParser.g:481:3: lv_scenario_30_0= ruleScenario4
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_11_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_30_0=ruleScenario4();

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
                                      		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario4");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalParametersTestLanguageExParser.g:498:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? )
                            {
                            // InternalParametersTestLanguageExParser.g:498:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? )
                            // InternalParametersTestLanguageExParser.g:498:7: ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )?
                            {
                            // InternalParametersTestLanguageExParser.g:498:7: ( (lv_scenario_31_0= ruleScenario2 ) )
                            // InternalParametersTestLanguageExParser.g:499:1: (lv_scenario_31_0= ruleScenario2 )
                            {
                            // InternalParametersTestLanguageExParser.g:499:1: (lv_scenario_31_0= ruleScenario2 )
                            // InternalParametersTestLanguageExParser.g:500:3: lv_scenario_31_0= ruleScenario2
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_11_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_5);
                            lv_scenario_31_0=ruleScenario2();

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
                                      		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.Scenario2");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalParametersTestLanguageExParser.g:516:2: (otherlv_32= Keyword )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==Keyword) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // InternalParametersTestLanguageExParser.g:517:2: otherlv_32= Keyword
                                    {
                                    otherlv_32=(Token)match(input,Keyword,FollowSets000.FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleScenario1"
    // InternalParametersTestLanguageExParser.g:529:1: entryRuleScenario1 returns [EObject current=null] : iv_ruleScenario1= ruleScenario1 EOF ;
    public final EObject entryRuleScenario1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario1 = null;


        try {
            // InternalParametersTestLanguageExParser.g:530:2: (iv_ruleScenario1= ruleScenario1 EOF )
            // InternalParametersTestLanguageExParser.g:531:2: iv_ruleScenario1= ruleScenario1 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario1Rule()); 
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
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario1"


    // $ANTLR start "ruleScenario1"
    // InternalParametersTestLanguageExParser.g:538:1: ruleScenario1 returns [EObject current=null] : ( (lv_second_0_0= RULE_ID ) ) ;
    public final EObject ruleScenario1() throws RecognitionException {
        EObject current = null;

        Token lv_second_0_0=null;

         enterRule(); 
            
        try {
            // InternalParametersTestLanguageExParser.g:541:28: ( ( (lv_second_0_0= RULE_ID ) ) )
            // InternalParametersTestLanguageExParser.g:542:1: ( (lv_second_0_0= RULE_ID ) )
            {
            // InternalParametersTestLanguageExParser.g:542:1: ( (lv_second_0_0= RULE_ID ) )
            // InternalParametersTestLanguageExParser.g:543:1: (lv_second_0_0= RULE_ID )
            {
            // InternalParametersTestLanguageExParser.g:543:1: (lv_second_0_0= RULE_ID )
            // InternalParametersTestLanguageExParser.g:544:3: lv_second_0_0= RULE_ID
            {
            lv_second_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_second_0_0, grammarAccess.getScenario1Access().getSecondIDTerminalRuleCall_1_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScenario1Rule());
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
    // $ANTLR end "ruleScenario1"


    // $ANTLR start "norm1_Scenario1"
    // InternalParametersTestLanguageExParser.g:569:1: norm1_Scenario1 returns [EObject current=null] : ( (lv_first_0_0= RULE_ID ) ) ;
    public final EObject norm1_Scenario1() throws RecognitionException {
        EObject current = null;

        Token lv_first_0_0=null;

         enterRule(); 
            
        try {
            // InternalParametersTestLanguageExParser.g:572:28: ( ( (lv_first_0_0= RULE_ID ) ) )
            // InternalParametersTestLanguageExParser.g:573:1: ( (lv_first_0_0= RULE_ID ) )
            {
            // InternalParametersTestLanguageExParser.g:573:1: ( (lv_first_0_0= RULE_ID ) )
            // InternalParametersTestLanguageExParser.g:574:1: (lv_first_0_0= RULE_ID )
            {
            // InternalParametersTestLanguageExParser.g:574:1: (lv_first_0_0= RULE_ID )
            // InternalParametersTestLanguageExParser.g:575:3: lv_first_0_0= RULE_ID
            {
            lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_first_0_0, grammarAccess.getScenario1Access().getFirstIDTerminalRuleCall_0_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScenario1Rule());
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
    // $ANTLR end "norm1_Scenario1"


    // $ANTLR start "entryRuleScenario2"
    // InternalParametersTestLanguageExParser.g:599:1: entryRuleScenario2 returns [EObject current=null] : iv_ruleScenario2= ruleScenario2 EOF ;
    public final EObject entryRuleScenario2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2 = null;


        try {
            // InternalParametersTestLanguageExParser.g:600:2: (iv_ruleScenario2= ruleScenario2 EOF )
            // InternalParametersTestLanguageExParser.g:601:2: iv_ruleScenario2= ruleScenario2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario2Rule()); 
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
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario2"


    // $ANTLR start "ruleScenario2"
    // InternalParametersTestLanguageExParser.g:608:1: ruleScenario2 returns [EObject current=null] : ( (lv_first_0_0= ruleIdOrKeyword ) ) ;
    public final EObject ruleScenario2() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageExParser.g:611:28: ( ( (lv_first_0_0= ruleIdOrKeyword ) ) )
            // InternalParametersTestLanguageExParser.g:612:1: ( (lv_first_0_0= ruleIdOrKeyword ) )
            {
            // InternalParametersTestLanguageExParser.g:612:1: ( (lv_first_0_0= ruleIdOrKeyword ) )
            // InternalParametersTestLanguageExParser.g:613:1: (lv_first_0_0= ruleIdOrKeyword )
            {
            // InternalParametersTestLanguageExParser.g:613:1: (lv_first_0_0= ruleIdOrKeyword )
            // InternalParametersTestLanguageExParser.g:614:3: lv_first_0_0= ruleIdOrKeyword
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario2Access().getFirstIdOrKeywordParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=ruleIdOrKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScenario2Rule());
              	        }
                     		set(
                     			current, 
                     			"first",
                      		lv_first_0_0, 
                      		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.IdOrKeyword");
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
    // $ANTLR end "ruleScenario2"


    // $ANTLR start "norm1_Scenario2"
    // InternalParametersTestLanguageExParser.g:639:1: norm1_Scenario2 returns [EObject current=null] : ( (lv_first_0_0= norm1_IdOrKeyword ) ) ;
    public final EObject norm1_Scenario2() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageExParser.g:642:28: ( ( (lv_first_0_0= norm1_IdOrKeyword ) ) )
            // InternalParametersTestLanguageExParser.g:643:1: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            {
            // InternalParametersTestLanguageExParser.g:643:1: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            // InternalParametersTestLanguageExParser.g:644:1: (lv_first_0_0= norm1_IdOrKeyword )
            {
            // InternalParametersTestLanguageExParser.g:644:1: (lv_first_0_0= norm1_IdOrKeyword )
            // InternalParametersTestLanguageExParser.g:645:3: lv_first_0_0= norm1_IdOrKeyword
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario2Access().getFirstIdOrKeywordParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_first_0_0=norm1_IdOrKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScenario2Rule());
              	        }
                     		set(
                     			current, 
                     			"first",
                      		lv_first_0_0, 
                      		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.IdOrKeyword");
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
    // $ANTLR end "norm1_Scenario2"


    // $ANTLR start "entryRuleScenario3"
    // InternalParametersTestLanguageExParser.g:669:1: entryRuleScenario3 returns [EObject current=null] : iv_ruleScenario3= ruleScenario3 EOF ;
    public final EObject entryRuleScenario3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario3 = null;


        try {
            // InternalParametersTestLanguageExParser.g:670:2: (iv_ruleScenario3= ruleScenario3 EOF )
            // InternalParametersTestLanguageExParser.g:671:2: iv_ruleScenario3= ruleScenario3 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario3Rule()); 
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
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario3"


    // $ANTLR start "ruleScenario3"
    // InternalParametersTestLanguageExParser.g:678:1: ruleScenario3 returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= Keyword ) ) ) ;
    public final EObject ruleScenario3() throws RecognitionException {
        EObject current = null;

        Token lv_second_1_0=null;
        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageExParser.g:681:28: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= Keyword ) ) ) )
            // InternalParametersTestLanguageExParser.g:682:1: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= Keyword ) ) )
            {
            // InternalParametersTestLanguageExParser.g:682:1: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= Keyword ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) && (synpred7_InternalParametersTestLanguageExParser())) {
                alt10=1;
            }
            else if ( (LA10_0==Keyword) ) {
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
                    // InternalParametersTestLanguageExParser.g:682:2: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    {
                    // InternalParametersTestLanguageExParser.g:682:2: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    // InternalParametersTestLanguageExParser.g:682:3: ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword )
                    {
                    // InternalParametersTestLanguageExParser.g:687:1: (lv_first_0_0= ruleIdOrKeyword )
                    // InternalParametersTestLanguageExParser.g:688:3: lv_first_0_0= ruleIdOrKeyword
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScenario3Access().getFirstIdOrKeywordParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_0_0=ruleIdOrKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScenario3Rule());
                      	        }
                             		set(
                             			current, 
                             			"first",
                              		lv_first_0_0, 
                              		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.IdOrKeyword");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguageExParser.g:705:6: ( (lv_second_1_0= Keyword ) )
                    {
                    // InternalParametersTestLanguageExParser.g:705:6: ( (lv_second_1_0= Keyword ) )
                    // InternalParametersTestLanguageExParser.g:706:1: (lv_second_1_0= Keyword )
                    {
                    // InternalParametersTestLanguageExParser.g:706:1: (lv_second_1_0= Keyword )
                    // InternalParametersTestLanguageExParser.g:707:3: lv_second_1_0= Keyword
                    {
                    lv_second_1_0=(Token)match(input,Keyword,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_second_1_0, grammarAccess.getScenario3Access().getSecondKeywordKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScenario3Rule());
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
    // $ANTLR end "ruleScenario3"


    // $ANTLR start "norm1_Scenario3"
    // InternalParametersTestLanguageExParser.g:730:1: norm1_Scenario3 returns [EObject current=null] : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= Keyword ) ) ) ;
    public final EObject norm1_Scenario3() throws RecognitionException {
        EObject current = null;

        Token lv_second_1_0=null;
        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageExParser.g:733:28: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= Keyword ) ) ) )
            // InternalParametersTestLanguageExParser.g:734:1: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= Keyword ) ) )
            {
            // InternalParametersTestLanguageExParser.g:734:1: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= Keyword ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Keyword) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred8_InternalParametersTestLanguageExParser()) ) {
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
            else if ( (LA11_0==RULE_ID) && (synpred8_InternalParametersTestLanguageExParser())) {
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
                    // InternalParametersTestLanguageExParser.g:734:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    {
                    // InternalParametersTestLanguageExParser.g:734:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    // InternalParametersTestLanguageExParser.g:734:3: ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword )
                    {
                    // InternalParametersTestLanguageExParser.g:739:1: (lv_first_0_0= norm1_IdOrKeyword )
                    // InternalParametersTestLanguageExParser.g:740:3: lv_first_0_0= norm1_IdOrKeyword
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScenario3Access().getFirstIdOrKeywordParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_first_0_0=norm1_IdOrKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScenario3Rule());
                      	        }
                             		set(
                             			current, 
                             			"first",
                              		lv_first_0_0, 
                              		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.IdOrKeyword");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguageExParser.g:757:6: ( (lv_second_1_0= Keyword ) )
                    {
                    // InternalParametersTestLanguageExParser.g:757:6: ( (lv_second_1_0= Keyword ) )
                    // InternalParametersTestLanguageExParser.g:758:1: (lv_second_1_0= Keyword )
                    {
                    // InternalParametersTestLanguageExParser.g:758:1: (lv_second_1_0= Keyword )
                    // InternalParametersTestLanguageExParser.g:759:3: lv_second_1_0= Keyword
                    {
                    lv_second_1_0=(Token)match(input,Keyword,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_second_1_0, grammarAccess.getScenario3Access().getSecondKeywordKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScenario3Rule());
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
    // $ANTLR end "norm1_Scenario3"


    // $ANTLR start "entryRuleScenario4"
    // InternalParametersTestLanguageExParser.g:781:1: entryRuleScenario4 returns [EObject current=null] : iv_ruleScenario4= ruleScenario4 EOF ;
    public final EObject entryRuleScenario4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario4 = null;


        try {
            // InternalParametersTestLanguageExParser.g:782:2: (iv_ruleScenario4= ruleScenario4 EOF )
            // InternalParametersTestLanguageExParser.g:783:2: iv_ruleScenario4= ruleScenario4 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario4Rule()); 
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
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario4"


    // $ANTLR start "ruleScenario4"
    // InternalParametersTestLanguageExParser.g:790:1: ruleScenario4 returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= Keyword ) ;
    public final EObject ruleScenario4() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_second_0_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageExParser.g:793:28: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= Keyword ) )
            // InternalParametersTestLanguageExParser.g:794:1: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= Keyword )
            {
            // InternalParametersTestLanguageExParser.g:794:1: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= Keyword )
            // InternalParametersTestLanguageExParser.g:794:2: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= Keyword
            {
            // InternalParametersTestLanguageExParser.g:794:2: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) )
            // InternalParametersTestLanguageExParser.g:794:3: ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword )
            {
            // InternalParametersTestLanguageExParser.g:799:1: (lv_second_0_0= ruleIdOrKeyword )
            // InternalParametersTestLanguageExParser.g:800:3: lv_second_0_0= ruleIdOrKeyword
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario4Access().getSecondIdOrKeywordParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_second_0_0=ruleIdOrKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScenario4Rule());
              	        }
                     		set(
                     			current, 
                     			"second",
                      		lv_second_0_0, 
                      		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.IdOrKeyword");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,Keyword,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScenario4Access().getKeywordKeyword_1());
                  
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
    // $ANTLR end "ruleScenario4"


    // $ANTLR start "norm1_Scenario4"
    // InternalParametersTestLanguageExParser.g:830:1: norm1_Scenario4 returns [EObject current=null] : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= Keyword ) ;
    public final EObject norm1_Scenario4() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_second_0_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageExParser.g:833:28: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= Keyword ) )
            // InternalParametersTestLanguageExParser.g:834:1: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= Keyword )
            {
            // InternalParametersTestLanguageExParser.g:834:1: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= Keyword )
            // InternalParametersTestLanguageExParser.g:834:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= Keyword
            {
            // InternalParametersTestLanguageExParser.g:834:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) )
            // InternalParametersTestLanguageExParser.g:834:3: ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword )
            {
            // InternalParametersTestLanguageExParser.g:839:1: (lv_second_0_0= norm1_IdOrKeyword )
            // InternalParametersTestLanguageExParser.g:840:3: lv_second_0_0= norm1_IdOrKeyword
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario4Access().getSecondIdOrKeywordParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_6);
            lv_second_0_0=norm1_IdOrKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScenario4Rule());
              	        }
                     		set(
                     			current, 
                     			"second",
                      		lv_second_0_0, 
                      		"org.eclipse.xtext.parser.parameters.ParametersTestLanguage.IdOrKeyword");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,Keyword,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScenario4Access().getKeywordKeyword_1());
                  
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
    // $ANTLR end "norm1_Scenario4"


    // $ANTLR start "entryRuleIdOrKeyword"
    // InternalParametersTestLanguageExParser.g:869:1: entryRuleIdOrKeyword returns [String current=null] : iv_ruleIdOrKeyword= ruleIdOrKeyword EOF ;
    public final String entryRuleIdOrKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrKeyword = null;


        try {
            // InternalParametersTestLanguageExParser.g:870:1: (iv_ruleIdOrKeyword= ruleIdOrKeyword EOF )
            // InternalParametersTestLanguageExParser.g:871:2: iv_ruleIdOrKeyword= ruleIdOrKeyword EOF
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
    // InternalParametersTestLanguageExParser.g:878:1: ruleIdOrKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdOrKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalParametersTestLanguageExParser.g:882:6: (this_ID_0= RULE_ID )
            // InternalParametersTestLanguageExParser.g:883:5: this_ID_0= RULE_ID
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
    // InternalParametersTestLanguageExParser.g:899:1: norm1_IdOrKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Keyword | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken norm1_IdOrKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalParametersTestLanguageExParser.g:903:6: ( (kw= Keyword | this_ID_1= RULE_ID ) )
            // InternalParametersTestLanguageExParser.g:904:1: (kw= Keyword | this_ID_1= RULE_ID )
            {
            // InternalParametersTestLanguageExParser.g:904:1: (kw= Keyword | this_ID_1= RULE_ID )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Keyword) ) {
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
                    // InternalParametersTestLanguageExParser.g:905:2: kw= Keyword
                    {
                    kw=(Token)match(input,Keyword,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrKeywordAccess().getKeywordKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguageExParser.g:911:10: this_ID_1= RULE_ID
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

    // $ANTLR start synpred1_InternalParametersTestLanguageExParser
    public final void synpred1_InternalParametersTestLanguageExParser_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageExParser.g:206:7: ( ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) ) )
        // InternalParametersTestLanguageExParser.g:206:8: ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) )
        {
        // InternalParametersTestLanguageExParser.g:206:8: ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) )
        // InternalParametersTestLanguageExParser.g:207:1: NumberSignDigitFive ( ( norm1_Scenario2 ) )
        {
        match(input,NumberSignDigitFive,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // InternalParametersTestLanguageExParser.g:208:1: ( ( norm1_Scenario2 ) )
        // InternalParametersTestLanguageExParser.g:209:1: ( norm1_Scenario2 )
        {
        // InternalParametersTestLanguageExParser.g:209:1: ( norm1_Scenario2 )
        // InternalParametersTestLanguageExParser.g:210:1: norm1_Scenario2
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
    // $ANTLR end synpred1_InternalParametersTestLanguageExParser

    // $ANTLR start synpred2_InternalParametersTestLanguageExParser
    public final void synpred2_InternalParametersTestLanguageExParser_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageExParser.g:236:7: ( ( NumberSignDigitSix ( ( ruleScenario2 ) ) ) )
        // InternalParametersTestLanguageExParser.g:236:8: ( NumberSignDigitSix ( ( ruleScenario2 ) ) )
        {
        // InternalParametersTestLanguageExParser.g:236:8: ( NumberSignDigitSix ( ( ruleScenario2 ) ) )
        // InternalParametersTestLanguageExParser.g:237:1: NumberSignDigitSix ( ( ruleScenario2 ) )
        {
        match(input,NumberSignDigitSix,FollowSets000.FOLLOW_3); if (state.failed) return ;
        // InternalParametersTestLanguageExParser.g:238:1: ( ( ruleScenario2 ) )
        // InternalParametersTestLanguageExParser.g:239:1: ( ruleScenario2 )
        {
        // InternalParametersTestLanguageExParser.g:239:1: ( ruleScenario2 )
        // InternalParametersTestLanguageExParser.g:240:1: ruleScenario2
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
    // $ANTLR end synpred2_InternalParametersTestLanguageExParser

    // $ANTLR start synpred3_InternalParametersTestLanguageExParser
    public final void synpred3_InternalParametersTestLanguageExParser_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageExParser.g:319:3: ( ( norm1_IdOrKeyword ) )
        // InternalParametersTestLanguageExParser.g:320:1: ( norm1_IdOrKeyword )
        {
        // InternalParametersTestLanguageExParser.g:320:1: ( norm1_IdOrKeyword )
        // InternalParametersTestLanguageExParser.g:321:1: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalParametersTestLanguageExParser

    // $ANTLR start synpred4_InternalParametersTestLanguageExParser
    public final void synpred4_InternalParametersTestLanguageExParser_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageExParser.g:371:3: ( ( norm1_IdOrKeyword ) )
        // InternalParametersTestLanguageExParser.g:372:1: ( norm1_IdOrKeyword )
        {
        // InternalParametersTestLanguageExParser.g:372:1: ( norm1_IdOrKeyword )
        // InternalParametersTestLanguageExParser.g:373:1: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalParametersTestLanguageExParser

    // $ANTLR start synpred5_InternalParametersTestLanguageExParser
    public final void synpred5_InternalParametersTestLanguageExParser_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageExParser.g:423:3: ( ( ruleIdOrKeyword ) )
        // InternalParametersTestLanguageExParser.g:424:1: ( ruleIdOrKeyword )
        {
        // InternalParametersTestLanguageExParser.g:424:1: ( ruleIdOrKeyword )
        // InternalParametersTestLanguageExParser.g:425:1: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalParametersTestLanguageExParser

    // $ANTLR start synpred6_InternalParametersTestLanguageExParser
    public final void synpred6_InternalParametersTestLanguageExParser_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageExParser.g:475:3: ( ( ruleIdOrKeyword ) )
        // InternalParametersTestLanguageExParser.g:476:1: ( ruleIdOrKeyword )
        {
        // InternalParametersTestLanguageExParser.g:476:1: ( ruleIdOrKeyword )
        // InternalParametersTestLanguageExParser.g:477:1: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalParametersTestLanguageExParser

    // $ANTLR start synpred7_InternalParametersTestLanguageExParser
    public final void synpred7_InternalParametersTestLanguageExParser_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageExParser.g:682:3: ( ( ruleIdOrKeyword ) )
        // InternalParametersTestLanguageExParser.g:683:1: ( ruleIdOrKeyword )
        {
        // InternalParametersTestLanguageExParser.g:683:1: ( ruleIdOrKeyword )
        // InternalParametersTestLanguageExParser.g:684:1: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalParametersTestLanguageExParser

    // $ANTLR start synpred8_InternalParametersTestLanguageExParser
    public final void synpred8_InternalParametersTestLanguageExParser_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageExParser.g:734:3: ( ( norm1_IdOrKeyword ) )
        // InternalParametersTestLanguageExParser.g:735:1: ( norm1_IdOrKeyword )
        {
        // InternalParametersTestLanguageExParser.g:735:1: ( norm1_IdOrKeyword )
        // InternalParametersTestLanguageExParser.g:736:1: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalParametersTestLanguageExParser

    // Delegated rules

    public final boolean synpred7_InternalParametersTestLanguageExParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalParametersTestLanguageExParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalParametersTestLanguageExParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalParametersTestLanguageExParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalParametersTestLanguageExParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalParametersTestLanguageExParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalParametersTestLanguageExParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalParametersTestLanguageExParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalParametersTestLanguageExParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalParametersTestLanguageExParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalParametersTestLanguageExParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalParametersTestLanguageExParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalParametersTestLanguageExParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalParametersTestLanguageExParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalParametersTestLanguageExParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalParametersTestLanguageExParser_fragment(); // can never throw exception
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
        "\1\5\14\uffff";
    static final String DFA9_maxS =
        "\1\20\14\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14";
    static final String DFA9_specialS =
        "\1\0\14\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\12\1\13\1\14\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11",
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
            return "110:2: ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( NumberSignDigitFive ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2 ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= Keyword )? ) ) ) )";
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
                        if ( (LA9_0==NumberSignDigitOne) ) {s = 1;}

                        else if ( (LA9_0==NumberSignDigitTwo) ) {s = 2;}

                        else if ( (LA9_0==NumberSignDigitThree) ) {s = 3;}

                        else if ( (LA9_0==NumberSignDigitFour) ) {s = 4;}

                        else if ( (LA9_0==NumberSignDigitFive) && (synpred1_InternalParametersTestLanguageExParser())) {s = 5;}

                        else if ( (LA9_0==NumberSignDigitSix) && (synpred2_InternalParametersTestLanguageExParser())) {s = 6;}

                        else if ( (LA9_0==NumberSignDigitSeven) ) {s = 7;}

                        else if ( (LA9_0==NumberSignDigitEight) ) {s = 8;}

                        else if ( (LA9_0==NumberSignDigitNine) ) {s = 9;}

                        else if ( (LA9_0==NumberSignDigitOneDigitZero) ) {s = 10;}

                        else if ( (LA9_0==NumberSignDigitOneDigitOne) ) {s = 11;}

                        else if ( (LA9_0==NumberSignDigitOneDigitTwo) ) {s = 12;}

                         
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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    }


}