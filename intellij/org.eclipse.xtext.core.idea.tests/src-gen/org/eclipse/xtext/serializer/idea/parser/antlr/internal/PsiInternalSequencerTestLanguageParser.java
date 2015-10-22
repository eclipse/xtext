package org.eclipse.xtext.serializer.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.serializer.services.SequencerTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalSequencerTestLanguageParser extends AbstractPsiAntlrParser {
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


        public PsiInternalSequencerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalSequencerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalSequencerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalSequencerTestLanguage.g"; }



    	protected SequencerTestLanguageGrammarAccess grammarAccess;

    	protected SequencerTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalSequencerTestLanguageParser(PsiBuilder builder, TokenStream input, SequencerTestLanguageElementTypeProvider elementTypeProvider, SequencerTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalSequencerTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalSequencerTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalSequencerTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalSequencerTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) | ( (lv_x33_32_0= ruleFragmentCaller ) ) | ( (lv_x34_33_0= ruleParameterCaller ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_x1_0_0 = null;

        Boolean lv_x2_1_0 = null;

        Boolean lv_x3_2_0 = null;

        Boolean lv_x4_3_0 = null;

        Boolean lv_x5_4_0 = null;

        Boolean lv_x6_5_0 = null;

        Boolean lv_x7_6_0 = null;

        Boolean lv_x8_7_0 = null;

        Boolean lv_x9_8_0 = null;

        Boolean lv_x10_9_0 = null;

        Boolean lv_x11_10_0 = null;

        Boolean lv_x12_11_0 = null;

        Boolean lv_x10_12_0 = null;

        Boolean lv_x11_13_0 = null;

        Boolean lv_x12_14_0 = null;

        Boolean lv_x13_15_0 = null;

        Boolean lv_x14_16_0 = null;

        Boolean lv_x15_17_0 = null;

        Boolean lv_x19_18_0 = null;

        Boolean lv_x20_19_0 = null;

        Boolean lv_x21_20_0 = null;

        Boolean lv_x22_21_0 = null;

        Boolean lv_x23_22_0 = null;

        Boolean lv_x24_23_0 = null;

        Boolean lv_x25_24_0 = null;

        Boolean lv_x26_25_0 = null;

        Boolean lv_x27_26_0 = null;

        Boolean lv_x28_27_0 = null;

        Boolean lv_x29_28_0 = null;

        Boolean lv_x30_29_0 = null;

        Boolean lv_x31_30_0 = null;

        Boolean lv_x32_31_0 = null;

        Boolean lv_x33_32_0 = null;

        Boolean lv_x34_33_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:60:1: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) | ( (lv_x33_32_0= ruleFragmentCaller ) ) | ( (lv_x34_33_0= ruleParameterCaller ) ) ) )
            // PsiInternalSequencerTestLanguage.g:61:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) | ( (lv_x33_32_0= ruleFragmentCaller ) ) | ( (lv_x34_33_0= ruleParameterCaller ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:61:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) | ( (lv_x33_32_0= ruleFragmentCaller ) ) | ( (lv_x34_33_0= ruleParameterCaller ) ) )
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
                    // PsiInternalSequencerTestLanguage.g:62:3: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:62:3: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    // PsiInternalSequencerTestLanguage.g:63:4: (lv_x1_0_0= ruleSimpleGroup )
                    {
                    // PsiInternalSequencerTestLanguage.g:63:4: (lv_x1_0_0= ruleSimpleGroup )
                    // PsiInternalSequencerTestLanguage.g:64:5: lv_x1_0_0= ruleSimpleGroup
                    {

                    					markComposite(elementTypeProvider.getModel_X1SimpleGroupParserRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x1_0_0=ruleSimpleGroup();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:78:3: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:78:3: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    // PsiInternalSequencerTestLanguage.g:79:4: (lv_x2_1_0= ruleSimpleAlternative )
                    {
                    // PsiInternalSequencerTestLanguage.g:79:4: (lv_x2_1_0= ruleSimpleAlternative )
                    // PsiInternalSequencerTestLanguage.g:80:5: lv_x2_1_0= ruleSimpleAlternative
                    {

                    					markComposite(elementTypeProvider.getModel_X2SimpleAlternativeParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x2_1_0=ruleSimpleAlternative();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:94:3: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:94:3: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    // PsiInternalSequencerTestLanguage.g:95:4: (lv_x3_2_0= ruleSimpleMultiplicities )
                    {
                    // PsiInternalSequencerTestLanguage.g:95:4: (lv_x3_2_0= ruleSimpleMultiplicities )
                    // PsiInternalSequencerTestLanguage.g:96:5: lv_x3_2_0= ruleSimpleMultiplicities
                    {

                    					markComposite(elementTypeProvider.getModel_X3SimpleMultiplicitiesParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x3_2_0=ruleSimpleMultiplicities();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalSequencerTestLanguage.g:110:3: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:110:3: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    // PsiInternalSequencerTestLanguage.g:111:4: (lv_x4_3_0= ruleGroupMultiplicities )
                    {
                    // PsiInternalSequencerTestLanguage.g:111:4: (lv_x4_3_0= ruleGroupMultiplicities )
                    // PsiInternalSequencerTestLanguage.g:112:5: lv_x4_3_0= ruleGroupMultiplicities
                    {

                    					markComposite(elementTypeProvider.getModel_X4GroupMultiplicitiesParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x4_3_0=ruleGroupMultiplicities();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalSequencerTestLanguage.g:126:3: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:126:3: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    // PsiInternalSequencerTestLanguage.g:127:4: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    {
                    // PsiInternalSequencerTestLanguage.g:127:4: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    // PsiInternalSequencerTestLanguage.g:128:5: lv_x5_4_0= ruleAlternativeMultiplicities
                    {

                    					markComposite(elementTypeProvider.getModel_X5AlternativeMultiplicitiesParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x5_4_0=ruleAlternativeMultiplicities();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // PsiInternalSequencerTestLanguage.g:142:3: ( (lv_x6_5_0= ruleList1 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:142:3: ( (lv_x6_5_0= ruleList1 ) )
                    // PsiInternalSequencerTestLanguage.g:143:4: (lv_x6_5_0= ruleList1 )
                    {
                    // PsiInternalSequencerTestLanguage.g:143:4: (lv_x6_5_0= ruleList1 )
                    // PsiInternalSequencerTestLanguage.g:144:5: lv_x6_5_0= ruleList1
                    {

                    					markComposite(elementTypeProvider.getModel_X6List1ParserRuleCall_5_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x6_5_0=ruleList1();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // PsiInternalSequencerTestLanguage.g:158:3: ( (lv_x7_6_0= ruleList2 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:158:3: ( (lv_x7_6_0= ruleList2 ) )
                    // PsiInternalSequencerTestLanguage.g:159:4: (lv_x7_6_0= ruleList2 )
                    {
                    // PsiInternalSequencerTestLanguage.g:159:4: (lv_x7_6_0= ruleList2 )
                    // PsiInternalSequencerTestLanguage.g:160:5: lv_x7_6_0= ruleList2
                    {

                    					markComposite(elementTypeProvider.getModel_X7List2ParserRuleCall_6_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x7_6_0=ruleList2();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 8 :
                    // PsiInternalSequencerTestLanguage.g:174:3: ( (lv_x8_7_0= ruleAltList1 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:174:3: ( (lv_x8_7_0= ruleAltList1 ) )
                    // PsiInternalSequencerTestLanguage.g:175:4: (lv_x8_7_0= ruleAltList1 )
                    {
                    // PsiInternalSequencerTestLanguage.g:175:4: (lv_x8_7_0= ruleAltList1 )
                    // PsiInternalSequencerTestLanguage.g:176:5: lv_x8_7_0= ruleAltList1
                    {

                    					markComposite(elementTypeProvider.getModel_X8AltList1ParserRuleCall_7_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x8_7_0=ruleAltList1();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 9 :
                    // PsiInternalSequencerTestLanguage.g:190:3: ( (lv_x9_8_0= ruleAltList2 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:190:3: ( (lv_x9_8_0= ruleAltList2 ) )
                    // PsiInternalSequencerTestLanguage.g:191:4: (lv_x9_8_0= ruleAltList2 )
                    {
                    // PsiInternalSequencerTestLanguage.g:191:4: (lv_x9_8_0= ruleAltList2 )
                    // PsiInternalSequencerTestLanguage.g:192:5: lv_x9_8_0= ruleAltList2
                    {

                    					markComposite(elementTypeProvider.getModel_X9AltList2ParserRuleCall_8_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x9_8_0=ruleAltList2();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 10 :
                    // PsiInternalSequencerTestLanguage.g:206:3: ( (lv_x10_9_0= ruleSingleKeywords ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:206:3: ( (lv_x10_9_0= ruleSingleKeywords ) )
                    // PsiInternalSequencerTestLanguage.g:207:4: (lv_x10_9_0= ruleSingleKeywords )
                    {
                    // PsiInternalSequencerTestLanguage.g:207:4: (lv_x10_9_0= ruleSingleKeywords )
                    // PsiInternalSequencerTestLanguage.g:208:5: lv_x10_9_0= ruleSingleKeywords
                    {

                    					markComposite(elementTypeProvider.getModel_X10SingleKeywordsParserRuleCall_9_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x10_9_0=ruleSingleKeywords();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 11 :
                    // PsiInternalSequencerTestLanguage.g:222:3: ( (lv_x11_10_0= ruleSingleKeywordsOrID ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:222:3: ( (lv_x11_10_0= ruleSingleKeywordsOrID ) )
                    // PsiInternalSequencerTestLanguage.g:223:4: (lv_x11_10_0= ruleSingleKeywordsOrID )
                    {
                    // PsiInternalSequencerTestLanguage.g:223:4: (lv_x11_10_0= ruleSingleKeywordsOrID )
                    // PsiInternalSequencerTestLanguage.g:224:5: lv_x11_10_0= ruleSingleKeywordsOrID
                    {

                    					markComposite(elementTypeProvider.getModel_X11SingleKeywordsOrIDParserRuleCall_10_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x11_10_0=ruleSingleKeywordsOrID();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 12 :
                    // PsiInternalSequencerTestLanguage.g:238:3: ( (lv_x12_11_0= ruleSingleTerminals ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:238:3: ( (lv_x12_11_0= ruleSingleTerminals ) )
                    // PsiInternalSequencerTestLanguage.g:239:4: (lv_x12_11_0= ruleSingleTerminals )
                    {
                    // PsiInternalSequencerTestLanguage.g:239:4: (lv_x12_11_0= ruleSingleTerminals )
                    // PsiInternalSequencerTestLanguage.g:240:5: lv_x12_11_0= ruleSingleTerminals
                    {

                    					markComposite(elementTypeProvider.getModel_X12SingleTerminalsParserRuleCall_11_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x12_11_0=ruleSingleTerminals();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 13 :
                    // PsiInternalSequencerTestLanguage.g:254:3: ( (lv_x10_12_0= ruleMultiKeywords ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:254:3: ( (lv_x10_12_0= ruleMultiKeywords ) )
                    // PsiInternalSequencerTestLanguage.g:255:4: (lv_x10_12_0= ruleMultiKeywords )
                    {
                    // PsiInternalSequencerTestLanguage.g:255:4: (lv_x10_12_0= ruleMultiKeywords )
                    // PsiInternalSequencerTestLanguage.g:256:5: lv_x10_12_0= ruleMultiKeywords
                    {

                    					markComposite(elementTypeProvider.getModel_X10MultiKeywordsParserRuleCall_12_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x10_12_0=ruleMultiKeywords();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 14 :
                    // PsiInternalSequencerTestLanguage.g:270:3: ( (lv_x11_13_0= ruleMultiKeywordsOrID ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:270:3: ( (lv_x11_13_0= ruleMultiKeywordsOrID ) )
                    // PsiInternalSequencerTestLanguage.g:271:4: (lv_x11_13_0= ruleMultiKeywordsOrID )
                    {
                    // PsiInternalSequencerTestLanguage.g:271:4: (lv_x11_13_0= ruleMultiKeywordsOrID )
                    // PsiInternalSequencerTestLanguage.g:272:5: lv_x11_13_0= ruleMultiKeywordsOrID
                    {

                    					markComposite(elementTypeProvider.getModel_X11MultiKeywordsOrIDParserRuleCall_13_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x11_13_0=ruleMultiKeywordsOrID();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 15 :
                    // PsiInternalSequencerTestLanguage.g:286:3: ( (lv_x12_14_0= ruleMultiTerminals ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:286:3: ( (lv_x12_14_0= ruleMultiTerminals ) )
                    // PsiInternalSequencerTestLanguage.g:287:4: (lv_x12_14_0= ruleMultiTerminals )
                    {
                    // PsiInternalSequencerTestLanguage.g:287:4: (lv_x12_14_0= ruleMultiTerminals )
                    // PsiInternalSequencerTestLanguage.g:288:5: lv_x12_14_0= ruleMultiTerminals
                    {

                    					markComposite(elementTypeProvider.getModel_X12MultiTerminalsParserRuleCall_14_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x12_14_0=ruleMultiTerminals();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 16 :
                    // PsiInternalSequencerTestLanguage.g:302:3: ( (lv_x13_15_0= ruleSingleEnum ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:302:3: ( (lv_x13_15_0= ruleSingleEnum ) )
                    // PsiInternalSequencerTestLanguage.g:303:4: (lv_x13_15_0= ruleSingleEnum )
                    {
                    // PsiInternalSequencerTestLanguage.g:303:4: (lv_x13_15_0= ruleSingleEnum )
                    // PsiInternalSequencerTestLanguage.g:304:5: lv_x13_15_0= ruleSingleEnum
                    {

                    					markComposite(elementTypeProvider.getModel_X13SingleEnumParserRuleCall_15_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x13_15_0=ruleSingleEnum();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 17 :
                    // PsiInternalSequencerTestLanguage.g:318:3: ( (lv_x14_16_0= ruleSingleCrossReference ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:318:3: ( (lv_x14_16_0= ruleSingleCrossReference ) )
                    // PsiInternalSequencerTestLanguage.g:319:4: (lv_x14_16_0= ruleSingleCrossReference )
                    {
                    // PsiInternalSequencerTestLanguage.g:319:4: (lv_x14_16_0= ruleSingleCrossReference )
                    // PsiInternalSequencerTestLanguage.g:320:5: lv_x14_16_0= ruleSingleCrossReference
                    {

                    					markComposite(elementTypeProvider.getModel_X14SingleCrossReferenceParserRuleCall_16_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x14_16_0=ruleSingleCrossReference();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 18 :
                    // PsiInternalSequencerTestLanguage.g:334:3: ( (lv_x15_17_0= ruleSingleContainmentReference ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:334:3: ( (lv_x15_17_0= ruleSingleContainmentReference ) )
                    // PsiInternalSequencerTestLanguage.g:335:4: (lv_x15_17_0= ruleSingleContainmentReference )
                    {
                    // PsiInternalSequencerTestLanguage.g:335:4: (lv_x15_17_0= ruleSingleContainmentReference )
                    // PsiInternalSequencerTestLanguage.g:336:5: lv_x15_17_0= ruleSingleContainmentReference
                    {

                    					markComposite(elementTypeProvider.getModel_X15SingleContainmentReferenceParserRuleCall_17_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x15_17_0=ruleSingleContainmentReference();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 19 :
                    // PsiInternalSequencerTestLanguage.g:350:3: ( (lv_x19_18_0= ruleDependentAlternative1 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:350:3: ( (lv_x19_18_0= ruleDependentAlternative1 ) )
                    // PsiInternalSequencerTestLanguage.g:351:4: (lv_x19_18_0= ruleDependentAlternative1 )
                    {
                    // PsiInternalSequencerTestLanguage.g:351:4: (lv_x19_18_0= ruleDependentAlternative1 )
                    // PsiInternalSequencerTestLanguage.g:352:5: lv_x19_18_0= ruleDependentAlternative1
                    {

                    					markComposite(elementTypeProvider.getModel_X19DependentAlternative1ParserRuleCall_18_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x19_18_0=ruleDependentAlternative1();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 20 :
                    // PsiInternalSequencerTestLanguage.g:366:3: ( (lv_x20_19_0= ruleDependentAlternative2 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:366:3: ( (lv_x20_19_0= ruleDependentAlternative2 ) )
                    // PsiInternalSequencerTestLanguage.g:367:4: (lv_x20_19_0= ruleDependentAlternative2 )
                    {
                    // PsiInternalSequencerTestLanguage.g:367:4: (lv_x20_19_0= ruleDependentAlternative2 )
                    // PsiInternalSequencerTestLanguage.g:368:5: lv_x20_19_0= ruleDependentAlternative2
                    {

                    					markComposite(elementTypeProvider.getModel_X20DependentAlternative2ParserRuleCall_19_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x20_19_0=ruleDependentAlternative2();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 21 :
                    // PsiInternalSequencerTestLanguage.g:382:3: ( (lv_x21_20_0= ruleOptional ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:382:3: ( (lv_x21_20_0= ruleOptional ) )
                    // PsiInternalSequencerTestLanguage.g:383:4: (lv_x21_20_0= ruleOptional )
                    {
                    // PsiInternalSequencerTestLanguage.g:383:4: (lv_x21_20_0= ruleOptional )
                    // PsiInternalSequencerTestLanguage.g:384:5: lv_x21_20_0= ruleOptional
                    {

                    					markComposite(elementTypeProvider.getModel_X21OptionalParserRuleCall_20_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x21_20_0=ruleOptional();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 22 :
                    // PsiInternalSequencerTestLanguage.g:398:3: ( (lv_x22_21_0= ruleFloat ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:398:3: ( (lv_x22_21_0= ruleFloat ) )
                    // PsiInternalSequencerTestLanguage.g:399:4: (lv_x22_21_0= ruleFloat )
                    {
                    // PsiInternalSequencerTestLanguage.g:399:4: (lv_x22_21_0= ruleFloat )
                    // PsiInternalSequencerTestLanguage.g:400:5: lv_x22_21_0= ruleFloat
                    {

                    					markComposite(elementTypeProvider.getModel_X22FloatParserRuleCall_21_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x22_21_0=ruleFloat();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 23 :
                    // PsiInternalSequencerTestLanguage.g:414:3: ( (lv_x23_22_0= ruleUnorderedAlternative ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:414:3: ( (lv_x23_22_0= ruleUnorderedAlternative ) )
                    // PsiInternalSequencerTestLanguage.g:415:4: (lv_x23_22_0= ruleUnorderedAlternative )
                    {
                    // PsiInternalSequencerTestLanguage.g:415:4: (lv_x23_22_0= ruleUnorderedAlternative )
                    // PsiInternalSequencerTestLanguage.g:416:5: lv_x23_22_0= ruleUnorderedAlternative
                    {

                    					markComposite(elementTypeProvider.getModel_X23UnorderedAlternativeParserRuleCall_22_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x23_22_0=ruleUnorderedAlternative();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 24 :
                    // PsiInternalSequencerTestLanguage.g:430:3: ( (lv_x24_23_0= ruleUnorderedGroup ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:430:3: ( (lv_x24_23_0= ruleUnorderedGroup ) )
                    // PsiInternalSequencerTestLanguage.g:431:4: (lv_x24_23_0= ruleUnorderedGroup )
                    {
                    // PsiInternalSequencerTestLanguage.g:431:4: (lv_x24_23_0= ruleUnorderedGroup )
                    // PsiInternalSequencerTestLanguage.g:432:5: lv_x24_23_0= ruleUnorderedGroup
                    {

                    					markComposite(elementTypeProvider.getModel_X24UnorderedGroupParserRuleCall_23_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x24_23_0=ruleUnorderedGroup();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 25 :
                    // PsiInternalSequencerTestLanguage.g:446:3: ( (lv_x25_24_0= ruleUnorderedGroupOptional ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:446:3: ( (lv_x25_24_0= ruleUnorderedGroupOptional ) )
                    // PsiInternalSequencerTestLanguage.g:447:4: (lv_x25_24_0= ruleUnorderedGroupOptional )
                    {
                    // PsiInternalSequencerTestLanguage.g:447:4: (lv_x25_24_0= ruleUnorderedGroupOptional )
                    // PsiInternalSequencerTestLanguage.g:448:5: lv_x25_24_0= ruleUnorderedGroupOptional
                    {

                    					markComposite(elementTypeProvider.getModel_X25UnorderedGroupOptionalParserRuleCall_24_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x25_24_0=ruleUnorderedGroupOptional();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 26 :
                    // PsiInternalSequencerTestLanguage.g:462:3: ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:462:3: ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) )
                    // PsiInternalSequencerTestLanguage.g:463:4: (lv_x26_25_0= ruleUnorderedGroupBoolean )
                    {
                    // PsiInternalSequencerTestLanguage.g:463:4: (lv_x26_25_0= ruleUnorderedGroupBoolean )
                    // PsiInternalSequencerTestLanguage.g:464:5: lv_x26_25_0= ruleUnorderedGroupBoolean
                    {

                    					markComposite(elementTypeProvider.getModel_X26UnorderedGroupBooleanParserRuleCall_25_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x26_25_0=ruleUnorderedGroupBoolean();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 27 :
                    // PsiInternalSequencerTestLanguage.g:478:3: ( (lv_x27_26_0= ruleComplex1 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:478:3: ( (lv_x27_26_0= ruleComplex1 ) )
                    // PsiInternalSequencerTestLanguage.g:479:4: (lv_x27_26_0= ruleComplex1 )
                    {
                    // PsiInternalSequencerTestLanguage.g:479:4: (lv_x27_26_0= ruleComplex1 )
                    // PsiInternalSequencerTestLanguage.g:480:5: lv_x27_26_0= ruleComplex1
                    {

                    					markComposite(elementTypeProvider.getModel_X27Complex1ParserRuleCall_26_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x27_26_0=ruleComplex1();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 28 :
                    // PsiInternalSequencerTestLanguage.g:494:3: ( (lv_x28_27_0= ruleOptionalDouble ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:494:3: ( (lv_x28_27_0= ruleOptionalDouble ) )
                    // PsiInternalSequencerTestLanguage.g:495:4: (lv_x28_27_0= ruleOptionalDouble )
                    {
                    // PsiInternalSequencerTestLanguage.g:495:4: (lv_x28_27_0= ruleOptionalDouble )
                    // PsiInternalSequencerTestLanguage.g:496:5: lv_x28_27_0= ruleOptionalDouble
                    {

                    					markComposite(elementTypeProvider.getModel_X28OptionalDoubleParserRuleCall_27_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x28_27_0=ruleOptionalDouble();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 29 :
                    // PsiInternalSequencerTestLanguage.g:510:3: ( (lv_x29_28_0= ruleNullValueGenerated ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:510:3: ( (lv_x29_28_0= ruleNullValueGenerated ) )
                    // PsiInternalSequencerTestLanguage.g:511:4: (lv_x29_28_0= ruleNullValueGenerated )
                    {
                    // PsiInternalSequencerTestLanguage.g:511:4: (lv_x29_28_0= ruleNullValueGenerated )
                    // PsiInternalSequencerTestLanguage.g:512:5: lv_x29_28_0= ruleNullValueGenerated
                    {

                    					markComposite(elementTypeProvider.getModel_X29NullValueGeneratedParserRuleCall_28_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x29_28_0=ruleNullValueGenerated();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 30 :
                    // PsiInternalSequencerTestLanguage.g:526:3: ( (lv_x30_29_0= ruleNullValueInterpreted ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:526:3: ( (lv_x30_29_0= ruleNullValueInterpreted ) )
                    // PsiInternalSequencerTestLanguage.g:527:4: (lv_x30_29_0= ruleNullValueInterpreted )
                    {
                    // PsiInternalSequencerTestLanguage.g:527:4: (lv_x30_29_0= ruleNullValueInterpreted )
                    // PsiInternalSequencerTestLanguage.g:528:5: lv_x30_29_0= ruleNullValueInterpreted
                    {

                    					markComposite(elementTypeProvider.getModel_X30NullValueInterpretedParserRuleCall_29_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x30_29_0=ruleNullValueInterpreted();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 31 :
                    // PsiInternalSequencerTestLanguage.g:542:3: ( (lv_x31_30_0= ruleNullCrossRefGenerated ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:542:3: ( (lv_x31_30_0= ruleNullCrossRefGenerated ) )
                    // PsiInternalSequencerTestLanguage.g:543:4: (lv_x31_30_0= ruleNullCrossRefGenerated )
                    {
                    // PsiInternalSequencerTestLanguage.g:543:4: (lv_x31_30_0= ruleNullCrossRefGenerated )
                    // PsiInternalSequencerTestLanguage.g:544:5: lv_x31_30_0= ruleNullCrossRefGenerated
                    {

                    					markComposite(elementTypeProvider.getModel_X31NullCrossRefGeneratedParserRuleCall_30_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x31_30_0=ruleNullCrossRefGenerated();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 32 :
                    // PsiInternalSequencerTestLanguage.g:558:3: ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:558:3: ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) )
                    // PsiInternalSequencerTestLanguage.g:559:4: (lv_x32_31_0= ruleNullCrossRefInterpreted )
                    {
                    // PsiInternalSequencerTestLanguage.g:559:4: (lv_x32_31_0= ruleNullCrossRefInterpreted )
                    // PsiInternalSequencerTestLanguage.g:560:5: lv_x32_31_0= ruleNullCrossRefInterpreted
                    {

                    					markComposite(elementTypeProvider.getModel_X32NullCrossRefInterpretedParserRuleCall_31_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x32_31_0=ruleNullCrossRefInterpreted();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 33 :
                    // PsiInternalSequencerTestLanguage.g:574:3: ( (lv_x33_32_0= ruleFragmentCaller ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:574:3: ( (lv_x33_32_0= ruleFragmentCaller ) )
                    // PsiInternalSequencerTestLanguage.g:575:4: (lv_x33_32_0= ruleFragmentCaller )
                    {
                    // PsiInternalSequencerTestLanguage.g:575:4: (lv_x33_32_0= ruleFragmentCaller )
                    // PsiInternalSequencerTestLanguage.g:576:5: lv_x33_32_0= ruleFragmentCaller
                    {

                    					markComposite(elementTypeProvider.getModel_X33FragmentCallerParserRuleCall_32_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x33_32_0=ruleFragmentCaller();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 34 :
                    // PsiInternalSequencerTestLanguage.g:590:3: ( (lv_x34_33_0= ruleParameterCaller ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:590:3: ( (lv_x34_33_0= ruleParameterCaller ) )
                    // PsiInternalSequencerTestLanguage.g:591:4: (lv_x34_33_0= ruleParameterCaller )
                    {
                    // PsiInternalSequencerTestLanguage.g:591:4: (lv_x34_33_0= ruleParameterCaller )
                    // PsiInternalSequencerTestLanguage.g:592:5: lv_x34_33_0= ruleParameterCaller
                    {

                    					markComposite(elementTypeProvider.getModel_X34ParameterCallerParserRuleCall_33_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x34_33_0=ruleParameterCaller();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSimpleGroup"
    // PsiInternalSequencerTestLanguage.g:609:1: entryRuleSimpleGroup returns [Boolean current=false] : iv_ruleSimpleGroup= ruleSimpleGroup EOF ;
    public final Boolean entryRuleSimpleGroup() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimpleGroup = null;


        try {
            // PsiInternalSequencerTestLanguage.g:609:53: (iv_ruleSimpleGroup= ruleSimpleGroup EOF )
            // PsiInternalSequencerTestLanguage.g:610:2: iv_ruleSimpleGroup= ruleSimpleGroup EOF
            {
             markComposite(elementTypeProvider.getSimpleGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleGroup=ruleSimpleGroup();

            state._fsp--;

             current =iv_ruleSimpleGroup; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleGroup"


    // $ANTLR start "ruleSimpleGroup"
    // PsiInternalSequencerTestLanguage.g:616:1: ruleSimpleGroup returns [Boolean current=false] : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleSimpleGroup() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:617:1: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:618:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:618:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:619:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSimpleGroup_NumberSignDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:626:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:627:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:627:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:628:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimpleGroup_Val1IDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalSequencerTestLanguage.g:643:3: ( (lv_val2_2_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:644:4: (lv_val2_2_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:644:4: (lv_val2_2_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:645:5: lv_val2_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimpleGroup_Val2IDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_val2_2_0);
            				

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
    // $ANTLR end "ruleSimpleGroup"


    // $ANTLR start "entryRuleSimpleAlternative"
    // PsiInternalSequencerTestLanguage.g:664:1: entryRuleSimpleAlternative returns [Boolean current=false] : iv_ruleSimpleAlternative= ruleSimpleAlternative EOF ;
    public final Boolean entryRuleSimpleAlternative() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimpleAlternative = null;


        try {
            // PsiInternalSequencerTestLanguage.g:664:59: (iv_ruleSimpleAlternative= ruleSimpleAlternative EOF )
            // PsiInternalSequencerTestLanguage.g:665:2: iv_ruleSimpleAlternative= ruleSimpleAlternative EOF
            {
             markComposite(elementTypeProvider.getSimpleAlternativeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleAlternative=ruleSimpleAlternative();

            state._fsp--;

             current =iv_ruleSimpleAlternative; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleAlternative"


    // $ANTLR start "ruleSimpleAlternative"
    // PsiInternalSequencerTestLanguage.g:671:1: ruleSimpleAlternative returns [Boolean current=false] : (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final Boolean ruleSimpleAlternative() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val2_4_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:672:1: ( (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:673:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:673:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:674:3: otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {

            			markLeaf(elementTypeProvider.getSimpleAlternative_NumberSignDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:681:3: ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
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
                    // PsiInternalSequencerTestLanguage.g:682:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:682:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:683:5: otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getSimpleAlternative_Kw1Keyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalSequencerTestLanguage.g:690:5: ( (lv_val1_2_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:691:6: (lv_val1_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:691:6: (lv_val1_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:692:7: lv_val1_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getSimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_val1_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:709:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:709:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:710:5: otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getSimpleAlternative_Kw2Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalSequencerTestLanguage.g:717:5: ( (lv_val2_4_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:718:6: (lv_val2_4_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:718:6: (lv_val2_4_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:719:7: lv_val2_4_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getSimpleAlternative_Val2IDTerminalRuleCall_1_1_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val2_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_val2_4_0);
                    						

                    }


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
    // $ANTLR end "ruleSimpleAlternative"


    // $ANTLR start "entryRuleSimpleMultiplicities"
    // PsiInternalSequencerTestLanguage.g:740:1: entryRuleSimpleMultiplicities returns [Boolean current=false] : iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF ;
    public final Boolean entryRuleSimpleMultiplicities() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimpleMultiplicities = null;


        try {
            // PsiInternalSequencerTestLanguage.g:740:62: (iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF )
            // PsiInternalSequencerTestLanguage.g:741:2: iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF
            {
             markComposite(elementTypeProvider.getSimpleMultiplicitiesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleMultiplicities=ruleSimpleMultiplicities();

            state._fsp--;

             current =iv_ruleSimpleMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleMultiplicities"


    // $ANTLR start "ruleSimpleMultiplicities"
    // PsiInternalSequencerTestLanguage.g:747:1: ruleSimpleMultiplicities returns [Boolean current=false] : (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
    public final Boolean ruleSimpleMultiplicities() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token lv_val3_5_0=null;
        Token otherlv_6=null;
        Token lv_val4_7_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:748:1: ( (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // PsiInternalSequencerTestLanguage.g:749:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // PsiInternalSequencerTestLanguage.g:749:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // PsiInternalSequencerTestLanguage.g:750:3: otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {

            			markLeaf(elementTypeProvider.getSimpleMultiplicities_NumberSignDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:757:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:758:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:758:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:759:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimpleMultiplicities_Val1IDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getSimpleMultiplicities_Kw1Keyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSequencerTestLanguage.g:781:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:782:4: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:782:4: (lv_val2_3_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:783:5: lv_val2_3_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getSimpleMultiplicities_Val2IDTerminalRuleCall_3_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    					doneLeaf(lv_val2_3_0);
                    				

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getSimpleMultiplicities_Kw2Keyword_4ElementType());
            		
            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalSequencerTestLanguage.g:805:3: ( (lv_val3_5_0= RULE_ID ) )+
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
            	    // PsiInternalSequencerTestLanguage.g:806:4: (lv_val3_5_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:806:4: (lv_val3_5_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:807:5: lv_val3_5_0= RULE_ID
            	    {

            	    					markLeaf(elementTypeProvider.getSimpleMultiplicities_Val3IDTerminalRuleCall_5_0ElementType());
            	    				

            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				
            	    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            	    					doneLeaf(lv_val3_5_0);
            	    				

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


            			markLeaf(elementTypeProvider.getSimpleMultiplicities_Kw3Keyword_6ElementType());
            		
            otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_6);
            		
            // PsiInternalSequencerTestLanguage.g:829:3: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalSequencerTestLanguage.g:830:4: (lv_val4_7_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:830:4: (lv_val4_7_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:831:5: lv_val4_7_0= RULE_ID
            	    {

            	    					markLeaf(elementTypeProvider.getSimpleMultiplicities_Val4IDTerminalRuleCall_7_0ElementType());
            	    				

            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				
            	    lv_val4_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            	    					doneLeaf(lv_val4_7_0);
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


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
    // $ANTLR end "ruleSimpleMultiplicities"


    // $ANTLR start "entryRuleGroupMultiplicities"
    // PsiInternalSequencerTestLanguage.g:850:1: entryRuleGroupMultiplicities returns [Boolean current=false] : iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF ;
    public final Boolean entryRuleGroupMultiplicities() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGroupMultiplicities = null;


        try {
            // PsiInternalSequencerTestLanguage.g:850:61: (iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF )
            // PsiInternalSequencerTestLanguage.g:851:2: iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF
            {
             markComposite(elementTypeProvider.getGroupMultiplicitiesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGroupMultiplicities=ruleGroupMultiplicities();

            state._fsp--;

             current =iv_ruleGroupMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleGroupMultiplicities"


    // $ANTLR start "ruleGroupMultiplicities"
    // PsiInternalSequencerTestLanguage.g:857:1: ruleGroupMultiplicities returns [Boolean current=false] : (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
    public final Boolean ruleGroupMultiplicities() throws RecognitionException {
        Boolean current = false;

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

        try {
            // PsiInternalSequencerTestLanguage.g:858:1: ( (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:859:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // PsiInternalSequencerTestLanguage.g:859:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // PsiInternalSequencerTestLanguage.g:860:3: otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getGroupMultiplicities_NumberSignDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:867:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:868:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:868:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:869:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getGroupMultiplicities_Val1IDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getGroupMultiplicities_Kw1Keyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSequencerTestLanguage.g:891:3: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:892:4: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:892:4: ( (lv_val2_3_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:893:5: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:893:5: (lv_val2_3_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:894:6: lv_val2_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val2IDTerminalRuleCall_3_0_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    						doneLeaf(lv_val2_3_0);
                    					

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:909:4: ( (lv_val3_4_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:910:5: (lv_val3_4_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:910:5: (lv_val3_4_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:911:6: lv_val3_4_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val3IDTerminalRuleCall_3_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    						doneLeaf(lv_val3_4_0);
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getGroupMultiplicities_Kw2Keyword_4ElementType());
            		
            otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_5);
            		
            // PsiInternalSequencerTestLanguage.g:934:3: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
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
            	    // PsiInternalSequencerTestLanguage.g:935:4: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:935:4: ( (lv_val4_6_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:936:5: (lv_val4_6_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:936:5: (lv_val4_6_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:937:6: lv_val4_6_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val4IDTerminalRuleCall_5_0_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						doneLeaf(lv_val4_6_0);
            	    					

            	    }


            	    }

            	    // PsiInternalSequencerTestLanguage.g:952:4: ( (lv_val5_7_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:953:5: (lv_val5_7_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:953:5: (lv_val5_7_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:954:6: lv_val5_7_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val5IDTerminalRuleCall_5_1_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            	    						doneLeaf(lv_val5_7_0);
            	    					

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


            			markLeaf(elementTypeProvider.getGroupMultiplicities_Kw3Keyword_6ElementType());
            		
            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_8);
            		
            // PsiInternalSequencerTestLanguage.g:977:3: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalSequencerTestLanguage.g:978:4: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:978:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:979:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:979:5: (lv_val6_9_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:980:6: lv_val6_9_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val6IDTerminalRuleCall_7_0_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						doneLeaf(lv_val6_9_0);
            	    					

            	    }


            	    }

            	    // PsiInternalSequencerTestLanguage.g:995:4: ( (lv_val7_10_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:996:5: (lv_val7_10_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:996:5: (lv_val7_10_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:997:6: lv_val7_10_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val7IDTerminalRuleCall_7_1_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_val7_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            	    						doneLeaf(lv_val7_10_0);
            	    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroupMultiplicities"


    // $ANTLR start "entryRuleAlternativeMultiplicities"
    // PsiInternalSequencerTestLanguage.g:1017:1: entryRuleAlternativeMultiplicities returns [Boolean current=false] : iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF ;
    public final Boolean entryRuleAlternativeMultiplicities() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAlternativeMultiplicities = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1017:67: (iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF )
            // PsiInternalSequencerTestLanguage.g:1018:2: iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF
            {
             markComposite(elementTypeProvider.getAlternativeMultiplicitiesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAlternativeMultiplicities=ruleAlternativeMultiplicities();

            state._fsp--;

             current =iv_ruleAlternativeMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleAlternativeMultiplicities"


    // $ANTLR start "ruleAlternativeMultiplicities"
    // PsiInternalSequencerTestLanguage.g:1024:1: ruleAlternativeMultiplicities returns [Boolean current=false] : (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
    public final Boolean ruleAlternativeMultiplicities() throws RecognitionException {
        Boolean current = false;

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

        try {
            // PsiInternalSequencerTestLanguage.g:1025:1: ( (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:1026:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // PsiInternalSequencerTestLanguage.g:1026:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // PsiInternalSequencerTestLanguage.g:1027:3: otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {

            			markLeaf(elementTypeProvider.getAlternativeMultiplicities_NumberSignDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1034:3: ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
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
                    // PsiInternalSequencerTestLanguage.g:1035:4: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1035:4: ( (lv_val2_1_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1036:5: (lv_val2_1_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1036:5: (lv_val2_1_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1037:6: lv_val2_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    						doneLeaf(lv_val2_1_0);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1053:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1053:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:1054:5: otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw1Keyword_1_1_0ElementType());
                    				
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalSequencerTestLanguage.g:1061:5: ( (lv_val3_3_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1062:6: (lv_val3_3_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1062:6: (lv_val3_3_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1063:7: lv_val3_3_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							doneLeaf(lv_val3_3_0);
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw2Keyword_2ElementType());
            		
            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalSequencerTestLanguage.g:1087:3: ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
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
            	    // PsiInternalSequencerTestLanguage.g:1088:4: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1088:4: ( (lv_val4_5_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:1089:5: (lv_val4_5_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1089:5: (lv_val4_5_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:1090:6: lv_val4_5_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            	    						doneLeaf(lv_val4_5_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSequencerTestLanguage.g:1106:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1106:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:1107:5: otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw3Keyword_3_1_0ElementType());
            	    				
            	    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_6);
            	    				
            	    // PsiInternalSequencerTestLanguage.g:1114:5: ( (lv_val5_7_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:1115:6: (lv_val5_7_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1115:6: (lv_val5_7_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:1116:7: lv_val5_7_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val5IDTerminalRuleCall_3_1_1_0ElementType());
            	    						

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            	    							doneLeaf(lv_val5_7_0);
            	    						

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


            			markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw4Keyword_4ElementType());
            		
            otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_12); 

            			doneLeaf(otherlv_8);
            		
            // PsiInternalSequencerTestLanguage.g:1140:3: ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
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
            	    // PsiInternalSequencerTestLanguage.g:1141:4: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1141:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:1142:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1142:5: (lv_val6_9_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:1143:6: lv_val6_9_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    						doneLeaf(lv_val6_9_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSequencerTestLanguage.g:1159:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1159:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:1160:5: otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw5Keyword_5_1_0ElementType());
            	    				
            	    otherlv_10=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_10);
            	    				
            	    // PsiInternalSequencerTestLanguage.g:1167:5: ( (lv_val7_11_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:1168:6: (lv_val7_11_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1168:6: (lv_val7_11_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:1169:7: lv_val7_11_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val7IDTerminalRuleCall_5_1_1_0ElementType());
            	    						

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						
            	    lv_val7_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    							doneLeaf(lv_val7_11_0);
            	    						

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlternativeMultiplicities"


    // $ANTLR start "entryRuleList1"
    // PsiInternalSequencerTestLanguage.g:1190:1: entryRuleList1 returns [Boolean current=false] : iv_ruleList1= ruleList1 EOF ;
    public final Boolean entryRuleList1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleList1 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1190:47: (iv_ruleList1= ruleList1 EOF )
            // PsiInternalSequencerTestLanguage.g:1191:2: iv_ruleList1= ruleList1 EOF
            {
             markComposite(elementTypeProvider.getList1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleList1=ruleList1();

            state._fsp--;

             current =iv_ruleList1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleList1"


    // $ANTLR start "ruleList1"
    // PsiInternalSequencerTestLanguage.g:1197:1: ruleList1 returns [Boolean current=false] : (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final Boolean ruleList1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1198:1: ( (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:1199:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // PsiInternalSequencerTestLanguage.g:1199:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // PsiInternalSequencerTestLanguage.g:1200:3: otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getList1_NumberSignDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1207:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:1208:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:1208:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:1209:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getList1_Val1IDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalSequencerTestLanguage.g:1224:3: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==25) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // PsiInternalSequencerTestLanguage.g:1225:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getList1_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalSequencerTestLanguage.g:1232:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:1233:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1233:5: (lv_val1_3_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:1234:6: lv_val1_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getList1_Val1IDTerminalRuleCall_2_1_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            	    						doneLeaf(lv_val1_3_0);
            	    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleList1"


    // $ANTLR start "entryRuleList2"
    // PsiInternalSequencerTestLanguage.g:1254:1: entryRuleList2 returns [Boolean current=false] : iv_ruleList2= ruleList2 EOF ;
    public final Boolean entryRuleList2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleList2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1254:47: (iv_ruleList2= ruleList2 EOF )
            // PsiInternalSequencerTestLanguage.g:1255:2: iv_ruleList2= ruleList2 EOF
            {
             markComposite(elementTypeProvider.getList2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleList2=ruleList2();

            state._fsp--;

             current =iv_ruleList2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleList2"


    // $ANTLR start "ruleList2"
    // PsiInternalSequencerTestLanguage.g:1261:1: ruleList2 returns [Boolean current=false] : (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? ) ;
    public final Boolean ruleList2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1262:1: ( (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? ) )
            // PsiInternalSequencerTestLanguage.g:1263:2: (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? )
            {
            // PsiInternalSequencerTestLanguage.g:1263:2: (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? )
            // PsiInternalSequencerTestLanguage.g:1264:3: otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )?
            {

            			markLeaf(elementTypeProvider.getList2_NumberSignDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1271:3: ()
            // PsiInternalSequencerTestLanguage.g:1272:4: 
            {

            				precedeComposite(elementTypeProvider.getList2_List2Action_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalSequencerTestLanguage.g:1278:3: ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:1279:4: ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )*
                    {
                    // PsiInternalSequencerTestLanguage.g:1279:4: ( (lv_val1_2_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1280:5: (lv_val1_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1280:5: (lv_val1_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1281:6: lv_val1_2_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getList2_Val1IDTerminalRuleCall_2_0_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

                    						doneLeaf(lv_val1_2_0);
                    					

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:1296:4: (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==25) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // PsiInternalSequencerTestLanguage.g:1297:5: otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getList2_CommaKeyword_2_1_0ElementType());
                    	    				
                    	    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_3);
                    	    				
                    	    // PsiInternalSequencerTestLanguage.g:1304:5: ( (lv_val1_4_0= RULE_ID ) )
                    	    // PsiInternalSequencerTestLanguage.g:1305:6: (lv_val1_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalSequencerTestLanguage.g:1305:6: (lv_val1_4_0= RULE_ID )
                    	    // PsiInternalSequencerTestLanguage.g:1306:7: lv_val1_4_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getList2_Val1IDTerminalRuleCall_2_1_1_0ElementType());
                    	    						

                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						
                    	    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

                    	    							doneLeaf(lv_val1_4_0);
                    	    						

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleList2"


    // $ANTLR start "entryRuleAltList1"
    // PsiInternalSequencerTestLanguage.g:1327:1: entryRuleAltList1 returns [Boolean current=false] : iv_ruleAltList1= ruleAltList1 EOF ;
    public final Boolean entryRuleAltList1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAltList1 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1327:50: (iv_ruleAltList1= ruleAltList1 EOF )
            // PsiInternalSequencerTestLanguage.g:1328:2: iv_ruleAltList1= ruleAltList1 EOF
            {
             markComposite(elementTypeProvider.getAltList1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAltList1=ruleAltList1();

            state._fsp--;

             current =iv_ruleAltList1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleAltList1"


    // $ANTLR start "ruleAltList1"
    // PsiInternalSequencerTestLanguage.g:1334:1: ruleAltList1 returns [Boolean current=false] : (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) ;
    public final Boolean ruleAltList1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;
        Token lv_val3_5_0=null;
        Token otherlv_6=null;
        Token lv_val1_7_0=null;
        Token lv_val4_8_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1335:1: ( (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1336:2: (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1336:2: (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            // PsiInternalSequencerTestLanguage.g:1337:3: otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            {

            			markLeaf(elementTypeProvider.getAltList1_NumberSignDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1344:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
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
                    // PsiInternalSequencerTestLanguage.g:1345:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1345:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:1346:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1346:5: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1347:6: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1347:6: (lv_val1_1_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1348:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							doneLeaf(lv_val1_1_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:1363:5: ( (lv_val2_2_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1364:6: (lv_val2_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1364:6: (lv_val2_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1365:7: lv_val2_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val2IDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_val2_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1382:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1382:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:1383:5: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getAltList1_Kw1Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalSequencerTestLanguage.g:1390:5: ( (lv_val1_4_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1391:6: (lv_val1_4_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1391:6: (lv_val1_4_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1392:7: lv_val1_4_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							doneLeaf(lv_val1_4_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:1407:5: ( (lv_val3_5_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1408:6: (lv_val3_5_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1408:6: (lv_val3_5_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1409:7: lv_val3_5_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val3IDTerminalRuleCall_1_1_2_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_val3_5_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:1426:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    {
                    // PsiInternalSequencerTestLanguage.g:1426:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    // PsiInternalSequencerTestLanguage.g:1427:5: otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )?
                    {

                    					markLeaf(elementTypeProvider.getAltList1_Kw2Keyword_1_2_0ElementType());
                    				
                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_6);
                    				
                    // PsiInternalSequencerTestLanguage.g:1434:5: ( (lv_val1_7_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1435:6: (lv_val1_7_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1435:6: (lv_val1_7_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1436:7: lv_val1_7_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_2_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val1_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    							doneLeaf(lv_val1_7_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:1451:5: ( (lv_val4_8_0= RULE_ID ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // PsiInternalSequencerTestLanguage.g:1452:6: (lv_val4_8_0= RULE_ID )
                            {
                            // PsiInternalSequencerTestLanguage.g:1452:6: (lv_val4_8_0= RULE_ID )
                            // PsiInternalSequencerTestLanguage.g:1453:7: lv_val4_8_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getAltList1_Val4IDTerminalRuleCall_1_2_2_0ElementType());
                            						

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						
                            lv_val4_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_val4_8_0);
                            						

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
    // $ANTLR end "ruleAltList1"


    // $ANTLR start "entryRuleAltList2"
    // PsiInternalSequencerTestLanguage.g:1474:1: entryRuleAltList2 returns [Boolean current=false] : iv_ruleAltList2= ruleAltList2 EOF ;
    public final Boolean entryRuleAltList2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAltList2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1474:50: (iv_ruleAltList2= ruleAltList2 EOF )
            // PsiInternalSequencerTestLanguage.g:1475:2: iv_ruleAltList2= ruleAltList2 EOF
            {
             markComposite(elementTypeProvider.getAltList2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAltList2=ruleAltList2();

            state._fsp--;

             current =iv_ruleAltList2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleAltList2"


    // $ANTLR start "ruleAltList2"
    // PsiInternalSequencerTestLanguage.g:1481:1: ruleAltList2 returns [Boolean current=false] : (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) ;
    public final Boolean ruleAltList2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;
        Token otherlv_5=null;
        Token lv_val1_6_0=null;
        Token lv_val3_7_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1482:1: ( (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1483:2: (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1483:2: (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1484:3: otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            {

            			markLeaf(elementTypeProvider.getAltList2_NumberSignDigitNineKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_14); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1491:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
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
                    // PsiInternalSequencerTestLanguage.g:1492:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1492:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:1493:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1493:5: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1494:6: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1494:6: (lv_val1_1_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1495:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							doneLeaf(lv_val1_1_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:1510:5: ( (lv_val2_2_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1511:6: (lv_val2_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1511:6: (lv_val2_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1512:7: lv_val2_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val2IDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_val2_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1529:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1529:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:1530:5: otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getAltList2_KwKeyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalSequencerTestLanguage.g:1537:5: ( (lv_val1_4_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1538:6: (lv_val1_4_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1538:6: (lv_val1_4_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1539:7: lv_val1_4_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

                    							doneLeaf(lv_val1_4_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:1554:5: (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==25) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // PsiInternalSequencerTestLanguage.g:1555:6: otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) )
                    	    {

                    	    						markLeaf(elementTypeProvider.getAltList2_CommaKeyword_1_1_2_0ElementType());
                    	    					
                    	    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_3); 

                    	    						doneLeaf(otherlv_5);
                    	    					
                    	    // PsiInternalSequencerTestLanguage.g:1562:6: ( (lv_val1_6_0= RULE_ID ) )
                    	    // PsiInternalSequencerTestLanguage.g:1563:7: (lv_val1_6_0= RULE_ID )
                    	    {
                    	    // PsiInternalSequencerTestLanguage.g:1563:7: (lv_val1_6_0= RULE_ID )
                    	    // PsiInternalSequencerTestLanguage.g:1564:8: lv_val1_6_0= RULE_ID
                    	    {

                    	    								markLeaf(elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_1_2_1_0ElementType());
                    	    							

                    	    								if(!current) {
                    	    									associateWithSemanticElement();
                    	    									current = true;
                    	    								}
                    	    							
                    	    lv_val1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

                    	    								doneLeaf(lv_val1_6_0);
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // PsiInternalSequencerTestLanguage.g:1580:5: ( (lv_val3_7_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1581:6: (lv_val3_7_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1581:6: (lv_val3_7_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1582:7: lv_val3_7_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val3IDTerminalRuleCall_1_1_3_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_val3_7_0);
                    						

                    }


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
    // $ANTLR end "ruleAltList2"


    // $ANTLR start "entryRuleSingleKeywords"
    // PsiInternalSequencerTestLanguage.g:1603:1: entryRuleSingleKeywords returns [Boolean current=false] : iv_ruleSingleKeywords= ruleSingleKeywords EOF ;
    public final Boolean entryRuleSingleKeywords() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleKeywords = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1603:56: (iv_ruleSingleKeywords= ruleSingleKeywords EOF )
            // PsiInternalSequencerTestLanguage.g:1604:2: iv_ruleSingleKeywords= ruleSingleKeywords EOF
            {
             markComposite(elementTypeProvider.getSingleKeywordsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleKeywords=ruleSingleKeywords();

            state._fsp--;

             current =iv_ruleSingleKeywords; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleKeywords"


    // $ANTLR start "ruleSingleKeywords"
    // PsiInternalSequencerTestLanguage.g:1610:1: ruleSingleKeywords returns [Boolean current=false] : (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) ;
    public final Boolean ruleSingleKeywords() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1611:1: ( (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1612:2: (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1612:2: (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1613:3: otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            {

            			markLeaf(elementTypeProvider.getSingleKeywords_NumberSignDigitOneDigitZeroKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1620:3: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            // PsiInternalSequencerTestLanguage.g:1621:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            {
            // PsiInternalSequencerTestLanguage.g:1621:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            // PsiInternalSequencerTestLanguage.g:1622:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
            {
            // PsiInternalSequencerTestLanguage.g:1622:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
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
                    // PsiInternalSequencerTestLanguage.g:1623:6: lv_val_1_1= 'kw1'
                    {

                    						markLeaf(elementTypeProvider.getSingleKeywords_ValKw1Keyword_1_0_0ElementType());
                    					
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_1);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1637:6: lv_val_1_2= 'kw2'
                    {

                    						markLeaf(elementTypeProvider.getSingleKeywords_ValKw2Keyword_1_0_1ElementType());
                    					
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_2);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:1651:6: lv_val_1_3= 'kw3'
                    {

                    						markLeaf(elementTypeProvider.getSingleKeywords_ValKw3Keyword_1_0_2ElementType());
                    					
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_3);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;

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
    // $ANTLR end "ruleSingleKeywords"


    // $ANTLR start "entryRuleSingleKeywordsOrID"
    // PsiInternalSequencerTestLanguage.g:1671:1: entryRuleSingleKeywordsOrID returns [Boolean current=false] : iv_ruleSingleKeywordsOrID= ruleSingleKeywordsOrID EOF ;
    public final Boolean entryRuleSingleKeywordsOrID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleKeywordsOrID = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1671:60: (iv_ruleSingleKeywordsOrID= ruleSingleKeywordsOrID EOF )
            // PsiInternalSequencerTestLanguage.g:1672:2: iv_ruleSingleKeywordsOrID= ruleSingleKeywordsOrID EOF
            {
             markComposite(elementTypeProvider.getSingleKeywordsOrIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleKeywordsOrID=ruleSingleKeywordsOrID();

            state._fsp--;

             current =iv_ruleSingleKeywordsOrID; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleKeywordsOrID"


    // $ANTLR start "ruleSingleKeywordsOrID"
    // PsiInternalSequencerTestLanguage.g:1678:1: ruleSingleKeywordsOrID returns [Boolean current=false] : (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) ;
    public final Boolean ruleSingleKeywordsOrID() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;
        Token lv_val_1_4=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1679:1: ( (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1680:2: (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1680:2: (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1681:3: otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            {

            			markLeaf(elementTypeProvider.getSingleKeywordsOrID_NumberSignDigitOneDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_17); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1688:3: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:1689:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            {
            // PsiInternalSequencerTestLanguage.g:1689:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:1690:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:1690:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
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
                    // PsiInternalSequencerTestLanguage.g:1691:6: lv_val_1_1= 'kw1'
                    {

                    						markLeaf(elementTypeProvider.getSingleKeywordsOrID_ValKw1Keyword_1_0_0ElementType());
                    					
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_1);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1705:6: lv_val_1_2= 'kw2'
                    {

                    						markLeaf(elementTypeProvider.getSingleKeywordsOrID_ValKw2Keyword_1_0_1ElementType());
                    					
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_2);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:1719:6: lv_val_1_3= 'kw3'
                    {

                    						markLeaf(elementTypeProvider.getSingleKeywordsOrID_ValKw3Keyword_1_0_2ElementType());
                    					
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_3);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 4 :
                    // PsiInternalSequencerTestLanguage.g:1733:6: lv_val_1_4= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getSingleKeywordsOrID_ValIDTerminalRuleCall_1_0_3ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val_1_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_4);
                    					

                    }
                    break;

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
    // $ANTLR end "ruleSingleKeywordsOrID"


    // $ANTLR start "entryRuleSingleTerminals"
    // PsiInternalSequencerTestLanguage.g:1753:1: entryRuleSingleTerminals returns [Boolean current=false] : iv_ruleSingleTerminals= ruleSingleTerminals EOF ;
    public final Boolean entryRuleSingleTerminals() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleTerminals = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1753:57: (iv_ruleSingleTerminals= ruleSingleTerminals EOF )
            // PsiInternalSequencerTestLanguage.g:1754:2: iv_ruleSingleTerminals= ruleSingleTerminals EOF
            {
             markComposite(elementTypeProvider.getSingleTerminalsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleTerminals=ruleSingleTerminals();

            state._fsp--;

             current =iv_ruleSingleTerminals; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleTerminals"


    // $ANTLR start "ruleSingleTerminals"
    // PsiInternalSequencerTestLanguage.g:1760:1: ruleSingleTerminals returns [Boolean current=false] : (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) ;
    public final Boolean ruleSingleTerminals() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1761:1: ( (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1762:2: (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1762:2: (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1763:3: otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            {

            			markLeaf(elementTypeProvider.getSingleTerminals_NumberSignDigitOneDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_18); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1770:3: ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            // PsiInternalSequencerTestLanguage.g:1771:4: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            {
            // PsiInternalSequencerTestLanguage.g:1771:4: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            // PsiInternalSequencerTestLanguage.g:1772:5: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
            {
            // PsiInternalSequencerTestLanguage.g:1772:5: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
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
                    // PsiInternalSequencerTestLanguage.g:1773:6: lv_val_1_1= RULE_ID1
                    {

                    						markLeaf(elementTypeProvider.getSingleTerminals_ValID1TerminalRuleCall_1_0_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1787:6: lv_val_1_2= RULE_ID2
                    {

                    						markLeaf(elementTypeProvider.getSingleTerminals_ValID2TerminalRuleCall_1_0_1ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_2);
                    					

                    }
                    break;

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
    // $ANTLR end "ruleSingleTerminals"


    // $ANTLR start "entryRuleSingleEnum"
    // PsiInternalSequencerTestLanguage.g:1807:1: entryRuleSingleEnum returns [Boolean current=false] : iv_ruleSingleEnum= ruleSingleEnum EOF ;
    public final Boolean entryRuleSingleEnum() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleEnum = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1807:52: (iv_ruleSingleEnum= ruleSingleEnum EOF )
            // PsiInternalSequencerTestLanguage.g:1808:2: iv_ruleSingleEnum= ruleSingleEnum EOF
            {
             markComposite(elementTypeProvider.getSingleEnumElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleEnum=ruleSingleEnum();

            state._fsp--;

             current =iv_ruleSingleEnum; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleEnum"


    // $ANTLR start "ruleSingleEnum"
    // PsiInternalSequencerTestLanguage.g:1814:1: ruleSingleEnum returns [Boolean current=false] : (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) ) ;
    public final Boolean ruleSingleEnum() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_val_1_1 = null;

        Boolean lv_val_1_2 = null;

        Boolean lv_val_1_3 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1815:1: ( (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1816:2: (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1816:2: (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1817:3: otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) )
            {

            			markLeaf(elementTypeProvider.getSingleEnum_NumberSignDigitOneDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1824:3: ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) )
            // PsiInternalSequencerTestLanguage.g:1825:4: ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) )
            {
            // PsiInternalSequencerTestLanguage.g:1825:4: ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) )
            // PsiInternalSequencerTestLanguage.g:1826:5: (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 )
            {
            // PsiInternalSequencerTestLanguage.g:1826:5: (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 )
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
                    // PsiInternalSequencerTestLanguage.g:1827:6: lv_val_1_1= ruleDefEnum1
                    {

                    						markComposite(elementTypeProvider.getSingleEnum_ValDefEnum1EnumRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_1_1=ruleDefEnum1();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1839:6: lv_val_1_2= ruleDefEnum2
                    {

                    						markComposite(elementTypeProvider.getSingleEnum_ValDefEnum2EnumRuleCall_1_0_1ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_1_2=ruleDefEnum2();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:1851:6: lv_val_1_3= ruleDefEnum3
                    {

                    						markComposite(elementTypeProvider.getSingleEnum_ValDefEnum3EnumRuleCall_1_0_2ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_1_3=ruleDefEnum3();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;

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
    // $ANTLR end "ruleSingleEnum"


    // $ANTLR start "entryRuleSingleCrossReference"
    // PsiInternalSequencerTestLanguage.g:1869:1: entryRuleSingleCrossReference returns [Boolean current=false] : iv_ruleSingleCrossReference= ruleSingleCrossReference EOF ;
    public final Boolean entryRuleSingleCrossReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleCrossReference = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1869:62: (iv_ruleSingleCrossReference= ruleSingleCrossReference EOF )
            // PsiInternalSequencerTestLanguage.g:1870:2: iv_ruleSingleCrossReference= ruleSingleCrossReference EOF
            {
             markComposite(elementTypeProvider.getSingleCrossReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleCrossReference=ruleSingleCrossReference();

            state._fsp--;

             current =iv_ruleSingleCrossReference; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleCrossReference"


    // $ANTLR start "ruleSingleCrossReference"
    // PsiInternalSequencerTestLanguage.g:1876:1: ruleSingleCrossReference returns [Boolean current=false] : (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) ) ;
    public final Boolean ruleSingleCrossReference() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1877:1: ( (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1878:2: (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1878:2: (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1879:3: otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) )
            {

            			markLeaf(elementTypeProvider.getSingleCrossReference_NumberSignDigitOneDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_19); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1886:3: ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) )
            // PsiInternalSequencerTestLanguage.g:1887:4: ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) )
            {
            // PsiInternalSequencerTestLanguage.g:1887:4: ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) )
            // PsiInternalSequencerTestLanguage.g:1888:5: (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 )
            {
            // PsiInternalSequencerTestLanguage.g:1888:5: (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 )
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
                    // PsiInternalSequencerTestLanguage.g:1889:6: lv_name_1_1= RULE_ID1
                    {

                    						markLeaf(elementTypeProvider.getSingleCrossReference_NameID1TerminalRuleCall_1_0_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_name_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_19); 

                    						doneLeaf(lv_name_1_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1903:6: lv_name_1_2= RULE_ID2
                    {

                    						markLeaf(elementTypeProvider.getSingleCrossReference_NameID2TerminalRuleCall_1_0_1ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_name_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_19); 

                    						doneLeaf(lv_name_1_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:1917:6: lv_name_1_3= RULE_ID3
                    {

                    						markLeaf(elementTypeProvider.getSingleCrossReference_NameID3TerminalRuleCall_1_0_2ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_name_1_3=(Token)match(input,RULE_ID3,FollowSets000.FOLLOW_19); 

                    						doneLeaf(lv_name_1_3);
                    					

                    }
                    break;

            }


            }


            }

            // PsiInternalSequencerTestLanguage.g:1933:3: ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) )
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
                    // PsiInternalSequencerTestLanguage.g:1934:4: ( (otherlv_2= RULE_ID1 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1934:4: ( (otherlv_2= RULE_ID1 ) )
                    // PsiInternalSequencerTestLanguage.g:1935:5: (otherlv_2= RULE_ID1 )
                    {
                    // PsiInternalSequencerTestLanguage.g:1935:5: (otherlv_2= RULE_ID1 )
                    // PsiInternalSequencerTestLanguage.g:1936:6: otherlv_2= RULE_ID1
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getSingleCrossReference_RefSingleCrossReferenceCrossReference_2_0_0ElementType());
                    					
                    otherlv_2=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_2); 

                    						doneLeaf(otherlv_2);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1952:4: ( (otherlv_3= RULE_ID2 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1952:4: ( (otherlv_3= RULE_ID2 ) )
                    // PsiInternalSequencerTestLanguage.g:1953:5: (otherlv_3= RULE_ID2 )
                    {
                    // PsiInternalSequencerTestLanguage.g:1953:5: (otherlv_3= RULE_ID2 )
                    // PsiInternalSequencerTestLanguage.g:1954:6: otherlv_3= RULE_ID2
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getSingleCrossReference_RefSingleCrossReferenceCrossReference_2_1_0ElementType());
                    					
                    otherlv_3=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_2); 

                    						doneLeaf(otherlv_3);
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:1970:4: ( (otherlv_4= RULE_ID3 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1970:4: ( (otherlv_4= RULE_ID3 ) )
                    // PsiInternalSequencerTestLanguage.g:1971:5: (otherlv_4= RULE_ID3 )
                    {
                    // PsiInternalSequencerTestLanguage.g:1971:5: (otherlv_4= RULE_ID3 )
                    // PsiInternalSequencerTestLanguage.g:1972:6: otherlv_4= RULE_ID3
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getSingleCrossReference_RefSingleCrossReferenceCrossReference_2_2_0ElementType());
                    					
                    otherlv_4=(Token)match(input,RULE_ID3,FollowSets000.FOLLOW_2); 

                    						doneLeaf(otherlv_4);
                    					

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
    // $ANTLR end "ruleSingleCrossReference"


    // $ANTLR start "entryRuleSingleContainmentReference"
    // PsiInternalSequencerTestLanguage.g:1992:1: entryRuleSingleContainmentReference returns [Boolean current=false] : iv_ruleSingleContainmentReference= ruleSingleContainmentReference EOF ;
    public final Boolean entryRuleSingleContainmentReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleContainmentReference = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1992:68: (iv_ruleSingleContainmentReference= ruleSingleContainmentReference EOF )
            // PsiInternalSequencerTestLanguage.g:1993:2: iv_ruleSingleContainmentReference= ruleSingleContainmentReference EOF
            {
             markComposite(elementTypeProvider.getSingleContainmentReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleContainmentReference=ruleSingleContainmentReference();

            state._fsp--;

             current =iv_ruleSingleContainmentReference; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleContainmentReference"


    // $ANTLR start "ruleSingleContainmentReference"
    // PsiInternalSequencerTestLanguage.g:1999:1: ruleSingleContainmentReference returns [Boolean current=false] : (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) ) ;
    public final Boolean ruleSingleContainmentReference() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_child_1_1 = null;

        Boolean lv_child_1_2 = null;

        Boolean lv_child_1_3 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2000:1: ( (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2001:2: (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2001:2: (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2002:3: otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) )
            {

            			markLeaf(elementTypeProvider.getSingleContainmentReference_NumberSignDigitOneDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2009:3: ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) )
            // PsiInternalSequencerTestLanguage.g:2010:4: ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) )
            {
            // PsiInternalSequencerTestLanguage.g:2010:4: ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) )
            // PsiInternalSequencerTestLanguage.g:2011:5: (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 )
            {
            // PsiInternalSequencerTestLanguage.g:2011:5: (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 )
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
                    // PsiInternalSequencerTestLanguage.g:2012:6: lv_child_1_1= ruleSingleContainmentReferenceChild1
                    {

                    						markComposite(elementTypeProvider.getSingleContainmentReference_ChildSingleContainmentReferenceChild1ParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_child_1_1=ruleSingleContainmentReferenceChild1();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:2024:6: lv_child_1_2= ruleSingleContainmentReferenceChild2
                    {

                    						markComposite(elementTypeProvider.getSingleContainmentReference_ChildSingleContainmentReferenceChild2ParserRuleCall_1_0_1ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_child_1_2=ruleSingleContainmentReferenceChild2();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:2036:6: lv_child_1_3= ruleSingleContainmentReferenceChild3
                    {

                    						markComposite(elementTypeProvider.getSingleContainmentReference_ChildSingleContainmentReferenceChild3ParserRuleCall_1_0_2ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_child_1_3=ruleSingleContainmentReferenceChild3();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;

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
    // $ANTLR end "ruleSingleContainmentReference"


    // $ANTLR start "entryRuleSingleContainmentReferenceChild1"
    // PsiInternalSequencerTestLanguage.g:2054:1: entryRuleSingleContainmentReferenceChild1 returns [Boolean current=false] : iv_ruleSingleContainmentReferenceChild1= ruleSingleContainmentReferenceChild1 EOF ;
    public final Boolean entryRuleSingleContainmentReferenceChild1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleContainmentReferenceChild1 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2054:74: (iv_ruleSingleContainmentReferenceChild1= ruleSingleContainmentReferenceChild1 EOF )
            // PsiInternalSequencerTestLanguage.g:2055:2: iv_ruleSingleContainmentReferenceChild1= ruleSingleContainmentReferenceChild1 EOF
            {
             markComposite(elementTypeProvider.getSingleContainmentReferenceChild1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleContainmentReferenceChild1=ruleSingleContainmentReferenceChild1();

            state._fsp--;

             current =iv_ruleSingleContainmentReferenceChild1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleContainmentReferenceChild1"


    // $ANTLR start "ruleSingleContainmentReferenceChild1"
    // PsiInternalSequencerTestLanguage.g:2061:1: ruleSingleContainmentReferenceChild1 returns [Boolean current=false] : ( (lv_val_0_0= 'kw1' ) ) ;
    public final Boolean ruleSingleContainmentReferenceChild1() throws RecognitionException {
        Boolean current = false;

        Token lv_val_0_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2062:1: ( ( (lv_val_0_0= 'kw1' ) ) )
            // PsiInternalSequencerTestLanguage.g:2063:2: ( (lv_val_0_0= 'kw1' ) )
            {
            // PsiInternalSequencerTestLanguage.g:2063:2: ( (lv_val_0_0= 'kw1' ) )
            // PsiInternalSequencerTestLanguage.g:2064:3: (lv_val_0_0= 'kw1' )
            {
            // PsiInternalSequencerTestLanguage.g:2064:3: (lv_val_0_0= 'kw1' )
            // PsiInternalSequencerTestLanguage.g:2065:4: lv_val_0_0= 'kw1'
            {

            				markLeaf(elementTypeProvider.getSingleContainmentReferenceChild1_ValKw1Keyword_0ElementType());
            			
            lv_val_0_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_val_0_0);
            			

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
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
    // $ANTLR end "ruleSingleContainmentReferenceChild1"


    // $ANTLR start "entryRuleSingleContainmentReferenceChild2"
    // PsiInternalSequencerTestLanguage.g:2083:1: entryRuleSingleContainmentReferenceChild2 returns [Boolean current=false] : iv_ruleSingleContainmentReferenceChild2= ruleSingleContainmentReferenceChild2 EOF ;
    public final Boolean entryRuleSingleContainmentReferenceChild2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleContainmentReferenceChild2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2083:74: (iv_ruleSingleContainmentReferenceChild2= ruleSingleContainmentReferenceChild2 EOF )
            // PsiInternalSequencerTestLanguage.g:2084:2: iv_ruleSingleContainmentReferenceChild2= ruleSingleContainmentReferenceChild2 EOF
            {
             markComposite(elementTypeProvider.getSingleContainmentReferenceChild2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleContainmentReferenceChild2=ruleSingleContainmentReferenceChild2();

            state._fsp--;

             current =iv_ruleSingleContainmentReferenceChild2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleContainmentReferenceChild2"


    // $ANTLR start "ruleSingleContainmentReferenceChild2"
    // PsiInternalSequencerTestLanguage.g:2090:1: ruleSingleContainmentReferenceChild2 returns [Boolean current=false] : ( (lv_val_0_0= 'kw2' ) ) ;
    public final Boolean ruleSingleContainmentReferenceChild2() throws RecognitionException {
        Boolean current = false;

        Token lv_val_0_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2091:1: ( ( (lv_val_0_0= 'kw2' ) ) )
            // PsiInternalSequencerTestLanguage.g:2092:2: ( (lv_val_0_0= 'kw2' ) )
            {
            // PsiInternalSequencerTestLanguage.g:2092:2: ( (lv_val_0_0= 'kw2' ) )
            // PsiInternalSequencerTestLanguage.g:2093:3: (lv_val_0_0= 'kw2' )
            {
            // PsiInternalSequencerTestLanguage.g:2093:3: (lv_val_0_0= 'kw2' )
            // PsiInternalSequencerTestLanguage.g:2094:4: lv_val_0_0= 'kw2'
            {

            				markLeaf(elementTypeProvider.getSingleContainmentReferenceChild2_ValKw2Keyword_0ElementType());
            			
            lv_val_0_0=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_val_0_0);
            			

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
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
    // $ANTLR end "ruleSingleContainmentReferenceChild2"


    // $ANTLR start "entryRuleSingleContainmentReferenceChild3"
    // PsiInternalSequencerTestLanguage.g:2112:1: entryRuleSingleContainmentReferenceChild3 returns [Boolean current=false] : iv_ruleSingleContainmentReferenceChild3= ruleSingleContainmentReferenceChild3 EOF ;
    public final Boolean entryRuleSingleContainmentReferenceChild3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleContainmentReferenceChild3 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2112:74: (iv_ruleSingleContainmentReferenceChild3= ruleSingleContainmentReferenceChild3 EOF )
            // PsiInternalSequencerTestLanguage.g:2113:2: iv_ruleSingleContainmentReferenceChild3= ruleSingleContainmentReferenceChild3 EOF
            {
             markComposite(elementTypeProvider.getSingleContainmentReferenceChild3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleContainmentReferenceChild3=ruleSingleContainmentReferenceChild3();

            state._fsp--;

             current =iv_ruleSingleContainmentReferenceChild3; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleSingleContainmentReferenceChild3"


    // $ANTLR start "ruleSingleContainmentReferenceChild3"
    // PsiInternalSequencerTestLanguage.g:2119:1: ruleSingleContainmentReferenceChild3 returns [Boolean current=false] : ( (lv_val_0_0= 'kw3' ) ) ;
    public final Boolean ruleSingleContainmentReferenceChild3() throws RecognitionException {
        Boolean current = false;

        Token lv_val_0_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2120:1: ( ( (lv_val_0_0= 'kw3' ) ) )
            // PsiInternalSequencerTestLanguage.g:2121:2: ( (lv_val_0_0= 'kw3' ) )
            {
            // PsiInternalSequencerTestLanguage.g:2121:2: ( (lv_val_0_0= 'kw3' ) )
            // PsiInternalSequencerTestLanguage.g:2122:3: (lv_val_0_0= 'kw3' )
            {
            // PsiInternalSequencerTestLanguage.g:2122:3: (lv_val_0_0= 'kw3' )
            // PsiInternalSequencerTestLanguage.g:2123:4: lv_val_0_0= 'kw3'
            {

            				markLeaf(elementTypeProvider.getSingleContainmentReferenceChild3_ValKw3Keyword_0ElementType());
            			
            lv_val_0_0=(Token)match(input,19,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_val_0_0);
            			

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
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
    // $ANTLR end "ruleSingleContainmentReferenceChild3"


    // $ANTLR start "entryRuleMultiKeywords"
    // PsiInternalSequencerTestLanguage.g:2141:1: entryRuleMultiKeywords returns [Boolean current=false] : iv_ruleMultiKeywords= ruleMultiKeywords EOF ;
    public final Boolean entryRuleMultiKeywords() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMultiKeywords = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2141:55: (iv_ruleMultiKeywords= ruleMultiKeywords EOF )
            // PsiInternalSequencerTestLanguage.g:2142:2: iv_ruleMultiKeywords= ruleMultiKeywords EOF
            {
             markComposite(elementTypeProvider.getMultiKeywordsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiKeywords=ruleMultiKeywords();

            state._fsp--;

             current =iv_ruleMultiKeywords; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleMultiKeywords"


    // $ANTLR start "ruleMultiKeywords"
    // PsiInternalSequencerTestLanguage.g:2148:1: ruleMultiKeywords returns [Boolean current=false] : (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) ;
    public final Boolean ruleMultiKeywords() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2149:1: ( (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2150:2: (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2150:2: (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2151:3: otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            {

            			markLeaf(elementTypeProvider.getMultiKeywords_NumberSignDigitOneDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2158:3: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            // PsiInternalSequencerTestLanguage.g:2159:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            {
            // PsiInternalSequencerTestLanguage.g:2159:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            // PsiInternalSequencerTestLanguage.g:2160:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
            {
            // PsiInternalSequencerTestLanguage.g:2160:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
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
                    // PsiInternalSequencerTestLanguage.g:2161:6: lv_val_1_1= 'kw1'
                    {

                    						markLeaf(elementTypeProvider.getMultiKeywords_ValKw1Keyword_1_0_0ElementType());
                    					
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_1);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:2175:6: lv_val_1_2= 'kw2'
                    {

                    						markLeaf(elementTypeProvider.getMultiKeywords_ValKw2Keyword_1_0_1ElementType());
                    					
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_2);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:2189:6: lv_val_1_3= 'kw3'
                    {

                    						markLeaf(elementTypeProvider.getMultiKeywords_ValKw3Keyword_1_0_2ElementType());
                    					
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_3);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;

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
    // $ANTLR end "ruleMultiKeywords"


    // $ANTLR start "entryRuleMultiKeywordsOrID"
    // PsiInternalSequencerTestLanguage.g:2209:1: entryRuleMultiKeywordsOrID returns [Boolean current=false] : iv_ruleMultiKeywordsOrID= ruleMultiKeywordsOrID EOF ;
    public final Boolean entryRuleMultiKeywordsOrID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMultiKeywordsOrID = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2209:59: (iv_ruleMultiKeywordsOrID= ruleMultiKeywordsOrID EOF )
            // PsiInternalSequencerTestLanguage.g:2210:2: iv_ruleMultiKeywordsOrID= ruleMultiKeywordsOrID EOF
            {
             markComposite(elementTypeProvider.getMultiKeywordsOrIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiKeywordsOrID=ruleMultiKeywordsOrID();

            state._fsp--;

             current =iv_ruleMultiKeywordsOrID; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleMultiKeywordsOrID"


    // $ANTLR start "ruleMultiKeywordsOrID"
    // PsiInternalSequencerTestLanguage.g:2216:1: ruleMultiKeywordsOrID returns [Boolean current=false] : (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) ;
    public final Boolean ruleMultiKeywordsOrID() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;
        Token lv_val_1_4=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2217:1: ( (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2218:2: (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2218:2: (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2219:3: otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            {

            			markLeaf(elementTypeProvider.getMultiKeywordsOrID_NumberSignDigitOneDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_17); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2226:3: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:2227:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            {
            // PsiInternalSequencerTestLanguage.g:2227:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:2228:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:2228:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
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
                    // PsiInternalSequencerTestLanguage.g:2229:6: lv_val_1_1= 'kw1'
                    {

                    						markLeaf(elementTypeProvider.getMultiKeywordsOrID_ValKw1Keyword_1_0_0ElementType());
                    					
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_1);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:2243:6: lv_val_1_2= 'kw2'
                    {

                    						markLeaf(elementTypeProvider.getMultiKeywordsOrID_ValKw2Keyword_1_0_1ElementType());
                    					
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_2);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:2257:6: lv_val_1_3= 'kw3'
                    {

                    						markLeaf(elementTypeProvider.getMultiKeywordsOrID_ValKw3Keyword_1_0_2ElementType());
                    					
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_3);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 4 :
                    // PsiInternalSequencerTestLanguage.g:2271:6: lv_val_1_4= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getMultiKeywordsOrID_ValIDTerminalRuleCall_1_0_3ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val_1_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_4);
                    					

                    }
                    break;

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
    // $ANTLR end "ruleMultiKeywordsOrID"


    // $ANTLR start "entryRuleMultiTerminals"
    // PsiInternalSequencerTestLanguage.g:2291:1: entryRuleMultiTerminals returns [Boolean current=false] : iv_ruleMultiTerminals= ruleMultiTerminals EOF ;
    public final Boolean entryRuleMultiTerminals() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMultiTerminals = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2291:56: (iv_ruleMultiTerminals= ruleMultiTerminals EOF )
            // PsiInternalSequencerTestLanguage.g:2292:2: iv_ruleMultiTerminals= ruleMultiTerminals EOF
            {
             markComposite(elementTypeProvider.getMultiTerminalsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiTerminals=ruleMultiTerminals();

            state._fsp--;

             current =iv_ruleMultiTerminals; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleMultiTerminals"


    // $ANTLR start "ruleMultiTerminals"
    // PsiInternalSequencerTestLanguage.g:2298:1: ruleMultiTerminals returns [Boolean current=false] : (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) ;
    public final Boolean ruleMultiTerminals() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2299:1: ( (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2300:2: (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2300:2: (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2301:3: otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            {

            			markLeaf(elementTypeProvider.getMultiTerminals_NumberSignDigitOneDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_18); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2308:3: ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            // PsiInternalSequencerTestLanguage.g:2309:4: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            {
            // PsiInternalSequencerTestLanguage.g:2309:4: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            // PsiInternalSequencerTestLanguage.g:2310:5: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
            {
            // PsiInternalSequencerTestLanguage.g:2310:5: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
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
                    // PsiInternalSequencerTestLanguage.g:2311:6: lv_val_1_1= RULE_ID1
                    {

                    						markLeaf(elementTypeProvider.getMultiTerminals_ValID1TerminalRuleCall_1_0_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:2325:6: lv_val_1_2= RULE_ID2
                    {

                    						markLeaf(elementTypeProvider.getMultiTerminals_ValID2TerminalRuleCall_1_0_1ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_2);
                    					

                    }
                    break;

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
    // $ANTLR end "ruleMultiTerminals"


    // $ANTLR start "entryRuleDependentAlternative1"
    // PsiInternalSequencerTestLanguage.g:2345:1: entryRuleDependentAlternative1 returns [Boolean current=false] : iv_ruleDependentAlternative1= ruleDependentAlternative1 EOF ;
    public final Boolean entryRuleDependentAlternative1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDependentAlternative1 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2345:63: (iv_ruleDependentAlternative1= ruleDependentAlternative1 EOF )
            // PsiInternalSequencerTestLanguage.g:2346:2: iv_ruleDependentAlternative1= ruleDependentAlternative1 EOF
            {
             markComposite(elementTypeProvider.getDependentAlternative1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDependentAlternative1=ruleDependentAlternative1();

            state._fsp--;

             current =iv_ruleDependentAlternative1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleDependentAlternative1"


    // $ANTLR start "ruleDependentAlternative1"
    // PsiInternalSequencerTestLanguage.g:2352:1: ruleDependentAlternative1 returns [Boolean current=false] : (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) ) ;
    public final Boolean ruleDependentAlternative1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token lv_val_2_0=null;
        Token lv_flag_3_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2353:1: ( (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2354:2: (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2354:2: (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2355:3: otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) )
            {

            			markLeaf(elementTypeProvider.getDependentAlternative1_NumberSignDigitOneDigitNineKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2362:3: ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) )
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
                    // PsiInternalSequencerTestLanguage.g:2363:4: ( (lv_val_1_0= RULE_ID ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:2363:4: ( (lv_val_1_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:2364:5: (lv_val_1_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:2364:5: (lv_val_1_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:2365:6: lv_val_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getDependentAlternative1_ValIDTerminalRuleCall_1_0_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_val_1_0);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:2381:4: ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:2381:4: ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) )
                    // PsiInternalSequencerTestLanguage.g:2382:5: ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:2382:5: ( (lv_val_2_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:2383:6: (lv_val_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:2383:6: (lv_val_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:2384:7: lv_val_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getDependentAlternative1_ValIDTerminalRuleCall_1_1_0_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    							doneLeaf(lv_val_2_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:2399:5: ( (lv_flag_3_0= 'kw1' ) )
                    // PsiInternalSequencerTestLanguage.g:2400:6: (lv_flag_3_0= 'kw1' )
                    {
                    // PsiInternalSequencerTestLanguage.g:2400:6: (lv_flag_3_0= 'kw1' )
                    // PsiInternalSequencerTestLanguage.g:2401:7: lv_flag_3_0= 'kw1'
                    {

                    							markLeaf(elementTypeProvider.getDependentAlternative1_FlagKw1Keyword_1_1_1_0ElementType());
                    						
                    lv_flag_3_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_flag_3_0);
                    						

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDependentAlternative1"


    // $ANTLR start "entryRuleDependentAlternative2"
    // PsiInternalSequencerTestLanguage.g:2422:1: entryRuleDependentAlternative2 returns [Boolean current=false] : iv_ruleDependentAlternative2= ruleDependentAlternative2 EOF ;
    public final Boolean entryRuleDependentAlternative2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDependentAlternative2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2422:63: (iv_ruleDependentAlternative2= ruleDependentAlternative2 EOF )
            // PsiInternalSequencerTestLanguage.g:2423:2: iv_ruleDependentAlternative2= ruleDependentAlternative2 EOF
            {
             markComposite(elementTypeProvider.getDependentAlternative2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDependentAlternative2=ruleDependentAlternative2();

            state._fsp--;

             current =iv_ruleDependentAlternative2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleDependentAlternative2"


    // $ANTLR start "ruleDependentAlternative2"
    // PsiInternalSequencerTestLanguage.g:2429:1: ruleDependentAlternative2 returns [Boolean current=false] : (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) ) ;
    public final Boolean ruleDependentAlternative2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token lv_val_2_0=null;
        Token lv_val_3_0=null;
        Token lv_flag_4_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2430:1: ( (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2431:2: (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2431:2: (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2432:3: otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )
            {

            			markLeaf(elementTypeProvider.getDependentAlternative2_NumberSignDigitTwoDigitZeroKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2439:3: ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:2440:4: ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ )
                    {
                    // PsiInternalSequencerTestLanguage.g:2440:4: ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ )
                    // PsiInternalSequencerTestLanguage.g:2441:5: ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+
                    {
                    // PsiInternalSequencerTestLanguage.g:2441:5: ( (lv_val_1_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:2442:6: (lv_val_1_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:2442:6: (lv_val_1_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:2443:7: lv_val_1_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getDependentAlternative2_ValIDTerminalRuleCall_1_0_0_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							doneLeaf(lv_val_1_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:2458:5: ( (lv_val_2_0= RULE_ID ) )+
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
                    	    // PsiInternalSequencerTestLanguage.g:2459:6: (lv_val_2_0= RULE_ID )
                    	    {
                    	    // PsiInternalSequencerTestLanguage.g:2459:6: (lv_val_2_0= RULE_ID )
                    	    // PsiInternalSequencerTestLanguage.g:2460:7: lv_val_2_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getDependentAlternative2_ValIDTerminalRuleCall_1_0_1_0ElementType());
                    	    						

                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						
                    	    lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    	    							doneLeaf(lv_val_2_0);
                    	    						

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
                    // PsiInternalSequencerTestLanguage.g:2477:4: ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:2477:4: ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) )
                    // PsiInternalSequencerTestLanguage.g:2478:5: ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:2478:5: ( (lv_val_3_0= RULE_ID ) )+
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
                    	    // PsiInternalSequencerTestLanguage.g:2479:6: (lv_val_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalSequencerTestLanguage.g:2479:6: (lv_val_3_0= RULE_ID )
                    	    // PsiInternalSequencerTestLanguage.g:2480:7: lv_val_3_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getDependentAlternative2_ValIDTerminalRuleCall_1_1_0_0ElementType());
                    	    						

                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						
                    	    lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); 

                    	    							doneLeaf(lv_val_3_0);
                    	    						

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

                    // PsiInternalSequencerTestLanguage.g:2495:5: ( (lv_flag_4_0= 'kw1' ) )
                    // PsiInternalSequencerTestLanguage.g:2496:6: (lv_flag_4_0= 'kw1' )
                    {
                    // PsiInternalSequencerTestLanguage.g:2496:6: (lv_flag_4_0= 'kw1' )
                    // PsiInternalSequencerTestLanguage.g:2497:7: lv_flag_4_0= 'kw1'
                    {

                    							markLeaf(elementTypeProvider.getDependentAlternative2_FlagKw1Keyword_1_1_1_0ElementType());
                    						
                    lv_flag_4_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_flag_4_0);
                    						

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDependentAlternative2"


    // $ANTLR start "entryRuleOptional"
    // PsiInternalSequencerTestLanguage.g:2518:1: entryRuleOptional returns [Boolean current=false] : iv_ruleOptional= ruleOptional EOF ;
    public final Boolean entryRuleOptional() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOptional = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2518:50: (iv_ruleOptional= ruleOptional EOF )
            // PsiInternalSequencerTestLanguage.g:2519:2: iv_ruleOptional= ruleOptional EOF
            {
             markComposite(elementTypeProvider.getOptionalElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptional=ruleOptional();

            state._fsp--;

             current =iv_ruleOptional; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleOptional"


    // $ANTLR start "ruleOptional"
    // PsiInternalSequencerTestLanguage.g:2525:1: ruleOptional returns [Boolean current=false] : (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? ) ;
    public final Boolean ruleOptional() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_int0_1_0=null;
        Token lv_int1_2_0=null;
        Token lv_int2_3_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2526:1: ( (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? ) )
            // PsiInternalSequencerTestLanguage.g:2527:2: (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? )
            {
            // PsiInternalSequencerTestLanguage.g:2527:2: (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? )
            // PsiInternalSequencerTestLanguage.g:2528:3: otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )?
            {

            			markLeaf(elementTypeProvider.getOptional_NumberSignDigitTwoDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_21); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2535:3: ( (lv_int0_1_0= RULE_INT ) )
            // PsiInternalSequencerTestLanguage.g:2536:4: (lv_int0_1_0= RULE_INT )
            {
            // PsiInternalSequencerTestLanguage.g:2536:4: (lv_int0_1_0= RULE_INT )
            // PsiInternalSequencerTestLanguage.g:2537:5: lv_int0_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getOptional_Int0INTTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_int0_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_22); 

            					doneLeaf(lv_int0_1_0);
            				

            }


            }

            // PsiInternalSequencerTestLanguage.g:2552:3: ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_INT) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:2553:4: ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:2553:4: ( (lv_int1_2_0= RULE_INT ) )
                    // PsiInternalSequencerTestLanguage.g:2554:5: (lv_int1_2_0= RULE_INT )
                    {
                    // PsiInternalSequencerTestLanguage.g:2554:5: (lv_int1_2_0= RULE_INT )
                    // PsiInternalSequencerTestLanguage.g:2555:6: lv_int1_2_0= RULE_INT
                    {

                    						markLeaf(elementTypeProvider.getOptional_Int1INTTerminalRuleCall_2_0_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_int1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_21); 

                    						doneLeaf(lv_int1_2_0);
                    					

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:2570:4: ( (lv_int2_3_0= RULE_INT ) )
                    // PsiInternalSequencerTestLanguage.g:2571:5: (lv_int2_3_0= RULE_INT )
                    {
                    // PsiInternalSequencerTestLanguage.g:2571:5: (lv_int2_3_0= RULE_INT )
                    // PsiInternalSequencerTestLanguage.g:2572:6: lv_int2_3_0= RULE_INT
                    {

                    						markLeaf(elementTypeProvider.getOptional_Int2INTTerminalRuleCall_2_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_int2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_int2_3_0);
                    					

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
    // $ANTLR end "ruleOptional"


    // $ANTLR start "entryRuleFloat"
    // PsiInternalSequencerTestLanguage.g:2592:1: entryRuleFloat returns [Boolean current=false] : iv_ruleFloat= ruleFloat EOF ;
    public final Boolean entryRuleFloat() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFloat = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2592:47: (iv_ruleFloat= ruleFloat EOF )
            // PsiInternalSequencerTestLanguage.g:2593:2: iv_ruleFloat= ruleFloat EOF
            {
             markComposite(elementTypeProvider.getFloatElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFloat=ruleFloat();

            state._fsp--;

             current =iv_ruleFloat; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleFloat"


    // $ANTLR start "ruleFloat"
    // PsiInternalSequencerTestLanguage.g:2599:1: ruleFloat returns [Boolean current=false] : (otherlv_0= '#22' () otherlv_2= 'Bye' ) ;
    public final Boolean ruleFloat() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2600:1: ( (otherlv_0= '#22' () otherlv_2= 'Bye' ) )
            // PsiInternalSequencerTestLanguage.g:2601:2: (otherlv_0= '#22' () otherlv_2= 'Bye' )
            {
            // PsiInternalSequencerTestLanguage.g:2601:2: (otherlv_0= '#22' () otherlv_2= 'Bye' )
            // PsiInternalSequencerTestLanguage.g:2602:3: otherlv_0= '#22' () otherlv_2= 'Bye'
            {

            			markLeaf(elementTypeProvider.getFloat_NumberSignDigitTwoDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_23); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2609:3: ()
            // PsiInternalSequencerTestLanguage.g:2610:4: 
            {

            				precedeComposite(elementTypeProvider.getFloat_FloatAction_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getFloat_ByeKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,43,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

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
    // $ANTLR end "ruleFloat"


    // $ANTLR start "entryRuleUnorderedAlternative"
    // PsiInternalSequencerTestLanguage.g:2627:1: entryRuleUnorderedAlternative returns [Boolean current=false] : iv_ruleUnorderedAlternative= ruleUnorderedAlternative EOF ;
    public final Boolean entryRuleUnorderedAlternative() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedAlternative = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2627:62: (iv_ruleUnorderedAlternative= ruleUnorderedAlternative EOF )
            // PsiInternalSequencerTestLanguage.g:2628:2: iv_ruleUnorderedAlternative= ruleUnorderedAlternative EOF
            {
             markComposite(elementTypeProvider.getUnorderedAlternativeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedAlternative=ruleUnorderedAlternative();

            state._fsp--;

             current =iv_ruleUnorderedAlternative; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedAlternative"


    // $ANTLR start "ruleUnorderedAlternative"
    // PsiInternalSequencerTestLanguage.g:2634:1: ruleUnorderedAlternative returns [Boolean current=false] : (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* ) ;
    public final Boolean ruleUnorderedAlternative() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Boolean lv_val3_4_0 = null;

        Boolean lv_val4_5_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2635:1: ( (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:2636:2: (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* )
            {
            // PsiInternalSequencerTestLanguage.g:2636:2: (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* )
            // PsiInternalSequencerTestLanguage.g:2637:3: otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )*
            {

            			markLeaf(elementTypeProvider.getUnorderedAlternative_NumberSignDigitTwoDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_24); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2644:3: ()
            // PsiInternalSequencerTestLanguage.g:2645:4: 
            {

            				precedeComposite(elementTypeProvider.getUnorderedAlternative_UnorderedAlternativeAction_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalSequencerTestLanguage.g:2651:3: ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )*
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
            	    // PsiInternalSequencerTestLanguage.g:2652:4: ( (lv_val1_2_0= RULE_ID ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2652:4: ( (lv_val1_2_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:2653:5: (lv_val1_2_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2653:5: (lv_val1_2_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:2654:6: lv_val1_2_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getUnorderedAlternative_Val1IDTerminalRuleCall_2_0_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_24); 

            	    						doneLeaf(lv_val1_2_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSequencerTestLanguage.g:2670:4: ( (lv_val2_3_0= RULE_INT ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2670:4: ( (lv_val2_3_0= RULE_INT ) )
            	    // PsiInternalSequencerTestLanguage.g:2671:5: (lv_val2_3_0= RULE_INT )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2671:5: (lv_val2_3_0= RULE_INT )
            	    // PsiInternalSequencerTestLanguage.g:2672:6: lv_val2_3_0= RULE_INT
            	    {

            	    						markLeaf(elementTypeProvider.getUnorderedAlternative_Val2INTTerminalRuleCall_2_1_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_val2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_24); 

            	    						doneLeaf(lv_val2_3_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalSequencerTestLanguage.g:2688:4: ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2688:4: ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) )
            	    // PsiInternalSequencerTestLanguage.g:2689:5: (lv_val3_4_0= ruleUnorderedAlternativeVal )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2689:5: (lv_val3_4_0= ruleUnorderedAlternativeVal )
            	    // PsiInternalSequencerTestLanguage.g:2690:6: lv_val3_4_0= ruleUnorderedAlternativeVal
            	    {

            	    						markComposite(elementTypeProvider.getUnorderedAlternative_Val3UnorderedAlternativeValParserRuleCall_2_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_24);
            	    lv_val3_4_0=ruleUnorderedAlternativeVal();

            	    state._fsp--;


            	    						doneComposite();
            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // PsiInternalSequencerTestLanguage.g:2704:4: ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2704:4: ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) )
            	    // PsiInternalSequencerTestLanguage.g:2705:5: (lv_val4_5_0= ruleUnorderedAlternativeValDelegate )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2705:5: (lv_val4_5_0= ruleUnorderedAlternativeValDelegate )
            	    // PsiInternalSequencerTestLanguage.g:2706:6: lv_val4_5_0= ruleUnorderedAlternativeValDelegate
            	    {

            	    						markComposite(elementTypeProvider.getUnorderedAlternative_Val4UnorderedAlternativeValDelegateParserRuleCall_2_3_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_24);
            	    lv_val4_5_0=ruleUnorderedAlternativeValDelegate();

            	    state._fsp--;


            	    						doneComposite();
            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedAlternative"


    // $ANTLR start "entryRuleUnorderedAlternativeVal"
    // PsiInternalSequencerTestLanguage.g:2724:1: entryRuleUnorderedAlternativeVal returns [Boolean current=false] : iv_ruleUnorderedAlternativeVal= ruleUnorderedAlternativeVal EOF ;
    public final Boolean entryRuleUnorderedAlternativeVal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedAlternativeVal = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2724:65: (iv_ruleUnorderedAlternativeVal= ruleUnorderedAlternativeVal EOF )
            // PsiInternalSequencerTestLanguage.g:2725:2: iv_ruleUnorderedAlternativeVal= ruleUnorderedAlternativeVal EOF
            {
             markComposite(elementTypeProvider.getUnorderedAlternativeValElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedAlternativeVal=ruleUnorderedAlternativeVal();

            state._fsp--;

             current =iv_ruleUnorderedAlternativeVal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedAlternativeVal"


    // $ANTLR start "ruleUnorderedAlternativeVal"
    // PsiInternalSequencerTestLanguage.g:2731:1: ruleUnorderedAlternativeVal returns [Boolean current=false] : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleUnorderedAlternativeVal() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2732:1: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2733:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2733:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:2734:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedAlternativeVal_Kw1Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2741:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:2742:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:2742:4: (lv_val_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:2743:5: lv_val_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnorderedAlternativeVal_ValIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_val_1_0);
            				

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
    // $ANTLR end "ruleUnorderedAlternativeVal"


    // $ANTLR start "entryRuleUnorderedAlternativeValDelegate"
    // PsiInternalSequencerTestLanguage.g:2762:1: entryRuleUnorderedAlternativeValDelegate returns [Boolean current=false] : iv_ruleUnorderedAlternativeValDelegate= ruleUnorderedAlternativeValDelegate EOF ;
    public final Boolean entryRuleUnorderedAlternativeValDelegate() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedAlternativeValDelegate = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2762:73: (iv_ruleUnorderedAlternativeValDelegate= ruleUnorderedAlternativeValDelegate EOF )
            // PsiInternalSequencerTestLanguage.g:2763:2: iv_ruleUnorderedAlternativeValDelegate= ruleUnorderedAlternativeValDelegate EOF
            {
             markComposite(elementTypeProvider.getUnorderedAlternativeValDelegateElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedAlternativeValDelegate=ruleUnorderedAlternativeValDelegate();

            state._fsp--;

             current =iv_ruleUnorderedAlternativeValDelegate; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedAlternativeValDelegate"


    // $ANTLR start "ruleUnorderedAlternativeValDelegate"
    // PsiInternalSequencerTestLanguage.g:2769:1: ruleUnorderedAlternativeValDelegate returns [Boolean current=false] : this_UnorderedAlternativeVal2_0= ruleUnorderedAlternativeVal2 ;
    public final Boolean ruleUnorderedAlternativeValDelegate() throws RecognitionException {
        Boolean current = false;

        Boolean this_UnorderedAlternativeVal2_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2770:1: (this_UnorderedAlternativeVal2_0= ruleUnorderedAlternativeVal2 )
            // PsiInternalSequencerTestLanguage.g:2771:2: this_UnorderedAlternativeVal2_0= ruleUnorderedAlternativeVal2
            {

            		markComposite(elementTypeProvider.getUnorderedAlternativeValDelegate_UnorderedAlternativeVal2ParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_2);
            this_UnorderedAlternativeVal2_0=ruleUnorderedAlternativeVal2();

            state._fsp--;


            		current = this_UnorderedAlternativeVal2_0;
            		doneComposite();
            	

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
    // $ANTLR end "ruleUnorderedAlternativeValDelegate"


    // $ANTLR start "entryRuleUnorderedAlternativeVal2"
    // PsiInternalSequencerTestLanguage.g:2782:1: entryRuleUnorderedAlternativeVal2 returns [Boolean current=false] : iv_ruleUnorderedAlternativeVal2= ruleUnorderedAlternativeVal2 EOF ;
    public final Boolean entryRuleUnorderedAlternativeVal2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedAlternativeVal2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2782:66: (iv_ruleUnorderedAlternativeVal2= ruleUnorderedAlternativeVal2 EOF )
            // PsiInternalSequencerTestLanguage.g:2783:2: iv_ruleUnorderedAlternativeVal2= ruleUnorderedAlternativeVal2 EOF
            {
             markComposite(elementTypeProvider.getUnorderedAlternativeVal2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedAlternativeVal2=ruleUnorderedAlternativeVal2();

            state._fsp--;

             current =iv_ruleUnorderedAlternativeVal2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedAlternativeVal2"


    // $ANTLR start "ruleUnorderedAlternativeVal2"
    // PsiInternalSequencerTestLanguage.g:2789:1: ruleUnorderedAlternativeVal2 returns [Boolean current=false] : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleUnorderedAlternativeVal2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2790:1: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2791:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2791:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:2792:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedAlternativeVal2_Kw2Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2799:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:2800:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:2800:4: (lv_val_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:2801:5: lv_val_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnorderedAlternativeVal2_ValIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_val_1_0);
            				

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
    // $ANTLR end "ruleUnorderedAlternativeVal2"


    // $ANTLR start "entryRuleUnorderedGroup"
    // PsiInternalSequencerTestLanguage.g:2820:1: entryRuleUnorderedGroup returns [Boolean current=false] : iv_ruleUnorderedGroup= ruleUnorderedGroup EOF ;
    public final Boolean entryRuleUnorderedGroup() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroup = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2820:56: (iv_ruleUnorderedGroup= ruleUnorderedGroup EOF )
            // PsiInternalSequencerTestLanguage.g:2821:2: iv_ruleUnorderedGroup= ruleUnorderedGroup EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroup=ruleUnorderedGroup();

            state._fsp--;

             current =iv_ruleUnorderedGroup; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedGroup"


    // $ANTLR start "ruleUnorderedGroup"
    // PsiInternalSequencerTestLanguage.g:2827:1: ruleUnorderedGroup returns [Boolean current=false] : (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) ) ;
    public final Boolean ruleUnorderedGroup() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Boolean lv_val3_4_0 = null;

        Boolean lv_val4_5_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2828:1: ( (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2829:2: (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2829:2: (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) )
            // PsiInternalSequencerTestLanguage.g:2830:3: otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedGroup_NumberSignDigitTwoDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_25); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2837:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) )
            // PsiInternalSequencerTestLanguage.g:2838:4: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) )
            {
            // PsiInternalSequencerTestLanguage.g:2838:4: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) )
            // PsiInternalSequencerTestLanguage.g:2839:5: ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            				
            // PsiInternalSequencerTestLanguage.g:2842:5: ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?)
            // PsiInternalSequencerTestLanguage.g:2843:6: ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?
            {
            // PsiInternalSequencerTestLanguage.g:2843:6: ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+
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
            	    // PsiInternalSequencerTestLanguage.g:2844:4: ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2844:4: ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2845:5: {...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2845:111: ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2846:6: ({...}? => ( (lv_val1_2_0= RULE_ID ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:2849:9: ({...}? => ( (lv_val1_2_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2849:10: {...}? => ( (lv_val1_2_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2849:19: ( (lv_val1_2_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:2849:20: (lv_val1_2_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2849:20: (lv_val1_2_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:2850:10: lv_val1_2_0= RULE_ID
            	    {

            	    										markLeaf(elementTypeProvider.getUnorderedGroup_Val1IDTerminalRuleCall_1_0_0ElementType());
            	    									

            	    										if(!current) {
            	    											associateWithSemanticElement();
            	    											current = true;
            	    										}
            	    									
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_24); 

            	    										doneLeaf(lv_val1_2_0);
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSequencerTestLanguage.g:2870:4: ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2870:4: ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2871:5: {...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2871:111: ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2872:6: ({...}? => ( (lv_val2_3_0= RULE_INT ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:2875:9: ({...}? => ( (lv_val2_3_0= RULE_INT ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2875:10: {...}? => ( (lv_val2_3_0= RULE_INT ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2875:19: ( (lv_val2_3_0= RULE_INT ) )
            	    // PsiInternalSequencerTestLanguage.g:2875:20: (lv_val2_3_0= RULE_INT )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2875:20: (lv_val2_3_0= RULE_INT )
            	    // PsiInternalSequencerTestLanguage.g:2876:10: lv_val2_3_0= RULE_INT
            	    {

            	    										markLeaf(elementTypeProvider.getUnorderedGroup_Val2INTTerminalRuleCall_1_1_0ElementType());
            	    									

            	    										if(!current) {
            	    											associateWithSemanticElement();
            	    											current = true;
            	    										}
            	    									
            	    lv_val2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_24); 

            	    										doneLeaf(lv_val2_3_0);
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalSequencerTestLanguage.g:2896:4: ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2896:4: ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2897:5: {...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2897:111: ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2898:6: ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:2901:9: ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2901:10: {...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2901:19: ( (lv_val3_4_0= ruleUnorderedGroupVal ) )
            	    // PsiInternalSequencerTestLanguage.g:2901:20: (lv_val3_4_0= ruleUnorderedGroupVal )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2901:20: (lv_val3_4_0= ruleUnorderedGroupVal )
            	    // PsiInternalSequencerTestLanguage.g:2902:10: lv_val3_4_0= ruleUnorderedGroupVal
            	    {

            	    										markComposite(elementTypeProvider.getUnorderedGroup_Val3UnorderedGroupValParserRuleCall_1_2_0ElementType());
            	    									
            	    pushFollow(FollowSets000.FOLLOW_24);
            	    lv_val3_4_0=ruleUnorderedGroupVal();

            	    state._fsp--;


            	    										doneComposite();
            	    										if(!current) {
            	    											associateWithSemanticElement();
            	    											current = true;
            	    										}
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // PsiInternalSequencerTestLanguage.g:2920:4: ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2920:4: ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2921:5: {...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2921:111: ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2922:6: ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:2925:9: ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2925:10: {...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2925:19: ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) )
            	    // PsiInternalSequencerTestLanguage.g:2925:20: (lv_val4_5_0= ruleUnorderedGroupValDelegate )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2925:20: (lv_val4_5_0= ruleUnorderedGroupValDelegate )
            	    // PsiInternalSequencerTestLanguage.g:2926:10: lv_val4_5_0= ruleUnorderedGroupValDelegate
            	    {

            	    										markComposite(elementTypeProvider.getUnorderedGroup_Val4UnorderedGroupValDelegateParserRuleCall_1_3_0ElementType());
            	    									
            	    pushFollow(FollowSets000.FOLLOW_24);
            	    lv_val4_5_0=ruleUnorderedGroupValDelegate();

            	    state._fsp--;


            	    										doneComposite();
            	    										if(!current) {
            	    											associateWithSemanticElement();
            	    											current = true;
            	    										}
            	    									

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleUnorderedGroupVal"
    // PsiInternalSequencerTestLanguage.g:2956:1: entryRuleUnorderedGroupVal returns [Boolean current=false] : iv_ruleUnorderedGroupVal= ruleUnorderedGroupVal EOF ;
    public final Boolean entryRuleUnorderedGroupVal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroupVal = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2956:59: (iv_ruleUnorderedGroupVal= ruleUnorderedGroupVal EOF )
            // PsiInternalSequencerTestLanguage.g:2957:2: iv_ruleUnorderedGroupVal= ruleUnorderedGroupVal EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupValElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroupVal=ruleUnorderedGroupVal();

            state._fsp--;

             current =iv_ruleUnorderedGroupVal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedGroupVal"


    // $ANTLR start "ruleUnorderedGroupVal"
    // PsiInternalSequencerTestLanguage.g:2963:1: ruleUnorderedGroupVal returns [Boolean current=false] : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleUnorderedGroupVal() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2964:1: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2965:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2965:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:2966:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedGroupVal_Kw1Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2973:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:2974:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:2974:4: (lv_val_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:2975:5: lv_val_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnorderedGroupVal_ValIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_val_1_0);
            				

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
    // $ANTLR end "ruleUnorderedGroupVal"


    // $ANTLR start "entryRuleUnorderedGroupValDelegate"
    // PsiInternalSequencerTestLanguage.g:2994:1: entryRuleUnorderedGroupValDelegate returns [Boolean current=false] : iv_ruleUnorderedGroupValDelegate= ruleUnorderedGroupValDelegate EOF ;
    public final Boolean entryRuleUnorderedGroupValDelegate() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroupValDelegate = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2994:67: (iv_ruleUnorderedGroupValDelegate= ruleUnorderedGroupValDelegate EOF )
            // PsiInternalSequencerTestLanguage.g:2995:2: iv_ruleUnorderedGroupValDelegate= ruleUnorderedGroupValDelegate EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupValDelegateElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroupValDelegate=ruleUnorderedGroupValDelegate();

            state._fsp--;

             current =iv_ruleUnorderedGroupValDelegate; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedGroupValDelegate"


    // $ANTLR start "ruleUnorderedGroupValDelegate"
    // PsiInternalSequencerTestLanguage.g:3001:1: ruleUnorderedGroupValDelegate returns [Boolean current=false] : this_UnorderedGroupVal2_0= ruleUnorderedGroupVal2 ;
    public final Boolean ruleUnorderedGroupValDelegate() throws RecognitionException {
        Boolean current = false;

        Boolean this_UnorderedGroupVal2_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3002:1: (this_UnorderedGroupVal2_0= ruleUnorderedGroupVal2 )
            // PsiInternalSequencerTestLanguage.g:3003:2: this_UnorderedGroupVal2_0= ruleUnorderedGroupVal2
            {

            		markComposite(elementTypeProvider.getUnorderedGroupValDelegate_UnorderedGroupVal2ParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_2);
            this_UnorderedGroupVal2_0=ruleUnorderedGroupVal2();

            state._fsp--;


            		current = this_UnorderedGroupVal2_0;
            		doneComposite();
            	

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
    // $ANTLR end "ruleUnorderedGroupValDelegate"


    // $ANTLR start "entryRuleUnorderedGroupVal2"
    // PsiInternalSequencerTestLanguage.g:3014:1: entryRuleUnorderedGroupVal2 returns [Boolean current=false] : iv_ruleUnorderedGroupVal2= ruleUnorderedGroupVal2 EOF ;
    public final Boolean entryRuleUnorderedGroupVal2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroupVal2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3014:60: (iv_ruleUnorderedGroupVal2= ruleUnorderedGroupVal2 EOF )
            // PsiInternalSequencerTestLanguage.g:3015:2: iv_ruleUnorderedGroupVal2= ruleUnorderedGroupVal2 EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupVal2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroupVal2=ruleUnorderedGroupVal2();

            state._fsp--;

             current =iv_ruleUnorderedGroupVal2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedGroupVal2"


    // $ANTLR start "ruleUnorderedGroupVal2"
    // PsiInternalSequencerTestLanguage.g:3021:1: ruleUnorderedGroupVal2 returns [Boolean current=false] : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleUnorderedGroupVal2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3022:1: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3023:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3023:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:3024:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedGroupVal2_Kw2Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3031:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:3032:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:3032:4: (lv_val_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:3033:5: lv_val_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnorderedGroupVal2_ValIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_val_1_0);
            				

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
    // $ANTLR end "ruleUnorderedGroupVal2"


    // $ANTLR start "entryRuleUnorderedGroupOptional"
    // PsiInternalSequencerTestLanguage.g:3052:1: entryRuleUnorderedGroupOptional returns [Boolean current=false] : iv_ruleUnorderedGroupOptional= ruleUnorderedGroupOptional EOF ;
    public final Boolean entryRuleUnorderedGroupOptional() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroupOptional = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3052:64: (iv_ruleUnorderedGroupOptional= ruleUnorderedGroupOptional EOF )
            // PsiInternalSequencerTestLanguage.g:3053:2: iv_ruleUnorderedGroupOptional= ruleUnorderedGroupOptional EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupOptionalElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroupOptional=ruleUnorderedGroupOptional();

            state._fsp--;

             current =iv_ruleUnorderedGroupOptional; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedGroupOptional"


    // $ANTLR start "ruleUnorderedGroupOptional"
    // PsiInternalSequencerTestLanguage.g:3059:1: ruleUnorderedGroupOptional returns [Boolean current=false] : (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) ) ;
    public final Boolean ruleUnorderedGroupOptional() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;
        Token otherlv_5=null;
        Token lv_va2_6_0=null;
        Token otherlv_7=null;
        Token lv_val3_8_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3060:1: ( (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3061:2: (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3061:2: (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3062:3: otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedGroupOptional_NumberSignDigitTwoDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_26); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3069:3: ()
            // PsiInternalSequencerTestLanguage.g:3070:4: 
            {

            				precedeComposite(elementTypeProvider.getUnorderedGroupOptional_UnorderedGroupOptionalAction_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalSequencerTestLanguage.g:3076:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) )
            // PsiInternalSequencerTestLanguage.g:3077:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) )
            {
            // PsiInternalSequencerTestLanguage.g:3077:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:3078:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2());
            				
            // PsiInternalSequencerTestLanguage.g:3081:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* )
            // PsiInternalSequencerTestLanguage.g:3082:6: ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )*
            {
            // PsiInternalSequencerTestLanguage.g:3082:6: ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )*
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
            	    // PsiInternalSequencerTestLanguage.g:3083:4: ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3083:4: ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3084:5: {...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3084:119: ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3085:6: ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:3088:9: ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3088:10: {...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3088:19: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3088:20: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) )
            	    {

            	    									markLeaf(elementTypeProvider.getUnorderedGroupOptional_Kw1Keyword_2_0_0ElementType());
            	    								
            	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            	    									doneLeaf(otherlv_3);
            	    								
            	    // PsiInternalSequencerTestLanguage.g:3095:9: ( (lv_val1_4_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3096:10: (lv_val1_4_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3096:10: (lv_val1_4_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3097:11: lv_val1_4_0= RULE_ID
            	    {

            	    											markLeaf(elementTypeProvider.getUnorderedGroupOptional_Val1IDTerminalRuleCall_2_0_1_0ElementType());
            	    										

            	    											if(!current) {
            	    												associateWithSemanticElement();
            	    												current = true;
            	    											}
            	    										
            	    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            	    											doneLeaf(lv_val1_4_0);
            	    										

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
            	    // PsiInternalSequencerTestLanguage.g:3118:4: ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3118:4: ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3119:5: {...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3119:119: ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3120:6: ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:3123:9: ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3123:10: {...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3123:19: (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3123:20: otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) )
            	    {

            	    									markLeaf(elementTypeProvider.getUnorderedGroupOptional_Kw2Keyword_2_1_0ElementType());
            	    								
            	    otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            	    									doneLeaf(otherlv_5);
            	    								
            	    // PsiInternalSequencerTestLanguage.g:3130:9: ( (lv_va2_6_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3131:10: (lv_va2_6_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3131:10: (lv_va2_6_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3132:11: lv_va2_6_0= RULE_ID
            	    {

            	    											markLeaf(elementTypeProvider.getUnorderedGroupOptional_Va2IDTerminalRuleCall_2_1_1_0ElementType());
            	    										

            	    											if(!current) {
            	    												associateWithSemanticElement();
            	    												current = true;
            	    											}
            	    										
            	    lv_va2_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            	    											doneLeaf(lv_va2_6_0);
            	    										

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
            	    // PsiInternalSequencerTestLanguage.g:3153:4: ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3153:4: ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3154:5: {...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3154:119: ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3155:6: ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:3158:9: ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3158:10: {...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3158:19: (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3158:20: otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) )
            	    {

            	    									markLeaf(elementTypeProvider.getUnorderedGroupOptional_Kw3Keyword_2_2_0ElementType());
            	    								
            	    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	    									doneLeaf(otherlv_7);
            	    								
            	    // PsiInternalSequencerTestLanguage.g:3165:9: ( (lv_val3_8_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3166:10: (lv_val3_8_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3166:10: (lv_val3_8_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3167:11: lv_val3_8_0= RULE_ID
            	    {

            	    											markLeaf(elementTypeProvider.getUnorderedGroupOptional_Val3IDTerminalRuleCall_2_2_1_0ElementType());
            	    										

            	    											if(!current) {
            	    												associateWithSemanticElement();
            	    												current = true;
            	    											}
            	    										
            	    lv_val3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            	    											doneLeaf(lv_val3_8_0);
            	    										

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedGroupOptional"


    // $ANTLR start "entryRuleUnorderedGroupBoolean"
    // PsiInternalSequencerTestLanguage.g:3199:1: entryRuleUnorderedGroupBoolean returns [Boolean current=false] : iv_ruleUnorderedGroupBoolean= ruleUnorderedGroupBoolean EOF ;
    public final Boolean entryRuleUnorderedGroupBoolean() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroupBoolean = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3199:63: (iv_ruleUnorderedGroupBoolean= ruleUnorderedGroupBoolean EOF )
            // PsiInternalSequencerTestLanguage.g:3200:2: iv_ruleUnorderedGroupBoolean= ruleUnorderedGroupBoolean EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupBooleanElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroupBoolean=ruleUnorderedGroupBoolean();

            state._fsp--;

             current =iv_ruleUnorderedGroupBoolean; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnorderedGroupBoolean"


    // $ANTLR start "ruleUnorderedGroupBoolean"
    // PsiInternalSequencerTestLanguage.g:3206:1: ruleUnorderedGroupBoolean returns [Boolean current=false] : (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) ) ;
    public final Boolean ruleUnorderedGroupBoolean() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_3_0=null;
        Token lv_val2_4_0=null;
        Token lv_val3_5_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3207:1: ( (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3208:2: (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3208:2: (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3209:3: otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedGroupBoolean_NumberSignDigitTwoDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,47,FollowSets000.FOLLOW_26); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3216:3: ()
            // PsiInternalSequencerTestLanguage.g:3217:4: 
            {

            				precedeComposite(elementTypeProvider.getUnorderedGroupBoolean_UnorderedGroupBooleanAction_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalSequencerTestLanguage.g:3223:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) )
            // PsiInternalSequencerTestLanguage.g:3224:4: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) )
            {
            // PsiInternalSequencerTestLanguage.g:3224:4: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:3225:5: ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
            				
            // PsiInternalSequencerTestLanguage.g:3228:5: ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* )
            // PsiInternalSequencerTestLanguage.g:3229:6: ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )*
            {
            // PsiInternalSequencerTestLanguage.g:3229:6: ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )*
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
            	    // PsiInternalSequencerTestLanguage.g:3230:4: ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3230:4: ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3231:5: {...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3231:118: ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3232:6: ({...}? => ( (lv_val1_3_0= 'kw1' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:3235:9: ({...}? => ( (lv_val1_3_0= 'kw1' ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3235:10: {...}? => ( (lv_val1_3_0= 'kw1' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3235:19: ( (lv_val1_3_0= 'kw1' ) )
            	    // PsiInternalSequencerTestLanguage.g:3235:20: (lv_val1_3_0= 'kw1' )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3235:20: (lv_val1_3_0= 'kw1' )
            	    // PsiInternalSequencerTestLanguage.g:3236:10: lv_val1_3_0= 'kw1'
            	    {

            	    										markLeaf(elementTypeProvider.getUnorderedGroupBoolean_Val1Kw1Keyword_2_0_0ElementType());
            	    									
            	    lv_val1_3_0=(Token)match(input,16,FollowSets000.FOLLOW_26); 

            	    										doneLeaf(lv_val1_3_0);
            	    									

            	    										if (!current) {
            	    											associateWithSemanticElement();
            	    											current = true;
            	    										}
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSequencerTestLanguage.g:3256:4: ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3256:4: ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3257:5: {...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3257:118: ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3258:6: ({...}? => ( (lv_val2_4_0= 'kw2' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:3261:9: ({...}? => ( (lv_val2_4_0= 'kw2' ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3261:10: {...}? => ( (lv_val2_4_0= 'kw2' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3261:19: ( (lv_val2_4_0= 'kw2' ) )
            	    // PsiInternalSequencerTestLanguage.g:3261:20: (lv_val2_4_0= 'kw2' )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3261:20: (lv_val2_4_0= 'kw2' )
            	    // PsiInternalSequencerTestLanguage.g:3262:10: lv_val2_4_0= 'kw2'
            	    {

            	    										markLeaf(elementTypeProvider.getUnorderedGroupBoolean_Val2Kw2Keyword_2_1_0ElementType());
            	    									
            	    lv_val2_4_0=(Token)match(input,17,FollowSets000.FOLLOW_26); 

            	    										doneLeaf(lv_val2_4_0);
            	    									

            	    										if (!current) {
            	    											associateWithSemanticElement();
            	    											current = true;
            	    										}
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalSequencerTestLanguage.g:3282:4: ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3282:4: ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3283:5: {...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3283:118: ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3284:6: ({...}? => ( (lv_val3_5_0= 'kw3' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:3287:9: ({...}? => ( (lv_val3_5_0= 'kw3' ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3287:10: {...}? => ( (lv_val3_5_0= 'kw3' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3287:19: ( (lv_val3_5_0= 'kw3' ) )
            	    // PsiInternalSequencerTestLanguage.g:3287:20: (lv_val3_5_0= 'kw3' )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3287:20: (lv_val3_5_0= 'kw3' )
            	    // PsiInternalSequencerTestLanguage.g:3288:10: lv_val3_5_0= 'kw3'
            	    {

            	    										markLeaf(elementTypeProvider.getUnorderedGroupBoolean_Val3Kw3Keyword_2_2_0ElementType());
            	    									
            	    lv_val3_5_0=(Token)match(input,19,FollowSets000.FOLLOW_26); 

            	    										doneLeaf(lv_val3_5_0);
            	    									

            	    										if (!current) {
            	    											associateWithSemanticElement();
            	    											current = true;
            	    										}
            	    									

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedGroupBoolean"


    // $ANTLR start "entryRuleComplex1"
    // PsiInternalSequencerTestLanguage.g:3319:1: entryRuleComplex1 returns [Boolean current=false] : iv_ruleComplex1= ruleComplex1 EOF ;
    public final Boolean entryRuleComplex1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleComplex1 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3319:50: (iv_ruleComplex1= ruleComplex1 EOF )
            // PsiInternalSequencerTestLanguage.g:3320:2: iv_ruleComplex1= ruleComplex1 EOF
            {
             markComposite(elementTypeProvider.getComplex1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleComplex1=ruleComplex1();

            state._fsp--;

             current =iv_ruleComplex1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleComplex1"


    // $ANTLR start "ruleComplex1"
    // PsiInternalSequencerTestLanguage.g:3326:1: ruleComplex1 returns [Boolean current=false] : (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* ) ;
    public final Boolean ruleComplex1() throws RecognitionException {
        Boolean current = false;

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

        try {
            // PsiInternalSequencerTestLanguage.g:3327:1: ( (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:3328:2: (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* )
            {
            // PsiInternalSequencerTestLanguage.g:3328:2: (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* )
            // PsiInternalSequencerTestLanguage.g:3329:3: otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )*
            {

            			markLeaf(elementTypeProvider.getComplex1_NumberSignDigitTwoDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_27); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3336:3: ()
            // PsiInternalSequencerTestLanguage.g:3337:4: 
            {

            				precedeComposite(elementTypeProvider.getComplex1_Complex1Action_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalSequencerTestLanguage.g:3343:3: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==16) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:3344:4: otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getComplex1_Kw1Keyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalSequencerTestLanguage.g:3351:4: ( (lv_val1_3_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:3352:5: (lv_val1_3_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:3352:5: (lv_val1_3_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:3353:6: lv_val1_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getComplex1_Val1IDTerminalRuleCall_2_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_28); 

                    						doneLeaf(lv_val1_3_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalSequencerTestLanguage.g:3369:3: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==17) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:3370:4: otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getComplex1_Kw2Keyword_3_0ElementType());
                    			
                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalSequencerTestLanguage.g:3377:4: ( (lv_val2_5_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:3378:5: (lv_val2_5_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:3378:5: (lv_val2_5_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:3379:6: lv_val2_5_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getComplex1_Val2IDTerminalRuleCall_3_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

                    						doneLeaf(lv_val2_5_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalSequencerTestLanguage.g:3395:3: ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )*
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
            	    // PsiInternalSequencerTestLanguage.g:3396:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3396:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3397:5: otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getComplex1_Kw3Keyword_4_0_0ElementType());
            	    				
            	    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_6);
            	    				
            	    // PsiInternalSequencerTestLanguage.g:3404:5: ( (lv_val3_7_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3405:6: (lv_val3_7_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3405:6: (lv_val3_7_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3406:7: lv_val3_7_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getComplex1_Val3IDTerminalRuleCall_4_0_1_0ElementType());
            	    						

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						
            	    lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            	    							doneLeaf(lv_val3_7_0);
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSequencerTestLanguage.g:3423:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3423:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3424:5: otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getComplex1_Kw4Keyword_4_1_0ElementType());
            	    				
            	    otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_8);
            	    				
            	    // PsiInternalSequencerTestLanguage.g:3431:5: ( (lv_val4_9_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3432:6: (lv_val4_9_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3432:6: (lv_val4_9_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3433:7: lv_val4_9_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getComplex1_Val4IDTerminalRuleCall_4_1_1_0ElementType());
            	    						

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						
            	    lv_val4_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            	    							doneLeaf(lv_val4_9_0);
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalSequencerTestLanguage.g:3450:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3450:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3451:5: otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getComplex1_Kw5Keyword_4_2_0ElementType());
            	    				
            	    otherlv_10=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_10);
            	    				
            	    // PsiInternalSequencerTestLanguage.g:3458:5: ( (lv_val5_11_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3459:6: (lv_val5_11_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3459:6: (lv_val5_11_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3460:7: lv_val5_11_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getComplex1_Val5IDTerminalRuleCall_4_2_1_0ElementType());
            	    						

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						
            	    lv_val5_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            	    							doneLeaf(lv_val5_11_0);
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // PsiInternalSequencerTestLanguage.g:3477:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3477:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3478:5: otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getComplex1_Kw6Keyword_4_3_0ElementType());
            	    				
            	    otherlv_12=(Token)match(input,49,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_12);
            	    				
            	    // PsiInternalSequencerTestLanguage.g:3485:5: ( (lv_val6_13_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3486:6: (lv_val6_13_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3486:6: (lv_val6_13_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3487:7: lv_val6_13_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getComplex1_Val6IDTerminalRuleCall_4_3_1_0ElementType());
            	    						

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						
            	    lv_val6_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            	    							doneLeaf(lv_val6_13_0);
            	    						

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComplex1"


    // $ANTLR start "entryRuleOptionalDouble"
    // PsiInternalSequencerTestLanguage.g:3508:1: entryRuleOptionalDouble returns [Boolean current=false] : iv_ruleOptionalDouble= ruleOptionalDouble EOF ;
    public final Boolean entryRuleOptionalDouble() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOptionalDouble = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3508:56: (iv_ruleOptionalDouble= ruleOptionalDouble EOF )
            // PsiInternalSequencerTestLanguage.g:3509:2: iv_ruleOptionalDouble= ruleOptionalDouble EOF
            {
             markComposite(elementTypeProvider.getOptionalDoubleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptionalDouble=ruleOptionalDouble();

            state._fsp--;

             current =iv_ruleOptionalDouble; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleOptionalDouble"


    // $ANTLR start "ruleOptionalDouble"
    // PsiInternalSequencerTestLanguage.g:3515:1: ruleOptionalDouble returns [Boolean current=false] : (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? ) ;
    public final Boolean ruleOptionalDouble() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_double0_1_0 = null;

        Boolean lv_double1_2_0 = null;

        Boolean lv_double2_3_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3516:1: ( (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? ) )
            // PsiInternalSequencerTestLanguage.g:3517:2: (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? )
            {
            // PsiInternalSequencerTestLanguage.g:3517:2: (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? )
            // PsiInternalSequencerTestLanguage.g:3518:3: otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )?
            {

            			markLeaf(elementTypeProvider.getOptionalDouble_NumberSignDigitTwoDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_21); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3525:3: ( (lv_double0_1_0= ruleDOUBLE ) )
            // PsiInternalSequencerTestLanguage.g:3526:4: (lv_double0_1_0= ruleDOUBLE )
            {
            // PsiInternalSequencerTestLanguage.g:3526:4: (lv_double0_1_0= ruleDOUBLE )
            // PsiInternalSequencerTestLanguage.g:3527:5: lv_double0_1_0= ruleDOUBLE
            {

            					markComposite(elementTypeProvider.getOptionalDouble_Double0DOUBLEParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_22);
            lv_double0_1_0=ruleDOUBLE();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalSequencerTestLanguage.g:3540:3: ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_INT) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:3541:4: ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:3541:4: ( (lv_double1_2_0= ruleDOUBLE ) )
                    // PsiInternalSequencerTestLanguage.g:3542:5: (lv_double1_2_0= ruleDOUBLE )
                    {
                    // PsiInternalSequencerTestLanguage.g:3542:5: (lv_double1_2_0= ruleDOUBLE )
                    // PsiInternalSequencerTestLanguage.g:3543:6: lv_double1_2_0= ruleDOUBLE
                    {

                    						markComposite(elementTypeProvider.getOptionalDouble_Double1DOUBLEParserRuleCall_2_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_21);
                    lv_double1_2_0=ruleDOUBLE();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:3556:4: ( (lv_double2_3_0= ruleDOUBLE ) )
                    // PsiInternalSequencerTestLanguage.g:3557:5: (lv_double2_3_0= ruleDOUBLE )
                    {
                    // PsiInternalSequencerTestLanguage.g:3557:5: (lv_double2_3_0= ruleDOUBLE )
                    // PsiInternalSequencerTestLanguage.g:3558:6: lv_double2_3_0= ruleDOUBLE
                    {

                    						markComposite(elementTypeProvider.getOptionalDouble_Double2DOUBLEParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_double2_3_0=ruleDOUBLE();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
    // $ANTLR end "ruleOptionalDouble"


    // $ANTLR start "entryRuleDOUBLE"
    // PsiInternalSequencerTestLanguage.g:3576:1: entryRuleDOUBLE returns [Boolean current=false] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final Boolean entryRuleDOUBLE() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDOUBLE = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3576:48: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // PsiInternalSequencerTestLanguage.g:3577:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
             markComposite(elementTypeProvider.getDOUBLEElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDOUBLE=ruleDOUBLE();

            state._fsp--;

             current =iv_ruleDOUBLE; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // PsiInternalSequencerTestLanguage.g:3583:1: ruleDOUBLE returns [Boolean current=false] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final Boolean ruleDOUBLE() throws RecognitionException {
        Boolean current = false;

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3584:1: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // PsiInternalSequencerTestLanguage.g:3585:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // PsiInternalSequencerTestLanguage.g:3585:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // PsiInternalSequencerTestLanguage.g:3586:3: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {

            			markLeaf(elementTypeProvider.getDOUBLE_INTTerminalRuleCall_0ElementType());
            		
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_30); 

            			doneLeaf(this_INT_0);
            		
            // PsiInternalSequencerTestLanguage.g:3593:3: (kw= '.' this_INT_2= RULE_INT )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==51) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:3594:4: kw= '.' this_INT_2= RULE_INT
                    {

                    				markLeaf(elementTypeProvider.getDOUBLE_FullStopKeyword_1_0ElementType());
                    			
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_21); 

                    				doneLeaf(kw);
                    			

                    				markLeaf(elementTypeProvider.getDOUBLE_INTTerminalRuleCall_1_1ElementType());
                    			
                    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    				doneLeaf(this_INT_2);
                    			

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
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "entryRuleNullValueGenerated"
    // PsiInternalSequencerTestLanguage.g:3613:1: entryRuleNullValueGenerated returns [Boolean current=false] : iv_ruleNullValueGenerated= ruleNullValueGenerated EOF ;
    public final Boolean entryRuleNullValueGenerated() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNullValueGenerated = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3613:60: (iv_ruleNullValueGenerated= ruleNullValueGenerated EOF )
            // PsiInternalSequencerTestLanguage.g:3614:2: iv_ruleNullValueGenerated= ruleNullValueGenerated EOF
            {
             markComposite(elementTypeProvider.getNullValueGeneratedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullValueGenerated=ruleNullValueGenerated();

            state._fsp--;

             current =iv_ruleNullValueGenerated; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNullValueGenerated"


    // $ANTLR start "ruleNullValueGenerated"
    // PsiInternalSequencerTestLanguage.g:3620:1: ruleNullValueGenerated returns [Boolean current=false] : (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) ) ;
    public final Boolean ruleNullValueGenerated() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_value_1_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3621:1: ( (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3622:2: (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3622:2: (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) )
            // PsiInternalSequencerTestLanguage.g:3623:3: otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) )
            {

            			markLeaf(elementTypeProvider.getNullValueGenerated_NumberSignDigitTwoDigitNineKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,52,FollowSets000.FOLLOW_31); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3630:3: ( (lv_value_1_0= ruleNULL_STRING ) )
            // PsiInternalSequencerTestLanguage.g:3631:4: (lv_value_1_0= ruleNULL_STRING )
            {
            // PsiInternalSequencerTestLanguage.g:3631:4: (lv_value_1_0= ruleNULL_STRING )
            // PsiInternalSequencerTestLanguage.g:3632:5: lv_value_1_0= ruleNULL_STRING
            {

            					markComposite(elementTypeProvider.getNullValueGenerated_ValueNULL_STRINGParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_1_0=ruleNULL_STRING();

            state._fsp--;


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
    // $ANTLR end "ruleNullValueGenerated"


    // $ANTLR start "entryRuleNullValueInterpreted"
    // PsiInternalSequencerTestLanguage.g:3649:1: entryRuleNullValueInterpreted returns [Boolean current=false] : iv_ruleNullValueInterpreted= ruleNullValueInterpreted EOF ;
    public final Boolean entryRuleNullValueInterpreted() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNullValueInterpreted = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3649:62: (iv_ruleNullValueInterpreted= ruleNullValueInterpreted EOF )
            // PsiInternalSequencerTestLanguage.g:3650:2: iv_ruleNullValueInterpreted= ruleNullValueInterpreted EOF
            {
             markComposite(elementTypeProvider.getNullValueInterpretedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullValueInterpreted=ruleNullValueInterpreted();

            state._fsp--;

             current =iv_ruleNullValueInterpreted; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNullValueInterpreted"


    // $ANTLR start "ruleNullValueInterpreted"
    // PsiInternalSequencerTestLanguage.g:3656:1: ruleNullValueInterpreted returns [Boolean current=false] : (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? ) ;
    public final Boolean ruleNullValueInterpreted() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_foo_2_0=null;
        Boolean lv_value_1_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3657:1: ( (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? ) )
            // PsiInternalSequencerTestLanguage.g:3658:2: (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            {
            // PsiInternalSequencerTestLanguage.g:3658:2: (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            // PsiInternalSequencerTestLanguage.g:3659:3: otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )?
            {

            			markLeaf(elementTypeProvider.getNullValueInterpreted_NumberSignDigitThreeDigitZeroKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,53,FollowSets000.FOLLOW_31); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3666:3: ( (lv_value_1_0= ruleNULL_STRING ) )
            // PsiInternalSequencerTestLanguage.g:3667:4: (lv_value_1_0= ruleNULL_STRING )
            {
            // PsiInternalSequencerTestLanguage.g:3667:4: (lv_value_1_0= ruleNULL_STRING )
            // PsiInternalSequencerTestLanguage.g:3668:5: lv_value_1_0= ruleNULL_STRING
            {

            					markComposite(elementTypeProvider.getNullValueInterpreted_ValueNULL_STRINGParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_9);
            lv_value_1_0=ruleNULL_STRING();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalSequencerTestLanguage.g:3681:3: ( (lv_foo_2_0= RULE_ID ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:3682:4: (lv_foo_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:3682:4: (lv_foo_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:3683:5: lv_foo_2_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getNullValueInterpreted_FooIDTerminalRuleCall_2_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_foo_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_foo_2_0);
                    				

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
    // $ANTLR end "ruleNullValueInterpreted"


    // $ANTLR start "entryRuleNULL_STRING"
    // PsiInternalSequencerTestLanguage.g:3702:1: entryRuleNULL_STRING returns [Boolean current=false] : iv_ruleNULL_STRING= ruleNULL_STRING EOF ;
    public final Boolean entryRuleNULL_STRING() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNULL_STRING = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3702:53: (iv_ruleNULL_STRING= ruleNULL_STRING EOF )
            // PsiInternalSequencerTestLanguage.g:3703:2: iv_ruleNULL_STRING= ruleNULL_STRING EOF
            {
             markComposite(elementTypeProvider.getNULL_STRINGElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNULL_STRING=ruleNULL_STRING();

            state._fsp--;

             current =iv_ruleNULL_STRING; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNULL_STRING"


    // $ANTLR start "ruleNULL_STRING"
    // PsiInternalSequencerTestLanguage.g:3709:1: ruleNULL_STRING returns [Boolean current=false] : this_STRING_0= RULE_STRING ;
    public final Boolean ruleNULL_STRING() throws RecognitionException {
        Boolean current = false;

        Token this_STRING_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3710:1: (this_STRING_0= RULE_STRING )
            // PsiInternalSequencerTestLanguage.g:3711:2: this_STRING_0= RULE_STRING
            {

            		markLeaf(elementTypeProvider.getNULL_STRING_STRINGTerminalRuleCallElementType());
            	
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            		doneLeaf(this_STRING_0);
            	

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
    // $ANTLR end "ruleNULL_STRING"


    // $ANTLR start "entryRuleNullCrossRefGenerated"
    // PsiInternalSequencerTestLanguage.g:3721:1: entryRuleNullCrossRefGenerated returns [Boolean current=false] : iv_ruleNullCrossRefGenerated= ruleNullCrossRefGenerated EOF ;
    public final Boolean entryRuleNullCrossRefGenerated() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNullCrossRefGenerated = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3721:63: (iv_ruleNullCrossRefGenerated= ruleNullCrossRefGenerated EOF )
            // PsiInternalSequencerTestLanguage.g:3722:2: iv_ruleNullCrossRefGenerated= ruleNullCrossRefGenerated EOF
            {
             markComposite(elementTypeProvider.getNullCrossRefGeneratedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullCrossRefGenerated=ruleNullCrossRefGenerated();

            state._fsp--;

             current =iv_ruleNullCrossRefGenerated; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNullCrossRefGenerated"


    // $ANTLR start "ruleNullCrossRefGenerated"
    // PsiInternalSequencerTestLanguage.g:3728:1: ruleNullCrossRefGenerated returns [Boolean current=false] : (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) ) ;
    public final Boolean ruleNullCrossRefGenerated() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3729:1: ( (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3730:2: (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3730:2: (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:3731:3: otherlv_0= '#31' ( (otherlv_1= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getNullCrossRefGenerated_NumberSignDigitThreeDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3738:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:3739:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:3739:4: (otherlv_1= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:3740:5: otherlv_1= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getNullCrossRefGenerated_RefEObjectCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(otherlv_1);
            				

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
    // $ANTLR end "ruleNullCrossRefGenerated"


    // $ANTLR start "entryRuleNullCrossRefInterpreted"
    // PsiInternalSequencerTestLanguage.g:3759:1: entryRuleNullCrossRefInterpreted returns [Boolean current=false] : iv_ruleNullCrossRefInterpreted= ruleNullCrossRefInterpreted EOF ;
    public final Boolean entryRuleNullCrossRefInterpreted() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNullCrossRefInterpreted = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3759:65: (iv_ruleNullCrossRefInterpreted= ruleNullCrossRefInterpreted EOF )
            // PsiInternalSequencerTestLanguage.g:3760:2: iv_ruleNullCrossRefInterpreted= ruleNullCrossRefInterpreted EOF
            {
             markComposite(elementTypeProvider.getNullCrossRefInterpretedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullCrossRefInterpreted=ruleNullCrossRefInterpreted();

            state._fsp--;

             current =iv_ruleNullCrossRefInterpreted; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNullCrossRefInterpreted"


    // $ANTLR start "ruleNullCrossRefInterpreted"
    // PsiInternalSequencerTestLanguage.g:3766:1: ruleNullCrossRefInterpreted returns [Boolean current=false] : (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? ) ;
    public final Boolean ruleNullCrossRefInterpreted() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_foo_2_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3767:1: ( (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? ) )
            // PsiInternalSequencerTestLanguage.g:3768:2: (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            {
            // PsiInternalSequencerTestLanguage.g:3768:2: (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            // PsiInternalSequencerTestLanguage.g:3769:3: otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )?
            {

            			markLeaf(elementTypeProvider.getNullCrossRefInterpreted_NumberSignDigitThreeDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3776:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:3777:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:3777:4: (otherlv_1= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:3778:5: otherlv_1= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getNullCrossRefInterpreted_RefEObjectCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalSequencerTestLanguage.g:3793:3: ( (lv_foo_2_0= RULE_ID ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:3794:4: (lv_foo_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:3794:4: (lv_foo_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:3795:5: lv_foo_2_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getNullCrossRefInterpreted_FooIDTerminalRuleCall_2_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_foo_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_foo_2_0);
                    				

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
    // $ANTLR end "ruleNullCrossRefInterpreted"


    // $ANTLR start "entryRuleFragmentCaller"
    // PsiInternalSequencerTestLanguage.g:3814:1: entryRuleFragmentCaller returns [Boolean current=false] : iv_ruleFragmentCaller= ruleFragmentCaller EOF ;
    public final Boolean entryRuleFragmentCaller() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFragmentCaller = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3814:56: (iv_ruleFragmentCaller= ruleFragmentCaller EOF )
            // PsiInternalSequencerTestLanguage.g:3815:2: iv_ruleFragmentCaller= ruleFragmentCaller EOF
            {
             markComposite(elementTypeProvider.getFragmentCallerElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFragmentCaller=ruleFragmentCaller();

            state._fsp--;

             current =iv_ruleFragmentCaller; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleFragmentCaller"


    // $ANTLR start "ruleFragmentCaller"
    // PsiInternalSequencerTestLanguage.g:3821:1: ruleFragmentCaller returns [Boolean current=false] : (otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) ) ;
    public final Boolean ruleFragmentCaller() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val_3_0=null;
        Boolean this_Fragment1_2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3822:1: ( (otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3823:2: (otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3823:2: (otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:3824:3: otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getFragmentCaller_NumberSignDigitThreeDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,56,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3831:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:3832:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:3832:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:3833:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFragmentCaller_Val1IDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }


            			markComposite(elementTypeProvider.getFragmentCaller_Fragment1ParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_Fragment1_2=ruleFragment1(current);

            state._fsp--;


            			current = this_Fragment1_2;
            			doneComposite();
            		
            // PsiInternalSequencerTestLanguage.g:3856:3: ( (lv_val_3_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:3857:4: (lv_val_3_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:3857:4: (lv_val_3_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:3858:5: lv_val_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFragmentCaller_ValIDTerminalRuleCall_3_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_val_3_0);
            				

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
    // $ANTLR end "ruleFragmentCaller"


    // $ANTLR start "ruleFragment1"
    // PsiInternalSequencerTestLanguage.g:3878:1: ruleFragment1[Boolean in_current] returns [Boolean current=in_current] : ( (lv_fragVal_0_0= RULE_ID ) ) ;
    public final Boolean ruleFragment1(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token lv_fragVal_0_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3879:1: ( ( (lv_fragVal_0_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:3880:2: ( (lv_fragVal_0_0= RULE_ID ) )
            {
            // PsiInternalSequencerTestLanguage.g:3880:2: ( (lv_fragVal_0_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:3881:3: (lv_fragVal_0_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:3881:3: (lv_fragVal_0_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:3882:4: lv_fragVal_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getFragment1_FragValIDTerminalRuleCall_0ElementType());
            			

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			
            lv_fragVal_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_fragVal_0_0);
            			

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
    // $ANTLR end "ruleFragment1"


    // $ANTLR start "entryRuleParameterCaller"
    // PsiInternalSequencerTestLanguage.g:3900:1: entryRuleParameterCaller returns [Boolean current=false] : iv_ruleParameterCaller= ruleParameterCaller EOF ;
    public final Boolean entryRuleParameterCaller() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParameterCaller = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3900:57: (iv_ruleParameterCaller= ruleParameterCaller EOF )
            // PsiInternalSequencerTestLanguage.g:3901:2: iv_ruleParameterCaller= ruleParameterCaller EOF
            {
             markComposite(elementTypeProvider.getParameterCallerElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameterCaller=ruleParameterCaller();

            state._fsp--;

             current =iv_ruleParameterCaller; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleParameterCaller"


    // $ANTLR start "ruleParameterCaller"
    // PsiInternalSequencerTestLanguage.g:3907:1: ruleParameterCaller returns [Boolean current=false] : (otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) ) ) ;
    public final Boolean ruleParameterCaller() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Boolean lv_p_2_0 = null;

        Boolean lv_p_4_0 = null;

        Boolean lv_p_6_0 = null;

        Boolean lv_p_8_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3908:1: ( (otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3909:2: (otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3909:2: (otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3910:3: otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) )
            {

            			markLeaf(elementTypeProvider.getParameterCaller_NumberSignDigitThreeDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_32); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3917:3: ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) )
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
                    // PsiInternalSequencerTestLanguage.g:3918:4: (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:3918:4: (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) )
                    // PsiInternalSequencerTestLanguage.g:3919:5: otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) )
                    {

                    					markLeaf(elementTypeProvider.getParameterCaller_Kw1Keyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_33); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalSequencerTestLanguage.g:3926:5: ( (lv_p_2_0= norm3_Parameterized ) )
                    // PsiInternalSequencerTestLanguage.g:3927:6: (lv_p_2_0= norm3_Parameterized )
                    {
                    // PsiInternalSequencerTestLanguage.g:3927:6: (lv_p_2_0= norm3_Parameterized )
                    // PsiInternalSequencerTestLanguage.g:3928:7: lv_p_2_0= norm3_Parameterized
                    {

                    							markComposite(elementTypeProvider.getParameterCaller_PParameterizedParserRuleCall_1_0_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_p_2_0=norm3_Parameterized();

                    state._fsp--;


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
                    // PsiInternalSequencerTestLanguage.g:3943:4: (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:3943:4: (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) )
                    // PsiInternalSequencerTestLanguage.g:3944:5: otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) )
                    {

                    					markLeaf(elementTypeProvider.getParameterCaller_Kw2Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_33); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalSequencerTestLanguage.g:3951:5: ( (lv_p_4_0= norm1_Parameterized ) )
                    // PsiInternalSequencerTestLanguage.g:3952:6: (lv_p_4_0= norm1_Parameterized )
                    {
                    // PsiInternalSequencerTestLanguage.g:3952:6: (lv_p_4_0= norm1_Parameterized )
                    // PsiInternalSequencerTestLanguage.g:3953:7: lv_p_4_0= norm1_Parameterized
                    {

                    							markComposite(elementTypeProvider.getParameterCaller_PParameterizedParserRuleCall_1_1_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_p_4_0=norm1_Parameterized();

                    state._fsp--;


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
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:3968:4: (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:3968:4: (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) )
                    // PsiInternalSequencerTestLanguage.g:3969:5: otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) )
                    {

                    					markLeaf(elementTypeProvider.getParameterCaller_Kw3Keyword_1_2_0ElementType());
                    				
                    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_34); 

                    					doneLeaf(otherlv_5);
                    				
                    // PsiInternalSequencerTestLanguage.g:3976:5: ( (lv_p_6_0= norm2_Parameterized ) )
                    // PsiInternalSequencerTestLanguage.g:3977:6: (lv_p_6_0= norm2_Parameterized )
                    {
                    // PsiInternalSequencerTestLanguage.g:3977:6: (lv_p_6_0= norm2_Parameterized )
                    // PsiInternalSequencerTestLanguage.g:3978:7: lv_p_6_0= norm2_Parameterized
                    {

                    							markComposite(elementTypeProvider.getParameterCaller_PParameterizedParserRuleCall_1_2_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_p_6_0=norm2_Parameterized();

                    state._fsp--;


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
                case 4 :
                    // PsiInternalSequencerTestLanguage.g:3993:4: (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:3993:4: (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) )
                    // PsiInternalSequencerTestLanguage.g:3994:5: otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) )
                    {

                    					markLeaf(elementTypeProvider.getParameterCaller_Kw4Keyword_1_3_0ElementType());
                    				
                    otherlv_7=(Token)match(input,22,FollowSets000.FOLLOW_34); 

                    					doneLeaf(otherlv_7);
                    				
                    // PsiInternalSequencerTestLanguage.g:4001:5: ( (lv_p_8_0= ruleParameterized ) )
                    // PsiInternalSequencerTestLanguage.g:4002:6: (lv_p_8_0= ruleParameterized )
                    {
                    // PsiInternalSequencerTestLanguage.g:4002:6: (lv_p_8_0= ruleParameterized )
                    // PsiInternalSequencerTestLanguage.g:4003:7: lv_p_8_0= ruleParameterized
                    {

                    							markComposite(elementTypeProvider.getParameterCaller_PParameterizedParserRuleCall_1_3_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_p_8_0=ruleParameterized();

                    state._fsp--;


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
    // $ANTLR end "ruleParameterCaller"


    // $ANTLR start "entryRuleParameterized"
    // PsiInternalSequencerTestLanguage.g:4022:1: entryRuleParameterized returns [Boolean current=false] : iv_ruleParameterized= ruleParameterized EOF ;
    public final Boolean entryRuleParameterized() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParameterized = null;


        try {
            // PsiInternalSequencerTestLanguage.g:4022:55: (iv_ruleParameterized= ruleParameterized EOF )
            // PsiInternalSequencerTestLanguage.g:4023:2: iv_ruleParameterized= ruleParameterized EOF
            {
             markComposite(elementTypeProvider.getParameterizedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameterized=ruleParameterized();

            state._fsp--;

             current =iv_ruleParameterized; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleParameterized"


    // $ANTLR start "ruleParameterized"
    // PsiInternalSequencerTestLanguage.g:4029:1: ruleParameterized returns [Boolean current=false] : (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleParameterized() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_v2_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4030:1: ( (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:4031:2: (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:4031:2: (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:4032:3: otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getParameterized_Kwp2Keyword_1_0ElementType());
            		
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:4039:3: ( (lv_v2_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:4040:4: (lv_v2_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:4040:4: (lv_v2_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:4041:5: lv_v2_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParameterized_V2IDTerminalRuleCall_1_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_v2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_v2_1_0);
            				

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
    // $ANTLR end "ruleParameterized"


    // $ANTLR start "norm1_Parameterized"
    // PsiInternalSequencerTestLanguage.g:4061:1: norm1_Parameterized returns [Boolean current=false] : (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) ) ;
    public final Boolean norm1_Parameterized() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_v1_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4062:1: ( (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:4063:2: (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:4063:2: (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:4064:3: otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getParameterized_Kwp1Keyword_0_0ElementType());
            		
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:4071:3: ( (lv_v1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:4072:4: (lv_v1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:4072:4: (lv_v1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:4073:5: lv_v1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParameterized_V1IDTerminalRuleCall_0_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_v1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_v1_1_0);
            				

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
    // $ANTLR end "norm1_Parameterized"


    // $ANTLR start "norm2_Parameterized"
    // PsiInternalSequencerTestLanguage.g:4093:1: norm2_Parameterized returns [Boolean current=false] : (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )? ) ;
    public final Boolean norm2_Parameterized() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_v2_1_0=null;
        Token otherlv_2=null;
        Token lv_v3_3_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4094:1: ( (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )? ) )
            // PsiInternalSequencerTestLanguage.g:4095:2: (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )? )
            {
            // PsiInternalSequencerTestLanguage.g:4095:2: (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )? )
            // PsiInternalSequencerTestLanguage.g:4096:3: otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )?
            {

            			markLeaf(elementTypeProvider.getParameterized_Kwp2Keyword_1_0ElementType());
            		
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:4103:3: ( (lv_v2_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:4104:4: (lv_v2_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:4104:4: (lv_v2_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:4105:5: lv_v2_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParameterized_V2IDTerminalRuleCall_1_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_v2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_35); 

            					doneLeaf(lv_v2_1_0);
            				

            }


            }

            // PsiInternalSequencerTestLanguage.g:4120:3: (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==60) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:4121:4: otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getParameterized_Kwp3Keyword_1_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,60,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalSequencerTestLanguage.g:4128:4: ( (lv_v3_3_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:4129:5: (lv_v3_3_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:4129:5: (lv_v3_3_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:4130:6: lv_v3_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getParameterized_V3IDTerminalRuleCall_1_2_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_v3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_v3_3_0);
                    					

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
    // $ANTLR end "norm2_Parameterized"


    // $ANTLR start "norm3_Parameterized"
    // PsiInternalSequencerTestLanguage.g:4151:1: norm3_Parameterized returns [Boolean current=false] : (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) ) ;
    public final Boolean norm3_Parameterized() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_v1_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4152:1: ( (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:4153:2: (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:4153:2: (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:4154:3: otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getParameterized_Kwp1Keyword_0_0ElementType());
            		
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:4161:3: ( (lv_v1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:4162:4: (lv_v1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:4162:4: (lv_v1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:4163:5: lv_v1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParameterized_V1IDTerminalRuleCall_0_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_v1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_v1_1_0);
            				

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
    // $ANTLR end "norm3_Parameterized"


    // $ANTLR start "ruleDefEnum1"
    // PsiInternalSequencerTestLanguage.g:4182:1: ruleDefEnum1 returns [Boolean current=false] : (enumLiteral_0= 'kw1' ) ;
    public final Boolean ruleDefEnum1() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4183:1: ( (enumLiteral_0= 'kw1' ) )
            // PsiInternalSequencerTestLanguage.g:4184:2: (enumLiteral_0= 'kw1' )
            {
            // PsiInternalSequencerTestLanguage.g:4184:2: (enumLiteral_0= 'kw1' )
            // PsiInternalSequencerTestLanguage.g:4185:3: enumLiteral_0= 'kw1'
            {

            			markLeaf(elementTypeProvider.getDefEnum1_Kw1EnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

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
    // $ANTLR end "ruleDefEnum1"


    // $ANTLR start "ruleDefEnum2"
    // PsiInternalSequencerTestLanguage.g:4196:1: ruleDefEnum2 returns [Boolean current=false] : (enumLiteral_0= 'kw2' ) ;
    public final Boolean ruleDefEnum2() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4197:1: ( (enumLiteral_0= 'kw2' ) )
            // PsiInternalSequencerTestLanguage.g:4198:2: (enumLiteral_0= 'kw2' )
            {
            // PsiInternalSequencerTestLanguage.g:4198:2: (enumLiteral_0= 'kw2' )
            // PsiInternalSequencerTestLanguage.g:4199:3: enumLiteral_0= 'kw2'
            {

            			markLeaf(elementTypeProvider.getDefEnum2_Kw2EnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

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
    // $ANTLR end "ruleDefEnum2"


    // $ANTLR start "ruleDefEnum3"
    // PsiInternalSequencerTestLanguage.g:4210:1: ruleDefEnum3 returns [Boolean current=false] : (enumLiteral_0= 'kw3' ) ;
    public final Boolean ruleDefEnum3() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4211:1: ( (enumLiteral_0= 'kw3' ) )
            // PsiInternalSequencerTestLanguage.g:4212:2: (enumLiteral_0= 'kw3' )
            {
            // PsiInternalSequencerTestLanguage.g:4212:2: (enumLiteral_0= 'kw3' )
            // PsiInternalSequencerTestLanguage.g:4213:3: enumLiteral_0= 'kw3'
            {

            			markLeaf(elementTypeProvider.getDefEnum3_Kw3EnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,19,FollowSets000.FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

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
    // $ANTLR end "ruleDefEnum3"

    // Delegated rules


    protected DFA32 dfa32 = new DFA32(this);
    static final String dfa_1s = "\5\uffff";
    static final String dfa_2s = "\2\uffff\1\4\2\uffff";
    static final String dfa_3s = "\3\4\2\uffff";
    static final String dfa_4s = "\1\4\2\20\2\uffff";
    static final String dfa_5s = "\3\uffff\1\2\1\1";
    static final String dfa_6s = "\5\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2\13\uffff\1\3",
            "\1\2\13\uffff\1\3",
            "",
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
            return "2439:3: ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )";
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