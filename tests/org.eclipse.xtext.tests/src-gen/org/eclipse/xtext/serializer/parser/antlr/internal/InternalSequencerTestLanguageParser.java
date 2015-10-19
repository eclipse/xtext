package org.eclipse.xtext.serializer.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.serializer.services.SequencerTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSequencerTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ID1", "RULE_ID2", "RULE_ID3", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'kw1'", "'kw2'", "'#3'", "'kw3'", "'#4'", "'#5'", "'kw4'", "'kw5'", "'#6'", "','", "'#7'", "'#8'", "'#9'", "'kw'", "'#10'", "'#11'", "'#12'", "'#13'", "'#14'", "'#15'", "'#16'", "'#17'", "'#18'", "'#19'", "'#20'", "'#21'", "'#22'", "'Bye'", "'#23'", "'#24'", "'#25'", "'#26'", "'#27'", "'kw6'", "'#28'", "'.'", "'#29'", "'#30'", "'#31'", "'#32'", "'#33'", "'#34'", "'kwp2'", "'kwp1'", "'kwp3'"
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
    public static final int RULE_ANY_OTHER=13;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__59=59;
    public static final int RULE_INT=8;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=9;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_ID1=5;
    public static final int RULE_ID2=6;
    public static final int RULE_ID3=7;
    public static final int RULE_WS=12;

    // delegates
    // delegators


        public InternalSequencerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSequencerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSequencerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSequencerTestLanguage.g"; }



     	private SequencerTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSequencerTestLanguageParser(TokenStream input, SequencerTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected SequencerTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalSequencerTestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalSequencerTestLanguage.g:69:2: (iv_ruleModel= ruleModel EOF )
            // InternalSequencerTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalSequencerTestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) | ( (lv_x33_32_0= ruleFragmentCaller ) ) | ( (lv_x34_33_0= ruleParameterCaller ) ) ) ;
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

        EObject lv_x10_12_0 = null;

        EObject lv_x11_13_0 = null;

        EObject lv_x12_14_0 = null;

        EObject lv_x13_15_0 = null;

        EObject lv_x14_16_0 = null;

        EObject lv_x15_17_0 = null;

        EObject lv_x19_18_0 = null;

        EObject lv_x20_19_0 = null;

        EObject lv_x21_20_0 = null;

        EObject lv_x22_21_0 = null;

        EObject lv_x23_22_0 = null;

        EObject lv_x24_23_0 = null;

        EObject lv_x25_24_0 = null;

        EObject lv_x26_25_0 = null;

        EObject lv_x27_26_0 = null;

        EObject lv_x28_27_0 = null;

        EObject lv_x29_28_0 = null;

        EObject lv_x30_29_0 = null;

        EObject lv_x31_30_0 = null;

        EObject lv_x32_31_0 = null;

        EObject lv_x33_32_0 = null;

        EObject lv_x34_33_0 = null;


         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:80:28: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) | ( (lv_x33_32_0= ruleFragmentCaller ) ) | ( (lv_x34_33_0= ruleParameterCaller ) ) ) )
            // InternalSequencerTestLanguage.g:81:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) | ( (lv_x33_32_0= ruleFragmentCaller ) ) | ( (lv_x34_33_0= ruleParameterCaller ) ) )
            {
            // InternalSequencerTestLanguage.g:81:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) | ( (lv_x33_32_0= ruleFragmentCaller ) ) | ( (lv_x34_33_0= ruleParameterCaller ) ) )
            int alt1=34;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 18:
                {
                alt1=3;
                }
                break;
            case 20:
                {
                alt1=4;
                }
                break;
            case 21:
                {
                alt1=5;
                }
                break;
            case 24:
                {
                alt1=6;
                }
                break;
            case 26:
                {
                alt1=7;
                }
                break;
            case 27:
                {
                alt1=8;
                }
                break;
            case 28:
                {
                alt1=9;
                }
                break;
            case 30:
                {
                alt1=10;
                }
                break;
            case 31:
                {
                alt1=11;
                }
                break;
            case 32:
                {
                alt1=12;
                }
                break;
            case 36:
                {
                alt1=13;
                }
                break;
            case 37:
                {
                alt1=14;
                }
                break;
            case 38:
                {
                alt1=15;
                }
                break;
            case 33:
                {
                alt1=16;
                }
                break;
            case 34:
                {
                alt1=17;
                }
                break;
            case 35:
                {
                alt1=18;
                }
                break;
            case 39:
                {
                alt1=19;
                }
                break;
            case 40:
                {
                alt1=20;
                }
                break;
            case 41:
                {
                alt1=21;
                }
                break;
            case 42:
                {
                alt1=22;
                }
                break;
            case 44:
                {
                alt1=23;
                }
                break;
            case 45:
                {
                alt1=24;
                }
                break;
            case 46:
                {
                alt1=25;
                }
                break;
            case 47:
                {
                alt1=26;
                }
                break;
            case 48:
                {
                alt1=27;
                }
                break;
            case 50:
                {
                alt1=28;
                }
                break;
            case 52:
                {
                alt1=29;
                }
                break;
            case 53:
                {
                alt1=30;
                }
                break;
            case 54:
                {
                alt1=31;
                }
                break;
            case 55:
                {
                alt1=32;
                }
                break;
            case 56:
                {
                alt1=33;
                }
                break;
            case 57:
                {
                alt1=34;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalSequencerTestLanguage.g:81:2: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    {
                    // InternalSequencerTestLanguage.g:81:2: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    // InternalSequencerTestLanguage.g:82:1: (lv_x1_0_0= ruleSimpleGroup )
                    {
                    // InternalSequencerTestLanguage.g:82:1: (lv_x1_0_0= ruleSimpleGroup )
                    // InternalSequencerTestLanguage.g:83:3: lv_x1_0_0= ruleSimpleGroup
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX1SimpleGroupParserRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x1_0_0=ruleSimpleGroup();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x1",
                            		lv_x1_0_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.SimpleGroup");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:100:6: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    {
                    // InternalSequencerTestLanguage.g:100:6: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    // InternalSequencerTestLanguage.g:101:1: (lv_x2_1_0= ruleSimpleAlternative )
                    {
                    // InternalSequencerTestLanguage.g:101:1: (lv_x2_1_0= ruleSimpleAlternative )
                    // InternalSequencerTestLanguage.g:102:3: lv_x2_1_0= ruleSimpleAlternative
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX2SimpleAlternativeParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x2_1_0=ruleSimpleAlternative();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x2",
                            		lv_x2_1_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.SimpleAlternative");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSequencerTestLanguage.g:119:6: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    {
                    // InternalSequencerTestLanguage.g:119:6: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    // InternalSequencerTestLanguage.g:120:1: (lv_x3_2_0= ruleSimpleMultiplicities )
                    {
                    // InternalSequencerTestLanguage.g:120:1: (lv_x3_2_0= ruleSimpleMultiplicities )
                    // InternalSequencerTestLanguage.g:121:3: lv_x3_2_0= ruleSimpleMultiplicities
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX3SimpleMultiplicitiesParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x3_2_0=ruleSimpleMultiplicities();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x3",
                            		lv_x3_2_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.SimpleMultiplicities");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSequencerTestLanguage.g:138:6: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    {
                    // InternalSequencerTestLanguage.g:138:6: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    // InternalSequencerTestLanguage.g:139:1: (lv_x4_3_0= ruleGroupMultiplicities )
                    {
                    // InternalSequencerTestLanguage.g:139:1: (lv_x4_3_0= ruleGroupMultiplicities )
                    // InternalSequencerTestLanguage.g:140:3: lv_x4_3_0= ruleGroupMultiplicities
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX4GroupMultiplicitiesParserRuleCall_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x4_3_0=ruleGroupMultiplicities();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x4",
                            		lv_x4_3_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.GroupMultiplicities");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSequencerTestLanguage.g:157:6: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    {
                    // InternalSequencerTestLanguage.g:157:6: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    // InternalSequencerTestLanguage.g:158:1: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    {
                    // InternalSequencerTestLanguage.g:158:1: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    // InternalSequencerTestLanguage.g:159:3: lv_x5_4_0= ruleAlternativeMultiplicities
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX5AlternativeMultiplicitiesParserRuleCall_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x5_4_0=ruleAlternativeMultiplicities();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x5",
                            		lv_x5_4_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.AlternativeMultiplicities");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalSequencerTestLanguage.g:176:6: ( (lv_x6_5_0= ruleList1 ) )
                    {
                    // InternalSequencerTestLanguage.g:176:6: ( (lv_x6_5_0= ruleList1 ) )
                    // InternalSequencerTestLanguage.g:177:1: (lv_x6_5_0= ruleList1 )
                    {
                    // InternalSequencerTestLanguage.g:177:1: (lv_x6_5_0= ruleList1 )
                    // InternalSequencerTestLanguage.g:178:3: lv_x6_5_0= ruleList1
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX6List1ParserRuleCall_5_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x6_5_0=ruleList1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x6",
                            		lv_x6_5_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.List1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalSequencerTestLanguage.g:195:6: ( (lv_x7_6_0= ruleList2 ) )
                    {
                    // InternalSequencerTestLanguage.g:195:6: ( (lv_x7_6_0= ruleList2 ) )
                    // InternalSequencerTestLanguage.g:196:1: (lv_x7_6_0= ruleList2 )
                    {
                    // InternalSequencerTestLanguage.g:196:1: (lv_x7_6_0= ruleList2 )
                    // InternalSequencerTestLanguage.g:197:3: lv_x7_6_0= ruleList2
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX7List2ParserRuleCall_6_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x7_6_0=ruleList2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x7",
                            		lv_x7_6_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.List2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalSequencerTestLanguage.g:214:6: ( (lv_x8_7_0= ruleAltList1 ) )
                    {
                    // InternalSequencerTestLanguage.g:214:6: ( (lv_x8_7_0= ruleAltList1 ) )
                    // InternalSequencerTestLanguage.g:215:1: (lv_x8_7_0= ruleAltList1 )
                    {
                    // InternalSequencerTestLanguage.g:215:1: (lv_x8_7_0= ruleAltList1 )
                    // InternalSequencerTestLanguage.g:216:3: lv_x8_7_0= ruleAltList1
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX8AltList1ParserRuleCall_7_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x8_7_0=ruleAltList1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x8",
                            		lv_x8_7_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.AltList1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalSequencerTestLanguage.g:233:6: ( (lv_x9_8_0= ruleAltList2 ) )
                    {
                    // InternalSequencerTestLanguage.g:233:6: ( (lv_x9_8_0= ruleAltList2 ) )
                    // InternalSequencerTestLanguage.g:234:1: (lv_x9_8_0= ruleAltList2 )
                    {
                    // InternalSequencerTestLanguage.g:234:1: (lv_x9_8_0= ruleAltList2 )
                    // InternalSequencerTestLanguage.g:235:3: lv_x9_8_0= ruleAltList2
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX9AltList2ParserRuleCall_8_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x9_8_0=ruleAltList2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x9",
                            		lv_x9_8_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.AltList2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalSequencerTestLanguage.g:252:6: ( (lv_x10_9_0= ruleSingleKeywords ) )
                    {
                    // InternalSequencerTestLanguage.g:252:6: ( (lv_x10_9_0= ruleSingleKeywords ) )
                    // InternalSequencerTestLanguage.g:253:1: (lv_x10_9_0= ruleSingleKeywords )
                    {
                    // InternalSequencerTestLanguage.g:253:1: (lv_x10_9_0= ruleSingleKeywords )
                    // InternalSequencerTestLanguage.g:254:3: lv_x10_9_0= ruleSingleKeywords
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX10SingleKeywordsParserRuleCall_9_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x10_9_0=ruleSingleKeywords();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x10",
                            		lv_x10_9_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.SingleKeywords");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalSequencerTestLanguage.g:271:6: ( (lv_x11_10_0= ruleSingleKeywordsOrID ) )
                    {
                    // InternalSequencerTestLanguage.g:271:6: ( (lv_x11_10_0= ruleSingleKeywordsOrID ) )
                    // InternalSequencerTestLanguage.g:272:1: (lv_x11_10_0= ruleSingleKeywordsOrID )
                    {
                    // InternalSequencerTestLanguage.g:272:1: (lv_x11_10_0= ruleSingleKeywordsOrID )
                    // InternalSequencerTestLanguage.g:273:3: lv_x11_10_0= ruleSingleKeywordsOrID
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX11SingleKeywordsOrIDParserRuleCall_10_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x11_10_0=ruleSingleKeywordsOrID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x11",
                            		lv_x11_10_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.SingleKeywordsOrID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalSequencerTestLanguage.g:290:6: ( (lv_x12_11_0= ruleSingleTerminals ) )
                    {
                    // InternalSequencerTestLanguage.g:290:6: ( (lv_x12_11_0= ruleSingleTerminals ) )
                    // InternalSequencerTestLanguage.g:291:1: (lv_x12_11_0= ruleSingleTerminals )
                    {
                    // InternalSequencerTestLanguage.g:291:1: (lv_x12_11_0= ruleSingleTerminals )
                    // InternalSequencerTestLanguage.g:292:3: lv_x12_11_0= ruleSingleTerminals
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX12SingleTerminalsParserRuleCall_11_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x12_11_0=ruleSingleTerminals();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x12",
                            		lv_x12_11_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.SingleTerminals");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalSequencerTestLanguage.g:309:6: ( (lv_x10_12_0= ruleMultiKeywords ) )
                    {
                    // InternalSequencerTestLanguage.g:309:6: ( (lv_x10_12_0= ruleMultiKeywords ) )
                    // InternalSequencerTestLanguage.g:310:1: (lv_x10_12_0= ruleMultiKeywords )
                    {
                    // InternalSequencerTestLanguage.g:310:1: (lv_x10_12_0= ruleMultiKeywords )
                    // InternalSequencerTestLanguage.g:311:3: lv_x10_12_0= ruleMultiKeywords
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX10MultiKeywordsParserRuleCall_12_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x10_12_0=ruleMultiKeywords();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x10",
                            		lv_x10_12_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.MultiKeywords");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalSequencerTestLanguage.g:328:6: ( (lv_x11_13_0= ruleMultiKeywordsOrID ) )
                    {
                    // InternalSequencerTestLanguage.g:328:6: ( (lv_x11_13_0= ruleMultiKeywordsOrID ) )
                    // InternalSequencerTestLanguage.g:329:1: (lv_x11_13_0= ruleMultiKeywordsOrID )
                    {
                    // InternalSequencerTestLanguage.g:329:1: (lv_x11_13_0= ruleMultiKeywordsOrID )
                    // InternalSequencerTestLanguage.g:330:3: lv_x11_13_0= ruleMultiKeywordsOrID
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX11MultiKeywordsOrIDParserRuleCall_13_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x11_13_0=ruleMultiKeywordsOrID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x11",
                            		lv_x11_13_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.MultiKeywordsOrID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 15 :
                    // InternalSequencerTestLanguage.g:347:6: ( (lv_x12_14_0= ruleMultiTerminals ) )
                    {
                    // InternalSequencerTestLanguage.g:347:6: ( (lv_x12_14_0= ruleMultiTerminals ) )
                    // InternalSequencerTestLanguage.g:348:1: (lv_x12_14_0= ruleMultiTerminals )
                    {
                    // InternalSequencerTestLanguage.g:348:1: (lv_x12_14_0= ruleMultiTerminals )
                    // InternalSequencerTestLanguage.g:349:3: lv_x12_14_0= ruleMultiTerminals
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX12MultiTerminalsParserRuleCall_14_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x12_14_0=ruleMultiTerminals();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x12",
                            		lv_x12_14_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.MultiTerminals");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 16 :
                    // InternalSequencerTestLanguage.g:366:6: ( (lv_x13_15_0= ruleSingleEnum ) )
                    {
                    // InternalSequencerTestLanguage.g:366:6: ( (lv_x13_15_0= ruleSingleEnum ) )
                    // InternalSequencerTestLanguage.g:367:1: (lv_x13_15_0= ruleSingleEnum )
                    {
                    // InternalSequencerTestLanguage.g:367:1: (lv_x13_15_0= ruleSingleEnum )
                    // InternalSequencerTestLanguage.g:368:3: lv_x13_15_0= ruleSingleEnum
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX13SingleEnumParserRuleCall_15_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x13_15_0=ruleSingleEnum();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x13",
                            		lv_x13_15_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.SingleEnum");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 17 :
                    // InternalSequencerTestLanguage.g:385:6: ( (lv_x14_16_0= ruleSingleCrossReference ) )
                    {
                    // InternalSequencerTestLanguage.g:385:6: ( (lv_x14_16_0= ruleSingleCrossReference ) )
                    // InternalSequencerTestLanguage.g:386:1: (lv_x14_16_0= ruleSingleCrossReference )
                    {
                    // InternalSequencerTestLanguage.g:386:1: (lv_x14_16_0= ruleSingleCrossReference )
                    // InternalSequencerTestLanguage.g:387:3: lv_x14_16_0= ruleSingleCrossReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX14SingleCrossReferenceParserRuleCall_16_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x14_16_0=ruleSingleCrossReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x14",
                            		lv_x14_16_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.SingleCrossReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 18 :
                    // InternalSequencerTestLanguage.g:404:6: ( (lv_x15_17_0= ruleSingleContainmentReference ) )
                    {
                    // InternalSequencerTestLanguage.g:404:6: ( (lv_x15_17_0= ruleSingleContainmentReference ) )
                    // InternalSequencerTestLanguage.g:405:1: (lv_x15_17_0= ruleSingleContainmentReference )
                    {
                    // InternalSequencerTestLanguage.g:405:1: (lv_x15_17_0= ruleSingleContainmentReference )
                    // InternalSequencerTestLanguage.g:406:3: lv_x15_17_0= ruleSingleContainmentReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX15SingleContainmentReferenceParserRuleCall_17_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x15_17_0=ruleSingleContainmentReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x15",
                            		lv_x15_17_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.SingleContainmentReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 19 :
                    // InternalSequencerTestLanguage.g:423:6: ( (lv_x19_18_0= ruleDependentAlternative1 ) )
                    {
                    // InternalSequencerTestLanguage.g:423:6: ( (lv_x19_18_0= ruleDependentAlternative1 ) )
                    // InternalSequencerTestLanguage.g:424:1: (lv_x19_18_0= ruleDependentAlternative1 )
                    {
                    // InternalSequencerTestLanguage.g:424:1: (lv_x19_18_0= ruleDependentAlternative1 )
                    // InternalSequencerTestLanguage.g:425:3: lv_x19_18_0= ruleDependentAlternative1
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX19DependentAlternative1ParserRuleCall_18_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x19_18_0=ruleDependentAlternative1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x19",
                            		lv_x19_18_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.DependentAlternative1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 20 :
                    // InternalSequencerTestLanguage.g:442:6: ( (lv_x20_19_0= ruleDependentAlternative2 ) )
                    {
                    // InternalSequencerTestLanguage.g:442:6: ( (lv_x20_19_0= ruleDependentAlternative2 ) )
                    // InternalSequencerTestLanguage.g:443:1: (lv_x20_19_0= ruleDependentAlternative2 )
                    {
                    // InternalSequencerTestLanguage.g:443:1: (lv_x20_19_0= ruleDependentAlternative2 )
                    // InternalSequencerTestLanguage.g:444:3: lv_x20_19_0= ruleDependentAlternative2
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX20DependentAlternative2ParserRuleCall_19_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x20_19_0=ruleDependentAlternative2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x20",
                            		lv_x20_19_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.DependentAlternative2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 21 :
                    // InternalSequencerTestLanguage.g:461:6: ( (lv_x21_20_0= ruleOptional ) )
                    {
                    // InternalSequencerTestLanguage.g:461:6: ( (lv_x21_20_0= ruleOptional ) )
                    // InternalSequencerTestLanguage.g:462:1: (lv_x21_20_0= ruleOptional )
                    {
                    // InternalSequencerTestLanguage.g:462:1: (lv_x21_20_0= ruleOptional )
                    // InternalSequencerTestLanguage.g:463:3: lv_x21_20_0= ruleOptional
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX21OptionalParserRuleCall_20_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x21_20_0=ruleOptional();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x21",
                            		lv_x21_20_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.Optional");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 22 :
                    // InternalSequencerTestLanguage.g:480:6: ( (lv_x22_21_0= ruleFloat ) )
                    {
                    // InternalSequencerTestLanguage.g:480:6: ( (lv_x22_21_0= ruleFloat ) )
                    // InternalSequencerTestLanguage.g:481:1: (lv_x22_21_0= ruleFloat )
                    {
                    // InternalSequencerTestLanguage.g:481:1: (lv_x22_21_0= ruleFloat )
                    // InternalSequencerTestLanguage.g:482:3: lv_x22_21_0= ruleFloat
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX22FloatParserRuleCall_21_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x22_21_0=ruleFloat();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x22",
                            		lv_x22_21_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.Float");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 23 :
                    // InternalSequencerTestLanguage.g:499:6: ( (lv_x23_22_0= ruleUnorderedAlternative ) )
                    {
                    // InternalSequencerTestLanguage.g:499:6: ( (lv_x23_22_0= ruleUnorderedAlternative ) )
                    // InternalSequencerTestLanguage.g:500:1: (lv_x23_22_0= ruleUnorderedAlternative )
                    {
                    // InternalSequencerTestLanguage.g:500:1: (lv_x23_22_0= ruleUnorderedAlternative )
                    // InternalSequencerTestLanguage.g:501:3: lv_x23_22_0= ruleUnorderedAlternative
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX23UnorderedAlternativeParserRuleCall_22_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x23_22_0=ruleUnorderedAlternative();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x23",
                            		lv_x23_22_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.UnorderedAlternative");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 24 :
                    // InternalSequencerTestLanguage.g:518:6: ( (lv_x24_23_0= ruleUnorderedGroup ) )
                    {
                    // InternalSequencerTestLanguage.g:518:6: ( (lv_x24_23_0= ruleUnorderedGroup ) )
                    // InternalSequencerTestLanguage.g:519:1: (lv_x24_23_0= ruleUnorderedGroup )
                    {
                    // InternalSequencerTestLanguage.g:519:1: (lv_x24_23_0= ruleUnorderedGroup )
                    // InternalSequencerTestLanguage.g:520:3: lv_x24_23_0= ruleUnorderedGroup
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX24UnorderedGroupParserRuleCall_23_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x24_23_0=ruleUnorderedGroup();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x24",
                            		lv_x24_23_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.UnorderedGroup");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 25 :
                    // InternalSequencerTestLanguage.g:537:6: ( (lv_x25_24_0= ruleUnorderedGroupOptional ) )
                    {
                    // InternalSequencerTestLanguage.g:537:6: ( (lv_x25_24_0= ruleUnorderedGroupOptional ) )
                    // InternalSequencerTestLanguage.g:538:1: (lv_x25_24_0= ruleUnorderedGroupOptional )
                    {
                    // InternalSequencerTestLanguage.g:538:1: (lv_x25_24_0= ruleUnorderedGroupOptional )
                    // InternalSequencerTestLanguage.g:539:3: lv_x25_24_0= ruleUnorderedGroupOptional
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX25UnorderedGroupOptionalParserRuleCall_24_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x25_24_0=ruleUnorderedGroupOptional();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x25",
                            		lv_x25_24_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.UnorderedGroupOptional");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 26 :
                    // InternalSequencerTestLanguage.g:556:6: ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) )
                    {
                    // InternalSequencerTestLanguage.g:556:6: ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) )
                    // InternalSequencerTestLanguage.g:557:1: (lv_x26_25_0= ruleUnorderedGroupBoolean )
                    {
                    // InternalSequencerTestLanguage.g:557:1: (lv_x26_25_0= ruleUnorderedGroupBoolean )
                    // InternalSequencerTestLanguage.g:558:3: lv_x26_25_0= ruleUnorderedGroupBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX26UnorderedGroupBooleanParserRuleCall_25_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x26_25_0=ruleUnorderedGroupBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x26",
                            		lv_x26_25_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.UnorderedGroupBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 27 :
                    // InternalSequencerTestLanguage.g:575:6: ( (lv_x27_26_0= ruleComplex1 ) )
                    {
                    // InternalSequencerTestLanguage.g:575:6: ( (lv_x27_26_0= ruleComplex1 ) )
                    // InternalSequencerTestLanguage.g:576:1: (lv_x27_26_0= ruleComplex1 )
                    {
                    // InternalSequencerTestLanguage.g:576:1: (lv_x27_26_0= ruleComplex1 )
                    // InternalSequencerTestLanguage.g:577:3: lv_x27_26_0= ruleComplex1
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX27Complex1ParserRuleCall_26_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x27_26_0=ruleComplex1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x27",
                            		lv_x27_26_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.Complex1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 28 :
                    // InternalSequencerTestLanguage.g:594:6: ( (lv_x28_27_0= ruleOptionalDouble ) )
                    {
                    // InternalSequencerTestLanguage.g:594:6: ( (lv_x28_27_0= ruleOptionalDouble ) )
                    // InternalSequencerTestLanguage.g:595:1: (lv_x28_27_0= ruleOptionalDouble )
                    {
                    // InternalSequencerTestLanguage.g:595:1: (lv_x28_27_0= ruleOptionalDouble )
                    // InternalSequencerTestLanguage.g:596:3: lv_x28_27_0= ruleOptionalDouble
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX28OptionalDoubleParserRuleCall_27_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x28_27_0=ruleOptionalDouble();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x28",
                            		lv_x28_27_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.OptionalDouble");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 29 :
                    // InternalSequencerTestLanguage.g:613:6: ( (lv_x29_28_0= ruleNullValueGenerated ) )
                    {
                    // InternalSequencerTestLanguage.g:613:6: ( (lv_x29_28_0= ruleNullValueGenerated ) )
                    // InternalSequencerTestLanguage.g:614:1: (lv_x29_28_0= ruleNullValueGenerated )
                    {
                    // InternalSequencerTestLanguage.g:614:1: (lv_x29_28_0= ruleNullValueGenerated )
                    // InternalSequencerTestLanguage.g:615:3: lv_x29_28_0= ruleNullValueGenerated
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX29NullValueGeneratedParserRuleCall_28_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x29_28_0=ruleNullValueGenerated();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x29",
                            		lv_x29_28_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.NullValueGenerated");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 30 :
                    // InternalSequencerTestLanguage.g:632:6: ( (lv_x30_29_0= ruleNullValueInterpreted ) )
                    {
                    // InternalSequencerTestLanguage.g:632:6: ( (lv_x30_29_0= ruleNullValueInterpreted ) )
                    // InternalSequencerTestLanguage.g:633:1: (lv_x30_29_0= ruleNullValueInterpreted )
                    {
                    // InternalSequencerTestLanguage.g:633:1: (lv_x30_29_0= ruleNullValueInterpreted )
                    // InternalSequencerTestLanguage.g:634:3: lv_x30_29_0= ruleNullValueInterpreted
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX30NullValueInterpretedParserRuleCall_29_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x30_29_0=ruleNullValueInterpreted();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x30",
                            		lv_x30_29_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.NullValueInterpreted");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 31 :
                    // InternalSequencerTestLanguage.g:651:6: ( (lv_x31_30_0= ruleNullCrossRefGenerated ) )
                    {
                    // InternalSequencerTestLanguage.g:651:6: ( (lv_x31_30_0= ruleNullCrossRefGenerated ) )
                    // InternalSequencerTestLanguage.g:652:1: (lv_x31_30_0= ruleNullCrossRefGenerated )
                    {
                    // InternalSequencerTestLanguage.g:652:1: (lv_x31_30_0= ruleNullCrossRefGenerated )
                    // InternalSequencerTestLanguage.g:653:3: lv_x31_30_0= ruleNullCrossRefGenerated
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX31NullCrossRefGeneratedParserRuleCall_30_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x31_30_0=ruleNullCrossRefGenerated();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x31",
                            		lv_x31_30_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.NullCrossRefGenerated");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 32 :
                    // InternalSequencerTestLanguage.g:670:6: ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) )
                    {
                    // InternalSequencerTestLanguage.g:670:6: ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) )
                    // InternalSequencerTestLanguage.g:671:1: (lv_x32_31_0= ruleNullCrossRefInterpreted )
                    {
                    // InternalSequencerTestLanguage.g:671:1: (lv_x32_31_0= ruleNullCrossRefInterpreted )
                    // InternalSequencerTestLanguage.g:672:3: lv_x32_31_0= ruleNullCrossRefInterpreted
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX32NullCrossRefInterpretedParserRuleCall_31_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x32_31_0=ruleNullCrossRefInterpreted();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x32",
                            		lv_x32_31_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.NullCrossRefInterpreted");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 33 :
                    // InternalSequencerTestLanguage.g:689:6: ( (lv_x33_32_0= ruleFragmentCaller ) )
                    {
                    // InternalSequencerTestLanguage.g:689:6: ( (lv_x33_32_0= ruleFragmentCaller ) )
                    // InternalSequencerTestLanguage.g:690:1: (lv_x33_32_0= ruleFragmentCaller )
                    {
                    // InternalSequencerTestLanguage.g:690:1: (lv_x33_32_0= ruleFragmentCaller )
                    // InternalSequencerTestLanguage.g:691:3: lv_x33_32_0= ruleFragmentCaller
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX33FragmentCallerParserRuleCall_32_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x33_32_0=ruleFragmentCaller();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x33",
                            		lv_x33_32_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.FragmentCaller");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 34 :
                    // InternalSequencerTestLanguage.g:708:6: ( (lv_x34_33_0= ruleParameterCaller ) )
                    {
                    // InternalSequencerTestLanguage.g:708:6: ( (lv_x34_33_0= ruleParameterCaller ) )
                    // InternalSequencerTestLanguage.g:709:1: (lv_x34_33_0= ruleParameterCaller )
                    {
                    // InternalSequencerTestLanguage.g:709:1: (lv_x34_33_0= ruleParameterCaller )
                    // InternalSequencerTestLanguage.g:710:3: lv_x34_33_0= ruleParameterCaller
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX34ParameterCallerParserRuleCall_33_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x34_33_0=ruleParameterCaller();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x34",
                            		lv_x34_33_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.ParameterCaller");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleSimpleGroup"
    // InternalSequencerTestLanguage.g:734:1: entryRuleSimpleGroup returns [EObject current=null] : iv_ruleSimpleGroup= ruleSimpleGroup EOF ;
    public final EObject entryRuleSimpleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleGroup = null;


        try {
            // InternalSequencerTestLanguage.g:735:2: (iv_ruleSimpleGroup= ruleSimpleGroup EOF )
            // InternalSequencerTestLanguage.g:736:2: iv_ruleSimpleGroup= ruleSimpleGroup EOF
            {
             newCompositeNode(grammarAccess.getSimpleGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleGroup=ruleSimpleGroup();

            state._fsp--;

             current =iv_ruleSimpleGroup; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleGroup"


    // $ANTLR start "ruleSimpleGroup"
    // InternalSequencerTestLanguage.g:743:1: ruleSimpleGroup returns [EObject current=null] : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:746:28: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // InternalSequencerTestLanguage.g:747:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // InternalSequencerTestLanguage.g:747:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:747:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleGroupAccess().getNumberSignDigitOneKeyword_0());
                
            // InternalSequencerTestLanguage.g:751:1: ( (lv_val1_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:752:1: (lv_val1_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:752:1: (lv_val1_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:753:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            			newLeafNode(lv_val1_1_0, grammarAccess.getSimpleGroupAccess().getVal1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleGroupRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val1",
                    		lv_val1_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalSequencerTestLanguage.g:769:2: ( (lv_val2_2_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:770:1: (lv_val2_2_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:770:1: (lv_val2_2_0= RULE_ID )
            // InternalSequencerTestLanguage.g:771:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_val2_2_0, grammarAccess.getSimpleGroupAccess().getVal2IDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleGroupRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val2",
                    		lv_val2_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleGroup"


    // $ANTLR start "entryRuleSimpleAlternative"
    // InternalSequencerTestLanguage.g:795:1: entryRuleSimpleAlternative returns [EObject current=null] : iv_ruleSimpleAlternative= ruleSimpleAlternative EOF ;
    public final EObject entryRuleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAlternative = null;


        try {
            // InternalSequencerTestLanguage.g:796:2: (iv_ruleSimpleAlternative= ruleSimpleAlternative EOF )
            // InternalSequencerTestLanguage.g:797:2: iv_ruleSimpleAlternative= ruleSimpleAlternative EOF
            {
             newCompositeNode(grammarAccess.getSimpleAlternativeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleAlternative=ruleSimpleAlternative();

            state._fsp--;

             current =iv_ruleSimpleAlternative; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleAlternative"


    // $ANTLR start "ruleSimpleAlternative"
    // InternalSequencerTestLanguage.g:804:1: ruleSimpleAlternative returns [EObject current=null] : (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val2_4_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:807:28: ( (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // InternalSequencerTestLanguage.g:808:1: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // InternalSequencerTestLanguage.g:808:1: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // InternalSequencerTestLanguage.g:808:3: otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleAlternativeAccess().getNumberSignDigitTwoKeyword_0());
                
            // InternalSequencerTestLanguage.g:812:1: ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            else if ( (LA2_0==17) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalSequencerTestLanguage.g:812:2: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // InternalSequencerTestLanguage.g:812:2: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // InternalSequencerTestLanguage.g:812:4: otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAlternativeAccess().getKw1Keyword_1_0_0());
                        
                    // InternalSequencerTestLanguage.g:816:1: ( (lv_val1_2_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:817:1: (lv_val1_2_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:817:1: (lv_val1_2_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:818:3: lv_val1_2_0= RULE_ID
                    {
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val1_2_0, grammarAccess.getSimpleAlternativeAccess().getVal1IDTerminalRuleCall_1_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleAlternativeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_2_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:835:6: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // InternalSequencerTestLanguage.g:835:6: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // InternalSequencerTestLanguage.g:835:8: otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getSimpleAlternativeAccess().getKw2Keyword_1_1_0());
                        
                    // InternalSequencerTestLanguage.g:839:1: ( (lv_val2_4_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:840:1: (lv_val2_4_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:840:1: (lv_val2_4_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:841:3: lv_val2_4_0= RULE_ID
                    {
                    lv_val2_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val2_4_0, grammarAccess.getSimpleAlternativeAccess().getVal2IDTerminalRuleCall_1_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleAlternativeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_4_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleAlternative"


    // $ANTLR start "entryRuleSimpleMultiplicities"
    // InternalSequencerTestLanguage.g:865:1: entryRuleSimpleMultiplicities returns [EObject current=null] : iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF ;
    public final EObject entryRuleSimpleMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMultiplicities = null;


        try {
            // InternalSequencerTestLanguage.g:866:2: (iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF )
            // InternalSequencerTestLanguage.g:867:2: iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF
            {
             newCompositeNode(grammarAccess.getSimpleMultiplicitiesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleMultiplicities=ruleSimpleMultiplicities();

            state._fsp--;

             current =iv_ruleSimpleMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleMultiplicities"


    // $ANTLR start "ruleSimpleMultiplicities"
    // InternalSequencerTestLanguage.g:874:1: ruleSimpleMultiplicities returns [EObject current=null] : (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
    public final EObject ruleSimpleMultiplicities() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token lv_val3_5_0=null;
        Token otherlv_6=null;
        Token lv_val4_7_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:877:28: ( (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // InternalSequencerTestLanguage.g:878:1: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // InternalSequencerTestLanguage.g:878:1: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // InternalSequencerTestLanguage.g:878:3: otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleMultiplicitiesAccess().getNumberSignDigitThreeKeyword_0());
                
            // InternalSequencerTestLanguage.g:882:1: ( (lv_val1_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:883:1: (lv_val1_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:883:1: (lv_val1_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:884:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            			newLeafNode(lv_val1_1_0, grammarAccess.getSimpleMultiplicitiesAccess().getVal1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleMultiplicitiesRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val1",
                    		lv_val1_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleMultiplicitiesAccess().getKw1Keyword_2());
                
            // InternalSequencerTestLanguage.g:904:1: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalSequencerTestLanguage.g:905:1: (lv_val2_3_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:905:1: (lv_val2_3_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:906:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    			newLeafNode(lv_val2_3_0, grammarAccess.getSimpleMultiplicitiesAccess().getVal2IDTerminalRuleCall_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleMultiplicitiesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_3_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleMultiplicitiesAccess().getKw2Keyword_4());
                
            // InternalSequencerTestLanguage.g:926:1: ( (lv_val3_5_0= RULE_ID ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSequencerTestLanguage.g:927:1: (lv_val3_5_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:927:1: (lv_val3_5_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:928:3: lv_val3_5_0= RULE_ID
            	    {
            	    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            	    			newLeafNode(lv_val3_5_0, grammarAccess.getSimpleMultiplicitiesAccess().getVal3IDTerminalRuleCall_5_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getSimpleMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val3",
            	            		lv_val3_5_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_6, grammarAccess.getSimpleMultiplicitiesAccess().getKw3Keyword_6());
                
            // InternalSequencerTestLanguage.g:948:1: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalSequencerTestLanguage.g:949:1: (lv_val4_7_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:949:1: (lv_val4_7_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:950:3: lv_val4_7_0= RULE_ID
            	    {
            	    lv_val4_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            	    			newLeafNode(lv_val4_7_0, grammarAccess.getSimpleMultiplicitiesAccess().getVal4IDTerminalRuleCall_7_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getSimpleMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val4",
            	            		lv_val4_7_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleMultiplicities"


    // $ANTLR start "entryRuleGroupMultiplicities"
    // InternalSequencerTestLanguage.g:974:1: entryRuleGroupMultiplicities returns [EObject current=null] : iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF ;
    public final EObject entryRuleGroupMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupMultiplicities = null;


        try {
            // InternalSequencerTestLanguage.g:975:2: (iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF )
            // InternalSequencerTestLanguage.g:976:2: iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF
            {
             newCompositeNode(grammarAccess.getGroupMultiplicitiesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGroupMultiplicities=ruleGroupMultiplicities();

            state._fsp--;

             current =iv_ruleGroupMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleGroupMultiplicities"


    // $ANTLR start "ruleGroupMultiplicities"
    // InternalSequencerTestLanguage.g:983:1: ruleGroupMultiplicities returns [EObject current=null] : (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
    public final EObject ruleGroupMultiplicities() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;
        Token otherlv_5=null;
        Token lv_val4_6_0=null;
        Token lv_val5_7_0=null;
        Token otherlv_8=null;
        Token lv_val6_9_0=null;
        Token lv_val7_10_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:986:28: ( (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // InternalSequencerTestLanguage.g:987:1: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // InternalSequencerTestLanguage.g:987:1: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // InternalSequencerTestLanguage.g:987:3: otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getGroupMultiplicitiesAccess().getNumberSignDigitFourKeyword_0());
                
            // InternalSequencerTestLanguage.g:991:1: ( (lv_val1_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:992:1: (lv_val1_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:992:1: (lv_val1_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:993:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            			newLeafNode(lv_val1_1_0, grammarAccess.getGroupMultiplicitiesAccess().getVal1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val1",
                    		lv_val1_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getGroupMultiplicitiesAccess().getKw1Keyword_2());
                
            // InternalSequencerTestLanguage.g:1013:1: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalSequencerTestLanguage.g:1013:2: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // InternalSequencerTestLanguage.g:1013:2: ( (lv_val2_3_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1014:1: (lv_val2_3_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1014:1: (lv_val2_3_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1015:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_val2_3_0, grammarAccess.getGroupMultiplicitiesAccess().getVal2IDTerminalRuleCall_3_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_3_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // InternalSequencerTestLanguage.g:1031:2: ( (lv_val3_4_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1032:1: (lv_val3_4_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1032:1: (lv_val3_4_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1033:3: lv_val3_4_0= RULE_ID
                    {
                    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    			newLeafNode(lv_val3_4_0, grammarAccess.getGroupMultiplicitiesAccess().getVal3IDTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val3",
                            		lv_val3_4_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_5, grammarAccess.getGroupMultiplicitiesAccess().getKw2Keyword_4());
                
            // InternalSequencerTestLanguage.g:1053:1: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSequencerTestLanguage.g:1053:2: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // InternalSequencerTestLanguage.g:1053:2: ( (lv_val4_6_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:1054:1: (lv_val4_6_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:1054:1: (lv_val4_6_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:1055:3: lv_val4_6_0= RULE_ID
            	    {
            	    lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    			newLeafNode(lv_val4_6_0, grammarAccess.getGroupMultiplicitiesAccess().getVal4IDTerminalRuleCall_5_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val4",
            	            		lv_val4_6_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }

            	    // InternalSequencerTestLanguage.g:1071:2: ( (lv_val5_7_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:1072:1: (lv_val5_7_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:1072:1: (lv_val5_7_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:1073:3: lv_val5_7_0= RULE_ID
            	    {
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            	    			newLeafNode(lv_val5_7_0, grammarAccess.getGroupMultiplicitiesAccess().getVal5IDTerminalRuleCall_5_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val5",
            	            		lv_val5_7_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_8, grammarAccess.getGroupMultiplicitiesAccess().getKw3Keyword_6());
                
            // InternalSequencerTestLanguage.g:1093:1: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalSequencerTestLanguage.g:1093:2: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // InternalSequencerTestLanguage.g:1093:2: ( (lv_val6_9_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:1094:1: (lv_val6_9_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:1094:1: (lv_val6_9_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:1095:3: lv_val6_9_0= RULE_ID
            	    {
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    			newLeafNode(lv_val6_9_0, grammarAccess.getGroupMultiplicitiesAccess().getVal6IDTerminalRuleCall_7_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val6",
            	            		lv_val6_9_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }

            	    // InternalSequencerTestLanguage.g:1111:2: ( (lv_val7_10_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:1112:1: (lv_val7_10_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:1112:1: (lv_val7_10_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:1113:3: lv_val7_10_0= RULE_ID
            	    {
            	    lv_val7_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            	    			newLeafNode(lv_val7_10_0, grammarAccess.getGroupMultiplicitiesAccess().getVal7IDTerminalRuleCall_7_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val7",
            	            		lv_val7_10_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroupMultiplicities"


    // $ANTLR start "entryRuleAlternativeMultiplicities"
    // InternalSequencerTestLanguage.g:1137:1: entryRuleAlternativeMultiplicities returns [EObject current=null] : iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF ;
    public final EObject entryRuleAlternativeMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeMultiplicities = null;


        try {
            // InternalSequencerTestLanguage.g:1138:2: (iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF )
            // InternalSequencerTestLanguage.g:1139:2: iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF
            {
             newCompositeNode(grammarAccess.getAlternativeMultiplicitiesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAlternativeMultiplicities=ruleAlternativeMultiplicities();

            state._fsp--;

             current =iv_ruleAlternativeMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleAlternativeMultiplicities"


    // $ANTLR start "ruleAlternativeMultiplicities"
    // InternalSequencerTestLanguage.g:1146:1: ruleAlternativeMultiplicities returns [EObject current=null] : (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
    public final EObject ruleAlternativeMultiplicities() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val2_1_0=null;
        Token otherlv_2=null;
        Token lv_val3_3_0=null;
        Token otherlv_4=null;
        Token lv_val4_5_0=null;
        Token otherlv_6=null;
        Token lv_val5_7_0=null;
        Token otherlv_8=null;
        Token lv_val6_9_0=null;
        Token otherlv_10=null;
        Token lv_val7_11_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:1149:28: ( (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // InternalSequencerTestLanguage.g:1150:1: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // InternalSequencerTestLanguage.g:1150:1: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // InternalSequencerTestLanguage.g:1150:3: otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getAlternativeMultiplicitiesAccess().getNumberSignDigitFiveKeyword_0());
                
            // InternalSequencerTestLanguage.g:1154:1: ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==16) ) {
                alt9=2;
            }
            switch (alt9) {
                case 1 :
                    // InternalSequencerTestLanguage.g:1154:2: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // InternalSequencerTestLanguage.g:1154:2: ( (lv_val2_1_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1155:1: (lv_val2_1_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1155:1: (lv_val2_1_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1156:3: lv_val2_1_0= RULE_ID
                    {
                    lv_val2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    			newLeafNode(lv_val2_1_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal2IDTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAlternativeMultiplicitiesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_1_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:1173:6: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // InternalSequencerTestLanguage.g:1173:6: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // InternalSequencerTestLanguage.g:1173:8: otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getAlternativeMultiplicitiesAccess().getKw1Keyword_1_1_0());
                        
                    // InternalSequencerTestLanguage.g:1177:1: ( (lv_val3_3_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1178:1: (lv_val3_3_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1178:1: (lv_val3_3_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1179:3: lv_val3_3_0= RULE_ID
                    {
                    lv_val3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    			newLeafNode(lv_val3_3_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal3IDTerminalRuleCall_1_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAlternativeMultiplicitiesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val3",
                            		lv_val3_3_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_4, grammarAccess.getAlternativeMultiplicitiesAccess().getKw2Keyword_2());
                
            // InternalSequencerTestLanguage.g:1199:1: ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }
                else if ( (LA10_0==19) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSequencerTestLanguage.g:1199:2: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // InternalSequencerTestLanguage.g:1199:2: ( (lv_val4_5_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:1200:1: (lv_val4_5_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:1200:1: (lv_val4_5_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:1201:3: lv_val4_5_0= RULE_ID
            	    {
            	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            	    			newLeafNode(lv_val4_5_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal4IDTerminalRuleCall_3_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAlternativeMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val4",
            	            		lv_val4_5_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSequencerTestLanguage.g:1218:6: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:1218:6: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // InternalSequencerTestLanguage.g:1218:8: otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_6, grammarAccess.getAlternativeMultiplicitiesAccess().getKw3Keyword_3_1_0());
            	        
            	    // InternalSequencerTestLanguage.g:1222:1: ( (lv_val5_7_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:1223:1: (lv_val5_7_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:1223:1: (lv_val5_7_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:1224:3: lv_val5_7_0= RULE_ID
            	    {
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            	    			newLeafNode(lv_val5_7_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal5IDTerminalRuleCall_3_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAlternativeMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val5",
            	            		lv_val5_7_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_12); 

                	newLeafNode(otherlv_8, grammarAccess.getAlternativeMultiplicitiesAccess().getKw4Keyword_4());
                
            // InternalSequencerTestLanguage.g:1244:1: ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }
                else if ( (LA11_0==23) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSequencerTestLanguage.g:1244:2: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // InternalSequencerTestLanguage.g:1244:2: ( (lv_val6_9_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:1245:1: (lv_val6_9_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:1245:1: (lv_val6_9_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:1246:3: lv_val6_9_0= RULE_ID
            	    {
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    			newLeafNode(lv_val6_9_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal6IDTerminalRuleCall_5_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAlternativeMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val6",
            	            		lv_val6_9_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSequencerTestLanguage.g:1263:6: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:1263:6: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // InternalSequencerTestLanguage.g:1263:8: otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {
            	    otherlv_10=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_10, grammarAccess.getAlternativeMultiplicitiesAccess().getKw5Keyword_5_1_0());
            	        
            	    // InternalSequencerTestLanguage.g:1267:1: ( (lv_val7_11_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:1268:1: (lv_val7_11_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:1268:1: (lv_val7_11_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:1269:3: lv_val7_11_0= RULE_ID
            	    {
            	    lv_val7_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    			newLeafNode(lv_val7_11_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal7IDTerminalRuleCall_5_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAlternativeMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val7",
            	            		lv_val7_11_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlternativeMultiplicities"


    // $ANTLR start "entryRuleList1"
    // InternalSequencerTestLanguage.g:1293:1: entryRuleList1 returns [EObject current=null] : iv_ruleList1= ruleList1 EOF ;
    public final EObject entryRuleList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList1 = null;


        try {
            // InternalSequencerTestLanguage.g:1294:2: (iv_ruleList1= ruleList1 EOF )
            // InternalSequencerTestLanguage.g:1295:2: iv_ruleList1= ruleList1 EOF
            {
             newCompositeNode(grammarAccess.getList1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleList1=ruleList1();

            state._fsp--;

             current =iv_ruleList1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleList1"


    // $ANTLR start "ruleList1"
    // InternalSequencerTestLanguage.g:1302:1: ruleList1 returns [EObject current=null] : (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleList1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:1305:28: ( (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // InternalSequencerTestLanguage.g:1306:1: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // InternalSequencerTestLanguage.g:1306:1: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // InternalSequencerTestLanguage.g:1306:3: otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getList1Access().getNumberSignDigitSixKeyword_0());
                
            // InternalSequencerTestLanguage.g:1310:1: ( (lv_val1_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:1311:1: (lv_val1_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:1311:1: (lv_val1_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:1312:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            			newLeafNode(lv_val1_1_0, grammarAccess.getList1Access().getVal1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getList1Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"val1",
                    		lv_val1_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalSequencerTestLanguage.g:1328:2: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==25) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalSequencerTestLanguage.g:1328:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_2, grammarAccess.getList1Access().getCommaKeyword_2_0());
            	        
            	    // InternalSequencerTestLanguage.g:1332:1: ( (lv_val1_3_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:1333:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:1333:1: (lv_val1_3_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:1334:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            	    			newLeafNode(lv_val1_3_0, grammarAccess.getList1Access().getVal1IDTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getList1Rule());
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

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleList1"


    // $ANTLR start "entryRuleList2"
    // InternalSequencerTestLanguage.g:1358:1: entryRuleList2 returns [EObject current=null] : iv_ruleList2= ruleList2 EOF ;
    public final EObject entryRuleList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList2 = null;


        try {
            // InternalSequencerTestLanguage.g:1359:2: (iv_ruleList2= ruleList2 EOF )
            // InternalSequencerTestLanguage.g:1360:2: iv_ruleList2= ruleList2 EOF
            {
             newCompositeNode(grammarAccess.getList2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleList2=ruleList2();

            state._fsp--;

             current =iv_ruleList2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleList2"


    // $ANTLR start "ruleList2"
    // InternalSequencerTestLanguage.g:1367:1: ruleList2 returns [EObject current=null] : (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? ) ;
    public final EObject ruleList2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:1370:28: ( (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? ) )
            // InternalSequencerTestLanguage.g:1371:1: (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? )
            {
            // InternalSequencerTestLanguage.g:1371:1: (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? )
            // InternalSequencerTestLanguage.g:1371:3: otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )?
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_0, grammarAccess.getList2Access().getNumberSignDigitSevenKeyword_0());
                
            // InternalSequencerTestLanguage.g:1375:1: ()
            // InternalSequencerTestLanguage.g:1376:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getList2Access().getList2Action_1(),
                        current);
                

            }

            // InternalSequencerTestLanguage.g:1381:2: ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalSequencerTestLanguage.g:1381:3: ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )*
                    {
                    // InternalSequencerTestLanguage.g:1381:3: ( (lv_val1_2_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1382:1: (lv_val1_2_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1382:1: (lv_val1_2_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1383:3: lv_val1_2_0= RULE_ID
                    {
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

                    			newLeafNode(lv_val1_2_0, grammarAccess.getList2Access().getVal1IDTerminalRuleCall_2_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getList2Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_2_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // InternalSequencerTestLanguage.g:1399:2: (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==25) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalSequencerTestLanguage.g:1399:4: otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_3); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getList2Access().getCommaKeyword_2_1_0());
                    	        
                    	    // InternalSequencerTestLanguage.g:1403:1: ( (lv_val1_4_0= RULE_ID ) )
                    	    // InternalSequencerTestLanguage.g:1404:1: (lv_val1_4_0= RULE_ID )
                    	    {
                    	    // InternalSequencerTestLanguage.g:1404:1: (lv_val1_4_0= RULE_ID )
                    	    // InternalSequencerTestLanguage.g:1405:3: lv_val1_4_0= RULE_ID
                    	    {
                    	    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

                    	    			newLeafNode(lv_val1_4_0, grammarAccess.getList2Access().getVal1IDTerminalRuleCall_2_1_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getList2Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"val1",
                    	            		lv_val1_4_0, 
                    	            		"org.eclipse.xtext.common.Terminals.ID");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleList2"


    // $ANTLR start "entryRuleAltList1"
    // InternalSequencerTestLanguage.g:1429:1: entryRuleAltList1 returns [EObject current=null] : iv_ruleAltList1= ruleAltList1 EOF ;
    public final EObject entryRuleAltList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltList1 = null;


        try {
            // InternalSequencerTestLanguage.g:1430:2: (iv_ruleAltList1= ruleAltList1 EOF )
            // InternalSequencerTestLanguage.g:1431:2: iv_ruleAltList1= ruleAltList1 EOF
            {
             newCompositeNode(grammarAccess.getAltList1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAltList1=ruleAltList1();

            state._fsp--;

             current =iv_ruleAltList1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleAltList1"


    // $ANTLR start "ruleAltList1"
    // InternalSequencerTestLanguage.g:1438:1: ruleAltList1 returns [EObject current=null] : (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) ;
    public final EObject ruleAltList1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;
        Token lv_val3_5_0=null;
        Token otherlv_6=null;
        Token lv_val1_7_0=null;
        Token lv_val4_8_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:1441:28: ( (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) )
            // InternalSequencerTestLanguage.g:1442:1: (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            {
            // InternalSequencerTestLanguage.g:1442:1: (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            // InternalSequencerTestLanguage.g:1442:3: otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getAltList1Access().getNumberSignDigitEightKeyword_0());
                
            // InternalSequencerTestLanguage.g:1446:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt16=1;
                }
                break;
            case 16:
                {
                alt16=2;
                }
                break;
            case 17:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalSequencerTestLanguage.g:1446:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // InternalSequencerTestLanguage.g:1446:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // InternalSequencerTestLanguage.g:1446:3: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // InternalSequencerTestLanguage.g:1446:3: ( (lv_val1_1_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1447:1: (lv_val1_1_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1447:1: (lv_val1_1_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1448:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_val1_1_0, grammarAccess.getAltList1Access().getVal1IDTerminalRuleCall_1_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_1_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // InternalSequencerTestLanguage.g:1464:2: ( (lv_val2_2_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1465:1: (lv_val2_2_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1465:1: (lv_val2_2_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1466:3: lv_val2_2_0= RULE_ID
                    {
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val2_2_0, grammarAccess.getAltList1Access().getVal2IDTerminalRuleCall_1_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_2_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:1483:6: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    {
                    // InternalSequencerTestLanguage.g:1483:6: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    // InternalSequencerTestLanguage.g:1483:8: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getAltList1Access().getKw1Keyword_1_1_0());
                        
                    // InternalSequencerTestLanguage.g:1487:1: ( (lv_val1_4_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1488:1: (lv_val1_4_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1488:1: (lv_val1_4_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1489:3: lv_val1_4_0= RULE_ID
                    {
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_val1_4_0, grammarAccess.getAltList1Access().getVal1IDTerminalRuleCall_1_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_4_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // InternalSequencerTestLanguage.g:1505:2: ( (lv_val3_5_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1506:1: (lv_val3_5_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1506:1: (lv_val3_5_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1507:3: lv_val3_5_0= RULE_ID
                    {
                    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val3_5_0, grammarAccess.getAltList1Access().getVal3IDTerminalRuleCall_1_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val3",
                            		lv_val3_5_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSequencerTestLanguage.g:1524:6: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    {
                    // InternalSequencerTestLanguage.g:1524:6: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    // InternalSequencerTestLanguage.g:1524:8: otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )?
                    {
                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_6, grammarAccess.getAltList1Access().getKw2Keyword_1_2_0());
                        
                    // InternalSequencerTestLanguage.g:1528:1: ( (lv_val1_7_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1529:1: (lv_val1_7_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1529:1: (lv_val1_7_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1530:3: lv_val1_7_0= RULE_ID
                    {
                    lv_val1_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    			newLeafNode(lv_val1_7_0, grammarAccess.getAltList1Access().getVal1IDTerminalRuleCall_1_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_7_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // InternalSequencerTestLanguage.g:1546:2: ( (lv_val4_8_0= RULE_ID ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalSequencerTestLanguage.g:1547:1: (lv_val4_8_0= RULE_ID )
                            {
                            // InternalSequencerTestLanguage.g:1547:1: (lv_val4_8_0= RULE_ID )
                            // InternalSequencerTestLanguage.g:1548:3: lv_val4_8_0= RULE_ID
                            {
                            lv_val4_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            			newLeafNode(lv_val4_8_0, grammarAccess.getAltList1Access().getVal4IDTerminalRuleCall_1_2_2_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAltList1Rule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"val4",
                                    		lv_val4_8_0, 
                                    		"org.eclipse.xtext.common.Terminals.ID");
                            	    

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

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAltList1"


    // $ANTLR start "entryRuleAltList2"
    // InternalSequencerTestLanguage.g:1572:1: entryRuleAltList2 returns [EObject current=null] : iv_ruleAltList2= ruleAltList2 EOF ;
    public final EObject entryRuleAltList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltList2 = null;


        try {
            // InternalSequencerTestLanguage.g:1573:2: (iv_ruleAltList2= ruleAltList2 EOF )
            // InternalSequencerTestLanguage.g:1574:2: iv_ruleAltList2= ruleAltList2 EOF
            {
             newCompositeNode(grammarAccess.getAltList2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAltList2=ruleAltList2();

            state._fsp--;

             current =iv_ruleAltList2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleAltList2"


    // $ANTLR start "ruleAltList2"
    // InternalSequencerTestLanguage.g:1581:1: ruleAltList2 returns [EObject current=null] : (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleAltList2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;
        Token otherlv_5=null;
        Token lv_val1_6_0=null;
        Token lv_val3_7_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:1584:28: ( (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) )
            // InternalSequencerTestLanguage.g:1585:1: (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            {
            // InternalSequencerTestLanguage.g:1585:1: (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            // InternalSequencerTestLanguage.g:1585:3: otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getAltList2Access().getNumberSignDigitNineKeyword_0());
                
            // InternalSequencerTestLanguage.g:1589:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            else if ( (LA18_0==29) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalSequencerTestLanguage.g:1589:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // InternalSequencerTestLanguage.g:1589:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // InternalSequencerTestLanguage.g:1589:3: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // InternalSequencerTestLanguage.g:1589:3: ( (lv_val1_1_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1590:1: (lv_val1_1_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1590:1: (lv_val1_1_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1591:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_val1_1_0, grammarAccess.getAltList2Access().getVal1IDTerminalRuleCall_1_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList2Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_1_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // InternalSequencerTestLanguage.g:1607:2: ( (lv_val2_2_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1608:1: (lv_val2_2_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1608:1: (lv_val2_2_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1609:3: lv_val2_2_0= RULE_ID
                    {
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val2_2_0, grammarAccess.getAltList2Access().getVal2IDTerminalRuleCall_1_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList2Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_2_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:1626:6: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    {
                    // InternalSequencerTestLanguage.g:1626:6: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    // InternalSequencerTestLanguage.g:1626:8: otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getAltList2Access().getKwKeyword_1_1_0());
                        
                    // InternalSequencerTestLanguage.g:1630:1: ( (lv_val1_4_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1631:1: (lv_val1_4_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1631:1: (lv_val1_4_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1632:3: lv_val1_4_0= RULE_ID
                    {
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

                    			newLeafNode(lv_val1_4_0, grammarAccess.getAltList2Access().getVal1IDTerminalRuleCall_1_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList2Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_4_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // InternalSequencerTestLanguage.g:1648:2: (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==25) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalSequencerTestLanguage.g:1648:4: otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) )
                    	    {
                    	    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_3); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getAltList2Access().getCommaKeyword_1_1_2_0());
                    	        
                    	    // InternalSequencerTestLanguage.g:1652:1: ( (lv_val1_6_0= RULE_ID ) )
                    	    // InternalSequencerTestLanguage.g:1653:1: (lv_val1_6_0= RULE_ID )
                    	    {
                    	    // InternalSequencerTestLanguage.g:1653:1: (lv_val1_6_0= RULE_ID )
                    	    // InternalSequencerTestLanguage.g:1654:3: lv_val1_6_0= RULE_ID
                    	    {
                    	    lv_val1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

                    	    			newLeafNode(lv_val1_6_0, grammarAccess.getAltList2Access().getVal1IDTerminalRuleCall_1_1_2_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getAltList2Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"val1",
                    	            		lv_val1_6_0, 
                    	            		"org.eclipse.xtext.common.Terminals.ID");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // InternalSequencerTestLanguage.g:1670:4: ( (lv_val3_7_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:1671:1: (lv_val3_7_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:1671:1: (lv_val3_7_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:1672:3: lv_val3_7_0= RULE_ID
                    {
                    lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val3_7_0, grammarAccess.getAltList2Access().getVal3IDTerminalRuleCall_1_1_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList2Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val3",
                            		lv_val3_7_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAltList2"


    // $ANTLR start "entryRuleSingleKeywords"
    // InternalSequencerTestLanguage.g:1696:1: entryRuleSingleKeywords returns [EObject current=null] : iv_ruleSingleKeywords= ruleSingleKeywords EOF ;
    public final EObject entryRuleSingleKeywords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleKeywords = null;


        try {
            // InternalSequencerTestLanguage.g:1697:2: (iv_ruleSingleKeywords= ruleSingleKeywords EOF )
            // InternalSequencerTestLanguage.g:1698:2: iv_ruleSingleKeywords= ruleSingleKeywords EOF
            {
             newCompositeNode(grammarAccess.getSingleKeywordsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleKeywords=ruleSingleKeywords();

            state._fsp--;

             current =iv_ruleSingleKeywords; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleKeywords"


    // $ANTLR start "ruleSingleKeywords"
    // InternalSequencerTestLanguage.g:1705:1: ruleSingleKeywords returns [EObject current=null] : (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) ;
    public final EObject ruleSingleKeywords() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:1708:28: ( (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) )
            // InternalSequencerTestLanguage.g:1709:1: (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            {
            // InternalSequencerTestLanguage.g:1709:1: (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            // InternalSequencerTestLanguage.g:1709:3: otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_16); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleKeywordsAccess().getNumberSignDigitOneDigitZeroKeyword_0());
                
            // InternalSequencerTestLanguage.g:1713:1: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            // InternalSequencerTestLanguage.g:1714:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            {
            // InternalSequencerTestLanguage.g:1714:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            // InternalSequencerTestLanguage.g:1715:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
            {
            // InternalSequencerTestLanguage.g:1715:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt19=1;
                }
                break;
            case 17:
                {
                alt19=2;
                }
                break;
            case 19:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalSequencerTestLanguage.g:1716:3: lv_val_1_1= 'kw1'
                    {
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_val_1_1, grammarAccess.getSingleKeywordsAccess().getValKw1Keyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "val", lv_val_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:1728:8: lv_val_1_2= 'kw2'
                    {
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_val_1_2, grammarAccess.getSingleKeywordsAccess().getValKw2Keyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "val", lv_val_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalSequencerTestLanguage.g:1740:8: lv_val_1_3= 'kw3'
                    {
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_val_1_3, grammarAccess.getSingleKeywordsAccess().getValKw3Keyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "val", lv_val_1_3, null);
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleKeywords"


    // $ANTLR start "entryRuleSingleKeywordsOrID"
    // InternalSequencerTestLanguage.g:1763:1: entryRuleSingleKeywordsOrID returns [EObject current=null] : iv_ruleSingleKeywordsOrID= ruleSingleKeywordsOrID EOF ;
    public final EObject entryRuleSingleKeywordsOrID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleKeywordsOrID = null;


        try {
            // InternalSequencerTestLanguage.g:1764:2: (iv_ruleSingleKeywordsOrID= ruleSingleKeywordsOrID EOF )
            // InternalSequencerTestLanguage.g:1765:2: iv_ruleSingleKeywordsOrID= ruleSingleKeywordsOrID EOF
            {
             newCompositeNode(grammarAccess.getSingleKeywordsOrIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleKeywordsOrID=ruleSingleKeywordsOrID();

            state._fsp--;

             current =iv_ruleSingleKeywordsOrID; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleKeywordsOrID"


    // $ANTLR start "ruleSingleKeywordsOrID"
    // InternalSequencerTestLanguage.g:1772:1: ruleSingleKeywordsOrID returns [EObject current=null] : (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) ;
    public final EObject ruleSingleKeywordsOrID() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;
        Token lv_val_1_4=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:1775:28: ( (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) )
            // InternalSequencerTestLanguage.g:1776:1: (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            {
            // InternalSequencerTestLanguage.g:1776:1: (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            // InternalSequencerTestLanguage.g:1776:3: otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleKeywordsOrIDAccess().getNumberSignDigitOneDigitOneKeyword_0());
                
            // InternalSequencerTestLanguage.g:1780:1: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:1781:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            {
            // InternalSequencerTestLanguage.g:1781:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            // InternalSequencerTestLanguage.g:1782:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:1782:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt20=1;
                }
                break;
            case 17:
                {
                alt20=2;
                }
                break;
            case 19:
                {
                alt20=3;
                }
                break;
            case RULE_ID:
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalSequencerTestLanguage.g:1783:3: lv_val_1_1= 'kw1'
                    {
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_val_1_1, grammarAccess.getSingleKeywordsOrIDAccess().getValKw1Keyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsOrIDRule());
                    	        }
                           		setWithLastConsumed(current, "val", lv_val_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:1795:8: lv_val_1_2= 'kw2'
                    {
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_val_1_2, grammarAccess.getSingleKeywordsOrIDAccess().getValKw2Keyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsOrIDRule());
                    	        }
                           		setWithLastConsumed(current, "val", lv_val_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalSequencerTestLanguage.g:1807:8: lv_val_1_3= 'kw3'
                    {
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_val_1_3, grammarAccess.getSingleKeywordsOrIDAccess().getValKw3Keyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsOrIDRule());
                    	        }
                           		setWithLastConsumed(current, "val", lv_val_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // InternalSequencerTestLanguage.g:1819:8: lv_val_1_4= RULE_ID
                    {
                    lv_val_1_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val_1_4, grammarAccess.getSingleKeywordsOrIDAccess().getValIDTerminalRuleCall_1_0_3()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsOrIDRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_4, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleKeywordsOrID"


    // $ANTLR start "entryRuleSingleTerminals"
    // InternalSequencerTestLanguage.g:1845:1: entryRuleSingleTerminals returns [EObject current=null] : iv_ruleSingleTerminals= ruleSingleTerminals EOF ;
    public final EObject entryRuleSingleTerminals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleTerminals = null;


        try {
            // InternalSequencerTestLanguage.g:1846:2: (iv_ruleSingleTerminals= ruleSingleTerminals EOF )
            // InternalSequencerTestLanguage.g:1847:2: iv_ruleSingleTerminals= ruleSingleTerminals EOF
            {
             newCompositeNode(grammarAccess.getSingleTerminalsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleTerminals=ruleSingleTerminals();

            state._fsp--;

             current =iv_ruleSingleTerminals; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleTerminals"


    // $ANTLR start "ruleSingleTerminals"
    // InternalSequencerTestLanguage.g:1854:1: ruleSingleTerminals returns [EObject current=null] : (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) ;
    public final EObject ruleSingleTerminals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:1857:28: ( (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) )
            // InternalSequencerTestLanguage.g:1858:1: (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            {
            // InternalSequencerTestLanguage.g:1858:1: (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            // InternalSequencerTestLanguage.g:1858:3: otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            {
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_18); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleTerminalsAccess().getNumberSignDigitOneDigitTwoKeyword_0());
                
            // InternalSequencerTestLanguage.g:1862:1: ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            // InternalSequencerTestLanguage.g:1863:1: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            {
            // InternalSequencerTestLanguage.g:1863:1: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            // InternalSequencerTestLanguage.g:1864:1: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
            {
            // InternalSequencerTestLanguage.g:1864:1: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID1) ) {
                alt21=1;
            }
            else if ( (LA21_0==RULE_ID2) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalSequencerTestLanguage.g:1865:3: lv_val_1_1= RULE_ID1
                    {
                    lv_val_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val_1_1, grammarAccess.getSingleTerminalsAccess().getValID1TerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleTerminalsRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_1, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.ID1");
                    	    

                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:1880:8: lv_val_1_2= RULE_ID2
                    {
                    lv_val_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val_1_2, grammarAccess.getSingleTerminalsAccess().getValID2TerminalRuleCall_1_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleTerminalsRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_2, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.ID2");
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleTerminals"


    // $ANTLR start "entryRuleSingleEnum"
    // InternalSequencerTestLanguage.g:1906:1: entryRuleSingleEnum returns [EObject current=null] : iv_ruleSingleEnum= ruleSingleEnum EOF ;
    public final EObject entryRuleSingleEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleEnum = null;


        try {
            // InternalSequencerTestLanguage.g:1907:2: (iv_ruleSingleEnum= ruleSingleEnum EOF )
            // InternalSequencerTestLanguage.g:1908:2: iv_ruleSingleEnum= ruleSingleEnum EOF
            {
             newCompositeNode(grammarAccess.getSingleEnumRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleEnum=ruleSingleEnum();

            state._fsp--;

             current =iv_ruleSingleEnum; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleEnum"


    // $ANTLR start "ruleSingleEnum"
    // InternalSequencerTestLanguage.g:1915:1: ruleSingleEnum returns [EObject current=null] : (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) ) ;
    public final EObject ruleSingleEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_val_1_1 = null;

        Enumerator lv_val_1_2 = null;

        Enumerator lv_val_1_3 = null;


         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:1918:28: ( (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) ) )
            // InternalSequencerTestLanguage.g:1919:1: (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) )
            {
            // InternalSequencerTestLanguage.g:1919:1: (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) )
            // InternalSequencerTestLanguage.g:1919:3: otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) )
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_16); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleEnumAccess().getNumberSignDigitOneDigitThreeKeyword_0());
                
            // InternalSequencerTestLanguage.g:1923:1: ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) )
            // InternalSequencerTestLanguage.g:1924:1: ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) )
            {
            // InternalSequencerTestLanguage.g:1924:1: ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) )
            // InternalSequencerTestLanguage.g:1925:1: (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 )
            {
            // InternalSequencerTestLanguage.g:1925:1: (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt22=1;
                }
                break;
            case 17:
                {
                alt22=2;
                }
                break;
            case 19:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalSequencerTestLanguage.g:1926:3: lv_val_1_1= ruleDefEnum1
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleEnumAccess().getValDefEnum1EnumRuleCall_1_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_1_1=ruleDefEnum1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleEnumRule());
                    	        }
                           		set(
                           			current, 
                           			"val",
                            		lv_val_1_1, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.DefEnum1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:1941:8: lv_val_1_2= ruleDefEnum2
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleEnumAccess().getValDefEnum2EnumRuleCall_1_0_1()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_1_2=ruleDefEnum2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleEnumRule());
                    	        }
                           		set(
                           			current, 
                           			"val",
                            		lv_val_1_2, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.DefEnum2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 3 :
                    // InternalSequencerTestLanguage.g:1956:8: lv_val_1_3= ruleDefEnum3
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleEnumAccess().getValDefEnum3EnumRuleCall_1_0_2()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_1_3=ruleDefEnum3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleEnumRule());
                    	        }
                           		set(
                           			current, 
                           			"val",
                            		lv_val_1_3, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.DefEnum3");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleEnum"


    // $ANTLR start "entryRuleSingleCrossReference"
    // InternalSequencerTestLanguage.g:1982:1: entryRuleSingleCrossReference returns [EObject current=null] : iv_ruleSingleCrossReference= ruleSingleCrossReference EOF ;
    public final EObject entryRuleSingleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleCrossReference = null;


        try {
            // InternalSequencerTestLanguage.g:1983:2: (iv_ruleSingleCrossReference= ruleSingleCrossReference EOF )
            // InternalSequencerTestLanguage.g:1984:2: iv_ruleSingleCrossReference= ruleSingleCrossReference EOF
            {
             newCompositeNode(grammarAccess.getSingleCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleCrossReference=ruleSingleCrossReference();

            state._fsp--;

             current =iv_ruleSingleCrossReference; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalSequencerTestLanguage.g:1991:1: ruleSingleCrossReference returns [EObject current=null] : (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) ) ;
    public final EObject ruleSingleCrossReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:1994:28: ( (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) ) )
            // InternalSequencerTestLanguage.g:1995:1: (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) )
            {
            // InternalSequencerTestLanguage.g:1995:1: (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) )
            // InternalSequencerTestLanguage.g:1995:3: otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) )
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_19); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleCrossReferenceAccess().getNumberSignDigitOneDigitFourKeyword_0());
                
            // InternalSequencerTestLanguage.g:1999:1: ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) )
            // InternalSequencerTestLanguage.g:2000:1: ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) )
            {
            // InternalSequencerTestLanguage.g:2000:1: ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) )
            // InternalSequencerTestLanguage.g:2001:1: (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 )
            {
            // InternalSequencerTestLanguage.g:2001:1: (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 )
            int alt23=3;
            switch ( input.LA(1) ) {
            case RULE_ID1:
                {
                alt23=1;
                }
                break;
            case RULE_ID2:
                {
                alt23=2;
                }
                break;
            case RULE_ID3:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalSequencerTestLanguage.g:2002:3: lv_name_1_1= RULE_ID1
                    {
                    lv_name_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_19); 

                    			newLeafNode(lv_name_1_1, grammarAccess.getSingleCrossReferenceAccess().getNameID1TerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_1, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.ID1");
                    	    

                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:2017:8: lv_name_1_2= RULE_ID2
                    {
                    lv_name_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_19); 

                    			newLeafNode(lv_name_1_2, grammarAccess.getSingleCrossReferenceAccess().getNameID2TerminalRuleCall_1_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_2, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.ID2");
                    	    

                    }
                    break;
                case 3 :
                    // InternalSequencerTestLanguage.g:2032:8: lv_name_1_3= RULE_ID3
                    {
                    lv_name_1_3=(Token)match(input,RULE_ID3,FollowSets000.FOLLOW_19); 

                    			newLeafNode(lv_name_1_3, grammarAccess.getSingleCrossReferenceAccess().getNameID3TerminalRuleCall_1_0_2()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_3, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.ID3");
                    	    

                    }
                    break;

            }


            }


            }

            // InternalSequencerTestLanguage.g:2050:2: ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) )
            int alt24=3;
            switch ( input.LA(1) ) {
            case RULE_ID1:
                {
                alt24=1;
                }
                break;
            case RULE_ID2:
                {
                alt24=2;
                }
                break;
            case RULE_ID3:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalSequencerTestLanguage.g:2050:3: ( (otherlv_2= RULE_ID1 ) )
                    {
                    // InternalSequencerTestLanguage.g:2050:3: ( (otherlv_2= RULE_ID1 ) )
                    // InternalSequencerTestLanguage.g:2051:1: (otherlv_2= RULE_ID1 )
                    {
                    // InternalSequencerTestLanguage.g:2051:1: (otherlv_2= RULE_ID1 )
                    // InternalSequencerTestLanguage.g:2052:3: otherlv_2= RULE_ID1
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_2); 

                    		newLeafNode(otherlv_2, grammarAccess.getSingleCrossReferenceAccess().getRefSingleCrossReferenceCrossReference_2_0_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:2064:6: ( (otherlv_3= RULE_ID2 ) )
                    {
                    // InternalSequencerTestLanguage.g:2064:6: ( (otherlv_3= RULE_ID2 ) )
                    // InternalSequencerTestLanguage.g:2065:1: (otherlv_3= RULE_ID2 )
                    {
                    // InternalSequencerTestLanguage.g:2065:1: (otherlv_3= RULE_ID2 )
                    // InternalSequencerTestLanguage.g:2066:3: otherlv_3= RULE_ID2
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_2); 

                    		newLeafNode(otherlv_3, grammarAccess.getSingleCrossReferenceAccess().getRefSingleCrossReferenceCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSequencerTestLanguage.g:2078:6: ( (otherlv_4= RULE_ID3 ) )
                    {
                    // InternalSequencerTestLanguage.g:2078:6: ( (otherlv_4= RULE_ID3 ) )
                    // InternalSequencerTestLanguage.g:2079:1: (otherlv_4= RULE_ID3 )
                    {
                    // InternalSequencerTestLanguage.g:2079:1: (otherlv_4= RULE_ID3 )
                    // InternalSequencerTestLanguage.g:2080:3: otherlv_4= RULE_ID3
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID3,FollowSets000.FOLLOW_2); 

                    		newLeafNode(otherlv_4, grammarAccess.getSingleCrossReferenceAccess().getRefSingleCrossReferenceCrossReference_2_2_0()); 
                    	

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleSingleContainmentReference"
    // InternalSequencerTestLanguage.g:2099:1: entryRuleSingleContainmentReference returns [EObject current=null] : iv_ruleSingleContainmentReference= ruleSingleContainmentReference EOF ;
    public final EObject entryRuleSingleContainmentReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleContainmentReference = null;


        try {
            // InternalSequencerTestLanguage.g:2100:2: (iv_ruleSingleContainmentReference= ruleSingleContainmentReference EOF )
            // InternalSequencerTestLanguage.g:2101:2: iv_ruleSingleContainmentReference= ruleSingleContainmentReference EOF
            {
             newCompositeNode(grammarAccess.getSingleContainmentReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleContainmentReference=ruleSingleContainmentReference();

            state._fsp--;

             current =iv_ruleSingleContainmentReference; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleContainmentReference"


    // $ANTLR start "ruleSingleContainmentReference"
    // InternalSequencerTestLanguage.g:2108:1: ruleSingleContainmentReference returns [EObject current=null] : (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) ) ;
    public final EObject ruleSingleContainmentReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_child_1_1 = null;

        EObject lv_child_1_2 = null;

        EObject lv_child_1_3 = null;


         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2111:28: ( (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) ) )
            // InternalSequencerTestLanguage.g:2112:1: (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) )
            {
            // InternalSequencerTestLanguage.g:2112:1: (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) )
            // InternalSequencerTestLanguage.g:2112:3: otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) )
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_16); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleContainmentReferenceAccess().getNumberSignDigitOneDigitFiveKeyword_0());
                
            // InternalSequencerTestLanguage.g:2116:1: ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) )
            // InternalSequencerTestLanguage.g:2117:1: ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) )
            {
            // InternalSequencerTestLanguage.g:2117:1: ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) )
            // InternalSequencerTestLanguage.g:2118:1: (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 )
            {
            // InternalSequencerTestLanguage.g:2118:1: (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt25=1;
                }
                break;
            case 17:
                {
                alt25=2;
                }
                break;
            case 19:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalSequencerTestLanguage.g:2119:3: lv_child_1_1= ruleSingleContainmentReferenceChild1
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleContainmentReferenceAccess().getChildSingleContainmentReferenceChild1ParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_child_1_1=ruleSingleContainmentReferenceChild1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleContainmentReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"child",
                            		lv_child_1_1, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.SingleContainmentReferenceChild1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:2134:8: lv_child_1_2= ruleSingleContainmentReferenceChild2
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleContainmentReferenceAccess().getChildSingleContainmentReferenceChild2ParserRuleCall_1_0_1()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_child_1_2=ruleSingleContainmentReferenceChild2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleContainmentReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"child",
                            		lv_child_1_2, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.SingleContainmentReferenceChild2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 3 :
                    // InternalSequencerTestLanguage.g:2149:8: lv_child_1_3= ruleSingleContainmentReferenceChild3
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleContainmentReferenceAccess().getChildSingleContainmentReferenceChild3ParserRuleCall_1_0_2()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_child_1_3=ruleSingleContainmentReferenceChild3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleContainmentReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"child",
                            		lv_child_1_3, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.SingleContainmentReferenceChild3");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleContainmentReference"


    // $ANTLR start "entryRuleSingleContainmentReferenceChild1"
    // InternalSequencerTestLanguage.g:2175:1: entryRuleSingleContainmentReferenceChild1 returns [EObject current=null] : iv_ruleSingleContainmentReferenceChild1= ruleSingleContainmentReferenceChild1 EOF ;
    public final EObject entryRuleSingleContainmentReferenceChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleContainmentReferenceChild1 = null;


        try {
            // InternalSequencerTestLanguage.g:2176:2: (iv_ruleSingleContainmentReferenceChild1= ruleSingleContainmentReferenceChild1 EOF )
            // InternalSequencerTestLanguage.g:2177:2: iv_ruleSingleContainmentReferenceChild1= ruleSingleContainmentReferenceChild1 EOF
            {
             newCompositeNode(grammarAccess.getSingleContainmentReferenceChild1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleContainmentReferenceChild1=ruleSingleContainmentReferenceChild1();

            state._fsp--;

             current =iv_ruleSingleContainmentReferenceChild1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleContainmentReferenceChild1"


    // $ANTLR start "ruleSingleContainmentReferenceChild1"
    // InternalSequencerTestLanguage.g:2184:1: ruleSingleContainmentReferenceChild1 returns [EObject current=null] : ( (lv_val_0_0= 'kw1' ) ) ;
    public final EObject ruleSingleContainmentReferenceChild1() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2187:28: ( ( (lv_val_0_0= 'kw1' ) ) )
            // InternalSequencerTestLanguage.g:2188:1: ( (lv_val_0_0= 'kw1' ) )
            {
            // InternalSequencerTestLanguage.g:2188:1: ( (lv_val_0_0= 'kw1' ) )
            // InternalSequencerTestLanguage.g:2189:1: (lv_val_0_0= 'kw1' )
            {
            // InternalSequencerTestLanguage.g:2189:1: (lv_val_0_0= 'kw1' )
            // InternalSequencerTestLanguage.g:2190:3: lv_val_0_0= 'kw1'
            {
            lv_val_0_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    newLeafNode(lv_val_0_0, grammarAccess.getSingleContainmentReferenceChild1Access().getValKw1Keyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSingleContainmentReferenceChild1Rule());
            	        }
                   		setWithLastConsumed(current, "val", lv_val_0_0, "kw1");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleContainmentReferenceChild1"


    // $ANTLR start "entryRuleSingleContainmentReferenceChild2"
    // InternalSequencerTestLanguage.g:2211:1: entryRuleSingleContainmentReferenceChild2 returns [EObject current=null] : iv_ruleSingleContainmentReferenceChild2= ruleSingleContainmentReferenceChild2 EOF ;
    public final EObject entryRuleSingleContainmentReferenceChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleContainmentReferenceChild2 = null;


        try {
            // InternalSequencerTestLanguage.g:2212:2: (iv_ruleSingleContainmentReferenceChild2= ruleSingleContainmentReferenceChild2 EOF )
            // InternalSequencerTestLanguage.g:2213:2: iv_ruleSingleContainmentReferenceChild2= ruleSingleContainmentReferenceChild2 EOF
            {
             newCompositeNode(grammarAccess.getSingleContainmentReferenceChild2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleContainmentReferenceChild2=ruleSingleContainmentReferenceChild2();

            state._fsp--;

             current =iv_ruleSingleContainmentReferenceChild2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleContainmentReferenceChild2"


    // $ANTLR start "ruleSingleContainmentReferenceChild2"
    // InternalSequencerTestLanguage.g:2220:1: ruleSingleContainmentReferenceChild2 returns [EObject current=null] : ( (lv_val_0_0= 'kw2' ) ) ;
    public final EObject ruleSingleContainmentReferenceChild2() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2223:28: ( ( (lv_val_0_0= 'kw2' ) ) )
            // InternalSequencerTestLanguage.g:2224:1: ( (lv_val_0_0= 'kw2' ) )
            {
            // InternalSequencerTestLanguage.g:2224:1: ( (lv_val_0_0= 'kw2' ) )
            // InternalSequencerTestLanguage.g:2225:1: (lv_val_0_0= 'kw2' )
            {
            // InternalSequencerTestLanguage.g:2225:1: (lv_val_0_0= 'kw2' )
            // InternalSequencerTestLanguage.g:2226:3: lv_val_0_0= 'kw2'
            {
            lv_val_0_0=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                    newLeafNode(lv_val_0_0, grammarAccess.getSingleContainmentReferenceChild2Access().getValKw2Keyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSingleContainmentReferenceChild2Rule());
            	        }
                   		setWithLastConsumed(current, "val", lv_val_0_0, "kw2");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleContainmentReferenceChild2"


    // $ANTLR start "entryRuleSingleContainmentReferenceChild3"
    // InternalSequencerTestLanguage.g:2247:1: entryRuleSingleContainmentReferenceChild3 returns [EObject current=null] : iv_ruleSingleContainmentReferenceChild3= ruleSingleContainmentReferenceChild3 EOF ;
    public final EObject entryRuleSingleContainmentReferenceChild3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleContainmentReferenceChild3 = null;


        try {
            // InternalSequencerTestLanguage.g:2248:2: (iv_ruleSingleContainmentReferenceChild3= ruleSingleContainmentReferenceChild3 EOF )
            // InternalSequencerTestLanguage.g:2249:2: iv_ruleSingleContainmentReferenceChild3= ruleSingleContainmentReferenceChild3 EOF
            {
             newCompositeNode(grammarAccess.getSingleContainmentReferenceChild3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleContainmentReferenceChild3=ruleSingleContainmentReferenceChild3();

            state._fsp--;

             current =iv_ruleSingleContainmentReferenceChild3; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleContainmentReferenceChild3"


    // $ANTLR start "ruleSingleContainmentReferenceChild3"
    // InternalSequencerTestLanguage.g:2256:1: ruleSingleContainmentReferenceChild3 returns [EObject current=null] : ( (lv_val_0_0= 'kw3' ) ) ;
    public final EObject ruleSingleContainmentReferenceChild3() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2259:28: ( ( (lv_val_0_0= 'kw3' ) ) )
            // InternalSequencerTestLanguage.g:2260:1: ( (lv_val_0_0= 'kw3' ) )
            {
            // InternalSequencerTestLanguage.g:2260:1: ( (lv_val_0_0= 'kw3' ) )
            // InternalSequencerTestLanguage.g:2261:1: (lv_val_0_0= 'kw3' )
            {
            // InternalSequencerTestLanguage.g:2261:1: (lv_val_0_0= 'kw3' )
            // InternalSequencerTestLanguage.g:2262:3: lv_val_0_0= 'kw3'
            {
            lv_val_0_0=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                    newLeafNode(lv_val_0_0, grammarAccess.getSingleContainmentReferenceChild3Access().getValKw3Keyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSingleContainmentReferenceChild3Rule());
            	        }
                   		setWithLastConsumed(current, "val", lv_val_0_0, "kw3");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleContainmentReferenceChild3"


    // $ANTLR start "entryRuleMultiKeywords"
    // InternalSequencerTestLanguage.g:2283:1: entryRuleMultiKeywords returns [EObject current=null] : iv_ruleMultiKeywords= ruleMultiKeywords EOF ;
    public final EObject entryRuleMultiKeywords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiKeywords = null;


        try {
            // InternalSequencerTestLanguage.g:2284:2: (iv_ruleMultiKeywords= ruleMultiKeywords EOF )
            // InternalSequencerTestLanguage.g:2285:2: iv_ruleMultiKeywords= ruleMultiKeywords EOF
            {
             newCompositeNode(grammarAccess.getMultiKeywordsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiKeywords=ruleMultiKeywords();

            state._fsp--;

             current =iv_ruleMultiKeywords; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleMultiKeywords"


    // $ANTLR start "ruleMultiKeywords"
    // InternalSequencerTestLanguage.g:2292:1: ruleMultiKeywords returns [EObject current=null] : (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) ;
    public final EObject ruleMultiKeywords() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2295:28: ( (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) )
            // InternalSequencerTestLanguage.g:2296:1: (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            {
            // InternalSequencerTestLanguage.g:2296:1: (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            // InternalSequencerTestLanguage.g:2296:3: otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_16); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiKeywordsAccess().getNumberSignDigitOneDigitSixKeyword_0());
                
            // InternalSequencerTestLanguage.g:2300:1: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            // InternalSequencerTestLanguage.g:2301:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            {
            // InternalSequencerTestLanguage.g:2301:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            // InternalSequencerTestLanguage.g:2302:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
            {
            // InternalSequencerTestLanguage.g:2302:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt26=1;
                }
                break;
            case 17:
                {
                alt26=2;
                }
                break;
            case 19:
                {
                alt26=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalSequencerTestLanguage.g:2303:3: lv_val_1_1= 'kw1'
                    {
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_val_1_1, grammarAccess.getMultiKeywordsAccess().getValKw1Keyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsRule());
                    	        }
                           		addWithLastConsumed(current, "val", lv_val_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:2315:8: lv_val_1_2= 'kw2'
                    {
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_val_1_2, grammarAccess.getMultiKeywordsAccess().getValKw2Keyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsRule());
                    	        }
                           		addWithLastConsumed(current, "val", lv_val_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalSequencerTestLanguage.g:2327:8: lv_val_1_3= 'kw3'
                    {
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_val_1_3, grammarAccess.getMultiKeywordsAccess().getValKw3Keyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsRule());
                    	        }
                           		addWithLastConsumed(current, "val", lv_val_1_3, null);
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiKeywords"


    // $ANTLR start "entryRuleMultiKeywordsOrID"
    // InternalSequencerTestLanguage.g:2350:1: entryRuleMultiKeywordsOrID returns [EObject current=null] : iv_ruleMultiKeywordsOrID= ruleMultiKeywordsOrID EOF ;
    public final EObject entryRuleMultiKeywordsOrID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiKeywordsOrID = null;


        try {
            // InternalSequencerTestLanguage.g:2351:2: (iv_ruleMultiKeywordsOrID= ruleMultiKeywordsOrID EOF )
            // InternalSequencerTestLanguage.g:2352:2: iv_ruleMultiKeywordsOrID= ruleMultiKeywordsOrID EOF
            {
             newCompositeNode(grammarAccess.getMultiKeywordsOrIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiKeywordsOrID=ruleMultiKeywordsOrID();

            state._fsp--;

             current =iv_ruleMultiKeywordsOrID; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleMultiKeywordsOrID"


    // $ANTLR start "ruleMultiKeywordsOrID"
    // InternalSequencerTestLanguage.g:2359:1: ruleMultiKeywordsOrID returns [EObject current=null] : (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) ;
    public final EObject ruleMultiKeywordsOrID() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;
        Token lv_val_1_4=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2362:28: ( (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) )
            // InternalSequencerTestLanguage.g:2363:1: (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            {
            // InternalSequencerTestLanguage.g:2363:1: (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            // InternalSequencerTestLanguage.g:2363:3: otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            {
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiKeywordsOrIDAccess().getNumberSignDigitOneDigitSevenKeyword_0());
                
            // InternalSequencerTestLanguage.g:2367:1: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:2368:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            {
            // InternalSequencerTestLanguage.g:2368:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            // InternalSequencerTestLanguage.g:2369:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:2369:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
            int alt27=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt27=1;
                }
                break;
            case 17:
                {
                alt27=2;
                }
                break;
            case 19:
                {
                alt27=3;
                }
                break;
            case RULE_ID:
                {
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalSequencerTestLanguage.g:2370:3: lv_val_1_1= 'kw1'
                    {
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_val_1_1, grammarAccess.getMultiKeywordsOrIDAccess().getValKw1Keyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsOrIDRule());
                    	        }
                           		addWithLastConsumed(current, "val", lv_val_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:2382:8: lv_val_1_2= 'kw2'
                    {
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_val_1_2, grammarAccess.getMultiKeywordsOrIDAccess().getValKw2Keyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsOrIDRule());
                    	        }
                           		addWithLastConsumed(current, "val", lv_val_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalSequencerTestLanguage.g:2394:8: lv_val_1_3= 'kw3'
                    {
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_val_1_3, grammarAccess.getMultiKeywordsOrIDAccess().getValKw3Keyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsOrIDRule());
                    	        }
                           		addWithLastConsumed(current, "val", lv_val_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // InternalSequencerTestLanguage.g:2406:8: lv_val_1_4= RULE_ID
                    {
                    lv_val_1_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val_1_4, grammarAccess.getMultiKeywordsOrIDAccess().getValIDTerminalRuleCall_1_0_3()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsOrIDRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_4, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiKeywordsOrID"


    // $ANTLR start "entryRuleMultiTerminals"
    // InternalSequencerTestLanguage.g:2432:1: entryRuleMultiTerminals returns [EObject current=null] : iv_ruleMultiTerminals= ruleMultiTerminals EOF ;
    public final EObject entryRuleMultiTerminals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiTerminals = null;


        try {
            // InternalSequencerTestLanguage.g:2433:2: (iv_ruleMultiTerminals= ruleMultiTerminals EOF )
            // InternalSequencerTestLanguage.g:2434:2: iv_ruleMultiTerminals= ruleMultiTerminals EOF
            {
             newCompositeNode(grammarAccess.getMultiTerminalsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiTerminals=ruleMultiTerminals();

            state._fsp--;

             current =iv_ruleMultiTerminals; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleMultiTerminals"


    // $ANTLR start "ruleMultiTerminals"
    // InternalSequencerTestLanguage.g:2441:1: ruleMultiTerminals returns [EObject current=null] : (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) ;
    public final EObject ruleMultiTerminals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2444:28: ( (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) )
            // InternalSequencerTestLanguage.g:2445:1: (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            {
            // InternalSequencerTestLanguage.g:2445:1: (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            // InternalSequencerTestLanguage.g:2445:3: otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_18); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiTerminalsAccess().getNumberSignDigitOneDigitEightKeyword_0());
                
            // InternalSequencerTestLanguage.g:2449:1: ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            // InternalSequencerTestLanguage.g:2450:1: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            {
            // InternalSequencerTestLanguage.g:2450:1: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            // InternalSequencerTestLanguage.g:2451:1: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
            {
            // InternalSequencerTestLanguage.g:2451:1: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID1) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_ID2) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalSequencerTestLanguage.g:2452:3: lv_val_1_1= RULE_ID1
                    {
                    lv_val_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val_1_1, grammarAccess.getMultiTerminalsAccess().getValID1TerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiTerminalsRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_1, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.ID1");
                    	    

                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:2467:8: lv_val_1_2= RULE_ID2
                    {
                    lv_val_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val_1_2, grammarAccess.getMultiTerminalsAccess().getValID2TerminalRuleCall_1_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiTerminalsRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_2, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.ID2");
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiTerminals"


    // $ANTLR start "entryRuleDependentAlternative1"
    // InternalSequencerTestLanguage.g:2493:1: entryRuleDependentAlternative1 returns [EObject current=null] : iv_ruleDependentAlternative1= ruleDependentAlternative1 EOF ;
    public final EObject entryRuleDependentAlternative1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependentAlternative1 = null;


        try {
            // InternalSequencerTestLanguage.g:2494:2: (iv_ruleDependentAlternative1= ruleDependentAlternative1 EOF )
            // InternalSequencerTestLanguage.g:2495:2: iv_ruleDependentAlternative1= ruleDependentAlternative1 EOF
            {
             newCompositeNode(grammarAccess.getDependentAlternative1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDependentAlternative1=ruleDependentAlternative1();

            state._fsp--;

             current =iv_ruleDependentAlternative1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleDependentAlternative1"


    // $ANTLR start "ruleDependentAlternative1"
    // InternalSequencerTestLanguage.g:2502:1: ruleDependentAlternative1 returns [EObject current=null] : (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) ) ;
    public final EObject ruleDependentAlternative1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token lv_val_2_0=null;
        Token lv_flag_3_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2505:28: ( (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) ) )
            // InternalSequencerTestLanguage.g:2506:1: (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) )
            {
            // InternalSequencerTestLanguage.g:2506:1: (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) )
            // InternalSequencerTestLanguage.g:2506:3: otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) )
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getDependentAlternative1Access().getNumberSignDigitOneDigitNineKeyword_0());
                
            // InternalSequencerTestLanguage.g:2510:1: ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==EOF) ) {
                    alt29=1;
                }
                else if ( (LA29_1==16) ) {
                    alt29=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalSequencerTestLanguage.g:2510:2: ( (lv_val_1_0= RULE_ID ) )
                    {
                    // InternalSequencerTestLanguage.g:2510:2: ( (lv_val_1_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:2511:1: (lv_val_1_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:2511:1: (lv_val_1_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:2512:3: lv_val_1_0= RULE_ID
                    {
                    lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val_1_0, grammarAccess.getDependentAlternative1Access().getValIDTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDependentAlternative1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:2529:6: ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) )
                    {
                    // InternalSequencerTestLanguage.g:2529:6: ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) )
                    // InternalSequencerTestLanguage.g:2529:7: ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) )
                    {
                    // InternalSequencerTestLanguage.g:2529:7: ( (lv_val_2_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:2530:1: (lv_val_2_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:2530:1: (lv_val_2_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:2531:3: lv_val_2_0= RULE_ID
                    {
                    lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    			newLeafNode(lv_val_2_0, grammarAccess.getDependentAlternative1Access().getValIDTerminalRuleCall_1_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDependentAlternative1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_2_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // InternalSequencerTestLanguage.g:2547:2: ( (lv_flag_3_0= 'kw1' ) )
                    // InternalSequencerTestLanguage.g:2548:1: (lv_flag_3_0= 'kw1' )
                    {
                    // InternalSequencerTestLanguage.g:2548:1: (lv_flag_3_0= 'kw1' )
                    // InternalSequencerTestLanguage.g:2549:3: lv_flag_3_0= 'kw1'
                    {
                    lv_flag_3_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_flag_3_0, grammarAccess.getDependentAlternative1Access().getFlagKw1Keyword_1_1_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDependentAlternative1Rule());
                    	        }
                           		setWithLastConsumed(current, "flag", true, "kw1");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDependentAlternative1"


    // $ANTLR start "entryRuleDependentAlternative2"
    // InternalSequencerTestLanguage.g:2570:1: entryRuleDependentAlternative2 returns [EObject current=null] : iv_ruleDependentAlternative2= ruleDependentAlternative2 EOF ;
    public final EObject entryRuleDependentAlternative2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependentAlternative2 = null;


        try {
            // InternalSequencerTestLanguage.g:2571:2: (iv_ruleDependentAlternative2= ruleDependentAlternative2 EOF )
            // InternalSequencerTestLanguage.g:2572:2: iv_ruleDependentAlternative2= ruleDependentAlternative2 EOF
            {
             newCompositeNode(grammarAccess.getDependentAlternative2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDependentAlternative2=ruleDependentAlternative2();

            state._fsp--;

             current =iv_ruleDependentAlternative2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleDependentAlternative2"


    // $ANTLR start "ruleDependentAlternative2"
    // InternalSequencerTestLanguage.g:2579:1: ruleDependentAlternative2 returns [EObject current=null] : (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) ) ;
    public final EObject ruleDependentAlternative2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token lv_val_2_0=null;
        Token lv_val_3_0=null;
        Token lv_flag_4_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2582:28: ( (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) ) )
            // InternalSequencerTestLanguage.g:2583:1: (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) )
            {
            // InternalSequencerTestLanguage.g:2583:1: (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) )
            // InternalSequencerTestLanguage.g:2583:3: otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getDependentAlternative2Access().getNumberSignDigitTwoDigitZeroKeyword_0());
                
            // InternalSequencerTestLanguage.g:2587:1: ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalSequencerTestLanguage.g:2587:2: ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ )
                    {
                    // InternalSequencerTestLanguage.g:2587:2: ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ )
                    // InternalSequencerTestLanguage.g:2587:3: ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+
                    {
                    // InternalSequencerTestLanguage.g:2587:3: ( (lv_val_1_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:2588:1: (lv_val_1_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:2588:1: (lv_val_1_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:2589:3: lv_val_1_0= RULE_ID
                    {
                    lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_val_1_0, grammarAccess.getDependentAlternative2Access().getValIDTerminalRuleCall_1_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDependentAlternative2Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // InternalSequencerTestLanguage.g:2605:2: ( (lv_val_2_0= RULE_ID ) )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_ID) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalSequencerTestLanguage.g:2606:1: (lv_val_2_0= RULE_ID )
                    	    {
                    	    // InternalSequencerTestLanguage.g:2606:1: (lv_val_2_0= RULE_ID )
                    	    // InternalSequencerTestLanguage.g:2607:3: lv_val_2_0= RULE_ID
                    	    {
                    	    lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    	    			newLeafNode(lv_val_2_0, grammarAccess.getDependentAlternative2Access().getValIDTerminalRuleCall_1_0_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getDependentAlternative2Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"val",
                    	            		lv_val_2_0, 
                    	            		"org.eclipse.xtext.common.Terminals.ID");
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt30 >= 1 ) break loop30;
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:2624:6: ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) )
                    {
                    // InternalSequencerTestLanguage.g:2624:6: ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) )
                    // InternalSequencerTestLanguage.g:2624:7: ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) )
                    {
                    // InternalSequencerTestLanguage.g:2624:7: ( (lv_val_3_0= RULE_ID ) )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==RULE_ID) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalSequencerTestLanguage.g:2625:1: (lv_val_3_0= RULE_ID )
                    	    {
                    	    // InternalSequencerTestLanguage.g:2625:1: (lv_val_3_0= RULE_ID )
                    	    // InternalSequencerTestLanguage.g:2626:3: lv_val_3_0= RULE_ID
                    	    {
                    	    lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); 

                    	    			newLeafNode(lv_val_3_0, grammarAccess.getDependentAlternative2Access().getValIDTerminalRuleCall_1_1_0_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getDependentAlternative2Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"val",
                    	            		lv_val_3_0, 
                    	            		"org.eclipse.xtext.common.Terminals.ID");
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);

                    // InternalSequencerTestLanguage.g:2642:3: ( (lv_flag_4_0= 'kw1' ) )
                    // InternalSequencerTestLanguage.g:2643:1: (lv_flag_4_0= 'kw1' )
                    {
                    // InternalSequencerTestLanguage.g:2643:1: (lv_flag_4_0= 'kw1' )
                    // InternalSequencerTestLanguage.g:2644:3: lv_flag_4_0= 'kw1'
                    {
                    lv_flag_4_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_flag_4_0, grammarAccess.getDependentAlternative2Access().getFlagKw1Keyword_1_1_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDependentAlternative2Rule());
                    	        }
                           		setWithLastConsumed(current, "flag", true, "kw1");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDependentAlternative2"


    // $ANTLR start "entryRuleOptional"
    // InternalSequencerTestLanguage.g:2665:1: entryRuleOptional returns [EObject current=null] : iv_ruleOptional= ruleOptional EOF ;
    public final EObject entryRuleOptional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptional = null;


        try {
            // InternalSequencerTestLanguage.g:2666:2: (iv_ruleOptional= ruleOptional EOF )
            // InternalSequencerTestLanguage.g:2667:2: iv_ruleOptional= ruleOptional EOF
            {
             newCompositeNode(grammarAccess.getOptionalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptional=ruleOptional();

            state._fsp--;

             current =iv_ruleOptional; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleOptional"


    // $ANTLR start "ruleOptional"
    // InternalSequencerTestLanguage.g:2674:1: ruleOptional returns [EObject current=null] : (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? ) ;
    public final EObject ruleOptional() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_int0_1_0=null;
        Token lv_int1_2_0=null;
        Token lv_int2_3_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2677:28: ( (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? ) )
            // InternalSequencerTestLanguage.g:2678:1: (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? )
            {
            // InternalSequencerTestLanguage.g:2678:1: (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? )
            // InternalSequencerTestLanguage.g:2678:3: otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )?
            {
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_21); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionalAccess().getNumberSignDigitTwoDigitOneKeyword_0());
                
            // InternalSequencerTestLanguage.g:2682:1: ( (lv_int0_1_0= RULE_INT ) )
            // InternalSequencerTestLanguage.g:2683:1: (lv_int0_1_0= RULE_INT )
            {
            // InternalSequencerTestLanguage.g:2683:1: (lv_int0_1_0= RULE_INT )
            // InternalSequencerTestLanguage.g:2684:3: lv_int0_1_0= RULE_INT
            {
            lv_int0_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_22); 

            			newLeafNode(lv_int0_1_0, grammarAccess.getOptionalAccess().getInt0INTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"int0",
                    		lv_int0_1_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

            }


            }

            // InternalSequencerTestLanguage.g:2700:2: ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_INT) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalSequencerTestLanguage.g:2700:3: ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) )
                    {
                    // InternalSequencerTestLanguage.g:2700:3: ( (lv_int1_2_0= RULE_INT ) )
                    // InternalSequencerTestLanguage.g:2701:1: (lv_int1_2_0= RULE_INT )
                    {
                    // InternalSequencerTestLanguage.g:2701:1: (lv_int1_2_0= RULE_INT )
                    // InternalSequencerTestLanguage.g:2702:3: lv_int1_2_0= RULE_INT
                    {
                    lv_int1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_21); 

                    			newLeafNode(lv_int1_2_0, grammarAccess.getOptionalAccess().getInt1INTTerminalRuleCall_2_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getOptionalRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"int1",
                            		lv_int1_2_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }

                    // InternalSequencerTestLanguage.g:2718:2: ( (lv_int2_3_0= RULE_INT ) )
                    // InternalSequencerTestLanguage.g:2719:1: (lv_int2_3_0= RULE_INT )
                    {
                    // InternalSequencerTestLanguage.g:2719:1: (lv_int2_3_0= RULE_INT )
                    // InternalSequencerTestLanguage.g:2720:3: lv_int2_3_0= RULE_INT
                    {
                    lv_int2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_int2_3_0, grammarAccess.getOptionalAccess().getInt2INTTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getOptionalRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"int2",
                            		lv_int2_3_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptional"


    // $ANTLR start "entryRuleFloat"
    // InternalSequencerTestLanguage.g:2744:1: entryRuleFloat returns [EObject current=null] : iv_ruleFloat= ruleFloat EOF ;
    public final EObject entryRuleFloat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloat = null;


        try {
            // InternalSequencerTestLanguage.g:2745:2: (iv_ruleFloat= ruleFloat EOF )
            // InternalSequencerTestLanguage.g:2746:2: iv_ruleFloat= ruleFloat EOF
            {
             newCompositeNode(grammarAccess.getFloatRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFloat=ruleFloat();

            state._fsp--;

             current =iv_ruleFloat; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleFloat"


    // $ANTLR start "ruleFloat"
    // InternalSequencerTestLanguage.g:2753:1: ruleFloat returns [EObject current=null] : (otherlv_0= '#22' () otherlv_2= 'Bye' ) ;
    public final EObject ruleFloat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2756:28: ( (otherlv_0= '#22' () otherlv_2= 'Bye' ) )
            // InternalSequencerTestLanguage.g:2757:1: (otherlv_0= '#22' () otherlv_2= 'Bye' )
            {
            // InternalSequencerTestLanguage.g:2757:1: (otherlv_0= '#22' () otherlv_2= 'Bye' )
            // InternalSequencerTestLanguage.g:2757:3: otherlv_0= '#22' () otherlv_2= 'Bye'
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_23); 

                	newLeafNode(otherlv_0, grammarAccess.getFloatAccess().getNumberSignDigitTwoDigitTwoKeyword_0());
                
            // InternalSequencerTestLanguage.g:2761:1: ()
            // InternalSequencerTestLanguage.g:2762:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFloatAccess().getFloatAction_1(),
                        current);
                

            }

            otherlv_2=(Token)match(input,43,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getFloatAccess().getByeKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloat"


    // $ANTLR start "entryRuleUnorderedAlternative"
    // InternalSequencerTestLanguage.g:2779:1: entryRuleUnorderedAlternative returns [EObject current=null] : iv_ruleUnorderedAlternative= ruleUnorderedAlternative EOF ;
    public final EObject entryRuleUnorderedAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedAlternative = null;


        try {
            // InternalSequencerTestLanguage.g:2780:2: (iv_ruleUnorderedAlternative= ruleUnorderedAlternative EOF )
            // InternalSequencerTestLanguage.g:2781:2: iv_ruleUnorderedAlternative= ruleUnorderedAlternative EOF
            {
             newCompositeNode(grammarAccess.getUnorderedAlternativeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedAlternative=ruleUnorderedAlternative();

            state._fsp--;

             current =iv_ruleUnorderedAlternative; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedAlternative"


    // $ANTLR start "ruleUnorderedAlternative"
    // InternalSequencerTestLanguage.g:2788:1: ruleUnorderedAlternative returns [EObject current=null] : (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* ) ;
    public final EObject ruleUnorderedAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        EObject lv_val3_4_0 = null;

        EObject lv_val4_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2791:28: ( (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* ) )
            // InternalSequencerTestLanguage.g:2792:1: (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* )
            {
            // InternalSequencerTestLanguage.g:2792:1: (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* )
            // InternalSequencerTestLanguage.g:2792:3: otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )*
            {
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_24); 

                	newLeafNode(otherlv_0, grammarAccess.getUnorderedAlternativeAccess().getNumberSignDigitTwoDigitThreeKeyword_0());
                
            // InternalSequencerTestLanguage.g:2796:1: ()
            // InternalSequencerTestLanguage.g:2797:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnorderedAlternativeAccess().getUnorderedAlternativeAction_1(),
                        current);
                

            }

            // InternalSequencerTestLanguage.g:2802:2: ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )*
            loop34:
            do {
                int alt34=5;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt34=1;
                    }
                    break;
                case RULE_INT:
                    {
                    alt34=2;
                    }
                    break;
                case 16:
                    {
                    alt34=3;
                    }
                    break;
                case 17:
                    {
                    alt34=4;
                    }
                    break;

                }

                switch (alt34) {
            	case 1 :
            	    // InternalSequencerTestLanguage.g:2802:3: ( (lv_val1_2_0= RULE_ID ) )
            	    {
            	    // InternalSequencerTestLanguage.g:2802:3: ( (lv_val1_2_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:2803:1: (lv_val1_2_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:2803:1: (lv_val1_2_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:2804:3: lv_val1_2_0= RULE_ID
            	    {
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_24); 

            	    			newLeafNode(lv_val1_2_0, grammarAccess.getUnorderedAlternativeAccess().getVal1IDTerminalRuleCall_2_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getUnorderedAlternativeRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val1",
            	            		lv_val1_2_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSequencerTestLanguage.g:2821:6: ( (lv_val2_3_0= RULE_INT ) )
            	    {
            	    // InternalSequencerTestLanguage.g:2821:6: ( (lv_val2_3_0= RULE_INT ) )
            	    // InternalSequencerTestLanguage.g:2822:1: (lv_val2_3_0= RULE_INT )
            	    {
            	    // InternalSequencerTestLanguage.g:2822:1: (lv_val2_3_0= RULE_INT )
            	    // InternalSequencerTestLanguage.g:2823:3: lv_val2_3_0= RULE_INT
            	    {
            	    lv_val2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_24); 

            	    			newLeafNode(lv_val2_3_0, grammarAccess.getUnorderedAlternativeAccess().getVal2INTTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getUnorderedAlternativeRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val2",
            	            		lv_val2_3_0, 
            	            		"org.eclipse.xtext.common.Terminals.INT");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSequencerTestLanguage.g:2840:6: ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) )
            	    {
            	    // InternalSequencerTestLanguage.g:2840:6: ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) )
            	    // InternalSequencerTestLanguage.g:2841:1: (lv_val3_4_0= ruleUnorderedAlternativeVal )
            	    {
            	    // InternalSequencerTestLanguage.g:2841:1: (lv_val3_4_0= ruleUnorderedAlternativeVal )
            	    // InternalSequencerTestLanguage.g:2842:3: lv_val3_4_0= ruleUnorderedAlternativeVal
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUnorderedAlternativeAccess().getVal3UnorderedAlternativeValParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_24);
            	    lv_val3_4_0=ruleUnorderedAlternativeVal();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getUnorderedAlternativeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"val3",
            	            		lv_val3_4_0, 
            	            		"org.eclipse.xtext.serializer.SequencerTestLanguage.UnorderedAlternativeVal");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalSequencerTestLanguage.g:2859:6: ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) )
            	    {
            	    // InternalSequencerTestLanguage.g:2859:6: ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) )
            	    // InternalSequencerTestLanguage.g:2860:1: (lv_val4_5_0= ruleUnorderedAlternativeValDelegate )
            	    {
            	    // InternalSequencerTestLanguage.g:2860:1: (lv_val4_5_0= ruleUnorderedAlternativeValDelegate )
            	    // InternalSequencerTestLanguage.g:2861:3: lv_val4_5_0= ruleUnorderedAlternativeValDelegate
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUnorderedAlternativeAccess().getVal4UnorderedAlternativeValDelegateParserRuleCall_2_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_24);
            	    lv_val4_5_0=ruleUnorderedAlternativeValDelegate();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getUnorderedAlternativeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"val4",
            	            		lv_val4_5_0, 
            	            		"org.eclipse.xtext.serializer.SequencerTestLanguage.UnorderedAlternativeValDelegate");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedAlternative"


    // $ANTLR start "entryRuleUnorderedAlternativeVal"
    // InternalSequencerTestLanguage.g:2885:1: entryRuleUnorderedAlternativeVal returns [EObject current=null] : iv_ruleUnorderedAlternativeVal= ruleUnorderedAlternativeVal EOF ;
    public final EObject entryRuleUnorderedAlternativeVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedAlternativeVal = null;


        try {
            // InternalSequencerTestLanguage.g:2886:2: (iv_ruleUnorderedAlternativeVal= ruleUnorderedAlternativeVal EOF )
            // InternalSequencerTestLanguage.g:2887:2: iv_ruleUnorderedAlternativeVal= ruleUnorderedAlternativeVal EOF
            {
             newCompositeNode(grammarAccess.getUnorderedAlternativeValRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedAlternativeVal=ruleUnorderedAlternativeVal();

            state._fsp--;

             current =iv_ruleUnorderedAlternativeVal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedAlternativeVal"


    // $ANTLR start "ruleUnorderedAlternativeVal"
    // InternalSequencerTestLanguage.g:2894:1: ruleUnorderedAlternativeVal returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleUnorderedAlternativeVal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2897:28: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // InternalSequencerTestLanguage.g:2898:1: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // InternalSequencerTestLanguage.g:2898:1: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:2898:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getUnorderedAlternativeValAccess().getKw1Keyword_0());
                
            // InternalSequencerTestLanguage.g:2902:1: ( (lv_val_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:2903:1: (lv_val_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:2903:1: (lv_val_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:2904:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_val_1_0, grammarAccess.getUnorderedAlternativeValAccess().getValIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnorderedAlternativeValRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedAlternativeVal"


    // $ANTLR start "entryRuleUnorderedAlternativeValDelegate"
    // InternalSequencerTestLanguage.g:2928:1: entryRuleUnorderedAlternativeValDelegate returns [EObject current=null] : iv_ruleUnorderedAlternativeValDelegate= ruleUnorderedAlternativeValDelegate EOF ;
    public final EObject entryRuleUnorderedAlternativeValDelegate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedAlternativeValDelegate = null;


        try {
            // InternalSequencerTestLanguage.g:2929:2: (iv_ruleUnorderedAlternativeValDelegate= ruleUnorderedAlternativeValDelegate EOF )
            // InternalSequencerTestLanguage.g:2930:2: iv_ruleUnorderedAlternativeValDelegate= ruleUnorderedAlternativeValDelegate EOF
            {
             newCompositeNode(grammarAccess.getUnorderedAlternativeValDelegateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedAlternativeValDelegate=ruleUnorderedAlternativeValDelegate();

            state._fsp--;

             current =iv_ruleUnorderedAlternativeValDelegate; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedAlternativeValDelegate"


    // $ANTLR start "ruleUnorderedAlternativeValDelegate"
    // InternalSequencerTestLanguage.g:2937:1: ruleUnorderedAlternativeValDelegate returns [EObject current=null] : this_UnorderedAlternativeVal2_0= ruleUnorderedAlternativeVal2 ;
    public final EObject ruleUnorderedAlternativeValDelegate() throws RecognitionException {
        EObject current = null;

        EObject this_UnorderedAlternativeVal2_0 = null;


         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2940:28: (this_UnorderedAlternativeVal2_0= ruleUnorderedAlternativeVal2 )
            // InternalSequencerTestLanguage.g:2942:5: this_UnorderedAlternativeVal2_0= ruleUnorderedAlternativeVal2
            {
             
                    newCompositeNode(grammarAccess.getUnorderedAlternativeValDelegateAccess().getUnorderedAlternativeVal2ParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
            this_UnorderedAlternativeVal2_0=ruleUnorderedAlternativeVal2();

            state._fsp--;

             
                    current = this_UnorderedAlternativeVal2_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedAlternativeValDelegate"


    // $ANTLR start "entryRuleUnorderedAlternativeVal2"
    // InternalSequencerTestLanguage.g:2958:1: entryRuleUnorderedAlternativeVal2 returns [EObject current=null] : iv_ruleUnorderedAlternativeVal2= ruleUnorderedAlternativeVal2 EOF ;
    public final EObject entryRuleUnorderedAlternativeVal2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedAlternativeVal2 = null;


        try {
            // InternalSequencerTestLanguage.g:2959:2: (iv_ruleUnorderedAlternativeVal2= ruleUnorderedAlternativeVal2 EOF )
            // InternalSequencerTestLanguage.g:2960:2: iv_ruleUnorderedAlternativeVal2= ruleUnorderedAlternativeVal2 EOF
            {
             newCompositeNode(grammarAccess.getUnorderedAlternativeVal2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedAlternativeVal2=ruleUnorderedAlternativeVal2();

            state._fsp--;

             current =iv_ruleUnorderedAlternativeVal2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedAlternativeVal2"


    // $ANTLR start "ruleUnorderedAlternativeVal2"
    // InternalSequencerTestLanguage.g:2967:1: ruleUnorderedAlternativeVal2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleUnorderedAlternativeVal2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:2970:28: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // InternalSequencerTestLanguage.g:2971:1: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // InternalSequencerTestLanguage.g:2971:1: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:2971:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getUnorderedAlternativeVal2Access().getKw2Keyword_0());
                
            // InternalSequencerTestLanguage.g:2975:1: ( (lv_val_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:2976:1: (lv_val_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:2976:1: (lv_val_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:2977:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_val_1_0, grammarAccess.getUnorderedAlternativeVal2Access().getValIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnorderedAlternativeVal2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedAlternativeVal2"


    // $ANTLR start "entryRuleUnorderedGroup"
    // InternalSequencerTestLanguage.g:3001:1: entryRuleUnorderedGroup returns [EObject current=null] : iv_ruleUnorderedGroup= ruleUnorderedGroup EOF ;
    public final EObject entryRuleUnorderedGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedGroup = null;


        try {
            // InternalSequencerTestLanguage.g:3002:2: (iv_ruleUnorderedGroup= ruleUnorderedGroup EOF )
            // InternalSequencerTestLanguage.g:3003:2: iv_ruleUnorderedGroup= ruleUnorderedGroup EOF
            {
             newCompositeNode(grammarAccess.getUnorderedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroup=ruleUnorderedGroup();

            state._fsp--;

             current =iv_ruleUnorderedGroup; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedGroup"


    // $ANTLR start "ruleUnorderedGroup"
    // InternalSequencerTestLanguage.g:3010:1: ruleUnorderedGroup returns [EObject current=null] : (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleUnorderedGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        EObject lv_val3_4_0 = null;

        EObject lv_val4_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3013:28: ( (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) ) )
            // InternalSequencerTestLanguage.g:3014:1: (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalSequencerTestLanguage.g:3014:1: (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) )
            // InternalSequencerTestLanguage.g:3014:3: otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) )
            {
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_25); 

                	newLeafNode(otherlv_0, grammarAccess.getUnorderedGroupAccess().getNumberSignDigitTwoDigitFourKeyword_0());
                
            // InternalSequencerTestLanguage.g:3018:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) )
            // InternalSequencerTestLanguage.g:3020:1: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) )
            {
            // InternalSequencerTestLanguage.g:3020:1: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) )
            // InternalSequencerTestLanguage.g:3021:2: ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            	
            // InternalSequencerTestLanguage.g:3024:2: ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?)
            // InternalSequencerTestLanguage.g:3025:3: ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?
            {
            // InternalSequencerTestLanguage.g:3025:3: ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+
            int cnt35=0;
            loop35:
            do {
                int alt35=5;
                int LA35_0 = input.LA(1);

                if ( LA35_0 == RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0) ) {
                    alt35=1;
                }
                else if ( LA35_0 == RULE_INT && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1) ) {
                    alt35=2;
                }
                else if ( LA35_0 == 16 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2) ) {
                    alt35=3;
                }
                else if ( LA35_0 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3) ) {
                    alt35=4;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalSequencerTestLanguage.g:3027:4: ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3027:4: ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3028:5: {...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // InternalSequencerTestLanguage.g:3028:111: ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) )
            	    // InternalSequencerTestLanguage.g:3029:6: ({...}? => ( (lv_val1_2_0= RULE_ID ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // InternalSequencerTestLanguage.g:3032:6: ({...}? => ( (lv_val1_2_0= RULE_ID ) ) )
            	    // InternalSequencerTestLanguage.g:3032:7: {...}? => ( (lv_val1_2_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // InternalSequencerTestLanguage.g:3032:16: ( (lv_val1_2_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:3033:1: (lv_val1_2_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:3033:1: (lv_val1_2_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:3034:3: lv_val1_2_0= RULE_ID
            	    {
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_24); 

            	    			newLeafNode(lv_val1_2_0, grammarAccess.getUnorderedGroupAccess().getVal1IDTerminalRuleCall_1_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getUnorderedGroupRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"val1",
            	            		lv_val1_2_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSequencerTestLanguage.g:3057:4: ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3057:4: ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3058:5: {...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // InternalSequencerTestLanguage.g:3058:111: ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) )
            	    // InternalSequencerTestLanguage.g:3059:6: ({...}? => ( (lv_val2_3_0= RULE_INT ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // InternalSequencerTestLanguage.g:3062:6: ({...}? => ( (lv_val2_3_0= RULE_INT ) ) )
            	    // InternalSequencerTestLanguage.g:3062:7: {...}? => ( (lv_val2_3_0= RULE_INT ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // InternalSequencerTestLanguage.g:3062:16: ( (lv_val2_3_0= RULE_INT ) )
            	    // InternalSequencerTestLanguage.g:3063:1: (lv_val2_3_0= RULE_INT )
            	    {
            	    // InternalSequencerTestLanguage.g:3063:1: (lv_val2_3_0= RULE_INT )
            	    // InternalSequencerTestLanguage.g:3064:3: lv_val2_3_0= RULE_INT
            	    {
            	    lv_val2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_24); 

            	    			newLeafNode(lv_val2_3_0, grammarAccess.getUnorderedGroupAccess().getVal2INTTerminalRuleCall_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getUnorderedGroupRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"val2",
            	            		lv_val2_3_0, 
            	            		"org.eclipse.xtext.common.Terminals.INT");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSequencerTestLanguage.g:3087:4: ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3087:4: ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3088:5: {...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // InternalSequencerTestLanguage.g:3088:111: ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) )
            	    // InternalSequencerTestLanguage.g:3089:6: ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2);
            	    	 				
            	    // InternalSequencerTestLanguage.g:3092:6: ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) )
            	    // InternalSequencerTestLanguage.g:3092:7: {...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // InternalSequencerTestLanguage.g:3092:16: ( (lv_val3_4_0= ruleUnorderedGroupVal ) )
            	    // InternalSequencerTestLanguage.g:3093:1: (lv_val3_4_0= ruleUnorderedGroupVal )
            	    {
            	    // InternalSequencerTestLanguage.g:3093:1: (lv_val3_4_0= ruleUnorderedGroupVal )
            	    // InternalSequencerTestLanguage.g:3094:3: lv_val3_4_0= ruleUnorderedGroupVal
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUnorderedGroupAccess().getVal3UnorderedGroupValParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_24);
            	    lv_val3_4_0=ruleUnorderedGroupVal();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getUnorderedGroupRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"val3",
            	            		lv_val3_4_0, 
            	            		"org.eclipse.xtext.serializer.SequencerTestLanguage.UnorderedGroupVal");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalSequencerTestLanguage.g:3117:4: ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3117:4: ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3118:5: {...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3)");
            	    }
            	    // InternalSequencerTestLanguage.g:3118:111: ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) )
            	    // InternalSequencerTestLanguage.g:3119:6: ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3);
            	    	 				
            	    // InternalSequencerTestLanguage.g:3122:6: ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) )
            	    // InternalSequencerTestLanguage.g:3122:7: {...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // InternalSequencerTestLanguage.g:3122:16: ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) )
            	    // InternalSequencerTestLanguage.g:3123:1: (lv_val4_5_0= ruleUnorderedGroupValDelegate )
            	    {
            	    // InternalSequencerTestLanguage.g:3123:1: (lv_val4_5_0= ruleUnorderedGroupValDelegate )
            	    // InternalSequencerTestLanguage.g:3124:3: lv_val4_5_0= ruleUnorderedGroupValDelegate
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUnorderedGroupAccess().getVal4UnorderedGroupValDelegateParserRuleCall_1_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_24);
            	    lv_val4_5_0=ruleUnorderedGroupValDelegate();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getUnorderedGroupRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"val4",
            	            		lv_val4_5_0, 
            	            		"org.eclipse.xtext.serializer.SequencerTestLanguage.UnorderedGroupValDelegate");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1()) ) {
                throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canLeave(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleUnorderedGroupVal"
    // InternalSequencerTestLanguage.g:3163:1: entryRuleUnorderedGroupVal returns [EObject current=null] : iv_ruleUnorderedGroupVal= ruleUnorderedGroupVal EOF ;
    public final EObject entryRuleUnorderedGroupVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedGroupVal = null;


        try {
            // InternalSequencerTestLanguage.g:3164:2: (iv_ruleUnorderedGroupVal= ruleUnorderedGroupVal EOF )
            // InternalSequencerTestLanguage.g:3165:2: iv_ruleUnorderedGroupVal= ruleUnorderedGroupVal EOF
            {
             newCompositeNode(grammarAccess.getUnorderedGroupValRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroupVal=ruleUnorderedGroupVal();

            state._fsp--;

             current =iv_ruleUnorderedGroupVal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedGroupVal"


    // $ANTLR start "ruleUnorderedGroupVal"
    // InternalSequencerTestLanguage.g:3172:1: ruleUnorderedGroupVal returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleUnorderedGroupVal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3175:28: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // InternalSequencerTestLanguage.g:3176:1: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // InternalSequencerTestLanguage.g:3176:1: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:3176:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getUnorderedGroupValAccess().getKw1Keyword_0());
                
            // InternalSequencerTestLanguage.g:3180:1: ( (lv_val_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:3181:1: (lv_val_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:3181:1: (lv_val_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:3182:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_val_1_0, grammarAccess.getUnorderedGroupValAccess().getValIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnorderedGroupValRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedGroupVal"


    // $ANTLR start "entryRuleUnorderedGroupValDelegate"
    // InternalSequencerTestLanguage.g:3206:1: entryRuleUnorderedGroupValDelegate returns [EObject current=null] : iv_ruleUnorderedGroupValDelegate= ruleUnorderedGroupValDelegate EOF ;
    public final EObject entryRuleUnorderedGroupValDelegate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedGroupValDelegate = null;


        try {
            // InternalSequencerTestLanguage.g:3207:2: (iv_ruleUnorderedGroupValDelegate= ruleUnorderedGroupValDelegate EOF )
            // InternalSequencerTestLanguage.g:3208:2: iv_ruleUnorderedGroupValDelegate= ruleUnorderedGroupValDelegate EOF
            {
             newCompositeNode(grammarAccess.getUnorderedGroupValDelegateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroupValDelegate=ruleUnorderedGroupValDelegate();

            state._fsp--;

             current =iv_ruleUnorderedGroupValDelegate; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedGroupValDelegate"


    // $ANTLR start "ruleUnorderedGroupValDelegate"
    // InternalSequencerTestLanguage.g:3215:1: ruleUnorderedGroupValDelegate returns [EObject current=null] : this_UnorderedGroupVal2_0= ruleUnorderedGroupVal2 ;
    public final EObject ruleUnorderedGroupValDelegate() throws RecognitionException {
        EObject current = null;

        EObject this_UnorderedGroupVal2_0 = null;


         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3218:28: (this_UnorderedGroupVal2_0= ruleUnorderedGroupVal2 )
            // InternalSequencerTestLanguage.g:3220:5: this_UnorderedGroupVal2_0= ruleUnorderedGroupVal2
            {
             
                    newCompositeNode(grammarAccess.getUnorderedGroupValDelegateAccess().getUnorderedGroupVal2ParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
            this_UnorderedGroupVal2_0=ruleUnorderedGroupVal2();

            state._fsp--;

             
                    current = this_UnorderedGroupVal2_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedGroupValDelegate"


    // $ANTLR start "entryRuleUnorderedGroupVal2"
    // InternalSequencerTestLanguage.g:3236:1: entryRuleUnorderedGroupVal2 returns [EObject current=null] : iv_ruleUnorderedGroupVal2= ruleUnorderedGroupVal2 EOF ;
    public final EObject entryRuleUnorderedGroupVal2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedGroupVal2 = null;


        try {
            // InternalSequencerTestLanguage.g:3237:2: (iv_ruleUnorderedGroupVal2= ruleUnorderedGroupVal2 EOF )
            // InternalSequencerTestLanguage.g:3238:2: iv_ruleUnorderedGroupVal2= ruleUnorderedGroupVal2 EOF
            {
             newCompositeNode(grammarAccess.getUnorderedGroupVal2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroupVal2=ruleUnorderedGroupVal2();

            state._fsp--;

             current =iv_ruleUnorderedGroupVal2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedGroupVal2"


    // $ANTLR start "ruleUnorderedGroupVal2"
    // InternalSequencerTestLanguage.g:3245:1: ruleUnorderedGroupVal2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleUnorderedGroupVal2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3248:28: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // InternalSequencerTestLanguage.g:3249:1: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // InternalSequencerTestLanguage.g:3249:1: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:3249:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getUnorderedGroupVal2Access().getKw2Keyword_0());
                
            // InternalSequencerTestLanguage.g:3253:1: ( (lv_val_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:3254:1: (lv_val_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:3254:1: (lv_val_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:3255:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_val_1_0, grammarAccess.getUnorderedGroupVal2Access().getValIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnorderedGroupVal2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedGroupVal2"


    // $ANTLR start "entryRuleUnorderedGroupOptional"
    // InternalSequencerTestLanguage.g:3279:1: entryRuleUnorderedGroupOptional returns [EObject current=null] : iv_ruleUnorderedGroupOptional= ruleUnorderedGroupOptional EOF ;
    public final EObject entryRuleUnorderedGroupOptional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedGroupOptional = null;


        try {
            // InternalSequencerTestLanguage.g:3280:2: (iv_ruleUnorderedGroupOptional= ruleUnorderedGroupOptional EOF )
            // InternalSequencerTestLanguage.g:3281:2: iv_ruleUnorderedGroupOptional= ruleUnorderedGroupOptional EOF
            {
             newCompositeNode(grammarAccess.getUnorderedGroupOptionalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroupOptional=ruleUnorderedGroupOptional();

            state._fsp--;

             current =iv_ruleUnorderedGroupOptional; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedGroupOptional"


    // $ANTLR start "ruleUnorderedGroupOptional"
    // InternalSequencerTestLanguage.g:3288:1: ruleUnorderedGroupOptional returns [EObject current=null] : (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleUnorderedGroupOptional() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;
        Token otherlv_5=null;
        Token lv_va2_6_0=null;
        Token otherlv_7=null;
        Token lv_val3_8_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3291:28: ( (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) ) )
            // InternalSequencerTestLanguage.g:3292:1: (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) )
            {
            // InternalSequencerTestLanguage.g:3292:1: (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) )
            // InternalSequencerTestLanguage.g:3292:3: otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) )
            {
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_26); 

                	newLeafNode(otherlv_0, grammarAccess.getUnorderedGroupOptionalAccess().getNumberSignDigitTwoDigitFiveKeyword_0());
                
            // InternalSequencerTestLanguage.g:3296:1: ()
            // InternalSequencerTestLanguage.g:3297:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroupOptionalAction_1(),
                        current);
                

            }

            // InternalSequencerTestLanguage.g:3302:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) )
            // InternalSequencerTestLanguage.g:3304:1: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) )
            {
            // InternalSequencerTestLanguage.g:3304:1: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) )
            // InternalSequencerTestLanguage.g:3305:2: ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2());
            	
            // InternalSequencerTestLanguage.g:3308:2: ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* )
            // InternalSequencerTestLanguage.g:3309:3: ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )*
            {
            // InternalSequencerTestLanguage.g:3309:3: ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )*
            loop36:
            do {
                int alt36=4;
                int LA36_0 = input.LA(1);

                if ( LA36_0 == 16 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0) ) {
                    alt36=1;
                }
                else if ( LA36_0 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1) ) {
                    alt36=2;
                }
                else if ( LA36_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2) ) {
                    alt36=3;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalSequencerTestLanguage.g:3311:4: ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3311:4: ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3312:5: {...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalSequencerTestLanguage.g:3312:119: ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3313:6: ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0);
            	    	 				
            	    // InternalSequencerTestLanguage.g:3316:6: ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) )
            	    // InternalSequencerTestLanguage.g:3316:7: {...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "true");
            	    }
            	    // InternalSequencerTestLanguage.g:3316:16: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) )
            	    // InternalSequencerTestLanguage.g:3316:18: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_3, grammarAccess.getUnorderedGroupOptionalAccess().getKw1Keyword_2_0_0());
            	        
            	    // InternalSequencerTestLanguage.g:3320:1: ( (lv_val1_4_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:3321:1: (lv_val1_4_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:3321:1: (lv_val1_4_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:3322:3: lv_val1_4_0= RULE_ID
            	    {
            	    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            	    			newLeafNode(lv_val1_4_0, grammarAccess.getUnorderedGroupOptionalAccess().getVal1IDTerminalRuleCall_2_0_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getUnorderedGroupOptionalRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"val1",
            	            		lv_val1_4_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSequencerTestLanguage.g:3345:4: ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3345:4: ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3346:5: {...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalSequencerTestLanguage.g:3346:119: ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3347:6: ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1);
            	    	 				
            	    // InternalSequencerTestLanguage.g:3350:6: ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) )
            	    // InternalSequencerTestLanguage.g:3350:7: {...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "true");
            	    }
            	    // InternalSequencerTestLanguage.g:3350:16: (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) )
            	    // InternalSequencerTestLanguage.g:3350:18: otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_5, grammarAccess.getUnorderedGroupOptionalAccess().getKw2Keyword_2_1_0());
            	        
            	    // InternalSequencerTestLanguage.g:3354:1: ( (lv_va2_6_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:3355:1: (lv_va2_6_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:3355:1: (lv_va2_6_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:3356:3: lv_va2_6_0= RULE_ID
            	    {
            	    lv_va2_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            	    			newLeafNode(lv_va2_6_0, grammarAccess.getUnorderedGroupOptionalAccess().getVa2IDTerminalRuleCall_2_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getUnorderedGroupOptionalRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"va2",
            	            		lv_va2_6_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSequencerTestLanguage.g:3379:4: ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3379:4: ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3380:5: {...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // InternalSequencerTestLanguage.g:3380:119: ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3381:6: ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2);
            	    	 				
            	    // InternalSequencerTestLanguage.g:3384:6: ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) )
            	    // InternalSequencerTestLanguage.g:3384:7: {...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "true");
            	    }
            	    // InternalSequencerTestLanguage.g:3384:16: (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) )
            	    // InternalSequencerTestLanguage.g:3384:18: otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) )
            	    {
            	    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_7, grammarAccess.getUnorderedGroupOptionalAccess().getKw3Keyword_2_2_0());
            	        
            	    // InternalSequencerTestLanguage.g:3388:1: ( (lv_val3_8_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:3389:1: (lv_val3_8_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:3389:1: (lv_val3_8_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:3390:3: lv_val3_8_0= RULE_ID
            	    {
            	    lv_val3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            	    			newLeafNode(lv_val3_8_0, grammarAccess.getUnorderedGroupOptionalAccess().getVal3IDTerminalRuleCall_2_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getUnorderedGroupOptionalRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"val3",
            	            		lv_val3_8_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2());
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedGroupOptional"


    // $ANTLR start "entryRuleUnorderedGroupBoolean"
    // InternalSequencerTestLanguage.g:3428:1: entryRuleUnorderedGroupBoolean returns [EObject current=null] : iv_ruleUnorderedGroupBoolean= ruleUnorderedGroupBoolean EOF ;
    public final EObject entryRuleUnorderedGroupBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedGroupBoolean = null;


        try {
            // InternalSequencerTestLanguage.g:3429:2: (iv_ruleUnorderedGroupBoolean= ruleUnorderedGroupBoolean EOF )
            // InternalSequencerTestLanguage.g:3430:2: iv_ruleUnorderedGroupBoolean= ruleUnorderedGroupBoolean EOF
            {
             newCompositeNode(grammarAccess.getUnorderedGroupBooleanRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroupBoolean=ruleUnorderedGroupBoolean();

            state._fsp--;

             current =iv_ruleUnorderedGroupBoolean; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedGroupBoolean"


    // $ANTLR start "ruleUnorderedGroupBoolean"
    // InternalSequencerTestLanguage.g:3437:1: ruleUnorderedGroupBoolean returns [EObject current=null] : (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleUnorderedGroupBoolean() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_3_0=null;
        Token lv_val2_4_0=null;
        Token lv_val3_5_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3440:28: ( (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) ) )
            // InternalSequencerTestLanguage.g:3441:1: (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) )
            {
            // InternalSequencerTestLanguage.g:3441:1: (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) )
            // InternalSequencerTestLanguage.g:3441:3: otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) )
            {
            otherlv_0=(Token)match(input,47,FollowSets000.FOLLOW_26); 

                	newLeafNode(otherlv_0, grammarAccess.getUnorderedGroupBooleanAccess().getNumberSignDigitTwoDigitSixKeyword_0());
                
            // InternalSequencerTestLanguage.g:3445:1: ()
            // InternalSequencerTestLanguage.g:3446:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroupBooleanAction_1(),
                        current);
                

            }

            // InternalSequencerTestLanguage.g:3451:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) )
            // InternalSequencerTestLanguage.g:3453:1: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) )
            {
            // InternalSequencerTestLanguage.g:3453:1: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) )
            // InternalSequencerTestLanguage.g:3454:2: ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
            	
            // InternalSequencerTestLanguage.g:3457:2: ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* )
            // InternalSequencerTestLanguage.g:3458:3: ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )*
            {
            // InternalSequencerTestLanguage.g:3458:3: ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )*
            loop37:
            do {
                int alt37=4;
                int LA37_0 = input.LA(1);

                if ( LA37_0 == 16 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0) ) {
                    alt37=1;
                }
                else if ( LA37_0 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1) ) {
                    alt37=2;
                }
                else if ( LA37_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2) ) {
                    alt37=3;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalSequencerTestLanguage.g:3460:4: ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3460:4: ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3461:5: {...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalSequencerTestLanguage.g:3461:118: ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) )
            	    // InternalSequencerTestLanguage.g:3462:6: ({...}? => ( (lv_val1_3_0= 'kw1' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0);
            	    	 				
            	    // InternalSequencerTestLanguage.g:3465:6: ({...}? => ( (lv_val1_3_0= 'kw1' ) ) )
            	    // InternalSequencerTestLanguage.g:3465:7: {...}? => ( (lv_val1_3_0= 'kw1' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "true");
            	    }
            	    // InternalSequencerTestLanguage.g:3465:16: ( (lv_val1_3_0= 'kw1' ) )
            	    // InternalSequencerTestLanguage.g:3466:1: (lv_val1_3_0= 'kw1' )
            	    {
            	    // InternalSequencerTestLanguage.g:3466:1: (lv_val1_3_0= 'kw1' )
            	    // InternalSequencerTestLanguage.g:3467:3: lv_val1_3_0= 'kw1'
            	    {
            	    lv_val1_3_0=(Token)match(input,16,FollowSets000.FOLLOW_26); 

            	            newLeafNode(lv_val1_3_0, grammarAccess.getUnorderedGroupBooleanAccess().getVal1Kw1Keyword_2_0_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getUnorderedGroupBooleanRule());
            	    	        }
            	           		setWithLastConsumed(current, "val1", true, "kw1");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSequencerTestLanguage.g:3487:4: ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3487:4: ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3488:5: {...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalSequencerTestLanguage.g:3488:118: ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) )
            	    // InternalSequencerTestLanguage.g:3489:6: ({...}? => ( (lv_val2_4_0= 'kw2' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1);
            	    	 				
            	    // InternalSequencerTestLanguage.g:3492:6: ({...}? => ( (lv_val2_4_0= 'kw2' ) ) )
            	    // InternalSequencerTestLanguage.g:3492:7: {...}? => ( (lv_val2_4_0= 'kw2' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "true");
            	    }
            	    // InternalSequencerTestLanguage.g:3492:16: ( (lv_val2_4_0= 'kw2' ) )
            	    // InternalSequencerTestLanguage.g:3493:1: (lv_val2_4_0= 'kw2' )
            	    {
            	    // InternalSequencerTestLanguage.g:3493:1: (lv_val2_4_0= 'kw2' )
            	    // InternalSequencerTestLanguage.g:3494:3: lv_val2_4_0= 'kw2'
            	    {
            	    lv_val2_4_0=(Token)match(input,17,FollowSets000.FOLLOW_26); 

            	            newLeafNode(lv_val2_4_0, grammarAccess.getUnorderedGroupBooleanAccess().getVal2Kw2Keyword_2_1_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getUnorderedGroupBooleanRule());
            	    	        }
            	           		setWithLastConsumed(current, "val2", true, "kw2");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSequencerTestLanguage.g:3514:4: ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3514:4: ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) )
            	    // InternalSequencerTestLanguage.g:3515:5: {...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // InternalSequencerTestLanguage.g:3515:118: ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) )
            	    // InternalSequencerTestLanguage.g:3516:6: ({...}? => ( (lv_val3_5_0= 'kw3' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2);
            	    	 				
            	    // InternalSequencerTestLanguage.g:3519:6: ({...}? => ( (lv_val3_5_0= 'kw3' ) ) )
            	    // InternalSequencerTestLanguage.g:3519:7: {...}? => ( (lv_val3_5_0= 'kw3' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "true");
            	    }
            	    // InternalSequencerTestLanguage.g:3519:16: ( (lv_val3_5_0= 'kw3' ) )
            	    // InternalSequencerTestLanguage.g:3520:1: (lv_val3_5_0= 'kw3' )
            	    {
            	    // InternalSequencerTestLanguage.g:3520:1: (lv_val3_5_0= 'kw3' )
            	    // InternalSequencerTestLanguage.g:3521:3: lv_val3_5_0= 'kw3'
            	    {
            	    lv_val3_5_0=(Token)match(input,19,FollowSets000.FOLLOW_26); 

            	            newLeafNode(lv_val3_5_0, grammarAccess.getUnorderedGroupBooleanAccess().getVal3Kw3Keyword_2_2_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getUnorderedGroupBooleanRule());
            	    	        }
            	           		setWithLastConsumed(current, "val3", true, "kw3");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedGroupBoolean"


    // $ANTLR start "entryRuleComplex1"
    // InternalSequencerTestLanguage.g:3556:1: entryRuleComplex1 returns [EObject current=null] : iv_ruleComplex1= ruleComplex1 EOF ;
    public final EObject entryRuleComplex1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplex1 = null;


        try {
            // InternalSequencerTestLanguage.g:3557:2: (iv_ruleComplex1= ruleComplex1 EOF )
            // InternalSequencerTestLanguage.g:3558:2: iv_ruleComplex1= ruleComplex1 EOF
            {
             newCompositeNode(grammarAccess.getComplex1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleComplex1=ruleComplex1();

            state._fsp--;

             current =iv_ruleComplex1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleComplex1"


    // $ANTLR start "ruleComplex1"
    // InternalSequencerTestLanguage.g:3565:1: ruleComplex1 returns [EObject current=null] : (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* ) ;
    public final EObject ruleComplex1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
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

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3568:28: ( (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* ) )
            // InternalSequencerTestLanguage.g:3569:1: (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* )
            {
            // InternalSequencerTestLanguage.g:3569:1: (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* )
            // InternalSequencerTestLanguage.g:3569:3: otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )*
            {
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_27); 

                	newLeafNode(otherlv_0, grammarAccess.getComplex1Access().getNumberSignDigitTwoDigitSevenKeyword_0());
                
            // InternalSequencerTestLanguage.g:3573:1: ()
            // InternalSequencerTestLanguage.g:3574:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getComplex1Access().getComplex1Action_1(),
                        current);
                

            }

            // InternalSequencerTestLanguage.g:3579:2: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==16) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalSequencerTestLanguage.g:3579:4: otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getComplex1Access().getKw1Keyword_2_0());
                        
                    // InternalSequencerTestLanguage.g:3583:1: ( (lv_val1_3_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:3584:1: (lv_val1_3_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:3584:1: (lv_val1_3_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:3585:3: lv_val1_3_0= RULE_ID
                    {
                    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_28); 

                    			newLeafNode(lv_val1_3_0, grammarAccess.getComplex1Access().getVal1IDTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getComplex1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_3_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalSequencerTestLanguage.g:3601:4: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==17) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalSequencerTestLanguage.g:3601:6: otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_4, grammarAccess.getComplex1Access().getKw2Keyword_3_0());
                        
                    // InternalSequencerTestLanguage.g:3605:1: ( (lv_val2_5_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:3606:1: (lv_val2_5_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:3606:1: (lv_val2_5_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:3607:3: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

                    			newLeafNode(lv_val2_5_0, grammarAccess.getComplex1Access().getVal2IDTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getComplex1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_5_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalSequencerTestLanguage.g:3623:4: ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )*
            loop40:
            do {
                int alt40=5;
                switch ( input.LA(1) ) {
                case 19:
                    {
                    alt40=1;
                    }
                    break;
                case 22:
                    {
                    alt40=2;
                    }
                    break;
                case 23:
                    {
                    alt40=3;
                    }
                    break;
                case 49:
                    {
                    alt40=4;
                    }
                    break;

                }

                switch (alt40) {
            	case 1 :
            	    // InternalSequencerTestLanguage.g:3623:5: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3623:5: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) )
            	    // InternalSequencerTestLanguage.g:3623:7: otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )
            	    {
            	    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_6, grammarAccess.getComplex1Access().getKw3Keyword_4_0_0());
            	        
            	    // InternalSequencerTestLanguage.g:3627:1: ( (lv_val3_7_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:3628:1: (lv_val3_7_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:3628:1: (lv_val3_7_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:3629:3: lv_val3_7_0= RULE_ID
            	    {
            	    lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            	    			newLeafNode(lv_val3_7_0, grammarAccess.getComplex1Access().getVal3IDTerminalRuleCall_4_0_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getComplex1Rule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val3",
            	            		lv_val3_7_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSequencerTestLanguage.g:3646:6: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3646:6: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) )
            	    // InternalSequencerTestLanguage.g:3646:8: otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )
            	    {
            	    otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_8, grammarAccess.getComplex1Access().getKw4Keyword_4_1_0());
            	        
            	    // InternalSequencerTestLanguage.g:3650:1: ( (lv_val4_9_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:3651:1: (lv_val4_9_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:3651:1: (lv_val4_9_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:3652:3: lv_val4_9_0= RULE_ID
            	    {
            	    lv_val4_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            	    			newLeafNode(lv_val4_9_0, grammarAccess.getComplex1Access().getVal4IDTerminalRuleCall_4_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getComplex1Rule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val4",
            	            		lv_val4_9_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSequencerTestLanguage.g:3669:6: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3669:6: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) )
            	    // InternalSequencerTestLanguage.g:3669:8: otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )
            	    {
            	    otherlv_10=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_10, grammarAccess.getComplex1Access().getKw5Keyword_4_2_0());
            	        
            	    // InternalSequencerTestLanguage.g:3673:1: ( (lv_val5_11_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:3674:1: (lv_val5_11_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:3674:1: (lv_val5_11_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:3675:3: lv_val5_11_0= RULE_ID
            	    {
            	    lv_val5_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            	    			newLeafNode(lv_val5_11_0, grammarAccess.getComplex1Access().getVal5IDTerminalRuleCall_4_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getComplex1Rule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val5",
            	            		lv_val5_11_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalSequencerTestLanguage.g:3692:6: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) )
            	    {
            	    // InternalSequencerTestLanguage.g:3692:6: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) )
            	    // InternalSequencerTestLanguage.g:3692:8: otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )
            	    {
            	    otherlv_12=(Token)match(input,49,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_12, grammarAccess.getComplex1Access().getKw6Keyword_4_3_0());
            	        
            	    // InternalSequencerTestLanguage.g:3696:1: ( (lv_val6_13_0= RULE_ID ) )
            	    // InternalSequencerTestLanguage.g:3697:1: (lv_val6_13_0= RULE_ID )
            	    {
            	    // InternalSequencerTestLanguage.g:3697:1: (lv_val6_13_0= RULE_ID )
            	    // InternalSequencerTestLanguage.g:3698:3: lv_val6_13_0= RULE_ID
            	    {
            	    lv_val6_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            	    			newLeafNode(lv_val6_13_0, grammarAccess.getComplex1Access().getVal6IDTerminalRuleCall_4_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getComplex1Rule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val6",
            	            		lv_val6_13_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComplex1"


    // $ANTLR start "entryRuleOptionalDouble"
    // InternalSequencerTestLanguage.g:3722:1: entryRuleOptionalDouble returns [EObject current=null] : iv_ruleOptionalDouble= ruleOptionalDouble EOF ;
    public final EObject entryRuleOptionalDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalDouble = null;


        try {
            // InternalSequencerTestLanguage.g:3723:2: (iv_ruleOptionalDouble= ruleOptionalDouble EOF )
            // InternalSequencerTestLanguage.g:3724:2: iv_ruleOptionalDouble= ruleOptionalDouble EOF
            {
             newCompositeNode(grammarAccess.getOptionalDoubleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptionalDouble=ruleOptionalDouble();

            state._fsp--;

             current =iv_ruleOptionalDouble; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleOptionalDouble"


    // $ANTLR start "ruleOptionalDouble"
    // InternalSequencerTestLanguage.g:3731:1: ruleOptionalDouble returns [EObject current=null] : (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? ) ;
    public final EObject ruleOptionalDouble() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_double0_1_0 = null;

        AntlrDatatypeRuleToken lv_double1_2_0 = null;

        AntlrDatatypeRuleToken lv_double2_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3734:28: ( (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? ) )
            // InternalSequencerTestLanguage.g:3735:1: (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? )
            {
            // InternalSequencerTestLanguage.g:3735:1: (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? )
            // InternalSequencerTestLanguage.g:3735:3: otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )?
            {
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_21); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionalDoubleAccess().getNumberSignDigitTwoDigitEightKeyword_0());
                
            // InternalSequencerTestLanguage.g:3739:1: ( (lv_double0_1_0= ruleDOUBLE ) )
            // InternalSequencerTestLanguage.g:3740:1: (lv_double0_1_0= ruleDOUBLE )
            {
            // InternalSequencerTestLanguage.g:3740:1: (lv_double0_1_0= ruleDOUBLE )
            // InternalSequencerTestLanguage.g:3741:3: lv_double0_1_0= ruleDOUBLE
            {
             
            	        newCompositeNode(grammarAccess.getOptionalDoubleAccess().getDouble0DOUBLEParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_22);
            lv_double0_1_0=ruleDOUBLE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOptionalDoubleRule());
            	        }
                   		set(
                   			current, 
                   			"double0",
                    		lv_double0_1_0, 
                    		"org.eclipse.xtext.serializer.SequencerTestLanguage.DOUBLE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalSequencerTestLanguage.g:3757:2: ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_INT) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalSequencerTestLanguage.g:3757:3: ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) )
                    {
                    // InternalSequencerTestLanguage.g:3757:3: ( (lv_double1_2_0= ruleDOUBLE ) )
                    // InternalSequencerTestLanguage.g:3758:1: (lv_double1_2_0= ruleDOUBLE )
                    {
                    // InternalSequencerTestLanguage.g:3758:1: (lv_double1_2_0= ruleDOUBLE )
                    // InternalSequencerTestLanguage.g:3759:3: lv_double1_2_0= ruleDOUBLE
                    {
                     
                    	        newCompositeNode(grammarAccess.getOptionalDoubleAccess().getDouble1DOUBLEParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_21);
                    lv_double1_2_0=ruleDOUBLE();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOptionalDoubleRule());
                    	        }
                           		set(
                           			current, 
                           			"double1",
                            		lv_double1_2_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.DOUBLE");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalSequencerTestLanguage.g:3775:2: ( (lv_double2_3_0= ruleDOUBLE ) )
                    // InternalSequencerTestLanguage.g:3776:1: (lv_double2_3_0= ruleDOUBLE )
                    {
                    // InternalSequencerTestLanguage.g:3776:1: (lv_double2_3_0= ruleDOUBLE )
                    // InternalSequencerTestLanguage.g:3777:3: lv_double2_3_0= ruleDOUBLE
                    {
                     
                    	        newCompositeNode(grammarAccess.getOptionalDoubleAccess().getDouble2DOUBLEParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_double2_3_0=ruleDOUBLE();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOptionalDoubleRule());
                    	        }
                           		set(
                           			current, 
                           			"double2",
                            		lv_double2_3_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.DOUBLE");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptionalDouble"


    // $ANTLR start "entryRuleDOUBLE"
    // InternalSequencerTestLanguage.g:3801:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // InternalSequencerTestLanguage.g:3802:2: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // InternalSequencerTestLanguage.g:3803:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
             newCompositeNode(grammarAccess.getDOUBLERule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDOUBLE=ruleDOUBLE();

            state._fsp--;

             current =iv_ruleDOUBLE.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // InternalSequencerTestLanguage.g:3810:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3813:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // InternalSequencerTestLanguage.g:3814:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // InternalSequencerTestLanguage.g:3814:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // InternalSequencerTestLanguage.g:3814:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_30); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 
                
            // InternalSequencerTestLanguage.g:3821:1: (kw= '.' this_INT_2= RULE_INT )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==51) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalSequencerTestLanguage.g:3822:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_21); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDOUBLEAccess().getFullStopKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_1_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "entryRuleNullValueGenerated"
    // InternalSequencerTestLanguage.g:3842:1: entryRuleNullValueGenerated returns [EObject current=null] : iv_ruleNullValueGenerated= ruleNullValueGenerated EOF ;
    public final EObject entryRuleNullValueGenerated() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullValueGenerated = null;


        try {
            // InternalSequencerTestLanguage.g:3843:2: (iv_ruleNullValueGenerated= ruleNullValueGenerated EOF )
            // InternalSequencerTestLanguage.g:3844:2: iv_ruleNullValueGenerated= ruleNullValueGenerated EOF
            {
             newCompositeNode(grammarAccess.getNullValueGeneratedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullValueGenerated=ruleNullValueGenerated();

            state._fsp--;

             current =iv_ruleNullValueGenerated; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNullValueGenerated"


    // $ANTLR start "ruleNullValueGenerated"
    // InternalSequencerTestLanguage.g:3851:1: ruleNullValueGenerated returns [EObject current=null] : (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) ) ;
    public final EObject ruleNullValueGenerated() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3854:28: ( (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) ) )
            // InternalSequencerTestLanguage.g:3855:1: (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) )
            {
            // InternalSequencerTestLanguage.g:3855:1: (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) )
            // InternalSequencerTestLanguage.g:3855:3: otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) )
            {
            otherlv_0=(Token)match(input,52,FollowSets000.FOLLOW_31); 

                	newLeafNode(otherlv_0, grammarAccess.getNullValueGeneratedAccess().getNumberSignDigitTwoDigitNineKeyword_0());
                
            // InternalSequencerTestLanguage.g:3859:1: ( (lv_value_1_0= ruleNULL_STRING ) )
            // InternalSequencerTestLanguage.g:3860:1: (lv_value_1_0= ruleNULL_STRING )
            {
            // InternalSequencerTestLanguage.g:3860:1: (lv_value_1_0= ruleNULL_STRING )
            // InternalSequencerTestLanguage.g:3861:3: lv_value_1_0= ruleNULL_STRING
            {
             
            	        newCompositeNode(grammarAccess.getNullValueGeneratedAccess().getValueNULL_STRINGParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_1_0=ruleNULL_STRING();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNullValueGeneratedRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"org.eclipse.xtext.serializer.SequencerTestLanguage.NULL_STRING");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullValueGenerated"


    // $ANTLR start "entryRuleNullValueInterpreted"
    // InternalSequencerTestLanguage.g:3885:1: entryRuleNullValueInterpreted returns [EObject current=null] : iv_ruleNullValueInterpreted= ruleNullValueInterpreted EOF ;
    public final EObject entryRuleNullValueInterpreted() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullValueInterpreted = null;


        try {
            // InternalSequencerTestLanguage.g:3886:2: (iv_ruleNullValueInterpreted= ruleNullValueInterpreted EOF )
            // InternalSequencerTestLanguage.g:3887:2: iv_ruleNullValueInterpreted= ruleNullValueInterpreted EOF
            {
             newCompositeNode(grammarAccess.getNullValueInterpretedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullValueInterpreted=ruleNullValueInterpreted();

            state._fsp--;

             current =iv_ruleNullValueInterpreted; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNullValueInterpreted"


    // $ANTLR start "ruleNullValueInterpreted"
    // InternalSequencerTestLanguage.g:3894:1: ruleNullValueInterpreted returns [EObject current=null] : (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? ) ;
    public final EObject ruleNullValueInterpreted() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_foo_2_0=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3897:28: ( (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? ) )
            // InternalSequencerTestLanguage.g:3898:1: (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            {
            // InternalSequencerTestLanguage.g:3898:1: (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            // InternalSequencerTestLanguage.g:3898:3: otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,53,FollowSets000.FOLLOW_31); 

                	newLeafNode(otherlv_0, grammarAccess.getNullValueInterpretedAccess().getNumberSignDigitThreeDigitZeroKeyword_0());
                
            // InternalSequencerTestLanguage.g:3902:1: ( (lv_value_1_0= ruleNULL_STRING ) )
            // InternalSequencerTestLanguage.g:3903:1: (lv_value_1_0= ruleNULL_STRING )
            {
            // InternalSequencerTestLanguage.g:3903:1: (lv_value_1_0= ruleNULL_STRING )
            // InternalSequencerTestLanguage.g:3904:3: lv_value_1_0= ruleNULL_STRING
            {
             
            	        newCompositeNode(grammarAccess.getNullValueInterpretedAccess().getValueNULL_STRINGParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_9);
            lv_value_1_0=ruleNULL_STRING();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNullValueInterpretedRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"org.eclipse.xtext.serializer.SequencerTestLanguage.NULL_STRING");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalSequencerTestLanguage.g:3920:2: ( (lv_foo_2_0= RULE_ID ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalSequencerTestLanguage.g:3921:1: (lv_foo_2_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:3921:1: (lv_foo_2_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:3922:3: lv_foo_2_0= RULE_ID
                    {
                    lv_foo_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_foo_2_0, grammarAccess.getNullValueInterpretedAccess().getFooIDTerminalRuleCall_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getNullValueInterpretedRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"foo",
                            		lv_foo_2_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullValueInterpreted"


    // $ANTLR start "entryRuleNULL_STRING"
    // InternalSequencerTestLanguage.g:3946:1: entryRuleNULL_STRING returns [String current=null] : iv_ruleNULL_STRING= ruleNULL_STRING EOF ;
    public final String entryRuleNULL_STRING() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNULL_STRING = null;


        try {
            // InternalSequencerTestLanguage.g:3947:2: (iv_ruleNULL_STRING= ruleNULL_STRING EOF )
            // InternalSequencerTestLanguage.g:3948:2: iv_ruleNULL_STRING= ruleNULL_STRING EOF
            {
             newCompositeNode(grammarAccess.getNULL_STRINGRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNULL_STRING=ruleNULL_STRING();

            state._fsp--;

             current =iv_ruleNULL_STRING.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNULL_STRING"


    // $ANTLR start "ruleNULL_STRING"
    // InternalSequencerTestLanguage.g:3955:1: ruleNULL_STRING returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNULL_STRING() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3958:28: (this_STRING_0= RULE_STRING )
            // InternalSequencerTestLanguage.g:3959:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            		current.merge(this_STRING_0);
                
             
                newLeafNode(this_STRING_0, grammarAccess.getNULL_STRINGAccess().getSTRINGTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNULL_STRING"


    // $ANTLR start "entryRuleNullCrossRefGenerated"
    // InternalSequencerTestLanguage.g:3974:1: entryRuleNullCrossRefGenerated returns [EObject current=null] : iv_ruleNullCrossRefGenerated= ruleNullCrossRefGenerated EOF ;
    public final EObject entryRuleNullCrossRefGenerated() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullCrossRefGenerated = null;


        try {
            // InternalSequencerTestLanguage.g:3975:2: (iv_ruleNullCrossRefGenerated= ruleNullCrossRefGenerated EOF )
            // InternalSequencerTestLanguage.g:3976:2: iv_ruleNullCrossRefGenerated= ruleNullCrossRefGenerated EOF
            {
             newCompositeNode(grammarAccess.getNullCrossRefGeneratedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullCrossRefGenerated=ruleNullCrossRefGenerated();

            state._fsp--;

             current =iv_ruleNullCrossRefGenerated; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNullCrossRefGenerated"


    // $ANTLR start "ruleNullCrossRefGenerated"
    // InternalSequencerTestLanguage.g:3983:1: ruleNullCrossRefGenerated returns [EObject current=null] : (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleNullCrossRefGenerated() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:3986:28: ( (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalSequencerTestLanguage.g:3987:1: (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalSequencerTestLanguage.g:3987:1: (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:3987:3: otherlv_0= '#31' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getNullCrossRefGeneratedAccess().getNumberSignDigitThreeDigitOneKeyword_0());
                
            // InternalSequencerTestLanguage.g:3991:1: ( (otherlv_1= RULE_ID ) )
            // InternalSequencerTestLanguage.g:3992:1: (otherlv_1= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:3992:1: (otherlv_1= RULE_ID )
            // InternalSequencerTestLanguage.g:3993:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNullCrossRefGeneratedRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_1, grammarAccess.getNullCrossRefGeneratedAccess().getRefEObjectCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullCrossRefGenerated"


    // $ANTLR start "entryRuleNullCrossRefInterpreted"
    // InternalSequencerTestLanguage.g:4012:1: entryRuleNullCrossRefInterpreted returns [EObject current=null] : iv_ruleNullCrossRefInterpreted= ruleNullCrossRefInterpreted EOF ;
    public final EObject entryRuleNullCrossRefInterpreted() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullCrossRefInterpreted = null;


        try {
            // InternalSequencerTestLanguage.g:4013:2: (iv_ruleNullCrossRefInterpreted= ruleNullCrossRefInterpreted EOF )
            // InternalSequencerTestLanguage.g:4014:2: iv_ruleNullCrossRefInterpreted= ruleNullCrossRefInterpreted EOF
            {
             newCompositeNode(grammarAccess.getNullCrossRefInterpretedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullCrossRefInterpreted=ruleNullCrossRefInterpreted();

            state._fsp--;

             current =iv_ruleNullCrossRefInterpreted; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNullCrossRefInterpreted"


    // $ANTLR start "ruleNullCrossRefInterpreted"
    // InternalSequencerTestLanguage.g:4021:1: ruleNullCrossRefInterpreted returns [EObject current=null] : (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? ) ;
    public final EObject ruleNullCrossRefInterpreted() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_foo_2_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:4024:28: ( (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? ) )
            // InternalSequencerTestLanguage.g:4025:1: (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            {
            // InternalSequencerTestLanguage.g:4025:1: (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            // InternalSequencerTestLanguage.g:4025:3: otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getNullCrossRefInterpretedAccess().getNumberSignDigitThreeDigitTwoKeyword_0());
                
            // InternalSequencerTestLanguage.g:4029:1: ( (otherlv_1= RULE_ID ) )
            // InternalSequencerTestLanguage.g:4030:1: (otherlv_1= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:4030:1: (otherlv_1= RULE_ID )
            // InternalSequencerTestLanguage.g:4031:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNullCrossRefInterpretedRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            		newLeafNode(otherlv_1, grammarAccess.getNullCrossRefInterpretedAccess().getRefEObjectCrossReference_1_0()); 
            	

            }


            }

            // InternalSequencerTestLanguage.g:4042:2: ( (lv_foo_2_0= RULE_ID ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalSequencerTestLanguage.g:4043:1: (lv_foo_2_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:4043:1: (lv_foo_2_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:4044:3: lv_foo_2_0= RULE_ID
                    {
                    lv_foo_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_foo_2_0, grammarAccess.getNullCrossRefInterpretedAccess().getFooIDTerminalRuleCall_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getNullCrossRefInterpretedRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"foo",
                            		lv_foo_2_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullCrossRefInterpreted"


    // $ANTLR start "entryRuleFragmentCaller"
    // InternalSequencerTestLanguage.g:4068:1: entryRuleFragmentCaller returns [EObject current=null] : iv_ruleFragmentCaller= ruleFragmentCaller EOF ;
    public final EObject entryRuleFragmentCaller() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFragmentCaller = null;


        try {
            // InternalSequencerTestLanguage.g:4069:2: (iv_ruleFragmentCaller= ruleFragmentCaller EOF )
            // InternalSequencerTestLanguage.g:4070:2: iv_ruleFragmentCaller= ruleFragmentCaller EOF
            {
             newCompositeNode(grammarAccess.getFragmentCallerRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFragmentCaller=ruleFragmentCaller();

            state._fsp--;

             current =iv_ruleFragmentCaller; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleFragmentCaller"


    // $ANTLR start "ruleFragmentCaller"
    // InternalSequencerTestLanguage.g:4077:1: ruleFragmentCaller returns [EObject current=null] : (otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) ) ;
    public final EObject ruleFragmentCaller() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val_3_0=null;
        EObject this_Fragment1_2 = null;


         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:4080:28: ( (otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) ) )
            // InternalSequencerTestLanguage.g:4081:1: (otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) )
            {
            // InternalSequencerTestLanguage.g:4081:1: (otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:4081:3: otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,56,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getFragmentCallerAccess().getNumberSignDigitThreeDigitThreeKeyword_0());
                
            // InternalSequencerTestLanguage.g:4085:1: ( (lv_val1_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:4086:1: (lv_val1_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:4086:1: (lv_val1_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:4087:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            			newLeafNode(lv_val1_1_0, grammarAccess.getFragmentCallerAccess().getVal1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFragmentCallerRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val1",
                    		lv_val1_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

             
            		if (current==null) {
            			current = createModelElement(grammarAccess.getFragmentCallerRule());
            		}
                    newCompositeNode(grammarAccess.getFragmentCallerAccess().getFragment1ParserRuleCall_2()); 
                
            pushFollow(FollowSets000.FOLLOW_3);
            this_Fragment1_2=ruleFragment1(current);

            state._fsp--;

             
                    current = this_Fragment1_2; 
                    afterParserOrEnumRuleCall();
                
            // InternalSequencerTestLanguage.g:4115:1: ( (lv_val_3_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:4116:1: (lv_val_3_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:4116:1: (lv_val_3_0= RULE_ID )
            // InternalSequencerTestLanguage.g:4117:3: lv_val_3_0= RULE_ID
            {
            lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_val_3_0, grammarAccess.getFragmentCallerAccess().getValIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFragmentCallerRule());
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

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFragmentCaller"


    // $ANTLR start "ruleFragment1"
    // InternalSequencerTestLanguage.g:4142:1: ruleFragment1[EObject in_current] returns [EObject current=in_current] : ( (lv_fragVal_0_0= RULE_ID ) ) ;
    public final EObject ruleFragment1(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_fragVal_0_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:4145:28: ( ( (lv_fragVal_0_0= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:4146:1: ( (lv_fragVal_0_0= RULE_ID ) )
            {
            // InternalSequencerTestLanguage.g:4146:1: ( (lv_fragVal_0_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:4147:1: (lv_fragVal_0_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:4147:1: (lv_fragVal_0_0= RULE_ID )
            // InternalSequencerTestLanguage.g:4148:3: lv_fragVal_0_0= RULE_ID
            {
            lv_fragVal_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_fragVal_0_0, grammarAccess.getFragment1Access().getFragValIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFragment1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"fragVal",
                    		lv_fragVal_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFragment1"


    // $ANTLR start "entryRuleParameterCaller"
    // InternalSequencerTestLanguage.g:4172:1: entryRuleParameterCaller returns [EObject current=null] : iv_ruleParameterCaller= ruleParameterCaller EOF ;
    public final EObject entryRuleParameterCaller() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterCaller = null;


        try {
            // InternalSequencerTestLanguage.g:4173:2: (iv_ruleParameterCaller= ruleParameterCaller EOF )
            // InternalSequencerTestLanguage.g:4174:2: iv_ruleParameterCaller= ruleParameterCaller EOF
            {
             newCompositeNode(grammarAccess.getParameterCallerRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameterCaller=ruleParameterCaller();

            state._fsp--;

             current =iv_ruleParameterCaller; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleParameterCaller"


    // $ANTLR start "ruleParameterCaller"
    // InternalSequencerTestLanguage.g:4181:1: ruleParameterCaller returns [EObject current=null] : (otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) ) ) ;
    public final EObject ruleParameterCaller() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_p_2_0 = null;

        EObject lv_p_4_0 = null;

        EObject lv_p_6_0 = null;

        EObject lv_p_8_0 = null;


         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:4184:28: ( (otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) ) ) )
            // InternalSequencerTestLanguage.g:4185:1: (otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) ) )
            {
            // InternalSequencerTestLanguage.g:4185:1: (otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) ) )
            // InternalSequencerTestLanguage.g:4185:3: otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) )
            {
            otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_32); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterCallerAccess().getNumberSignDigitThreeDigitFourKeyword_0());
                
            // InternalSequencerTestLanguage.g:4189:1: ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) )
            int alt45=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt45=1;
                }
                break;
            case 17:
                {
                alt45=2;
                }
                break;
            case 19:
                {
                alt45=3;
                }
                break;
            case 22:
                {
                alt45=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalSequencerTestLanguage.g:4189:2: (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) )
                    {
                    // InternalSequencerTestLanguage.g:4189:2: (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) )
                    // InternalSequencerTestLanguage.g:4189:4: otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) )
                    {
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_33); 

                        	newLeafNode(otherlv_1, grammarAccess.getParameterCallerAccess().getKw1Keyword_1_0_0());
                        
                    // InternalSequencerTestLanguage.g:4193:1: ( (lv_p_2_0= norm3_Parameterized ) )
                    // InternalSequencerTestLanguage.g:4194:1: (lv_p_2_0= norm3_Parameterized )
                    {
                    // InternalSequencerTestLanguage.g:4194:1: (lv_p_2_0= norm3_Parameterized )
                    // InternalSequencerTestLanguage.g:4195:3: lv_p_2_0= norm3_Parameterized
                    {
                     
                    	        newCompositeNode(grammarAccess.getParameterCallerAccess().getPParameterizedParserRuleCall_1_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_p_2_0=norm3_Parameterized();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParameterCallerRule());
                    	        }
                           		set(
                           			current, 
                           			"p",
                            		lv_p_2_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.Parameterized");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSequencerTestLanguage.g:4212:6: (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) )
                    {
                    // InternalSequencerTestLanguage.g:4212:6: (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) )
                    // InternalSequencerTestLanguage.g:4212:8: otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) )
                    {
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_33); 

                        	newLeafNode(otherlv_3, grammarAccess.getParameterCallerAccess().getKw2Keyword_1_1_0());
                        
                    // InternalSequencerTestLanguage.g:4216:1: ( (lv_p_4_0= norm1_Parameterized ) )
                    // InternalSequencerTestLanguage.g:4217:1: (lv_p_4_0= norm1_Parameterized )
                    {
                    // InternalSequencerTestLanguage.g:4217:1: (lv_p_4_0= norm1_Parameterized )
                    // InternalSequencerTestLanguage.g:4218:3: lv_p_4_0= norm1_Parameterized
                    {
                     
                    	        newCompositeNode(grammarAccess.getParameterCallerAccess().getPParameterizedParserRuleCall_1_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_p_4_0=norm1_Parameterized();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParameterCallerRule());
                    	        }
                           		set(
                           			current, 
                           			"p",
                            		lv_p_4_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.Parameterized");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSequencerTestLanguage.g:4235:6: (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) )
                    {
                    // InternalSequencerTestLanguage.g:4235:6: (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) )
                    // InternalSequencerTestLanguage.g:4235:8: otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) )
                    {
                    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_34); 

                        	newLeafNode(otherlv_5, grammarAccess.getParameterCallerAccess().getKw3Keyword_1_2_0());
                        
                    // InternalSequencerTestLanguage.g:4239:1: ( (lv_p_6_0= norm2_Parameterized ) )
                    // InternalSequencerTestLanguage.g:4240:1: (lv_p_6_0= norm2_Parameterized )
                    {
                    // InternalSequencerTestLanguage.g:4240:1: (lv_p_6_0= norm2_Parameterized )
                    // InternalSequencerTestLanguage.g:4241:3: lv_p_6_0= norm2_Parameterized
                    {
                     
                    	        newCompositeNode(grammarAccess.getParameterCallerAccess().getPParameterizedParserRuleCall_1_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_p_6_0=norm2_Parameterized();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParameterCallerRule());
                    	        }
                           		set(
                           			current, 
                           			"p",
                            		lv_p_6_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.Parameterized");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSequencerTestLanguage.g:4258:6: (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) )
                    {
                    // InternalSequencerTestLanguage.g:4258:6: (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) )
                    // InternalSequencerTestLanguage.g:4258:8: otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) )
                    {
                    otherlv_7=(Token)match(input,22,FollowSets000.FOLLOW_34); 

                        	newLeafNode(otherlv_7, grammarAccess.getParameterCallerAccess().getKw4Keyword_1_3_0());
                        
                    // InternalSequencerTestLanguage.g:4262:1: ( (lv_p_8_0= ruleParameterized ) )
                    // InternalSequencerTestLanguage.g:4263:1: (lv_p_8_0= ruleParameterized )
                    {
                    // InternalSequencerTestLanguage.g:4263:1: (lv_p_8_0= ruleParameterized )
                    // InternalSequencerTestLanguage.g:4264:3: lv_p_8_0= ruleParameterized
                    {
                     
                    	        newCompositeNode(grammarAccess.getParameterCallerAccess().getPParameterizedParserRuleCall_1_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_p_8_0=ruleParameterized();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParameterCallerRule());
                    	        }
                           		set(
                           			current, 
                           			"p",
                            		lv_p_8_0, 
                            		"org.eclipse.xtext.serializer.SequencerTestLanguage.Parameterized");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterCaller"


    // $ANTLR start "entryRuleParameterized"
    // InternalSequencerTestLanguage.g:4288:1: entryRuleParameterized returns [EObject current=null] : iv_ruleParameterized= ruleParameterized EOF ;
    public final EObject entryRuleParameterized() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterized = null;


        try {
            // InternalSequencerTestLanguage.g:4289:2: (iv_ruleParameterized= ruleParameterized EOF )
            // InternalSequencerTestLanguage.g:4290:2: iv_ruleParameterized= ruleParameterized EOF
            {
             newCompositeNode(grammarAccess.getParameterizedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameterized=ruleParameterized();

            state._fsp--;

             current =iv_ruleParameterized; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleParameterized"


    // $ANTLR start "ruleParameterized"
    // InternalSequencerTestLanguage.g:4297:1: ruleParameterized returns [EObject current=null] : (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParameterized() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_v2_1_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:4300:28: ( (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) ) )
            // InternalSequencerTestLanguage.g:4301:1: (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) )
            {
            // InternalSequencerTestLanguage.g:4301:1: (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:4301:3: otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterizedAccess().getKwp2Keyword_1_0());
                
            // InternalSequencerTestLanguage.g:4305:1: ( (lv_v2_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:4306:1: (lv_v2_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:4306:1: (lv_v2_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:4307:3: lv_v2_1_0= RULE_ID
            {
            lv_v2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_v2_1_0, grammarAccess.getParameterizedAccess().getV2IDTerminalRuleCall_1_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterizedRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"v2",
                    		lv_v2_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterized"


    // $ANTLR start "norm1_Parameterized"
    // InternalSequencerTestLanguage.g:4332:1: norm1_Parameterized returns [EObject current=null] : (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) ) ;
    public final EObject norm1_Parameterized() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_v1_1_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:4335:28: ( (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) ) )
            // InternalSequencerTestLanguage.g:4336:1: (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) )
            {
            // InternalSequencerTestLanguage.g:4336:1: (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:4336:3: otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterizedAccess().getKwp1Keyword_0_0());
                
            // InternalSequencerTestLanguage.g:4340:1: ( (lv_v1_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:4341:1: (lv_v1_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:4341:1: (lv_v1_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:4342:3: lv_v1_1_0= RULE_ID
            {
            lv_v1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_v1_1_0, grammarAccess.getParameterizedAccess().getV1IDTerminalRuleCall_0_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterizedRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"v1",
                    		lv_v1_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "norm1_Parameterized"


    // $ANTLR start "norm2_Parameterized"
    // InternalSequencerTestLanguage.g:4367:1: norm2_Parameterized returns [EObject current=null] : (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )? ) ;
    public final EObject norm2_Parameterized() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_v2_1_0=null;
        Token otherlv_2=null;
        Token lv_v3_3_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:4370:28: ( (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )? ) )
            // InternalSequencerTestLanguage.g:4371:1: (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )? )
            {
            // InternalSequencerTestLanguage.g:4371:1: (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )? )
            // InternalSequencerTestLanguage.g:4371:3: otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterizedAccess().getKwp2Keyword_1_0());
                
            // InternalSequencerTestLanguage.g:4375:1: ( (lv_v2_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:4376:1: (lv_v2_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:4376:1: (lv_v2_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:4377:3: lv_v2_1_0= RULE_ID
            {
            lv_v2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_35); 

            			newLeafNode(lv_v2_1_0, grammarAccess.getParameterizedAccess().getV2IDTerminalRuleCall_1_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterizedRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"v2",
                    		lv_v2_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalSequencerTestLanguage.g:4393:2: (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==60) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalSequencerTestLanguage.g:4393:4: otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,60,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getParameterizedAccess().getKwp3Keyword_1_2_0());
                        
                    // InternalSequencerTestLanguage.g:4397:1: ( (lv_v3_3_0= RULE_ID ) )
                    // InternalSequencerTestLanguage.g:4398:1: (lv_v3_3_0= RULE_ID )
                    {
                    // InternalSequencerTestLanguage.g:4398:1: (lv_v3_3_0= RULE_ID )
                    // InternalSequencerTestLanguage.g:4399:3: lv_v3_3_0= RULE_ID
                    {
                    lv_v3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_v3_3_0, grammarAccess.getParameterizedAccess().getV3IDTerminalRuleCall_1_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getParameterizedRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"v3",
                            		lv_v3_3_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "norm2_Parameterized"


    // $ANTLR start "norm3_Parameterized"
    // InternalSequencerTestLanguage.g:4424:1: norm3_Parameterized returns [EObject current=null] : (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) ) ;
    public final EObject norm3_Parameterized() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_v1_1_0=null;

         enterRule(); 
            
        try {
            // InternalSequencerTestLanguage.g:4427:28: ( (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) ) )
            // InternalSequencerTestLanguage.g:4428:1: (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) )
            {
            // InternalSequencerTestLanguage.g:4428:1: (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) )
            // InternalSequencerTestLanguage.g:4428:3: otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterizedAccess().getKwp1Keyword_0_0());
                
            // InternalSequencerTestLanguage.g:4432:1: ( (lv_v1_1_0= RULE_ID ) )
            // InternalSequencerTestLanguage.g:4433:1: (lv_v1_1_0= RULE_ID )
            {
            // InternalSequencerTestLanguage.g:4433:1: (lv_v1_1_0= RULE_ID )
            // InternalSequencerTestLanguage.g:4434:3: lv_v1_1_0= RULE_ID
            {
            lv_v1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_v1_1_0, grammarAccess.getParameterizedAccess().getV1IDTerminalRuleCall_0_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterizedRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"v1",
                    		lv_v1_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "norm3_Parameterized"


    // $ANTLR start "ruleDefEnum1"
    // InternalSequencerTestLanguage.g:4458:1: ruleDefEnum1 returns [Enumerator current=null] : (enumLiteral_0= 'kw1' ) ;
    public final Enumerator ruleDefEnum1() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // InternalSequencerTestLanguage.g:4460:28: ( (enumLiteral_0= 'kw1' ) )
            // InternalSequencerTestLanguage.g:4461:1: (enumLiteral_0= 'kw1' )
            {
            // InternalSequencerTestLanguage.g:4461:1: (enumLiteral_0= 'kw1' )
            // InternalSequencerTestLanguage.g:4461:3: enumLiteral_0= 'kw1'
            {
            enumLiteral_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    current = grammarAccess.getDefEnum1Access().getKw1EnumLiteralDeclaration().getEnumLiteral().getInstance();
                    newLeafNode(enumLiteral_0, grammarAccess.getDefEnum1Access().getKw1EnumLiteralDeclaration()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefEnum1"


    // $ANTLR start "ruleDefEnum2"
    // InternalSequencerTestLanguage.g:4471:1: ruleDefEnum2 returns [Enumerator current=null] : (enumLiteral_0= 'kw2' ) ;
    public final Enumerator ruleDefEnum2() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // InternalSequencerTestLanguage.g:4473:28: ( (enumLiteral_0= 'kw2' ) )
            // InternalSequencerTestLanguage.g:4474:1: (enumLiteral_0= 'kw2' )
            {
            // InternalSequencerTestLanguage.g:4474:1: (enumLiteral_0= 'kw2' )
            // InternalSequencerTestLanguage.g:4474:3: enumLiteral_0= 'kw2'
            {
            enumLiteral_0=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                    current = grammarAccess.getDefEnum2Access().getKw2EnumLiteralDeclaration().getEnumLiteral().getInstance();
                    newLeafNode(enumLiteral_0, grammarAccess.getDefEnum2Access().getKw2EnumLiteralDeclaration()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefEnum2"


    // $ANTLR start "ruleDefEnum3"
    // InternalSequencerTestLanguage.g:4484:1: ruleDefEnum3 returns [Enumerator current=null] : (enumLiteral_0= 'kw3' ) ;
    public final Enumerator ruleDefEnum3() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // InternalSequencerTestLanguage.g:4486:28: ( (enumLiteral_0= 'kw3' ) )
            // InternalSequencerTestLanguage.g:4487:1: (enumLiteral_0= 'kw3' )
            {
            // InternalSequencerTestLanguage.g:4487:1: (enumLiteral_0= 'kw3' )
            // InternalSequencerTestLanguage.g:4487:3: enumLiteral_0= 'kw3'
            {
            enumLiteral_0=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                    current = grammarAccess.getDefEnum3Access().getKw3EnumLiteralDeclaration().getEnumLiteral().getInstance();
                    newLeafNode(enumLiteral_0, grammarAccess.getDefEnum3Access().getKw3EnumLiteralDeclaration()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefEnum3"

    // Delegated rules


    protected DFA32 dfa32 = new DFA32(this);
    static final String dfa_1s = "\5\uffff";
    static final String dfa_2s = "\3\uffff\1\4\1\uffff";
    static final String dfa_3s = "\2\4\1\uffff\1\4\1\uffff";
    static final String dfa_4s = "\1\4\1\20\1\uffff\1\20\1\uffff";
    static final String dfa_5s = "\2\uffff\1\2\1\uffff\1\1";
    static final String dfa_6s = "\5\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\3\13\uffff\1\2",
            "",
            "\1\3\13\uffff\1\2",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2587:1: ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000030010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000480010L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800012L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000020000010L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000010L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000000B0000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000000B0010L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000000000E0L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000102L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000030112L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000030110L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000000000B0002L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0002000000CB0002L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0002000000CA0002L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0002000000C80002L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0008000000000002L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000000004B0000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0400000000000000L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x1000000000000002L});
    }


}