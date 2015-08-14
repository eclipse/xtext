package org.eclipse.xtext.serializer.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.serializer.services.SyntacticSequencerTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSyntacticSequencerTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_TERMINAL_ID", "RULE_INT", "RULE_BOOLEAN_TERMINAL_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'kw1'", "'kw2'", "'kw3'", "'kw4'", "'#2'", "'+'", "'#3'", "'('", "')'", "'#4'", "'*'", "'#5'", "'#6'", "'#7'", "'matched'", "'#8'", "'#9'", "'#10'", "'#11'", "'#12'", "'#13'", "'kw5'", "'kw6'", "'kw7'", "'kw8'", "'!'", "'#14'"
    };
    public static final int RULE_ID=4;
    public static final int T__40=40;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_BOOLEAN_TERMINAL_ID=7;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=8;
    public static final int RULE_TERMINAL_ID=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public InternalSyntacticSequencerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSyntacticSequencerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSyntacticSequencerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSyntacticSequencerTestLanguage.g"; }



     	private SyntacticSequencerTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSyntacticSequencerTestLanguageParser(TokenStream input, SyntacticSequencerTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected SyntacticSequencerTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalSyntacticSequencerTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalSyntacticSequencerTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalSyntacticSequencerTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) | ( (lv_x14_13_0= ruleActionOnly ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_x1_0_0 = null;

        EObject lv_x2_1_0 = null;

        EObject lv_x3_2_0 = null;

        EObject lv_x4_3_0 = null;

        EObject lv_x5_4_0 = null;

        EObject lv_x6_5_0 = null;

        EObject lv_x7_6_0 = null;

        EObject lv_x8_7_0 = null;

        EObject lv_x9_8_0 = null;

        EObject lv_x10_9_0 = null;

        EObject lv_x11_10_0 = null;

        EObject lv_x12_11_0 = null;

        EObject lv_x13_12_0 = null;

        EObject lv_x14_13_0 = null;


         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:79:28: ( ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) | ( (lv_x14_13_0= ruleActionOnly ) ) ) )
            // InternalSyntacticSequencerTestLanguage.g:80:1: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) | ( (lv_x14_13_0= ruleActionOnly ) ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:80:1: ( ( (lv_x1_0_0= ruleMandatoryKeywords ) ) | ( (lv_x2_1_0= ruleExp0 ) ) | ( (lv_x3_2_0= ruleExp1 ) ) | ( (lv_x4_3_0= ruleExp2 ) ) | ( (lv_x5_4_0= ruleSingleCrossReference ) ) | ( (lv_x6_5_0= ruleBooleanAlternative ) ) | ( (lv_x7_6_0= ruleUnassignedDatatype ) ) | ( (lv_x8_7_0= ruleOptionalSingleTransition ) ) | ( (lv_x9_8_0= ruleOptionalManyTransition ) ) | ( (lv_x10_9_0= ruleMandatoryManyTransition ) ) | ( (lv_x11_10_0= ruleAlternativeTransition ) ) | ( (lv_x12_11_0= ruleBooleanValues ) ) | ( (lv_x13_12_0= ruleLongAlternative ) ) | ( (lv_x14_13_0= ruleActionOnly ) ) )
            int alt1=14;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt1=1;
                }
                break;
            case 18:
                {
                alt1=2;
                }
                break;
            case 20:
                {
                alt1=3;
                }
                break;
            case 23:
                {
                alt1=4;
                }
                break;
            case 25:
                {
                alt1=5;
                }
                break;
            case 26:
                {
                alt1=6;
                }
                break;
            case 27:
                {
                alt1=7;
                }
                break;
            case 29:
                {
                alt1=8;
                }
                break;
            case 30:
                {
                alt1=9;
                }
                break;
            case 31:
                {
                alt1=10;
                }
                break;
            case 32:
                {
                alt1=11;
                }
                break;
            case 33:
                {
                alt1=12;
                }
                break;
            case 34:
                {
                alt1=13;
                }
                break;
            case 40:
                {
                alt1=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:80:2: ( (lv_x1_0_0= ruleMandatoryKeywords ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:80:2: ( (lv_x1_0_0= ruleMandatoryKeywords ) )
                    // InternalSyntacticSequencerTestLanguage.g:81:1: (lv_x1_0_0= ruleMandatoryKeywords )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:81:1: (lv_x1_0_0= ruleMandatoryKeywords )
                    // InternalSyntacticSequencerTestLanguage.g:82:3: lv_x1_0_0= ruleMandatoryKeywords
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX1MandatoryKeywordsParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x1_0_0=ruleMandatoryKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x1",
                              		lv_x1_0_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.MandatoryKeywords");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSyntacticSequencerTestLanguage.g:99:6: ( (lv_x2_1_0= ruleExp0 ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:99:6: ( (lv_x2_1_0= ruleExp0 ) )
                    // InternalSyntacticSequencerTestLanguage.g:100:1: (lv_x2_1_0= ruleExp0 )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:100:1: (lv_x2_1_0= ruleExp0 )
                    // InternalSyntacticSequencerTestLanguage.g:101:3: lv_x2_1_0= ruleExp0
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX2Exp0ParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x2_1_0=ruleExp0();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x2",
                              		lv_x2_1_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.Exp0");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSyntacticSequencerTestLanguage.g:118:6: ( (lv_x3_2_0= ruleExp1 ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:118:6: ( (lv_x3_2_0= ruleExp1 ) )
                    // InternalSyntacticSequencerTestLanguage.g:119:1: (lv_x3_2_0= ruleExp1 )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:119:1: (lv_x3_2_0= ruleExp1 )
                    // InternalSyntacticSequencerTestLanguage.g:120:3: lv_x3_2_0= ruleExp1
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX3Exp1ParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x3_2_0=ruleExp1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x3",
                              		lv_x3_2_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.Exp1");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSyntacticSequencerTestLanguage.g:137:6: ( (lv_x4_3_0= ruleExp2 ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:137:6: ( (lv_x4_3_0= ruleExp2 ) )
                    // InternalSyntacticSequencerTestLanguage.g:138:1: (lv_x4_3_0= ruleExp2 )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:138:1: (lv_x4_3_0= ruleExp2 )
                    // InternalSyntacticSequencerTestLanguage.g:139:3: lv_x4_3_0= ruleExp2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX4Exp2ParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x4_3_0=ruleExp2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x4",
                              		lv_x4_3_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.Exp2");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSyntacticSequencerTestLanguage.g:156:6: ( (lv_x5_4_0= ruleSingleCrossReference ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:156:6: ( (lv_x5_4_0= ruleSingleCrossReference ) )
                    // InternalSyntacticSequencerTestLanguage.g:157:1: (lv_x5_4_0= ruleSingleCrossReference )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:157:1: (lv_x5_4_0= ruleSingleCrossReference )
                    // InternalSyntacticSequencerTestLanguage.g:158:3: lv_x5_4_0= ruleSingleCrossReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX5SingleCrossReferenceParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x5_4_0=ruleSingleCrossReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x5",
                              		lv_x5_4_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.SingleCrossReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalSyntacticSequencerTestLanguage.g:175:6: ( (lv_x6_5_0= ruleBooleanAlternative ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:175:6: ( (lv_x6_5_0= ruleBooleanAlternative ) )
                    // InternalSyntacticSequencerTestLanguage.g:176:1: (lv_x6_5_0= ruleBooleanAlternative )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:176:1: (lv_x6_5_0= ruleBooleanAlternative )
                    // InternalSyntacticSequencerTestLanguage.g:177:3: lv_x6_5_0= ruleBooleanAlternative
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX6BooleanAlternativeParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x6_5_0=ruleBooleanAlternative();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x6",
                              		lv_x6_5_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.BooleanAlternative");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalSyntacticSequencerTestLanguage.g:194:6: ( (lv_x7_6_0= ruleUnassignedDatatype ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:194:6: ( (lv_x7_6_0= ruleUnassignedDatatype ) )
                    // InternalSyntacticSequencerTestLanguage.g:195:1: (lv_x7_6_0= ruleUnassignedDatatype )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:195:1: (lv_x7_6_0= ruleUnassignedDatatype )
                    // InternalSyntacticSequencerTestLanguage.g:196:3: lv_x7_6_0= ruleUnassignedDatatype
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX7UnassignedDatatypeParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x7_6_0=ruleUnassignedDatatype();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x7",
                              		lv_x7_6_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.UnassignedDatatype");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalSyntacticSequencerTestLanguage.g:213:6: ( (lv_x8_7_0= ruleOptionalSingleTransition ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:213:6: ( (lv_x8_7_0= ruleOptionalSingleTransition ) )
                    // InternalSyntacticSequencerTestLanguage.g:214:1: (lv_x8_7_0= ruleOptionalSingleTransition )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:214:1: (lv_x8_7_0= ruleOptionalSingleTransition )
                    // InternalSyntacticSequencerTestLanguage.g:215:3: lv_x8_7_0= ruleOptionalSingleTransition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX8OptionalSingleTransitionParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x8_7_0=ruleOptionalSingleTransition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x8",
                              		lv_x8_7_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.OptionalSingleTransition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalSyntacticSequencerTestLanguage.g:232:6: ( (lv_x9_8_0= ruleOptionalManyTransition ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:232:6: ( (lv_x9_8_0= ruleOptionalManyTransition ) )
                    // InternalSyntacticSequencerTestLanguage.g:233:1: (lv_x9_8_0= ruleOptionalManyTransition )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:233:1: (lv_x9_8_0= ruleOptionalManyTransition )
                    // InternalSyntacticSequencerTestLanguage.g:234:3: lv_x9_8_0= ruleOptionalManyTransition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX9OptionalManyTransitionParserRuleCall_8_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x9_8_0=ruleOptionalManyTransition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x9",
                              		lv_x9_8_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.OptionalManyTransition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalSyntacticSequencerTestLanguage.g:251:6: ( (lv_x10_9_0= ruleMandatoryManyTransition ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:251:6: ( (lv_x10_9_0= ruleMandatoryManyTransition ) )
                    // InternalSyntacticSequencerTestLanguage.g:252:1: (lv_x10_9_0= ruleMandatoryManyTransition )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:252:1: (lv_x10_9_0= ruleMandatoryManyTransition )
                    // InternalSyntacticSequencerTestLanguage.g:253:3: lv_x10_9_0= ruleMandatoryManyTransition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX10MandatoryManyTransitionParserRuleCall_9_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x10_9_0=ruleMandatoryManyTransition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x10",
                              		lv_x10_9_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.MandatoryManyTransition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalSyntacticSequencerTestLanguage.g:270:6: ( (lv_x11_10_0= ruleAlternativeTransition ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:270:6: ( (lv_x11_10_0= ruleAlternativeTransition ) )
                    // InternalSyntacticSequencerTestLanguage.g:271:1: (lv_x11_10_0= ruleAlternativeTransition )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:271:1: (lv_x11_10_0= ruleAlternativeTransition )
                    // InternalSyntacticSequencerTestLanguage.g:272:3: lv_x11_10_0= ruleAlternativeTransition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX11AlternativeTransitionParserRuleCall_10_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x11_10_0=ruleAlternativeTransition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x11",
                              		lv_x11_10_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.AlternativeTransition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalSyntacticSequencerTestLanguage.g:289:6: ( (lv_x12_11_0= ruleBooleanValues ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:289:6: ( (lv_x12_11_0= ruleBooleanValues ) )
                    // InternalSyntacticSequencerTestLanguage.g:290:1: (lv_x12_11_0= ruleBooleanValues )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:290:1: (lv_x12_11_0= ruleBooleanValues )
                    // InternalSyntacticSequencerTestLanguage.g:291:3: lv_x12_11_0= ruleBooleanValues
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX12BooleanValuesParserRuleCall_11_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x12_11_0=ruleBooleanValues();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x12",
                              		lv_x12_11_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.BooleanValues");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalSyntacticSequencerTestLanguage.g:308:6: ( (lv_x13_12_0= ruleLongAlternative ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:308:6: ( (lv_x13_12_0= ruleLongAlternative ) )
                    // InternalSyntacticSequencerTestLanguage.g:309:1: (lv_x13_12_0= ruleLongAlternative )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:309:1: (lv_x13_12_0= ruleLongAlternative )
                    // InternalSyntacticSequencerTestLanguage.g:310:3: lv_x13_12_0= ruleLongAlternative
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX13LongAlternativeParserRuleCall_12_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x13_12_0=ruleLongAlternative();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x13",
                              		lv_x13_12_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.LongAlternative");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalSyntacticSequencerTestLanguage.g:327:6: ( (lv_x14_13_0= ruleActionOnly ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:327:6: ( (lv_x14_13_0= ruleActionOnly ) )
                    // InternalSyntacticSequencerTestLanguage.g:328:1: (lv_x14_13_0= ruleActionOnly )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:328:1: (lv_x14_13_0= ruleActionOnly )
                    // InternalSyntacticSequencerTestLanguage.g:329:3: lv_x14_13_0= ruleActionOnly
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getX14ActionOnlyParserRuleCall_13_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x14_13_0=ruleActionOnly();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"x14",
                              		lv_x14_13_0, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.ActionOnly");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleMandatoryKeywords"
    // InternalSyntacticSequencerTestLanguage.g:353:1: entryRuleMandatoryKeywords returns [EObject current=null] : iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF ;
    public final EObject entryRuleMandatoryKeywords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryKeywords = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:354:2: (iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF )
            // InternalSyntacticSequencerTestLanguage.g:355:2: iv_ruleMandatoryKeywords= ruleMandatoryKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMandatoryKeywordsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMandatoryKeywords=ruleMandatoryKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMandatoryKeywords; 
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
    // $ANTLR end "entryRuleMandatoryKeywords"


    // $ANTLR start "ruleMandatoryKeywords"
    // InternalSyntacticSequencerTestLanguage.g:362:1: ruleMandatoryKeywords returns [EObject current=null] : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) ;
    public final EObject ruleMandatoryKeywords() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_val3_6_0=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:365:28: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )
            // InternalSyntacticSequencerTestLanguage.g:366:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            {
            // InternalSyntacticSequencerTestLanguage.g:366:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
            // InternalSyntacticSequencerTestLanguage.g:366:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) otherlv_4= 'kw2' otherlv_5= 'kw3' ( (lv_val3_6_0= RULE_ID ) ) otherlv_7= 'kw4'
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMandatoryKeywordsAccess().getNumberSignDigitOneKeyword_0());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:370:1: ( (lv_val1_1_0= RULE_ID ) )
            // InternalSyntacticSequencerTestLanguage.g:371:1: (lv_val1_1_0= RULE_ID )
            {
            // InternalSyntacticSequencerTestLanguage.g:371:1: (lv_val1_1_0= RULE_ID )
            // InternalSyntacticSequencerTestLanguage.g:372:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_val1_1_0, grammarAccess.getMandatoryKeywordsAccess().getVal1IDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMandatoryKeywordsRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"val1",
                      		lv_val1_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMandatoryKeywordsAccess().getKw1Keyword_2());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:392:1: ( (lv_val2_3_0= RULE_ID ) )
            // InternalSyntacticSequencerTestLanguage.g:393:1: (lv_val2_3_0= RULE_ID )
            {
            // InternalSyntacticSequencerTestLanguage.g:393:1: (lv_val2_3_0= RULE_ID )
            // InternalSyntacticSequencerTestLanguage.g:394:3: lv_val2_3_0= RULE_ID
            {
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_val2_3_0, grammarAccess.getMandatoryKeywordsAccess().getVal2IDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMandatoryKeywordsRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"val2",
                      		lv_val2_3_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getMandatoryKeywordsAccess().getKw2Keyword_4());
                  
            }
            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMandatoryKeywordsAccess().getKw3Keyword_5());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:418:1: ( (lv_val3_6_0= RULE_ID ) )
            // InternalSyntacticSequencerTestLanguage.g:419:1: (lv_val3_6_0= RULE_ID )
            {
            // InternalSyntacticSequencerTestLanguage.g:419:1: (lv_val3_6_0= RULE_ID )
            // InternalSyntacticSequencerTestLanguage.g:420:3: lv_val3_6_0= RULE_ID
            {
            lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_val3_6_0, grammarAccess.getMandatoryKeywordsAccess().getVal3IDTerminalRuleCall_6_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMandatoryKeywordsRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"val3",
                      		lv_val3_6_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMandatoryKeywordsAccess().getKw4Keyword_7());
                  
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
    // $ANTLR end "ruleMandatoryKeywords"


    // $ANTLR start "entryRuleExp0"
    // InternalSyntacticSequencerTestLanguage.g:448:1: entryRuleExp0 returns [EObject current=null] : iv_ruleExp0= ruleExp0 EOF ;
    public final EObject entryRuleExp0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp0 = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:449:2: (iv_ruleExp0= ruleExp0 EOF )
            // InternalSyntacticSequencerTestLanguage.g:450:2: iv_ruleExp0= ruleExp0 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExp0Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExp0=ruleExp0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp0; 
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
    // $ANTLR end "entryRuleExp0"


    // $ANTLR start "ruleExp0"
    // InternalSyntacticSequencerTestLanguage.g:457:1: ruleExp0 returns [EObject current=null] : (otherlv_0= '#2' this_Addition0_1= ruleAddition0 ) ;
    public final EObject ruleExp0() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Addition0_1 = null;


         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:460:28: ( (otherlv_0= '#2' this_Addition0_1= ruleAddition0 ) )
            // InternalSyntacticSequencerTestLanguage.g:461:1: (otherlv_0= '#2' this_Addition0_1= ruleAddition0 )
            {
            // InternalSyntacticSequencerTestLanguage.g:461:1: (otherlv_0= '#2' this_Addition0_1= ruleAddition0 )
            // InternalSyntacticSequencerTestLanguage.g:461:3: otherlv_0= '#2' this_Addition0_1= ruleAddition0
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExp0Access().getNumberSignDigitTwoKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExp0Access().getAddition0ParserRuleCall_1()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Addition0_1=ruleAddition0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Addition0_1; 
                      afterParserOrEnumRuleCall();
                  
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
    // $ANTLR end "ruleExp0"


    // $ANTLR start "entryRuleAddition0"
    // InternalSyntacticSequencerTestLanguage.g:482:1: entryRuleAddition0 returns [EObject current=null] : iv_ruleAddition0= ruleAddition0 EOF ;
    public final EObject entryRuleAddition0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition0 = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:483:2: (iv_ruleAddition0= ruleAddition0 EOF )
            // InternalSyntacticSequencerTestLanguage.g:484:2: iv_ruleAddition0= ruleAddition0 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAddition0Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAddition0=ruleAddition0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition0; 
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
    // $ANTLR end "entryRuleAddition0"


    // $ANTLR start "ruleAddition0"
    // InternalSyntacticSequencerTestLanguage.g:491:1: ruleAddition0 returns [EObject current=null] : (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) ;
    public final EObject ruleAddition0() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim0_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:494:28: ( (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* ) )
            // InternalSyntacticSequencerTestLanguage.g:495:1: (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            {
            // InternalSyntacticSequencerTestLanguage.g:495:1: (this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )* )
            // InternalSyntacticSequencerTestLanguage.g:496:5: this_Prim0_0= rulePrim0 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAddition0Access().getPrim0ParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_8);
            this_Prim0_0=rulePrim0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Prim0_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:504:1: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSyntacticSequencerTestLanguage.g:504:2: () otherlv_2= '+' ( (lv_right_3_0= rulePrim0 ) )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:504:2: ()
            	    // InternalSyntacticSequencerTestLanguage.g:505:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAddition0Access().getAdd0LeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAddition0Access().getPlusSignKeyword_1_1());
            	          
            	    }
            	    // InternalSyntacticSequencerTestLanguage.g:514:1: ( (lv_right_3_0= rulePrim0 ) )
            	    // InternalSyntacticSequencerTestLanguage.g:515:1: (lv_right_3_0= rulePrim0 )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:515:1: (lv_right_3_0= rulePrim0 )
            	    // InternalSyntacticSequencerTestLanguage.g:516:3: lv_right_3_0= rulePrim0
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAddition0Access().getRightPrim0ParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_right_3_0=rulePrim0();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAddition0Rule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.Prim0");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end "ruleAddition0"


    // $ANTLR start "entryRulePrim0"
    // InternalSyntacticSequencerTestLanguage.g:540:1: entryRulePrim0 returns [EObject current=null] : iv_rulePrim0= rulePrim0 EOF ;
    public final EObject entryRulePrim0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim0 = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:541:2: (iv_rulePrim0= rulePrim0 EOF )
            // InternalSyntacticSequencerTestLanguage.g:542:2: iv_rulePrim0= rulePrim0 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrim0Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrim0=rulePrim0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrim0; 
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
    // $ANTLR end "entryRulePrim0"


    // $ANTLR start "rulePrim0"
    // InternalSyntacticSequencerTestLanguage.g:549:1: rulePrim0 returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePrim0() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:552:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSyntacticSequencerTestLanguage.g:553:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:553:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSyntacticSequencerTestLanguage.g:553:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:553:2: ()
            // InternalSyntacticSequencerTestLanguage.g:554:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPrim0Access().getVal0Action_0(),
                          current);
                  
            }

            }

            // InternalSyntacticSequencerTestLanguage.g:559:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalSyntacticSequencerTestLanguage.g:560:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSyntacticSequencerTestLanguage.g:560:1: (lv_name_1_0= RULE_ID )
            // InternalSyntacticSequencerTestLanguage.g:561:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getPrim0Access().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPrim0Rule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

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
    // $ANTLR end "rulePrim0"


    // $ANTLR start "entryRuleExp1"
    // InternalSyntacticSequencerTestLanguage.g:585:1: entryRuleExp1 returns [EObject current=null] : iv_ruleExp1= ruleExp1 EOF ;
    public final EObject entryRuleExp1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp1 = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:586:2: (iv_ruleExp1= ruleExp1 EOF )
            // InternalSyntacticSequencerTestLanguage.g:587:2: iv_ruleExp1= ruleExp1 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExp1Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExp1=ruleExp1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp1; 
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
    // $ANTLR end "entryRuleExp1"


    // $ANTLR start "ruleExp1"
    // InternalSyntacticSequencerTestLanguage.g:594:1: ruleExp1 returns [EObject current=null] : (otherlv_0= '#3' this_Addition1_1= ruleAddition1 ) ;
    public final EObject ruleExp1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Addition1_1 = null;


         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:597:28: ( (otherlv_0= '#3' this_Addition1_1= ruleAddition1 ) )
            // InternalSyntacticSequencerTestLanguage.g:598:1: (otherlv_0= '#3' this_Addition1_1= ruleAddition1 )
            {
            // InternalSyntacticSequencerTestLanguage.g:598:1: (otherlv_0= '#3' this_Addition1_1= ruleAddition1 )
            // InternalSyntacticSequencerTestLanguage.g:598:3: otherlv_0= '#3' this_Addition1_1= ruleAddition1
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExp1Access().getNumberSignDigitThreeKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExp1Access().getAddition1ParserRuleCall_1()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Addition1_1=ruleAddition1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Addition1_1; 
                      afterParserOrEnumRuleCall();
                  
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
    // $ANTLR end "ruleExp1"


    // $ANTLR start "entryRuleAddition1"
    // InternalSyntacticSequencerTestLanguage.g:619:1: entryRuleAddition1 returns [EObject current=null] : iv_ruleAddition1= ruleAddition1 EOF ;
    public final EObject entryRuleAddition1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition1 = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:620:2: (iv_ruleAddition1= ruleAddition1 EOF )
            // InternalSyntacticSequencerTestLanguage.g:621:2: iv_ruleAddition1= ruleAddition1 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAddition1Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAddition1=ruleAddition1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition1; 
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
    // $ANTLR end "entryRuleAddition1"


    // $ANTLR start "ruleAddition1"
    // InternalSyntacticSequencerTestLanguage.g:628:1: ruleAddition1 returns [EObject current=null] : (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) ;
    public final EObject ruleAddition1() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim1_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:631:28: ( (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* ) )
            // InternalSyntacticSequencerTestLanguage.g:632:1: (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            {
            // InternalSyntacticSequencerTestLanguage.g:632:1: (this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )* )
            // InternalSyntacticSequencerTestLanguage.g:633:5: this_Prim1_0= rulePrim1 ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAddition1Access().getPrim1ParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_8);
            this_Prim1_0=rulePrim1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Prim1_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:641:1: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSyntacticSequencerTestLanguage.g:641:2: () otherlv_2= '+' ( (lv_right_3_0= rulePrim1 ) )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:641:2: ()
            	    // InternalSyntacticSequencerTestLanguage.g:642:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAddition1Access().getAdd1LeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAddition1Access().getPlusSignKeyword_1_1());
            	          
            	    }
            	    // InternalSyntacticSequencerTestLanguage.g:651:1: ( (lv_right_3_0= rulePrim1 ) )
            	    // InternalSyntacticSequencerTestLanguage.g:652:1: (lv_right_3_0= rulePrim1 )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:652:1: (lv_right_3_0= rulePrim1 )
            	    // InternalSyntacticSequencerTestLanguage.g:653:3: lv_right_3_0= rulePrim1
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAddition1Access().getRightPrim1ParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_right_3_0=rulePrim1();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAddition1Rule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.Prim1");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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
    // $ANTLR end "ruleAddition1"


    // $ANTLR start "entryRulePrim1"
    // InternalSyntacticSequencerTestLanguage.g:677:1: entryRulePrim1 returns [EObject current=null] : iv_rulePrim1= rulePrim1 EOF ;
    public final EObject entryRulePrim1() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim1 = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:678:2: (iv_rulePrim1= rulePrim1 EOF )
            // InternalSyntacticSequencerTestLanguage.g:679:2: iv_rulePrim1= rulePrim1 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrim1Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrim1=rulePrim1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrim1; 
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
    // $ANTLR end "entryRulePrim1"


    // $ANTLR start "rulePrim1"
    // InternalSyntacticSequencerTestLanguage.g:686:1: rulePrim1 returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) ) ;
    public final EObject rulePrim1() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Addition1_3 = null;


         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:689:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) ) )
            // InternalSyntacticSequencerTestLanguage.g:690:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:690:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==21) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:690:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:690:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // InternalSyntacticSequencerTestLanguage.g:690:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:690:3: ()
                    // InternalSyntacticSequencerTestLanguage.g:691:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrim1Access().getVal1Action_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSyntacticSequencerTestLanguage.g:696:2: ( (lv_name_1_0= RULE_ID ) )
                    // InternalSyntacticSequencerTestLanguage.g:697:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:697:1: (lv_name_1_0= RULE_ID )
                    // InternalSyntacticSequencerTestLanguage.g:698:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getPrim1Access().getNameIDTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrim1Rule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSyntacticSequencerTestLanguage.g:715:6: (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:715:6: (otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')' )
                    // InternalSyntacticSequencerTestLanguage.g:715:8: otherlv_2= '(' this_Addition1_3= ruleAddition1 otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getPrim1Access().getLeftParenthesisKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrim1Access().getAddition1ParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    this_Addition1_3=ruleAddition1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Addition1_3; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPrim1Access().getRightParenthesisKeyword_1_2());
                          
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
    // $ANTLR end "rulePrim1"


    // $ANTLR start "entryRuleExp2"
    // InternalSyntacticSequencerTestLanguage.g:740:1: entryRuleExp2 returns [EObject current=null] : iv_ruleExp2= ruleExp2 EOF ;
    public final EObject entryRuleExp2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp2 = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:741:2: (iv_ruleExp2= ruleExp2 EOF )
            // InternalSyntacticSequencerTestLanguage.g:742:2: iv_ruleExp2= ruleExp2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExp2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExp2=ruleExp2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp2; 
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
    // $ANTLR end "entryRuleExp2"


    // $ANTLR start "ruleExp2"
    // InternalSyntacticSequencerTestLanguage.g:749:1: ruleExp2 returns [EObject current=null] : (otherlv_0= '#4' this_Addition2_1= ruleAddition2 ) ;
    public final EObject ruleExp2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Addition2_1 = null;


         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:752:28: ( (otherlv_0= '#4' this_Addition2_1= ruleAddition2 ) )
            // InternalSyntacticSequencerTestLanguage.g:753:1: (otherlv_0= '#4' this_Addition2_1= ruleAddition2 )
            {
            // InternalSyntacticSequencerTestLanguage.g:753:1: (otherlv_0= '#4' this_Addition2_1= ruleAddition2 )
            // InternalSyntacticSequencerTestLanguage.g:753:3: otherlv_0= '#4' this_Addition2_1= ruleAddition2
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExp2Access().getNumberSignDigitFourKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExp2Access().getAddition2ParserRuleCall_1()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Addition2_1=ruleAddition2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Addition2_1; 
                      afterParserOrEnumRuleCall();
                  
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
    // $ANTLR end "ruleExp2"


    // $ANTLR start "entryRuleAddition2"
    // InternalSyntacticSequencerTestLanguage.g:774:1: entryRuleAddition2 returns [EObject current=null] : iv_ruleAddition2= ruleAddition2 EOF ;
    public final EObject entryRuleAddition2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition2 = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:775:2: (iv_ruleAddition2= ruleAddition2 EOF )
            // InternalSyntacticSequencerTestLanguage.g:776:2: iv_ruleAddition2= ruleAddition2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAddition2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAddition2=ruleAddition2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition2; 
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
    // $ANTLR end "entryRuleAddition2"


    // $ANTLR start "ruleAddition2"
    // InternalSyntacticSequencerTestLanguage.g:783:1: ruleAddition2 returns [EObject current=null] : (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) ;
    public final EObject ruleAddition2() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Multiplication2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:786:28: ( (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* ) )
            // InternalSyntacticSequencerTestLanguage.g:787:1: (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            {
            // InternalSyntacticSequencerTestLanguage.g:787:1: (this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )* )
            // InternalSyntacticSequencerTestLanguage.g:788:5: this_Multiplication2_0= ruleMultiplication2 ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAddition2Access().getMultiplication2ParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_8);
            this_Multiplication2_0=ruleMultiplication2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Multiplication2_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:796:1: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalSyntacticSequencerTestLanguage.g:796:2: () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication2 ) )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:796:2: ()
            	    // InternalSyntacticSequencerTestLanguage.g:797:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAddition2Access().getAdd2LeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAddition2Access().getPlusSignKeyword_1_1());
            	          
            	    }
            	    // InternalSyntacticSequencerTestLanguage.g:806:1: ( (lv_right_3_0= ruleMultiplication2 ) )
            	    // InternalSyntacticSequencerTestLanguage.g:807:1: (lv_right_3_0= ruleMultiplication2 )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:807:1: (lv_right_3_0= ruleMultiplication2 )
            	    // InternalSyntacticSequencerTestLanguage.g:808:3: lv_right_3_0= ruleMultiplication2
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAddition2Access().getRightMultiplication2ParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_right_3_0=ruleMultiplication2();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAddition2Rule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.Multiplication2");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


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
    // $ANTLR end "ruleAddition2"


    // $ANTLR start "entryRuleMultiplication2"
    // InternalSyntacticSequencerTestLanguage.g:832:1: entryRuleMultiplication2 returns [EObject current=null] : iv_ruleMultiplication2= ruleMultiplication2 EOF ;
    public final EObject entryRuleMultiplication2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication2 = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:833:2: (iv_ruleMultiplication2= ruleMultiplication2 EOF )
            // InternalSyntacticSequencerTestLanguage.g:834:2: iv_ruleMultiplication2= ruleMultiplication2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplication2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiplication2=ruleMultiplication2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication2; 
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
    // $ANTLR end "entryRuleMultiplication2"


    // $ANTLR start "ruleMultiplication2"
    // InternalSyntacticSequencerTestLanguage.g:841:1: ruleMultiplication2 returns [EObject current=null] : (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) ;
    public final EObject ruleMultiplication2() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:844:28: ( (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* ) )
            // InternalSyntacticSequencerTestLanguage.g:845:1: (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            {
            // InternalSyntacticSequencerTestLanguage.g:845:1: (this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )* )
            // InternalSyntacticSequencerTestLanguage.g:846:5: this_Prim2_0= rulePrim2 ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplication2Access().getPrim2ParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_11);
            this_Prim2_0=rulePrim2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Prim2_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:854:1: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalSyntacticSequencerTestLanguage.g:854:2: () otherlv_2= '*' ( (lv_right_3_0= rulePrim2 ) )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:854:2: ()
            	    // InternalSyntacticSequencerTestLanguage.g:855:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplication2Access().getMult2LeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getMultiplication2Access().getAsteriskKeyword_1_1());
            	          
            	    }
            	    // InternalSyntacticSequencerTestLanguage.g:864:1: ( (lv_right_3_0= rulePrim2 ) )
            	    // InternalSyntacticSequencerTestLanguage.g:865:1: (lv_right_3_0= rulePrim2 )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:865:1: (lv_right_3_0= rulePrim2 )
            	    // InternalSyntacticSequencerTestLanguage.g:866:3: lv_right_3_0= rulePrim2
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplication2Access().getRightPrim2ParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_right_3_0=rulePrim2();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplication2Rule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.Prim2");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


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
    // $ANTLR end "ruleMultiplication2"


    // $ANTLR start "entryRulePrim2"
    // InternalSyntacticSequencerTestLanguage.g:890:1: entryRulePrim2 returns [EObject current=null] : iv_rulePrim2= rulePrim2 EOF ;
    public final EObject entryRulePrim2() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim2 = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:891:2: (iv_rulePrim2= rulePrim2 EOF )
            // InternalSyntacticSequencerTestLanguage.g:892:2: iv_rulePrim2= rulePrim2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrim2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrim2=rulePrim2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrim2; 
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
    // $ANTLR end "entryRulePrim2"


    // $ANTLR start "rulePrim2"
    // InternalSyntacticSequencerTestLanguage.g:899:1: rulePrim2 returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) ) ;
    public final EObject rulePrim2() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Addition2_3 = null;


         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:902:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) ) )
            // InternalSyntacticSequencerTestLanguage.g:903:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:903:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==21) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:903:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:903:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // InternalSyntacticSequencerTestLanguage.g:903:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:903:3: ()
                    // InternalSyntacticSequencerTestLanguage.g:904:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrim2Access().getVal2Action_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSyntacticSequencerTestLanguage.g:909:2: ( (lv_name_1_0= RULE_ID ) )
                    // InternalSyntacticSequencerTestLanguage.g:910:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:910:1: (lv_name_1_0= RULE_ID )
                    // InternalSyntacticSequencerTestLanguage.g:911:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getPrim2Access().getNameIDTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrim2Rule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSyntacticSequencerTestLanguage.g:928:6: (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:928:6: (otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')' )
                    // InternalSyntacticSequencerTestLanguage.g:928:8: otherlv_2= '(' this_Addition2_3= ruleAddition2 otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getPrim2Access().getLeftParenthesisKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrim2Access().getAddition2ParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    this_Addition2_3=ruleAddition2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Addition2_3; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPrim2Access().getRightParenthesisKeyword_1_2());
                          
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
    // $ANTLR end "rulePrim2"


    // $ANTLR start "entryRuleDatatypeID"
    // InternalSyntacticSequencerTestLanguage.g:953:1: entryRuleDatatypeID returns [String current=null] : iv_ruleDatatypeID= ruleDatatypeID EOF ;
    public final String entryRuleDatatypeID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatypeID = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:954:2: (iv_ruleDatatypeID= ruleDatatypeID EOF )
            // InternalSyntacticSequencerTestLanguage.g:955:2: iv_ruleDatatypeID= ruleDatatypeID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDatatypeIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatypeID=ruleDatatypeID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDatatypeID.getText(); 
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
    // $ANTLR end "entryRuleDatatypeID"


    // $ANTLR start "ruleDatatypeID"
    // InternalSyntacticSequencerTestLanguage.g:962:1: ruleDatatypeID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleDatatypeID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:965:28: (this_ID_0= RULE_ID )
            // InternalSyntacticSequencerTestLanguage.g:966:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getDatatypeIDAccess().getIDTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleDatatypeID"


    // $ANTLR start "entryRuleSingleCrossReference"
    // InternalSyntacticSequencerTestLanguage.g:981:1: entryRuleSingleCrossReference returns [EObject current=null] : iv_ruleSingleCrossReference= ruleSingleCrossReference EOF ;
    public final EObject entryRuleSingleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleCrossReference = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:982:2: (iv_ruleSingleCrossReference= ruleSingleCrossReference EOF )
            // InternalSyntacticSequencerTestLanguage.g:983:2: iv_ruleSingleCrossReference= ruleSingleCrossReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSingleCrossReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleCrossReference=ruleSingleCrossReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSingleCrossReference; 
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
    // $ANTLR end "entryRuleSingleCrossReference"


    // $ANTLR start "ruleSingleCrossReference"
    // InternalSyntacticSequencerTestLanguage.g:990:1: ruleSingleCrossReference returns [EObject current=null] : (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) ;
    public final EObject ruleSingleCrossReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:993:28: ( (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? ) )
            // InternalSyntacticSequencerTestLanguage.g:994:1: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            {
            // InternalSyntacticSequencerTestLanguage.g:994:1: (otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )? )
            // InternalSyntacticSequencerTestLanguage.g:994:3: otherlv_0= '#5' ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) ) (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )? (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )? (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )? (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSingleCrossReferenceAccess().getNumberSignDigitFiveKeyword_0());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:998:1: ( ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) ) )
            // InternalSyntacticSequencerTestLanguage.g:999:1: ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:999:1: ( (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID ) )
            // InternalSyntacticSequencerTestLanguage.g:1000:1: (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID )
            {
            // InternalSyntacticSequencerTestLanguage.g:1000:1: (lv_name_1_1= RULE_TERMINAL_ID | lv_name_1_2= RULE_ID )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_TERMINAL_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1001:3: lv_name_1_1= RULE_TERMINAL_ID
                    {
                    lv_name_1_1=(Token)match(input,RULE_TERMINAL_ID,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_1, grammarAccess.getSingleCrossReferenceAccess().getNameTERMINAL_IDTerminalRuleCall_1_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_1, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.TERMINAL_ID");
                      	    
                    }

                    }
                    break;
                case 2 :
                    // InternalSyntacticSequencerTestLanguage.g:1016:8: lv_name_1_2= RULE_ID
                    {
                    lv_name_1_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_2, grammarAccess.getSingleCrossReferenceAccess().getNameIDTerminalRuleCall_1_0_1()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_2, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // InternalSyntacticSequencerTestLanguage.g:1034:2: (otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==14) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1034:4: otherlv_2= 'kw1' ( (otherlv_3= RULE_TERMINAL_ID ) )
                    {
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSingleCrossReferenceAccess().getKw1Keyword_2_0());
                          
                    }
                    // InternalSyntacticSequencerTestLanguage.g:1038:1: ( (otherlv_3= RULE_TERMINAL_ID ) )
                    // InternalSyntacticSequencerTestLanguage.g:1039:1: (otherlv_3= RULE_TERMINAL_ID )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:1039:1: (otherlv_3= RULE_TERMINAL_ID )
                    // InternalSyntacticSequencerTestLanguage.g:1040:3: otherlv_3= RULE_TERMINAL_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_TERMINAL_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getSingleCrossReferenceAccess().getRef1SingleCrossReferenceCrossReference_2_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSyntacticSequencerTestLanguage.g:1051:4: (otherlv_4= 'kw2' ( ( ruleDatatypeID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1051:6: otherlv_4= 'kw2' ( ( ruleDatatypeID ) )
                    {
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getSingleCrossReferenceAccess().getKw2Keyword_3_0());
                          
                    }
                    // InternalSyntacticSequencerTestLanguage.g:1055:1: ( ( ruleDatatypeID ) )
                    // InternalSyntacticSequencerTestLanguage.g:1056:1: ( ruleDatatypeID )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:1056:1: ( ruleDatatypeID )
                    // InternalSyntacticSequencerTestLanguage.g:1057:3: ruleDatatypeID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSingleCrossReferenceAccess().getRef2SingleCrossReferenceCrossReference_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
                    ruleDatatypeID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSyntacticSequencerTestLanguage.g:1070:4: (otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1070:6: otherlv_6= 'kw3' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSingleCrossReferenceAccess().getKw3Keyword_4_0());
                          
                    }
                    // InternalSyntacticSequencerTestLanguage.g:1074:1: ( (otherlv_7= RULE_ID ) )
                    // InternalSyntacticSequencerTestLanguage.g:1075:1: (otherlv_7= RULE_ID )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:1075:1: (otherlv_7= RULE_ID )
                    // InternalSyntacticSequencerTestLanguage.g:1076:3: otherlv_7= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                      	        }
                              
                    }
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_7, grammarAccess.getSingleCrossReferenceAccess().getRef3SingleCrossReferenceCrossReference_4_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSyntacticSequencerTestLanguage.g:1087:4: (otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1087:6: otherlv_8= 'kw4' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getSingleCrossReferenceAccess().getKw4Keyword_5_0());
                          
                    }
                    // InternalSyntacticSequencerTestLanguage.g:1091:1: ( (otherlv_9= RULE_ID ) )
                    // InternalSyntacticSequencerTestLanguage.g:1092:1: (otherlv_9= RULE_ID )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:1092:1: (otherlv_9= RULE_ID )
                    // InternalSyntacticSequencerTestLanguage.g:1093:3: otherlv_9= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                      	        }
                              
                    }
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_9, grammarAccess.getSingleCrossReferenceAccess().getRef4SingleCrossReferenceCrossReference_5_1_0()); 
                      	
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
    // $ANTLR end "ruleSingleCrossReference"


    // $ANTLR start "entryRuleBooleanAlternative"
    // InternalSyntacticSequencerTestLanguage.g:1112:1: entryRuleBooleanAlternative returns [EObject current=null] : iv_ruleBooleanAlternative= ruleBooleanAlternative EOF ;
    public final EObject entryRuleBooleanAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAlternative = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:1113:2: (iv_ruleBooleanAlternative= ruleBooleanAlternative EOF )
            // InternalSyntacticSequencerTestLanguage.g:1114:2: iv_ruleBooleanAlternative= ruleBooleanAlternative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanAlternativeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanAlternative=ruleBooleanAlternative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanAlternative; 
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
    // $ANTLR end "entryRuleBooleanAlternative"


    // $ANTLR start "ruleBooleanAlternative"
    // InternalSyntacticSequencerTestLanguage.g:1121:1: ruleBooleanAlternative returns [EObject current=null] : (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) ;
    public final EObject ruleBooleanAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_bool_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:1124:28: ( (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1125:1: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:1125:1: (otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1125:3: otherlv_0= '#6' ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBooleanAlternativeAccess().getNumberSignDigitSixKeyword_0());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:1129:1: ( (lv_bool_1_0= ruleBooleanAlternativeLiteral ) )
            // InternalSyntacticSequencerTestLanguage.g:1130:1: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            {
            // InternalSyntacticSequencerTestLanguage.g:1130:1: (lv_bool_1_0= ruleBooleanAlternativeLiteral )
            // InternalSyntacticSequencerTestLanguage.g:1131:3: lv_bool_1_0= ruleBooleanAlternativeLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBooleanAlternativeAccess().getBoolBooleanAlternativeLiteralParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_bool_1_0=ruleBooleanAlternativeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBooleanAlternativeRule());
              	        }
                     		set(
                     			current, 
                     			"bool",
                      		lv_bool_1_0, 
                      		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.BooleanAlternativeLiteral");
              	        afterParserOrEnumRuleCall();
              	    
            }

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
    // $ANTLR end "ruleBooleanAlternative"


    // $ANTLR start "entryRuleBooleanAlternativeLiteral"
    // InternalSyntacticSequencerTestLanguage.g:1155:1: entryRuleBooleanAlternativeLiteral returns [EObject current=null] : iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF ;
    public final EObject entryRuleBooleanAlternativeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAlternativeLiteral = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:1156:2: (iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF )
            // InternalSyntacticSequencerTestLanguage.g:1157:2: iv_ruleBooleanAlternativeLiteral= ruleBooleanAlternativeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanAlternativeLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanAlternativeLiteral=ruleBooleanAlternativeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanAlternativeLiteral; 
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
    // $ANTLR end "entryRuleBooleanAlternativeLiteral"


    // $ANTLR start "ruleBooleanAlternativeLiteral"
    // InternalSyntacticSequencerTestLanguage.g:1164:1: ruleBooleanAlternativeLiteral returns [EObject current=null] : ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) ;
    public final EObject ruleBooleanAlternativeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:1167:28: ( ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1168:1: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:1168:1: ( () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1168:2: () (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:1168:2: ()
            // InternalSyntacticSequencerTestLanguage.g:1169:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBooleanAlternativeLiteralAccess().getBooleanAlternativeLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalSyntacticSequencerTestLanguage.g:1174:2: (otherlv_1= 'kw1' | ( (lv_isTrue_2_0= 'kw2' ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==14) ) {
                alt13=1;
            }
            else if ( (LA13_0==15) ) {
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
                    // InternalSyntacticSequencerTestLanguage.g:1174:4: otherlv_1= 'kw1'
                    {
                    otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getBooleanAlternativeLiteralAccess().getKw1Keyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSyntacticSequencerTestLanguage.g:1179:6: ( (lv_isTrue_2_0= 'kw2' ) )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:1179:6: ( (lv_isTrue_2_0= 'kw2' ) )
                    // InternalSyntacticSequencerTestLanguage.g:1180:1: (lv_isTrue_2_0= 'kw2' )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:1180:1: (lv_isTrue_2_0= 'kw2' )
                    // InternalSyntacticSequencerTestLanguage.g:1181:3: lv_isTrue_2_0= 'kw2'
                    {
                    lv_isTrue_2_0=(Token)match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isTrue_2_0, grammarAccess.getBooleanAlternativeLiteralAccess().getIsTrueKw2Keyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanAlternativeLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "isTrue", true, "kw2");
                      	    
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
    // $ANTLR end "ruleBooleanAlternativeLiteral"


    // $ANTLR start "entryRuleUnassignedDatatype"
    // InternalSyntacticSequencerTestLanguage.g:1202:1: entryRuleUnassignedDatatype returns [EObject current=null] : iv_ruleUnassignedDatatype= ruleUnassignedDatatype EOF ;
    public final EObject entryRuleUnassignedDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedDatatype = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:1203:2: (iv_ruleUnassignedDatatype= ruleUnassignedDatatype EOF )
            // InternalSyntacticSequencerTestLanguage.g:1204:2: iv_ruleUnassignedDatatype= ruleUnassignedDatatype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnassignedDatatypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedDatatype=ruleUnassignedDatatype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnassignedDatatype; 
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
    // $ANTLR end "entryRuleUnassignedDatatype"


    // $ANTLR start "ruleUnassignedDatatype"
    // InternalSyntacticSequencerTestLanguage.g:1211:1: ruleUnassignedDatatype returns [EObject current=null] : (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 ) ;
    public final EObject ruleUnassignedDatatype() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:1214:28: ( (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 ) )
            // InternalSyntacticSequencerTestLanguage.g:1215:1: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 )
            {
            // InternalSyntacticSequencerTestLanguage.g:1215:1: (otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1 )
            // InternalSyntacticSequencerTestLanguage.g:1215:3: otherlv_0= '#7' ( (lv_val_1_0= RULE_ID ) ) ruleKW1
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getUnassignedDatatypeAccess().getNumberSignDigitSevenKeyword_0());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:1219:1: ( (lv_val_1_0= RULE_ID ) )
            // InternalSyntacticSequencerTestLanguage.g:1220:1: (lv_val_1_0= RULE_ID )
            {
            // InternalSyntacticSequencerTestLanguage.g:1220:1: (lv_val_1_0= RULE_ID )
            // InternalSyntacticSequencerTestLanguage.g:1221:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_val_1_0, grammarAccess.getUnassignedDatatypeAccess().getValIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getUnassignedDatatypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"val",
                      		lv_val_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnassignedDatatypeAccess().getKW1ParserRuleCall_2()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleKW1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
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
    // $ANTLR end "ruleUnassignedDatatype"


    // $ANTLR start "entryRuleKW1"
    // InternalSyntacticSequencerTestLanguage.g:1253:1: entryRuleKW1 returns [String current=null] : iv_ruleKW1= ruleKW1 EOF ;
    public final String entryRuleKW1() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKW1 = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:1254:2: (iv_ruleKW1= ruleKW1 EOF )
            // InternalSyntacticSequencerTestLanguage.g:1255:2: iv_ruleKW1= ruleKW1 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKW1Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKW1=ruleKW1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKW1.getText(); 
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
    // $ANTLR end "entryRuleKW1"


    // $ANTLR start "ruleKW1"
    // InternalSyntacticSequencerTestLanguage.g:1262:1: ruleKW1 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) ) ;
    public final AntlrDatatypeRuleToken ruleKW1() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:1265:28: ( (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1266:1: (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:1266:1: (kw= 'kw1' | (kw= 'matched' (this_INT_2= RULE_INT )? ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==14) ) {
                alt15=1;
            }
            else if ( (LA15_0==28) ) {
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
                    // InternalSyntacticSequencerTestLanguage.g:1267:2: kw= 'kw1'
                    {
                    kw=(Token)match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getKW1Access().getKw1Keyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSyntacticSequencerTestLanguage.g:1273:6: (kw= 'matched' (this_INT_2= RULE_INT )? )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:1273:6: (kw= 'matched' (this_INT_2= RULE_INT )? )
                    // InternalSyntacticSequencerTestLanguage.g:1274:2: kw= 'matched' (this_INT_2= RULE_INT )?
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getKW1Access().getMatchedKeyword_1_0()); 
                          
                    }
                    // InternalSyntacticSequencerTestLanguage.g:1279:1: (this_INT_2= RULE_INT )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_INT) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalSyntacticSequencerTestLanguage.g:1279:6: this_INT_2= RULE_INT
                            {
                            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_INT_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_INT_2, grammarAccess.getKW1Access().getINTTerminalRuleCall_1_1()); 
                                  
                            }

                            }
                            break;

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
    // $ANTLR end "ruleKW1"


    // $ANTLR start "entryRuleOptionalSingleTransition"
    // InternalSyntacticSequencerTestLanguage.g:1294:1: entryRuleOptionalSingleTransition returns [EObject current=null] : iv_ruleOptionalSingleTransition= ruleOptionalSingleTransition EOF ;
    public final EObject entryRuleOptionalSingleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalSingleTransition = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:1295:2: (iv_ruleOptionalSingleTransition= ruleOptionalSingleTransition EOF )
            // InternalSyntacticSequencerTestLanguage.g:1296:2: iv_ruleOptionalSingleTransition= ruleOptionalSingleTransition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOptionalSingleTransitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptionalSingleTransition=ruleOptionalSingleTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptionalSingleTransition; 
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
    // $ANTLR end "entryRuleOptionalSingleTransition"


    // $ANTLR start "ruleOptionalSingleTransition"
    // InternalSyntacticSequencerTestLanguage.g:1303:1: ruleOptionalSingleTransition returns [EObject current=null] : (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalSingleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_2_0=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:1306:28: ( (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1307:1: (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:1307:1: (otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1307:3: otherlv_0= '#8' ( ruleKW1 )? ( (lv_val_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOptionalSingleTransitionAccess().getNumberSignDigitEightKeyword_0());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:1311:1: ( ruleKW1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14||LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1312:5: ruleKW1
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getOptionalSingleTransitionAccess().getKW1ParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_3);
                    ruleKW1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            // InternalSyntacticSequencerTestLanguage.g:1319:3: ( (lv_val_2_0= RULE_ID ) )
            // InternalSyntacticSequencerTestLanguage.g:1320:1: (lv_val_2_0= RULE_ID )
            {
            // InternalSyntacticSequencerTestLanguage.g:1320:1: (lv_val_2_0= RULE_ID )
            // InternalSyntacticSequencerTestLanguage.g:1321:3: lv_val_2_0= RULE_ID
            {
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_val_2_0, grammarAccess.getOptionalSingleTransitionAccess().getValIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOptionalSingleTransitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"val",
                      		lv_val_2_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

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
    // $ANTLR end "ruleOptionalSingleTransition"


    // $ANTLR start "entryRuleOptionalManyTransition"
    // InternalSyntacticSequencerTestLanguage.g:1345:1: entryRuleOptionalManyTransition returns [EObject current=null] : iv_ruleOptionalManyTransition= ruleOptionalManyTransition EOF ;
    public final EObject entryRuleOptionalManyTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalManyTransition = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:1346:2: (iv_ruleOptionalManyTransition= ruleOptionalManyTransition EOF )
            // InternalSyntacticSequencerTestLanguage.g:1347:2: iv_ruleOptionalManyTransition= ruleOptionalManyTransition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOptionalManyTransitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptionalManyTransition=ruleOptionalManyTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptionalManyTransition; 
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
    // $ANTLR end "entryRuleOptionalManyTransition"


    // $ANTLR start "ruleOptionalManyTransition"
    // InternalSyntacticSequencerTestLanguage.g:1354:1: ruleOptionalManyTransition returns [EObject current=null] : (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalManyTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_2_0=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:1357:28: ( (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1358:1: (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:1358:1: (otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1358:3: otherlv_0= '#9' ( ruleKW1 )* ( (lv_val_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOptionalManyTransitionAccess().getNumberSignDigitNineKeyword_0());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:1362:1: ( ruleKW1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==14||LA17_0==28) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalSyntacticSequencerTestLanguage.g:1363:5: ruleKW1
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getOptionalManyTransitionAccess().getKW1ParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    ruleKW1();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // InternalSyntacticSequencerTestLanguage.g:1370:3: ( (lv_val_2_0= RULE_ID ) )
            // InternalSyntacticSequencerTestLanguage.g:1371:1: (lv_val_2_0= RULE_ID )
            {
            // InternalSyntacticSequencerTestLanguage.g:1371:1: (lv_val_2_0= RULE_ID )
            // InternalSyntacticSequencerTestLanguage.g:1372:3: lv_val_2_0= RULE_ID
            {
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_val_2_0, grammarAccess.getOptionalManyTransitionAccess().getValIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOptionalManyTransitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"val",
                      		lv_val_2_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

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
    // $ANTLR end "ruleOptionalManyTransition"


    // $ANTLR start "entryRuleMandatoryManyTransition"
    // InternalSyntacticSequencerTestLanguage.g:1396:1: entryRuleMandatoryManyTransition returns [EObject current=null] : iv_ruleMandatoryManyTransition= ruleMandatoryManyTransition EOF ;
    public final EObject entryRuleMandatoryManyTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryManyTransition = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:1397:2: (iv_ruleMandatoryManyTransition= ruleMandatoryManyTransition EOF )
            // InternalSyntacticSequencerTestLanguage.g:1398:2: iv_ruleMandatoryManyTransition= ruleMandatoryManyTransition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMandatoryManyTransitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMandatoryManyTransition=ruleMandatoryManyTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMandatoryManyTransition; 
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
    // $ANTLR end "entryRuleMandatoryManyTransition"


    // $ANTLR start "ruleMandatoryManyTransition"
    // InternalSyntacticSequencerTestLanguage.g:1405:1: ruleMandatoryManyTransition returns [EObject current=null] : (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) ) ;
    public final EObject ruleMandatoryManyTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_2_0=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:1408:28: ( (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1409:1: (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:1409:1: (otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1409:3: otherlv_0= '#10' ( ruleKW1 )+ ( (lv_val_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMandatoryManyTransitionAccess().getNumberSignDigitOneDigitZeroKeyword_0());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:1413:1: ( ruleKW1 )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==14||LA18_0==28) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSyntacticSequencerTestLanguage.g:1414:5: ruleKW1
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMandatoryManyTransitionAccess().getKW1ParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    ruleKW1();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            // InternalSyntacticSequencerTestLanguage.g:1421:3: ( (lv_val_2_0= RULE_ID ) )
            // InternalSyntacticSequencerTestLanguage.g:1422:1: (lv_val_2_0= RULE_ID )
            {
            // InternalSyntacticSequencerTestLanguage.g:1422:1: (lv_val_2_0= RULE_ID )
            // InternalSyntacticSequencerTestLanguage.g:1423:3: lv_val_2_0= RULE_ID
            {
            lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_val_2_0, grammarAccess.getMandatoryManyTransitionAccess().getValIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMandatoryManyTransitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"val",
                      		lv_val_2_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

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
    // $ANTLR end "ruleMandatoryManyTransition"


    // $ANTLR start "entryRuleAlternativeTransition"
    // InternalSyntacticSequencerTestLanguage.g:1447:1: entryRuleAlternativeTransition returns [EObject current=null] : iv_ruleAlternativeTransition= ruleAlternativeTransition EOF ;
    public final EObject entryRuleAlternativeTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeTransition = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:1448:2: (iv_ruleAlternativeTransition= ruleAlternativeTransition EOF )
            // InternalSyntacticSequencerTestLanguage.g:1449:2: iv_ruleAlternativeTransition= ruleAlternativeTransition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAlternativeTransitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAlternativeTransition=ruleAlternativeTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlternativeTransition; 
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
    // $ANTLR end "entryRuleAlternativeTransition"


    // $ANTLR start "ruleAlternativeTransition"
    // InternalSyntacticSequencerTestLanguage.g:1456:1: ruleAlternativeTransition returns [EObject current=null] : (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) ) ;
    public final EObject ruleAlternativeTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_val_3_0=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:1459:28: ( (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1460:1: (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) )
            {
            // InternalSyntacticSequencerTestLanguage.g:1460:1: (otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) ) )
            // InternalSyntacticSequencerTestLanguage.g:1460:3: otherlv_0= '#11' ( ruleKW1 | otherlv_2= 'kw2' ) ( (lv_val_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAlternativeTransitionAccess().getNumberSignDigitOneDigitOneKeyword_0());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:1464:1: ( ruleKW1 | otherlv_2= 'kw2' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==14||LA19_0==28) ) {
                alt19=1;
            }
            else if ( (LA19_0==15) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1465:5: ruleKW1
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAlternativeTransitionAccess().getKW1ParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_3);
                    ruleKW1();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSyntacticSequencerTestLanguage.g:1473:7: otherlv_2= 'kw2'
                    {
                    otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAlternativeTransitionAccess().getKw2Keyword_1_1());
                          
                    }

                    }
                    break;

            }

            // InternalSyntacticSequencerTestLanguage.g:1477:2: ( (lv_val_3_0= RULE_ID ) )
            // InternalSyntacticSequencerTestLanguage.g:1478:1: (lv_val_3_0= RULE_ID )
            {
            // InternalSyntacticSequencerTestLanguage.g:1478:1: (lv_val_3_0= RULE_ID )
            // InternalSyntacticSequencerTestLanguage.g:1479:3: lv_val_3_0= RULE_ID
            {
            lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_val_3_0, grammarAccess.getAlternativeTransitionAccess().getValIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAlternativeTransitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"val",
                      		lv_val_3_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

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
    // $ANTLR end "ruleAlternativeTransition"


    // $ANTLR start "entryRuleBooleanDatatypeID"
    // InternalSyntacticSequencerTestLanguage.g:1503:1: entryRuleBooleanDatatypeID returns [String current=null] : iv_ruleBooleanDatatypeID= ruleBooleanDatatypeID EOF ;
    public final String entryRuleBooleanDatatypeID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBooleanDatatypeID = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:1504:2: (iv_ruleBooleanDatatypeID= ruleBooleanDatatypeID EOF )
            // InternalSyntacticSequencerTestLanguage.g:1505:2: iv_ruleBooleanDatatypeID= ruleBooleanDatatypeID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanDatatypeIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanDatatypeID=ruleBooleanDatatypeID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanDatatypeID.getText(); 
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
    // $ANTLR end "entryRuleBooleanDatatypeID"


    // $ANTLR start "ruleBooleanDatatypeID"
    // InternalSyntacticSequencerTestLanguage.g:1512:1: ruleBooleanDatatypeID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleBooleanDatatypeID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:1515:28: (this_ID_0= RULE_ID )
            // InternalSyntacticSequencerTestLanguage.g:1516:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getBooleanDatatypeIDAccess().getIDTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleBooleanDatatypeID"


    // $ANTLR start "entryRuleBooleanValues"
    // InternalSyntacticSequencerTestLanguage.g:1531:1: entryRuleBooleanValues returns [EObject current=null] : iv_ruleBooleanValues= ruleBooleanValues EOF ;
    public final EObject entryRuleBooleanValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanValues = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:1532:2: (iv_ruleBooleanValues= ruleBooleanValues EOF )
            // InternalSyntacticSequencerTestLanguage.g:1533:2: iv_ruleBooleanValues= ruleBooleanValues EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanValuesRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanValues=ruleBooleanValues();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanValues; 
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
    // $ANTLR end "entryRuleBooleanValues"


    // $ANTLR start "ruleBooleanValues"
    // InternalSyntacticSequencerTestLanguage.g:1540:1: ruleBooleanValues returns [EObject current=null] : ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? ) ;
    public final EObject ruleBooleanValues() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        AntlrDatatypeRuleToken lv_val3_4_0 = null;


         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:1543:28: ( ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? ) )
            // InternalSyntacticSequencerTestLanguage.g:1544:1: ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? )
            {
            // InternalSyntacticSequencerTestLanguage.g:1544:1: ( () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )? )
            // InternalSyntacticSequencerTestLanguage.g:1544:2: () otherlv_1= '#12' ( (lv_val1_2_0= 'kw1' ) )? ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )? ( (lv_val3_4_0= ruleBooleanDatatypeID ) )?
            {
            // InternalSyntacticSequencerTestLanguage.g:1544:2: ()
            // InternalSyntacticSequencerTestLanguage.g:1545:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBooleanValuesAccess().getBooleanValuesAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBooleanValuesAccess().getNumberSignDigitOneDigitTwoKeyword_1());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:1554:1: ( (lv_val1_2_0= 'kw1' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==14) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1555:1: (lv_val1_2_0= 'kw1' )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:1555:1: (lv_val1_2_0= 'kw1' )
                    // InternalSyntacticSequencerTestLanguage.g:1556:3: lv_val1_2_0= 'kw1'
                    {
                    lv_val1_2_0=(Token)match(input,14,FollowSets000.FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_val1_2_0, grammarAccess.getBooleanValuesAccess().getVal1Kw1Keyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanValuesRule());
                      	        }
                             		setWithLastConsumed(current, "val1", true, "kw1");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalSyntacticSequencerTestLanguage.g:1569:3: ( (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_BOOLEAN_TERMINAL_ID) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1570:1: (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:1570:1: (lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID )
                    // InternalSyntacticSequencerTestLanguage.g:1571:3: lv_val2_3_0= RULE_BOOLEAN_TERMINAL_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_BOOLEAN_TERMINAL_ID,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_val2_3_0, grammarAccess.getBooleanValuesAccess().getVal2BOOLEAN_TERMINAL_IDTerminalRuleCall_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanValuesRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"val2",
                              		true, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.BOOLEAN_TERMINAL_ID");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalSyntacticSequencerTestLanguage.g:1587:3: ( (lv_val3_4_0= ruleBooleanDatatypeID ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1588:1: (lv_val3_4_0= ruleBooleanDatatypeID )
                    {
                    // InternalSyntacticSequencerTestLanguage.g:1588:1: (lv_val3_4_0= ruleBooleanDatatypeID )
                    // InternalSyntacticSequencerTestLanguage.g:1589:3: lv_val3_4_0= ruleBooleanDatatypeID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getBooleanValuesAccess().getVal3BooleanDatatypeIDParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val3_4_0=ruleBooleanDatatypeID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getBooleanValuesRule());
                      	        }
                             		set(
                             			current, 
                             			"val3",
                              		true, 
                              		"org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage.BooleanDatatypeID");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "ruleBooleanValues"


    // $ANTLR start "entryRuleLongAlternative"
    // InternalSyntacticSequencerTestLanguage.g:1613:1: entryRuleLongAlternative returns [EObject current=null] : iv_ruleLongAlternative= ruleLongAlternative EOF ;
    public final EObject entryRuleLongAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongAlternative = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:1614:2: (iv_ruleLongAlternative= ruleLongAlternative EOF )
            // InternalSyntacticSequencerTestLanguage.g:1615:2: iv_ruleLongAlternative= ruleLongAlternative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLongAlternativeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLongAlternative=ruleLongAlternative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLongAlternative; 
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
    // $ANTLR end "entryRuleLongAlternative"


    // $ANTLR start "ruleLongAlternative"
    // InternalSyntacticSequencerTestLanguage.g:1622:1: ruleLongAlternative returns [EObject current=null] : (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' ) ;
    public final EObject ruleLongAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_foo_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;
        Token otherlv_6=null;
        Token lv_val3_7_0=null;
        Token otherlv_8=null;
        Token lv_val4_9_0=null;
        Token otherlv_10=null;
        Token lv_val5_11_0=null;
        Token otherlv_12=null;
        Token lv_val6_13_0=null;
        Token otherlv_14=null;
        Token lv_val7_15_0=null;
        Token otherlv_16=null;
        Token lv_val8_17_0=null;
        Token otherlv_18=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:1625:28: ( (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' ) )
            // InternalSyntacticSequencerTestLanguage.g:1626:1: (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' )
            {
            // InternalSyntacticSequencerTestLanguage.g:1626:1: (otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!' )
            // InternalSyntacticSequencerTestLanguage.g:1626:3: otherlv_0= '#13' ( (lv_foo_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )* otherlv_18= '!'
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLongAlternativeAccess().getNumberSignDigitOneDigitThreeKeyword_0());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:1630:1: ( (lv_foo_1_0= RULE_ID ) )
            // InternalSyntacticSequencerTestLanguage.g:1631:1: (lv_foo_1_0= RULE_ID )
            {
            // InternalSyntacticSequencerTestLanguage.g:1631:1: (lv_foo_1_0= RULE_ID )
            // InternalSyntacticSequencerTestLanguage.g:1632:3: lv_foo_1_0= RULE_ID
            {
            lv_foo_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_foo_1_0, grammarAccess.getLongAlternativeAccess().getFooIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getLongAlternativeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"foo",
                      		lv_foo_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            // InternalSyntacticSequencerTestLanguage.g:1648:2: ( (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? ) | (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? ) | (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? ) | (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? ) | (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? ) )*
            loop31:
            do {
                int alt31=9;
                switch ( input.LA(1) ) {
                case 14:
                    {
                    alt31=1;
                    }
                    break;
                case 15:
                    {
                    alt31=2;
                    }
                    break;
                case 16:
                    {
                    alt31=3;
                    }
                    break;
                case 17:
                    {
                    alt31=4;
                    }
                    break;
                case 35:
                    {
                    alt31=5;
                    }
                    break;
                case 36:
                    {
                    alt31=6;
                    }
                    break;
                case 37:
                    {
                    alt31=7;
                    }
                    break;
                case 38:
                    {
                    alt31=8;
                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // InternalSyntacticSequencerTestLanguage.g:1648:3: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:1648:3: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )? )
            	    // InternalSyntacticSequencerTestLanguage.g:1648:5: otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )?
            	    {
            	    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLongAlternativeAccess().getKw1Keyword_2_0_0());
            	          
            	    }
            	    // InternalSyntacticSequencerTestLanguage.g:1652:1: ( (lv_val1_3_0= RULE_ID ) )?
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==RULE_ID) ) {
            	        alt23=1;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // InternalSyntacticSequencerTestLanguage.g:1653:1: (lv_val1_3_0= RULE_ID )
            	            {
            	            // InternalSyntacticSequencerTestLanguage.g:1653:1: (lv_val1_3_0= RULE_ID )
            	            // InternalSyntacticSequencerTestLanguage.g:1654:3: lv_val1_3_0= RULE_ID
            	            {
            	            lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_val1_3_0, grammarAccess.getLongAlternativeAccess().getVal1IDTerminalRuleCall_2_0_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getLongAlternativeRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"val1",
            	                      		lv_val1_3_0, 
            	                      		"org.eclipse.xtext.common.Terminals.ID");
            	              	    
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSyntacticSequencerTestLanguage.g:1671:6: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:1671:6: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )? )
            	    // InternalSyntacticSequencerTestLanguage.g:1671:8: otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )?
            	    {
            	    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getLongAlternativeAccess().getKw2Keyword_2_1_0());
            	          
            	    }
            	    // InternalSyntacticSequencerTestLanguage.g:1675:1: ( (lv_val2_5_0= RULE_ID ) )?
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==RULE_ID) ) {
            	        alt24=1;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // InternalSyntacticSequencerTestLanguage.g:1676:1: (lv_val2_5_0= RULE_ID )
            	            {
            	            // InternalSyntacticSequencerTestLanguage.g:1676:1: (lv_val2_5_0= RULE_ID )
            	            // InternalSyntacticSequencerTestLanguage.g:1677:3: lv_val2_5_0= RULE_ID
            	            {
            	            lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_val2_5_0, grammarAccess.getLongAlternativeAccess().getVal2IDTerminalRuleCall_2_1_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getLongAlternativeRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"val2",
            	                      		lv_val2_5_0, 
            	                      		"org.eclipse.xtext.common.Terminals.ID");
            	              	    
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSyntacticSequencerTestLanguage.g:1694:6: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:1694:6: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )? )
            	    // InternalSyntacticSequencerTestLanguage.g:1694:8: otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )?
            	    {
            	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getLongAlternativeAccess().getKw3Keyword_2_2_0());
            	          
            	    }
            	    // InternalSyntacticSequencerTestLanguage.g:1698:1: ( (lv_val3_7_0= RULE_ID ) )?
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==RULE_ID) ) {
            	        alt25=1;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // InternalSyntacticSequencerTestLanguage.g:1699:1: (lv_val3_7_0= RULE_ID )
            	            {
            	            // InternalSyntacticSequencerTestLanguage.g:1699:1: (lv_val3_7_0= RULE_ID )
            	            // InternalSyntacticSequencerTestLanguage.g:1700:3: lv_val3_7_0= RULE_ID
            	            {
            	            lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_val3_7_0, grammarAccess.getLongAlternativeAccess().getVal3IDTerminalRuleCall_2_2_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getLongAlternativeRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"val3",
            	                      		lv_val3_7_0, 
            	                      		"org.eclipse.xtext.common.Terminals.ID");
            	              	    
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalSyntacticSequencerTestLanguage.g:1717:6: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:1717:6: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )? )
            	    // InternalSyntacticSequencerTestLanguage.g:1717:8: otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )?
            	    {
            	    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getLongAlternativeAccess().getKw4Keyword_2_3_0());
            	          
            	    }
            	    // InternalSyntacticSequencerTestLanguage.g:1721:1: ( (lv_val4_9_0= RULE_ID ) )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==RULE_ID) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // InternalSyntacticSequencerTestLanguage.g:1722:1: (lv_val4_9_0= RULE_ID )
            	            {
            	            // InternalSyntacticSequencerTestLanguage.g:1722:1: (lv_val4_9_0= RULE_ID )
            	            // InternalSyntacticSequencerTestLanguage.g:1723:3: lv_val4_9_0= RULE_ID
            	            {
            	            lv_val4_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_val4_9_0, grammarAccess.getLongAlternativeAccess().getVal4IDTerminalRuleCall_2_3_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getLongAlternativeRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"val4",
            	                      		lv_val4_9_0, 
            	                      		"org.eclipse.xtext.common.Terminals.ID");
            	              	    
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalSyntacticSequencerTestLanguage.g:1740:6: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:1740:6: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )? )
            	    // InternalSyntacticSequencerTestLanguage.g:1740:8: otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )?
            	    {
            	    otherlv_10=(Token)match(input,35,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_10, grammarAccess.getLongAlternativeAccess().getKw5Keyword_2_4_0());
            	          
            	    }
            	    // InternalSyntacticSequencerTestLanguage.g:1744:1: ( (lv_val5_11_0= RULE_ID ) )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==RULE_ID) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // InternalSyntacticSequencerTestLanguage.g:1745:1: (lv_val5_11_0= RULE_ID )
            	            {
            	            // InternalSyntacticSequencerTestLanguage.g:1745:1: (lv_val5_11_0= RULE_ID )
            	            // InternalSyntacticSequencerTestLanguage.g:1746:3: lv_val5_11_0= RULE_ID
            	            {
            	            lv_val5_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_val5_11_0, grammarAccess.getLongAlternativeAccess().getVal5IDTerminalRuleCall_2_4_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getLongAlternativeRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"val5",
            	                      		lv_val5_11_0, 
            	                      		"org.eclipse.xtext.common.Terminals.ID");
            	              	    
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalSyntacticSequencerTestLanguage.g:1763:6: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:1763:6: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )? )
            	    // InternalSyntacticSequencerTestLanguage.g:1763:8: otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )?
            	    {
            	    otherlv_12=(Token)match(input,36,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_12, grammarAccess.getLongAlternativeAccess().getKw6Keyword_2_5_0());
            	          
            	    }
            	    // InternalSyntacticSequencerTestLanguage.g:1767:1: ( (lv_val6_13_0= RULE_ID ) )?
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==RULE_ID) ) {
            	        alt28=1;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // InternalSyntacticSequencerTestLanguage.g:1768:1: (lv_val6_13_0= RULE_ID )
            	            {
            	            // InternalSyntacticSequencerTestLanguage.g:1768:1: (lv_val6_13_0= RULE_ID )
            	            // InternalSyntacticSequencerTestLanguage.g:1769:3: lv_val6_13_0= RULE_ID
            	            {
            	            lv_val6_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_val6_13_0, grammarAccess.getLongAlternativeAccess().getVal6IDTerminalRuleCall_2_5_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getLongAlternativeRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"val6",
            	                      		lv_val6_13_0, 
            	                      		"org.eclipse.xtext.common.Terminals.ID");
            	              	    
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalSyntacticSequencerTestLanguage.g:1786:6: (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:1786:6: (otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )? )
            	    // InternalSyntacticSequencerTestLanguage.g:1786:8: otherlv_14= 'kw7' ( (lv_val7_15_0= RULE_ID ) )?
            	    {
            	    otherlv_14=(Token)match(input,37,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_14, grammarAccess.getLongAlternativeAccess().getKw7Keyword_2_6_0());
            	          
            	    }
            	    // InternalSyntacticSequencerTestLanguage.g:1790:1: ( (lv_val7_15_0= RULE_ID ) )?
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==RULE_ID) ) {
            	        alt29=1;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // InternalSyntacticSequencerTestLanguage.g:1791:1: (lv_val7_15_0= RULE_ID )
            	            {
            	            // InternalSyntacticSequencerTestLanguage.g:1791:1: (lv_val7_15_0= RULE_ID )
            	            // InternalSyntacticSequencerTestLanguage.g:1792:3: lv_val7_15_0= RULE_ID
            	            {
            	            lv_val7_15_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_val7_15_0, grammarAccess.getLongAlternativeAccess().getVal7IDTerminalRuleCall_2_6_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getLongAlternativeRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"val7",
            	                      		lv_val7_15_0, 
            	                      		"org.eclipse.xtext.common.Terminals.ID");
            	              	    
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalSyntacticSequencerTestLanguage.g:1809:6: (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? )
            	    {
            	    // InternalSyntacticSequencerTestLanguage.g:1809:6: (otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )? )
            	    // InternalSyntacticSequencerTestLanguage.g:1809:8: otherlv_16= 'kw8' ( (lv_val8_17_0= RULE_ID ) )?
            	    {
            	    otherlv_16=(Token)match(input,38,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_16, grammarAccess.getLongAlternativeAccess().getKw8Keyword_2_7_0());
            	          
            	    }
            	    // InternalSyntacticSequencerTestLanguage.g:1813:1: ( (lv_val8_17_0= RULE_ID ) )?
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==RULE_ID) ) {
            	        alt30=1;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // InternalSyntacticSequencerTestLanguage.g:1814:1: (lv_val8_17_0= RULE_ID )
            	            {
            	            // InternalSyntacticSequencerTestLanguage.g:1814:1: (lv_val8_17_0= RULE_ID )
            	            // InternalSyntacticSequencerTestLanguage.g:1815:3: lv_val8_17_0= RULE_ID
            	            {
            	            lv_val8_17_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_val8_17_0, grammarAccess.getLongAlternativeAccess().getVal8IDTerminalRuleCall_2_7_1_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getLongAlternativeRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"val8",
            	                      		lv_val8_17_0, 
            	                      		"org.eclipse.xtext.common.Terminals.ID");
            	              	    
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_18=(Token)match(input,39,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_18, grammarAccess.getLongAlternativeAccess().getExclamationMarkKeyword_3());
                  
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
    // $ANTLR end "ruleLongAlternative"


    // $ANTLR start "entryRuleActionOnly"
    // InternalSyntacticSequencerTestLanguage.g:1843:1: entryRuleActionOnly returns [EObject current=null] : iv_ruleActionOnly= ruleActionOnly EOF ;
    public final EObject entryRuleActionOnly() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionOnly = null;


        try {
            // InternalSyntacticSequencerTestLanguage.g:1844:2: (iv_ruleActionOnly= ruleActionOnly EOF )
            // InternalSyntacticSequencerTestLanguage.g:1845:2: iv_ruleActionOnly= ruleActionOnly EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionOnlyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleActionOnly=ruleActionOnly();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActionOnly; 
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
    // $ANTLR end "entryRuleActionOnly"


    // $ANTLR start "ruleActionOnly"
    // InternalSyntacticSequencerTestLanguage.g:1852:1: ruleActionOnly returns [EObject current=null] : (otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )? ) ;
    public final EObject ruleActionOnly() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_ID_2=null;
        Token otherlv_4=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // InternalSyntacticSequencerTestLanguage.g:1855:28: ( (otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )? ) )
            // InternalSyntacticSequencerTestLanguage.g:1856:1: (otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )? )
            {
            // InternalSyntacticSequencerTestLanguage.g:1856:1: (otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )? )
            // InternalSyntacticSequencerTestLanguage.g:1856:3: otherlv_0= '#14' (otherlv_1= 'kw1' )? ( ( RULE_ID )=>this_ID_2= RULE_ID )? () (otherlv_4= 'kw2' )? (this_ID_5= RULE_ID )?
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getActionOnlyAccess().getNumberSignDigitOneDigitFourKeyword_0());
                  
            }
            // InternalSyntacticSequencerTestLanguage.g:1860:1: (otherlv_1= 'kw1' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==14) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1860:3: otherlv_1= 'kw1'
                    {
                    otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getActionOnlyAccess().getKw1Keyword_1());
                          
                    }

                    }
                    break;

            }

            // InternalSyntacticSequencerTestLanguage.g:1864:3: ( ( RULE_ID )=>this_ID_2= RULE_ID )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                int LA33_1 = input.LA(2);

                if ( (synpred1_InternalSyntacticSequencerTestLanguage()) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1864:4: ( RULE_ID )=>this_ID_2= RULE_ID
                    {
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_2, grammarAccess.getActionOnlyAccess().getIDTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;

            }

            // InternalSyntacticSequencerTestLanguage.g:1868:3: ()
            // InternalSyntacticSequencerTestLanguage.g:1869:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getActionOnlyAccess().getActionOnlyAction_3(),
                          current);
                  
            }

            }

            // InternalSyntacticSequencerTestLanguage.g:1874:2: (otherlv_4= 'kw2' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==15) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1874:4: otherlv_4= 'kw2'
                    {
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getActionOnlyAccess().getKw2Keyword_4());
                          
                    }

                    }
                    break;

            }

            // InternalSyntacticSequencerTestLanguage.g:1878:3: (this_ID_5= RULE_ID )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalSyntacticSequencerTestLanguage.g:1878:4: this_ID_5= RULE_ID
                    {
                    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_5, grammarAccess.getActionOnlyAccess().getIDTerminalRuleCall_5()); 
                          
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
    // $ANTLR end "ruleActionOnly"

    // $ANTLR start synpred1_InternalSyntacticSequencerTestLanguage
    public final void synpred1_InternalSyntacticSequencerTestLanguage_fragment() throws RecognitionException {   
        // InternalSyntacticSequencerTestLanguage.g:1864:4: ( RULE_ID )
        // InternalSyntacticSequencerTestLanguage.g:1864:6: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalSyntacticSequencerTestLanguage

    // Delegated rules

    public final boolean synpred1_InternalSyntacticSequencerTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalSyntacticSequencerTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000000003C002L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010004000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010004010L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000001000C000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000004092L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000092L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x000000F80003C000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000000F80003C010L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000000000000C012L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000008012L});
    }


}