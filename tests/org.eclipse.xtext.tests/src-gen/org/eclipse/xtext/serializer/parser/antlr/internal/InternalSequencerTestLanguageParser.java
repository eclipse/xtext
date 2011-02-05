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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ID1", "RULE_ID2", "RULE_ID3", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'kw1'", "'kw2'", "'#3'", "'kw3'", "'#4'", "'#5'", "'kw4'", "'kw5'", "'#6'", "','", "'#7'", "'#8'", "'#9'", "'kw'", "'#10'", "'#11'", "'#12'", "'#13'", "'#14'", "'#15'", "'#16'", "'#17'", "'#18'", "'#19'", "'#20'"
    };
    public static final int RULE_ML_COMMENT=10;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int RULE_STRING=9;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int RULE_ID3=7;
    public static final int T__33=33;
    public static final int T__14=14;
    public static final int T__22=22;
    public static final int T__29=29;
    public static final int T__39=39;
    public static final int RULE_ID1=5;
    public static final int T__30=30;
    public static final int RULE_WS=12;
    public static final int T__17=17;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int RULE_INT=8;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__24=24;
    public static final int T__37=37;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__34=34;
    public static final int RULE_ID2=6;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalSequencerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSequencerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSequencerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g"; }



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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:69:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) ) ;
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


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:80:28: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:81:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:81:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) )
            int alt1=20;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:81:2: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:81:2: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:82:1: (lv_x1_0_0= ruleSimpleGroup )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:82:1: (lv_x1_0_0= ruleSimpleGroup )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:83:3: lv_x1_0_0= ruleSimpleGroup
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX1SimpleGroupParserRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleGroup_in_ruleModel131);
                    lv_x1_0_0=ruleSimpleGroup();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x1",
                            		lv_x1_0_0, 
                            		"SimpleGroup");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:100:6: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:100:6: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:101:1: (lv_x2_1_0= ruleSimpleAlternative )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:101:1: (lv_x2_1_0= ruleSimpleAlternative )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:102:3: lv_x2_1_0= ruleSimpleAlternative
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX2SimpleAlternativeParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleAlternative_in_ruleModel158);
                    lv_x2_1_0=ruleSimpleAlternative();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x2",
                            		lv_x2_1_0, 
                            		"SimpleAlternative");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:119:6: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:119:6: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:120:1: (lv_x3_2_0= ruleSimpleMultiplicities )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:120:1: (lv_x3_2_0= ruleSimpleMultiplicities )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:121:3: lv_x3_2_0= ruleSimpleMultiplicities
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX3SimpleMultiplicitiesParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicities_in_ruleModel185);
                    lv_x3_2_0=ruleSimpleMultiplicities();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x3",
                            		lv_x3_2_0, 
                            		"SimpleMultiplicities");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:138:6: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:138:6: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:139:1: (lv_x4_3_0= ruleGroupMultiplicities )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:139:1: (lv_x4_3_0= ruleGroupMultiplicities )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:140:3: lv_x4_3_0= ruleGroupMultiplicities
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX4GroupMultiplicitiesParserRuleCall_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleGroupMultiplicities_in_ruleModel212);
                    lv_x4_3_0=ruleGroupMultiplicities();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x4",
                            		lv_x4_3_0, 
                            		"GroupMultiplicities");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:157:6: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:157:6: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:158:1: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:158:1: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:159:3: lv_x5_4_0= ruleAlternativeMultiplicities
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX5AlternativeMultiplicitiesParserRuleCall_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAlternativeMultiplicities_in_ruleModel239);
                    lv_x5_4_0=ruleAlternativeMultiplicities();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x5",
                            		lv_x5_4_0, 
                            		"AlternativeMultiplicities");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:176:6: ( (lv_x6_5_0= ruleList1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:176:6: ( (lv_x6_5_0= ruleList1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:177:1: (lv_x6_5_0= ruleList1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:177:1: (lv_x6_5_0= ruleList1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:178:3: lv_x6_5_0= ruleList1
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX6List1ParserRuleCall_5_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleList1_in_ruleModel266);
                    lv_x6_5_0=ruleList1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x6",
                            		lv_x6_5_0, 
                            		"List1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:195:6: ( (lv_x7_6_0= ruleList2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:195:6: ( (lv_x7_6_0= ruleList2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:196:1: (lv_x7_6_0= ruleList2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:196:1: (lv_x7_6_0= ruleList2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:197:3: lv_x7_6_0= ruleList2
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX7List2ParserRuleCall_6_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleList2_in_ruleModel293);
                    lv_x7_6_0=ruleList2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x7",
                            		lv_x7_6_0, 
                            		"List2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:214:6: ( (lv_x8_7_0= ruleAltList1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:214:6: ( (lv_x8_7_0= ruleAltList1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:215:1: (lv_x8_7_0= ruleAltList1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:215:1: (lv_x8_7_0= ruleAltList1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:216:3: lv_x8_7_0= ruleAltList1
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX8AltList1ParserRuleCall_7_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAltList1_in_ruleModel320);
                    lv_x8_7_0=ruleAltList1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x8",
                            		lv_x8_7_0, 
                            		"AltList1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:233:6: ( (lv_x9_8_0= ruleAltList2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:233:6: ( (lv_x9_8_0= ruleAltList2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:234:1: (lv_x9_8_0= ruleAltList2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:234:1: (lv_x9_8_0= ruleAltList2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:235:3: lv_x9_8_0= ruleAltList2
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX9AltList2ParserRuleCall_8_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAltList2_in_ruleModel347);
                    lv_x9_8_0=ruleAltList2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x9",
                            		lv_x9_8_0, 
                            		"AltList2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:252:6: ( (lv_x10_9_0= ruleSingleKeywords ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:252:6: ( (lv_x10_9_0= ruleSingleKeywords ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:253:1: (lv_x10_9_0= ruleSingleKeywords )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:253:1: (lv_x10_9_0= ruleSingleKeywords )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:254:3: lv_x10_9_0= ruleSingleKeywords
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX10SingleKeywordsParserRuleCall_9_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSingleKeywords_in_ruleModel374);
                    lv_x10_9_0=ruleSingleKeywords();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x10",
                            		lv_x10_9_0, 
                            		"SingleKeywords");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:271:6: ( (lv_x11_10_0= ruleSingleKeywordsOrID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:271:6: ( (lv_x11_10_0= ruleSingleKeywordsOrID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:272:1: (lv_x11_10_0= ruleSingleKeywordsOrID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:272:1: (lv_x11_10_0= ruleSingleKeywordsOrID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:273:3: lv_x11_10_0= ruleSingleKeywordsOrID
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX11SingleKeywordsOrIDParserRuleCall_10_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSingleKeywordsOrID_in_ruleModel401);
                    lv_x11_10_0=ruleSingleKeywordsOrID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x11",
                            		lv_x11_10_0, 
                            		"SingleKeywordsOrID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:290:6: ( (lv_x12_11_0= ruleSingleTerminals ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:290:6: ( (lv_x12_11_0= ruleSingleTerminals ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:291:1: (lv_x12_11_0= ruleSingleTerminals )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:291:1: (lv_x12_11_0= ruleSingleTerminals )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:292:3: lv_x12_11_0= ruleSingleTerminals
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX12SingleTerminalsParserRuleCall_11_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSingleTerminals_in_ruleModel428);
                    lv_x12_11_0=ruleSingleTerminals();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x12",
                            		lv_x12_11_0, 
                            		"SingleTerminals");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:309:6: ( (lv_x10_12_0= ruleMultiKeywords ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:309:6: ( (lv_x10_12_0= ruleMultiKeywords ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:310:1: (lv_x10_12_0= ruleMultiKeywords )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:310:1: (lv_x10_12_0= ruleMultiKeywords )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:311:3: lv_x10_12_0= ruleMultiKeywords
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX10MultiKeywordsParserRuleCall_12_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMultiKeywords_in_ruleModel455);
                    lv_x10_12_0=ruleMultiKeywords();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x10",
                            		lv_x10_12_0, 
                            		"MultiKeywords");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 14 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:328:6: ( (lv_x11_13_0= ruleMultiKeywordsOrID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:328:6: ( (lv_x11_13_0= ruleMultiKeywordsOrID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:329:1: (lv_x11_13_0= ruleMultiKeywordsOrID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:329:1: (lv_x11_13_0= ruleMultiKeywordsOrID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:330:3: lv_x11_13_0= ruleMultiKeywordsOrID
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX11MultiKeywordsOrIDParserRuleCall_13_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMultiKeywordsOrID_in_ruleModel482);
                    lv_x11_13_0=ruleMultiKeywordsOrID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x11",
                            		lv_x11_13_0, 
                            		"MultiKeywordsOrID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 15 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:347:6: ( (lv_x12_14_0= ruleMultiTerminals ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:347:6: ( (lv_x12_14_0= ruleMultiTerminals ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:348:1: (lv_x12_14_0= ruleMultiTerminals )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:348:1: (lv_x12_14_0= ruleMultiTerminals )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:349:3: lv_x12_14_0= ruleMultiTerminals
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX12MultiTerminalsParserRuleCall_14_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMultiTerminals_in_ruleModel509);
                    lv_x12_14_0=ruleMultiTerminals();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x12",
                            		lv_x12_14_0, 
                            		"MultiTerminals");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 16 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:366:6: ( (lv_x13_15_0= ruleSingleEnum ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:366:6: ( (lv_x13_15_0= ruleSingleEnum ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:367:1: (lv_x13_15_0= ruleSingleEnum )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:367:1: (lv_x13_15_0= ruleSingleEnum )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:368:3: lv_x13_15_0= ruleSingleEnum
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX13SingleEnumParserRuleCall_15_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSingleEnum_in_ruleModel536);
                    lv_x13_15_0=ruleSingleEnum();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x13",
                            		lv_x13_15_0, 
                            		"SingleEnum");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 17 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:385:6: ( (lv_x14_16_0= ruleSingleCrossReference ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:385:6: ( (lv_x14_16_0= ruleSingleCrossReference ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:386:1: (lv_x14_16_0= ruleSingleCrossReference )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:386:1: (lv_x14_16_0= ruleSingleCrossReference )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:387:3: lv_x14_16_0= ruleSingleCrossReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX14SingleCrossReferenceParserRuleCall_16_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSingleCrossReference_in_ruleModel563);
                    lv_x14_16_0=ruleSingleCrossReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x14",
                            		lv_x14_16_0, 
                            		"SingleCrossReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 18 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:404:6: ( (lv_x15_17_0= ruleSingleContainmentReference ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:404:6: ( (lv_x15_17_0= ruleSingleContainmentReference ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:405:1: (lv_x15_17_0= ruleSingleContainmentReference )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:405:1: (lv_x15_17_0= ruleSingleContainmentReference )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:406:3: lv_x15_17_0= ruleSingleContainmentReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX15SingleContainmentReferenceParserRuleCall_17_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReference_in_ruleModel590);
                    lv_x15_17_0=ruleSingleContainmentReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x15",
                            		lv_x15_17_0, 
                            		"SingleContainmentReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 19 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:423:6: ( (lv_x19_18_0= ruleDependentAlternative1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:423:6: ( (lv_x19_18_0= ruleDependentAlternative1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:424:1: (lv_x19_18_0= ruleDependentAlternative1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:424:1: (lv_x19_18_0= ruleDependentAlternative1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:425:3: lv_x19_18_0= ruleDependentAlternative1
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX19DependentAlternative1ParserRuleCall_18_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDependentAlternative1_in_ruleModel617);
                    lv_x19_18_0=ruleDependentAlternative1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x19",
                            		lv_x19_18_0, 
                            		"DependentAlternative1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 20 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:442:6: ( (lv_x20_19_0= ruleDependentAlternative2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:442:6: ( (lv_x20_19_0= ruleDependentAlternative2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:443:1: (lv_x20_19_0= ruleDependentAlternative2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:443:1: (lv_x20_19_0= ruleDependentAlternative2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:444:3: lv_x20_19_0= ruleDependentAlternative2
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getX20DependentAlternative2ParserRuleCall_19_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDependentAlternative2_in_ruleModel644);
                    lv_x20_19_0=ruleDependentAlternative2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"x20",
                            		lv_x20_19_0, 
                            		"DependentAlternative2");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:468:1: entryRuleSimpleGroup returns [EObject current=null] : iv_ruleSimpleGroup= ruleSimpleGroup EOF ;
    public final EObject entryRuleSimpleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleGroup = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:469:2: (iv_ruleSimpleGroup= ruleSimpleGroup EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:470:2: iv_ruleSimpleGroup= ruleSimpleGroup EOF
            {
             newCompositeNode(grammarAccess.getSimpleGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup680);
            iv_ruleSimpleGroup=ruleSimpleGroup();

            state._fsp--;

             current =iv_ruleSimpleGroup; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleGroup690); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:477:1: ruleSimpleGroup returns [EObject current=null] : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:480:28: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:481:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:481:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:481:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSimpleGroup727); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleGroupAccess().getNumberSignDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:485:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:486:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:486:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:487:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup744); 

            			newLeafNode(lv_val1_1_0, grammarAccess.getSimpleGroupAccess().getVal1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleGroupRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val1",
                    		lv_val1_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:503:2: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:504:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:504:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:505:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup766); 

            			newLeafNode(lv_val2_2_0, grammarAccess.getSimpleGroupAccess().getVal2IDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleGroupRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val2",
                    		lv_val2_2_0, 
                    		"ID");
            	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:529:1: entryRuleSimpleAlternative returns [EObject current=null] : iv_ruleSimpleAlternative= ruleSimpleAlternative EOF ;
    public final EObject entryRuleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAlternative = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:530:2: (iv_ruleSimpleAlternative= ruleSimpleAlternative EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:531:2: iv_ruleSimpleAlternative= ruleSimpleAlternative EOF
            {
             newCompositeNode(grammarAccess.getSimpleAlternativeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative807);
            iv_ruleSimpleAlternative=ruleSimpleAlternative();

            state._fsp--;

             current =iv_ruleSimpleAlternative; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleAlternative817); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:538:1: ruleSimpleAlternative returns [EObject current=null] : (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val2_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:541:28: ( (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:542:1: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:542:1: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:542:3: otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSimpleAlternative854); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleAlternativeAccess().getNumberSignDigitTwoKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:546:1: ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:546:2: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:546:2: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:546:4: otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSimpleAlternative868); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAlternativeAccess().getKw1Keyword_1_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:550:1: ( (lv_val1_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:551:1: (lv_val1_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:551:1: (lv_val1_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:552:3: lv_val1_2_0= RULE_ID
                    {
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative885); 

                    			newLeafNode(lv_val1_2_0, grammarAccess.getSimpleAlternativeAccess().getVal1IDTerminalRuleCall_1_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleAlternativeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_2_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:569:6: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:569:6: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:569:8: otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSimpleAlternative910); 

                        	newLeafNode(otherlv_3, grammarAccess.getSimpleAlternativeAccess().getKw2Keyword_1_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:573:1: ( (lv_val2_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:574:1: (lv_val2_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:574:1: (lv_val2_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:575:3: lv_val2_4_0= RULE_ID
                    {
                    lv_val2_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative927); 

                    			newLeafNode(lv_val2_4_0, grammarAccess.getSimpleAlternativeAccess().getVal2IDTerminalRuleCall_1_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleAlternativeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_4_0, 
                            		"ID");
                    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:599:1: entryRuleSimpleMultiplicities returns [EObject current=null] : iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF ;
    public final EObject entryRuleSimpleMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:600:2: (iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:601:2: iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF
            {
             newCompositeNode(grammarAccess.getSimpleMultiplicitiesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities970);
            iv_ruleSimpleMultiplicities=ruleSimpleMultiplicities();

            state._fsp--;

             current =iv_ruleSimpleMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleMultiplicities980); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:608:1: ruleSimpleMultiplicities returns [EObject current=null] : (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:611:28: ( (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:612:1: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:612:1: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:612:3: otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSimpleMultiplicities1017); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleMultiplicitiesAccess().getNumberSignDigitThreeKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:616:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:617:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:617:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:618:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1034); 

            			newLeafNode(lv_val1_1_0, grammarAccess.getSimpleMultiplicitiesAccess().getVal1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleMultiplicitiesRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val1",
                    		lv_val1_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSimpleMultiplicities1051); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleMultiplicitiesAccess().getKw1Keyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:638:1: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:639:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:639:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:640:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1068); 

                    			newLeafNode(lv_val2_3_0, grammarAccess.getSimpleMultiplicitiesAccess().getVal2IDTerminalRuleCall_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleMultiplicitiesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_3_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSimpleMultiplicities1086); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleMultiplicitiesAccess().getKw2Keyword_4());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:660:1: ( (lv_val3_5_0= RULE_ID ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:661:1: (lv_val3_5_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:661:1: (lv_val3_5_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:662:3: lv_val3_5_0= RULE_ID
            	    {
            	    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1103); 

            	    			newLeafNode(lv_val3_5_0, grammarAccess.getSimpleMultiplicitiesAccess().getVal3IDTerminalRuleCall_5_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getSimpleMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val3",
            	            		lv_val3_5_0, 
            	            		"ID");
            	    	    

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

            otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSimpleMultiplicities1121); 

                	newLeafNode(otherlv_6, grammarAccess.getSimpleMultiplicitiesAccess().getKw3Keyword_6());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:682:1: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:683:1: (lv_val4_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:683:1: (lv_val4_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:684:3: lv_val4_7_0= RULE_ID
            	    {
            	    lv_val4_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1138); 

            	    			newLeafNode(lv_val4_7_0, grammarAccess.getSimpleMultiplicitiesAccess().getVal4IDTerminalRuleCall_7_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getSimpleMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val4",
            	            		lv_val4_7_0, 
            	            		"ID");
            	    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:708:1: entryRuleGroupMultiplicities returns [EObject current=null] : iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF ;
    public final EObject entryRuleGroupMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:709:2: (iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:710:2: iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF
            {
             newCompositeNode(grammarAccess.getGroupMultiplicitiesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities1180);
            iv_ruleGroupMultiplicities=ruleGroupMultiplicities();

            state._fsp--;

             current =iv_ruleGroupMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupMultiplicities1190); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:717:1: ruleGroupMultiplicities returns [EObject current=null] : (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:720:28: ( (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:721:1: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:721:1: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:721:3: otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleGroupMultiplicities1227); 

                	newLeafNode(otherlv_0, grammarAccess.getGroupMultiplicitiesAccess().getNumberSignDigitFourKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:725:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:726:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:726:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:727:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1244); 

            			newLeafNode(lv_val1_1_0, grammarAccess.getGroupMultiplicitiesAccess().getVal1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val1",
                    		lv_val1_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleGroupMultiplicities1261); 

                	newLeafNode(otherlv_2, grammarAccess.getGroupMultiplicitiesAccess().getKw1Keyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:747:1: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:747:2: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:747:2: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:748:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:748:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:749:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1279); 

                    			newLeafNode(lv_val2_3_0, grammarAccess.getGroupMultiplicitiesAccess().getVal2IDTerminalRuleCall_3_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_3_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:765:2: ( (lv_val3_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:766:1: (lv_val3_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:766:1: (lv_val3_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:767:3: lv_val3_4_0= RULE_ID
                    {
                    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1301); 

                    			newLeafNode(lv_val3_4_0, grammarAccess.getGroupMultiplicitiesAccess().getVal3IDTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val3",
                            		lv_val3_4_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGroupMultiplicities1320); 

                	newLeafNode(otherlv_5, grammarAccess.getGroupMultiplicitiesAccess().getKw2Keyword_4());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:787:1: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:787:2: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:787:2: ( (lv_val4_6_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:788:1: (lv_val4_6_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:788:1: (lv_val4_6_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:789:3: lv_val4_6_0= RULE_ID
            	    {
            	    lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1338); 

            	    			newLeafNode(lv_val4_6_0, grammarAccess.getGroupMultiplicitiesAccess().getVal4IDTerminalRuleCall_5_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val4",
            	            		lv_val4_6_0, 
            	            		"ID");
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:805:2: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:806:1: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:806:1: (lv_val5_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:807:3: lv_val5_7_0= RULE_ID
            	    {
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1360); 

            	    			newLeafNode(lv_val5_7_0, grammarAccess.getGroupMultiplicitiesAccess().getVal5IDTerminalRuleCall_5_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val5",
            	            		lv_val5_7_0, 
            	            		"ID");
            	    	    

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

            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleGroupMultiplicities1379); 

                	newLeafNode(otherlv_8, grammarAccess.getGroupMultiplicitiesAccess().getKw3Keyword_6());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:827:1: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:827:2: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:827:2: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:828:1: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:828:1: (lv_val6_9_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:829:3: lv_val6_9_0= RULE_ID
            	    {
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1397); 

            	    			newLeafNode(lv_val6_9_0, grammarAccess.getGroupMultiplicitiesAccess().getVal6IDTerminalRuleCall_7_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val6",
            	            		lv_val6_9_0, 
            	            		"ID");
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:845:2: ( (lv_val7_10_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:846:1: (lv_val7_10_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:846:1: (lv_val7_10_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:847:3: lv_val7_10_0= RULE_ID
            	    {
            	    lv_val7_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1419); 

            	    			newLeafNode(lv_val7_10_0, grammarAccess.getGroupMultiplicitiesAccess().getVal7IDTerminalRuleCall_7_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGroupMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val7",
            	            		lv_val7_10_0, 
            	            		"ID");
            	    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:871:1: entryRuleAlternativeMultiplicities returns [EObject current=null] : iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF ;
    public final EObject entryRuleAlternativeMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:872:2: (iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:873:2: iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF
            {
             newCompositeNode(grammarAccess.getAlternativeMultiplicitiesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities1462);
            iv_ruleAlternativeMultiplicities=ruleAlternativeMultiplicities();

            state._fsp--;

             current =iv_ruleAlternativeMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeMultiplicities1472); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:880:1: ruleAlternativeMultiplicities returns [EObject current=null] : (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:883:28: ( (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:884:1: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:884:1: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:884:3: otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAlternativeMultiplicities1509); 

                	newLeafNode(otherlv_0, grammarAccess.getAlternativeMultiplicitiesAccess().getNumberSignDigitFiveKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:888:1: ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:888:2: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:888:2: ( (lv_val2_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:889:1: (lv_val2_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:889:1: (lv_val2_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:890:3: lv_val2_1_0= RULE_ID
                    {
                    lv_val2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1527); 

                    			newLeafNode(lv_val2_1_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal2IDTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAlternativeMultiplicitiesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_1_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:907:6: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:907:6: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:907:8: otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleAlternativeMultiplicities1551); 

                        	newLeafNode(otherlv_2, grammarAccess.getAlternativeMultiplicitiesAccess().getKw1Keyword_1_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:911:1: ( (lv_val3_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:912:1: (lv_val3_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:912:1: (lv_val3_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:913:3: lv_val3_3_0= RULE_ID
                    {
                    lv_val3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1568); 

                    			newLeafNode(lv_val3_3_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal3IDTerminalRuleCall_1_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAlternativeMultiplicitiesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val3",
                            		lv_val3_3_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAlternativeMultiplicities1588); 

                	newLeafNode(otherlv_4, grammarAccess.getAlternativeMultiplicitiesAccess().getKw2Keyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:933:1: ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:933:2: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:933:2: ( (lv_val4_5_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:934:1: (lv_val4_5_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:934:1: (lv_val4_5_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:935:3: lv_val4_5_0= RULE_ID
            	    {
            	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1606); 

            	    			newLeafNode(lv_val4_5_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal4IDTerminalRuleCall_3_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAlternativeMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val4",
            	            		lv_val4_5_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:952:6: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:952:6: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:952:8: otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAlternativeMultiplicities1630); 

            	        	newLeafNode(otherlv_6, grammarAccess.getAlternativeMultiplicitiesAccess().getKw3Keyword_3_1_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:956:1: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:957:1: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:957:1: (lv_val5_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:958:3: lv_val5_7_0= RULE_ID
            	    {
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1647); 

            	    			newLeafNode(lv_val5_7_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal5IDTerminalRuleCall_3_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAlternativeMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val5",
            	            		lv_val5_7_0, 
            	            		"ID");
            	    	    

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

            otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleAlternativeMultiplicities1667); 

                	newLeafNode(otherlv_8, grammarAccess.getAlternativeMultiplicitiesAccess().getKw4Keyword_4());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:978:1: ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:978:2: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:978:2: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:979:1: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:979:1: (lv_val6_9_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:980:3: lv_val6_9_0= RULE_ID
            	    {
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1685); 

            	    			newLeafNode(lv_val6_9_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal6IDTerminalRuleCall_5_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAlternativeMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val6",
            	            		lv_val6_9_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:997:6: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:997:6: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:997:8: otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {
            	    otherlv_10=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleAlternativeMultiplicities1709); 

            	        	newLeafNode(otherlv_10, grammarAccess.getAlternativeMultiplicitiesAccess().getKw5Keyword_5_1_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1001:1: ( (lv_val7_11_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1002:1: (lv_val7_11_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1002:1: (lv_val7_11_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1003:3: lv_val7_11_0= RULE_ID
            	    {
            	    lv_val7_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1726); 

            	    			newLeafNode(lv_val7_11_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal7IDTerminalRuleCall_5_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAlternativeMultiplicitiesRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val7",
            	            		lv_val7_11_0, 
            	            		"ID");
            	    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1027:1: entryRuleList1 returns [EObject current=null] : iv_ruleList1= ruleList1 EOF ;
    public final EObject entryRuleList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1028:2: (iv_ruleList1= ruleList1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1029:2: iv_ruleList1= ruleList1 EOF
            {
             newCompositeNode(grammarAccess.getList1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleList1_in_entryRuleList11770);
            iv_ruleList1=ruleList1();

            state._fsp--;

             current =iv_ruleList1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList11780); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1036:1: ruleList1 returns [EObject current=null] : (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleList1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1039:28: ( (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1040:1: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1040:1: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1040:3: otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleList11817); 

                	newLeafNode(otherlv_0, grammarAccess.getList1Access().getNumberSignDigitSixKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1044:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1045:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1045:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1046:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList11834); 

            			newLeafNode(lv_val1_1_0, grammarAccess.getList1Access().getVal1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getList1Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"val1",
                    		lv_val1_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1062:2: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==25) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1062:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleList11852); 

            	        	newLeafNode(otherlv_2, grammarAccess.getList1Access().getCommaKeyword_2_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1066:1: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1067:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1067:1: (lv_val1_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1068:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList11869); 

            	    			newLeafNode(lv_val1_3_0, grammarAccess.getList1Access().getVal1IDTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getList1Rule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"val1",
            	            		lv_val1_3_0, 
            	            		"ID");
            	    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1092:1: entryRuleList2 returns [EObject current=null] : iv_ruleList2= ruleList2 EOF ;
    public final EObject entryRuleList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1093:2: (iv_ruleList2= ruleList2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1094:2: iv_ruleList2= ruleList2 EOF
            {
             newCompositeNode(grammarAccess.getList2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleList2_in_entryRuleList21912);
            iv_ruleList2=ruleList2();

            state._fsp--;

             current =iv_ruleList2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList21922); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1101:1: ruleList2 returns [EObject current=null] : (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? ) ;
    public final EObject ruleList2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1104:28: ( (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1105:1: (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1105:1: (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1105:3: otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )?
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleList21959); 

                	newLeafNode(otherlv_0, grammarAccess.getList2Access().getNumberSignDigitSevenKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1109:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1110:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getList2Access().getList2Action_1(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1115:2: ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1115:3: ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1115:3: ( (lv_val1_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1116:1: (lv_val1_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1116:1: (lv_val1_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1117:3: lv_val1_2_0= RULE_ID
                    {
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList21986); 

                    			newLeafNode(lv_val1_2_0, grammarAccess.getList2Access().getVal1IDTerminalRuleCall_2_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getList2Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1133:2: (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==25) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1133:4: otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleList22004); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getList2Access().getCommaKeyword_2_1_0());
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1137:1: ( (lv_val1_4_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1138:1: (lv_val1_4_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1138:1: (lv_val1_4_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1139:3: lv_val1_4_0= RULE_ID
                    	    {
                    	    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList22021); 

                    	    			newLeafNode(lv_val1_4_0, grammarAccess.getList2Access().getVal1IDTerminalRuleCall_2_1_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getList2Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"val1",
                    	            		lv_val1_4_0, 
                    	            		"ID");
                    	    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1163:1: entryRuleAltList1 returns [EObject current=null] : iv_ruleAltList1= ruleAltList1 EOF ;
    public final EObject entryRuleAltList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltList1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1164:2: (iv_ruleAltList1= ruleAltList1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1165:2: iv_ruleAltList1= ruleAltList1 EOF
            {
             newCompositeNode(grammarAccess.getAltList1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAltList1_in_entryRuleAltList12066);
            iv_ruleAltList1=ruleAltList1();

            state._fsp--;

             current =iv_ruleAltList1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAltList12076); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1172:1: ruleAltList1 returns [EObject current=null] : (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1175:28: ( (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1176:1: (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1176:1: (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1176:3: otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAltList12113); 

                	newLeafNode(otherlv_0, grammarAccess.getAltList1Access().getNumberSignDigitEightKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1180:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1180:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1180:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1180:3: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1180:3: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1181:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1181:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1182:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList12132); 

                    			newLeafNode(lv_val1_1_0, grammarAccess.getAltList1Access().getVal1IDTerminalRuleCall_1_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_1_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1198:2: ( (lv_val2_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1199:1: (lv_val2_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1199:1: (lv_val2_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1200:3: lv_val2_2_0= RULE_ID
                    {
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList12154); 

                    			newLeafNode(lv_val2_2_0, grammarAccess.getAltList1Access().getVal2IDTerminalRuleCall_1_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_2_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1217:6: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1217:6: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1217:8: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleAltList12179); 

                        	newLeafNode(otherlv_3, grammarAccess.getAltList1Access().getKw1Keyword_1_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1221:1: ( (lv_val1_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1222:1: (lv_val1_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1222:1: (lv_val1_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1223:3: lv_val1_4_0= RULE_ID
                    {
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList12196); 

                    			newLeafNode(lv_val1_4_0, grammarAccess.getAltList1Access().getVal1IDTerminalRuleCall_1_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_4_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1239:2: ( (lv_val3_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1240:1: (lv_val3_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1240:1: (lv_val3_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1241:3: lv_val3_5_0= RULE_ID
                    {
                    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList12218); 

                    			newLeafNode(lv_val3_5_0, grammarAccess.getAltList1Access().getVal3IDTerminalRuleCall_1_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val3",
                            		lv_val3_5_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1258:6: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1258:6: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1258:8: otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )?
                    {
                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAltList12243); 

                        	newLeafNode(otherlv_6, grammarAccess.getAltList1Access().getKw2Keyword_1_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1262:1: ( (lv_val1_7_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1263:1: (lv_val1_7_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1263:1: (lv_val1_7_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1264:3: lv_val1_7_0= RULE_ID
                    {
                    lv_val1_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList12260); 

                    			newLeafNode(lv_val1_7_0, grammarAccess.getAltList1Access().getVal1IDTerminalRuleCall_1_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_7_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1280:2: ( (lv_val4_8_0= RULE_ID ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1281:1: (lv_val4_8_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1281:1: (lv_val4_8_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1282:3: lv_val4_8_0= RULE_ID
                            {
                            lv_val4_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList12282); 

                            			newLeafNode(lv_val4_8_0, grammarAccess.getAltList1Access().getVal4IDTerminalRuleCall_1_2_2_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAltList1Rule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"val4",
                                    		lv_val4_8_0, 
                                    		"ID");
                            	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1306:1: entryRuleAltList2 returns [EObject current=null] : iv_ruleAltList2= ruleAltList2 EOF ;
    public final EObject entryRuleAltList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltList2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1307:2: (iv_ruleAltList2= ruleAltList2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1308:2: iv_ruleAltList2= ruleAltList2 EOF
            {
             newCompositeNode(grammarAccess.getAltList2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAltList2_in_entryRuleAltList22326);
            iv_ruleAltList2=ruleAltList2();

            state._fsp--;

             current =iv_ruleAltList2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAltList22336); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1315:1: ruleAltList2 returns [EObject current=null] : (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1318:28: ( (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1319:1: (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1319:1: (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1319:3: otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAltList22373); 

                	newLeafNode(otherlv_0, grammarAccess.getAltList2Access().getNumberSignDigitNineKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1323:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1323:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1323:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1323:3: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1323:3: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1324:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1324:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1325:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList22392); 

                    			newLeafNode(lv_val1_1_0, grammarAccess.getAltList2Access().getVal1IDTerminalRuleCall_1_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList2Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_1_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1341:2: ( (lv_val2_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1342:1: (lv_val2_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1342:1: (lv_val2_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1343:3: lv_val2_2_0= RULE_ID
                    {
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList22414); 

                    			newLeafNode(lv_val2_2_0, grammarAccess.getAltList2Access().getVal2IDTerminalRuleCall_1_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList2Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val2",
                            		lv_val2_2_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1360:6: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1360:6: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1360:8: otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAltList22439); 

                        	newLeafNode(otherlv_3, grammarAccess.getAltList2Access().getKwKeyword_1_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1364:1: ( (lv_val1_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1365:1: (lv_val1_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1365:1: (lv_val1_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1366:3: lv_val1_4_0= RULE_ID
                    {
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList22456); 

                    			newLeafNode(lv_val1_4_0, grammarAccess.getAltList2Access().getVal1IDTerminalRuleCall_1_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList2Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val1",
                            		lv_val1_4_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1382:2: (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==25) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1382:4: otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) )
                    	    {
                    	    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAltList22474); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getAltList2Access().getCommaKeyword_1_1_2_0());
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1386:1: ( (lv_val1_6_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1387:1: (lv_val1_6_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1387:1: (lv_val1_6_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1388:3: lv_val1_6_0= RULE_ID
                    	    {
                    	    lv_val1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList22491); 

                    	    			newLeafNode(lv_val1_6_0, grammarAccess.getAltList2Access().getVal1IDTerminalRuleCall_1_1_2_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getAltList2Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"val1",
                    	            		lv_val1_6_0, 
                    	            		"ID");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1404:4: ( (lv_val3_7_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1405:1: (lv_val3_7_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1405:1: (lv_val3_7_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1406:3: lv_val3_7_0= RULE_ID
                    {
                    lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList22515); 

                    			newLeafNode(lv_val3_7_0, grammarAccess.getAltList2Access().getVal3IDTerminalRuleCall_1_1_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAltList2Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val3",
                            		lv_val3_7_0, 
                            		"ID");
                    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1430:1: entryRuleSingleKeywords returns [EObject current=null] : iv_ruleSingleKeywords= ruleSingleKeywords EOF ;
    public final EObject entryRuleSingleKeywords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleKeywords = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1431:2: (iv_ruleSingleKeywords= ruleSingleKeywords EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1432:2: iv_ruleSingleKeywords= ruleSingleKeywords EOF
            {
             newCompositeNode(grammarAccess.getSingleKeywordsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleKeywords_in_entryRuleSingleKeywords2558);
            iv_ruleSingleKeywords=ruleSingleKeywords();

            state._fsp--;

             current =iv_ruleSingleKeywords; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleKeywords2568); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1439:1: ruleSingleKeywords returns [EObject current=null] : (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) ;
    public final EObject ruleSingleKeywords() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1442:28: ( (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1443:1: (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1443:1: (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1443:3: otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleSingleKeywords2605); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleKeywordsAccess().getNumberSignDigitOneDigitZeroKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1447:1: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1448:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1448:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1449:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1449:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1450:3: lv_val_1_1= 'kw1'
                    {
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSingleKeywords2625); 

                            newLeafNode(lv_val_1_1, grammarAccess.getSingleKeywordsAccess().getValKw1Keyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "val", lv_val_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1462:8: lv_val_1_2= 'kw2'
                    {
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSingleKeywords2654); 

                            newLeafNode(lv_val_1_2, grammarAccess.getSingleKeywordsAccess().getValKw2Keyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "val", lv_val_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1474:8: lv_val_1_3= 'kw3'
                    {
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleKeywords2683); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1497:1: entryRuleSingleKeywordsOrID returns [EObject current=null] : iv_ruleSingleKeywordsOrID= ruleSingleKeywordsOrID EOF ;
    public final EObject entryRuleSingleKeywordsOrID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleKeywordsOrID = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1498:2: (iv_ruleSingleKeywordsOrID= ruleSingleKeywordsOrID EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1499:2: iv_ruleSingleKeywordsOrID= ruleSingleKeywordsOrID EOF
            {
             newCompositeNode(grammarAccess.getSingleKeywordsOrIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleKeywordsOrID_in_entryRuleSingleKeywordsOrID2735);
            iv_ruleSingleKeywordsOrID=ruleSingleKeywordsOrID();

            state._fsp--;

             current =iv_ruleSingleKeywordsOrID; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleKeywordsOrID2745); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1506:1: ruleSingleKeywordsOrID returns [EObject current=null] : (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) ;
    public final EObject ruleSingleKeywordsOrID() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;
        Token lv_val_1_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1509:28: ( (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1510:1: (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1510:1: (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1510:3: otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleSingleKeywordsOrID2782); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleKeywordsOrIDAccess().getNumberSignDigitOneDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1514:1: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1515:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1515:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1516:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1516:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1517:3: lv_val_1_1= 'kw1'
                    {
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSingleKeywordsOrID2802); 

                            newLeafNode(lv_val_1_1, grammarAccess.getSingleKeywordsOrIDAccess().getValKw1Keyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsOrIDRule());
                    	        }
                           		setWithLastConsumed(current, "val", lv_val_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1529:8: lv_val_1_2= 'kw2'
                    {
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSingleKeywordsOrID2831); 

                            newLeafNode(lv_val_1_2, grammarAccess.getSingleKeywordsOrIDAccess().getValKw2Keyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsOrIDRule());
                    	        }
                           		setWithLastConsumed(current, "val", lv_val_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1541:8: lv_val_1_3= 'kw3'
                    {
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleKeywordsOrID2860); 

                            newLeafNode(lv_val_1_3, grammarAccess.getSingleKeywordsOrIDAccess().getValKw3Keyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsOrIDRule());
                    	        }
                           		setWithLastConsumed(current, "val", lv_val_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1553:8: lv_val_1_4= RULE_ID
                    {
                    lv_val_1_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleKeywordsOrID2888); 

                    			newLeafNode(lv_val_1_4, grammarAccess.getSingleKeywordsOrIDAccess().getValIDTerminalRuleCall_1_0_3()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleKeywordsOrIDRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_4, 
                            		"ID");
                    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1579:1: entryRuleSingleTerminals returns [EObject current=null] : iv_ruleSingleTerminals= ruleSingleTerminals EOF ;
    public final EObject entryRuleSingleTerminals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleTerminals = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1580:2: (iv_ruleSingleTerminals= ruleSingleTerminals EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1581:2: iv_ruleSingleTerminals= ruleSingleTerminals EOF
            {
             newCompositeNode(grammarAccess.getSingleTerminalsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleTerminals_in_entryRuleSingleTerminals2932);
            iv_ruleSingleTerminals=ruleSingleTerminals();

            state._fsp--;

             current =iv_ruleSingleTerminals; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleTerminals2942); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1588:1: ruleSingleTerminals returns [EObject current=null] : (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) ;
    public final EObject ruleSingleTerminals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1591:28: ( (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1592:1: (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1592:1: (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1592:3: otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            {
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleSingleTerminals2979); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleTerminalsAccess().getNumberSignDigitOneDigitTwoKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1596:1: ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1597:1: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1597:1: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1598:1: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1598:1: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1599:3: lv_val_1_1= RULE_ID1
                    {
                    lv_val_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_RULE_ID1_in_ruleSingleTerminals2998); 

                    			newLeafNode(lv_val_1_1, grammarAccess.getSingleTerminalsAccess().getValID1TerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleTerminalsRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_1, 
                            		"ID1");
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1614:8: lv_val_1_2= RULE_ID2
                    {
                    lv_val_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_RULE_ID2_in_ruleSingleTerminals3018); 

                    			newLeafNode(lv_val_1_2, grammarAccess.getSingleTerminalsAccess().getValID2TerminalRuleCall_1_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleTerminalsRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_2, 
                            		"ID2");
                    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1640:1: entryRuleSingleEnum returns [EObject current=null] : iv_ruleSingleEnum= ruleSingleEnum EOF ;
    public final EObject entryRuleSingleEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleEnum = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1641:2: (iv_ruleSingleEnum= ruleSingleEnum EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1642:2: iv_ruleSingleEnum= ruleSingleEnum EOF
            {
             newCompositeNode(grammarAccess.getSingleEnumRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleEnum_in_entryRuleSingleEnum3062);
            iv_ruleSingleEnum=ruleSingleEnum();

            state._fsp--;

             current =iv_ruleSingleEnum; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleEnum3072); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1649:1: ruleSingleEnum returns [EObject current=null] : (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) ) ;
    public final EObject ruleSingleEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_val_1_1 = null;

        Enumerator lv_val_1_2 = null;

        Enumerator lv_val_1_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1652:28: ( (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1653:1: (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1653:1: (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1653:3: otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) )
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSingleEnum3109); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleEnumAccess().getNumberSignDigitOneDigitThreeKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1657:1: ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1658:1: ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1658:1: ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1659:1: (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1659:1: (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1660:3: lv_val_1_1= ruleDefEnum1
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleEnumAccess().getValDefEnum1EnumRuleCall_1_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDefEnum1_in_ruleSingleEnum3132);
                    lv_val_1_1=ruleDefEnum1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleEnumRule());
                    	        }
                           		set(
                           			current, 
                           			"val",
                            		lv_val_1_1, 
                            		"DefEnum1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1675:8: lv_val_1_2= ruleDefEnum2
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleEnumAccess().getValDefEnum2EnumRuleCall_1_0_1()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDefEnum2_in_ruleSingleEnum3151);
                    lv_val_1_2=ruleDefEnum2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleEnumRule());
                    	        }
                           		set(
                           			current, 
                           			"val",
                            		lv_val_1_2, 
                            		"DefEnum2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1690:8: lv_val_1_3= ruleDefEnum3
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleEnumAccess().getValDefEnum3EnumRuleCall_1_0_2()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDefEnum3_in_ruleSingleEnum3170);
                    lv_val_1_3=ruleDefEnum3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleEnumRule());
                    	        }
                           		set(
                           			current, 
                           			"val",
                            		lv_val_1_3, 
                            		"DefEnum3");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1716:1: entryRuleSingleCrossReference returns [EObject current=null] : iv_ruleSingleCrossReference= ruleSingleCrossReference EOF ;
    public final EObject entryRuleSingleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleCrossReference = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1717:2: (iv_ruleSingleCrossReference= ruleSingleCrossReference EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1718:2: iv_ruleSingleCrossReference= ruleSingleCrossReference EOF
            {
             newCompositeNode(grammarAccess.getSingleCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference3209);
            iv_ruleSingleCrossReference=ruleSingleCrossReference();

            state._fsp--;

             current =iv_ruleSingleCrossReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleCrossReference3219); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1725:1: ruleSingleCrossReference returns [EObject current=null] : (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1728:28: ( (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1729:1: (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1729:1: (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1729:3: otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) )
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleSingleCrossReference3256); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleCrossReferenceAccess().getNumberSignDigitOneDigitFourKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1733:1: ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1734:1: ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1734:1: ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1735:1: (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1735:1: (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1736:3: lv_name_1_1= RULE_ID1
                    {
                    lv_name_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_RULE_ID1_in_ruleSingleCrossReference3275); 

                    			newLeafNode(lv_name_1_1, grammarAccess.getSingleCrossReferenceAccess().getNameID1TerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_1, 
                            		"ID1");
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1751:8: lv_name_1_2= RULE_ID2
                    {
                    lv_name_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_RULE_ID2_in_ruleSingleCrossReference3295); 

                    			newLeafNode(lv_name_1_2, grammarAccess.getSingleCrossReferenceAccess().getNameID2TerminalRuleCall_1_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_2, 
                            		"ID2");
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1766:8: lv_name_1_3= RULE_ID3
                    {
                    lv_name_1_3=(Token)match(input,RULE_ID3,FollowSets000.FOLLOW_RULE_ID3_in_ruleSingleCrossReference3315); 

                    			newLeafNode(lv_name_1_3, grammarAccess.getSingleCrossReferenceAccess().getNameID3TerminalRuleCall_1_0_2()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_3, 
                            		"ID3");
                    	    

                    }
                    break;

            }


            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1784:2: ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1784:3: ( (otherlv_2= RULE_ID1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1784:3: ( (otherlv_2= RULE_ID1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1785:1: (otherlv_2= RULE_ID1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1785:1: (otherlv_2= RULE_ID1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1786:3: otherlv_2= RULE_ID1
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_RULE_ID1_in_ruleSingleCrossReference3344); 

                    		newLeafNode(otherlv_2, grammarAccess.getSingleCrossReferenceAccess().getRefSingleCrossReferenceCrossReference_2_0_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1798:6: ( (otherlv_3= RULE_ID2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1798:6: ( (otherlv_3= RULE_ID2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1799:1: (otherlv_3= RULE_ID2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1799:1: (otherlv_3= RULE_ID2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1800:3: otherlv_3= RULE_ID2
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_RULE_ID2_in_ruleSingleCrossReference3370); 

                    		newLeafNode(otherlv_3, grammarAccess.getSingleCrossReferenceAccess().getRefSingleCrossReferenceCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1812:6: ( (otherlv_4= RULE_ID3 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1812:6: ( (otherlv_4= RULE_ID3 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1813:1: (otherlv_4= RULE_ID3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1813:1: (otherlv_4= RULE_ID3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1814:3: otherlv_4= RULE_ID3
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleCrossReferenceRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID3,FollowSets000.FOLLOW_RULE_ID3_in_ruleSingleCrossReference3396); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1833:1: entryRuleSingleContainmentReference returns [EObject current=null] : iv_ruleSingleContainmentReference= ruleSingleContainmentReference EOF ;
    public final EObject entryRuleSingleContainmentReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleContainmentReference = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1834:2: (iv_ruleSingleContainmentReference= ruleSingleContainmentReference EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1835:2: iv_ruleSingleContainmentReference= ruleSingleContainmentReference EOF
            {
             newCompositeNode(grammarAccess.getSingleContainmentReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReference_in_entryRuleSingleContainmentReference3433);
            iv_ruleSingleContainmentReference=ruleSingleContainmentReference();

            state._fsp--;

             current =iv_ruleSingleContainmentReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleContainmentReference3443); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1842:1: ruleSingleContainmentReference returns [EObject current=null] : (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) ) ;
    public final EObject ruleSingleContainmentReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_child_1_1 = null;

        EObject lv_child_1_2 = null;

        EObject lv_child_1_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1845:28: ( (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1846:1: (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1846:1: (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1846:3: otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) )
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleSingleContainmentReference3480); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleContainmentReferenceAccess().getNumberSignDigitOneDigitFiveKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1850:1: ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1851:1: ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1851:1: ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1852:1: (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1852:1: (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1853:3: lv_child_1_1= ruleSingleContainmentReferenceChild1
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleContainmentReferenceAccess().getChildSingleContainmentReferenceChild1ParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReferenceChild1_in_ruleSingleContainmentReference3503);
                    lv_child_1_1=ruleSingleContainmentReferenceChild1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleContainmentReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"child",
                            		lv_child_1_1, 
                            		"SingleContainmentReferenceChild1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1868:8: lv_child_1_2= ruleSingleContainmentReferenceChild2
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleContainmentReferenceAccess().getChildSingleContainmentReferenceChild2ParserRuleCall_1_0_1()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReferenceChild2_in_ruleSingleContainmentReference3522);
                    lv_child_1_2=ruleSingleContainmentReferenceChild2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleContainmentReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"child",
                            		lv_child_1_2, 
                            		"SingleContainmentReferenceChild2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1883:8: lv_child_1_3= ruleSingleContainmentReferenceChild3
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleContainmentReferenceAccess().getChildSingleContainmentReferenceChild3ParserRuleCall_1_0_2()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReferenceChild3_in_ruleSingleContainmentReference3541);
                    lv_child_1_3=ruleSingleContainmentReferenceChild3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleContainmentReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"child",
                            		lv_child_1_3, 
                            		"SingleContainmentReferenceChild3");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1909:1: entryRuleSingleContainmentReferenceChild1 returns [EObject current=null] : iv_ruleSingleContainmentReferenceChild1= ruleSingleContainmentReferenceChild1 EOF ;
    public final EObject entryRuleSingleContainmentReferenceChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleContainmentReferenceChild1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1910:2: (iv_ruleSingleContainmentReferenceChild1= ruleSingleContainmentReferenceChild1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1911:2: iv_ruleSingleContainmentReferenceChild1= ruleSingleContainmentReferenceChild1 EOF
            {
             newCompositeNode(grammarAccess.getSingleContainmentReferenceChild1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReferenceChild1_in_entryRuleSingleContainmentReferenceChild13580);
            iv_ruleSingleContainmentReferenceChild1=ruleSingleContainmentReferenceChild1();

            state._fsp--;

             current =iv_ruleSingleContainmentReferenceChild1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleContainmentReferenceChild13590); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1918:1: ruleSingleContainmentReferenceChild1 returns [EObject current=null] : ( (lv_val_0_0= 'kw1' ) ) ;
    public final EObject ruleSingleContainmentReferenceChild1() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1921:28: ( ( (lv_val_0_0= 'kw1' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1922:1: ( (lv_val_0_0= 'kw1' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1922:1: ( (lv_val_0_0= 'kw1' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1923:1: (lv_val_0_0= 'kw1' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1923:1: (lv_val_0_0= 'kw1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1924:3: lv_val_0_0= 'kw1'
            {
            lv_val_0_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSingleContainmentReferenceChild13632); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1945:1: entryRuleSingleContainmentReferenceChild2 returns [EObject current=null] : iv_ruleSingleContainmentReferenceChild2= ruleSingleContainmentReferenceChild2 EOF ;
    public final EObject entryRuleSingleContainmentReferenceChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleContainmentReferenceChild2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1946:2: (iv_ruleSingleContainmentReferenceChild2= ruleSingleContainmentReferenceChild2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1947:2: iv_ruleSingleContainmentReferenceChild2= ruleSingleContainmentReferenceChild2 EOF
            {
             newCompositeNode(grammarAccess.getSingleContainmentReferenceChild2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReferenceChild2_in_entryRuleSingleContainmentReferenceChild23680);
            iv_ruleSingleContainmentReferenceChild2=ruleSingleContainmentReferenceChild2();

            state._fsp--;

             current =iv_ruleSingleContainmentReferenceChild2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleContainmentReferenceChild23690); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1954:1: ruleSingleContainmentReferenceChild2 returns [EObject current=null] : ( (lv_val_0_0= 'kw2' ) ) ;
    public final EObject ruleSingleContainmentReferenceChild2() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1957:28: ( ( (lv_val_0_0= 'kw2' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1958:1: ( (lv_val_0_0= 'kw2' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1958:1: ( (lv_val_0_0= 'kw2' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1959:1: (lv_val_0_0= 'kw2' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1959:1: (lv_val_0_0= 'kw2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1960:3: lv_val_0_0= 'kw2'
            {
            lv_val_0_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSingleContainmentReferenceChild23732); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1981:1: entryRuleSingleContainmentReferenceChild3 returns [EObject current=null] : iv_ruleSingleContainmentReferenceChild3= ruleSingleContainmentReferenceChild3 EOF ;
    public final EObject entryRuleSingleContainmentReferenceChild3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleContainmentReferenceChild3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1982:2: (iv_ruleSingleContainmentReferenceChild3= ruleSingleContainmentReferenceChild3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1983:2: iv_ruleSingleContainmentReferenceChild3= ruleSingleContainmentReferenceChild3 EOF
            {
             newCompositeNode(grammarAccess.getSingleContainmentReferenceChild3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReferenceChild3_in_entryRuleSingleContainmentReferenceChild33780);
            iv_ruleSingleContainmentReferenceChild3=ruleSingleContainmentReferenceChild3();

            state._fsp--;

             current =iv_ruleSingleContainmentReferenceChild3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleContainmentReferenceChild33790); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1990:1: ruleSingleContainmentReferenceChild3 returns [EObject current=null] : ( (lv_val_0_0= 'kw3' ) ) ;
    public final EObject ruleSingleContainmentReferenceChild3() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1993:28: ( ( (lv_val_0_0= 'kw3' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1994:1: ( (lv_val_0_0= 'kw3' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1994:1: ( (lv_val_0_0= 'kw3' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1995:1: (lv_val_0_0= 'kw3' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1995:1: (lv_val_0_0= 'kw3' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:1996:3: lv_val_0_0= 'kw3'
            {
            lv_val_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleContainmentReferenceChild33832); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2017:1: entryRuleMultiKeywords returns [EObject current=null] : iv_ruleMultiKeywords= ruleMultiKeywords EOF ;
    public final EObject entryRuleMultiKeywords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiKeywords = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2018:2: (iv_ruleMultiKeywords= ruleMultiKeywords EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2019:2: iv_ruleMultiKeywords= ruleMultiKeywords EOF
            {
             newCompositeNode(grammarAccess.getMultiKeywordsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiKeywords_in_entryRuleMultiKeywords3880);
            iv_ruleMultiKeywords=ruleMultiKeywords();

            state._fsp--;

             current =iv_ruleMultiKeywords; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiKeywords3890); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2026:1: ruleMultiKeywords returns [EObject current=null] : (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) ;
    public final EObject ruleMultiKeywords() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2029:28: ( (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2030:1: (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2030:1: (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2030:3: otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleMultiKeywords3927); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiKeywordsAccess().getNumberSignDigitOneDigitSixKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2034:1: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2035:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2035:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2036:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2036:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2037:3: lv_val_1_1= 'kw1'
                    {
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiKeywords3947); 

                            newLeafNode(lv_val_1_1, grammarAccess.getMultiKeywordsAccess().getValKw1Keyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsRule());
                    	        }
                           		addWithLastConsumed(current, "val", lv_val_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2049:8: lv_val_1_2= 'kw2'
                    {
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiKeywords3976); 

                            newLeafNode(lv_val_1_2, grammarAccess.getMultiKeywordsAccess().getValKw2Keyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsRule());
                    	        }
                           		addWithLastConsumed(current, "val", lv_val_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2061:8: lv_val_1_3= 'kw3'
                    {
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMultiKeywords4005); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2084:1: entryRuleMultiKeywordsOrID returns [EObject current=null] : iv_ruleMultiKeywordsOrID= ruleMultiKeywordsOrID EOF ;
    public final EObject entryRuleMultiKeywordsOrID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiKeywordsOrID = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2085:2: (iv_ruleMultiKeywordsOrID= ruleMultiKeywordsOrID EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2086:2: iv_ruleMultiKeywordsOrID= ruleMultiKeywordsOrID EOF
            {
             newCompositeNode(grammarAccess.getMultiKeywordsOrIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiKeywordsOrID_in_entryRuleMultiKeywordsOrID4057);
            iv_ruleMultiKeywordsOrID=ruleMultiKeywordsOrID();

            state._fsp--;

             current =iv_ruleMultiKeywordsOrID; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiKeywordsOrID4067); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2093:1: ruleMultiKeywordsOrID returns [EObject current=null] : (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) ;
    public final EObject ruleMultiKeywordsOrID() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;
        Token lv_val_1_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2096:28: ( (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2097:1: (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2097:1: (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2097:3: otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            {
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleMultiKeywordsOrID4104); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiKeywordsOrIDAccess().getNumberSignDigitOneDigitSevenKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2101:1: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2102:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2102:1: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2103:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2103:1: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2104:3: lv_val_1_1= 'kw1'
                    {
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiKeywordsOrID4124); 

                            newLeafNode(lv_val_1_1, grammarAccess.getMultiKeywordsOrIDAccess().getValKw1Keyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsOrIDRule());
                    	        }
                           		addWithLastConsumed(current, "val", lv_val_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2116:8: lv_val_1_2= 'kw2'
                    {
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiKeywordsOrID4153); 

                            newLeafNode(lv_val_1_2, grammarAccess.getMultiKeywordsOrIDAccess().getValKw2Keyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsOrIDRule());
                    	        }
                           		addWithLastConsumed(current, "val", lv_val_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2128:8: lv_val_1_3= 'kw3'
                    {
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMultiKeywordsOrID4182); 

                            newLeafNode(lv_val_1_3, grammarAccess.getMultiKeywordsOrIDAccess().getValKw3Keyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsOrIDRule());
                    	        }
                           		addWithLastConsumed(current, "val", lv_val_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2140:8: lv_val_1_4= RULE_ID
                    {
                    lv_val_1_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMultiKeywordsOrID4210); 

                    			newLeafNode(lv_val_1_4, grammarAccess.getMultiKeywordsOrIDAccess().getValIDTerminalRuleCall_1_0_3()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiKeywordsOrIDRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_4, 
                            		"ID");
                    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2166:1: entryRuleMultiTerminals returns [EObject current=null] : iv_ruleMultiTerminals= ruleMultiTerminals EOF ;
    public final EObject entryRuleMultiTerminals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiTerminals = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2167:2: (iv_ruleMultiTerminals= ruleMultiTerminals EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2168:2: iv_ruleMultiTerminals= ruleMultiTerminals EOF
            {
             newCompositeNode(grammarAccess.getMultiTerminalsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiTerminals_in_entryRuleMultiTerminals4254);
            iv_ruleMultiTerminals=ruleMultiTerminals();

            state._fsp--;

             current =iv_ruleMultiTerminals; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiTerminals4264); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2175:1: ruleMultiTerminals returns [EObject current=null] : (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) ;
    public final EObject ruleMultiTerminals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2178:28: ( (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2179:1: (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2179:1: (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2179:3: otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleMultiTerminals4301); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiTerminalsAccess().getNumberSignDigitOneDigitEightKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2183:1: ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2184:1: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2184:1: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2185:1: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2185:1: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2186:3: lv_val_1_1= RULE_ID1
                    {
                    lv_val_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_RULE_ID1_in_ruleMultiTerminals4320); 

                    			newLeafNode(lv_val_1_1, grammarAccess.getMultiTerminalsAccess().getValID1TerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiTerminalsRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_1, 
                            		"ID1");
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2201:8: lv_val_1_2= RULE_ID2
                    {
                    lv_val_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_RULE_ID2_in_ruleMultiTerminals4340); 

                    			newLeafNode(lv_val_1_2, grammarAccess.getMultiTerminalsAccess().getValID2TerminalRuleCall_1_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiTerminalsRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_2, 
                            		"ID2");
                    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2227:1: entryRuleDependentAlternative1 returns [EObject current=null] : iv_ruleDependentAlternative1= ruleDependentAlternative1 EOF ;
    public final EObject entryRuleDependentAlternative1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependentAlternative1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2228:2: (iv_ruleDependentAlternative1= ruleDependentAlternative1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2229:2: iv_ruleDependentAlternative1= ruleDependentAlternative1 EOF
            {
             newCompositeNode(grammarAccess.getDependentAlternative1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDependentAlternative1_in_entryRuleDependentAlternative14384);
            iv_ruleDependentAlternative1=ruleDependentAlternative1();

            state._fsp--;

             current =iv_ruleDependentAlternative1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDependentAlternative14394); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2236:1: ruleDependentAlternative1 returns [EObject current=null] : (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) ) ;
    public final EObject ruleDependentAlternative1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token lv_val_2_0=null;
        Token lv_flag_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2239:28: ( (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2240:1: (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2240:1: (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2240:3: otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) )
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleDependentAlternative14431); 

                	newLeafNode(otherlv_0, grammarAccess.getDependentAlternative1Access().getNumberSignDigitOneDigitNineKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2244:1: ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==16) ) {
                    alt29=2;
                }
                else if ( (LA29_1==EOF) ) {
                    alt29=1;
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2244:2: ( (lv_val_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2244:2: ( (lv_val_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2245:1: (lv_val_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2245:1: (lv_val_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2246:3: lv_val_1_0= RULE_ID
                    {
                    lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDependentAlternative14449); 

                    			newLeafNode(lv_val_1_0, grammarAccess.getDependentAlternative1Access().getValIDTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDependentAlternative1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2263:6: ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2263:6: ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2263:7: ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2263:7: ( (lv_val_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2264:1: (lv_val_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2264:1: (lv_val_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2265:3: lv_val_2_0= RULE_ID
                    {
                    lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDependentAlternative14478); 

                    			newLeafNode(lv_val_2_0, grammarAccess.getDependentAlternative1Access().getValIDTerminalRuleCall_1_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDependentAlternative1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2281:2: ( (lv_flag_3_0= 'kw1' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2282:1: (lv_flag_3_0= 'kw1' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2282:1: (lv_flag_3_0= 'kw1' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2283:3: lv_flag_3_0= 'kw1'
                    {
                    lv_flag_3_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDependentAlternative14501); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2304:1: entryRuleDependentAlternative2 returns [EObject current=null] : iv_ruleDependentAlternative2= ruleDependentAlternative2 EOF ;
    public final EObject entryRuleDependentAlternative2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependentAlternative2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2305:2: (iv_ruleDependentAlternative2= ruleDependentAlternative2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2306:2: iv_ruleDependentAlternative2= ruleDependentAlternative2 EOF
            {
             newCompositeNode(grammarAccess.getDependentAlternative2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDependentAlternative2_in_entryRuleDependentAlternative24552);
            iv_ruleDependentAlternative2=ruleDependentAlternative2();

            state._fsp--;

             current =iv_ruleDependentAlternative2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDependentAlternative24562); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2313:1: ruleDependentAlternative2 returns [EObject current=null] : (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) ) ;
    public final EObject ruleDependentAlternative2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token lv_val_2_0=null;
        Token lv_val_3_0=null;
        Token lv_flag_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2316:28: ( (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2317:1: (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2317:1: (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2317:3: otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleDependentAlternative24599); 

                	newLeafNode(otherlv_0, grammarAccess.getDependentAlternative2Access().getNumberSignDigitTwoDigitZeroKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2321:1: ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2321:2: ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2321:2: ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2321:3: ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2321:3: ( (lv_val_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2322:1: (lv_val_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2322:1: (lv_val_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2323:3: lv_val_1_0= RULE_ID
                    {
                    lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDependentAlternative24618); 

                    			newLeafNode(lv_val_1_0, grammarAccess.getDependentAlternative2Access().getValIDTerminalRuleCall_1_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDependentAlternative2Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2339:2: ( (lv_val_2_0= RULE_ID ) )+
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2340:1: (lv_val_2_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2340:1: (lv_val_2_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2341:3: lv_val_2_0= RULE_ID
                    	    {
                    	    lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDependentAlternative24640); 

                    	    			newLeafNode(lv_val_2_0, grammarAccess.getDependentAlternative2Access().getValIDTerminalRuleCall_1_0_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getDependentAlternative2Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"val",
                    	            		lv_val_2_0, 
                    	            		"ID");
                    	    	    

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2358:6: ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2358:6: ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2358:7: ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2358:7: ( (lv_val_3_0= RULE_ID ) )+
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2359:1: (lv_val_3_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2359:1: (lv_val_3_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2360:3: lv_val_3_0= RULE_ID
                    	    {
                    	    lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDependentAlternative24671); 

                    	    			newLeafNode(lv_val_3_0, grammarAccess.getDependentAlternative2Access().getValIDTerminalRuleCall_1_1_0_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getDependentAlternative2Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"val",
                    	            		lv_val_3_0, 
                    	            		"ID");
                    	    	    

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2376:3: ( (lv_flag_4_0= 'kw1' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2377:1: (lv_flag_4_0= 'kw1' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2377:1: (lv_flag_4_0= 'kw1' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2378:3: lv_flag_4_0= 'kw1'
                    {
                    lv_flag_4_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDependentAlternative24695); 

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


    // $ANTLR start "ruleDefEnum1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2399:1: ruleDefEnum1 returns [Enumerator current=null] : (enumLiteral_0= 'kw1' ) ;
    public final Enumerator ruleDefEnum1() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2401:28: ( (enumLiteral_0= 'kw1' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2402:1: (enumLiteral_0= 'kw1' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2402:1: (enumLiteral_0= 'kw1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2402:3: enumLiteral_0= 'kw1'
            {
            enumLiteral_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDefEnum14759); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2412:1: ruleDefEnum2 returns [Enumerator current=null] : (enumLiteral_0= 'kw2' ) ;
    public final Enumerator ruleDefEnum2() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2414:28: ( (enumLiteral_0= 'kw2' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2415:1: (enumLiteral_0= 'kw2' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2415:1: (enumLiteral_0= 'kw2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2415:3: enumLiteral_0= 'kw2'
            {
            enumLiteral_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDefEnum24802); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2425:1: ruleDefEnum3 returns [Enumerator current=null] : (enumLiteral_0= 'kw3' ) ;
    public final Enumerator ruleDefEnum3() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2427:28: ( (enumLiteral_0= 'kw3' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2428:1: (enumLiteral_0= 'kw3' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2428:1: (enumLiteral_0= 'kw3' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalSequencerTestLanguage.g:2428:3: enumLiteral_0= 'kw3'
            {
            enumLiteral_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleDefEnum34845); 

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
    static final String DFA32_eotS =
        "\5\uffff";
    static final String DFA32_eofS =
        "\2\uffff\1\4\2\uffff";
    static final String DFA32_minS =
        "\3\4\2\uffff";
    static final String DFA32_maxS =
        "\1\4\2\20\2\uffff";
    static final String DFA32_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA32_specialS =
        "\5\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\1",
            "\1\2\13\uffff\1\3",
            "\1\2\13\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "2321:1: ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleGroup_in_ruleModel131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAlternative_in_ruleModel158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicities_in_ruleModel185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupMultiplicities_in_ruleModel212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeMultiplicities_in_ruleModel239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList1_in_ruleModel266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList2_in_ruleModel293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList1_in_ruleModel320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList2_in_ruleModel347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleKeywords_in_ruleModel374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleKeywordsOrID_in_ruleModel401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleTerminals_in_ruleModel428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiKeywords_in_ruleModel455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiKeywordsOrID_in_ruleModel482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiTerminals_in_ruleModel509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleEnum_in_ruleModel536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleCrossReference_in_ruleModel563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReference_in_ruleModel590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDependentAlternative1_in_ruleModel617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDependentAlternative2_in_ruleModel644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup680 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleGroup690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSimpleGroup727 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup744 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative807 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAlternative817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSimpleAlternative854 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_16_in_ruleSimpleAlternative868 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSimpleAlternative910 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities970 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleMultiplicities980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleSimpleMultiplicities1017 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1034 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleSimpleMultiplicities1051 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1068 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleSimpleMultiplicities1086 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1103 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_19_in_ruleSimpleMultiplicities1121 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1138 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities1180 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupMultiplicities1190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleGroupMultiplicities1227 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1244 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleGroupMultiplicities1261 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1279 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1301 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleGroupMultiplicities1320 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1338 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1360 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_19_in_ruleGroupMultiplicities1379 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1397 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1419 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities1462 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeMultiplicities1472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAlternativeMultiplicities1509 = new BitSet(new long[]{0x0000000000030010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1527 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_16_in_ruleAlternativeMultiplicities1551 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1568 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleAlternativeMultiplicities1588 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1606 = new BitSet(new long[]{0x0000000000480010L});
        public static final BitSet FOLLOW_19_in_ruleAlternativeMultiplicities1630 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1647 = new BitSet(new long[]{0x0000000000480010L});
        public static final BitSet FOLLOW_22_in_ruleAlternativeMultiplicities1667 = new BitSet(new long[]{0x0000000000800012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1685 = new BitSet(new long[]{0x0000000000800012L});
        public static final BitSet FOLLOW_23_in_ruleAlternativeMultiplicities1709 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1726 = new BitSet(new long[]{0x0000000000800012L});
        public static final BitSet FOLLOW_ruleList1_in_entryRuleList11770 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList11780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleList11817 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList11834 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleList11852 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList11869 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleList2_in_entryRuleList21912 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList21922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleList21959 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList21986 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleList22004 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList22021 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleAltList1_in_entryRuleAltList12066 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAltList12076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleAltList12113 = new BitSet(new long[]{0x0000000000030010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList12132 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList12154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleAltList12179 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList12196 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList12218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleAltList12243 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList12260 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList12282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList2_in_entryRuleAltList22326 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAltList22336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleAltList22373 = new BitSet(new long[]{0x0000000020000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList22392 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList22414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleAltList22439 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList22456 = new BitSet(new long[]{0x0000000002000010L});
        public static final BitSet FOLLOW_25_in_ruleAltList22474 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList22491 = new BitSet(new long[]{0x0000000002000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList22515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleKeywords_in_entryRuleSingleKeywords2558 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleKeywords2568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleSingleKeywords2605 = new BitSet(new long[]{0x00000000000B0000L});
        public static final BitSet FOLLOW_16_in_ruleSingleKeywords2625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSingleKeywords2654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleSingleKeywords2683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleKeywordsOrID_in_entryRuleSingleKeywordsOrID2735 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleKeywordsOrID2745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleSingleKeywordsOrID2782 = new BitSet(new long[]{0x00000000000B0010L});
        public static final BitSet FOLLOW_16_in_ruleSingleKeywordsOrID2802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSingleKeywordsOrID2831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleSingleKeywordsOrID2860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleKeywordsOrID2888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleTerminals_in_entryRuleSingleTerminals2932 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleTerminals2942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleSingleTerminals2979 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_RULE_ID1_in_ruleSingleTerminals2998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID2_in_ruleSingleTerminals3018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleEnum_in_entryRuleSingleEnum3062 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleEnum3072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSingleEnum3109 = new BitSet(new long[]{0x00000000000B0000L});
        public static final BitSet FOLLOW_ruleDefEnum1_in_ruleSingleEnum3132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefEnum2_in_ruleSingleEnum3151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefEnum3_in_ruleSingleEnum3170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference3209 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleCrossReference3219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleSingleCrossReference3256 = new BitSet(new long[]{0x00000000000000E0L});
        public static final BitSet FOLLOW_RULE_ID1_in_ruleSingleCrossReference3275 = new BitSet(new long[]{0x00000000000000E0L});
        public static final BitSet FOLLOW_RULE_ID2_in_ruleSingleCrossReference3295 = new BitSet(new long[]{0x00000000000000E0L});
        public static final BitSet FOLLOW_RULE_ID3_in_ruleSingleCrossReference3315 = new BitSet(new long[]{0x00000000000000E0L});
        public static final BitSet FOLLOW_RULE_ID1_in_ruleSingleCrossReference3344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID2_in_ruleSingleCrossReference3370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID3_in_ruleSingleCrossReference3396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReference_in_entryRuleSingleContainmentReference3433 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleContainmentReference3443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleSingleContainmentReference3480 = new BitSet(new long[]{0x00000000000B0000L});
        public static final BitSet FOLLOW_ruleSingleContainmentReferenceChild1_in_ruleSingleContainmentReference3503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReferenceChild2_in_ruleSingleContainmentReference3522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReferenceChild3_in_ruleSingleContainmentReference3541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReferenceChild1_in_entryRuleSingleContainmentReferenceChild13580 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleContainmentReferenceChild13590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleSingleContainmentReferenceChild13632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReferenceChild2_in_entryRuleSingleContainmentReferenceChild23680 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleContainmentReferenceChild23690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSingleContainmentReferenceChild23732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReferenceChild3_in_entryRuleSingleContainmentReferenceChild33780 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleContainmentReferenceChild33790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleSingleContainmentReferenceChild33832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiKeywords_in_entryRuleMultiKeywords3880 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiKeywords3890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleMultiKeywords3927 = new BitSet(new long[]{0x00000000000B0000L});
        public static final BitSet FOLLOW_16_in_ruleMultiKeywords3947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMultiKeywords3976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleMultiKeywords4005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiKeywordsOrID_in_entryRuleMultiKeywordsOrID4057 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiKeywordsOrID4067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleMultiKeywordsOrID4104 = new BitSet(new long[]{0x00000000000B0010L});
        public static final BitSet FOLLOW_16_in_ruleMultiKeywordsOrID4124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMultiKeywordsOrID4153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleMultiKeywordsOrID4182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMultiKeywordsOrID4210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiTerminals_in_entryRuleMultiTerminals4254 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiTerminals4264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleMultiTerminals4301 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_RULE_ID1_in_ruleMultiTerminals4320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID2_in_ruleMultiTerminals4340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDependentAlternative1_in_entryRuleDependentAlternative14384 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDependentAlternative14394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleDependentAlternative14431 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDependentAlternative14449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDependentAlternative14478 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDependentAlternative14501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDependentAlternative2_in_entryRuleDependentAlternative24552 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDependentAlternative24562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleDependentAlternative24599 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDependentAlternative24618 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDependentAlternative24640 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDependentAlternative24671 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleDependentAlternative24695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleDefEnum14759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleDefEnum24802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleDefEnum34845 = new BitSet(new long[]{0x0000000000000002L});
    }


}