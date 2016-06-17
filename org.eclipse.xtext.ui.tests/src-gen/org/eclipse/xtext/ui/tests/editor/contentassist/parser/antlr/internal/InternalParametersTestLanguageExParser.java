package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ParametersTestLanguageExGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalParametersTestLanguageExParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'#3'", "'#4'", "'#5'", "'#6'", "'#7'", "'#8'", "'#9'", "'trailing'", "'#10'", "'#11'", "'#12'", "'#13'", "'#14'", "'scenario3'", "'scenario4'", "'scenario5'", "'include'", "'keyword'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
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


        public InternalParametersTestLanguageExParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalParametersTestLanguageExParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalParametersTestLanguageExParser.tokenNames; }
    public String getGrammarFileName() { return "InternalParametersTestLanguageEx.g"; }



     	private ParametersTestLanguageExGrammarAccess grammarAccess;
     	
        public InternalParametersTestLanguageExParser(TokenStream input, ParametersTestLanguageExGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ParserRuleParameters";	
       	}
       	
       	@Override
       	protected ParametersTestLanguageExGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleParserRuleParameters"
    // InternalParametersTestLanguageEx.g:67:1: entryRuleParserRuleParameters returns [EObject current=null] : iv_ruleParserRuleParameters= ruleParserRuleParameters EOF ;
    public final EObject entryRuleParserRuleParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRuleParameters = null;


        try {
            // InternalParametersTestLanguageEx.g:68:2: (iv_ruleParserRuleParameters= ruleParserRuleParameters EOF )
            // InternalParametersTestLanguageEx.g:69:2: iv_ruleParserRuleParameters= ruleParserRuleParameters EOF
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
    // InternalParametersTestLanguageEx.g:76:1: ruleParserRuleParameters returns [EObject current=null] : this_ParserRuleParameters_0= superParserRuleParameters ;
    public final EObject ruleParserRuleParameters() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRuleParameters_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:79:28: (this_ParserRuleParameters_0= superParserRuleParameters )
            // InternalParametersTestLanguageEx.g:81:5: this_ParserRuleParameters_0= superParserRuleParameters
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getParserRuleParametersAccess().getParserRuleParametersParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ParserRuleParameters_0=superParserRuleParameters();

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
    // $ANTLR end "ruleParserRuleParameters"


    // $ANTLR start "entryRuleScenario1"
    // InternalParametersTestLanguageEx.g:97:1: entryRuleScenario1 returns [EObject current=null] : iv_ruleScenario1= ruleScenario1 EOF ;
    public final EObject entryRuleScenario1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario1 = null;


        try {
            // InternalParametersTestLanguageEx.g:98:2: (iv_ruleScenario1= ruleScenario1 EOF )
            // InternalParametersTestLanguageEx.g:99:2: iv_ruleScenario1= ruleScenario1 EOF
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
    // InternalParametersTestLanguageEx.g:106:1: ruleScenario1 returns [EObject current=null] : this_Scenario1_0= superScenario1 ;
    public final EObject ruleScenario1() throws RecognitionException {
        EObject current = null;

        EObject this_Scenario1_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:109:28: (this_Scenario1_0= superScenario1 )
            // InternalParametersTestLanguageEx.g:111:5: this_Scenario1_0= superScenario1
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getScenario1Access().getScenario1ParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Scenario1_0=superScenario1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Scenario1_0; 
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
    // $ANTLR end "ruleScenario1"


    // $ANTLR start "norm1_Scenario1"
    // InternalParametersTestLanguageEx.g:128:1: norm1_Scenario1 returns [EObject current=null] : this_Scenario1_0= normSuper1_Scenario1 ;
    public final EObject norm1_Scenario1() throws RecognitionException {
        EObject current = null;

        EObject this_Scenario1_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:131:28: (this_Scenario1_0= normSuper1_Scenario1 )
            // InternalParametersTestLanguageEx.g:133:5: this_Scenario1_0= normSuper1_Scenario1
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getScenario1Access().getScenario1ParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Scenario1_0=normSuper1_Scenario1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Scenario1_0; 
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
    // $ANTLR end "norm1_Scenario1"


    // $ANTLR start "entrySuperParserRuleParameters"
    // InternalParametersTestLanguageEx.g:149:1: entrySuperParserRuleParameters returns [EObject current=null] : iv_superParserRuleParameters= superParserRuleParameters EOF ;
    public final EObject entrySuperParserRuleParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_superParserRuleParameters = null;


        try {
            // InternalParametersTestLanguageEx.g:150:2: (iv_superParserRuleParameters= superParserRuleParameters EOF )
            // InternalParametersTestLanguageEx.g:151:2: iv_superParserRuleParameters= superParserRuleParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersRule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entrySuperParserRuleParameters"


    // $ANTLR start "superParserRuleParameters"
    // InternalParametersTestLanguageEx.g:158:1: superParserRuleParameters returns [EObject current=null] : ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? ) ) ) | (otherlv_33= '#13' ( (lv_scenario_34_0= ruleScenario5 ) ) ) | (otherlv_35= '#14' ( (lv_scenario_36_0= norm1_Scenario5 ) ) ) ) ) ;
    public final EObject superParserRuleParameters() throws RecognitionException {
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
        Token otherlv_33=null;
        Token otherlv_35=null;
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

        EObject lv_scenario_34_0 = null;

        EObject lv_scenario_36_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:161:28: ( ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? ) ) ) | (otherlv_33= '#13' ( (lv_scenario_34_0= ruleScenario5 ) ) ) | (otherlv_35= '#14' ( (lv_scenario_36_0= norm1_Scenario5 ) ) ) ) ) )
            // InternalParametersTestLanguageEx.g:162:1: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? ) ) ) | (otherlv_33= '#13' ( (lv_scenario_34_0= ruleScenario5 ) ) ) | (otherlv_35= '#14' ( (lv_scenario_36_0= norm1_Scenario5 ) ) ) ) )
            {
            // InternalParametersTestLanguageEx.g:162:1: ( () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? ) ) ) | (otherlv_33= '#13' ( (lv_scenario_34_0= ruleScenario5 ) ) ) | (otherlv_35= '#14' ( (lv_scenario_36_0= norm1_Scenario5 ) ) ) ) )
            // InternalParametersTestLanguageEx.g:162:2: () ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? ) ) ) | (otherlv_33= '#13' ( (lv_scenario_34_0= ruleScenario5 ) ) ) | (otherlv_35= '#14' ( (lv_scenario_36_0= norm1_Scenario5 ) ) ) )
            {
            // InternalParametersTestLanguageEx.g:162:2: ()
            // InternalParametersTestLanguageEx.g:163:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getParserRuleParametersAction_0(),
                          current);
                  
            }

            }

            // InternalParametersTestLanguageEx.g:168:2: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? ) ) ) | (otherlv_33= '#13' ( (lv_scenario_34_0= ruleScenario5 ) ) ) | (otherlv_35= '#14' ( (lv_scenario_36_0= norm1_Scenario5 ) ) ) )
            int alt9=14;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalParametersTestLanguageEx.g:168:3: (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:168:3: (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) )
                    // InternalParametersTestLanguageEx.g:168:5: otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    {
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneKeyword_1_0_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:172:1: ( (lv_scenario_2_0= norm1_Scenario1 ) )
                    // InternalParametersTestLanguageEx.g:173:1: (lv_scenario_2_0= norm1_Scenario1 )
                    {
                    // InternalParametersTestLanguageEx.g:173:1: (lv_scenario_2_0= norm1_Scenario1 )
                    // InternalParametersTestLanguageEx.g:174:3: lv_scenario_2_0= norm1_Scenario1
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario1ParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_2_0=norm1_Scenario1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                      	        }
                             		set(
                             			current, 
                             			"scenario",
                              		lv_scenario_2_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguageEx.Scenario1");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguageEx.g:191:6: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:191:6: (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) )
                    // InternalParametersTestLanguageEx.g:191:8: otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) )
                    {
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitTwoKeyword_1_1_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:195:1: ( (lv_scenario_4_0= ruleScenario1 ) )
                    // InternalParametersTestLanguageEx.g:196:1: (lv_scenario_4_0= ruleScenario1 )
                    {
                    // InternalParametersTestLanguageEx.g:196:1: (lv_scenario_4_0= ruleScenario1 )
                    // InternalParametersTestLanguageEx.g:197:3: lv_scenario_4_0= ruleScenario1
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario1ParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_4_0=ruleScenario1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                      	        }
                             		set(
                             			current, 
                             			"scenario",
                              		lv_scenario_4_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguageEx.Scenario1");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalParametersTestLanguageEx.g:214:6: (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:214:6: (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) )
                    // InternalParametersTestLanguageEx.g:214:8: otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    {
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitThreeKeyword_1_2_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:218:1: ( (lv_scenario_6_0= norm1_Scenario2 ) )
                    // InternalParametersTestLanguageEx.g:219:1: (lv_scenario_6_0= norm1_Scenario2 )
                    {
                    // InternalParametersTestLanguageEx.g:219:1: (lv_scenario_6_0= norm1_Scenario2 )
                    // InternalParametersTestLanguageEx.g:220:3: lv_scenario_6_0= norm1_Scenario2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_6_0=norm1_Scenario2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                      	        }
                             		set(
                             			current, 
                             			"scenario",
                              		lv_scenario_6_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario2");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalParametersTestLanguageEx.g:237:6: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:237:6: (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) )
                    // InternalParametersTestLanguageEx.g:237:8: otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) )
                    {
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitFourKeyword_1_3_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:241:1: ( (lv_scenario_8_0= ruleScenario2 ) )
                    // InternalParametersTestLanguageEx.g:242:1: (lv_scenario_8_0= ruleScenario2 )
                    {
                    // InternalParametersTestLanguageEx.g:242:1: (lv_scenario_8_0= ruleScenario2 )
                    // InternalParametersTestLanguageEx.g:243:3: lv_scenario_8_0= ruleScenario2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_8_0=ruleScenario2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                      	        }
                             		set(
                             			current, 
                             			"scenario",
                              		lv_scenario_8_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario2");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalParametersTestLanguageEx.g:260:6: ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:260:6: ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) )
                    // InternalParametersTestLanguageEx.g:260:7: ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:265:6: (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) )
                    // InternalParametersTestLanguageEx.g:265:8: otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    {
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitFiveKeyword_1_4_0_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:269:1: ( (lv_scenario_10_0= norm1_Scenario2 ) )
                    // InternalParametersTestLanguageEx.g:270:1: (lv_scenario_10_0= norm1_Scenario2 )
                    {
                    // InternalParametersTestLanguageEx.g:270:1: (lv_scenario_10_0= norm1_Scenario2 )
                    // InternalParametersTestLanguageEx.g:271:3: lv_scenario_10_0= norm1_Scenario2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_4_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_10_0=norm1_Scenario2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                      	        }
                             		set(
                             			current, 
                             			"scenario",
                              		lv_scenario_10_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario2");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalParametersTestLanguageEx.g:288:6: ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:288:6: ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) )
                    // InternalParametersTestLanguageEx.g:288:7: ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:293:6: (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) )
                    // InternalParametersTestLanguageEx.g:293:8: otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) )
                    {
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitSixKeyword_1_5_0_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:297:1: ( (lv_scenario_12_0= ruleScenario2 ) )
                    // InternalParametersTestLanguageEx.g:298:1: (lv_scenario_12_0= ruleScenario2 )
                    {
                    // InternalParametersTestLanguageEx.g:298:1: (lv_scenario_12_0= ruleScenario2 )
                    // InternalParametersTestLanguageEx.g:299:3: lv_scenario_12_0= ruleScenario2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_5_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_12_0=ruleScenario2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                      	        }
                             		set(
                             			current, 
                             			"scenario",
                              		lv_scenario_12_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario2");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalParametersTestLanguageEx.g:316:6: (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:316:6: (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) )
                    // InternalParametersTestLanguageEx.g:316:8: otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    {
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitSevenKeyword_1_6_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:320:1: ( (lv_scenario_14_0= norm1_Scenario3 ) )
                    // InternalParametersTestLanguageEx.g:321:1: (lv_scenario_14_0= norm1_Scenario3 )
                    {
                    // InternalParametersTestLanguageEx.g:321:1: (lv_scenario_14_0= norm1_Scenario3 )
                    // InternalParametersTestLanguageEx.g:322:3: lv_scenario_14_0= norm1_Scenario3
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario3ParserRuleCall_1_6_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_14_0=norm1_Scenario3();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                      	        }
                             		set(
                             			current, 
                             			"scenario",
                              		lv_scenario_14_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario3");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalParametersTestLanguageEx.g:339:6: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:339:6: (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) )
                    // InternalParametersTestLanguageEx.g:339:8: otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) )
                    {
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitEightKeyword_1_7_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:343:1: ( (lv_scenario_16_0= ruleScenario3 ) )
                    // InternalParametersTestLanguageEx.g:344:1: (lv_scenario_16_0= ruleScenario3 )
                    {
                    // InternalParametersTestLanguageEx.g:344:1: (lv_scenario_16_0= ruleScenario3 )
                    // InternalParametersTestLanguageEx.g:345:3: lv_scenario_16_0= ruleScenario3
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario3ParserRuleCall_1_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_16_0=ruleScenario3();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                      	        }
                             		set(
                             			current, 
                             			"scenario",
                              		lv_scenario_16_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario3");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalParametersTestLanguageEx.g:362:6: (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:362:6: (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? ) ) )
                    // InternalParametersTestLanguageEx.g:362:8: otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? ) )
                    {
                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitNineKeyword_1_8_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:366:1: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? ) )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==30) ) {
                        int LA2_1 = input.LA(2);

                        if ( (LA2_1==EOF||LA2_1==20) ) {
                            alt2=2;
                        }
                        else if ( (LA2_1==27) && (synpred3_InternalParametersTestLanguageEx())) {
                            alt2=1;
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

                        if ( (LA2_2==27) && (synpred3_InternalParametersTestLanguageEx())) {
                            alt2=1;
                        }
                        else if ( (LA2_2==EOF||LA2_2==20) ) {
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
                            // InternalParametersTestLanguageEx.g:366:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            {
                            // InternalParametersTestLanguageEx.g:366:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) )
                            // InternalParametersTestLanguageEx.g:366:3: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 )
                            {
                            // InternalParametersTestLanguageEx.g:371:1: (lv_scenario_18_0= norm1_Scenario4 )
                            // InternalParametersTestLanguageEx.g:372:3: lv_scenario_18_0= norm1_Scenario4
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_8_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_18_0=norm1_Scenario4();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"scenario",
                                      		lv_scenario_18_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario4");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalParametersTestLanguageEx.g:389:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? )
                            {
                            // InternalParametersTestLanguageEx.g:389:6: ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? )
                            // InternalParametersTestLanguageEx.g:389:7: ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )?
                            {
                            // InternalParametersTestLanguageEx.g:389:7: ( (lv_scenario_19_0= norm1_Scenario2 ) )
                            // InternalParametersTestLanguageEx.g:390:1: (lv_scenario_19_0= norm1_Scenario2 )
                            {
                            // InternalParametersTestLanguageEx.g:390:1: (lv_scenario_19_0= norm1_Scenario2 )
                            // InternalParametersTestLanguageEx.g:391:3: lv_scenario_19_0= norm1_Scenario2
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_8_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_7);
                            lv_scenario_19_0=norm1_Scenario2();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"scenario",
                                      		lv_scenario_19_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario2");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalParametersTestLanguageEx.g:407:2: (otherlv_20= 'trailing' )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==20) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // InternalParametersTestLanguageEx.g:407:4: otherlv_20= 'trailing'
                                    {
                                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_20, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_8_1_1_1());
                                          
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
                    // InternalParametersTestLanguageEx.g:412:6: (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:412:6: (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? ) ) )
                    // InternalParametersTestLanguageEx.g:412:8: otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? ) )
                    {
                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitZeroKeyword_1_9_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:416:1: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==30) && (synpred4_InternalParametersTestLanguageEx())) {
                        alt4=1;
                    }
                    else if ( (LA4_0==RULE_ID) ) {
                        int LA4_2 = input.LA(2);

                        if ( (LA4_2==27) && (synpred4_InternalParametersTestLanguageEx())) {
                            alt4=1;
                        }
                        else if ( (LA4_2==EOF||LA4_2==20) ) {
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
                            // InternalParametersTestLanguageEx.g:416:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            {
                            // InternalParametersTestLanguageEx.g:416:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) )
                            // InternalParametersTestLanguageEx.g:416:3: ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 )
                            {
                            // InternalParametersTestLanguageEx.g:421:1: (lv_scenario_22_0= norm1_Scenario4 )
                            // InternalParametersTestLanguageEx.g:422:3: lv_scenario_22_0= norm1_Scenario4
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_9_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_22_0=norm1_Scenario4();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"scenario",
                                      		lv_scenario_22_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario4");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalParametersTestLanguageEx.g:439:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? )
                            {
                            // InternalParametersTestLanguageEx.g:439:6: ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? )
                            // InternalParametersTestLanguageEx.g:439:7: ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )?
                            {
                            // InternalParametersTestLanguageEx.g:439:7: ( (lv_scenario_23_0= ruleScenario2 ) )
                            // InternalParametersTestLanguageEx.g:440:1: (lv_scenario_23_0= ruleScenario2 )
                            {
                            // InternalParametersTestLanguageEx.g:440:1: (lv_scenario_23_0= ruleScenario2 )
                            // InternalParametersTestLanguageEx.g:441:3: lv_scenario_23_0= ruleScenario2
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_9_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_7);
                            lv_scenario_23_0=ruleScenario2();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"scenario",
                                      		lv_scenario_23_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario2");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalParametersTestLanguageEx.g:457:2: (otherlv_24= 'trailing' )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==20) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // InternalParametersTestLanguageEx.g:457:4: otherlv_24= 'trailing'
                                    {
                                    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_24, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_9_1_1_1());
                                          
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
                    // InternalParametersTestLanguageEx.g:462:6: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:462:6: (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? ) ) )
                    // InternalParametersTestLanguageEx.g:462:8: otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? ) )
                    {
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitOneKeyword_1_10_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:466:1: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==27) && (synpred5_InternalParametersTestLanguageEx())) {
                            alt6=1;
                        }
                        else if ( (LA6_1==EOF||LA6_1==20) ) {
                            alt6=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA6_0==30) ) {
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
                            // InternalParametersTestLanguageEx.g:466:2: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            {
                            // InternalParametersTestLanguageEx.g:466:2: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) )
                            // InternalParametersTestLanguageEx.g:466:3: ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 )
                            {
                            // InternalParametersTestLanguageEx.g:471:1: (lv_scenario_26_0= ruleScenario4 )
                            // InternalParametersTestLanguageEx.g:472:3: lv_scenario_26_0= ruleScenario4
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_10_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_26_0=ruleScenario4();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"scenario",
                                      		lv_scenario_26_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario4");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalParametersTestLanguageEx.g:489:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? )
                            {
                            // InternalParametersTestLanguageEx.g:489:6: ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? )
                            // InternalParametersTestLanguageEx.g:489:7: ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )?
                            {
                            // InternalParametersTestLanguageEx.g:489:7: ( (lv_scenario_27_0= norm1_Scenario2 ) )
                            // InternalParametersTestLanguageEx.g:490:1: (lv_scenario_27_0= norm1_Scenario2 )
                            {
                            // InternalParametersTestLanguageEx.g:490:1: (lv_scenario_27_0= norm1_Scenario2 )
                            // InternalParametersTestLanguageEx.g:491:3: lv_scenario_27_0= norm1_Scenario2
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_10_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_7);
                            lv_scenario_27_0=norm1_Scenario2();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"scenario",
                                      		lv_scenario_27_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario2");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalParametersTestLanguageEx.g:507:2: (otherlv_28= 'trailing' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==20) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // InternalParametersTestLanguageEx.g:507:4: otherlv_28= 'trailing'
                                    {
                                    otherlv_28=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_28, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_10_1_1_1());
                                          
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
                    // InternalParametersTestLanguageEx.g:512:6: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:512:6: (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? ) ) )
                    // InternalParametersTestLanguageEx.g:512:8: otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? ) )
                    {
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitTwoKeyword_1_11_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:516:1: ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==27) && (synpred6_InternalParametersTestLanguageEx())) {
                            alt8=1;
                        }
                        else if ( (LA8_1==EOF||LA8_1==20) ) {
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
                            // InternalParametersTestLanguageEx.g:516:2: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            {
                            // InternalParametersTestLanguageEx.g:516:2: ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) )
                            // InternalParametersTestLanguageEx.g:516:3: ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 )
                            {
                            // InternalParametersTestLanguageEx.g:521:1: (lv_scenario_30_0= ruleScenario4 )
                            // InternalParametersTestLanguageEx.g:522:3: lv_scenario_30_0= ruleScenario4
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_11_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_scenario_30_0=ruleScenario4();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"scenario",
                                      		lv_scenario_30_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario4");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalParametersTestLanguageEx.g:539:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? )
                            {
                            // InternalParametersTestLanguageEx.g:539:6: ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? )
                            // InternalParametersTestLanguageEx.g:539:7: ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )?
                            {
                            // InternalParametersTestLanguageEx.g:539:7: ( (lv_scenario_31_0= ruleScenario2 ) )
                            // InternalParametersTestLanguageEx.g:540:1: (lv_scenario_31_0= ruleScenario2 )
                            {
                            // InternalParametersTestLanguageEx.g:540:1: (lv_scenario_31_0= ruleScenario2 )
                            // InternalParametersTestLanguageEx.g:541:3: lv_scenario_31_0= ruleScenario2
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_11_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_7);
                            lv_scenario_31_0=ruleScenario2();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"scenario",
                                      		lv_scenario_31_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario2");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalParametersTestLanguageEx.g:557:2: (otherlv_32= 'trailing' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==20) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // InternalParametersTestLanguageEx.g:557:4: otherlv_32= 'trailing'
                                    {
                                    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_32, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_11_1_1_1());
                                          
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
                case 13 :
                    // InternalParametersTestLanguageEx.g:562:6: (otherlv_33= '#13' ( (lv_scenario_34_0= ruleScenario5 ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:562:6: (otherlv_33= '#13' ( (lv_scenario_34_0= ruleScenario5 ) ) )
                    // InternalParametersTestLanguageEx.g:562:8: otherlv_33= '#13' ( (lv_scenario_34_0= ruleScenario5 ) )
                    {
                    otherlv_33=(Token)match(input,24,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_33, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitThreeKeyword_1_12_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:566:1: ( (lv_scenario_34_0= ruleScenario5 ) )
                    // InternalParametersTestLanguageEx.g:567:1: (lv_scenario_34_0= ruleScenario5 )
                    {
                    // InternalParametersTestLanguageEx.g:567:1: (lv_scenario_34_0= ruleScenario5 )
                    // InternalParametersTestLanguageEx.g:568:3: lv_scenario_34_0= ruleScenario5
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario5ParserRuleCall_1_12_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_34_0=ruleScenario5();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                      	        }
                             		set(
                             			current, 
                             			"scenario",
                              		lv_scenario_34_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario5");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalParametersTestLanguageEx.g:585:6: (otherlv_35= '#14' ( (lv_scenario_36_0= norm1_Scenario5 ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:585:6: (otherlv_35= '#14' ( (lv_scenario_36_0= norm1_Scenario5 ) ) )
                    // InternalParametersTestLanguageEx.g:585:8: otherlv_35= '#14' ( (lv_scenario_36_0= norm1_Scenario5 ) )
                    {
                    otherlv_35=(Token)match(input,25,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_35, grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitFourKeyword_1_13_0());
                          
                    }
                    // InternalParametersTestLanguageEx.g:589:1: ( (lv_scenario_36_0= norm1_Scenario5 ) )
                    // InternalParametersTestLanguageEx.g:590:1: (lv_scenario_36_0= norm1_Scenario5 )
                    {
                    // InternalParametersTestLanguageEx.g:590:1: (lv_scenario_36_0= norm1_Scenario5 )
                    // InternalParametersTestLanguageEx.g:591:3: lv_scenario_36_0= norm1_Scenario5
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario5ParserRuleCall_1_13_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scenario_36_0=norm1_Scenario5();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParametersTestLanguageParserRuleParametersRule());
                      	        }
                             		set(
                             			current, 
                             			"scenario",
                              		lv_scenario_36_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.Scenario5");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


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
    // $ANTLR end "superParserRuleParameters"


    // $ANTLR start "entrySuperScenario1"
    // InternalParametersTestLanguageEx.g:615:1: entrySuperScenario1 returns [EObject current=null] : iv_superScenario1= superScenario1 EOF ;
    public final EObject entrySuperScenario1() throws RecognitionException {
        EObject current = null;

        EObject iv_superScenario1 = null;


        try {
            // InternalParametersTestLanguageEx.g:616:2: (iv_superScenario1= superScenario1 EOF )
            // InternalParametersTestLanguageEx.g:617:2: iv_superScenario1= superScenario1 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParametersTestLanguageScenario1Rule()); 
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
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entrySuperScenario1"


    // $ANTLR start "superScenario1"
    // InternalParametersTestLanguageEx.g:624:1: superScenario1 returns [EObject current=null] : ( (lv_second_0_0= RULE_ID ) ) ;
    public final EObject superScenario1() throws RecognitionException {
        EObject current = null;

        Token lv_second_0_0=null;

         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:627:28: ( ( (lv_second_0_0= RULE_ID ) ) )
            // InternalParametersTestLanguageEx.g:628:1: ( (lv_second_0_0= RULE_ID ) )
            {
            // InternalParametersTestLanguageEx.g:628:1: ( (lv_second_0_0= RULE_ID ) )
            // InternalParametersTestLanguageEx.g:629:1: (lv_second_0_0= RULE_ID )
            {
            // InternalParametersTestLanguageEx.g:629:1: (lv_second_0_0= RULE_ID )
            // InternalParametersTestLanguageEx.g:630:3: lv_second_0_0= RULE_ID
            {
            lv_second_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_second_0_0, grammarAccess.getParametersTestLanguageScenario1Access().getSecondIDTerminalRuleCall_1_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getParametersTestLanguageScenario1Rule());
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
    // $ANTLR end "superScenario1"


    // $ANTLR start "normSuper1_Scenario1"
    // InternalParametersTestLanguageEx.g:655:1: normSuper1_Scenario1 returns [EObject current=null] : ( (lv_first_0_0= RULE_ID ) ) ;
    public final EObject normSuper1_Scenario1() throws RecognitionException {
        EObject current = null;

        Token lv_first_0_0=null;

         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:658:28: ( ( (lv_first_0_0= RULE_ID ) ) )
            // InternalParametersTestLanguageEx.g:659:1: ( (lv_first_0_0= RULE_ID ) )
            {
            // InternalParametersTestLanguageEx.g:659:1: ( (lv_first_0_0= RULE_ID ) )
            // InternalParametersTestLanguageEx.g:660:1: (lv_first_0_0= RULE_ID )
            {
            // InternalParametersTestLanguageEx.g:660:1: (lv_first_0_0= RULE_ID )
            // InternalParametersTestLanguageEx.g:661:3: lv_first_0_0= RULE_ID
            {
            lv_first_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_first_0_0, grammarAccess.getParametersTestLanguageScenario1Access().getFirstIDTerminalRuleCall_0_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getParametersTestLanguageScenario1Rule());
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
    // $ANTLR end "normSuper1_Scenario1"


    // $ANTLR start "entryRuleScenario2"
    // InternalParametersTestLanguageEx.g:685:1: entryRuleScenario2 returns [EObject current=null] : iv_ruleScenario2= ruleScenario2 EOF ;
    public final EObject entryRuleScenario2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2 = null;


        try {
            // InternalParametersTestLanguageEx.g:686:2: (iv_ruleScenario2= ruleScenario2 EOF )
            // InternalParametersTestLanguageEx.g:687:2: iv_ruleScenario2= ruleScenario2 EOF
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
    // InternalParametersTestLanguageEx.g:694:1: ruleScenario2 returns [EObject current=null] : ( (lv_first_0_0= ruleIdOrKeyword ) ) ;
    public final EObject ruleScenario2() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:697:28: ( ( (lv_first_0_0= ruleIdOrKeyword ) ) )
            // InternalParametersTestLanguageEx.g:698:1: ( (lv_first_0_0= ruleIdOrKeyword ) )
            {
            // InternalParametersTestLanguageEx.g:698:1: ( (lv_first_0_0= ruleIdOrKeyword ) )
            // InternalParametersTestLanguageEx.g:699:1: (lv_first_0_0= ruleIdOrKeyword )
            {
            // InternalParametersTestLanguageEx.g:699:1: (lv_first_0_0= ruleIdOrKeyword )
            // InternalParametersTestLanguageEx.g:700:3: lv_first_0_0= ruleIdOrKeyword
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
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.IdOrKeyword");
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
    // InternalParametersTestLanguageEx.g:725:1: norm1_Scenario2 returns [EObject current=null] : ( (lv_first_0_0= norm1_IdOrKeyword ) ) ;
    public final EObject norm1_Scenario2() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:728:28: ( ( (lv_first_0_0= norm1_IdOrKeyword ) ) )
            // InternalParametersTestLanguageEx.g:729:1: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            {
            // InternalParametersTestLanguageEx.g:729:1: ( (lv_first_0_0= norm1_IdOrKeyword ) )
            // InternalParametersTestLanguageEx.g:730:1: (lv_first_0_0= norm1_IdOrKeyword )
            {
            // InternalParametersTestLanguageEx.g:730:1: (lv_first_0_0= norm1_IdOrKeyword )
            // InternalParametersTestLanguageEx.g:731:3: lv_first_0_0= norm1_IdOrKeyword
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
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.IdOrKeyword");
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
    // InternalParametersTestLanguageEx.g:755:1: entryRuleScenario3 returns [EObject current=null] : iv_ruleScenario3= ruleScenario3 EOF ;
    public final EObject entryRuleScenario3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario3 = null;


        try {
            // InternalParametersTestLanguageEx.g:756:2: (iv_ruleScenario3= ruleScenario3 EOF )
            // InternalParametersTestLanguageEx.g:757:2: iv_ruleScenario3= ruleScenario3 EOF
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
    // InternalParametersTestLanguageEx.g:764:1: ruleScenario3 returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'scenario3' ) ) ) ;
    public final EObject ruleScenario3() throws RecognitionException {
        EObject current = null;

        Token lv_second_1_0=null;
        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:767:28: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'scenario3' ) ) ) )
            // InternalParametersTestLanguageEx.g:768:1: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'scenario3' ) ) )
            {
            // InternalParametersTestLanguageEx.g:768:1: ( ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) ) | ( (lv_second_1_0= 'scenario3' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) && (synpred7_InternalParametersTestLanguageEx())) {
                alt10=1;
            }
            else if ( (LA10_0==26) ) {
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
                    // InternalParametersTestLanguageEx.g:768:2: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    {
                    // InternalParametersTestLanguageEx.g:768:2: ( ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword ) )
                    // InternalParametersTestLanguageEx.g:768:3: ( ( ruleIdOrKeyword ) )=> (lv_first_0_0= ruleIdOrKeyword )
                    {
                    // InternalParametersTestLanguageEx.g:773:1: (lv_first_0_0= ruleIdOrKeyword )
                    // InternalParametersTestLanguageEx.g:774:3: lv_first_0_0= ruleIdOrKeyword
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
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.IdOrKeyword");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguageEx.g:791:6: ( (lv_second_1_0= 'scenario3' ) )
                    {
                    // InternalParametersTestLanguageEx.g:791:6: ( (lv_second_1_0= 'scenario3' ) )
                    // InternalParametersTestLanguageEx.g:792:1: (lv_second_1_0= 'scenario3' )
                    {
                    // InternalParametersTestLanguageEx.g:792:1: (lv_second_1_0= 'scenario3' )
                    // InternalParametersTestLanguageEx.g:793:3: lv_second_1_0= 'scenario3'
                    {
                    lv_second_1_0=(Token)match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_second_1_0, grammarAccess.getScenario3Access().getSecondScenario3Keyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScenario3Rule());
                      	        }
                             		setWithLastConsumed(current, "second", lv_second_1_0, "scenario3");
                      	    
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
    // InternalParametersTestLanguageEx.g:815:1: norm1_Scenario3 returns [EObject current=null] : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'scenario3' ) ) ) ;
    public final EObject norm1_Scenario3() throws RecognitionException {
        EObject current = null;

        Token lv_second_1_0=null;
        AntlrDatatypeRuleToken lv_first_0_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:818:28: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'scenario3' ) ) ) )
            // InternalParametersTestLanguageEx.g:819:1: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'scenario3' ) ) )
            {
            // InternalParametersTestLanguageEx.g:819:1: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) ) | ( (lv_second_1_0= 'scenario3' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==30) && (synpred8_InternalParametersTestLanguageEx())) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_ID) && (synpred8_InternalParametersTestLanguageEx())) {
                alt11=1;
            }
            else if ( (LA11_0==26) ) {
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
                    // InternalParametersTestLanguageEx.g:819:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    {
                    // InternalParametersTestLanguageEx.g:819:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword ) )
                    // InternalParametersTestLanguageEx.g:819:3: ( ( norm1_IdOrKeyword ) )=> (lv_first_0_0= norm1_IdOrKeyword )
                    {
                    // InternalParametersTestLanguageEx.g:824:1: (lv_first_0_0= norm1_IdOrKeyword )
                    // InternalParametersTestLanguageEx.g:825:3: lv_first_0_0= norm1_IdOrKeyword
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
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.IdOrKeyword");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguageEx.g:842:6: ( (lv_second_1_0= 'scenario3' ) )
                    {
                    // InternalParametersTestLanguageEx.g:842:6: ( (lv_second_1_0= 'scenario3' ) )
                    // InternalParametersTestLanguageEx.g:843:1: (lv_second_1_0= 'scenario3' )
                    {
                    // InternalParametersTestLanguageEx.g:843:1: (lv_second_1_0= 'scenario3' )
                    // InternalParametersTestLanguageEx.g:844:3: lv_second_1_0= 'scenario3'
                    {
                    lv_second_1_0=(Token)match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_second_1_0, grammarAccess.getScenario3Access().getSecondScenario3Keyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScenario3Rule());
                      	        }
                             		setWithLastConsumed(current, "second", lv_second_1_0, "scenario3");
                      	    
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
    // InternalParametersTestLanguageEx.g:865:1: entryRuleScenario4 returns [EObject current=null] : iv_ruleScenario4= ruleScenario4 EOF ;
    public final EObject entryRuleScenario4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario4 = null;


        try {
            // InternalParametersTestLanguageEx.g:866:2: (iv_ruleScenario4= ruleScenario4 EOF )
            // InternalParametersTestLanguageEx.g:867:2: iv_ruleScenario4= ruleScenario4 EOF
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
    // InternalParametersTestLanguageEx.g:874:1: ruleScenario4 returns [EObject current=null] : ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'scenario4' ) ;
    public final EObject ruleScenario4() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_second_0_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:877:28: ( ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'scenario4' ) )
            // InternalParametersTestLanguageEx.g:878:1: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'scenario4' )
            {
            // InternalParametersTestLanguageEx.g:878:1: ( ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'scenario4' )
            // InternalParametersTestLanguageEx.g:878:2: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) ) otherlv_1= 'scenario4'
            {
            // InternalParametersTestLanguageEx.g:878:2: ( ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword ) )
            // InternalParametersTestLanguageEx.g:878:3: ( ( ruleIdOrKeyword ) )=> (lv_second_0_0= ruleIdOrKeyword )
            {
            // InternalParametersTestLanguageEx.g:883:1: (lv_second_0_0= ruleIdOrKeyword )
            // InternalParametersTestLanguageEx.g:884:3: lv_second_0_0= ruleIdOrKeyword
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario4Access().getSecondIdOrKeywordParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_10);
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
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.IdOrKeyword");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScenario4Access().getScenario4Keyword_1());
                  
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
    // InternalParametersTestLanguageEx.g:913:1: norm1_Scenario4 returns [EObject current=null] : ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'scenario4' ) ;
    public final EObject norm1_Scenario4() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_second_0_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:916:28: ( ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'scenario4' ) )
            // InternalParametersTestLanguageEx.g:917:1: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'scenario4' )
            {
            // InternalParametersTestLanguageEx.g:917:1: ( ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'scenario4' )
            // InternalParametersTestLanguageEx.g:917:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) ) otherlv_1= 'scenario4'
            {
            // InternalParametersTestLanguageEx.g:917:2: ( ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword ) )
            // InternalParametersTestLanguageEx.g:917:3: ( ( norm1_IdOrKeyword ) )=> (lv_second_0_0= norm1_IdOrKeyword )
            {
            // InternalParametersTestLanguageEx.g:922:1: (lv_second_0_0= norm1_IdOrKeyword )
            // InternalParametersTestLanguageEx.g:923:3: lv_second_0_0= norm1_IdOrKeyword
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScenario4Access().getSecondIdOrKeywordParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_10);
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
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.IdOrKeyword");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScenario4Access().getScenario4Keyword_1());
                  
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


    // $ANTLR start "entryRuleScenario5"
    // InternalParametersTestLanguageEx.g:951:1: entryRuleScenario5 returns [EObject current=null] : iv_ruleScenario5= ruleScenario5 EOF ;
    public final EObject entryRuleScenario5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario5 = null;


        try {
            // InternalParametersTestLanguageEx.g:952:2: (iv_ruleScenario5= ruleScenario5 EOF )
            // InternalParametersTestLanguageEx.g:953:2: iv_ruleScenario5= ruleScenario5 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScenario5Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario5=ruleScenario5();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScenario5; 
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
    // $ANTLR end "entryRuleScenario5"


    // $ANTLR start "ruleScenario5"
    // InternalParametersTestLanguageEx.g:960:1: ruleScenario5 returns [EObject current=null] : ( ( () otherlv_1= 'trailing' ) | ( () otherlv_3= 'scenario5' ( (lv_first_4_0= norm1_IdOrKeyword ) ) ( (lv_second_5_0= ruleIdOrKeyword ) ) ) ) ;
    public final EObject ruleScenario5() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_first_4_0 = null;

        AntlrDatatypeRuleToken lv_second_5_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:963:28: ( ( ( () otherlv_1= 'trailing' ) | ( () otherlv_3= 'scenario5' ( (lv_first_4_0= norm1_IdOrKeyword ) ) ( (lv_second_5_0= ruleIdOrKeyword ) ) ) ) )
            // InternalParametersTestLanguageEx.g:964:1: ( ( () otherlv_1= 'trailing' ) | ( () otherlv_3= 'scenario5' ( (lv_first_4_0= norm1_IdOrKeyword ) ) ( (lv_second_5_0= ruleIdOrKeyword ) ) ) )
            {
            // InternalParametersTestLanguageEx.g:964:1: ( ( () otherlv_1= 'trailing' ) | ( () otherlv_3= 'scenario5' ( (lv_first_4_0= norm1_IdOrKeyword ) ) ( (lv_second_5_0= ruleIdOrKeyword ) ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            else if ( (LA12_0==28) ) {
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
                    // InternalParametersTestLanguageEx.g:964:2: ( () otherlv_1= 'trailing' )
                    {
                    // InternalParametersTestLanguageEx.g:964:2: ( () otherlv_1= 'trailing' )
                    // InternalParametersTestLanguageEx.g:964:3: () otherlv_1= 'trailing'
                    {
                    // InternalParametersTestLanguageEx.g:964:3: ()
                    // InternalParametersTestLanguageEx.g:965:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getScenario5Access().getScenarioAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getScenario5Access().getTrailingKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguageEx.g:975:6: ( () otherlv_3= 'scenario5' ( (lv_first_4_0= norm1_IdOrKeyword ) ) ( (lv_second_5_0= ruleIdOrKeyword ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:975:6: ( () otherlv_3= 'scenario5' ( (lv_first_4_0= norm1_IdOrKeyword ) ) ( (lv_second_5_0= ruleIdOrKeyword ) ) )
                    // InternalParametersTestLanguageEx.g:975:7: () otherlv_3= 'scenario5' ( (lv_first_4_0= norm1_IdOrKeyword ) ) ( (lv_second_5_0= ruleIdOrKeyword ) )
                    {
                    // InternalParametersTestLanguageEx.g:975:7: ()
                    // InternalParametersTestLanguageEx.g:976:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getScenario5Access().getScenarioAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getScenario5Access().getScenario5Keyword_2_1());
                          
                    }
                    // InternalParametersTestLanguageEx.g:985:1: ( (lv_first_4_0= norm1_IdOrKeyword ) )
                    // InternalParametersTestLanguageEx.g:986:1: (lv_first_4_0= norm1_IdOrKeyword )
                    {
                    // InternalParametersTestLanguageEx.g:986:1: (lv_first_4_0= norm1_IdOrKeyword )
                    // InternalParametersTestLanguageEx.g:987:3: lv_first_4_0= norm1_IdOrKeyword
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScenario5Access().getFirstIdOrKeywordParserRuleCall_2_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_3);
                    lv_first_4_0=norm1_IdOrKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScenario5Rule());
                      	        }
                             		set(
                             			current, 
                             			"first",
                              		lv_first_4_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.IdOrKeyword");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalParametersTestLanguageEx.g:1003:2: ( (lv_second_5_0= ruleIdOrKeyword ) )
                    // InternalParametersTestLanguageEx.g:1004:1: (lv_second_5_0= ruleIdOrKeyword )
                    {
                    // InternalParametersTestLanguageEx.g:1004:1: (lv_second_5_0= ruleIdOrKeyword )
                    // InternalParametersTestLanguageEx.g:1005:3: lv_second_5_0= ruleIdOrKeyword
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScenario5Access().getSecondIdOrKeywordParserRuleCall_2_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_second_5_0=ruleIdOrKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScenario5Rule());
                      	        }
                             		set(
                             			current, 
                             			"second",
                              		lv_second_5_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.IdOrKeyword");
                      	        afterParserOrEnumRuleCall();
                      	    
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


    // $ANTLR start "norm1_Scenario5"
    // InternalParametersTestLanguageEx.g:1030:1: norm1_Scenario5 returns [EObject current=null] : ( ( () otherlv_1= 'include' ) | ( () otherlv_3= 'trailing' ) | ( () otherlv_5= 'scenario5' (otherlv_6= 'include' )? ( (lv_first_7_0= norm1_IdOrKeyword ) ) ( (lv_second_8_0= ruleIdOrKeyword ) ) ) ) ;
    public final EObject norm1_Scenario5() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_first_7_0 = null;

        AntlrDatatypeRuleToken lv_second_8_0 = null;


         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:1033:28: ( ( ( () otherlv_1= 'include' ) | ( () otherlv_3= 'trailing' ) | ( () otherlv_5= 'scenario5' (otherlv_6= 'include' )? ( (lv_first_7_0= norm1_IdOrKeyword ) ) ( (lv_second_8_0= ruleIdOrKeyword ) ) ) ) )
            // InternalParametersTestLanguageEx.g:1034:1: ( ( () otherlv_1= 'include' ) | ( () otherlv_3= 'trailing' ) | ( () otherlv_5= 'scenario5' (otherlv_6= 'include' )? ( (lv_first_7_0= norm1_IdOrKeyword ) ) ( (lv_second_8_0= ruleIdOrKeyword ) ) ) )
            {
            // InternalParametersTestLanguageEx.g:1034:1: ( ( () otherlv_1= 'include' ) | ( () otherlv_3= 'trailing' ) | ( () otherlv_5= 'scenario5' (otherlv_6= 'include' )? ( (lv_first_7_0= norm1_IdOrKeyword ) ) ( (lv_second_8_0= ruleIdOrKeyword ) ) ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt14=1;
                }
                break;
            case 20:
                {
                alt14=2;
                }
                break;
            case 28:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalParametersTestLanguageEx.g:1034:2: ( () otherlv_1= 'include' )
                    {
                    // InternalParametersTestLanguageEx.g:1034:2: ( () otherlv_1= 'include' )
                    // InternalParametersTestLanguageEx.g:1034:3: () otherlv_1= 'include'
                    {
                    // InternalParametersTestLanguageEx.g:1034:3: ()
                    // InternalParametersTestLanguageEx.g:1035:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getScenario5Access().getScenarioAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getScenario5Access().getIncludeKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguageEx.g:1045:6: ( () otherlv_3= 'trailing' )
                    {
                    // InternalParametersTestLanguageEx.g:1045:6: ( () otherlv_3= 'trailing' )
                    // InternalParametersTestLanguageEx.g:1045:7: () otherlv_3= 'trailing'
                    {
                    // InternalParametersTestLanguageEx.g:1045:7: ()
                    // InternalParametersTestLanguageEx.g:1046:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getScenario5Access().getScenarioAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getScenario5Access().getTrailingKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalParametersTestLanguageEx.g:1056:6: ( () otherlv_5= 'scenario5' (otherlv_6= 'include' )? ( (lv_first_7_0= norm1_IdOrKeyword ) ) ( (lv_second_8_0= ruleIdOrKeyword ) ) )
                    {
                    // InternalParametersTestLanguageEx.g:1056:6: ( () otherlv_5= 'scenario5' (otherlv_6= 'include' )? ( (lv_first_7_0= norm1_IdOrKeyword ) ) ( (lv_second_8_0= ruleIdOrKeyword ) ) )
                    // InternalParametersTestLanguageEx.g:1056:7: () otherlv_5= 'scenario5' (otherlv_6= 'include' )? ( (lv_first_7_0= norm1_IdOrKeyword ) ) ( (lv_second_8_0= ruleIdOrKeyword ) )
                    {
                    // InternalParametersTestLanguageEx.g:1056:7: ()
                    // InternalParametersTestLanguageEx.g:1057:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getScenario5Access().getScenarioAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_5=(Token)match(input,28,FollowSets000.FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getScenario5Access().getScenario5Keyword_2_1());
                          
                    }
                    // InternalParametersTestLanguageEx.g:1066:1: (otherlv_6= 'include' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==29) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalParametersTestLanguageEx.g:1066:3: otherlv_6= 'include'
                            {
                            otherlv_6=(Token)match(input,29,FollowSets000.FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getScenario5Access().getIncludeKeyword_2_2_0());
                                  
                            }

                            }
                            break;

                    }

                    // InternalParametersTestLanguageEx.g:1070:3: ( (lv_first_7_0= norm1_IdOrKeyword ) )
                    // InternalParametersTestLanguageEx.g:1071:1: (lv_first_7_0= norm1_IdOrKeyword )
                    {
                    // InternalParametersTestLanguageEx.g:1071:1: (lv_first_7_0= norm1_IdOrKeyword )
                    // InternalParametersTestLanguageEx.g:1072:3: lv_first_7_0= norm1_IdOrKeyword
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScenario5Access().getFirstIdOrKeywordParserRuleCall_2_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_3);
                    lv_first_7_0=norm1_IdOrKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScenario5Rule());
                      	        }
                             		set(
                             			current, 
                             			"first",
                              		lv_first_7_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.IdOrKeyword");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalParametersTestLanguageEx.g:1088:2: ( (lv_second_8_0= ruleIdOrKeyword ) )
                    // InternalParametersTestLanguageEx.g:1089:1: (lv_second_8_0= ruleIdOrKeyword )
                    {
                    // InternalParametersTestLanguageEx.g:1089:1: (lv_second_8_0= ruleIdOrKeyword )
                    // InternalParametersTestLanguageEx.g:1090:3: lv_second_8_0= ruleIdOrKeyword
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getScenario5Access().getSecondIdOrKeywordParserRuleCall_2_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_second_8_0=ruleIdOrKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getScenario5Rule());
                      	        }
                             		set(
                             			current, 
                             			"second",
                              		lv_second_8_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.ParametersTestLanguage.IdOrKeyword");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "norm1_Scenario5"


    // $ANTLR start "entryRuleIdOrKeyword"
    // InternalParametersTestLanguageEx.g:1114:1: entryRuleIdOrKeyword returns [String current=null] : iv_ruleIdOrKeyword= ruleIdOrKeyword EOF ;
    public final String entryRuleIdOrKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrKeyword = null;


        try {
            // InternalParametersTestLanguageEx.g:1115:2: (iv_ruleIdOrKeyword= ruleIdOrKeyword EOF )
            // InternalParametersTestLanguageEx.g:1116:2: iv_ruleIdOrKeyword= ruleIdOrKeyword EOF
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
    // InternalParametersTestLanguageEx.g:1123:1: ruleIdOrKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdOrKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:1126:28: (this_ID_0= RULE_ID )
            // InternalParametersTestLanguageEx.g:1127:5: this_ID_0= RULE_ID
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
    // InternalParametersTestLanguageEx.g:1143:1: norm1_IdOrKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'keyword' | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken norm1_IdOrKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalParametersTestLanguageEx.g:1146:28: ( (kw= 'keyword' | this_ID_1= RULE_ID ) )
            // InternalParametersTestLanguageEx.g:1147:1: (kw= 'keyword' | this_ID_1= RULE_ID )
            {
            // InternalParametersTestLanguageEx.g:1147:1: (kw= 'keyword' | this_ID_1= RULE_ID )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==30) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ID) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalParametersTestLanguageEx.g:1148:2: kw= 'keyword'
                    {
                    kw=(Token)match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrKeywordAccess().getKeywordKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalParametersTestLanguageEx.g:1154:10: this_ID_1= RULE_ID
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

    // $ANTLR start synpred1_InternalParametersTestLanguageEx
    public final void synpred1_InternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageEx.g:260:7: ( ( '#5' ( ( norm1_Scenario2 ) ) ) )
        // InternalParametersTestLanguageEx.g:260:8: ( '#5' ( ( norm1_Scenario2 ) ) )
        {
        // InternalParametersTestLanguageEx.g:260:8: ( '#5' ( ( norm1_Scenario2 ) ) )
        // InternalParametersTestLanguageEx.g:260:10: '#5' ( ( norm1_Scenario2 ) )
        {
        match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // InternalParametersTestLanguageEx.g:261:1: ( ( norm1_Scenario2 ) )
        // InternalParametersTestLanguageEx.g:262:1: ( norm1_Scenario2 )
        {
        // InternalParametersTestLanguageEx.g:262:1: ( norm1_Scenario2 )
        // InternalParametersTestLanguageEx.g:263:1: norm1_Scenario2
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
    // $ANTLR end synpred1_InternalParametersTestLanguageEx

    // $ANTLR start synpred2_InternalParametersTestLanguageEx
    public final void synpred2_InternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageEx.g:288:7: ( ( '#6' ( ( ruleScenario2 ) ) ) )
        // InternalParametersTestLanguageEx.g:288:8: ( '#6' ( ( ruleScenario2 ) ) )
        {
        // InternalParametersTestLanguageEx.g:288:8: ( '#6' ( ( ruleScenario2 ) ) )
        // InternalParametersTestLanguageEx.g:288:10: '#6' ( ( ruleScenario2 ) )
        {
        match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return ;
        // InternalParametersTestLanguageEx.g:289:1: ( ( ruleScenario2 ) )
        // InternalParametersTestLanguageEx.g:290:1: ( ruleScenario2 )
        {
        // InternalParametersTestLanguageEx.g:290:1: ( ruleScenario2 )
        // InternalParametersTestLanguageEx.g:291:1: ruleScenario2
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
    // $ANTLR end synpred2_InternalParametersTestLanguageEx

    // $ANTLR start synpred3_InternalParametersTestLanguageEx
    public final void synpred3_InternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageEx.g:366:3: ( ( norm1_IdOrKeyword ) )
        // InternalParametersTestLanguageEx.g:367:1: ( norm1_IdOrKeyword )
        {
        // InternalParametersTestLanguageEx.g:367:1: ( norm1_IdOrKeyword )
        // InternalParametersTestLanguageEx.g:368:1: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalParametersTestLanguageEx

    // $ANTLR start synpred4_InternalParametersTestLanguageEx
    public final void synpred4_InternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageEx.g:416:3: ( ( norm1_IdOrKeyword ) )
        // InternalParametersTestLanguageEx.g:417:1: ( norm1_IdOrKeyword )
        {
        // InternalParametersTestLanguageEx.g:417:1: ( norm1_IdOrKeyword )
        // InternalParametersTestLanguageEx.g:418:1: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalParametersTestLanguageEx

    // $ANTLR start synpred5_InternalParametersTestLanguageEx
    public final void synpred5_InternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageEx.g:466:3: ( ( ruleIdOrKeyword ) )
        // InternalParametersTestLanguageEx.g:467:1: ( ruleIdOrKeyword )
        {
        // InternalParametersTestLanguageEx.g:467:1: ( ruleIdOrKeyword )
        // InternalParametersTestLanguageEx.g:468:1: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalParametersTestLanguageEx

    // $ANTLR start synpred6_InternalParametersTestLanguageEx
    public final void synpred6_InternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageEx.g:516:3: ( ( ruleIdOrKeyword ) )
        // InternalParametersTestLanguageEx.g:517:1: ( ruleIdOrKeyword )
        {
        // InternalParametersTestLanguageEx.g:517:1: ( ruleIdOrKeyword )
        // InternalParametersTestLanguageEx.g:518:1: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalParametersTestLanguageEx

    // $ANTLR start synpred7_InternalParametersTestLanguageEx
    public final void synpred7_InternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageEx.g:768:3: ( ( ruleIdOrKeyword ) )
        // InternalParametersTestLanguageEx.g:769:1: ( ruleIdOrKeyword )
        {
        // InternalParametersTestLanguageEx.g:769:1: ( ruleIdOrKeyword )
        // InternalParametersTestLanguageEx.g:770:1: ruleIdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleIdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalParametersTestLanguageEx

    // $ANTLR start synpred8_InternalParametersTestLanguageEx
    public final void synpred8_InternalParametersTestLanguageEx_fragment() throws RecognitionException {   
        // InternalParametersTestLanguageEx.g:819:3: ( ( norm1_IdOrKeyword ) )
        // InternalParametersTestLanguageEx.g:820:1: ( norm1_IdOrKeyword )
        {
        // InternalParametersTestLanguageEx.g:820:1: ( norm1_IdOrKeyword )
        // InternalParametersTestLanguageEx.g:821:1: norm1_IdOrKeyword
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_IdOrKeyword();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalParametersTestLanguageEx

    // Delegated rules

    public final boolean synpred1_InternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalParametersTestLanguageEx_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalParametersTestLanguageEx() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalParametersTestLanguageEx_fragment(); // can never throw exception
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
    static final String dfa_1s = "\17\uffff";
    static final String dfa_2s = "\1\13\16\uffff";
    static final String dfa_3s = "\1\31\16\uffff";
    static final String dfa_4s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16";
    static final String dfa_5s = "\1\0\16\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\12\1\13\1\14\1\15\1\16",
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
            return "168:2: ( (otherlv_1= '#1' ( (lv_scenario_2_0= norm1_Scenario1 ) ) ) | (otherlv_3= '#2' ( (lv_scenario_4_0= ruleScenario1 ) ) ) | (otherlv_5= '#3' ( (lv_scenario_6_0= norm1_Scenario2 ) ) ) | (otherlv_7= '#4' ( (lv_scenario_8_0= ruleScenario2 ) ) ) | ( ( ( '#5' ( ( norm1_Scenario2 ) ) ) )=> (otherlv_9= '#5' ( (lv_scenario_10_0= norm1_Scenario2 ) ) ) ) | ( ( ( '#6' ( ( ruleScenario2 ) ) ) )=> (otherlv_11= '#6' ( (lv_scenario_12_0= ruleScenario2 ) ) ) ) | (otherlv_13= '#7' ( (lv_scenario_14_0= norm1_Scenario3 ) ) ) | (otherlv_15= '#8' ( (lv_scenario_16_0= ruleScenario3 ) ) ) | (otherlv_17= '#9' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_18_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_19_0= norm1_Scenario2 ) ) (otherlv_20= 'trailing' )? ) ) ) | (otherlv_21= '#10' ( ( ( ( norm1_IdOrKeyword ) )=> (lv_scenario_22_0= norm1_Scenario4 ) ) | ( ( (lv_scenario_23_0= ruleScenario2 ) ) (otherlv_24= 'trailing' )? ) ) ) | (otherlv_25= '#11' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_26_0= ruleScenario4 ) ) | ( ( (lv_scenario_27_0= norm1_Scenario2 ) ) (otherlv_28= 'trailing' )? ) ) ) | (otherlv_29= '#12' ( ( ( ( ruleIdOrKeyword ) )=> (lv_scenario_30_0= ruleScenario4 ) ) | ( ( (lv_scenario_31_0= ruleScenario2 ) ) (otherlv_32= 'trailing' )? ) ) ) | (otherlv_33= '#13' ( (lv_scenario_34_0= ruleScenario5 ) ) ) | (otherlv_35= '#14' ( (lv_scenario_36_0= norm1_Scenario5 ) ) ) )";
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

                        else if ( (LA9_0==15) && (synpred1_InternalParametersTestLanguageEx())) {s = 5;}

                        else if ( (LA9_0==16) && (synpred2_InternalParametersTestLanguageEx())) {s = 6;}

                        else if ( (LA9_0==17) ) {s = 7;}

                        else if ( (LA9_0==18) ) {s = 8;}

                        else if ( (LA9_0==19) ) {s = 9;}

                        else if ( (LA9_0==21) ) {s = 10;}

                        else if ( (LA9_0==22) ) {s = 11;}

                        else if ( (LA9_0==23) ) {s = 12;}

                        else if ( (LA9_0==24) ) {s = 13;}

                        else if ( (LA9_0==25) ) {s = 14;}

                         
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
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000040000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000044000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000004000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000010100000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000030100000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000060000010L});
    }


}