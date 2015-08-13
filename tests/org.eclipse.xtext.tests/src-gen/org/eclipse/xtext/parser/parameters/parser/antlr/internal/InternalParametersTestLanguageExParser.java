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
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g"; }




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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:61:1: entryRuleParserRuleFragmentsEx returns [EObject current=null] : iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF ;
    public final EObject entryRuleParserRuleFragmentsEx() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleFragmentsEx = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:62:2: (iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:63:2: iv_ruleParserRuleFragmentsEx= ruleParserRuleFragmentsEx EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParserRuleFragmentsExRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParserRuleFragmentsEx_in_entryRuleParserRuleFragmentsEx67);
            iv_ruleParserRuleFragmentsEx=ruleParserRuleFragmentsEx();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParserRuleFragmentsEx; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRuleFragmentsEx77); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:70:1: ruleParserRuleFragmentsEx returns [EObject current=null] : this_ParserRuleParameters_0= ruleParserRuleParameters ;
    public final EObject ruleParserRuleFragmentsEx() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRuleParameters_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:73:28: (this_ParserRuleParameters_0= ruleParserRuleParameters )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:75:5: this_ParserRuleParameters_0= ruleParserRuleParameters
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getParserRuleFragmentsExAccess().getParserRuleParametersParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleParserRuleParameters_in_ruleParserRuleFragmentsEx123);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:91:1: entryRuleParserRuleParameters returns [EObject current=null] : iv_ruleParserRuleParameters= ruleParserRuleParameters EOF ;
    public final EObject entryRuleParserRuleParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleParameters = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:92:2: (iv_ruleParserRuleParameters= ruleParserRuleParameters EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:93:2: iv_ruleParserRuleParameters= ruleParserRuleParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParserRuleParametersRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParserRuleParameters_in_entryRuleParserRuleParameters156);
            iv_ruleParserRuleParameters=ruleParserRuleParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParserRuleParameters; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRuleParameters166); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:100:1: ruleParserRuleParameters returns [EObject current=null] : ( () ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:103:28: ( ( () ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:104:1: ( () ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:104:1: ( () ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:104:2: () ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:104:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:105:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParserRuleParametersAccess().getParserRuleParametersAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:110:2: ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? ) ) ) )
            int alt9=12;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:110:3: (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= ruleScenario1[true] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:110:3: (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= ruleScenario1[true] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:111:2: otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= ruleScenario1[true] ) )
                    {
                    otherlv_1=(Token)match(input,NumberSignDigitOne,FollowSets000.FOLLOW_NumberSignDigitOne_in_ruleParserRuleParameters215); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneKeyword_1_0_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:115:1: ( (lv_scenario_2_0= ruleScenario1[true] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:116:1: (lv_scenario_2_0= ruleScenario1[true] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:116:1: (lv_scenario_2_0= ruleScenario1[true] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:117:3: lv_scenario_2_0= ruleScenario1[true]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario1ParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario1_in_ruleParserRuleParameters235);
                    lv_scenario_2_0=ruleScenario1(true);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:134:6: (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1[false] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:134:6: (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1[false] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:135:2: otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1[false] ) )
                    {
                    otherlv_3=(Token)match(input,NumberSignDigitTwo,FollowSets000.FOLLOW_NumberSignDigitTwo_in_ruleParserRuleParameters257); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitTwoKeyword_1_1_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:139:1: ( (lv_scenario_4_0= ruleScenario1[false] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:140:1: (lv_scenario_4_0= ruleScenario1[false] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:140:1: (lv_scenario_4_0= ruleScenario1[false] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:141:3: lv_scenario_4_0= ruleScenario1[false]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario1ParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario1_in_ruleParserRuleParameters277);
                    lv_scenario_4_0=ruleScenario1(false);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:158:6: (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= ruleScenario2[true] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:158:6: (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= ruleScenario2[true] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:159:2: otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= ruleScenario2[true] ) )
                    {
                    otherlv_5=(Token)match(input,NumberSignDigitThree,FollowSets000.FOLLOW_NumberSignDigitThree_in_ruleParserRuleParameters299); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitThreeKeyword_1_2_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:163:1: ( (lv_scenario_6_0= ruleScenario2[true] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:164:1: (lv_scenario_6_0= ruleScenario2[true] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:164:1: (lv_scenario_6_0= ruleScenario2[true] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:165:3: lv_scenario_6_0= ruleScenario2[true]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters319);
                    lv_scenario_6_0=ruleScenario2(true);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:182:6: (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2[false] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:182:6: (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2[false] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:183:2: otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2[false] ) )
                    {
                    otherlv_7=(Token)match(input,NumberSignDigitFour,FollowSets000.FOLLOW_NumberSignDigitFour_in_ruleParserRuleParameters341); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitFourKeyword_1_3_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:187:1: ( (lv_scenario_8_0= ruleScenario2[false] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:188:1: (lv_scenario_8_0= ruleScenario2[false] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:188:1: (lv_scenario_8_0= ruleScenario2[false] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:189:3: lv_scenario_8_0= ruleScenario2[false]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters361);
                    lv_scenario_8_0=ruleScenario2(false);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:206:6: ( ( ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:206:6: ( ( ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:206:7: ( ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= ruleScenario2[true] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:212:6: (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= ruleScenario2[true] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:213:2: otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= ruleScenario2[true] ) )
                    {
                    otherlv_9=(Token)match(input,NumberSignDigitFive,FollowSets000.FOLLOW_NumberSignDigitFive_in_ruleParserRuleParameters402); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitFiveKeyword_1_4_0_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:217:1: ( (lv_scenario_10_0= ruleScenario2[true] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:218:1: (lv_scenario_10_0= ruleScenario2[true] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:218:1: (lv_scenario_10_0= ruleScenario2[true] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:219:3: lv_scenario_10_0= ruleScenario2[true]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_4_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters422);
                    lv_scenario_10_0=ruleScenario2(true);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:236:6: ( ( ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:236:6: ( ( ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:236:7: ( ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2[false] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:242:6: (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2[false] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:243:2: otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2[false] ) )
                    {
                    otherlv_11=(Token)match(input,NumberSignDigitSix,FollowSets000.FOLLOW_NumberSignDigitSix_in_ruleParserRuleParameters464); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitSixKeyword_1_5_0_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:247:1: ( (lv_scenario_12_0= ruleScenario2[false] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:248:1: (lv_scenario_12_0= ruleScenario2[false] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:248:1: (lv_scenario_12_0= ruleScenario2[false] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:249:3: lv_scenario_12_0= ruleScenario2[false]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_5_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters484);
                    lv_scenario_12_0=ruleScenario2(false);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:266:6: (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= ruleScenario3[true] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:266:6: (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= ruleScenario3[true] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:267:2: otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= ruleScenario3[true] ) )
                    {
                    otherlv_13=(Token)match(input,NumberSignDigitSeven,FollowSets000.FOLLOW_NumberSignDigitSeven_in_ruleParserRuleParameters507); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitSevenKeyword_1_6_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:271:1: ( (lv_scenario_14_0= ruleScenario3[true] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:272:1: (lv_scenario_14_0= ruleScenario3[true] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:272:1: (lv_scenario_14_0= ruleScenario3[true] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:273:3: lv_scenario_14_0= ruleScenario3[true]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario3ParserRuleCall_1_6_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario3_in_ruleParserRuleParameters527);
                    lv_scenario_14_0=ruleScenario3(true);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:290:6: (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3[false] ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:290:6: (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3[false] ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:291:2: otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3[false] ) )
                    {
                    otherlv_15=(Token)match(input,NumberSignDigitEight,FollowSets000.FOLLOW_NumberSignDigitEight_in_ruleParserRuleParameters549); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitEightKeyword_1_7_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:295:1: ( (lv_scenario_16_0= ruleScenario3[false] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:296:1: (lv_scenario_16_0= ruleScenario3[false] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:296:1: (lv_scenario_16_0= ruleScenario3[false] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:297:3: lv_scenario_16_0= ruleScenario3[false]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario3ParserRuleCall_1_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleScenario3_in_ruleParserRuleParameters569);
                    lv_scenario_16_0=ruleScenario3(false);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:314:6: (otherlv_17= NumberSignDigitNine ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:314:6: (otherlv_17= NumberSignDigitNine ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:315:2: otherlv_17= NumberSignDigitNine ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? ) )
                    {
                    otherlv_17=(Token)match(input,NumberSignDigitNine,FollowSets000.FOLLOW_NumberSignDigitNine_in_ruleParserRuleParameters591); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitNineKeyword_1_8_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:319:1: ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? ) )
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:319:2: ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:319:2: ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:319:3: ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:324:1: (lv_scenario_18_0= ruleScenario4[true] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:325:3: lv_scenario_18_0= ruleScenario4[true]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_8_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_ruleParserRuleParameters623);
                            lv_scenario_18_0=ruleScenario4(true);

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:342:6: ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:342:6: ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:342:7: ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )?
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:342:7: ( (lv_scenario_19_0= ruleScenario2[true] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:343:1: (lv_scenario_19_0= ruleScenario2[true] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:343:1: (lv_scenario_19_0= ruleScenario2[true] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:344:3: lv_scenario_19_0= ruleScenario2[true]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_8_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters652);
                            lv_scenario_19_0=ruleScenario2(true);

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

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:360:2: (otherlv_20= Keyword )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==Keyword) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:361:2: otherlv_20= Keyword
                                    {
                                    otherlv_20=(Token)match(input,Keyword,FollowSets000.FOLLOW_Keyword_in_ruleParserRuleParameters667); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:366:6: (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:366:6: (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:367:2: otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? ) )
                    {
                    otherlv_21=(Token)match(input,NumberSignDigitOneDigitZero,FollowSets000.FOLLOW_NumberSignDigitOneDigitZero_in_ruleParserRuleParameters691); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitZeroKeyword_1_9_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:371:1: ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==Keyword) ) {
                        int LA4_1 = input.LA(2);

                        if ( (LA4_1==Keyword) ) {
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:371:2: ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:371:2: ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:371:3: ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:376:1: (lv_scenario_22_0= ruleScenario4[true] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:377:3: lv_scenario_22_0= ruleScenario4[true]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_9_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_ruleParserRuleParameters723);
                            lv_scenario_22_0=ruleScenario4(true);

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:394:6: ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:394:6: ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:394:7: ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )?
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:394:7: ( (lv_scenario_23_0= ruleScenario2[false] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:395:1: (lv_scenario_23_0= ruleScenario2[false] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:395:1: (lv_scenario_23_0= ruleScenario2[false] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:396:3: lv_scenario_23_0= ruleScenario2[false]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_9_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters752);
                            lv_scenario_23_0=ruleScenario2(false);

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

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:412:2: (otherlv_24= Keyword )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==Keyword) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:413:2: otherlv_24= Keyword
                                    {
                                    otherlv_24=(Token)match(input,Keyword,FollowSets000.FOLLOW_Keyword_in_ruleParserRuleParameters767); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:418:6: (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:418:6: (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:419:2: otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? ) )
                    {
                    otherlv_25=(Token)match(input,NumberSignDigitOneDigitOne,FollowSets000.FOLLOW_NumberSignDigitOneDigitOne_in_ruleParserRuleParameters791); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitOneKeyword_1_10_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:423:1: ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==Keyword) ) {
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
                    else if ( (LA6_0==RULE_ID) ) {
                        int LA6_2 = input.LA(2);

                        if ( (LA6_2==Keyword) ) {
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:423:2: ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:423:2: ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:423:3: ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:428:1: (lv_scenario_26_0= ruleScenario4[false] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:429:3: lv_scenario_26_0= ruleScenario4[false]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_10_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_ruleParserRuleParameters823);
                            lv_scenario_26_0=ruleScenario4(false);

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:446:6: ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:446:6: ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:446:7: ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )?
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:446:7: ( (lv_scenario_27_0= ruleScenario2[true] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:447:1: (lv_scenario_27_0= ruleScenario2[true] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:447:1: (lv_scenario_27_0= ruleScenario2[true] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:448:3: lv_scenario_27_0= ruleScenario2[true]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_10_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters852);
                            lv_scenario_27_0=ruleScenario2(true);

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

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:464:2: (otherlv_28= Keyword )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==Keyword) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:465:2: otherlv_28= Keyword
                                    {
                                    otherlv_28=(Token)match(input,Keyword,FollowSets000.FOLLOW_Keyword_in_ruleParserRuleParameters867); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:470:6: (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:470:6: (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:471:2: otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? ) )
                    {
                    otherlv_29=(Token)match(input,NumberSignDigitOneDigitTwo,FollowSets000.FOLLOW_NumberSignDigitOneDigitTwo_in_ruleParserRuleParameters891); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getParserRuleParametersAccess().getNumberSignDigitOneDigitTwoKeyword_1_11_0());
                          
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:475:1: ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==Keyword) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==Keyword) ) {
                            int LA8_3 = input.LA(3);

                            if ( (synpred6_InternalParametersTestLanguageExParser()) ) {
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

                        if ( (LA8_2==Keyword) ) {
                            int LA8_3 = input.LA(3);

                            if ( (synpred6_InternalParametersTestLanguageExParser()) ) {
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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:475:2: ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:475:2: ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:475:3: ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:480:1: (lv_scenario_30_0= ruleScenario4[false] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:481:3: lv_scenario_30_0= ruleScenario4[false]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_11_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_ruleParserRuleParameters923);
                            lv_scenario_30_0=ruleScenario4(false);

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:498:6: ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:498:6: ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:498:7: ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )?
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:498:7: ( (lv_scenario_31_0= ruleScenario2[false] ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:499:1: (lv_scenario_31_0= ruleScenario2[false] )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:499:1: (lv_scenario_31_0= ruleScenario2[false] )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:500:3: lv_scenario_31_0= ruleScenario2[false]
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_11_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_ruleParserRuleParameters952);
                            lv_scenario_31_0=ruleScenario2(false);

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

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:516:2: (otherlv_32= Keyword )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==Keyword) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:517:2: otherlv_32= Keyword
                                    {
                                    otherlv_32=(Token)match(input,Keyword,FollowSets000.FOLLOW_Keyword_in_ruleParserRuleParameters967); if (state.failed) return current;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:529:1: entryRuleScenario1 returns [EObject current=null] : iv_ruleScenario1= ruleScenario1[false] EOF ;
    public final EObject entryRuleScenario1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:530:2: (iv_ruleScenario1= ruleScenario1[false] EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:531:2: iv_ruleScenario1= ruleScenario1[false] EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario1Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_in_entryRuleScenario11007);
            iv_ruleScenario1=ruleScenario1(false);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario1; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario11018); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:538:1: ruleScenario1[boolean p_Param] returns [EObject current=null] : ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleScenario1(boolean p_Param) throws RecognitionException {
        EObject current = null;

        Token lv_first_0_0=null;
        Token lv_second_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:541:28: ( ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:542:1: ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:542:1: ( ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) ) | ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:542:2: ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:542:2: ({...}? => ( ( (lv_first_0_0= RULE_ID ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:542:3: {...}? => ( ( (lv_first_0_0= RULE_ID ) ) )
                    {
                    if ( ! p_Param ) {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        throw new FailedPredicateException(input, "ruleScenario1", "p_Param");
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:542:15: ( ( (lv_first_0_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:542:16: ( (lv_first_0_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:542:16: ( (lv_first_0_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:543:1: (lv_first_0_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:543:1: (lv_first_0_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:544:3: lv_first_0_0= RULE_ID
                    {
                    lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleScenario11066); if (state.failed) return current;
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


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:562:6: ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:562:6: ({...}? => ( ( (lv_second_1_0= RULE_ID ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:562:7: {...}? => ( ( (lv_second_1_0= RULE_ID ) ) )
                    {
                    if ( p_Param ) {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        throw new FailedPredicateException(input, "ruleScenario1", "!p_Param");
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:562:20: ( ( (lv_second_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:562:21: ( (lv_second_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:562:21: ( (lv_second_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:563:1: (lv_second_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:563:1: (lv_second_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:564:3: lv_second_1_0= RULE_ID
                    {
                    lv_second_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleScenario11101); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_second_1_0, grammarAccess.getScenario1Access().getSecondIDTerminalRuleCall_1_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScenario1Rule());
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
    // $ANTLR end "ruleScenario1"


    // $ANTLR start "entryRuleScenario2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:589:1: entryRuleScenario2 returns [EObject current=null] : iv_ruleScenario2= ruleScenario2[false] EOF ;
    public final EObject entryRuleScenario2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:590:2: (iv_ruleScenario2= ruleScenario2[false] EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:591:2: iv_ruleScenario2= ruleScenario2[false] EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_entryRuleScenario21144);
            iv_ruleScenario2=ruleScenario2(false);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario21155); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:598:1: ruleScenario2[boolean p_AllowKeyword] returns [EObject current=null] : ( (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] ) ) ;
    public final EObject ruleScenario2(boolean p_AllowKeyword) throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:601:28: ( ( (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:602:1: ( (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:602:1: ( (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:603:1: (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:603:1: (lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword] )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:604:3: lv_first_0_0= ruleIdOrKeyword[$ruleScenario2.p_AllowKeyword]
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario2Access().getFirstIdOrKeywordParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_ruleScenario21202);
            lv_first_0_0=ruleIdOrKeyword(p_AllowKeyword);

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


    // $ANTLR start "entryRuleScenario3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:628:1: entryRuleScenario3 returns [EObject current=null] : iv_ruleScenario3= ruleScenario3[false] EOF ;
    public final EObject entryRuleScenario3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:629:2: (iv_ruleScenario3= ruleScenario3[false] EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:630:2: iv_ruleScenario3= ruleScenario3[false] EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario3Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario3_in_entryRuleScenario31237);
            iv_ruleScenario3=ruleScenario3(false);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario3; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario31248); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:637:1: ruleScenario3[boolean p_AllowKeyword] returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) ) | ( (lv_second_1_0= Keyword ) ) ) ;
    public final EObject ruleScenario3(boolean p_AllowKeyword) throws RecognitionException {
        EObject current = null;

        Token lv_second_1_0=null;
        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:640:28: ( ( ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) ) | ( (lv_second_1_0= Keyword ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:641:1: ( ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) ) | ( (lv_second_1_0= Keyword ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:641:1: ( ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) ) | ( (lv_second_1_0= Keyword ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Keyword) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred7_InternalParametersTestLanguageExParser(p_AllowKeyword)) ) {
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
            else if ( (LA11_0==RULE_ID) && (synpred7_InternalParametersTestLanguageExParser(p_AllowKeyword))) {
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:641:2: ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:641:2: ( ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:641:3: ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )=> (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:646:1: (lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:647:3: lv_first_0_0= ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScenario3Access().getFirstIdOrKeywordParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_ruleScenario31307);
                    lv_first_0_0=ruleIdOrKeyword(p_AllowKeyword);

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:664:6: ( (lv_second_1_0= Keyword ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:664:6: ( (lv_second_1_0= Keyword ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:665:1: (lv_second_1_0= Keyword )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:665:1: (lv_second_1_0= Keyword )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:666:3: lv_second_1_0= Keyword
                    {
                    lv_second_1_0=(Token)match(input,Keyword,FollowSets000.FOLLOW_Keyword_in_ruleScenario31333); if (state.failed) return current;
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


    // $ANTLR start "entryRuleScenario4"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:688:1: entryRuleScenario4 returns [EObject current=null] : iv_ruleScenario4= ruleScenario4[false] EOF ;
    public final EObject entryRuleScenario4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:689:2: (iv_ruleScenario4= ruleScenario4[false] EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:690:2: iv_ruleScenario4= ruleScenario4[false] EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario4Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleScenario4_in_entryRuleScenario41379);
            iv_ruleScenario4=ruleScenario4(false);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario4; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario41390); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:697:1: ruleScenario4[boolean p_AllowKeyword] returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= Keyword ) ;
    public final EObject ruleScenario4(boolean p_AllowKeyword) throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_second_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:700:28: ( ( ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= Keyword ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:701:1: ( ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= Keyword )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:701:1: ( ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= Keyword )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:701:2: ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) ) otherlv_1= Keyword
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:701:2: ( ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:701:3: ( ( ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] ) )=> (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:706:1: (lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword] )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:707:3: lv_second_0_0= ruleIdOrKeyword[$ruleScenario4.p_AllowKeyword]
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario4Access().getSecondIdOrKeywordParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_ruleScenario41449);
            lv_second_0_0=ruleIdOrKeyword(p_AllowKeyword);

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

            otherlv_1=(Token)match(input,Keyword,FollowSets000.FOLLOW_Keyword_in_ruleScenario41463); if (state.failed) return current;
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


    // $ANTLR start "entryRuleIdOrKeyword"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:736:1: entryRuleIdOrKeyword returns [String current=null] : iv_ruleIdOrKeyword= ruleIdOrKeyword[false] EOF ;
    public final String entryRuleIdOrKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrKeyword = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:737:1: (iv_ruleIdOrKeyword= ruleIdOrKeyword[false] EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:738:2: iv_ruleIdOrKeyword= ruleIdOrKeyword[false] EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrKeywordRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_entryRuleIdOrKeyword1498);
            iv_ruleIdOrKeyword=ruleIdOrKeyword(false);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrKeyword.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdOrKeyword1510); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:745:1: ruleIdOrKeyword[boolean p_Keyword] returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ({...}? => (kw= Keyword ) ) | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIdOrKeyword(boolean p_Keyword) throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:749:6: ( ( ({...}? => (kw= Keyword ) ) | this_ID_1= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:750:1: ( ({...}? => (kw= Keyword ) ) | this_ID_1= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:750:1: ( ({...}? => (kw= Keyword ) ) | this_ID_1= RULE_ID )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( LA12_0 == Keyword && p_Keyword ) {
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:750:2: ({...}? => (kw= Keyword ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:750:2: ({...}? => (kw= Keyword ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:750:3: {...}? => (kw= Keyword )
                    {
                    if ( ! p_Keyword ) {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        throw new FailedPredicateException(input, "ruleIdOrKeyword", "p_Keyword");
                    }
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:750:17: (kw= Keyword )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:751:2: kw= Keyword
                    {
                    kw=(Token)match(input,Keyword,FollowSets000.FOLLOW_Keyword_in_ruleIdOrKeyword1554); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrKeywordAccess().getKeywordKeyword_0_0()); 
                          
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:758:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdOrKeyword1578); if (state.failed) return current;
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

    // $ANTLR start synpred1_InternalParametersTestLanguageExParser
    public final void synpred1_InternalParametersTestLanguageExParser_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:206:7: ( ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:206:8: ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:206:8: ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:207:1: NumberSignDigitFive ( ( ruleScenario2[true] ) )
        {
        match(input,NumberSignDigitFive,FollowSets000.FOLLOW_NumberSignDigitFive_in_synpred1_InternalParametersTestLanguageExParser382); if (state.failed) return ;
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:208:1: ( ( ruleScenario2[true] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:209:1: ( ruleScenario2[true] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:209:1: ( ruleScenario2[true] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:210:1: ruleScenario2[true]
        {
        pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_synpred1_InternalParametersTestLanguageExParser388);
        ruleScenario2(true);

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
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:236:7: ( ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:236:8: ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:236:8: ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:237:1: NumberSignDigitSix ( ( ruleScenario2[false] ) )
        {
        match(input,NumberSignDigitSix,FollowSets000.FOLLOW_NumberSignDigitSix_in_synpred2_InternalParametersTestLanguageExParser444); if (state.failed) return ;
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:238:1: ( ( ruleScenario2[false] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:239:1: ( ruleScenario2[false] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:239:1: ( ruleScenario2[false] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:240:1: ruleScenario2[false]
        {
        pushFollow(FollowSets000.FOLLOW_ruleScenario2_in_synpred2_InternalParametersTestLanguageExParser450);
        ruleScenario2(false);

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
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:319:3: ( ( ruleIdOrKeyword[true] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:320:1: ( ruleIdOrKeyword[true] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:320:1: ( ruleIdOrKeyword[true] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:321:1: ruleIdOrKeyword[true]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred3_InternalParametersTestLanguageExParser605);
        ruleIdOrKeyword(true);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalParametersTestLanguageExParser

    // $ANTLR start synpred4_InternalParametersTestLanguageExParser
    public final void synpred4_InternalParametersTestLanguageExParser_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:371:3: ( ( ruleIdOrKeyword[true] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:372:1: ( ruleIdOrKeyword[true] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:372:1: ( ruleIdOrKeyword[true] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:373:1: ruleIdOrKeyword[true]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred4_InternalParametersTestLanguageExParser705);
        ruleIdOrKeyword(true);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalParametersTestLanguageExParser

    // $ANTLR start synpred5_InternalParametersTestLanguageExParser
    public final void synpred5_InternalParametersTestLanguageExParser_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:423:3: ( ( ruleIdOrKeyword[false] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:424:1: ( ruleIdOrKeyword[false] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:424:1: ( ruleIdOrKeyword[false] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:425:1: ruleIdOrKeyword[false]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred5_InternalParametersTestLanguageExParser805);
        ruleIdOrKeyword(false);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalParametersTestLanguageExParser

    // $ANTLR start synpred6_InternalParametersTestLanguageExParser
    public final void synpred6_InternalParametersTestLanguageExParser_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:475:3: ( ( ruleIdOrKeyword[false] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:476:1: ( ruleIdOrKeyword[false] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:476:1: ( ruleIdOrKeyword[false] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:477:1: ruleIdOrKeyword[false]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred6_InternalParametersTestLanguageExParser905);
        ruleIdOrKeyword(false);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalParametersTestLanguageExParser

    // $ANTLR start synpred7_InternalParametersTestLanguageExParser
    public final void synpred7_InternalParametersTestLanguageExParser_fragment(boolean p_AllowKeyword) throws RecognitionException {   
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:641:3: ( ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:642:1: ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:642:1: ( ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword] )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/parameters/parser/antlr/internal/InternalParametersTestLanguageExParser.g:643:1: ruleIdOrKeyword[$ruleScenario3.p_AllowKeyword]
        {
        pushFollow(FollowSets000.FOLLOW_ruleIdOrKeyword_in_synpred7_InternalParametersTestLanguageExParser1289);
        ruleIdOrKeyword(p_AllowKeyword);

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalParametersTestLanguageExParser

    // Delegated rules

    public final boolean synpred7_InternalParametersTestLanguageExParser(boolean p_AllowKeyword) {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalParametersTestLanguageExParser_fragment(p_AllowKeyword); // can never throw exception
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
            return "110:2: ( (otherlv_1= NumberSignDigitOne ( (lv_scenario_2_0= ruleScenario1[true] ) ) ) | (otherlv_3= NumberSignDigitTwo ( (lv_scenario_4_0= ruleScenario1[false] ) ) ) | (otherlv_5= NumberSignDigitThree ( (lv_scenario_6_0= ruleScenario2[true] ) ) ) | (otherlv_7= NumberSignDigitFour ( (lv_scenario_8_0= ruleScenario2[false] ) ) ) | ( ( ( NumberSignDigitFive ( ( ruleScenario2[true] ) ) ) )=> (otherlv_9= NumberSignDigitFive ( (lv_scenario_10_0= ruleScenario2[true] ) ) ) ) | ( ( ( NumberSignDigitSix ( ( ruleScenario2[false] ) ) ) )=> (otherlv_11= NumberSignDigitSix ( (lv_scenario_12_0= ruleScenario2[false] ) ) ) ) | (otherlv_13= NumberSignDigitSeven ( (lv_scenario_14_0= ruleScenario3[true] ) ) ) | (otherlv_15= NumberSignDigitEight ( (lv_scenario_16_0= ruleScenario3[false] ) ) ) | (otherlv_17= NumberSignDigitNine ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_18_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_19_0= ruleScenario2[true] ) ) (otherlv_20= Keyword )? ) ) ) | (otherlv_21= NumberSignDigitOneDigitZero ( ( ( ( ruleIdOrKeyword[true] ) )=> (lv_scenario_22_0= ruleScenario4[true] ) ) | ( ( (lv_scenario_23_0= ruleScenario2[false] ) ) (otherlv_24= Keyword )? ) ) ) | (otherlv_25= NumberSignDigitOneDigitOne ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_26_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_27_0= ruleScenario2[true] ) ) (otherlv_28= Keyword )? ) ) ) | (otherlv_29= NumberSignDigitOneDigitTwo ( ( ( ( ruleIdOrKeyword[false] ) )=> (lv_scenario_30_0= ruleScenario4[false] ) ) | ( ( (lv_scenario_31_0= ruleScenario2[false] ) ) (otherlv_32= Keyword )? ) ) ) )";
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
        public static final BitSet FOLLOW_ruleParserRuleFragmentsEx_in_entryRuleParserRuleFragmentsEx67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRuleFragmentsEx77 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRuleParameters_in_ruleParserRuleFragmentsEx123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRuleParameters_in_entryRuleParserRuleParameters156 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRuleParameters166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitOne_in_ruleParserRuleParameters215 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleScenario1_in_ruleParserRuleParameters235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitTwo_in_ruleParserRuleParameters257 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleScenario1_in_ruleParserRuleParameters277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitThree_in_ruleParserRuleParameters299 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitFour_in_ruleParserRuleParameters341 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitFive_in_ruleParserRuleParameters402 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitSix_in_ruleParserRuleParameters464 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitSeven_in_ruleParserRuleParameters507 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleScenario3_in_ruleParserRuleParameters527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitEight_in_ruleParserRuleParameters549 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleScenario3_in_ruleParserRuleParameters569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitNine_in_ruleParserRuleParameters591 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleScenario4_in_ruleParserRuleParameters623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters652 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_Keyword_in_ruleParserRuleParameters667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitOneDigitZero_in_ruleParserRuleParameters691 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleScenario4_in_ruleParserRuleParameters723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters752 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_Keyword_in_ruleParserRuleParameters767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitOneDigitOne_in_ruleParserRuleParameters791 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleScenario4_in_ruleParserRuleParameters823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters852 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_Keyword_in_ruleParserRuleParameters867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitOneDigitTwo_in_ruleParserRuleParameters891 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleScenario4_in_ruleParserRuleParameters923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_ruleParserRuleParameters952 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_Keyword_in_ruleParserRuleParameters967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_in_entryRuleScenario11007 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario11018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleScenario11066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleScenario11101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_in_entryRuleScenario21144 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario21155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_ruleScenario21202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario3_in_entryRuleScenario31237 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario31248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_ruleScenario31307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_Keyword_in_ruleScenario31333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario4_in_entryRuleScenario41379 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario41390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_ruleScenario41449 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_Keyword_in_ruleScenario41463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_entryRuleIdOrKeyword1498 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdOrKeyword1510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_Keyword_in_ruleIdOrKeyword1554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdOrKeyword1578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitFive_in_synpred1_InternalParametersTestLanguageExParser382 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleScenario2_in_synpred1_InternalParametersTestLanguageExParser388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_NumberSignDigitSix_in_synpred2_InternalParametersTestLanguageExParser444 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleScenario2_in_synpred2_InternalParametersTestLanguageExParser450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred3_InternalParametersTestLanguageExParser605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred4_InternalParametersTestLanguageExParser705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred5_InternalParametersTestLanguageExParser805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred6_InternalParametersTestLanguageExParser905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdOrKeyword_in_synpred7_InternalParametersTestLanguageExParser1289 = new BitSet(new long[]{0x0000000000000002L});
    }


}