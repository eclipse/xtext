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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ID1", "RULE_ID2", "RULE_ID3", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'kw1'", "'kw2'", "'#3'", "'kw3'", "'#4'", "'#5'", "'kw4'", "'kw5'", "'#6'", "','", "'#7'", "'#8'", "'#9'", "'kw'", "'#10'", "'#11'", "'#12'", "'#13'", "'#14'", "'#15'", "'#16'", "'#17'", "'#18'", "'#19'", "'#20'", "'#21'", "'#22'", "'Bye'", "'#23'", "'#24'", "'#25'", "'#26'", "'#27'", "'kw6'", "'#28'", "'.'", "'#29'", "'#30'", "'#31'", "'#32'", "'#33'", "'#34'", "'kwp2'", "'kwp1'", "'kwp3'", "'#35'", "'kwd'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
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
    // PsiInternalSequencerTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) | ( (lv_x33_32_0= ruleFragmentCaller ) ) | ( (lv_x34_33_0= ruleParameterCaller ) ) | ( (lv_x35_34_0= ruleParameterDelegation ) ) ) ;
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

        Boolean lv_x35_34_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:60:1: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) | ( (lv_x33_32_0= ruleFragmentCaller ) ) | ( (lv_x34_33_0= ruleParameterCaller ) ) | ( (lv_x35_34_0= ruleParameterDelegation ) ) ) )
            // PsiInternalSequencerTestLanguage.g:61:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) | ( (lv_x33_32_0= ruleFragmentCaller ) ) | ( (lv_x34_33_0= ruleParameterCaller ) ) | ( (lv_x35_34_0= ruleParameterDelegation ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:61:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) | ( (lv_x33_32_0= ruleFragmentCaller ) ) | ( (lv_x34_33_0= ruleParameterCaller ) ) | ( (lv_x35_34_0= ruleParameterDelegation ) ) )
            int alt1=35;
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
            case 61:
                {
                alt1=35;
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
                case 35 :
                    // PsiInternalSequencerTestLanguage.g:606:3: ( (lv_x35_34_0= ruleParameterDelegation ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:606:3: ( (lv_x35_34_0= ruleParameterDelegation ) )
                    // PsiInternalSequencerTestLanguage.g:607:4: (lv_x35_34_0= ruleParameterDelegation )
                    {
                    // PsiInternalSequencerTestLanguage.g:607:4: (lv_x35_34_0= ruleParameterDelegation )
                    // PsiInternalSequencerTestLanguage.g:608:5: lv_x35_34_0= ruleParameterDelegation
                    {

                    					markComposite(elementTypeProvider.getModel_X35ParameterDelegationParserRuleCall_34_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x35_34_0=ruleParameterDelegation();

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
    // PsiInternalSequencerTestLanguage.g:625:1: entryRuleSimpleGroup returns [Boolean current=false] : iv_ruleSimpleGroup= ruleSimpleGroup EOF ;
    public final Boolean entryRuleSimpleGroup() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimpleGroup = null;


        try {
            // PsiInternalSequencerTestLanguage.g:625:53: (iv_ruleSimpleGroup= ruleSimpleGroup EOF )
            // PsiInternalSequencerTestLanguage.g:626:2: iv_ruleSimpleGroup= ruleSimpleGroup EOF
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
    // PsiInternalSequencerTestLanguage.g:632:1: ruleSimpleGroup returns [Boolean current=false] : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleSimpleGroup() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:633:1: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:634:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:634:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:635:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSimpleGroup_NumberSignDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:642:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:643:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:643:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:644:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimpleGroup_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalSequencerTestLanguage.g:659:3: ( (lv_val2_2_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:660:4: (lv_val2_2_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:660:4: (lv_val2_2_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:661:5: lv_val2_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimpleGroup_Val2IDTerminalRuleCall_2_0ElementType());
            				
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // PsiInternalSequencerTestLanguage.g:680:1: entryRuleSimpleAlternative returns [Boolean current=false] : iv_ruleSimpleAlternative= ruleSimpleAlternative EOF ;
    public final Boolean entryRuleSimpleAlternative() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimpleAlternative = null;


        try {
            // PsiInternalSequencerTestLanguage.g:680:59: (iv_ruleSimpleAlternative= ruleSimpleAlternative EOF )
            // PsiInternalSequencerTestLanguage.g:681:2: iv_ruleSimpleAlternative= ruleSimpleAlternative EOF
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
    // PsiInternalSequencerTestLanguage.g:687:1: ruleSimpleAlternative returns [Boolean current=false] : (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final Boolean ruleSimpleAlternative() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val2_4_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:688:1: ( (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:689:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:689:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:690:3: otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {

            			markLeaf(elementTypeProvider.getSimpleAlternative_NumberSignDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:697:3: ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
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
                    // PsiInternalSequencerTestLanguage.g:698:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:698:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:699:5: otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getSimpleAlternative_Kw1Keyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalSequencerTestLanguage.g:706:5: ( (lv_val1_2_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:707:6: (lv_val1_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:707:6: (lv_val1_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:708:7: lv_val1_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getSimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0ElementType());
                    						
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val1_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:725:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:725:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:726:5: otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getSimpleAlternative_Kw2Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalSequencerTestLanguage.g:733:5: ( (lv_val2_4_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:734:6: (lv_val2_4_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:734:6: (lv_val2_4_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:735:7: lv_val2_4_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getSimpleAlternative_Val2IDTerminalRuleCall_1_1_1_0ElementType());
                    						
                    lv_val2_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

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
    // PsiInternalSequencerTestLanguage.g:756:1: entryRuleSimpleMultiplicities returns [Boolean current=false] : iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF ;
    public final Boolean entryRuleSimpleMultiplicities() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimpleMultiplicities = null;


        try {
            // PsiInternalSequencerTestLanguage.g:756:62: (iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF )
            // PsiInternalSequencerTestLanguage.g:757:2: iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF
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
    // PsiInternalSequencerTestLanguage.g:763:1: ruleSimpleMultiplicities returns [Boolean current=false] : (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
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
            // PsiInternalSequencerTestLanguage.g:764:1: ( (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // PsiInternalSequencerTestLanguage.g:765:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // PsiInternalSequencerTestLanguage.g:765:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // PsiInternalSequencerTestLanguage.g:766:3: otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {

            			markLeaf(elementTypeProvider.getSimpleMultiplicities_NumberSignDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:773:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:774:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:774:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:775:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimpleMultiplicities_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getSimpleMultiplicities_Kw1Keyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSequencerTestLanguage.g:797:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:798:4: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:798:4: (lv_val2_3_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:799:5: lv_val2_3_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getSimpleMultiplicities_Val2IDTerminalRuleCall_3_0ElementType());
                    				
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_val2_3_0);
                    				

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getSimpleMultiplicities_Kw2Keyword_4ElementType());
            		
            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalSequencerTestLanguage.g:821:3: ( (lv_val3_5_0= RULE_ID ) )+
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
            	    // PsiInternalSequencerTestLanguage.g:822:4: (lv_val3_5_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:822:4: (lv_val3_5_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:823:5: lv_val3_5_0= RULE_ID
            	    {

            	    					markLeaf(elementTypeProvider.getSimpleMultiplicities_Val3IDTerminalRuleCall_5_0ElementType());
            	    				
            	    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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
            		
            // PsiInternalSequencerTestLanguage.g:845:3: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalSequencerTestLanguage.g:846:4: (lv_val4_7_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:846:4: (lv_val4_7_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:847:5: lv_val4_7_0= RULE_ID
            	    {

            	    					markLeaf(elementTypeProvider.getSimpleMultiplicities_Val4IDTerminalRuleCall_7_0ElementType());
            	    				
            	    lv_val4_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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
    // PsiInternalSequencerTestLanguage.g:866:1: entryRuleGroupMultiplicities returns [Boolean current=false] : iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF ;
    public final Boolean entryRuleGroupMultiplicities() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGroupMultiplicities = null;


        try {
            // PsiInternalSequencerTestLanguage.g:866:61: (iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF )
            // PsiInternalSequencerTestLanguage.g:867:2: iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF
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
    // PsiInternalSequencerTestLanguage.g:873:1: ruleGroupMultiplicities returns [Boolean current=false] : (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
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
            // PsiInternalSequencerTestLanguage.g:874:1: ( (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:875:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // PsiInternalSequencerTestLanguage.g:875:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // PsiInternalSequencerTestLanguage.g:876:3: otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getGroupMultiplicities_NumberSignDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:883:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:884:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:884:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:885:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getGroupMultiplicities_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getGroupMultiplicities_Kw1Keyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSequencerTestLanguage.g:907:3: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:908:4: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:908:4: ( (lv_val2_3_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:909:5: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:909:5: (lv_val2_3_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:910:6: lv_val2_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val2IDTerminalRuleCall_3_0_0ElementType());
                    					
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val2_3_0);
                    					

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:925:4: ( (lv_val3_4_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:926:5: (lv_val3_4_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:926:5: (lv_val3_4_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:927:6: lv_val3_4_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val3IDTerminalRuleCall_3_1_0ElementType());
                    					
                    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val3_4_0);
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getGroupMultiplicities_Kw2Keyword_4ElementType());
            		
            otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_5);
            		
            // PsiInternalSequencerTestLanguage.g:950:3: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
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
            	    // PsiInternalSequencerTestLanguage.g:951:4: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:951:4: ( (lv_val4_6_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:952:5: (lv_val4_6_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:952:5: (lv_val4_6_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:953:6: lv_val4_6_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val4IDTerminalRuleCall_5_0_0ElementType());
            	    					
            	    lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_val4_6_0);
            	    					

            	    }


            	    }

            	    // PsiInternalSequencerTestLanguage.g:968:4: ( (lv_val5_7_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:969:5: (lv_val5_7_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:969:5: (lv_val5_7_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:970:6: lv_val5_7_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val5IDTerminalRuleCall_5_1_0ElementType());
            	    					
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

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
            		
            // PsiInternalSequencerTestLanguage.g:993:3: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalSequencerTestLanguage.g:994:4: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:994:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:995:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:995:5: (lv_val6_9_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:996:6: lv_val6_9_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val6IDTerminalRuleCall_7_0_0ElementType());
            	    					
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_val6_9_0);
            	    					

            	    }


            	    }

            	    // PsiInternalSequencerTestLanguage.g:1011:4: ( (lv_val7_10_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:1012:5: (lv_val7_10_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1012:5: (lv_val7_10_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:1013:6: lv_val7_10_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val7IDTerminalRuleCall_7_1_0ElementType());
            	    					
            	    lv_val7_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

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
    // PsiInternalSequencerTestLanguage.g:1033:1: entryRuleAlternativeMultiplicities returns [Boolean current=false] : iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF ;
    public final Boolean entryRuleAlternativeMultiplicities() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAlternativeMultiplicities = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1033:67: (iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF )
            // PsiInternalSequencerTestLanguage.g:1034:2: iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF
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
    // PsiInternalSequencerTestLanguage.g:1040:1: ruleAlternativeMultiplicities returns [Boolean current=false] : (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
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
            // PsiInternalSequencerTestLanguage.g:1041:1: ( (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:1042:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // PsiInternalSequencerTestLanguage.g:1042:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // PsiInternalSequencerTestLanguage.g:1043:3: otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {

            			markLeaf(elementTypeProvider.getAlternativeMultiplicities_NumberSignDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1050:3: ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
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
                    // PsiInternalSequencerTestLanguage.g:1051:4: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1051:4: ( (lv_val2_1_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1052:5: (lv_val2_1_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1052:5: (lv_val2_1_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1053:6: lv_val2_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0ElementType());
                    					
                    lv_val2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val2_1_0);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1069:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1069:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:1070:5: otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw1Keyword_1_1_0ElementType());
                    				
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalSequencerTestLanguage.g:1077:5: ( (lv_val3_3_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1078:6: (lv_val3_3_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1078:6: (lv_val3_3_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1079:7: lv_val3_3_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0ElementType());
                    						
                    lv_val3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

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
            		
            // PsiInternalSequencerTestLanguage.g:1103:3: ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
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
            	    // PsiInternalSequencerTestLanguage.g:1104:4: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1104:4: ( (lv_val4_5_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:1105:5: (lv_val4_5_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1105:5: (lv_val4_5_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:1106:6: lv_val4_5_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0ElementType());
            	    					
            	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_val4_5_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSequencerTestLanguage.g:1122:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1122:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:1123:5: otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw3Keyword_3_1_0ElementType());
            	    				
            	    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_6);
            	    				
            	    // PsiInternalSequencerTestLanguage.g:1130:5: ( (lv_val5_7_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:1131:6: (lv_val5_7_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1131:6: (lv_val5_7_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:1132:7: lv_val5_7_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val5IDTerminalRuleCall_3_1_1_0ElementType());
            	    						
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						

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
            		
            // PsiInternalSequencerTestLanguage.g:1156:3: ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
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
            	    // PsiInternalSequencerTestLanguage.g:1157:4: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1157:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:1158:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1158:5: (lv_val6_9_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:1159:6: lv_val6_9_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0ElementType());
            	    					
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_val6_9_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSequencerTestLanguage.g:1175:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1175:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:1176:5: otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw5Keyword_5_1_0ElementType());
            	    				
            	    otherlv_10=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_10);
            	    				
            	    // PsiInternalSequencerTestLanguage.g:1183:5: ( (lv_val7_11_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:1184:6: (lv_val7_11_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1184:6: (lv_val7_11_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:1185:7: lv_val7_11_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val7IDTerminalRuleCall_5_1_1_0ElementType());
            	    						
            	    lv_val7_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						

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
    // PsiInternalSequencerTestLanguage.g:1206:1: entryRuleList1 returns [Boolean current=false] : iv_ruleList1= ruleList1 EOF ;
    public final Boolean entryRuleList1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleList1 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1206:47: (iv_ruleList1= ruleList1 EOF )
            // PsiInternalSequencerTestLanguage.g:1207:2: iv_ruleList1= ruleList1 EOF
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
    // PsiInternalSequencerTestLanguage.g:1213:1: ruleList1 returns [Boolean current=false] : (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final Boolean ruleList1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1214:1: ( (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:1215:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // PsiInternalSequencerTestLanguage.g:1215:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // PsiInternalSequencerTestLanguage.g:1216:3: otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getList1_NumberSignDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1223:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:1224:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:1224:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:1225:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getList1_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalSequencerTestLanguage.g:1240:3: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==25) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // PsiInternalSequencerTestLanguage.g:1241:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getList1_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalSequencerTestLanguage.g:1248:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:1249:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:1249:5: (lv_val1_3_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:1250:6: lv_val1_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getList1_Val1IDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

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
    // PsiInternalSequencerTestLanguage.g:1270:1: entryRuleList2 returns [Boolean current=false] : iv_ruleList2= ruleList2 EOF ;
    public final Boolean entryRuleList2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleList2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1270:47: (iv_ruleList2= ruleList2 EOF )
            // PsiInternalSequencerTestLanguage.g:1271:2: iv_ruleList2= ruleList2 EOF
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
    // PsiInternalSequencerTestLanguage.g:1277:1: ruleList2 returns [Boolean current=false] : (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? ) ;
    public final Boolean ruleList2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1278:1: ( (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? ) )
            // PsiInternalSequencerTestLanguage.g:1279:2: (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? )
            {
            // PsiInternalSequencerTestLanguage.g:1279:2: (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? )
            // PsiInternalSequencerTestLanguage.g:1280:3: otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )?
            {

            			markLeaf(elementTypeProvider.getList2_NumberSignDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1287:3: ()
            // PsiInternalSequencerTestLanguage.g:1288:4: 
            {

            				precedeComposite(elementTypeProvider.getList2_List2Action_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalSequencerTestLanguage.g:1294:3: ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:1295:4: ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )*
                    {
                    // PsiInternalSequencerTestLanguage.g:1295:4: ( (lv_val1_2_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1296:5: (lv_val1_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1296:5: (lv_val1_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1297:6: lv_val1_2_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getList2_Val1IDTerminalRuleCall_2_0_0ElementType());
                    					
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val1_2_0);
                    					

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:1312:4: (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==25) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // PsiInternalSequencerTestLanguage.g:1313:5: otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getList2_CommaKeyword_2_1_0ElementType());
                    	    				
                    	    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_3);
                    	    				
                    	    // PsiInternalSequencerTestLanguage.g:1320:5: ( (lv_val1_4_0= RULE_ID ) )
                    	    // PsiInternalSequencerTestLanguage.g:1321:6: (lv_val1_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalSequencerTestLanguage.g:1321:6: (lv_val1_4_0= RULE_ID )
                    	    // PsiInternalSequencerTestLanguage.g:1322:7: lv_val1_4_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getList2_Val1IDTerminalRuleCall_2_1_1_0ElementType());
                    	    						
                    	    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

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
    // PsiInternalSequencerTestLanguage.g:1343:1: entryRuleAltList1 returns [Boolean current=false] : iv_ruleAltList1= ruleAltList1 EOF ;
    public final Boolean entryRuleAltList1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAltList1 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1343:50: (iv_ruleAltList1= ruleAltList1 EOF )
            // PsiInternalSequencerTestLanguage.g:1344:2: iv_ruleAltList1= ruleAltList1 EOF
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
    // PsiInternalSequencerTestLanguage.g:1350:1: ruleAltList1 returns [Boolean current=false] : (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) ;
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
            // PsiInternalSequencerTestLanguage.g:1351:1: ( (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1352:2: (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1352:2: (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            // PsiInternalSequencerTestLanguage.g:1353:3: otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            {

            			markLeaf(elementTypeProvider.getAltList1_NumberSignDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1360:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
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
                    // PsiInternalSequencerTestLanguage.g:1361:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1361:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:1362:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1362:5: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1363:6: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1363:6: (lv_val1_1_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1364:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val1_1_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:1379:5: ( (lv_val2_2_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1380:6: (lv_val2_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1380:6: (lv_val2_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1381:7: lv_val2_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val2IDTerminalRuleCall_1_0_1_0ElementType());
                    						
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val2_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1398:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1398:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:1399:5: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getAltList1_Kw1Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalSequencerTestLanguage.g:1406:5: ( (lv_val1_4_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1407:6: (lv_val1_4_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1407:6: (lv_val1_4_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1408:7: lv_val1_4_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    						
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val1_4_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:1423:5: ( (lv_val3_5_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1424:6: (lv_val3_5_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1424:6: (lv_val3_5_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1425:7: lv_val3_5_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val3IDTerminalRuleCall_1_1_2_0ElementType());
                    						
                    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val3_5_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:1442:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    {
                    // PsiInternalSequencerTestLanguage.g:1442:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    // PsiInternalSequencerTestLanguage.g:1443:5: otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )?
                    {

                    					markLeaf(elementTypeProvider.getAltList1_Kw2Keyword_1_2_0ElementType());
                    				
                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_6);
                    				
                    // PsiInternalSequencerTestLanguage.g:1450:5: ( (lv_val1_7_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1451:6: (lv_val1_7_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1451:6: (lv_val1_7_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1452:7: lv_val1_7_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_2_1_0ElementType());
                    						
                    lv_val1_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val1_7_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:1467:5: ( (lv_val4_8_0= RULE_ID ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // PsiInternalSequencerTestLanguage.g:1468:6: (lv_val4_8_0= RULE_ID )
                            {
                            // PsiInternalSequencerTestLanguage.g:1468:6: (lv_val4_8_0= RULE_ID )
                            // PsiInternalSequencerTestLanguage.g:1469:7: lv_val4_8_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getAltList1_Val4IDTerminalRuleCall_1_2_2_0ElementType());
                            						
                            lv_val4_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

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
    // PsiInternalSequencerTestLanguage.g:1490:1: entryRuleAltList2 returns [Boolean current=false] : iv_ruleAltList2= ruleAltList2 EOF ;
    public final Boolean entryRuleAltList2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAltList2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1490:50: (iv_ruleAltList2= ruleAltList2 EOF )
            // PsiInternalSequencerTestLanguage.g:1491:2: iv_ruleAltList2= ruleAltList2 EOF
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
    // PsiInternalSequencerTestLanguage.g:1497:1: ruleAltList2 returns [Boolean current=false] : (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) ;
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
            // PsiInternalSequencerTestLanguage.g:1498:1: ( (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1499:2: (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1499:2: (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1500:3: otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            {

            			markLeaf(elementTypeProvider.getAltList2_NumberSignDigitNineKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_14); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1507:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
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
                    // PsiInternalSequencerTestLanguage.g:1508:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1508:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:1509:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1509:5: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1510:6: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1510:6: (lv_val1_1_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1511:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val1_1_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:1526:5: ( (lv_val2_2_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1527:6: (lv_val2_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1527:6: (lv_val2_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1528:7: lv_val2_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val2IDTerminalRuleCall_1_0_1_0ElementType());
                    						
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val2_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1545:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1545:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    // PsiInternalSequencerTestLanguage.g:1546:5: otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getAltList2_KwKeyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalSequencerTestLanguage.g:1553:5: ( (lv_val1_4_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1554:6: (lv_val1_4_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1554:6: (lv_val1_4_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1555:7: lv_val1_4_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    						
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val1_4_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:1570:5: (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==25) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // PsiInternalSequencerTestLanguage.g:1571:6: otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) )
                    	    {

                    	    						markLeaf(elementTypeProvider.getAltList2_CommaKeyword_1_1_2_0ElementType());
                    	    					
                    	    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_3); 

                    	    						doneLeaf(otherlv_5);
                    	    					
                    	    // PsiInternalSequencerTestLanguage.g:1578:6: ( (lv_val1_6_0= RULE_ID ) )
                    	    // PsiInternalSequencerTestLanguage.g:1579:7: (lv_val1_6_0= RULE_ID )
                    	    {
                    	    // PsiInternalSequencerTestLanguage.g:1579:7: (lv_val1_6_0= RULE_ID )
                    	    // PsiInternalSequencerTestLanguage.g:1580:8: lv_val1_6_0= RULE_ID
                    	    {

                    	    								markLeaf(elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_1_2_1_0ElementType());
                    	    							
                    	    lv_val1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

                    	    								if(!current) {
                    	    									associateWithSemanticElement();
                    	    									current = true;
                    	    								}
                    	    							

                    	    								doneLeaf(lv_val1_6_0);
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // PsiInternalSequencerTestLanguage.g:1596:5: ( (lv_val3_7_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:1597:6: (lv_val3_7_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:1597:6: (lv_val3_7_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:1598:7: lv_val3_7_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val3IDTerminalRuleCall_1_1_3_0ElementType());
                    						
                    lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

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
    // PsiInternalSequencerTestLanguage.g:1619:1: entryRuleSingleKeywords returns [Boolean current=false] : iv_ruleSingleKeywords= ruleSingleKeywords EOF ;
    public final Boolean entryRuleSingleKeywords() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleKeywords = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1619:56: (iv_ruleSingleKeywords= ruleSingleKeywords EOF )
            // PsiInternalSequencerTestLanguage.g:1620:2: iv_ruleSingleKeywords= ruleSingleKeywords EOF
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
    // PsiInternalSequencerTestLanguage.g:1626:1: ruleSingleKeywords returns [Boolean current=false] : (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) ;
    public final Boolean ruleSingleKeywords() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1627:1: ( (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1628:2: (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1628:2: (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1629:3: otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            {

            			markLeaf(elementTypeProvider.getSingleKeywords_NumberSignDigitOneDigitZeroKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1636:3: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            // PsiInternalSequencerTestLanguage.g:1637:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            {
            // PsiInternalSequencerTestLanguage.g:1637:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            // PsiInternalSequencerTestLanguage.g:1638:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
            {
            // PsiInternalSequencerTestLanguage.g:1638:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
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
                    // PsiInternalSequencerTestLanguage.g:1639:6: lv_val_1_1= 'kw1'
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
                    // PsiInternalSequencerTestLanguage.g:1653:6: lv_val_1_2= 'kw2'
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
                    // PsiInternalSequencerTestLanguage.g:1667:6: lv_val_1_3= 'kw3'
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
    // PsiInternalSequencerTestLanguage.g:1687:1: entryRuleSingleKeywordsOrID returns [Boolean current=false] : iv_ruleSingleKeywordsOrID= ruleSingleKeywordsOrID EOF ;
    public final Boolean entryRuleSingleKeywordsOrID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleKeywordsOrID = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1687:60: (iv_ruleSingleKeywordsOrID= ruleSingleKeywordsOrID EOF )
            // PsiInternalSequencerTestLanguage.g:1688:2: iv_ruleSingleKeywordsOrID= ruleSingleKeywordsOrID EOF
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
    // PsiInternalSequencerTestLanguage.g:1694:1: ruleSingleKeywordsOrID returns [Boolean current=false] : (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) ;
    public final Boolean ruleSingleKeywordsOrID() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;
        Token lv_val_1_4=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1695:1: ( (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1696:2: (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1696:2: (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1697:3: otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            {

            			markLeaf(elementTypeProvider.getSingleKeywordsOrID_NumberSignDigitOneDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_17); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1704:3: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:1705:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            {
            // PsiInternalSequencerTestLanguage.g:1705:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:1706:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:1706:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
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
                    // PsiInternalSequencerTestLanguage.g:1707:6: lv_val_1_1= 'kw1'
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
                    // PsiInternalSequencerTestLanguage.g:1721:6: lv_val_1_2= 'kw2'
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
                    // PsiInternalSequencerTestLanguage.g:1735:6: lv_val_1_3= 'kw3'
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
                    // PsiInternalSequencerTestLanguage.g:1749:6: lv_val_1_4= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getSingleKeywordsOrID_ValIDTerminalRuleCall_1_0_3ElementType());
                    					
                    lv_val_1_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
    // PsiInternalSequencerTestLanguage.g:1769:1: entryRuleSingleTerminals returns [Boolean current=false] : iv_ruleSingleTerminals= ruleSingleTerminals EOF ;
    public final Boolean entryRuleSingleTerminals() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleTerminals = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1769:57: (iv_ruleSingleTerminals= ruleSingleTerminals EOF )
            // PsiInternalSequencerTestLanguage.g:1770:2: iv_ruleSingleTerminals= ruleSingleTerminals EOF
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
    // PsiInternalSequencerTestLanguage.g:1776:1: ruleSingleTerminals returns [Boolean current=false] : (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) ;
    public final Boolean ruleSingleTerminals() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;

        try {
            // PsiInternalSequencerTestLanguage.g:1777:1: ( (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1778:2: (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1778:2: (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1779:3: otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            {

            			markLeaf(elementTypeProvider.getSingleTerminals_NumberSignDigitOneDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_18); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1786:3: ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            // PsiInternalSequencerTestLanguage.g:1787:4: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            {
            // PsiInternalSequencerTestLanguage.g:1787:4: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            // PsiInternalSequencerTestLanguage.g:1788:5: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
            {
            // PsiInternalSequencerTestLanguage.g:1788:5: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
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
                    // PsiInternalSequencerTestLanguage.g:1789:6: lv_val_1_1= RULE_ID1
                    {

                    						markLeaf(elementTypeProvider.getSingleTerminals_ValID1TerminalRuleCall_1_0_0ElementType());
                    					
                    lv_val_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val_1_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1803:6: lv_val_1_2= RULE_ID2
                    {

                    						markLeaf(elementTypeProvider.getSingleTerminals_ValID2TerminalRuleCall_1_0_1ElementType());
                    					
                    lv_val_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
    // PsiInternalSequencerTestLanguage.g:1823:1: entryRuleSingleEnum returns [Boolean current=false] : iv_ruleSingleEnum= ruleSingleEnum EOF ;
    public final Boolean entryRuleSingleEnum() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleEnum = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1823:52: (iv_ruleSingleEnum= ruleSingleEnum EOF )
            // PsiInternalSequencerTestLanguage.g:1824:2: iv_ruleSingleEnum= ruleSingleEnum EOF
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
    // PsiInternalSequencerTestLanguage.g:1830:1: ruleSingleEnum returns [Boolean current=false] : (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) ) ;
    public final Boolean ruleSingleEnum() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_val_1_1 = null;

        Boolean lv_val_1_2 = null;

        Boolean lv_val_1_3 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1831:1: ( (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1832:2: (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1832:2: (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1833:3: otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) )
            {

            			markLeaf(elementTypeProvider.getSingleEnum_NumberSignDigitOneDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1840:3: ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) )
            // PsiInternalSequencerTestLanguage.g:1841:4: ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) )
            {
            // PsiInternalSequencerTestLanguage.g:1841:4: ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) )
            // PsiInternalSequencerTestLanguage.g:1842:5: (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 )
            {
            // PsiInternalSequencerTestLanguage.g:1842:5: (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 )
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
                    // PsiInternalSequencerTestLanguage.g:1843:6: lv_val_1_1= ruleDefEnum1
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
                    // PsiInternalSequencerTestLanguage.g:1855:6: lv_val_1_2= ruleDefEnum2
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
                    // PsiInternalSequencerTestLanguage.g:1867:6: lv_val_1_3= ruleDefEnum3
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
    // PsiInternalSequencerTestLanguage.g:1885:1: entryRuleSingleCrossReference returns [Boolean current=false] : iv_ruleSingleCrossReference= ruleSingleCrossReference EOF ;
    public final Boolean entryRuleSingleCrossReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleCrossReference = null;


        try {
            // PsiInternalSequencerTestLanguage.g:1885:62: (iv_ruleSingleCrossReference= ruleSingleCrossReference EOF )
            // PsiInternalSequencerTestLanguage.g:1886:2: iv_ruleSingleCrossReference= ruleSingleCrossReference EOF
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
    // PsiInternalSequencerTestLanguage.g:1892:1: ruleSingleCrossReference returns [Boolean current=false] : (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) ) ;
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
            // PsiInternalSequencerTestLanguage.g:1893:1: ( (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1894:2: (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:1894:2: (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) )
            // PsiInternalSequencerTestLanguage.g:1895:3: otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) )
            {

            			markLeaf(elementTypeProvider.getSingleCrossReference_NumberSignDigitOneDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_19); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:1902:3: ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) )
            // PsiInternalSequencerTestLanguage.g:1903:4: ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) )
            {
            // PsiInternalSequencerTestLanguage.g:1903:4: ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) )
            // PsiInternalSequencerTestLanguage.g:1904:5: (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 )
            {
            // PsiInternalSequencerTestLanguage.g:1904:5: (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 )
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
                    // PsiInternalSequencerTestLanguage.g:1905:6: lv_name_1_1= RULE_ID1
                    {

                    						markLeaf(elementTypeProvider.getSingleCrossReference_NameID1TerminalRuleCall_1_0_0ElementType());
                    					
                    lv_name_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_19); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_name_1_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:1919:6: lv_name_1_2= RULE_ID2
                    {

                    						markLeaf(elementTypeProvider.getSingleCrossReference_NameID2TerminalRuleCall_1_0_1ElementType());
                    					
                    lv_name_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_19); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_name_1_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalSequencerTestLanguage.g:1933:6: lv_name_1_3= RULE_ID3
                    {

                    						markLeaf(elementTypeProvider.getSingleCrossReference_NameID3TerminalRuleCall_1_0_2ElementType());
                    					
                    lv_name_1_3=(Token)match(input,RULE_ID3,FollowSets000.FOLLOW_19); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_name_1_3);
                    					

                    }
                    break;

            }


            }


            }

            // PsiInternalSequencerTestLanguage.g:1949:3: ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) )
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
                    // PsiInternalSequencerTestLanguage.g:1950:4: ( (otherlv_2= RULE_ID1 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1950:4: ( (otherlv_2= RULE_ID1 ) )
                    // PsiInternalSequencerTestLanguage.g:1951:5: (otherlv_2= RULE_ID1 )
                    {
                    // PsiInternalSequencerTestLanguage.g:1951:5: (otherlv_2= RULE_ID1 )
                    // PsiInternalSequencerTestLanguage.g:1952:6: otherlv_2= RULE_ID1
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
                    // PsiInternalSequencerTestLanguage.g:1968:4: ( (otherlv_3= RULE_ID2 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1968:4: ( (otherlv_3= RULE_ID2 ) )
                    // PsiInternalSequencerTestLanguage.g:1969:5: (otherlv_3= RULE_ID2 )
                    {
                    // PsiInternalSequencerTestLanguage.g:1969:5: (otherlv_3= RULE_ID2 )
                    // PsiInternalSequencerTestLanguage.g:1970:6: otherlv_3= RULE_ID2
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
                    // PsiInternalSequencerTestLanguage.g:1986:4: ( (otherlv_4= RULE_ID3 ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:1986:4: ( (otherlv_4= RULE_ID3 ) )
                    // PsiInternalSequencerTestLanguage.g:1987:5: (otherlv_4= RULE_ID3 )
                    {
                    // PsiInternalSequencerTestLanguage.g:1987:5: (otherlv_4= RULE_ID3 )
                    // PsiInternalSequencerTestLanguage.g:1988:6: otherlv_4= RULE_ID3
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
    // PsiInternalSequencerTestLanguage.g:2008:1: entryRuleSingleContainmentReference returns [Boolean current=false] : iv_ruleSingleContainmentReference= ruleSingleContainmentReference EOF ;
    public final Boolean entryRuleSingleContainmentReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleContainmentReference = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2008:68: (iv_ruleSingleContainmentReference= ruleSingleContainmentReference EOF )
            // PsiInternalSequencerTestLanguage.g:2009:2: iv_ruleSingleContainmentReference= ruleSingleContainmentReference EOF
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
    // PsiInternalSequencerTestLanguage.g:2015:1: ruleSingleContainmentReference returns [Boolean current=false] : (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) ) ;
    public final Boolean ruleSingleContainmentReference() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_child_1_1 = null;

        Boolean lv_child_1_2 = null;

        Boolean lv_child_1_3 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2016:1: ( (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2017:2: (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2017:2: (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2018:3: otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) )
            {

            			markLeaf(elementTypeProvider.getSingleContainmentReference_NumberSignDigitOneDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2025:3: ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) )
            // PsiInternalSequencerTestLanguage.g:2026:4: ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) )
            {
            // PsiInternalSequencerTestLanguage.g:2026:4: ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) )
            // PsiInternalSequencerTestLanguage.g:2027:5: (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 )
            {
            // PsiInternalSequencerTestLanguage.g:2027:5: (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 )
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
                    // PsiInternalSequencerTestLanguage.g:2028:6: lv_child_1_1= ruleSingleContainmentReferenceChild1
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
                    // PsiInternalSequencerTestLanguage.g:2040:6: lv_child_1_2= ruleSingleContainmentReferenceChild2
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
                    // PsiInternalSequencerTestLanguage.g:2052:6: lv_child_1_3= ruleSingleContainmentReferenceChild3
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
    // PsiInternalSequencerTestLanguage.g:2070:1: entryRuleSingleContainmentReferenceChild1 returns [Boolean current=false] : iv_ruleSingleContainmentReferenceChild1= ruleSingleContainmentReferenceChild1 EOF ;
    public final Boolean entryRuleSingleContainmentReferenceChild1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleContainmentReferenceChild1 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2070:74: (iv_ruleSingleContainmentReferenceChild1= ruleSingleContainmentReferenceChild1 EOF )
            // PsiInternalSequencerTestLanguage.g:2071:2: iv_ruleSingleContainmentReferenceChild1= ruleSingleContainmentReferenceChild1 EOF
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
    // PsiInternalSequencerTestLanguage.g:2077:1: ruleSingleContainmentReferenceChild1 returns [Boolean current=false] : ( (lv_val_0_0= 'kw1' ) ) ;
    public final Boolean ruleSingleContainmentReferenceChild1() throws RecognitionException {
        Boolean current = false;

        Token lv_val_0_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2078:1: ( ( (lv_val_0_0= 'kw1' ) ) )
            // PsiInternalSequencerTestLanguage.g:2079:2: ( (lv_val_0_0= 'kw1' ) )
            {
            // PsiInternalSequencerTestLanguage.g:2079:2: ( (lv_val_0_0= 'kw1' ) )
            // PsiInternalSequencerTestLanguage.g:2080:3: (lv_val_0_0= 'kw1' )
            {
            // PsiInternalSequencerTestLanguage.g:2080:3: (lv_val_0_0= 'kw1' )
            // PsiInternalSequencerTestLanguage.g:2081:4: lv_val_0_0= 'kw1'
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
    // PsiInternalSequencerTestLanguage.g:2099:1: entryRuleSingleContainmentReferenceChild2 returns [Boolean current=false] : iv_ruleSingleContainmentReferenceChild2= ruleSingleContainmentReferenceChild2 EOF ;
    public final Boolean entryRuleSingleContainmentReferenceChild2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleContainmentReferenceChild2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2099:74: (iv_ruleSingleContainmentReferenceChild2= ruleSingleContainmentReferenceChild2 EOF )
            // PsiInternalSequencerTestLanguage.g:2100:2: iv_ruleSingleContainmentReferenceChild2= ruleSingleContainmentReferenceChild2 EOF
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
    // PsiInternalSequencerTestLanguage.g:2106:1: ruleSingleContainmentReferenceChild2 returns [Boolean current=false] : ( (lv_val_0_0= 'kw2' ) ) ;
    public final Boolean ruleSingleContainmentReferenceChild2() throws RecognitionException {
        Boolean current = false;

        Token lv_val_0_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2107:1: ( ( (lv_val_0_0= 'kw2' ) ) )
            // PsiInternalSequencerTestLanguage.g:2108:2: ( (lv_val_0_0= 'kw2' ) )
            {
            // PsiInternalSequencerTestLanguage.g:2108:2: ( (lv_val_0_0= 'kw2' ) )
            // PsiInternalSequencerTestLanguage.g:2109:3: (lv_val_0_0= 'kw2' )
            {
            // PsiInternalSequencerTestLanguage.g:2109:3: (lv_val_0_0= 'kw2' )
            // PsiInternalSequencerTestLanguage.g:2110:4: lv_val_0_0= 'kw2'
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
    // PsiInternalSequencerTestLanguage.g:2128:1: entryRuleSingleContainmentReferenceChild3 returns [Boolean current=false] : iv_ruleSingleContainmentReferenceChild3= ruleSingleContainmentReferenceChild3 EOF ;
    public final Boolean entryRuleSingleContainmentReferenceChild3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleContainmentReferenceChild3 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2128:74: (iv_ruleSingleContainmentReferenceChild3= ruleSingleContainmentReferenceChild3 EOF )
            // PsiInternalSequencerTestLanguage.g:2129:2: iv_ruleSingleContainmentReferenceChild3= ruleSingleContainmentReferenceChild3 EOF
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
    // PsiInternalSequencerTestLanguage.g:2135:1: ruleSingleContainmentReferenceChild3 returns [Boolean current=false] : ( (lv_val_0_0= 'kw3' ) ) ;
    public final Boolean ruleSingleContainmentReferenceChild3() throws RecognitionException {
        Boolean current = false;

        Token lv_val_0_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2136:1: ( ( (lv_val_0_0= 'kw3' ) ) )
            // PsiInternalSequencerTestLanguage.g:2137:2: ( (lv_val_0_0= 'kw3' ) )
            {
            // PsiInternalSequencerTestLanguage.g:2137:2: ( (lv_val_0_0= 'kw3' ) )
            // PsiInternalSequencerTestLanguage.g:2138:3: (lv_val_0_0= 'kw3' )
            {
            // PsiInternalSequencerTestLanguage.g:2138:3: (lv_val_0_0= 'kw3' )
            // PsiInternalSequencerTestLanguage.g:2139:4: lv_val_0_0= 'kw3'
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
    // PsiInternalSequencerTestLanguage.g:2157:1: entryRuleMultiKeywords returns [Boolean current=false] : iv_ruleMultiKeywords= ruleMultiKeywords EOF ;
    public final Boolean entryRuleMultiKeywords() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMultiKeywords = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2157:55: (iv_ruleMultiKeywords= ruleMultiKeywords EOF )
            // PsiInternalSequencerTestLanguage.g:2158:2: iv_ruleMultiKeywords= ruleMultiKeywords EOF
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
    // PsiInternalSequencerTestLanguage.g:2164:1: ruleMultiKeywords returns [Boolean current=false] : (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) ;
    public final Boolean ruleMultiKeywords() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2165:1: ( (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2166:2: (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2166:2: (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2167:3: otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            {

            			markLeaf(elementTypeProvider.getMultiKeywords_NumberSignDigitOneDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2174:3: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            // PsiInternalSequencerTestLanguage.g:2175:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            {
            // PsiInternalSequencerTestLanguage.g:2175:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            // PsiInternalSequencerTestLanguage.g:2176:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
            {
            // PsiInternalSequencerTestLanguage.g:2176:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
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
                    // PsiInternalSequencerTestLanguage.g:2177:6: lv_val_1_1= 'kw1'
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
                    // PsiInternalSequencerTestLanguage.g:2191:6: lv_val_1_2= 'kw2'
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
                    // PsiInternalSequencerTestLanguage.g:2205:6: lv_val_1_3= 'kw3'
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
    // PsiInternalSequencerTestLanguage.g:2225:1: entryRuleMultiKeywordsOrID returns [Boolean current=false] : iv_ruleMultiKeywordsOrID= ruleMultiKeywordsOrID EOF ;
    public final Boolean entryRuleMultiKeywordsOrID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMultiKeywordsOrID = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2225:59: (iv_ruleMultiKeywordsOrID= ruleMultiKeywordsOrID EOF )
            // PsiInternalSequencerTestLanguage.g:2226:2: iv_ruleMultiKeywordsOrID= ruleMultiKeywordsOrID EOF
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
    // PsiInternalSequencerTestLanguage.g:2232:1: ruleMultiKeywordsOrID returns [Boolean current=false] : (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) ;
    public final Boolean ruleMultiKeywordsOrID() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;
        Token lv_val_1_4=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2233:1: ( (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2234:2: (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2234:2: (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2235:3: otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            {

            			markLeaf(elementTypeProvider.getMultiKeywordsOrID_NumberSignDigitOneDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_17); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2242:3: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:2243:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            {
            // PsiInternalSequencerTestLanguage.g:2243:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:2244:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:2244:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
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
                    // PsiInternalSequencerTestLanguage.g:2245:6: lv_val_1_1= 'kw1'
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
                    // PsiInternalSequencerTestLanguage.g:2259:6: lv_val_1_2= 'kw2'
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
                    // PsiInternalSequencerTestLanguage.g:2273:6: lv_val_1_3= 'kw3'
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
                    // PsiInternalSequencerTestLanguage.g:2287:6: lv_val_1_4= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getMultiKeywordsOrID_ValIDTerminalRuleCall_1_0_3ElementType());
                    					
                    lv_val_1_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
    // PsiInternalSequencerTestLanguage.g:2307:1: entryRuleMultiTerminals returns [Boolean current=false] : iv_ruleMultiTerminals= ruleMultiTerminals EOF ;
    public final Boolean entryRuleMultiTerminals() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMultiTerminals = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2307:56: (iv_ruleMultiTerminals= ruleMultiTerminals EOF )
            // PsiInternalSequencerTestLanguage.g:2308:2: iv_ruleMultiTerminals= ruleMultiTerminals EOF
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
    // PsiInternalSequencerTestLanguage.g:2314:1: ruleMultiTerminals returns [Boolean current=false] : (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) ;
    public final Boolean ruleMultiTerminals() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2315:1: ( (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2316:2: (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2316:2: (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2317:3: otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            {

            			markLeaf(elementTypeProvider.getMultiTerminals_NumberSignDigitOneDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_18); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2324:3: ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            // PsiInternalSequencerTestLanguage.g:2325:4: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            {
            // PsiInternalSequencerTestLanguage.g:2325:4: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            // PsiInternalSequencerTestLanguage.g:2326:5: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
            {
            // PsiInternalSequencerTestLanguage.g:2326:5: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
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
                    // PsiInternalSequencerTestLanguage.g:2327:6: lv_val_1_1= RULE_ID1
                    {

                    						markLeaf(elementTypeProvider.getMultiTerminals_ValID1TerminalRuleCall_1_0_0ElementType());
                    					
                    lv_val_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val_1_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:2341:6: lv_val_1_2= RULE_ID2
                    {

                    						markLeaf(elementTypeProvider.getMultiTerminals_ValID2TerminalRuleCall_1_0_1ElementType());
                    					
                    lv_val_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
    // PsiInternalSequencerTestLanguage.g:2361:1: entryRuleDependentAlternative1 returns [Boolean current=false] : iv_ruleDependentAlternative1= ruleDependentAlternative1 EOF ;
    public final Boolean entryRuleDependentAlternative1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDependentAlternative1 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2361:63: (iv_ruleDependentAlternative1= ruleDependentAlternative1 EOF )
            // PsiInternalSequencerTestLanguage.g:2362:2: iv_ruleDependentAlternative1= ruleDependentAlternative1 EOF
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
    // PsiInternalSequencerTestLanguage.g:2368:1: ruleDependentAlternative1 returns [Boolean current=false] : (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) ) ;
    public final Boolean ruleDependentAlternative1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token lv_val_2_0=null;
        Token lv_flag_3_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2369:1: ( (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2370:2: (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2370:2: (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2371:3: otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) )
            {

            			markLeaf(elementTypeProvider.getDependentAlternative1_NumberSignDigitOneDigitNineKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2378:3: ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) )
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
                    // PsiInternalSequencerTestLanguage.g:2379:4: ( (lv_val_1_0= RULE_ID ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:2379:4: ( (lv_val_1_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:2380:5: (lv_val_1_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:2380:5: (lv_val_1_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:2381:6: lv_val_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getDependentAlternative1_ValIDTerminalRuleCall_1_0_0ElementType());
                    					
                    lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val_1_0);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSequencerTestLanguage.g:2397:4: ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:2397:4: ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) )
                    // PsiInternalSequencerTestLanguage.g:2398:5: ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:2398:5: ( (lv_val_2_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:2399:6: (lv_val_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:2399:6: (lv_val_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:2400:7: lv_val_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getDependentAlternative1_ValIDTerminalRuleCall_1_1_0_0ElementType());
                    						
                    lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val_2_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:2415:5: ( (lv_flag_3_0= 'kw1' ) )
                    // PsiInternalSequencerTestLanguage.g:2416:6: (lv_flag_3_0= 'kw1' )
                    {
                    // PsiInternalSequencerTestLanguage.g:2416:6: (lv_flag_3_0= 'kw1' )
                    // PsiInternalSequencerTestLanguage.g:2417:7: lv_flag_3_0= 'kw1'
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
    // PsiInternalSequencerTestLanguage.g:2438:1: entryRuleDependentAlternative2 returns [Boolean current=false] : iv_ruleDependentAlternative2= ruleDependentAlternative2 EOF ;
    public final Boolean entryRuleDependentAlternative2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDependentAlternative2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2438:63: (iv_ruleDependentAlternative2= ruleDependentAlternative2 EOF )
            // PsiInternalSequencerTestLanguage.g:2439:2: iv_ruleDependentAlternative2= ruleDependentAlternative2 EOF
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
    // PsiInternalSequencerTestLanguage.g:2445:1: ruleDependentAlternative2 returns [Boolean current=false] : (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) ) ;
    public final Boolean ruleDependentAlternative2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token lv_val_2_0=null;
        Token lv_val_3_0=null;
        Token lv_flag_4_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2446:1: ( (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2447:2: (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2447:2: (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2448:3: otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )
            {

            			markLeaf(elementTypeProvider.getDependentAlternative2_NumberSignDigitTwoDigitZeroKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2455:3: ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:2456:4: ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ )
                    {
                    // PsiInternalSequencerTestLanguage.g:2456:4: ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ )
                    // PsiInternalSequencerTestLanguage.g:2457:5: ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+
                    {
                    // PsiInternalSequencerTestLanguage.g:2457:5: ( (lv_val_1_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:2458:6: (lv_val_1_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:2458:6: (lv_val_1_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:2459:7: lv_val_1_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getDependentAlternative2_ValIDTerminalRuleCall_1_0_0_0ElementType());
                    						
                    lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val_1_0);
                    						

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:2474:5: ( (lv_val_2_0= RULE_ID ) )+
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
                    	    // PsiInternalSequencerTestLanguage.g:2475:6: (lv_val_2_0= RULE_ID )
                    	    {
                    	    // PsiInternalSequencerTestLanguage.g:2475:6: (lv_val_2_0= RULE_ID )
                    	    // PsiInternalSequencerTestLanguage.g:2476:7: lv_val_2_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getDependentAlternative2_ValIDTerminalRuleCall_1_0_1_0ElementType());
                    	    						
                    	    lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

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
                    // PsiInternalSequencerTestLanguage.g:2493:4: ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:2493:4: ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) )
                    // PsiInternalSequencerTestLanguage.g:2494:5: ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:2494:5: ( (lv_val_3_0= RULE_ID ) )+
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
                    	    // PsiInternalSequencerTestLanguage.g:2495:6: (lv_val_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalSequencerTestLanguage.g:2495:6: (lv_val_3_0= RULE_ID )
                    	    // PsiInternalSequencerTestLanguage.g:2496:7: lv_val_3_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getDependentAlternative2_ValIDTerminalRuleCall_1_1_0_0ElementType());
                    	    						
                    	    lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); 

                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

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

                    // PsiInternalSequencerTestLanguage.g:2511:5: ( (lv_flag_4_0= 'kw1' ) )
                    // PsiInternalSequencerTestLanguage.g:2512:6: (lv_flag_4_0= 'kw1' )
                    {
                    // PsiInternalSequencerTestLanguage.g:2512:6: (lv_flag_4_0= 'kw1' )
                    // PsiInternalSequencerTestLanguage.g:2513:7: lv_flag_4_0= 'kw1'
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
    // PsiInternalSequencerTestLanguage.g:2534:1: entryRuleOptional returns [Boolean current=false] : iv_ruleOptional= ruleOptional EOF ;
    public final Boolean entryRuleOptional() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOptional = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2534:50: (iv_ruleOptional= ruleOptional EOF )
            // PsiInternalSequencerTestLanguage.g:2535:2: iv_ruleOptional= ruleOptional EOF
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
    // PsiInternalSequencerTestLanguage.g:2541:1: ruleOptional returns [Boolean current=false] : (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? ) ;
    public final Boolean ruleOptional() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_int0_1_0=null;
        Token lv_int1_2_0=null;
        Token lv_int2_3_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2542:1: ( (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? ) )
            // PsiInternalSequencerTestLanguage.g:2543:2: (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? )
            {
            // PsiInternalSequencerTestLanguage.g:2543:2: (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? )
            // PsiInternalSequencerTestLanguage.g:2544:3: otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )?
            {

            			markLeaf(elementTypeProvider.getOptional_NumberSignDigitTwoDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_21); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2551:3: ( (lv_int0_1_0= RULE_INT ) )
            // PsiInternalSequencerTestLanguage.g:2552:4: (lv_int0_1_0= RULE_INT )
            {
            // PsiInternalSequencerTestLanguage.g:2552:4: (lv_int0_1_0= RULE_INT )
            // PsiInternalSequencerTestLanguage.g:2553:5: lv_int0_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getOptional_Int0INTTerminalRuleCall_1_0ElementType());
            				
            lv_int0_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_int0_1_0);
            				

            }


            }

            // PsiInternalSequencerTestLanguage.g:2568:3: ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_INT) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:2569:4: ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:2569:4: ( (lv_int1_2_0= RULE_INT ) )
                    // PsiInternalSequencerTestLanguage.g:2570:5: (lv_int1_2_0= RULE_INT )
                    {
                    // PsiInternalSequencerTestLanguage.g:2570:5: (lv_int1_2_0= RULE_INT )
                    // PsiInternalSequencerTestLanguage.g:2571:6: lv_int1_2_0= RULE_INT
                    {

                    						markLeaf(elementTypeProvider.getOptional_Int1INTTerminalRuleCall_2_0_0ElementType());
                    					
                    lv_int1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_21); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_int1_2_0);
                    					

                    }


                    }

                    // PsiInternalSequencerTestLanguage.g:2586:4: ( (lv_int2_3_0= RULE_INT ) )
                    // PsiInternalSequencerTestLanguage.g:2587:5: (lv_int2_3_0= RULE_INT )
                    {
                    // PsiInternalSequencerTestLanguage.g:2587:5: (lv_int2_3_0= RULE_INT )
                    // PsiInternalSequencerTestLanguage.g:2588:6: lv_int2_3_0= RULE_INT
                    {

                    						markLeaf(elementTypeProvider.getOptional_Int2INTTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_int2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
    // PsiInternalSequencerTestLanguage.g:2608:1: entryRuleFloat returns [Boolean current=false] : iv_ruleFloat= ruleFloat EOF ;
    public final Boolean entryRuleFloat() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFloat = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2608:47: (iv_ruleFloat= ruleFloat EOF )
            // PsiInternalSequencerTestLanguage.g:2609:2: iv_ruleFloat= ruleFloat EOF
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
    // PsiInternalSequencerTestLanguage.g:2615:1: ruleFloat returns [Boolean current=false] : (otherlv_0= '#22' () otherlv_2= 'Bye' ) ;
    public final Boolean ruleFloat() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2616:1: ( (otherlv_0= '#22' () otherlv_2= 'Bye' ) )
            // PsiInternalSequencerTestLanguage.g:2617:2: (otherlv_0= '#22' () otherlv_2= 'Bye' )
            {
            // PsiInternalSequencerTestLanguage.g:2617:2: (otherlv_0= '#22' () otherlv_2= 'Bye' )
            // PsiInternalSequencerTestLanguage.g:2618:3: otherlv_0= '#22' () otherlv_2= 'Bye'
            {

            			markLeaf(elementTypeProvider.getFloat_NumberSignDigitTwoDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_23); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2625:3: ()
            // PsiInternalSequencerTestLanguage.g:2626:4: 
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
    // PsiInternalSequencerTestLanguage.g:2643:1: entryRuleUnorderedAlternative returns [Boolean current=false] : iv_ruleUnorderedAlternative= ruleUnorderedAlternative EOF ;
    public final Boolean entryRuleUnorderedAlternative() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedAlternative = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2643:62: (iv_ruleUnorderedAlternative= ruleUnorderedAlternative EOF )
            // PsiInternalSequencerTestLanguage.g:2644:2: iv_ruleUnorderedAlternative= ruleUnorderedAlternative EOF
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
    // PsiInternalSequencerTestLanguage.g:2650:1: ruleUnorderedAlternative returns [Boolean current=false] : (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* ) ;
    public final Boolean ruleUnorderedAlternative() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Boolean lv_val3_4_0 = null;

        Boolean lv_val4_5_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2651:1: ( (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:2652:2: (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* )
            {
            // PsiInternalSequencerTestLanguage.g:2652:2: (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* )
            // PsiInternalSequencerTestLanguage.g:2653:3: otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )*
            {

            			markLeaf(elementTypeProvider.getUnorderedAlternative_NumberSignDigitTwoDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_24); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2660:3: ()
            // PsiInternalSequencerTestLanguage.g:2661:4: 
            {

            				precedeComposite(elementTypeProvider.getUnorderedAlternative_UnorderedAlternativeAction_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalSequencerTestLanguage.g:2667:3: ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )*
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
            	    // PsiInternalSequencerTestLanguage.g:2668:4: ( (lv_val1_2_0= RULE_ID ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2668:4: ( (lv_val1_2_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:2669:5: (lv_val1_2_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2669:5: (lv_val1_2_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:2670:6: lv_val1_2_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getUnorderedAlternative_Val1IDTerminalRuleCall_2_0_0ElementType());
            	    					
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_24); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_val1_2_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSequencerTestLanguage.g:2686:4: ( (lv_val2_3_0= RULE_INT ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2686:4: ( (lv_val2_3_0= RULE_INT ) )
            	    // PsiInternalSequencerTestLanguage.g:2687:5: (lv_val2_3_0= RULE_INT )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2687:5: (lv_val2_3_0= RULE_INT )
            	    // PsiInternalSequencerTestLanguage.g:2688:6: lv_val2_3_0= RULE_INT
            	    {

            	    						markLeaf(elementTypeProvider.getUnorderedAlternative_Val2INTTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_val2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_24); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_val2_3_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalSequencerTestLanguage.g:2704:4: ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2704:4: ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) )
            	    // PsiInternalSequencerTestLanguage.g:2705:5: (lv_val3_4_0= ruleUnorderedAlternativeVal )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2705:5: (lv_val3_4_0= ruleUnorderedAlternativeVal )
            	    // PsiInternalSequencerTestLanguage.g:2706:6: lv_val3_4_0= ruleUnorderedAlternativeVal
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
            	    // PsiInternalSequencerTestLanguage.g:2720:4: ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2720:4: ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) )
            	    // PsiInternalSequencerTestLanguage.g:2721:5: (lv_val4_5_0= ruleUnorderedAlternativeValDelegate )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2721:5: (lv_val4_5_0= ruleUnorderedAlternativeValDelegate )
            	    // PsiInternalSequencerTestLanguage.g:2722:6: lv_val4_5_0= ruleUnorderedAlternativeValDelegate
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
    // PsiInternalSequencerTestLanguage.g:2740:1: entryRuleUnorderedAlternativeVal returns [Boolean current=false] : iv_ruleUnorderedAlternativeVal= ruleUnorderedAlternativeVal EOF ;
    public final Boolean entryRuleUnorderedAlternativeVal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedAlternativeVal = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2740:65: (iv_ruleUnorderedAlternativeVal= ruleUnorderedAlternativeVal EOF )
            // PsiInternalSequencerTestLanguage.g:2741:2: iv_ruleUnorderedAlternativeVal= ruleUnorderedAlternativeVal EOF
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
    // PsiInternalSequencerTestLanguage.g:2747:1: ruleUnorderedAlternativeVal returns [Boolean current=false] : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleUnorderedAlternativeVal() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2748:1: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2749:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2749:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:2750:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedAlternativeVal_Kw1Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2757:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:2758:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:2758:4: (lv_val_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:2759:5: lv_val_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnorderedAlternativeVal_ValIDTerminalRuleCall_1_0ElementType());
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // PsiInternalSequencerTestLanguage.g:2778:1: entryRuleUnorderedAlternativeValDelegate returns [Boolean current=false] : iv_ruleUnorderedAlternativeValDelegate= ruleUnorderedAlternativeValDelegate EOF ;
    public final Boolean entryRuleUnorderedAlternativeValDelegate() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedAlternativeValDelegate = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2778:73: (iv_ruleUnorderedAlternativeValDelegate= ruleUnorderedAlternativeValDelegate EOF )
            // PsiInternalSequencerTestLanguage.g:2779:2: iv_ruleUnorderedAlternativeValDelegate= ruleUnorderedAlternativeValDelegate EOF
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
    // PsiInternalSequencerTestLanguage.g:2785:1: ruleUnorderedAlternativeValDelegate returns [Boolean current=false] : this_UnorderedAlternativeVal2_0= ruleUnorderedAlternativeVal2 ;
    public final Boolean ruleUnorderedAlternativeValDelegate() throws RecognitionException {
        Boolean current = false;

        Boolean this_UnorderedAlternativeVal2_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2786:1: (this_UnorderedAlternativeVal2_0= ruleUnorderedAlternativeVal2 )
            // PsiInternalSequencerTestLanguage.g:2787:2: this_UnorderedAlternativeVal2_0= ruleUnorderedAlternativeVal2
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
    // PsiInternalSequencerTestLanguage.g:2798:1: entryRuleUnorderedAlternativeVal2 returns [Boolean current=false] : iv_ruleUnorderedAlternativeVal2= ruleUnorderedAlternativeVal2 EOF ;
    public final Boolean entryRuleUnorderedAlternativeVal2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedAlternativeVal2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2798:66: (iv_ruleUnorderedAlternativeVal2= ruleUnorderedAlternativeVal2 EOF )
            // PsiInternalSequencerTestLanguage.g:2799:2: iv_ruleUnorderedAlternativeVal2= ruleUnorderedAlternativeVal2 EOF
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
    // PsiInternalSequencerTestLanguage.g:2805:1: ruleUnorderedAlternativeVal2 returns [Boolean current=false] : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleUnorderedAlternativeVal2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2806:1: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2807:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2807:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:2808:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedAlternativeVal2_Kw2Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2815:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:2816:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:2816:4: (lv_val_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:2817:5: lv_val_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnorderedAlternativeVal2_ValIDTerminalRuleCall_1_0ElementType());
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // PsiInternalSequencerTestLanguage.g:2836:1: entryRuleUnorderedGroup returns [Boolean current=false] : iv_ruleUnorderedGroup= ruleUnorderedGroup EOF ;
    public final Boolean entryRuleUnorderedGroup() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroup = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2836:56: (iv_ruleUnorderedGroup= ruleUnorderedGroup EOF )
            // PsiInternalSequencerTestLanguage.g:2837:2: iv_ruleUnorderedGroup= ruleUnorderedGroup EOF
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
    // PsiInternalSequencerTestLanguage.g:2843:1: ruleUnorderedGroup returns [Boolean current=false] : (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) ) ;
    public final Boolean ruleUnorderedGroup() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Boolean lv_val3_4_0 = null;

        Boolean lv_val4_5_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2844:1: ( (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2845:2: (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2845:2: (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) )
            // PsiInternalSequencerTestLanguage.g:2846:3: otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedGroup_NumberSignDigitTwoDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_25); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2853:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) )
            // PsiInternalSequencerTestLanguage.g:2854:4: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) )
            {
            // PsiInternalSequencerTestLanguage.g:2854:4: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) )
            // PsiInternalSequencerTestLanguage.g:2855:5: ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            				
            // PsiInternalSequencerTestLanguage.g:2858:5: ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?)
            // PsiInternalSequencerTestLanguage.g:2859:6: ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?
            {
            // PsiInternalSequencerTestLanguage.g:2859:6: ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+
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
            	    // PsiInternalSequencerTestLanguage.g:2860:4: ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2860:4: ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2861:5: {...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2861:111: ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2862:6: ({...}? => ( (lv_val1_2_0= RULE_ID ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:2865:9: ({...}? => ( (lv_val1_2_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2865:10: {...}? => ( (lv_val1_2_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2865:19: ( (lv_val1_2_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:2865:20: (lv_val1_2_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2865:20: (lv_val1_2_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:2866:10: lv_val1_2_0= RULE_ID
            	    {

            	    										markLeaf(elementTypeProvider.getUnorderedGroup_Val1IDTerminalRuleCall_1_0_0ElementType());
            	    									
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_24); 

            	    										if(!current) {
            	    											associateWithSemanticElement();
            	    											current = true;
            	    										}
            	    									

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
            	    // PsiInternalSequencerTestLanguage.g:2886:4: ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2886:4: ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2887:5: {...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2887:111: ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2888:6: ({...}? => ( (lv_val2_3_0= RULE_INT ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:2891:9: ({...}? => ( (lv_val2_3_0= RULE_INT ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2891:10: {...}? => ( (lv_val2_3_0= RULE_INT ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2891:19: ( (lv_val2_3_0= RULE_INT ) )
            	    // PsiInternalSequencerTestLanguage.g:2891:20: (lv_val2_3_0= RULE_INT )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2891:20: (lv_val2_3_0= RULE_INT )
            	    // PsiInternalSequencerTestLanguage.g:2892:10: lv_val2_3_0= RULE_INT
            	    {

            	    										markLeaf(elementTypeProvider.getUnorderedGroup_Val2INTTerminalRuleCall_1_1_0ElementType());
            	    									
            	    lv_val2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_24); 

            	    										if(!current) {
            	    											associateWithSemanticElement();
            	    											current = true;
            	    										}
            	    									

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
            	    // PsiInternalSequencerTestLanguage.g:2912:4: ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2912:4: ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2913:5: {...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2913:111: ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2914:6: ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:2917:9: ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2917:10: {...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2917:19: ( (lv_val3_4_0= ruleUnorderedGroupVal ) )
            	    // PsiInternalSequencerTestLanguage.g:2917:20: (lv_val3_4_0= ruleUnorderedGroupVal )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2917:20: (lv_val3_4_0= ruleUnorderedGroupVal )
            	    // PsiInternalSequencerTestLanguage.g:2918:10: lv_val3_4_0= ruleUnorderedGroupVal
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
            	    // PsiInternalSequencerTestLanguage.g:2936:4: ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2936:4: ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2937:5: {...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2937:111: ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2938:6: ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:2941:9: ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) )
            	    // PsiInternalSequencerTestLanguage.g:2941:10: {...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:2941:19: ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) )
            	    // PsiInternalSequencerTestLanguage.g:2941:20: (lv_val4_5_0= ruleUnorderedGroupValDelegate )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:2941:20: (lv_val4_5_0= ruleUnorderedGroupValDelegate )
            	    // PsiInternalSequencerTestLanguage.g:2942:10: lv_val4_5_0= ruleUnorderedGroupValDelegate
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
    // PsiInternalSequencerTestLanguage.g:2972:1: entryRuleUnorderedGroupVal returns [Boolean current=false] : iv_ruleUnorderedGroupVal= ruleUnorderedGroupVal EOF ;
    public final Boolean entryRuleUnorderedGroupVal() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroupVal = null;


        try {
            // PsiInternalSequencerTestLanguage.g:2972:59: (iv_ruleUnorderedGroupVal= ruleUnorderedGroupVal EOF )
            // PsiInternalSequencerTestLanguage.g:2973:2: iv_ruleUnorderedGroupVal= ruleUnorderedGroupVal EOF
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
    // PsiInternalSequencerTestLanguage.g:2979:1: ruleUnorderedGroupVal returns [Boolean current=false] : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleUnorderedGroupVal() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:2980:1: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:2981:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:2981:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:2982:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedGroupVal_Kw1Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:2989:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:2990:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:2990:4: (lv_val_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:2991:5: lv_val_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnorderedGroupVal_ValIDTerminalRuleCall_1_0ElementType());
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // PsiInternalSequencerTestLanguage.g:3010:1: entryRuleUnorderedGroupValDelegate returns [Boolean current=false] : iv_ruleUnorderedGroupValDelegate= ruleUnorderedGroupValDelegate EOF ;
    public final Boolean entryRuleUnorderedGroupValDelegate() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroupValDelegate = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3010:67: (iv_ruleUnorderedGroupValDelegate= ruleUnorderedGroupValDelegate EOF )
            // PsiInternalSequencerTestLanguage.g:3011:2: iv_ruleUnorderedGroupValDelegate= ruleUnorderedGroupValDelegate EOF
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
    // PsiInternalSequencerTestLanguage.g:3017:1: ruleUnorderedGroupValDelegate returns [Boolean current=false] : this_UnorderedGroupVal2_0= ruleUnorderedGroupVal2 ;
    public final Boolean ruleUnorderedGroupValDelegate() throws RecognitionException {
        Boolean current = false;

        Boolean this_UnorderedGroupVal2_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3018:1: (this_UnorderedGroupVal2_0= ruleUnorderedGroupVal2 )
            // PsiInternalSequencerTestLanguage.g:3019:2: this_UnorderedGroupVal2_0= ruleUnorderedGroupVal2
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
    // PsiInternalSequencerTestLanguage.g:3030:1: entryRuleUnorderedGroupVal2 returns [Boolean current=false] : iv_ruleUnorderedGroupVal2= ruleUnorderedGroupVal2 EOF ;
    public final Boolean entryRuleUnorderedGroupVal2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroupVal2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3030:60: (iv_ruleUnorderedGroupVal2= ruleUnorderedGroupVal2 EOF )
            // PsiInternalSequencerTestLanguage.g:3031:2: iv_ruleUnorderedGroupVal2= ruleUnorderedGroupVal2 EOF
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
    // PsiInternalSequencerTestLanguage.g:3037:1: ruleUnorderedGroupVal2 returns [Boolean current=false] : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleUnorderedGroupVal2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3038:1: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3039:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3039:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:3040:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedGroupVal2_Kw2Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3047:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:3048:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:3048:4: (lv_val_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:3049:5: lv_val_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnorderedGroupVal2_ValIDTerminalRuleCall_1_0ElementType());
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // PsiInternalSequencerTestLanguage.g:3068:1: entryRuleUnorderedGroupOptional returns [Boolean current=false] : iv_ruleUnorderedGroupOptional= ruleUnorderedGroupOptional EOF ;
    public final Boolean entryRuleUnorderedGroupOptional() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroupOptional = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3068:64: (iv_ruleUnorderedGroupOptional= ruleUnorderedGroupOptional EOF )
            // PsiInternalSequencerTestLanguage.g:3069:2: iv_ruleUnorderedGroupOptional= ruleUnorderedGroupOptional EOF
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
    // PsiInternalSequencerTestLanguage.g:3075:1: ruleUnorderedGroupOptional returns [Boolean current=false] : (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) ) ;
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
            // PsiInternalSequencerTestLanguage.g:3076:1: ( (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3077:2: (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3077:2: (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3078:3: otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedGroupOptional_NumberSignDigitTwoDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_26); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3085:3: ()
            // PsiInternalSequencerTestLanguage.g:3086:4: 
            {

            				precedeComposite(elementTypeProvider.getUnorderedGroupOptional_UnorderedGroupOptionalAction_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalSequencerTestLanguage.g:3092:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) )
            // PsiInternalSequencerTestLanguage.g:3093:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) )
            {
            // PsiInternalSequencerTestLanguage.g:3093:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:3094:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2());
            				
            // PsiInternalSequencerTestLanguage.g:3097:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* )
            // PsiInternalSequencerTestLanguage.g:3098:6: ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )*
            {
            // PsiInternalSequencerTestLanguage.g:3098:6: ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )*
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
            	    // PsiInternalSequencerTestLanguage.g:3099:4: ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3099:4: ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3100:5: {...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3100:119: ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3101:6: ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:3104:9: ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3104:10: {...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3104:19: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3104:20: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) )
            	    {

            	    									markLeaf(elementTypeProvider.getUnorderedGroupOptional_Kw1Keyword_2_0_0ElementType());
            	    								
            	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            	    									doneLeaf(otherlv_3);
            	    								
            	    // PsiInternalSequencerTestLanguage.g:3111:9: ( (lv_val1_4_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3112:10: (lv_val1_4_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3112:10: (lv_val1_4_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3113:11: lv_val1_4_0= RULE_ID
            	    {

            	    											markLeaf(elementTypeProvider.getUnorderedGroupOptional_Val1IDTerminalRuleCall_2_0_1_0ElementType());
            	    										
            	    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            	    											if(!current) {
            	    												associateWithSemanticElement();
            	    												current = true;
            	    											}
            	    										

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
            	    // PsiInternalSequencerTestLanguage.g:3134:4: ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3134:4: ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3135:5: {...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3135:119: ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3136:6: ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:3139:9: ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3139:10: {...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3139:19: (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3139:20: otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) )
            	    {

            	    									markLeaf(elementTypeProvider.getUnorderedGroupOptional_Kw2Keyword_2_1_0ElementType());
            	    								
            	    otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            	    									doneLeaf(otherlv_5);
            	    								
            	    // PsiInternalSequencerTestLanguage.g:3146:9: ( (lv_va2_6_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3147:10: (lv_va2_6_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3147:10: (lv_va2_6_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3148:11: lv_va2_6_0= RULE_ID
            	    {

            	    											markLeaf(elementTypeProvider.getUnorderedGroupOptional_Va2IDTerminalRuleCall_2_1_1_0ElementType());
            	    										
            	    lv_va2_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            	    											if(!current) {
            	    												associateWithSemanticElement();
            	    												current = true;
            	    											}
            	    										

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
            	    // PsiInternalSequencerTestLanguage.g:3169:4: ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3169:4: ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3170:5: {...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3170:119: ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3171:6: ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:3174:9: ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3174:10: {...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3174:19: (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3174:20: otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) )
            	    {

            	    									markLeaf(elementTypeProvider.getUnorderedGroupOptional_Kw3Keyword_2_2_0ElementType());
            	    								
            	    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	    									doneLeaf(otherlv_7);
            	    								
            	    // PsiInternalSequencerTestLanguage.g:3181:9: ( (lv_val3_8_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3182:10: (lv_val3_8_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3182:10: (lv_val3_8_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3183:11: lv_val3_8_0= RULE_ID
            	    {

            	    											markLeaf(elementTypeProvider.getUnorderedGroupOptional_Val3IDTerminalRuleCall_2_2_1_0ElementType());
            	    										
            	    lv_val3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            	    											if(!current) {
            	    												associateWithSemanticElement();
            	    												current = true;
            	    											}
            	    										

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
    // PsiInternalSequencerTestLanguage.g:3215:1: entryRuleUnorderedGroupBoolean returns [Boolean current=false] : iv_ruleUnorderedGroupBoolean= ruleUnorderedGroupBoolean EOF ;
    public final Boolean entryRuleUnorderedGroupBoolean() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnorderedGroupBoolean = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3215:63: (iv_ruleUnorderedGroupBoolean= ruleUnorderedGroupBoolean EOF )
            // PsiInternalSequencerTestLanguage.g:3216:2: iv_ruleUnorderedGroupBoolean= ruleUnorderedGroupBoolean EOF
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
    // PsiInternalSequencerTestLanguage.g:3222:1: ruleUnorderedGroupBoolean returns [Boolean current=false] : (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) ) ;
    public final Boolean ruleUnorderedGroupBoolean() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_3_0=null;
        Token lv_val2_4_0=null;
        Token lv_val3_5_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3223:1: ( (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3224:2: (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3224:2: (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3225:3: otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) )
            {

            			markLeaf(elementTypeProvider.getUnorderedGroupBoolean_NumberSignDigitTwoDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,47,FollowSets000.FOLLOW_26); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3232:3: ()
            // PsiInternalSequencerTestLanguage.g:3233:4: 
            {

            				precedeComposite(elementTypeProvider.getUnorderedGroupBoolean_UnorderedGroupBooleanAction_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalSequencerTestLanguage.g:3239:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) )
            // PsiInternalSequencerTestLanguage.g:3240:4: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) )
            {
            // PsiInternalSequencerTestLanguage.g:3240:4: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:3241:5: ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
            				
            // PsiInternalSequencerTestLanguage.g:3244:5: ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* )
            // PsiInternalSequencerTestLanguage.g:3245:6: ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )*
            {
            // PsiInternalSequencerTestLanguage.g:3245:6: ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )*
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
            	    // PsiInternalSequencerTestLanguage.g:3246:4: ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3246:4: ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3247:5: {...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3247:118: ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3248:6: ({...}? => ( (lv_val1_3_0= 'kw1' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:3251:9: ({...}? => ( (lv_val1_3_0= 'kw1' ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3251:10: {...}? => ( (lv_val1_3_0= 'kw1' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3251:19: ( (lv_val1_3_0= 'kw1' ) )
            	    // PsiInternalSequencerTestLanguage.g:3251:20: (lv_val1_3_0= 'kw1' )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3251:20: (lv_val1_3_0= 'kw1' )
            	    // PsiInternalSequencerTestLanguage.g:3252:10: lv_val1_3_0= 'kw1'
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
            	    // PsiInternalSequencerTestLanguage.g:3272:4: ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3272:4: ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3273:5: {...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3273:118: ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3274:6: ({...}? => ( (lv_val2_4_0= 'kw2' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:3277:9: ({...}? => ( (lv_val2_4_0= 'kw2' ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3277:10: {...}? => ( (lv_val2_4_0= 'kw2' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3277:19: ( (lv_val2_4_0= 'kw2' ) )
            	    // PsiInternalSequencerTestLanguage.g:3277:20: (lv_val2_4_0= 'kw2' )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3277:20: (lv_val2_4_0= 'kw2' )
            	    // PsiInternalSequencerTestLanguage.g:3278:10: lv_val2_4_0= 'kw2'
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
            	    // PsiInternalSequencerTestLanguage.g:3298:4: ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3298:4: ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3299:5: {...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3299:118: ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3300:6: ({...}? => ( (lv_val3_5_0= 'kw3' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // PsiInternalSequencerTestLanguage.g:3303:9: ({...}? => ( (lv_val3_5_0= 'kw3' ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3303:10: {...}? => ( (lv_val3_5_0= 'kw3' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "true");
            	    }
            	    // PsiInternalSequencerTestLanguage.g:3303:19: ( (lv_val3_5_0= 'kw3' ) )
            	    // PsiInternalSequencerTestLanguage.g:3303:20: (lv_val3_5_0= 'kw3' )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3303:20: (lv_val3_5_0= 'kw3' )
            	    // PsiInternalSequencerTestLanguage.g:3304:10: lv_val3_5_0= 'kw3'
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
    // PsiInternalSequencerTestLanguage.g:3335:1: entryRuleComplex1 returns [Boolean current=false] : iv_ruleComplex1= ruleComplex1 EOF ;
    public final Boolean entryRuleComplex1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleComplex1 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3335:50: (iv_ruleComplex1= ruleComplex1 EOF )
            // PsiInternalSequencerTestLanguage.g:3336:2: iv_ruleComplex1= ruleComplex1 EOF
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
    // PsiInternalSequencerTestLanguage.g:3342:1: ruleComplex1 returns [Boolean current=false] : (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* ) ;
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
            // PsiInternalSequencerTestLanguage.g:3343:1: ( (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* ) )
            // PsiInternalSequencerTestLanguage.g:3344:2: (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* )
            {
            // PsiInternalSequencerTestLanguage.g:3344:2: (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* )
            // PsiInternalSequencerTestLanguage.g:3345:3: otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )*
            {

            			markLeaf(elementTypeProvider.getComplex1_NumberSignDigitTwoDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_27); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3352:3: ()
            // PsiInternalSequencerTestLanguage.g:3353:4: 
            {

            				precedeComposite(elementTypeProvider.getComplex1_Complex1Action_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }

            // PsiInternalSequencerTestLanguage.g:3359:3: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==16) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:3360:4: otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getComplex1_Kw1Keyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalSequencerTestLanguage.g:3367:4: ( (lv_val1_3_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:3368:5: (lv_val1_3_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:3368:5: (lv_val1_3_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:3369:6: lv_val1_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getComplex1_Val1IDTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_28); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val1_3_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalSequencerTestLanguage.g:3385:3: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==17) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:3386:4: otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getComplex1_Kw2Keyword_3_0ElementType());
                    			
                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalSequencerTestLanguage.g:3393:4: ( (lv_val2_5_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:3394:5: (lv_val2_5_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:3394:5: (lv_val2_5_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:3395:6: lv_val2_5_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getComplex1_Val2IDTerminalRuleCall_3_1_0ElementType());
                    					
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val2_5_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalSequencerTestLanguage.g:3411:3: ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )*
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
            	    // PsiInternalSequencerTestLanguage.g:3412:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3412:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3413:5: otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getComplex1_Kw3Keyword_4_0_0ElementType());
            	    				
            	    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_6);
            	    				
            	    // PsiInternalSequencerTestLanguage.g:3420:5: ( (lv_val3_7_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3421:6: (lv_val3_7_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3421:6: (lv_val3_7_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3422:7: lv_val3_7_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getComplex1_Val3IDTerminalRuleCall_4_0_1_0ElementType());
            	    						
            	    lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						

            	    							doneLeaf(lv_val3_7_0);
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSequencerTestLanguage.g:3439:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3439:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3440:5: otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getComplex1_Kw4Keyword_4_1_0ElementType());
            	    				
            	    otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_8);
            	    				
            	    // PsiInternalSequencerTestLanguage.g:3447:5: ( (lv_val4_9_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3448:6: (lv_val4_9_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3448:6: (lv_val4_9_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3449:7: lv_val4_9_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getComplex1_Val4IDTerminalRuleCall_4_1_1_0ElementType());
            	    						
            	    lv_val4_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						

            	    							doneLeaf(lv_val4_9_0);
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalSequencerTestLanguage.g:3466:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3466:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3467:5: otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getComplex1_Kw5Keyword_4_2_0ElementType());
            	    				
            	    otherlv_10=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_10);
            	    				
            	    // PsiInternalSequencerTestLanguage.g:3474:5: ( (lv_val5_11_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3475:6: (lv_val5_11_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3475:6: (lv_val5_11_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3476:7: lv_val5_11_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getComplex1_Val5IDTerminalRuleCall_4_2_1_0ElementType());
            	    						
            	    lv_val5_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						

            	    							doneLeaf(lv_val5_11_0);
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // PsiInternalSequencerTestLanguage.g:3493:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3493:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) )
            	    // PsiInternalSequencerTestLanguage.g:3494:5: otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getComplex1_Kw6Keyword_4_3_0ElementType());
            	    				
            	    otherlv_12=(Token)match(input,49,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_12);
            	    				
            	    // PsiInternalSequencerTestLanguage.g:3501:5: ( (lv_val6_13_0= RULE_ID ) )
            	    // PsiInternalSequencerTestLanguage.g:3502:6: (lv_val6_13_0= RULE_ID )
            	    {
            	    // PsiInternalSequencerTestLanguage.g:3502:6: (lv_val6_13_0= RULE_ID )
            	    // PsiInternalSequencerTestLanguage.g:3503:7: lv_val6_13_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getComplex1_Val6IDTerminalRuleCall_4_3_1_0ElementType());
            	    						
            	    lv_val6_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						

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
    // PsiInternalSequencerTestLanguage.g:3524:1: entryRuleOptionalDouble returns [Boolean current=false] : iv_ruleOptionalDouble= ruleOptionalDouble EOF ;
    public final Boolean entryRuleOptionalDouble() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOptionalDouble = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3524:56: (iv_ruleOptionalDouble= ruleOptionalDouble EOF )
            // PsiInternalSequencerTestLanguage.g:3525:2: iv_ruleOptionalDouble= ruleOptionalDouble EOF
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
    // PsiInternalSequencerTestLanguage.g:3531:1: ruleOptionalDouble returns [Boolean current=false] : (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? ) ;
    public final Boolean ruleOptionalDouble() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_double0_1_0 = null;

        Boolean lv_double1_2_0 = null;

        Boolean lv_double2_3_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3532:1: ( (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? ) )
            // PsiInternalSequencerTestLanguage.g:3533:2: (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? )
            {
            // PsiInternalSequencerTestLanguage.g:3533:2: (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? )
            // PsiInternalSequencerTestLanguage.g:3534:3: otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )?
            {

            			markLeaf(elementTypeProvider.getOptionalDouble_NumberSignDigitTwoDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_21); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3541:3: ( (lv_double0_1_0= ruleDOUBLE ) )
            // PsiInternalSequencerTestLanguage.g:3542:4: (lv_double0_1_0= ruleDOUBLE )
            {
            // PsiInternalSequencerTestLanguage.g:3542:4: (lv_double0_1_0= ruleDOUBLE )
            // PsiInternalSequencerTestLanguage.g:3543:5: lv_double0_1_0= ruleDOUBLE
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

            // PsiInternalSequencerTestLanguage.g:3556:3: ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_INT) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:3557:4: ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:3557:4: ( (lv_double1_2_0= ruleDOUBLE ) )
                    // PsiInternalSequencerTestLanguage.g:3558:5: (lv_double1_2_0= ruleDOUBLE )
                    {
                    // PsiInternalSequencerTestLanguage.g:3558:5: (lv_double1_2_0= ruleDOUBLE )
                    // PsiInternalSequencerTestLanguage.g:3559:6: lv_double1_2_0= ruleDOUBLE
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

                    // PsiInternalSequencerTestLanguage.g:3572:4: ( (lv_double2_3_0= ruleDOUBLE ) )
                    // PsiInternalSequencerTestLanguage.g:3573:5: (lv_double2_3_0= ruleDOUBLE )
                    {
                    // PsiInternalSequencerTestLanguage.g:3573:5: (lv_double2_3_0= ruleDOUBLE )
                    // PsiInternalSequencerTestLanguage.g:3574:6: lv_double2_3_0= ruleDOUBLE
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
    // PsiInternalSequencerTestLanguage.g:3592:1: entryRuleDOUBLE returns [Boolean current=false] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final Boolean entryRuleDOUBLE() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDOUBLE = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3592:48: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // PsiInternalSequencerTestLanguage.g:3593:2: iv_ruleDOUBLE= ruleDOUBLE EOF
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
    // PsiInternalSequencerTestLanguage.g:3599:1: ruleDOUBLE returns [Boolean current=false] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final Boolean ruleDOUBLE() throws RecognitionException {
        Boolean current = false;

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3600:1: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // PsiInternalSequencerTestLanguage.g:3601:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // PsiInternalSequencerTestLanguage.g:3601:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // PsiInternalSequencerTestLanguage.g:3602:3: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {

            			markLeaf(elementTypeProvider.getDOUBLE_INTTerminalRuleCall_0ElementType());
            		
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_30); 

            			doneLeaf(this_INT_0);
            		
            // PsiInternalSequencerTestLanguage.g:3609:3: (kw= '.' this_INT_2= RULE_INT )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==51) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:3610:4: kw= '.' this_INT_2= RULE_INT
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
    // PsiInternalSequencerTestLanguage.g:3629:1: entryRuleNullValueGenerated returns [Boolean current=false] : iv_ruleNullValueGenerated= ruleNullValueGenerated EOF ;
    public final Boolean entryRuleNullValueGenerated() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNullValueGenerated = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3629:60: (iv_ruleNullValueGenerated= ruleNullValueGenerated EOF )
            // PsiInternalSequencerTestLanguage.g:3630:2: iv_ruleNullValueGenerated= ruleNullValueGenerated EOF
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
    // PsiInternalSequencerTestLanguage.g:3636:1: ruleNullValueGenerated returns [Boolean current=false] : (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) ) ;
    public final Boolean ruleNullValueGenerated() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_value_1_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3637:1: ( (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3638:2: (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3638:2: (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) )
            // PsiInternalSequencerTestLanguage.g:3639:3: otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) )
            {

            			markLeaf(elementTypeProvider.getNullValueGenerated_NumberSignDigitTwoDigitNineKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,52,FollowSets000.FOLLOW_31); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3646:3: ( (lv_value_1_0= ruleNULL_STRING ) )
            // PsiInternalSequencerTestLanguage.g:3647:4: (lv_value_1_0= ruleNULL_STRING )
            {
            // PsiInternalSequencerTestLanguage.g:3647:4: (lv_value_1_0= ruleNULL_STRING )
            // PsiInternalSequencerTestLanguage.g:3648:5: lv_value_1_0= ruleNULL_STRING
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
    // PsiInternalSequencerTestLanguage.g:3665:1: entryRuleNullValueInterpreted returns [Boolean current=false] : iv_ruleNullValueInterpreted= ruleNullValueInterpreted EOF ;
    public final Boolean entryRuleNullValueInterpreted() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNullValueInterpreted = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3665:62: (iv_ruleNullValueInterpreted= ruleNullValueInterpreted EOF )
            // PsiInternalSequencerTestLanguage.g:3666:2: iv_ruleNullValueInterpreted= ruleNullValueInterpreted EOF
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
    // PsiInternalSequencerTestLanguage.g:3672:1: ruleNullValueInterpreted returns [Boolean current=false] : (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? ) ;
    public final Boolean ruleNullValueInterpreted() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_foo_2_0=null;
        Boolean lv_value_1_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3673:1: ( (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? ) )
            // PsiInternalSequencerTestLanguage.g:3674:2: (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            {
            // PsiInternalSequencerTestLanguage.g:3674:2: (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            // PsiInternalSequencerTestLanguage.g:3675:3: otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )?
            {

            			markLeaf(elementTypeProvider.getNullValueInterpreted_NumberSignDigitThreeDigitZeroKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,53,FollowSets000.FOLLOW_31); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3682:3: ( (lv_value_1_0= ruleNULL_STRING ) )
            // PsiInternalSequencerTestLanguage.g:3683:4: (lv_value_1_0= ruleNULL_STRING )
            {
            // PsiInternalSequencerTestLanguage.g:3683:4: (lv_value_1_0= ruleNULL_STRING )
            // PsiInternalSequencerTestLanguage.g:3684:5: lv_value_1_0= ruleNULL_STRING
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

            // PsiInternalSequencerTestLanguage.g:3697:3: ( (lv_foo_2_0= RULE_ID ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:3698:4: (lv_foo_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:3698:4: (lv_foo_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:3699:5: lv_foo_2_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getNullValueInterpreted_FooIDTerminalRuleCall_2_0ElementType());
                    				
                    lv_foo_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

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
    // PsiInternalSequencerTestLanguage.g:3718:1: entryRuleNULL_STRING returns [Boolean current=false] : iv_ruleNULL_STRING= ruleNULL_STRING EOF ;
    public final Boolean entryRuleNULL_STRING() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNULL_STRING = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3718:53: (iv_ruleNULL_STRING= ruleNULL_STRING EOF )
            // PsiInternalSequencerTestLanguage.g:3719:2: iv_ruleNULL_STRING= ruleNULL_STRING EOF
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
    // PsiInternalSequencerTestLanguage.g:3725:1: ruleNULL_STRING returns [Boolean current=false] : this_STRING_0= RULE_STRING ;
    public final Boolean ruleNULL_STRING() throws RecognitionException {
        Boolean current = false;

        Token this_STRING_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3726:1: (this_STRING_0= RULE_STRING )
            // PsiInternalSequencerTestLanguage.g:3727:2: this_STRING_0= RULE_STRING
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
    // PsiInternalSequencerTestLanguage.g:3737:1: entryRuleNullCrossRefGenerated returns [Boolean current=false] : iv_ruleNullCrossRefGenerated= ruleNullCrossRefGenerated EOF ;
    public final Boolean entryRuleNullCrossRefGenerated() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNullCrossRefGenerated = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3737:63: (iv_ruleNullCrossRefGenerated= ruleNullCrossRefGenerated EOF )
            // PsiInternalSequencerTestLanguage.g:3738:2: iv_ruleNullCrossRefGenerated= ruleNullCrossRefGenerated EOF
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
    // PsiInternalSequencerTestLanguage.g:3744:1: ruleNullCrossRefGenerated returns [Boolean current=false] : (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) ) ;
    public final Boolean ruleNullCrossRefGenerated() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3745:1: ( (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3746:2: (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3746:2: (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:3747:3: otherlv_0= '#31' ( (otherlv_1= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getNullCrossRefGenerated_NumberSignDigitThreeDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3754:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:3755:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:3755:4: (otherlv_1= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:3756:5: otherlv_1= RULE_ID
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
    // PsiInternalSequencerTestLanguage.g:3775:1: entryRuleNullCrossRefInterpreted returns [Boolean current=false] : iv_ruleNullCrossRefInterpreted= ruleNullCrossRefInterpreted EOF ;
    public final Boolean entryRuleNullCrossRefInterpreted() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNullCrossRefInterpreted = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3775:65: (iv_ruleNullCrossRefInterpreted= ruleNullCrossRefInterpreted EOF )
            // PsiInternalSequencerTestLanguage.g:3776:2: iv_ruleNullCrossRefInterpreted= ruleNullCrossRefInterpreted EOF
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
    // PsiInternalSequencerTestLanguage.g:3782:1: ruleNullCrossRefInterpreted returns [Boolean current=false] : (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? ) ;
    public final Boolean ruleNullCrossRefInterpreted() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_foo_2_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3783:1: ( (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? ) )
            // PsiInternalSequencerTestLanguage.g:3784:2: (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            {
            // PsiInternalSequencerTestLanguage.g:3784:2: (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            // PsiInternalSequencerTestLanguage.g:3785:3: otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )?
            {

            			markLeaf(elementTypeProvider.getNullCrossRefInterpreted_NumberSignDigitThreeDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3792:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:3793:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:3793:4: (otherlv_1= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:3794:5: otherlv_1= RULE_ID
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

            // PsiInternalSequencerTestLanguage.g:3809:3: ( (lv_foo_2_0= RULE_ID ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:3810:4: (lv_foo_2_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:3810:4: (lv_foo_2_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:3811:5: lv_foo_2_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getNullCrossRefInterpreted_FooIDTerminalRuleCall_2_0ElementType());
                    				
                    lv_foo_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

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
    // PsiInternalSequencerTestLanguage.g:3830:1: entryRuleFragmentCaller returns [Boolean current=false] : iv_ruleFragmentCaller= ruleFragmentCaller EOF ;
    public final Boolean entryRuleFragmentCaller() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFragmentCaller = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3830:56: (iv_ruleFragmentCaller= ruleFragmentCaller EOF )
            // PsiInternalSequencerTestLanguage.g:3831:2: iv_ruleFragmentCaller= ruleFragmentCaller EOF
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
    // PsiInternalSequencerTestLanguage.g:3837:1: ruleFragmentCaller returns [Boolean current=false] : (otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) ) ;
    public final Boolean ruleFragmentCaller() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val_3_0=null;
        Boolean this_Fragment1_2 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3838:1: ( (otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3839:2: (otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3839:2: (otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:3840:3: otherlv_0= '#33' ( (lv_val1_1_0= RULE_ID ) ) this_Fragment1_2= ruleFragment1[$current] ( (lv_val_3_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getFragmentCaller_NumberSignDigitThreeDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,56,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3847:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:3848:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:3848:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:3849:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFragmentCaller_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_1_0);
            				

            }


            }


            			if (!current) {
            				associateWithSemanticElement();
            				current = true;
            			}
            			markComposite(elementTypeProvider.getFragmentCaller_Fragment1ParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_Fragment1_2=ruleFragment1(current);

            state._fsp--;


            			current = this_Fragment1_2;
            			doneComposite();
            		
            // PsiInternalSequencerTestLanguage.g:3876:3: ( (lv_val_3_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:3877:4: (lv_val_3_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:3877:4: (lv_val_3_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:3878:5: lv_val_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFragmentCaller_ValIDTerminalRuleCall_3_0ElementType());
            				
            lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // PsiInternalSequencerTestLanguage.g:3898:1: ruleFragment1[Boolean in_current] returns [Boolean current=in_current] : ( (lv_fragVal_0_0= RULE_ID ) ) ;
    public final Boolean ruleFragment1(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token lv_fragVal_0_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:3899:1: ( ( (lv_fragVal_0_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:3900:2: ( (lv_fragVal_0_0= RULE_ID ) )
            {
            // PsiInternalSequencerTestLanguage.g:3900:2: ( (lv_fragVal_0_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:3901:3: (lv_fragVal_0_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:3901:3: (lv_fragVal_0_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:3902:4: lv_fragVal_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getFragment1_FragValIDTerminalRuleCall_0ElementType());
            			
            lv_fragVal_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

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
    // PsiInternalSequencerTestLanguage.g:3920:1: entryRuleParameterCaller returns [Boolean current=false] : iv_ruleParameterCaller= ruleParameterCaller EOF ;
    public final Boolean entryRuleParameterCaller() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParameterCaller = null;


        try {
            // PsiInternalSequencerTestLanguage.g:3920:57: (iv_ruleParameterCaller= ruleParameterCaller EOF )
            // PsiInternalSequencerTestLanguage.g:3921:2: iv_ruleParameterCaller= ruleParameterCaller EOF
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
    // PsiInternalSequencerTestLanguage.g:3927:1: ruleParameterCaller returns [Boolean current=false] : (otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) ) ) ;
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
            // PsiInternalSequencerTestLanguage.g:3928:1: ( (otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3929:2: (otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:3929:2: (otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:3930:3: otherlv_0= '#34' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) )
            {

            			markLeaf(elementTypeProvider.getParameterCaller_NumberSignDigitThreeDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_32); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:3937:3: ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) ) | (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) ) | (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) ) )
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
                    // PsiInternalSequencerTestLanguage.g:3938:4: (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:3938:4: (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) ) )
                    // PsiInternalSequencerTestLanguage.g:3939:5: otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Parameterized ) )
                    {

                    					markLeaf(elementTypeProvider.getParameterCaller_Kw1Keyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_33); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalSequencerTestLanguage.g:3946:5: ( (lv_p_2_0= norm3_Parameterized ) )
                    // PsiInternalSequencerTestLanguage.g:3947:6: (lv_p_2_0= norm3_Parameterized )
                    {
                    // PsiInternalSequencerTestLanguage.g:3947:6: (lv_p_2_0= norm3_Parameterized )
                    // PsiInternalSequencerTestLanguage.g:3948:7: lv_p_2_0= norm3_Parameterized
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
                    // PsiInternalSequencerTestLanguage.g:3963:4: (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:3963:4: (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) ) )
                    // PsiInternalSequencerTestLanguage.g:3964:5: otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Parameterized ) )
                    {

                    					markLeaf(elementTypeProvider.getParameterCaller_Kw2Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_33); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalSequencerTestLanguage.g:3971:5: ( (lv_p_4_0= norm1_Parameterized ) )
                    // PsiInternalSequencerTestLanguage.g:3972:6: (lv_p_4_0= norm1_Parameterized )
                    {
                    // PsiInternalSequencerTestLanguage.g:3972:6: (lv_p_4_0= norm1_Parameterized )
                    // PsiInternalSequencerTestLanguage.g:3973:7: lv_p_4_0= norm1_Parameterized
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
                    // PsiInternalSequencerTestLanguage.g:3988:4: (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:3988:4: (otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) ) )
                    // PsiInternalSequencerTestLanguage.g:3989:5: otherlv_5= 'kw3' ( (lv_p_6_0= norm2_Parameterized ) )
                    {

                    					markLeaf(elementTypeProvider.getParameterCaller_Kw3Keyword_1_2_0ElementType());
                    				
                    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_34); 

                    					doneLeaf(otherlv_5);
                    				
                    // PsiInternalSequencerTestLanguage.g:3996:5: ( (lv_p_6_0= norm2_Parameterized ) )
                    // PsiInternalSequencerTestLanguage.g:3997:6: (lv_p_6_0= norm2_Parameterized )
                    {
                    // PsiInternalSequencerTestLanguage.g:3997:6: (lv_p_6_0= norm2_Parameterized )
                    // PsiInternalSequencerTestLanguage.g:3998:7: lv_p_6_0= norm2_Parameterized
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
                    // PsiInternalSequencerTestLanguage.g:4013:4: (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:4013:4: (otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) ) )
                    // PsiInternalSequencerTestLanguage.g:4014:5: otherlv_7= 'kw4' ( (lv_p_8_0= ruleParameterized ) )
                    {

                    					markLeaf(elementTypeProvider.getParameterCaller_Kw4Keyword_1_3_0ElementType());
                    				
                    otherlv_7=(Token)match(input,22,FollowSets000.FOLLOW_34); 

                    					doneLeaf(otherlv_7);
                    				
                    // PsiInternalSequencerTestLanguage.g:4021:5: ( (lv_p_8_0= ruleParameterized ) )
                    // PsiInternalSequencerTestLanguage.g:4022:6: (lv_p_8_0= ruleParameterized )
                    {
                    // PsiInternalSequencerTestLanguage.g:4022:6: (lv_p_8_0= ruleParameterized )
                    // PsiInternalSequencerTestLanguage.g:4023:7: lv_p_8_0= ruleParameterized
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
    // PsiInternalSequencerTestLanguage.g:4042:1: entryRuleParameterized returns [Boolean current=false] : iv_ruleParameterized= ruleParameterized EOF ;
    public final Boolean entryRuleParameterized() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParameterized = null;


        try {
            // PsiInternalSequencerTestLanguage.g:4042:55: (iv_ruleParameterized= ruleParameterized EOF )
            // PsiInternalSequencerTestLanguage.g:4043:2: iv_ruleParameterized= ruleParameterized EOF
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
    // PsiInternalSequencerTestLanguage.g:4049:1: ruleParameterized returns [Boolean current=false] : (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleParameterized() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_v2_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4050:1: ( (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:4051:2: (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:4051:2: (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:4052:3: otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getParameterized_Kwp2Keyword_1_0ElementType());
            		
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:4059:3: ( (lv_v2_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:4060:4: (lv_v2_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:4060:4: (lv_v2_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:4061:5: lv_v2_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParameterized_V2IDTerminalRuleCall_1_1_0ElementType());
            				
            lv_v2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // PsiInternalSequencerTestLanguage.g:4081:1: norm1_Parameterized returns [Boolean current=false] : (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) ) ;
    public final Boolean norm1_Parameterized() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_v1_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4082:1: ( (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:4083:2: (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:4083:2: (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:4084:3: otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getParameterized_Kwp1Keyword_0_0ElementType());
            		
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:4091:3: ( (lv_v1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:4092:4: (lv_v1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:4092:4: (lv_v1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:4093:5: lv_v1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParameterized_V1IDTerminalRuleCall_0_1_0ElementType());
            				
            lv_v1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // PsiInternalSequencerTestLanguage.g:4113:1: norm2_Parameterized returns [Boolean current=false] : (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )? ) ;
    public final Boolean norm2_Parameterized() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_v2_1_0=null;
        Token otherlv_2=null;
        Token lv_v3_3_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4114:1: ( (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )? ) )
            // PsiInternalSequencerTestLanguage.g:4115:2: (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )? )
            {
            // PsiInternalSequencerTestLanguage.g:4115:2: (otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )? )
            // PsiInternalSequencerTestLanguage.g:4116:3: otherlv_0= 'kwp2' ( (lv_v2_1_0= RULE_ID ) ) (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )?
            {

            			markLeaf(elementTypeProvider.getParameterized_Kwp2Keyword_1_0ElementType());
            		
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:4123:3: ( (lv_v2_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:4124:4: (lv_v2_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:4124:4: (lv_v2_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:4125:5: lv_v2_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParameterized_V2IDTerminalRuleCall_1_1_0ElementType());
            				
            lv_v2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_35); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_v2_1_0);
            				

            }


            }

            // PsiInternalSequencerTestLanguage.g:4140:3: (otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==60) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:4141:4: otherlv_2= 'kwp3' ( (lv_v3_3_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getParameterized_Kwp3Keyword_1_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,60,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalSequencerTestLanguage.g:4148:4: ( (lv_v3_3_0= RULE_ID ) )
                    // PsiInternalSequencerTestLanguage.g:4149:5: (lv_v3_3_0= RULE_ID )
                    {
                    // PsiInternalSequencerTestLanguage.g:4149:5: (lv_v3_3_0= RULE_ID )
                    // PsiInternalSequencerTestLanguage.g:4150:6: lv_v3_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getParameterized_V3IDTerminalRuleCall_1_2_1_0ElementType());
                    					
                    lv_v3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
    // PsiInternalSequencerTestLanguage.g:4171:1: norm3_Parameterized returns [Boolean current=false] : (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) ) ;
    public final Boolean norm3_Parameterized() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_v1_1_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4172:1: ( (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) ) )
            // PsiInternalSequencerTestLanguage.g:4173:2: (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:4173:2: (otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:4174:3: otherlv_0= 'kwp1' ( (lv_v1_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getParameterized_Kwp1Keyword_0_0ElementType());
            		
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:4181:3: ( (lv_v1_1_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:4182:4: (lv_v1_1_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:4182:4: (lv_v1_1_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:4183:5: lv_v1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParameterized_V1IDTerminalRuleCall_0_1_0ElementType());
            				
            lv_v1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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


    // $ANTLR start "entryRuleParameterDelegation"
    // PsiInternalSequencerTestLanguage.g:4202:1: entryRuleParameterDelegation returns [Boolean current=false] : iv_ruleParameterDelegation= ruleParameterDelegation EOF ;
    public final Boolean entryRuleParameterDelegation() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParameterDelegation = null;


        try {
            // PsiInternalSequencerTestLanguage.g:4202:61: (iv_ruleParameterDelegation= ruleParameterDelegation EOF )
            // PsiInternalSequencerTestLanguage.g:4203:2: iv_ruleParameterDelegation= ruleParameterDelegation EOF
            {
             markComposite(elementTypeProvider.getParameterDelegationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameterDelegation=ruleParameterDelegation();

            state._fsp--;

             current =iv_ruleParameterDelegation; 
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
    // $ANTLR end "entryRuleParameterDelegation"


    // $ANTLR start "ruleParameterDelegation"
    // PsiInternalSequencerTestLanguage.g:4209:1: ruleParameterDelegation returns [Boolean current=false] : (otherlv_0= '#35' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Delegation ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Delegation ) ) ) ) ) ;
    public final Boolean ruleParameterDelegation() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Boolean lv_p_2_0 = null;

        Boolean lv_p_4_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:4210:1: ( (otherlv_0= '#35' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Delegation ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Delegation ) ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:4211:2: (otherlv_0= '#35' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Delegation ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Delegation ) ) ) ) )
            {
            // PsiInternalSequencerTestLanguage.g:4211:2: (otherlv_0= '#35' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Delegation ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Delegation ) ) ) ) )
            // PsiInternalSequencerTestLanguage.g:4212:3: otherlv_0= '#35' ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Delegation ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Delegation ) ) ) )
            {

            			markLeaf(elementTypeProvider.getParameterDelegation_NumberSignDigitThreeDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,61,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSequencerTestLanguage.g:4219:3: ( (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Delegation ) ) ) | (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Delegation ) ) ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==16) ) {
                alt47=1;
            }
            else if ( (LA47_0==17) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:4220:4: (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Delegation ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:4220:4: (otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Delegation ) ) )
                    // PsiInternalSequencerTestLanguage.g:4221:5: otherlv_1= 'kw1' ( (lv_p_2_0= norm3_Delegation ) )
                    {

                    					markLeaf(elementTypeProvider.getParameterDelegation_Kw1Keyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_36); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalSequencerTestLanguage.g:4228:5: ( (lv_p_2_0= norm3_Delegation ) )
                    // PsiInternalSequencerTestLanguage.g:4229:6: (lv_p_2_0= norm3_Delegation )
                    {
                    // PsiInternalSequencerTestLanguage.g:4229:6: (lv_p_2_0= norm3_Delegation )
                    // PsiInternalSequencerTestLanguage.g:4230:7: lv_p_2_0= norm3_Delegation
                    {

                    							markComposite(elementTypeProvider.getParameterDelegation_PDelegationParserRuleCall_1_0_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_p_2_0=norm3_Delegation();

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
                    // PsiInternalSequencerTestLanguage.g:4245:4: (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Delegation ) ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:4245:4: (otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Delegation ) ) )
                    // PsiInternalSequencerTestLanguage.g:4246:5: otherlv_3= 'kw2' ( (lv_p_4_0= norm1_Delegation ) )
                    {

                    					markLeaf(elementTypeProvider.getParameterDelegation_Kw2Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_36); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalSequencerTestLanguage.g:4253:5: ( (lv_p_4_0= norm1_Delegation ) )
                    // PsiInternalSequencerTestLanguage.g:4254:6: (lv_p_4_0= norm1_Delegation )
                    {
                    // PsiInternalSequencerTestLanguage.g:4254:6: (lv_p_4_0= norm1_Delegation )
                    // PsiInternalSequencerTestLanguage.g:4255:7: lv_p_4_0= norm1_Delegation
                    {

                    							markComposite(elementTypeProvider.getParameterDelegation_PDelegationParserRuleCall_1_1_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_p_4_0=norm1_Delegation();

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
    // $ANTLR end "ruleParameterDelegation"


    // $ANTLR start "entryRuleDelegation"
    // PsiInternalSequencerTestLanguage.g:4274:1: entryRuleDelegation returns [Boolean current=false] : iv_ruleDelegation= ruleDelegation EOF ;
    public final Boolean entryRuleDelegation() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDelegation = null;


        try {
            // PsiInternalSequencerTestLanguage.g:4274:52: (iv_ruleDelegation= ruleDelegation EOF )
            // PsiInternalSequencerTestLanguage.g:4275:2: iv_ruleDelegation= ruleDelegation EOF
            {
             markComposite(elementTypeProvider.getDelegationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDelegation=ruleDelegation();

            state._fsp--;

             current =iv_ruleDelegation; 
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
    // $ANTLR end "entryRuleDelegation"


    // $ANTLR start "ruleDelegation"
    // PsiInternalSequencerTestLanguage.g:4281:1: ruleDelegation returns [Boolean current=false] : ( (lv_np_0_0= RULE_INT ) ) ;
    public final Boolean ruleDelegation() throws RecognitionException {
        Boolean current = false;

        Token lv_np_0_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4282:1: ( ( (lv_np_0_0= RULE_INT ) ) )
            // PsiInternalSequencerTestLanguage.g:4283:2: ( (lv_np_0_0= RULE_INT ) )
            {
            // PsiInternalSequencerTestLanguage.g:4283:2: ( (lv_np_0_0= RULE_INT ) )
            // PsiInternalSequencerTestLanguage.g:4284:3: (lv_np_0_0= RULE_INT )
            {
            // PsiInternalSequencerTestLanguage.g:4284:3: (lv_np_0_0= RULE_INT )
            // PsiInternalSequencerTestLanguage.g:4285:4: lv_np_0_0= RULE_INT
            {

            				markLeaf(elementTypeProvider.getDelegation_NpINTTerminalRuleCall_0_0_1_0_0ElementType());
            			
            lv_np_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				doneLeaf(lv_np_0_0);
            			

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
    // $ANTLR end "ruleDelegation"


    // $ANTLR start "norm1_Delegation"
    // PsiInternalSequencerTestLanguage.g:4304:1: norm1_Delegation returns [Boolean current=false] : (otherlv_0= 'kwd' this_Delegation_1= ruleDelegation ( () ( (lv_rc2_3_0= ruleDelegation ) ) )? ) ;
    public final Boolean norm1_Delegation() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_Delegation_1 = null;

        Boolean lv_rc2_3_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:4305:1: ( (otherlv_0= 'kwd' this_Delegation_1= ruleDelegation ( () ( (lv_rc2_3_0= ruleDelegation ) ) )? ) )
            // PsiInternalSequencerTestLanguage.g:4306:2: (otherlv_0= 'kwd' this_Delegation_1= ruleDelegation ( () ( (lv_rc2_3_0= ruleDelegation ) ) )? )
            {
            // PsiInternalSequencerTestLanguage.g:4306:2: (otherlv_0= 'kwd' this_Delegation_1= ruleDelegation ( () ( (lv_rc2_3_0= ruleDelegation ) ) )? )
            // PsiInternalSequencerTestLanguage.g:4307:3: otherlv_0= 'kwd' this_Delegation_1= ruleDelegation ( () ( (lv_rc2_3_0= ruleDelegation ) ) )?
            {

            			markLeaf(elementTypeProvider.getDelegation_KwdKeyword_1_0ElementType());
            		
            otherlv_0=(Token)match(input,62,FollowSets000.FOLLOW_21); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getDelegation_DelegationParserRuleCall_1_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_22);
            this_Delegation_1=ruleDelegation();

            state._fsp--;


            			current = this_Delegation_1;
            			doneComposite();
            		
            // PsiInternalSequencerTestLanguage.g:4322:3: ( () ( (lv_rc2_3_0= ruleDelegation ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_INT) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:4323:4: () ( (lv_rc2_3_0= ruleDelegation ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:4323:4: ()
                    // PsiInternalSequencerTestLanguage.g:4324:5: 
                    {

                    					precedeComposite(elementTypeProvider.getDelegation_DelegationALeftAction_1_2_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalSequencerTestLanguage.g:4330:4: ( (lv_rc2_3_0= ruleDelegation ) )
                    // PsiInternalSequencerTestLanguage.g:4331:5: (lv_rc2_3_0= ruleDelegation )
                    {
                    // PsiInternalSequencerTestLanguage.g:4331:5: (lv_rc2_3_0= ruleDelegation )
                    // PsiInternalSequencerTestLanguage.g:4332:6: lv_rc2_3_0= ruleDelegation
                    {

                    						markComposite(elementTypeProvider.getDelegation_Rc2DelegationParserRuleCall_1_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_rc2_3_0=ruleDelegation();

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
    // $ANTLR end "norm1_Delegation"


    // $ANTLR start "norm2_Delegation"
    // PsiInternalSequencerTestLanguage.g:4351:1: norm2_Delegation returns [Boolean current=false] : ( (lv_p_0_0= RULE_ID ) ) ;
    public final Boolean norm2_Delegation() throws RecognitionException {
        Boolean current = false;

        Token lv_p_0_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4352:1: ( ( (lv_p_0_0= RULE_ID ) ) )
            // PsiInternalSequencerTestLanguage.g:4353:2: ( (lv_p_0_0= RULE_ID ) )
            {
            // PsiInternalSequencerTestLanguage.g:4353:2: ( (lv_p_0_0= RULE_ID ) )
            // PsiInternalSequencerTestLanguage.g:4354:3: (lv_p_0_0= RULE_ID )
            {
            // PsiInternalSequencerTestLanguage.g:4354:3: (lv_p_0_0= RULE_ID )
            // PsiInternalSequencerTestLanguage.g:4355:4: lv_p_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getDelegation_PIDTerminalRuleCall_0_0_0_0_0ElementType());
            			
            lv_p_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				doneLeaf(lv_p_0_0);
            			

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
    // $ANTLR end "norm2_Delegation"


    // $ANTLR start "norm3_Delegation"
    // PsiInternalSequencerTestLanguage.g:4374:1: norm3_Delegation returns [Boolean current=false] : (otherlv_0= 'kwd' this_Delegation_1= norm2_Delegation ( () ( (lv_rc2_3_0= norm2_Delegation ) ) )? ) ;
    public final Boolean norm3_Delegation() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_Delegation_1 = null;

        Boolean lv_rc2_3_0 = null;


        try {
            // PsiInternalSequencerTestLanguage.g:4375:1: ( (otherlv_0= 'kwd' this_Delegation_1= norm2_Delegation ( () ( (lv_rc2_3_0= norm2_Delegation ) ) )? ) )
            // PsiInternalSequencerTestLanguage.g:4376:2: (otherlv_0= 'kwd' this_Delegation_1= norm2_Delegation ( () ( (lv_rc2_3_0= norm2_Delegation ) ) )? )
            {
            // PsiInternalSequencerTestLanguage.g:4376:2: (otherlv_0= 'kwd' this_Delegation_1= norm2_Delegation ( () ( (lv_rc2_3_0= norm2_Delegation ) ) )? )
            // PsiInternalSequencerTestLanguage.g:4377:3: otherlv_0= 'kwd' this_Delegation_1= norm2_Delegation ( () ( (lv_rc2_3_0= norm2_Delegation ) ) )?
            {

            			markLeaf(elementTypeProvider.getDelegation_KwdKeyword_1_0ElementType());
            		
            otherlv_0=(Token)match(input,62,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getDelegation_DelegationParserRuleCall_1_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_9);
            this_Delegation_1=norm2_Delegation();

            state._fsp--;


            			current = this_Delegation_1;
            			doneComposite();
            		
            // PsiInternalSequencerTestLanguage.g:4392:3: ( () ( (lv_rc2_3_0= norm2_Delegation ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // PsiInternalSequencerTestLanguage.g:4393:4: () ( (lv_rc2_3_0= norm2_Delegation ) )
                    {
                    // PsiInternalSequencerTestLanguage.g:4393:4: ()
                    // PsiInternalSequencerTestLanguage.g:4394:5: 
                    {

                    					precedeComposite(elementTypeProvider.getDelegation_DelegationALeftAction_1_2_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalSequencerTestLanguage.g:4400:4: ( (lv_rc2_3_0= norm2_Delegation ) )
                    // PsiInternalSequencerTestLanguage.g:4401:5: (lv_rc2_3_0= norm2_Delegation )
                    {
                    // PsiInternalSequencerTestLanguage.g:4401:5: (lv_rc2_3_0= norm2_Delegation )
                    // PsiInternalSequencerTestLanguage.g:4402:6: lv_rc2_3_0= norm2_Delegation
                    {

                    						markComposite(elementTypeProvider.getDelegation_Rc2DelegationParserRuleCall_1_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_rc2_3_0=norm2_Delegation();

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
    // $ANTLR end "norm3_Delegation"


    // $ANTLR start "ruleDefEnum1"
    // PsiInternalSequencerTestLanguage.g:4420:1: ruleDefEnum1 returns [Boolean current=false] : (enumLiteral_0= 'kw1' ) ;
    public final Boolean ruleDefEnum1() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4421:1: ( (enumLiteral_0= 'kw1' ) )
            // PsiInternalSequencerTestLanguage.g:4422:2: (enumLiteral_0= 'kw1' )
            {
            // PsiInternalSequencerTestLanguage.g:4422:2: (enumLiteral_0= 'kw1' )
            // PsiInternalSequencerTestLanguage.g:4423:3: enumLiteral_0= 'kw1'
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
    // PsiInternalSequencerTestLanguage.g:4434:1: ruleDefEnum2 returns [Boolean current=false] : (enumLiteral_0= 'kw2' ) ;
    public final Boolean ruleDefEnum2() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4435:1: ( (enumLiteral_0= 'kw2' ) )
            // PsiInternalSequencerTestLanguage.g:4436:2: (enumLiteral_0= 'kw2' )
            {
            // PsiInternalSequencerTestLanguage.g:4436:2: (enumLiteral_0= 'kw2' )
            // PsiInternalSequencerTestLanguage.g:4437:3: enumLiteral_0= 'kw2'
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
    // PsiInternalSequencerTestLanguage.g:4448:1: ruleDefEnum3 returns [Boolean current=false] : (enumLiteral_0= 'kw3' ) ;
    public final Boolean ruleDefEnum3() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalSequencerTestLanguage.g:4449:1: ( (enumLiteral_0= 'kw3' ) )
            // PsiInternalSequencerTestLanguage.g:4450:2: (enumLiteral_0= 'kw3' )
            {
            // PsiInternalSequencerTestLanguage.g:4450:2: (enumLiteral_0= 'kw3' )
            // PsiInternalSequencerTestLanguage.g:4451:3: enumLiteral_0= 'kw3'
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
            return "2455:3: ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )";
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
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x4000000000000000L});
    }


}