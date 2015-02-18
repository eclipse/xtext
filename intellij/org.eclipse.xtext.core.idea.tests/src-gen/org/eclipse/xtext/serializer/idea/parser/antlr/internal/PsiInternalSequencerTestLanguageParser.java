package org.eclipse.xtext.serializer.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.serializer.services.SequencerTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalSequencerTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ID1", "RULE_ID2", "RULE_ID3", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'kw1'", "'kw2'", "'#3'", "'kw3'", "'#4'", "'#5'", "'kw4'", "'kw5'", "'#6'", "','", "'#7'", "'#8'", "'#9'", "'kw'", "'#10'", "'#11'", "'#12'", "'#13'", "'#14'", "'#15'", "'#16'", "'#17'", "'#18'", "'#19'", "'#20'", "'#21'", "'#22'", "'Bye'", "'#23'", "'#24'", "'#25'", "'#26'", "'#27'", "'kw6'", "'#28'", "'.'", "'#29'", "'#30'", "'#31'", "'#32'"
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
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:51:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:59:1: ruleModel : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:59:10: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:60:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:60:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleList1 ) ) | ( (lv_x7_6_0= ruleList2 ) ) | ( (lv_x8_7_0= ruleAltList1 ) ) | ( (lv_x9_8_0= ruleAltList2 ) ) | ( (lv_x10_9_0= ruleSingleKeywords ) ) | ( (lv_x11_10_0= ruleSingleKeywordsOrID ) ) | ( (lv_x12_11_0= ruleSingleTerminals ) ) | ( (lv_x10_12_0= ruleMultiKeywords ) ) | ( (lv_x11_13_0= ruleMultiKeywordsOrID ) ) | ( (lv_x12_14_0= ruleMultiTerminals ) ) | ( (lv_x13_15_0= ruleSingleEnum ) ) | ( (lv_x14_16_0= ruleSingleCrossReference ) ) | ( (lv_x15_17_0= ruleSingleContainmentReference ) ) | ( (lv_x19_18_0= ruleDependentAlternative1 ) ) | ( (lv_x20_19_0= ruleDependentAlternative2 ) ) | ( (lv_x21_20_0= ruleOptional ) ) | ( (lv_x22_21_0= ruleFloat ) ) | ( (lv_x23_22_0= ruleUnorderedAlternative ) ) | ( (lv_x24_23_0= ruleUnorderedGroup ) ) | ( (lv_x25_24_0= ruleUnorderedGroupOptional ) ) | ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) ) | ( (lv_x27_26_0= ruleComplex1 ) ) | ( (lv_x28_27_0= ruleOptionalDouble ) ) | ( (lv_x29_28_0= ruleNullValueGenerated ) ) | ( (lv_x30_29_0= ruleNullValueInterpreted ) ) | ( (lv_x31_30_0= ruleNullCrossRefGenerated ) ) | ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) ) )
            int alt1=32;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:61:3: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:61:3: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:62:4: (lv_x1_0_0= ruleSimpleGroup )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:62:4: (lv_x1_0_0= ruleSimpleGroup )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:63:5: lv_x1_0_0= ruleSimpleGroup
                    {

                    					markComposite(elementTypeProvider.getModel_X1SimpleGroupParserRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleGroup_in_ruleModel96);
                    ruleSimpleGroup();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:73:3: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:73:3: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:74:4: (lv_x2_1_0= ruleSimpleAlternative )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:74:4: (lv_x2_1_0= ruleSimpleAlternative )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:75:5: lv_x2_1_0= ruleSimpleAlternative
                    {

                    					markComposite(elementTypeProvider.getModel_X2SimpleAlternativeParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleAlternative_in_ruleModel142);
                    ruleSimpleAlternative();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:85:3: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:85:3: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:86:4: (lv_x3_2_0= ruleSimpleMultiplicities )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:86:4: (lv_x3_2_0= ruleSimpleMultiplicities )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:87:5: lv_x3_2_0= ruleSimpleMultiplicities
                    {

                    					markComposite(elementTypeProvider.getModel_X3SimpleMultiplicitiesParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicities_in_ruleModel188);
                    ruleSimpleMultiplicities();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:97:3: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:97:3: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:98:4: (lv_x4_3_0= ruleGroupMultiplicities )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:98:4: (lv_x4_3_0= ruleGroupMultiplicities )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:99:5: lv_x4_3_0= ruleGroupMultiplicities
                    {

                    					markComposite(elementTypeProvider.getModel_X4GroupMultiplicitiesParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleGroupMultiplicities_in_ruleModel234);
                    ruleGroupMultiplicities();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:109:3: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:109:3: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:110:4: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:110:4: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:111:5: lv_x5_4_0= ruleAlternativeMultiplicities
                    {

                    					markComposite(elementTypeProvider.getModel_X5AlternativeMultiplicitiesParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleAlternativeMultiplicities_in_ruleModel280);
                    ruleAlternativeMultiplicities();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:121:3: ( (lv_x6_5_0= ruleList1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:121:3: ( (lv_x6_5_0= ruleList1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:122:4: (lv_x6_5_0= ruleList1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:122:4: (lv_x6_5_0= ruleList1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:123:5: lv_x6_5_0= ruleList1
                    {

                    					markComposite(elementTypeProvider.getModel_X6List1ParserRuleCall_5_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleList1_in_ruleModel326);
                    ruleList1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:133:3: ( (lv_x7_6_0= ruleList2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:133:3: ( (lv_x7_6_0= ruleList2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:134:4: (lv_x7_6_0= ruleList2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:134:4: (lv_x7_6_0= ruleList2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:135:5: lv_x7_6_0= ruleList2
                    {

                    					markComposite(elementTypeProvider.getModel_X7List2ParserRuleCall_6_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleList2_in_ruleModel372);
                    ruleList2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:145:3: ( (lv_x8_7_0= ruleAltList1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:145:3: ( (lv_x8_7_0= ruleAltList1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:146:4: (lv_x8_7_0= ruleAltList1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:146:4: (lv_x8_7_0= ruleAltList1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:147:5: lv_x8_7_0= ruleAltList1
                    {

                    					markComposite(elementTypeProvider.getModel_X8AltList1ParserRuleCall_7_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleAltList1_in_ruleModel418);
                    ruleAltList1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 9 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:157:3: ( (lv_x9_8_0= ruleAltList2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:157:3: ( (lv_x9_8_0= ruleAltList2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:158:4: (lv_x9_8_0= ruleAltList2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:158:4: (lv_x9_8_0= ruleAltList2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:159:5: lv_x9_8_0= ruleAltList2
                    {

                    					markComposite(elementTypeProvider.getModel_X9AltList2ParserRuleCall_8_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleAltList2_in_ruleModel464);
                    ruleAltList2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 10 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:169:3: ( (lv_x10_9_0= ruleSingleKeywords ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:169:3: ( (lv_x10_9_0= ruleSingleKeywords ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:170:4: (lv_x10_9_0= ruleSingleKeywords )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:170:4: (lv_x10_9_0= ruleSingleKeywords )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:171:5: lv_x10_9_0= ruleSingleKeywords
                    {

                    					markComposite(elementTypeProvider.getModel_X10SingleKeywordsParserRuleCall_9_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSingleKeywords_in_ruleModel510);
                    ruleSingleKeywords();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 11 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:181:3: ( (lv_x11_10_0= ruleSingleKeywordsOrID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:181:3: ( (lv_x11_10_0= ruleSingleKeywordsOrID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:182:4: (lv_x11_10_0= ruleSingleKeywordsOrID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:182:4: (lv_x11_10_0= ruleSingleKeywordsOrID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:183:5: lv_x11_10_0= ruleSingleKeywordsOrID
                    {

                    					markComposite(elementTypeProvider.getModel_X11SingleKeywordsOrIDParserRuleCall_10_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSingleKeywordsOrID_in_ruleModel556);
                    ruleSingleKeywordsOrID();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 12 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:193:3: ( (lv_x12_11_0= ruleSingleTerminals ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:193:3: ( (lv_x12_11_0= ruleSingleTerminals ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:194:4: (lv_x12_11_0= ruleSingleTerminals )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:194:4: (lv_x12_11_0= ruleSingleTerminals )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:195:5: lv_x12_11_0= ruleSingleTerminals
                    {

                    					markComposite(elementTypeProvider.getModel_X12SingleTerminalsParserRuleCall_11_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSingleTerminals_in_ruleModel602);
                    ruleSingleTerminals();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 13 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:205:3: ( (lv_x10_12_0= ruleMultiKeywords ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:205:3: ( (lv_x10_12_0= ruleMultiKeywords ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:206:4: (lv_x10_12_0= ruleMultiKeywords )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:206:4: (lv_x10_12_0= ruleMultiKeywords )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:207:5: lv_x10_12_0= ruleMultiKeywords
                    {

                    					markComposite(elementTypeProvider.getModel_X10MultiKeywordsParserRuleCall_12_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleMultiKeywords_in_ruleModel648);
                    ruleMultiKeywords();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 14 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:217:3: ( (lv_x11_13_0= ruleMultiKeywordsOrID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:217:3: ( (lv_x11_13_0= ruleMultiKeywordsOrID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:218:4: (lv_x11_13_0= ruleMultiKeywordsOrID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:218:4: (lv_x11_13_0= ruleMultiKeywordsOrID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:219:5: lv_x11_13_0= ruleMultiKeywordsOrID
                    {

                    					markComposite(elementTypeProvider.getModel_X11MultiKeywordsOrIDParserRuleCall_13_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleMultiKeywordsOrID_in_ruleModel694);
                    ruleMultiKeywordsOrID();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 15 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:229:3: ( (lv_x12_14_0= ruleMultiTerminals ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:229:3: ( (lv_x12_14_0= ruleMultiTerminals ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:230:4: (lv_x12_14_0= ruleMultiTerminals )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:230:4: (lv_x12_14_0= ruleMultiTerminals )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:231:5: lv_x12_14_0= ruleMultiTerminals
                    {

                    					markComposite(elementTypeProvider.getModel_X12MultiTerminalsParserRuleCall_14_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleMultiTerminals_in_ruleModel740);
                    ruleMultiTerminals();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 16 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:241:3: ( (lv_x13_15_0= ruleSingleEnum ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:241:3: ( (lv_x13_15_0= ruleSingleEnum ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:242:4: (lv_x13_15_0= ruleSingleEnum )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:242:4: (lv_x13_15_0= ruleSingleEnum )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:243:5: lv_x13_15_0= ruleSingleEnum
                    {

                    					markComposite(elementTypeProvider.getModel_X13SingleEnumParserRuleCall_15_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSingleEnum_in_ruleModel786);
                    ruleSingleEnum();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 17 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:253:3: ( (lv_x14_16_0= ruleSingleCrossReference ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:253:3: ( (lv_x14_16_0= ruleSingleCrossReference ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:254:4: (lv_x14_16_0= ruleSingleCrossReference )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:254:4: (lv_x14_16_0= ruleSingleCrossReference )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:255:5: lv_x14_16_0= ruleSingleCrossReference
                    {

                    					markComposite(elementTypeProvider.getModel_X14SingleCrossReferenceParserRuleCall_16_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSingleCrossReference_in_ruleModel832);
                    ruleSingleCrossReference();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 18 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:265:3: ( (lv_x15_17_0= ruleSingleContainmentReference ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:265:3: ( (lv_x15_17_0= ruleSingleContainmentReference ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:266:4: (lv_x15_17_0= ruleSingleContainmentReference )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:266:4: (lv_x15_17_0= ruleSingleContainmentReference )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:267:5: lv_x15_17_0= ruleSingleContainmentReference
                    {

                    					markComposite(elementTypeProvider.getModel_X15SingleContainmentReferenceParserRuleCall_17_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReference_in_ruleModel878);
                    ruleSingleContainmentReference();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 19 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:277:3: ( (lv_x19_18_0= ruleDependentAlternative1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:277:3: ( (lv_x19_18_0= ruleDependentAlternative1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:278:4: (lv_x19_18_0= ruleDependentAlternative1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:278:4: (lv_x19_18_0= ruleDependentAlternative1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:279:5: lv_x19_18_0= ruleDependentAlternative1
                    {

                    					markComposite(elementTypeProvider.getModel_X19DependentAlternative1ParserRuleCall_18_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleDependentAlternative1_in_ruleModel924);
                    ruleDependentAlternative1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 20 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:289:3: ( (lv_x20_19_0= ruleDependentAlternative2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:289:3: ( (lv_x20_19_0= ruleDependentAlternative2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:290:4: (lv_x20_19_0= ruleDependentAlternative2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:290:4: (lv_x20_19_0= ruleDependentAlternative2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:291:5: lv_x20_19_0= ruleDependentAlternative2
                    {

                    					markComposite(elementTypeProvider.getModel_X20DependentAlternative2ParserRuleCall_19_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleDependentAlternative2_in_ruleModel970);
                    ruleDependentAlternative2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 21 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:301:3: ( (lv_x21_20_0= ruleOptional ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:301:3: ( (lv_x21_20_0= ruleOptional ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:302:4: (lv_x21_20_0= ruleOptional )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:302:4: (lv_x21_20_0= ruleOptional )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:303:5: lv_x21_20_0= ruleOptional
                    {

                    					markComposite(elementTypeProvider.getModel_X21OptionalParserRuleCall_20_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleOptional_in_ruleModel1016);
                    ruleOptional();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 22 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:313:3: ( (lv_x22_21_0= ruleFloat ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:313:3: ( (lv_x22_21_0= ruleFloat ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:314:4: (lv_x22_21_0= ruleFloat )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:314:4: (lv_x22_21_0= ruleFloat )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:315:5: lv_x22_21_0= ruleFloat
                    {

                    					markComposite(elementTypeProvider.getModel_X22FloatParserRuleCall_21_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleFloat_in_ruleModel1062);
                    ruleFloat();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 23 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:325:3: ( (lv_x23_22_0= ruleUnorderedAlternative ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:325:3: ( (lv_x23_22_0= ruleUnorderedAlternative ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:326:4: (lv_x23_22_0= ruleUnorderedAlternative )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:326:4: (lv_x23_22_0= ruleUnorderedAlternative )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:327:5: lv_x23_22_0= ruleUnorderedAlternative
                    {

                    					markComposite(elementTypeProvider.getModel_X23UnorderedAlternativeParserRuleCall_22_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleUnorderedAlternative_in_ruleModel1108);
                    ruleUnorderedAlternative();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 24 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:337:3: ( (lv_x24_23_0= ruleUnorderedGroup ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:337:3: ( (lv_x24_23_0= ruleUnorderedGroup ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:338:4: (lv_x24_23_0= ruleUnorderedGroup )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:338:4: (lv_x24_23_0= ruleUnorderedGroup )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:339:5: lv_x24_23_0= ruleUnorderedGroup
                    {

                    					markComposite(elementTypeProvider.getModel_X24UnorderedGroupParserRuleCall_23_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_ruleModel1154);
                    ruleUnorderedGroup();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 25 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:349:3: ( (lv_x25_24_0= ruleUnorderedGroupOptional ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:349:3: ( (lv_x25_24_0= ruleUnorderedGroupOptional ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:350:4: (lv_x25_24_0= ruleUnorderedGroupOptional )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:350:4: (lv_x25_24_0= ruleUnorderedGroupOptional )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:351:5: lv_x25_24_0= ruleUnorderedGroupOptional
                    {

                    					markComposite(elementTypeProvider.getModel_X25UnorderedGroupOptionalParserRuleCall_24_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroupOptional_in_ruleModel1200);
                    ruleUnorderedGroupOptional();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 26 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:361:3: ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:361:3: ( (lv_x26_25_0= ruleUnorderedGroupBoolean ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:362:4: (lv_x26_25_0= ruleUnorderedGroupBoolean )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:362:4: (lv_x26_25_0= ruleUnorderedGroupBoolean )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:363:5: lv_x26_25_0= ruleUnorderedGroupBoolean
                    {

                    					markComposite(elementTypeProvider.getModel_X26UnorderedGroupBooleanParserRuleCall_25_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroupBoolean_in_ruleModel1246);
                    ruleUnorderedGroupBoolean();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 27 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:373:3: ( (lv_x27_26_0= ruleComplex1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:373:3: ( (lv_x27_26_0= ruleComplex1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:374:4: (lv_x27_26_0= ruleComplex1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:374:4: (lv_x27_26_0= ruleComplex1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:375:5: lv_x27_26_0= ruleComplex1
                    {

                    					markComposite(elementTypeProvider.getModel_X27Complex1ParserRuleCall_26_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleComplex1_in_ruleModel1292);
                    ruleComplex1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 28 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:385:3: ( (lv_x28_27_0= ruleOptionalDouble ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:385:3: ( (lv_x28_27_0= ruleOptionalDouble ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:386:4: (lv_x28_27_0= ruleOptionalDouble )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:386:4: (lv_x28_27_0= ruleOptionalDouble )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:387:5: lv_x28_27_0= ruleOptionalDouble
                    {

                    					markComposite(elementTypeProvider.getModel_X28OptionalDoubleParserRuleCall_27_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalDouble_in_ruleModel1338);
                    ruleOptionalDouble();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 29 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:397:3: ( (lv_x29_28_0= ruleNullValueGenerated ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:397:3: ( (lv_x29_28_0= ruleNullValueGenerated ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:398:4: (lv_x29_28_0= ruleNullValueGenerated )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:398:4: (lv_x29_28_0= ruleNullValueGenerated )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:399:5: lv_x29_28_0= ruleNullValueGenerated
                    {

                    					markComposite(elementTypeProvider.getModel_X29NullValueGeneratedParserRuleCall_28_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleNullValueGenerated_in_ruleModel1384);
                    ruleNullValueGenerated();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 30 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:409:3: ( (lv_x30_29_0= ruleNullValueInterpreted ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:409:3: ( (lv_x30_29_0= ruleNullValueInterpreted ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:410:4: (lv_x30_29_0= ruleNullValueInterpreted )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:410:4: (lv_x30_29_0= ruleNullValueInterpreted )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:411:5: lv_x30_29_0= ruleNullValueInterpreted
                    {

                    					markComposite(elementTypeProvider.getModel_X30NullValueInterpretedParserRuleCall_29_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleNullValueInterpreted_in_ruleModel1430);
                    ruleNullValueInterpreted();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 31 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:421:3: ( (lv_x31_30_0= ruleNullCrossRefGenerated ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:421:3: ( (lv_x31_30_0= ruleNullCrossRefGenerated ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:422:4: (lv_x31_30_0= ruleNullCrossRefGenerated )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:422:4: (lv_x31_30_0= ruleNullCrossRefGenerated )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:423:5: lv_x31_30_0= ruleNullCrossRefGenerated
                    {

                    					markComposite(elementTypeProvider.getModel_X31NullCrossRefGeneratedParserRuleCall_30_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleNullCrossRefGenerated_in_ruleModel1476);
                    ruleNullCrossRefGenerated();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 32 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:433:3: ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:433:3: ( (lv_x32_31_0= ruleNullCrossRefInterpreted ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:434:4: (lv_x32_31_0= ruleNullCrossRefInterpreted )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:434:4: (lv_x32_31_0= ruleNullCrossRefInterpreted )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:435:5: lv_x32_31_0= ruleNullCrossRefInterpreted
                    {

                    					markComposite(elementTypeProvider.getModel_X32NullCrossRefInterpretedParserRuleCall_31_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleNullCrossRefInterpreted_in_ruleModel1522);
                    ruleNullCrossRefInterpreted();

                    state._fsp--;


                    					doneComposite();
                    				

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
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSimpleGroup"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:448:1: entryRuleSimpleGroup : ruleSimpleGroup EOF ;
    public final void entryRuleSimpleGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:448:21: ( ruleSimpleGroup EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:449:2: ruleSimpleGroup EOF
            {
             markComposite(elementTypeProvider.getSimpleGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup1553);
            ruleSimpleGroup();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleGroup1559); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleGroup"


    // $ANTLR start "ruleSimpleGroup"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:457:1: ruleSimpleGroup : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final void ruleSimpleGroup() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:457:16: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:458:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:458:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:459:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSimpleGroup1582); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSimpleGroup_NumberSignDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:466:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:467:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:467:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:468:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup1609); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getSimpleGroup_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:477:3: ( (lv_val2_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:478:4: (lv_val2_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:478:4: (lv_val2_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:479:5: lv_val2_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup1647); 

            					doneLeaf(lv_val2_2_0, elementTypeProvider.getSimpleGroup_Val2IDTerminalRuleCall_2_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleSimpleGroup"


    // $ANTLR start "entryRuleSimpleAlternative"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:492:1: entryRuleSimpleAlternative : ruleSimpleAlternative EOF ;
    public final void entryRuleSimpleAlternative() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:492:27: ( ruleSimpleAlternative EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:493:2: ruleSimpleAlternative EOF
            {
             markComposite(elementTypeProvider.getSimpleAlternativeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative1678);
            ruleSimpleAlternative();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleAlternative1684); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleAlternative"


    // $ANTLR start "ruleSimpleAlternative"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:501:1: ruleSimpleAlternative : (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final void ruleSimpleAlternative() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val2_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:501:22: ( (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:502:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:502:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:503:3: otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSimpleAlternative1707); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSimpleAlternative_NumberSignDigitTwoKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:510:3: ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:511:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:511:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:512:5: otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSimpleAlternative1734); 

                    					doneLeaf(otherlv_1, elementTypeProvider.getSimpleAlternative_Kw1Keyword_1_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:519:5: ( (lv_val1_2_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:520:6: (lv_val1_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:520:6: (lv_val1_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:521:7: lv_val1_2_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative1771); 

                    							doneLeaf(lv_val1_2_0, elementTypeProvider.getSimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:532:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:532:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:533:5: otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSimpleAlternative1825); 

                    					doneLeaf(otherlv_3, elementTypeProvider.getSimpleAlternative_Kw2Keyword_1_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:540:5: ( (lv_val2_4_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:541:6: (lv_val2_4_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:541:6: (lv_val2_4_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:542:7: lv_val2_4_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val2_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative1862); 

                    							doneLeaf(lv_val2_4_0, elementTypeProvider.getSimpleAlternative_Val2IDTerminalRuleCall_1_1_1_0ElementType());
                    						

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
        return ;
    }
    // $ANTLR end "ruleSimpleAlternative"


    // $ANTLR start "entryRuleSimpleMultiplicities"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:557:1: entryRuleSimpleMultiplicities : ruleSimpleMultiplicities EOF ;
    public final void entryRuleSimpleMultiplicities() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:557:30: ( ruleSimpleMultiplicities EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:558:2: ruleSimpleMultiplicities EOF
            {
             markComposite(elementTypeProvider.getSimpleMultiplicitiesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities1908);
            ruleSimpleMultiplicities();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleMultiplicities1914); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleMultiplicities"


    // $ANTLR start "ruleSimpleMultiplicities"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:566:1: ruleSimpleMultiplicities : (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
    public final void ruleSimpleMultiplicities() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token lv_val3_5_0=null;
        Token otherlv_6=null;
        Token lv_val4_7_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:566:25: ( (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:567:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:567:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:568:3: otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSimpleMultiplicities1937); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSimpleMultiplicities_NumberSignDigitThreeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:575:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:576:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:576:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:577:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1964); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getSimpleMultiplicities_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSimpleMultiplicities1989); 

            			doneLeaf(otherlv_2, elementTypeProvider.getSimpleMultiplicities_Kw1Keyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:593:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:594:4: (lv_val2_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:594:4: (lv_val2_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:595:5: lv_val2_3_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities2016); 

                    					doneLeaf(lv_val2_3_0, elementTypeProvider.getSimpleMultiplicities_Val2IDTerminalRuleCall_3_0ElementType());
                    				

                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSimpleMultiplicities2042); 

            			doneLeaf(otherlv_4, elementTypeProvider.getSimpleMultiplicities_Kw2Keyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:611:3: ( (lv_val3_5_0= RULE_ID ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:612:4: (lv_val3_5_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:612:4: (lv_val3_5_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:613:5: lv_val3_5_0= RULE_ID
            	    {

            	    					markLeaf();
            	    				
            	    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities2069); 

            	    					doneLeaf(lv_val3_5_0, elementTypeProvider.getSimpleMultiplicities_Val3IDTerminalRuleCall_5_0ElementType());
            	    				

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


            			markLeaf();
            		
            otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSimpleMultiplicities2095); 

            			doneLeaf(otherlv_6, elementTypeProvider.getSimpleMultiplicities_Kw3Keyword_6ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:629:3: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:630:4: (lv_val4_7_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:630:4: (lv_val4_7_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:631:5: lv_val4_7_0= RULE_ID
            	    {

            	    					markLeaf();
            	    				
            	    lv_val4_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities2122); 

            	    					doneLeaf(lv_val4_7_0, elementTypeProvider.getSimpleMultiplicities_Val4IDTerminalRuleCall_7_0ElementType());
            	    				

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
        return ;
    }
    // $ANTLR end "ruleSimpleMultiplicities"


    // $ANTLR start "entryRuleGroupMultiplicities"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:644:1: entryRuleGroupMultiplicities : ruleGroupMultiplicities EOF ;
    public final void entryRuleGroupMultiplicities() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:644:29: ( ruleGroupMultiplicities EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:645:2: ruleGroupMultiplicities EOF
            {
             markComposite(elementTypeProvider.getGroupMultiplicitiesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities2154);
            ruleGroupMultiplicities();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupMultiplicities2160); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleGroupMultiplicities"


    // $ANTLR start "ruleGroupMultiplicities"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:653:1: ruleGroupMultiplicities : (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
    public final void ruleGroupMultiplicities() throws RecognitionException {
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:653:24: ( (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:654:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:654:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:655:3: otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleGroupMultiplicities2183); 

            			doneLeaf(otherlv_0, elementTypeProvider.getGroupMultiplicities_NumberSignDigitFourKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:662:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:663:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:663:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:664:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2210); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getGroupMultiplicities_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleGroupMultiplicities2235); 

            			doneLeaf(otherlv_2, elementTypeProvider.getGroupMultiplicities_Kw1Keyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:680:3: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:681:4: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:681:4: ( (lv_val2_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:682:5: (lv_val2_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:682:5: (lv_val2_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:683:6: lv_val2_3_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2270); 

                    						doneLeaf(lv_val2_3_0, elementTypeProvider.getGroupMultiplicities_Val2IDTerminalRuleCall_3_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:692:4: ( (lv_val3_4_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:693:5: (lv_val3_4_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:693:5: (lv_val3_4_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:694:6: lv_val3_4_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2315); 

                    						doneLeaf(lv_val3_4_0, elementTypeProvider.getGroupMultiplicities_Val3IDTerminalRuleCall_3_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGroupMultiplicities2348); 

            			doneLeaf(otherlv_5, elementTypeProvider.getGroupMultiplicities_Kw2Keyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:711:3: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:712:4: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:712:4: ( (lv_val4_6_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:713:5: (lv_val4_6_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:713:5: (lv_val4_6_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:714:6: lv_val4_6_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2383); 

            	    						doneLeaf(lv_val4_6_0, elementTypeProvider.getGroupMultiplicities_Val4IDTerminalRuleCall_5_0_0ElementType());
            	    					

            	    }


            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:723:4: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:724:5: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:724:5: (lv_val5_7_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:725:6: lv_val5_7_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2428); 

            	    						doneLeaf(lv_val5_7_0, elementTypeProvider.getGroupMultiplicities_Val5IDTerminalRuleCall_5_1_0ElementType());
            	    					

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


            			markLeaf();
            		
            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleGroupMultiplicities2461); 

            			doneLeaf(otherlv_8, elementTypeProvider.getGroupMultiplicities_Kw3Keyword_6ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:742:3: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:743:4: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:743:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:744:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:744:5: (lv_val6_9_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:745:6: lv_val6_9_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2496); 

            	    						doneLeaf(lv_val6_9_0, elementTypeProvider.getGroupMultiplicities_Val6IDTerminalRuleCall_7_0_0ElementType());
            	    					

            	    }


            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:754:4: ( (lv_val7_10_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:755:5: (lv_val7_10_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:755:5: (lv_val7_10_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:756:6: lv_val7_10_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val7_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2541); 

            	    						doneLeaf(lv_val7_10_0, elementTypeProvider.getGroupMultiplicities_Val7IDTerminalRuleCall_7_1_0ElementType());
            	    					

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
        return ;
    }
    // $ANTLR end "ruleGroupMultiplicities"


    // $ANTLR start "entryRuleAlternativeMultiplicities"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:770:1: entryRuleAlternativeMultiplicities : ruleAlternativeMultiplicities EOF ;
    public final void entryRuleAlternativeMultiplicities() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:770:35: ( ruleAlternativeMultiplicities EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:771:2: ruleAlternativeMultiplicities EOF
            {
             markComposite(elementTypeProvider.getAlternativeMultiplicitiesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities2580);
            ruleAlternativeMultiplicities();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeMultiplicities2586); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleAlternativeMultiplicities"


    // $ANTLR start "ruleAlternativeMultiplicities"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:779:1: ruleAlternativeMultiplicities : (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
    public final void ruleAlternativeMultiplicities() throws RecognitionException {
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:779:30: ( (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:780:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:780:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:781:3: otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAlternativeMultiplicities2609); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAlternativeMultiplicities_NumberSignDigitFiveKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:788:3: ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:789:4: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:789:4: ( (lv_val2_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:790:5: (lv_val2_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:790:5: (lv_val2_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:791:6: lv_val2_1_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2644); 

                    						doneLeaf(lv_val2_1_0, elementTypeProvider.getAlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:801:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:801:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:802:5: otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleAlternativeMultiplicities2690); 

                    					doneLeaf(otherlv_2, elementTypeProvider.getAlternativeMultiplicities_Kw1Keyword_1_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:809:5: ( (lv_val3_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:810:6: (lv_val3_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:810:6: (lv_val3_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:811:7: lv_val3_3_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2727); 

                    							doneLeaf(lv_val3_3_0, elementTypeProvider.getAlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAlternativeMultiplicities2768); 

            			doneLeaf(otherlv_4, elementTypeProvider.getAlternativeMultiplicities_Kw2Keyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:829:3: ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:830:4: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:830:4: ( (lv_val4_5_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:831:5: (lv_val4_5_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:831:5: (lv_val4_5_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:832:6: lv_val4_5_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2803); 

            	    						doneLeaf(lv_val4_5_0, elementTypeProvider.getAlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:842:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:842:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:843:5: otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAlternativeMultiplicities2849); 

            	    					doneLeaf(otherlv_6, elementTypeProvider.getAlternativeMultiplicities_Kw3Keyword_3_1_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:850:5: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:851:6: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:851:6: (lv_val5_7_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:852:7: lv_val5_7_0= RULE_ID
            	    {

            	    							markLeaf();
            	    						
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2886); 

            	    							doneLeaf(lv_val5_7_0, elementTypeProvider.getAlternativeMultiplicities_Val5IDTerminalRuleCall_3_1_1_0ElementType());
            	    						

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


            			markLeaf();
            		
            otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleAlternativeMultiplicities2927); 

            			doneLeaf(otherlv_8, elementTypeProvider.getAlternativeMultiplicities_Kw4Keyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:870:3: ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:871:4: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:871:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:872:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:872:5: (lv_val6_9_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:873:6: lv_val6_9_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2962); 

            	    						doneLeaf(lv_val6_9_0, elementTypeProvider.getAlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:883:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:883:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:884:5: otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_10=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleAlternativeMultiplicities3008); 

            	    					doneLeaf(otherlv_10, elementTypeProvider.getAlternativeMultiplicities_Kw5Keyword_5_1_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:891:5: ( (lv_val7_11_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:892:6: (lv_val7_11_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:892:6: (lv_val7_11_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:893:7: lv_val7_11_0= RULE_ID
            	    {

            	    							markLeaf();
            	    						
            	    lv_val7_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities3045); 

            	    							doneLeaf(lv_val7_11_0, elementTypeProvider.getAlternativeMultiplicities_Val7IDTerminalRuleCall_5_1_1_0ElementType());
            	    						

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
        return ;
    }
    // $ANTLR end "ruleAlternativeMultiplicities"


    // $ANTLR start "entryRuleList1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:908:1: entryRuleList1 : ruleList1 EOF ;
    public final void entryRuleList1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:908:15: ( ruleList1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:909:2: ruleList1 EOF
            {
             markComposite(elementTypeProvider.getList1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleList1_in_entryRuleList13092);
            ruleList1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList13098); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleList1"


    // $ANTLR start "ruleList1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:917:1: ruleList1 : (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final void ruleList1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:917:10: ( (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:918:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:918:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:919:3: otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleList13121); 

            			doneLeaf(otherlv_0, elementTypeProvider.getList1_NumberSignDigitSixKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:926:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:927:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:927:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:928:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList13148); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getList1_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:937:3: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==25) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:938:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleList13179); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getList1_CommaKeyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:945:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:946:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:946:5: (lv_val1_3_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:947:6: lv_val1_3_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList13211); 

            	    						doneLeaf(lv_val1_3_0, elementTypeProvider.getList1_Val1IDTerminalRuleCall_2_1_0ElementType());
            	    					

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
        return ;
    }
    // $ANTLR end "ruleList1"


    // $ANTLR start "entryRuleList2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:961:1: entryRuleList2 : ruleList2 EOF ;
    public final void entryRuleList2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:961:15: ( ruleList2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:962:2: ruleList2 EOF
            {
             markComposite(elementTypeProvider.getList2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleList2_in_entryRuleList23250);
            ruleList2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList23256); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleList2"


    // $ANTLR start "ruleList2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:970:1: ruleList2 : (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? ) ;
    public final void ruleList2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:970:10: ( (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:971:2: (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:971:2: (otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:972:3: otherlv_0= '#7' () ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleList23279); 

            			doneLeaf(otherlv_0, elementTypeProvider.getList2_NumberSignDigitSevenKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:979:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:980:4: 
            {

            				precedeComposite(elementTypeProvider.getList2_List2Action_1ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:985:3: ( ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:986:4: ( (lv_val1_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:986:4: ( (lv_val1_2_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:987:5: (lv_val1_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:987:5: (lv_val1_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:988:6: lv_val1_2_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList23327); 

                    						doneLeaf(lv_val1_2_0, elementTypeProvider.getList2_Val1IDTerminalRuleCall_2_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:997:4: (otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==25) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:998:5: otherlv_3= ',' ( (lv_val1_4_0= RULE_ID ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleList23364); 

                    	    					doneLeaf(otherlv_3, elementTypeProvider.getList2_CommaKeyword_2_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1005:5: ( (lv_val1_4_0= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1006:6: (lv_val1_4_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1006:6: (lv_val1_4_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1007:7: lv_val1_4_0= RULE_ID
                    	    {

                    	    							markLeaf();
                    	    						
                    	    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList23401); 

                    	    							doneLeaf(lv_val1_4_0, elementTypeProvider.getList2_Val1IDTerminalRuleCall_2_1_1_0ElementType());
                    	    						

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
        return ;
    }
    // $ANTLR end "ruleList2"


    // $ANTLR start "entryRuleAltList1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1022:1: entryRuleAltList1 : ruleAltList1 EOF ;
    public final void entryRuleAltList1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1022:18: ( ruleAltList1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1023:2: ruleAltList1 EOF
            {
             markComposite(elementTypeProvider.getAltList1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAltList1_in_entryRuleAltList13449);
            ruleAltList1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAltList13455); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleAltList1"


    // $ANTLR start "ruleAltList1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1031:1: ruleAltList1 : (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) ;
    public final void ruleAltList1() throws RecognitionException {
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1031:13: ( (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1032:2: (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1032:2: (otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1033:3: otherlv_0= '#8' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAltList13478); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAltList1_NumberSignDigitEightKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1040:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1041:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1041:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1042:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1042:5: ( (lv_val1_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1043:6: (lv_val1_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1043:6: (lv_val1_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1044:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList13522); 

                    							doneLeaf(lv_val1_1_0, elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1053:5: ( (lv_val2_2_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1054:6: (lv_val2_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1054:6: (lv_val2_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1055:7: lv_val2_2_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList13574); 

                    							doneLeaf(lv_val2_2_0, elementTypeProvider.getAltList1_Val2IDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1066:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1066:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1067:5: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleAltList13628); 

                    					doneLeaf(otherlv_3, elementTypeProvider.getAltList1_Kw1Keyword_1_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1074:5: ( (lv_val1_4_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1075:6: (lv_val1_4_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1075:6: (lv_val1_4_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1076:7: lv_val1_4_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList13665); 

                    							doneLeaf(lv_val1_4_0, elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1085:5: ( (lv_val3_5_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1086:6: (lv_val3_5_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1086:6: (lv_val3_5_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1087:7: lv_val3_5_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList13717); 

                    							doneLeaf(lv_val3_5_0, elementTypeProvider.getAltList1_Val3IDTerminalRuleCall_1_1_2_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1098:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1098:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1099:5: otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )?
                    {

                    					markLeaf();
                    				
                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAltList13771); 

                    					doneLeaf(otherlv_6, elementTypeProvider.getAltList1_Kw2Keyword_1_2_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1106:5: ( (lv_val1_7_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1107:6: (lv_val1_7_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1107:6: (lv_val1_7_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1108:7: lv_val1_7_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList13808); 

                    							doneLeaf(lv_val1_7_0, elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_2_1_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1117:5: ( (lv_val4_8_0= RULE_ID ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1118:6: (lv_val4_8_0= RULE_ID )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1118:6: (lv_val4_8_0= RULE_ID )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1119:7: lv_val4_8_0= RULE_ID
                            {

                            							markLeaf();
                            						
                            lv_val4_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList13860); 

                            							doneLeaf(lv_val4_8_0, elementTypeProvider.getAltList1_Val4IDTerminalRuleCall_1_2_2_0ElementType());
                            						

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
        return ;
    }
    // $ANTLR end "ruleAltList1"


    // $ANTLR start "entryRuleAltList2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1134:1: entryRuleAltList2 : ruleAltList2 EOF ;
    public final void entryRuleAltList2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1134:18: ( ruleAltList2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1135:2: ruleAltList2 EOF
            {
             markComposite(elementTypeProvider.getAltList2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAltList2_in_entryRuleAltList23907);
            ruleAltList2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAltList23913); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleAltList2"


    // $ANTLR start "ruleAltList2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1143:1: ruleAltList2 : (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) ;
    public final void ruleAltList2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;
        Token otherlv_5=null;
        Token lv_val1_6_0=null;
        Token lv_val3_7_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1143:13: ( (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1144:2: (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1144:2: (otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1145:3: otherlv_0= '#9' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAltList23936); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAltList2_NumberSignDigitNineKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1152:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1153:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1153:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1154:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1154:5: ( (lv_val1_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1155:6: (lv_val1_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1155:6: (lv_val1_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1156:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList23980); 

                    							doneLeaf(lv_val1_1_0, elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1165:5: ( (lv_val2_2_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1166:6: (lv_val2_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1166:6: (lv_val2_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1167:7: lv_val2_2_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList24032); 

                    							doneLeaf(lv_val2_2_0, elementTypeProvider.getAltList2_Val2IDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1178:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1178:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1179:5: otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAltList24086); 

                    					doneLeaf(otherlv_3, elementTypeProvider.getAltList2_KwKeyword_1_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1186:5: ( (lv_val1_4_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1187:6: (lv_val1_4_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1187:6: (lv_val1_4_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1188:7: lv_val1_4_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList24123); 

                    							doneLeaf(lv_val1_4_0, elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1197:5: (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==25) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1198:6: otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) )
                    	    {

                    	    						markLeaf();
                    	    					
                    	    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAltList24166); 

                    	    						doneLeaf(otherlv_5, elementTypeProvider.getAltList2_CommaKeyword_1_1_2_0ElementType());
                    	    					
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1205:6: ( (lv_val1_6_0= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1206:7: (lv_val1_6_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1206:7: (lv_val1_6_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1207:8: lv_val1_6_0= RULE_ID
                    	    {

                    	    								markLeaf();
                    	    							
                    	    lv_val1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList24208); 

                    	    								doneLeaf(lv_val1_6_0, elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_1_2_1_0ElementType());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1217:5: ( (lv_val3_7_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1218:6: (lv_val3_7_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1218:6: (lv_val3_7_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1219:7: lv_val3_7_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList24270); 

                    							doneLeaf(lv_val3_7_0, elementTypeProvider.getAltList2_Val3IDTerminalRuleCall_1_1_3_0ElementType());
                    						

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
        return ;
    }
    // $ANTLR end "ruleAltList2"


    // $ANTLR start "entryRuleSingleKeywords"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1234:1: entryRuleSingleKeywords : ruleSingleKeywords EOF ;
    public final void entryRuleSingleKeywords() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1234:24: ( ruleSingleKeywords EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1235:2: ruleSingleKeywords EOF
            {
             markComposite(elementTypeProvider.getSingleKeywordsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleKeywords_in_entryRuleSingleKeywords4316);
            ruleSingleKeywords();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleKeywords4322); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSingleKeywords"


    // $ANTLR start "ruleSingleKeywords"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1243:1: ruleSingleKeywords : (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) ;
    public final void ruleSingleKeywords() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1243:19: ( (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1244:2: (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1244:2: (otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1245:3: otherlv_0= '#10' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleSingleKeywords4345); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSingleKeywords_NumberSignDigitOneDigitZeroKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1252:3: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1253:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1253:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1254:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1254:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1255:6: lv_val_1_1= 'kw1'
                    {

                    						markLeaf();
                    					
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSingleKeywords4380); 

                    						doneLeaf(lv_val_1_1, elementTypeProvider.getSingleKeywords_ValKw1Keyword_1_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1263:6: lv_val_1_2= 'kw2'
                    {

                    						markLeaf();
                    					
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSingleKeywords4414); 

                    						doneLeaf(lv_val_1_2, elementTypeProvider.getSingleKeywords_ValKw2Keyword_1_0_1ElementType());
                    					

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1271:6: lv_val_1_3= 'kw3'
                    {

                    						markLeaf();
                    					
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleKeywords4448); 

                    						doneLeaf(lv_val_1_3, elementTypeProvider.getSingleKeywords_ValKw3Keyword_1_0_2ElementType());
                    					

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
        return ;
    }
    // $ANTLR end "ruleSingleKeywords"


    // $ANTLR start "entryRuleSingleKeywordsOrID"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1285:1: entryRuleSingleKeywordsOrID : ruleSingleKeywordsOrID EOF ;
    public final void entryRuleSingleKeywordsOrID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1285:28: ( ruleSingleKeywordsOrID EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1286:2: ruleSingleKeywordsOrID EOF
            {
             markComposite(elementTypeProvider.getSingleKeywordsOrIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleKeywordsOrID_in_entryRuleSingleKeywordsOrID4486);
            ruleSingleKeywordsOrID();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleKeywordsOrID4492); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSingleKeywordsOrID"


    // $ANTLR start "ruleSingleKeywordsOrID"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1294:1: ruleSingleKeywordsOrID : (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) ;
    public final void ruleSingleKeywordsOrID() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;
        Token lv_val_1_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1294:23: ( (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1295:2: (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1295:2: (otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1296:3: otherlv_0= '#11' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleSingleKeywordsOrID4515); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSingleKeywordsOrID_NumberSignDigitOneDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1303:3: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1304:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1304:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1305:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1305:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1306:6: lv_val_1_1= 'kw1'
                    {

                    						markLeaf();
                    					
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSingleKeywordsOrID4550); 

                    						doneLeaf(lv_val_1_1, elementTypeProvider.getSingleKeywordsOrID_ValKw1Keyword_1_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1314:6: lv_val_1_2= 'kw2'
                    {

                    						markLeaf();
                    					
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSingleKeywordsOrID4584); 

                    						doneLeaf(lv_val_1_2, elementTypeProvider.getSingleKeywordsOrID_ValKw2Keyword_1_0_1ElementType());
                    					

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1322:6: lv_val_1_3= 'kw3'
                    {

                    						markLeaf();
                    					
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleKeywordsOrID4618); 

                    						doneLeaf(lv_val_1_3, elementTypeProvider.getSingleKeywordsOrID_ValKw3Keyword_1_0_2ElementType());
                    					

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1330:6: lv_val_1_4= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val_1_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleKeywordsOrID4652); 

                    						doneLeaf(lv_val_1_4, elementTypeProvider.getSingleKeywordsOrID_ValIDTerminalRuleCall_1_0_3ElementType());
                    					

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
        return ;
    }
    // $ANTLR end "ruleSingleKeywordsOrID"


    // $ANTLR start "entryRuleSingleTerminals"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1344:1: entryRuleSingleTerminals : ruleSingleTerminals EOF ;
    public final void entryRuleSingleTerminals() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1344:25: ( ruleSingleTerminals EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1345:2: ruleSingleTerminals EOF
            {
             markComposite(elementTypeProvider.getSingleTerminalsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleTerminals_in_entryRuleSingleTerminals4690);
            ruleSingleTerminals();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleTerminals4696); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSingleTerminals"


    // $ANTLR start "ruleSingleTerminals"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1353:1: ruleSingleTerminals : (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) ;
    public final void ruleSingleTerminals() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1353:20: ( (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1354:2: (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1354:2: (otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1355:3: otherlv_0= '#12' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleSingleTerminals4719); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSingleTerminals_NumberSignDigitOneDigitTwoKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1362:3: ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1363:4: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1363:4: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1364:5: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1364:5: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1365:6: lv_val_1_1= RULE_ID1
                    {

                    						markLeaf();
                    					
                    lv_val_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_RULE_ID1_in_ruleSingleTerminals4754); 

                    						doneLeaf(lv_val_1_1, elementTypeProvider.getSingleTerminals_ValID1TerminalRuleCall_1_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1373:6: lv_val_1_2= RULE_ID2
                    {

                    						markLeaf();
                    					
                    lv_val_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_RULE_ID2_in_ruleSingleTerminals4788); 

                    						doneLeaf(lv_val_1_2, elementTypeProvider.getSingleTerminals_ValID2TerminalRuleCall_1_0_1ElementType());
                    					

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
        return ;
    }
    // $ANTLR end "ruleSingleTerminals"


    // $ANTLR start "entryRuleSingleEnum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1387:1: entryRuleSingleEnum : ruleSingleEnum EOF ;
    public final void entryRuleSingleEnum() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1387:20: ( ruleSingleEnum EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1388:2: ruleSingleEnum EOF
            {
             markComposite(elementTypeProvider.getSingleEnumElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleEnum_in_entryRuleSingleEnum4826);
            ruleSingleEnum();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleEnum4832); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSingleEnum"


    // $ANTLR start "ruleSingleEnum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1396:1: ruleSingleEnum : (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) ) ;
    public final void ruleSingleEnum() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1396:15: ( (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1397:2: (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1397:2: (otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1398:3: otherlv_0= '#13' ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSingleEnum4855); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSingleEnum_NumberSignDigitOneDigitThreeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1405:3: ( ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1406:4: ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1406:4: ( (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1407:5: (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1407:5: (lv_val_1_1= ruleDefEnum1 | lv_val_1_2= ruleDefEnum2 | lv_val_1_3= ruleDefEnum3 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1408:6: lv_val_1_1= ruleDefEnum1
                    {

                    						markComposite(elementTypeProvider.getSingleEnum_ValDefEnum1EnumRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDefEnum1_in_ruleSingleEnum4890);
                    ruleDefEnum1();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1416:6: lv_val_1_2= ruleDefEnum2
                    {

                    						markComposite(elementTypeProvider.getSingleEnum_ValDefEnum2EnumRuleCall_1_0_1ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDefEnum2_in_ruleSingleEnum4924);
                    ruleDefEnum2();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1424:6: lv_val_1_3= ruleDefEnum3
                    {

                    						markComposite(elementTypeProvider.getSingleEnum_ValDefEnum3EnumRuleCall_1_0_2ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDefEnum3_in_ruleSingleEnum4958);
                    ruleDefEnum3();

                    state._fsp--;


                    						doneComposite();
                    					

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
        return ;
    }
    // $ANTLR end "ruleSingleEnum"


    // $ANTLR start "entryRuleSingleCrossReference"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1438:1: entryRuleSingleCrossReference : ruleSingleCrossReference EOF ;
    public final void entryRuleSingleCrossReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1438:30: ( ruleSingleCrossReference EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1439:2: ruleSingleCrossReference EOF
            {
             markComposite(elementTypeProvider.getSingleCrossReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference4996);
            ruleSingleCrossReference();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleCrossReference5002); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSingleCrossReference"


    // $ANTLR start "ruleSingleCrossReference"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1447:1: ruleSingleCrossReference : (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) ) ;
    public final void ruleSingleCrossReference() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1447:25: ( (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1448:2: (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1448:2: (otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1449:3: otherlv_0= '#14' ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) ) ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleSingleCrossReference5025); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSingleCrossReference_NumberSignDigitOneDigitFourKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1456:3: ( ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1457:4: ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1457:4: ( (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1458:5: (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1458:5: (lv_name_1_1= RULE_ID1 | lv_name_1_2= RULE_ID2 | lv_name_1_3= RULE_ID3 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1459:6: lv_name_1_1= RULE_ID1
                    {

                    						markLeaf();
                    					
                    lv_name_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_RULE_ID1_in_ruleSingleCrossReference5060); 

                    						doneLeaf(lv_name_1_1, elementTypeProvider.getSingleCrossReference_NameID1TerminalRuleCall_1_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1467:6: lv_name_1_2= RULE_ID2
                    {

                    						markLeaf();
                    					
                    lv_name_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_RULE_ID2_in_ruleSingleCrossReference5094); 

                    						doneLeaf(lv_name_1_2, elementTypeProvider.getSingleCrossReference_NameID2TerminalRuleCall_1_0_1ElementType());
                    					

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1475:6: lv_name_1_3= RULE_ID3
                    {

                    						markLeaf();
                    					
                    lv_name_1_3=(Token)match(input,RULE_ID3,FollowSets000.FOLLOW_RULE_ID3_in_ruleSingleCrossReference5128); 

                    						doneLeaf(lv_name_1_3, elementTypeProvider.getSingleCrossReference_NameID3TerminalRuleCall_1_0_2ElementType());
                    					

                    }
                    break;

            }


            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1485:3: ( ( (otherlv_2= RULE_ID1 ) ) | ( (otherlv_3= RULE_ID2 ) ) | ( (otherlv_4= RULE_ID3 ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1486:4: ( (otherlv_2= RULE_ID1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1486:4: ( (otherlv_2= RULE_ID1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1487:5: (otherlv_2= RULE_ID1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1487:5: (otherlv_2= RULE_ID1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1488:6: otherlv_2= RULE_ID1
                    {

                    						markLeaf();
                    					
                    otherlv_2=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_RULE_ID1_in_ruleSingleCrossReference5181); 

                    						doneLeaf(otherlv_2, elementTypeProvider.getSingleCrossReference_RefSingleCrossReferenceCrossReference_2_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1498:4: ( (otherlv_3= RULE_ID2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1498:4: ( (otherlv_3= RULE_ID2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1499:5: (otherlv_3= RULE_ID2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1499:5: (otherlv_3= RULE_ID2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1500:6: otherlv_3= RULE_ID2
                    {

                    						markLeaf();
                    					
                    otherlv_3=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_RULE_ID2_in_ruleSingleCrossReference5235); 

                    						doneLeaf(otherlv_3, elementTypeProvider.getSingleCrossReference_RefSingleCrossReferenceCrossReference_2_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1510:4: ( (otherlv_4= RULE_ID3 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1510:4: ( (otherlv_4= RULE_ID3 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1511:5: (otherlv_4= RULE_ID3 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1511:5: (otherlv_4= RULE_ID3 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1512:6: otherlv_4= RULE_ID3
                    {

                    						markLeaf();
                    					
                    otherlv_4=(Token)match(input,RULE_ID3,FollowSets000.FOLLOW_RULE_ID3_in_ruleSingleCrossReference5289); 

                    						doneLeaf(otherlv_4, elementTypeProvider.getSingleCrossReference_RefSingleCrossReferenceCrossReference_2_2_0ElementType());
                    					

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
        return ;
    }
    // $ANTLR end "ruleSingleCrossReference"


    // $ANTLR start "entryRuleSingleContainmentReference"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1526:1: entryRuleSingleContainmentReference : ruleSingleContainmentReference EOF ;
    public final void entryRuleSingleContainmentReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1526:36: ( ruleSingleContainmentReference EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1527:2: ruleSingleContainmentReference EOF
            {
             markComposite(elementTypeProvider.getSingleContainmentReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReference_in_entryRuleSingleContainmentReference5327);
            ruleSingleContainmentReference();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleContainmentReference5333); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSingleContainmentReference"


    // $ANTLR start "ruleSingleContainmentReference"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1535:1: ruleSingleContainmentReference : (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) ) ;
    public final void ruleSingleContainmentReference() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1535:31: ( (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1536:2: (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1536:2: (otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1537:3: otherlv_0= '#15' ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleSingleContainmentReference5356); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSingleContainmentReference_NumberSignDigitOneDigitFiveKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1544:3: ( ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1545:4: ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1545:4: ( (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1546:5: (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1546:5: (lv_child_1_1= ruleSingleContainmentReferenceChild1 | lv_child_1_2= ruleSingleContainmentReferenceChild2 | lv_child_1_3= ruleSingleContainmentReferenceChild3 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1547:6: lv_child_1_1= ruleSingleContainmentReferenceChild1
                    {

                    						markComposite(elementTypeProvider.getSingleContainmentReference_ChildSingleContainmentReferenceChild1ParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReferenceChild1_in_ruleSingleContainmentReference5391);
                    ruleSingleContainmentReferenceChild1();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1555:6: lv_child_1_2= ruleSingleContainmentReferenceChild2
                    {

                    						markComposite(elementTypeProvider.getSingleContainmentReference_ChildSingleContainmentReferenceChild2ParserRuleCall_1_0_1ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReferenceChild2_in_ruleSingleContainmentReference5425);
                    ruleSingleContainmentReferenceChild2();

                    state._fsp--;


                    						doneComposite();
                    					

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1563:6: lv_child_1_3= ruleSingleContainmentReferenceChild3
                    {

                    						markComposite(elementTypeProvider.getSingleContainmentReference_ChildSingleContainmentReferenceChild3ParserRuleCall_1_0_2ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReferenceChild3_in_ruleSingleContainmentReference5459);
                    ruleSingleContainmentReferenceChild3();

                    state._fsp--;


                    						doneComposite();
                    					

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
        return ;
    }
    // $ANTLR end "ruleSingleContainmentReference"


    // $ANTLR start "entryRuleSingleContainmentReferenceChild1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1577:1: entryRuleSingleContainmentReferenceChild1 : ruleSingleContainmentReferenceChild1 EOF ;
    public final void entryRuleSingleContainmentReferenceChild1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1577:42: ( ruleSingleContainmentReferenceChild1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1578:2: ruleSingleContainmentReferenceChild1 EOF
            {
             markComposite(elementTypeProvider.getSingleContainmentReferenceChild1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReferenceChild1_in_entryRuleSingleContainmentReferenceChild15497);
            ruleSingleContainmentReferenceChild1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleContainmentReferenceChild15503); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSingleContainmentReferenceChild1"


    // $ANTLR start "ruleSingleContainmentReferenceChild1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1586:1: ruleSingleContainmentReferenceChild1 : ( (lv_val_0_0= 'kw1' ) ) ;
    public final void ruleSingleContainmentReferenceChild1() throws RecognitionException {
        Token lv_val_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1586:37: ( ( (lv_val_0_0= 'kw1' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1587:2: ( (lv_val_0_0= 'kw1' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1587:2: ( (lv_val_0_0= 'kw1' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1588:3: (lv_val_0_0= 'kw1' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1588:3: (lv_val_0_0= 'kw1' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1589:4: lv_val_0_0= 'kw1'
            {

            				markLeaf();
            			
            lv_val_0_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSingleContainmentReferenceChild15532); 

            				doneLeaf(lv_val_0_0, elementTypeProvider.getSingleContainmentReferenceChild1_ValKw1Keyword_0ElementType());
            			

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
        return ;
    }
    // $ANTLR end "ruleSingleContainmentReferenceChild1"


    // $ANTLR start "entryRuleSingleContainmentReferenceChild2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1601:1: entryRuleSingleContainmentReferenceChild2 : ruleSingleContainmentReferenceChild2 EOF ;
    public final void entryRuleSingleContainmentReferenceChild2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1601:42: ( ruleSingleContainmentReferenceChild2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1602:2: ruleSingleContainmentReferenceChild2 EOF
            {
             markComposite(elementTypeProvider.getSingleContainmentReferenceChild2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReferenceChild2_in_entryRuleSingleContainmentReferenceChild25557);
            ruleSingleContainmentReferenceChild2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleContainmentReferenceChild25563); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSingleContainmentReferenceChild2"


    // $ANTLR start "ruleSingleContainmentReferenceChild2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1610:1: ruleSingleContainmentReferenceChild2 : ( (lv_val_0_0= 'kw2' ) ) ;
    public final void ruleSingleContainmentReferenceChild2() throws RecognitionException {
        Token lv_val_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1610:37: ( ( (lv_val_0_0= 'kw2' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1611:2: ( (lv_val_0_0= 'kw2' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1611:2: ( (lv_val_0_0= 'kw2' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1612:3: (lv_val_0_0= 'kw2' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1612:3: (lv_val_0_0= 'kw2' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1613:4: lv_val_0_0= 'kw2'
            {

            				markLeaf();
            			
            lv_val_0_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSingleContainmentReferenceChild25592); 

            				doneLeaf(lv_val_0_0, elementTypeProvider.getSingleContainmentReferenceChild2_ValKw2Keyword_0ElementType());
            			

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
        return ;
    }
    // $ANTLR end "ruleSingleContainmentReferenceChild2"


    // $ANTLR start "entryRuleSingleContainmentReferenceChild3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1625:1: entryRuleSingleContainmentReferenceChild3 : ruleSingleContainmentReferenceChild3 EOF ;
    public final void entryRuleSingleContainmentReferenceChild3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1625:42: ( ruleSingleContainmentReferenceChild3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1626:2: ruleSingleContainmentReferenceChild3 EOF
            {
             markComposite(elementTypeProvider.getSingleContainmentReferenceChild3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleContainmentReferenceChild3_in_entryRuleSingleContainmentReferenceChild35617);
            ruleSingleContainmentReferenceChild3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleContainmentReferenceChild35623); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSingleContainmentReferenceChild3"


    // $ANTLR start "ruleSingleContainmentReferenceChild3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1634:1: ruleSingleContainmentReferenceChild3 : ( (lv_val_0_0= 'kw3' ) ) ;
    public final void ruleSingleContainmentReferenceChild3() throws RecognitionException {
        Token lv_val_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1634:37: ( ( (lv_val_0_0= 'kw3' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1635:2: ( (lv_val_0_0= 'kw3' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1635:2: ( (lv_val_0_0= 'kw3' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1636:3: (lv_val_0_0= 'kw3' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1636:3: (lv_val_0_0= 'kw3' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1637:4: lv_val_0_0= 'kw3'
            {

            				markLeaf();
            			
            lv_val_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleContainmentReferenceChild35652); 

            				doneLeaf(lv_val_0_0, elementTypeProvider.getSingleContainmentReferenceChild3_ValKw3Keyword_0ElementType());
            			

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
        return ;
    }
    // $ANTLR end "ruleSingleContainmentReferenceChild3"


    // $ANTLR start "entryRuleMultiKeywords"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1649:1: entryRuleMultiKeywords : ruleMultiKeywords EOF ;
    public final void entryRuleMultiKeywords() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1649:23: ( ruleMultiKeywords EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1650:2: ruleMultiKeywords EOF
            {
             markComposite(elementTypeProvider.getMultiKeywordsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiKeywords_in_entryRuleMultiKeywords5677);
            ruleMultiKeywords();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiKeywords5683); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleMultiKeywords"


    // $ANTLR start "ruleMultiKeywords"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1658:1: ruleMultiKeywords : (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) ;
    public final void ruleMultiKeywords() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1658:18: ( (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1659:2: (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1659:2: (otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1660:3: otherlv_0= '#16' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleMultiKeywords5706); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMultiKeywords_NumberSignDigitOneDigitSixKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1667:3: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1668:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1668:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1669:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1669:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1670:6: lv_val_1_1= 'kw1'
                    {

                    						markLeaf();
                    					
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiKeywords5741); 

                    						doneLeaf(lv_val_1_1, elementTypeProvider.getMultiKeywords_ValKw1Keyword_1_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1678:6: lv_val_1_2= 'kw2'
                    {

                    						markLeaf();
                    					
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiKeywords5775); 

                    						doneLeaf(lv_val_1_2, elementTypeProvider.getMultiKeywords_ValKw2Keyword_1_0_1ElementType());
                    					

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1686:6: lv_val_1_3= 'kw3'
                    {

                    						markLeaf();
                    					
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMultiKeywords5809); 

                    						doneLeaf(lv_val_1_3, elementTypeProvider.getMultiKeywords_ValKw3Keyword_1_0_2ElementType());
                    					

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
        return ;
    }
    // $ANTLR end "ruleMultiKeywords"


    // $ANTLR start "entryRuleMultiKeywordsOrID"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1700:1: entryRuleMultiKeywordsOrID : ruleMultiKeywordsOrID EOF ;
    public final void entryRuleMultiKeywordsOrID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1700:27: ( ruleMultiKeywordsOrID EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1701:2: ruleMultiKeywordsOrID EOF
            {
             markComposite(elementTypeProvider.getMultiKeywordsOrIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiKeywordsOrID_in_entryRuleMultiKeywordsOrID5847);
            ruleMultiKeywordsOrID();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiKeywordsOrID5853); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleMultiKeywordsOrID"


    // $ANTLR start "ruleMultiKeywordsOrID"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1709:1: ruleMultiKeywordsOrID : (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) ;
    public final void ruleMultiKeywordsOrID() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;
        Token lv_val_1_3=null;
        Token lv_val_1_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1709:22: ( (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1710:2: (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1710:2: (otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1711:3: otherlv_0= '#17' ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleMultiKeywordsOrID5876); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMultiKeywordsOrID_NumberSignDigitOneDigitSevenKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1718:3: ( ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1719:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1719:4: ( (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1720:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1720:5: (lv_val_1_1= 'kw1' | lv_val_1_2= 'kw2' | lv_val_1_3= 'kw3' | lv_val_1_4= RULE_ID )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1721:6: lv_val_1_1= 'kw1'
                    {

                    						markLeaf();
                    					
                    lv_val_1_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiKeywordsOrID5911); 

                    						doneLeaf(lv_val_1_1, elementTypeProvider.getMultiKeywordsOrID_ValKw1Keyword_1_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1729:6: lv_val_1_2= 'kw2'
                    {

                    						markLeaf();
                    					
                    lv_val_1_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiKeywordsOrID5945); 

                    						doneLeaf(lv_val_1_2, elementTypeProvider.getMultiKeywordsOrID_ValKw2Keyword_1_0_1ElementType());
                    					

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1737:6: lv_val_1_3= 'kw3'
                    {

                    						markLeaf();
                    					
                    lv_val_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMultiKeywordsOrID5979); 

                    						doneLeaf(lv_val_1_3, elementTypeProvider.getMultiKeywordsOrID_ValKw3Keyword_1_0_2ElementType());
                    					

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1745:6: lv_val_1_4= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val_1_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMultiKeywordsOrID6013); 

                    						doneLeaf(lv_val_1_4, elementTypeProvider.getMultiKeywordsOrID_ValIDTerminalRuleCall_1_0_3ElementType());
                    					

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
        return ;
    }
    // $ANTLR end "ruleMultiKeywordsOrID"


    // $ANTLR start "entryRuleMultiTerminals"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1759:1: entryRuleMultiTerminals : ruleMultiTerminals EOF ;
    public final void entryRuleMultiTerminals() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1759:24: ( ruleMultiTerminals EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1760:2: ruleMultiTerminals EOF
            {
             markComposite(elementTypeProvider.getMultiTerminalsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiTerminals_in_entryRuleMultiTerminals6051);
            ruleMultiTerminals();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiTerminals6057); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleMultiTerminals"


    // $ANTLR start "ruleMultiTerminals"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1768:1: ruleMultiTerminals : (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) ;
    public final void ruleMultiTerminals() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_1=null;
        Token lv_val_1_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1768:19: ( (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1769:2: (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1769:2: (otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1770:3: otherlv_0= '#18' ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleMultiTerminals6080); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMultiTerminals_NumberSignDigitOneDigitEightKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1777:3: ( ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1778:4: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1778:4: ( (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1779:5: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1779:5: (lv_val_1_1= RULE_ID1 | lv_val_1_2= RULE_ID2 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1780:6: lv_val_1_1= RULE_ID1
                    {

                    						markLeaf();
                    					
                    lv_val_1_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_RULE_ID1_in_ruleMultiTerminals6115); 

                    						doneLeaf(lv_val_1_1, elementTypeProvider.getMultiTerminals_ValID1TerminalRuleCall_1_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1788:6: lv_val_1_2= RULE_ID2
                    {

                    						markLeaf();
                    					
                    lv_val_1_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_RULE_ID2_in_ruleMultiTerminals6149); 

                    						doneLeaf(lv_val_1_2, elementTypeProvider.getMultiTerminals_ValID2TerminalRuleCall_1_0_1ElementType());
                    					

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
        return ;
    }
    // $ANTLR end "ruleMultiTerminals"


    // $ANTLR start "entryRuleDependentAlternative1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1802:1: entryRuleDependentAlternative1 : ruleDependentAlternative1 EOF ;
    public final void entryRuleDependentAlternative1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1802:31: ( ruleDependentAlternative1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1803:2: ruleDependentAlternative1 EOF
            {
             markComposite(elementTypeProvider.getDependentAlternative1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDependentAlternative1_in_entryRuleDependentAlternative16187);
            ruleDependentAlternative1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDependentAlternative16193); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleDependentAlternative1"


    // $ANTLR start "ruleDependentAlternative1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1811:1: ruleDependentAlternative1 : (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) ) ;
    public final void ruleDependentAlternative1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token lv_val_2_0=null;
        Token lv_flag_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1811:26: ( (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1812:2: (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1812:2: (otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1813:3: otherlv_0= '#19' ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleDependentAlternative16216); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDependentAlternative1_NumberSignDigitOneDigitNineKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1820:3: ( ( (lv_val_1_0= RULE_ID ) ) | ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1821:4: ( (lv_val_1_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1821:4: ( (lv_val_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1822:5: (lv_val_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1822:5: (lv_val_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1823:6: lv_val_1_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDependentAlternative16251); 

                    						doneLeaf(lv_val_1_0, elementTypeProvider.getDependentAlternative1_ValIDTerminalRuleCall_1_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1833:4: ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1833:4: ( ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1834:5: ( (lv_val_2_0= RULE_ID ) ) ( (lv_flag_3_0= 'kw1' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1834:5: ( (lv_val_2_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1835:6: (lv_val_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1835:6: (lv_val_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1836:7: lv_val_2_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDependentAlternative16314); 

                    							doneLeaf(lv_val_2_0, elementTypeProvider.getDependentAlternative1_ValIDTerminalRuleCall_1_1_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1845:5: ( (lv_flag_3_0= 'kw1' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1846:6: (lv_flag_3_0= 'kw1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1846:6: (lv_flag_3_0= 'kw1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1847:7: lv_flag_3_0= 'kw1'
                    {

                    							markLeaf();
                    						
                    lv_flag_3_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDependentAlternative16366); 

                    							doneLeaf(lv_flag_3_0, elementTypeProvider.getDependentAlternative1_FlagKw1Keyword_1_1_1_0ElementType());
                    						

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
        return ;
    }
    // $ANTLR end "ruleDependentAlternative1"


    // $ANTLR start "entryRuleDependentAlternative2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1862:1: entryRuleDependentAlternative2 : ruleDependentAlternative2 EOF ;
    public final void entryRuleDependentAlternative2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1862:31: ( ruleDependentAlternative2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1863:2: ruleDependentAlternative2 EOF
            {
             markComposite(elementTypeProvider.getDependentAlternative2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDependentAlternative2_in_entryRuleDependentAlternative26412);
            ruleDependentAlternative2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDependentAlternative26418); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleDependentAlternative2"


    // $ANTLR start "ruleDependentAlternative2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1871:1: ruleDependentAlternative2 : (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) ) ;
    public final void ruleDependentAlternative2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;
        Token lv_val_2_0=null;
        Token lv_val_3_0=null;
        Token lv_flag_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1871:26: ( (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1872:2: (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1872:2: (otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1873:3: otherlv_0= '#20' ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleDependentAlternative26441); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDependentAlternative2_NumberSignDigitTwoDigitZeroKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1880:3: ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1881:4: ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1881:4: ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1882:5: ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1882:5: ( (lv_val_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1883:6: (lv_val_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1883:6: (lv_val_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1884:7: lv_val_1_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDependentAlternative26485); 

                    							doneLeaf(lv_val_1_0, elementTypeProvider.getDependentAlternative2_ValIDTerminalRuleCall_1_0_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1893:5: ( (lv_val_2_0= RULE_ID ) )+
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
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1894:6: (lv_val_2_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1894:6: (lv_val_2_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1895:7: lv_val_2_0= RULE_ID
                    	    {

                    	    							markLeaf();
                    	    						
                    	    lv_val_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDependentAlternative26537); 

                    	    							doneLeaf(lv_val_2_0, elementTypeProvider.getDependentAlternative2_ValIDTerminalRuleCall_1_0_1_0ElementType());
                    	    						

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1906:4: ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1906:4: ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1907:5: ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1907:5: ( (lv_val_3_0= RULE_ID ) )+
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
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1908:6: (lv_val_3_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1908:6: (lv_val_3_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1909:7: lv_val_3_0= RULE_ID
                    	    {

                    	    							markLeaf();
                    	    						
                    	    lv_val_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDependentAlternative26609); 

                    	    							doneLeaf(lv_val_3_0, elementTypeProvider.getDependentAlternative2_ValIDTerminalRuleCall_1_1_0_0ElementType());
                    	    						

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

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1918:5: ( (lv_flag_4_0= 'kw1' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1919:6: (lv_flag_4_0= 'kw1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1919:6: (lv_flag_4_0= 'kw1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1920:7: lv_flag_4_0= 'kw1'
                    {

                    							markLeaf();
                    						
                    lv_flag_4_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDependentAlternative26662); 

                    							doneLeaf(lv_flag_4_0, elementTypeProvider.getDependentAlternative2_FlagKw1Keyword_1_1_1_0ElementType());
                    						

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
        return ;
    }
    // $ANTLR end "ruleDependentAlternative2"


    // $ANTLR start "entryRuleOptional"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1935:1: entryRuleOptional : ruleOptional EOF ;
    public final void entryRuleOptional() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1935:18: ( ruleOptional EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1936:2: ruleOptional EOF
            {
             markComposite(elementTypeProvider.getOptionalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptional_in_entryRuleOptional6708);
            ruleOptional();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptional6714); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleOptional"


    // $ANTLR start "ruleOptional"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1944:1: ruleOptional : (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? ) ;
    public final void ruleOptional() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_int0_1_0=null;
        Token lv_int1_2_0=null;
        Token lv_int2_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1944:13: ( (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1945:2: (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1945:2: (otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1946:3: otherlv_0= '#21' ( (lv_int0_1_0= RULE_INT ) ) ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleOptional6737); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOptional_NumberSignDigitTwoDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1953:3: ( (lv_int0_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1954:4: (lv_int0_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1954:4: (lv_int0_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1955:5: lv_int0_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_int0_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleOptional6764); 

            					doneLeaf(lv_int0_1_0, elementTypeProvider.getOptional_Int0INTTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1964:3: ( ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_INT) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1965:4: ( (lv_int1_2_0= RULE_INT ) ) ( (lv_int2_3_0= RULE_INT ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1965:4: ( (lv_int1_2_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1966:5: (lv_int1_2_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1966:5: (lv_int1_2_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1967:6: lv_int1_2_0= RULE_INT
                    {

                    						markLeaf();
                    					
                    lv_int1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleOptional6810); 

                    						doneLeaf(lv_int1_2_0, elementTypeProvider.getOptional_Int1INTTerminalRuleCall_2_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1976:4: ( (lv_int2_3_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1977:5: (lv_int2_3_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1977:5: (lv_int2_3_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1978:6: lv_int2_3_0= RULE_INT
                    {

                    						markLeaf();
                    					
                    lv_int2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleOptional6855); 

                    						doneLeaf(lv_int2_3_0, elementTypeProvider.getOptional_Int2INTTerminalRuleCall_2_1_0ElementType());
                    					

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
        return ;
    }
    // $ANTLR end "ruleOptional"


    // $ANTLR start "entryRuleFloat"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1992:1: entryRuleFloat : ruleFloat EOF ;
    public final void entryRuleFloat() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1992:15: ( ruleFloat EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:1993:2: ruleFloat EOF
            {
             markComposite(elementTypeProvider.getFloatElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFloat_in_entryRuleFloat6894);
            ruleFloat();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFloat6900); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleFloat"


    // $ANTLR start "ruleFloat"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2001:1: ruleFloat : (otherlv_0= '#22' () otherlv_2= 'Bye' ) ;
    public final void ruleFloat() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2001:10: ( (otherlv_0= '#22' () otherlv_2= 'Bye' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2002:2: (otherlv_0= '#22' () otherlv_2= 'Bye' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2002:2: (otherlv_0= '#22' () otherlv_2= 'Bye' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2003:3: otherlv_0= '#22' () otherlv_2= 'Bye'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleFloat6923); 

            			doneLeaf(otherlv_0, elementTypeProvider.getFloat_NumberSignDigitTwoDigitTwoKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2010:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2011:4: 
            {

            				precedeComposite(elementTypeProvider.getFloat_FloatAction_1ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleFloat6950); 

            			doneLeaf(otherlv_2, elementTypeProvider.getFloat_ByeKeyword_2ElementType());
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleFloat"


    // $ANTLR start "entryRuleUnorderedAlternative"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2027:1: entryRuleUnorderedAlternative : ruleUnorderedAlternative EOF ;
    public final void entryRuleUnorderedAlternative() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2027:30: ( ruleUnorderedAlternative EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2028:2: ruleUnorderedAlternative EOF
            {
             markComposite(elementTypeProvider.getUnorderedAlternativeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedAlternative_in_entryRuleUnorderedAlternative6970);
            ruleUnorderedAlternative();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedAlternative6976); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleUnorderedAlternative"


    // $ANTLR start "ruleUnorderedAlternative"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2036:1: ruleUnorderedAlternative : (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* ) ;
    public final void ruleUnorderedAlternative() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2036:25: ( (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2037:2: (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2037:2: (otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2038:3: otherlv_0= '#23' () ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleUnorderedAlternative6999); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnorderedAlternative_NumberSignDigitTwoDigitThreeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2045:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2046:4: 
            {

            				precedeComposite(elementTypeProvider.getUnorderedAlternative_UnorderedAlternativeAction_1ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2051:3: ( ( (lv_val1_2_0= RULE_ID ) ) | ( (lv_val2_3_0= RULE_INT ) ) | ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) ) | ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2052:4: ( (lv_val1_2_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2052:4: ( (lv_val1_2_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2053:5: (lv_val1_2_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2053:5: (lv_val1_2_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2054:6: lv_val1_2_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnorderedAlternative7047); 

            	    						doneLeaf(lv_val1_2_0, elementTypeProvider.getUnorderedAlternative_Val1IDTerminalRuleCall_2_0_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2064:4: ( (lv_val2_3_0= RULE_INT ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2064:4: ( (lv_val2_3_0= RULE_INT ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2065:5: (lv_val2_3_0= RULE_INT )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2065:5: (lv_val2_3_0= RULE_INT )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2066:6: lv_val2_3_0= RULE_INT
            	    {

            	    						markLeaf();
            	    					
            	    lv_val2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUnorderedAlternative7101); 

            	    						doneLeaf(lv_val2_3_0, elementTypeProvider.getUnorderedAlternative_Val2INTTerminalRuleCall_2_1_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2076:4: ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2076:4: ( (lv_val3_4_0= ruleUnorderedAlternativeVal ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2077:5: (lv_val3_4_0= ruleUnorderedAlternativeVal )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2077:5: (lv_val3_4_0= ruleUnorderedAlternativeVal )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2078:6: lv_val3_4_0= ruleUnorderedAlternativeVal
            	    {

            	    						markComposite(elementTypeProvider.getUnorderedAlternative_Val3UnorderedAlternativeValParserRuleCall_2_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleUnorderedAlternativeVal_in_ruleUnorderedAlternative7155);
            	    ruleUnorderedAlternativeVal();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2088:4: ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2088:4: ( (lv_val4_5_0= ruleUnorderedAlternativeValDelegate ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2089:5: (lv_val4_5_0= ruleUnorderedAlternativeValDelegate )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2089:5: (lv_val4_5_0= ruleUnorderedAlternativeValDelegate )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2090:6: lv_val4_5_0= ruleUnorderedAlternativeValDelegate
            	    {

            	    						markComposite(elementTypeProvider.getUnorderedAlternative_Val4UnorderedAlternativeValDelegateParserRuleCall_2_3_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleUnorderedAlternativeValDelegate_in_ruleUnorderedAlternative7209);
            	    ruleUnorderedAlternativeValDelegate();

            	    state._fsp--;


            	    						doneComposite();
            	    					

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
        return ;
    }
    // $ANTLR end "ruleUnorderedAlternative"


    // $ANTLR start "entryRuleUnorderedAlternativeVal"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2104:1: entryRuleUnorderedAlternativeVal : ruleUnorderedAlternativeVal EOF ;
    public final void entryRuleUnorderedAlternativeVal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2104:33: ( ruleUnorderedAlternativeVal EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2105:2: ruleUnorderedAlternativeVal EOF
            {
             markComposite(elementTypeProvider.getUnorderedAlternativeValElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedAlternativeVal_in_entryRuleUnorderedAlternativeVal7248);
            ruleUnorderedAlternativeVal();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedAlternativeVal7254); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleUnorderedAlternativeVal"


    // $ANTLR start "ruleUnorderedAlternativeVal"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2113:1: ruleUnorderedAlternativeVal : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final void ruleUnorderedAlternativeVal() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2113:28: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2114:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2114:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2115:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleUnorderedAlternativeVal7277); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnorderedAlternativeVal_Kw1Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2122:3: ( (lv_val_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2123:4: (lv_val_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2123:4: (lv_val_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2124:5: lv_val_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnorderedAlternativeVal7304); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getUnorderedAlternativeVal_ValIDTerminalRuleCall_1_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleUnorderedAlternativeVal"


    // $ANTLR start "entryRuleUnorderedAlternativeValDelegate"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2137:1: entryRuleUnorderedAlternativeValDelegate : ruleUnorderedAlternativeValDelegate EOF ;
    public final void entryRuleUnorderedAlternativeValDelegate() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2137:41: ( ruleUnorderedAlternativeValDelegate EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2138:2: ruleUnorderedAlternativeValDelegate EOF
            {
             markComposite(elementTypeProvider.getUnorderedAlternativeValDelegateElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedAlternativeValDelegate_in_entryRuleUnorderedAlternativeValDelegate7335);
            ruleUnorderedAlternativeValDelegate();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedAlternativeValDelegate7341); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleUnorderedAlternativeValDelegate"


    // $ANTLR start "ruleUnorderedAlternativeValDelegate"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2146:1: ruleUnorderedAlternativeValDelegate : ruleUnorderedAlternativeVal2 ;
    public final void ruleUnorderedAlternativeValDelegate() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2146:36: ( ruleUnorderedAlternativeVal2 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2147:2: ruleUnorderedAlternativeVal2
            {

            		markComposite(elementTypeProvider.getUnorderedAlternativeValDelegate_UnorderedAlternativeVal2ParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedAlternativeVal2_in_ruleUnorderedAlternativeValDelegate7357);
            ruleUnorderedAlternativeVal2();

            state._fsp--;


            		doneComposite();
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleUnorderedAlternativeValDelegate"


    // $ANTLR start "entryRuleUnorderedAlternativeVal2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2157:1: entryRuleUnorderedAlternativeVal2 : ruleUnorderedAlternativeVal2 EOF ;
    public final void entryRuleUnorderedAlternativeVal2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2157:34: ( ruleUnorderedAlternativeVal2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2158:2: ruleUnorderedAlternativeVal2 EOF
            {
             markComposite(elementTypeProvider.getUnorderedAlternativeVal2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedAlternativeVal2_in_entryRuleUnorderedAlternativeVal27373);
            ruleUnorderedAlternativeVal2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedAlternativeVal27379); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleUnorderedAlternativeVal2"


    // $ANTLR start "ruleUnorderedAlternativeVal2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2166:1: ruleUnorderedAlternativeVal2 : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final void ruleUnorderedAlternativeVal2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2166:29: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2167:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2167:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2168:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleUnorderedAlternativeVal27402); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnorderedAlternativeVal2_Kw2Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2175:3: ( (lv_val_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2176:4: (lv_val_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2176:4: (lv_val_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2177:5: lv_val_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnorderedAlternativeVal27429); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getUnorderedAlternativeVal2_ValIDTerminalRuleCall_1_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleUnorderedAlternativeVal2"


    // $ANTLR start "entryRuleUnorderedGroup"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2190:1: entryRuleUnorderedGroup : ruleUnorderedGroup EOF ;
    public final void entryRuleUnorderedGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2190:24: ( ruleUnorderedGroup EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2191:2: ruleUnorderedGroup EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup7460);
            ruleUnorderedGroup();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedGroup7466); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleUnorderedGroup"


    // $ANTLR start "ruleUnorderedGroup"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2199:1: ruleUnorderedGroup : (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) ) ;
    public final void ruleUnorderedGroup() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2199:19: ( (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2200:2: (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2200:2: (otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2201:3: otherlv_0= '#24' ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleUnorderedGroup7489); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnorderedGroup_NumberSignDigitTwoDigitFourKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2208:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2209:4: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2209:4: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2210:5: ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            				
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2213:5: ( ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?)
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2214:6: ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+ {...}?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2214:6: ( ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) ) )+
            int cnt35=0;
            loop35:
            do {
                int alt35=5;
                int LA35_0 = input.LA(1);

                if ( LA35_0 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0) ) {
                    alt35=1;
                }
                else if ( LA35_0 ==RULE_INT && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1) ) {
                    alt35=2;
                }
                else if ( LA35_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2) ) {
                    alt35=3;
                }
                else if ( LA35_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3) ) {
                    alt35=4;
                }


                switch (alt35) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2215:4: ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2215:4: ({...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2216:5: {...}? => ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2216:111: ( ({...}? => ( (lv_val1_2_0= RULE_ID ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2217:6: ({...}? => ( (lv_val1_2_0= RULE_ID ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 0);
            	    					
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2220:9: ({...}? => ( (lv_val1_2_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2220:10: {...}? => ( (lv_val1_2_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2220:19: ( (lv_val1_2_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2220:20: (lv_val1_2_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2220:20: (lv_val1_2_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2221:10: lv_val1_2_0= RULE_ID
            	    {

            	    										markLeaf();
            	    									
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnorderedGroup7579); 

            	    										doneLeaf(lv_val1_2_0, elementTypeProvider.getUnorderedGroup_Val1IDTerminalRuleCall_1_0_0ElementType());
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2235:4: ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2235:4: ({...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2236:5: {...}? => ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2236:111: ( ({...}? => ( (lv_val2_3_0= RULE_INT ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2237:6: ({...}? => ( (lv_val2_3_0= RULE_INT ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 1);
            	    					
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2240:9: ({...}? => ( (lv_val2_3_0= RULE_INT ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2240:10: {...}? => ( (lv_val2_3_0= RULE_INT ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2240:19: ( (lv_val2_3_0= RULE_INT ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2240:20: (lv_val2_3_0= RULE_INT )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2240:20: (lv_val2_3_0= RULE_INT )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2241:10: lv_val2_3_0= RULE_INT
            	    {

            	    										markLeaf();
            	    									
            	    lv_val2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUnorderedGroup7688); 

            	    										doneLeaf(lv_val2_3_0, elementTypeProvider.getUnorderedGroup_Val2INTTerminalRuleCall_1_1_0ElementType());
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2255:4: ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2255:4: ({...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2256:5: {...}? => ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2256:111: ( ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2257:6: ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 2);
            	    					
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2260:9: ({...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2260:10: {...}? => ( (lv_val3_4_0= ruleUnorderedGroupVal ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2260:19: ( (lv_val3_4_0= ruleUnorderedGroupVal ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2260:20: (lv_val3_4_0= ruleUnorderedGroupVal )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2260:20: (lv_val3_4_0= ruleUnorderedGroupVal )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2261:10: lv_val3_4_0= ruleUnorderedGroupVal
            	    {

            	    										markComposite(elementTypeProvider.getUnorderedGroup_Val3UnorderedGroupValParserRuleCall_1_2_0ElementType());
            	    									
            	    pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroupVal_in_ruleUnorderedGroup7797);
            	    ruleUnorderedGroupVal();

            	    state._fsp--;


            	    										doneComposite();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2275:4: ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2275:4: ({...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2276:5: {...}? => ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3)");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2276:111: ( ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2277:6: ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupAccess().getUnorderedGroup_1(), 3);
            	    					
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2280:9: ({...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2280:10: {...}? => ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroup", "true");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2280:19: ( (lv_val4_5_0= ruleUnorderedGroupValDelegate ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2280:20: (lv_val4_5_0= ruleUnorderedGroupValDelegate )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2280:20: (lv_val4_5_0= ruleUnorderedGroupValDelegate )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2281:10: lv_val4_5_0= ruleUnorderedGroupValDelegate
            	    {

            	    										markComposite(elementTypeProvider.getUnorderedGroup_Val4UnorderedGroupValDelegateParserRuleCall_1_3_0ElementType());
            	    									
            	    pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroupValDelegate_in_ruleUnorderedGroup7906);
            	    ruleUnorderedGroupValDelegate();

            	    state._fsp--;


            	    										doneComposite();
            	    									

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
        return ;
    }
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleUnorderedGroupVal"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2307:1: entryRuleUnorderedGroupVal : ruleUnorderedGroupVal EOF ;
    public final void entryRuleUnorderedGroupVal() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2307:27: ( ruleUnorderedGroupVal EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2308:2: ruleUnorderedGroupVal EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupValElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroupVal_in_entryRuleUnorderedGroupVal8008);
            ruleUnorderedGroupVal();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedGroupVal8014); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleUnorderedGroupVal"


    // $ANTLR start "ruleUnorderedGroupVal"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2316:1: ruleUnorderedGroupVal : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final void ruleUnorderedGroupVal() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2316:22: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2317:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2317:2: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2318:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleUnorderedGroupVal8037); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnorderedGroupVal_Kw1Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2325:3: ( (lv_val_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2326:4: (lv_val_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2326:4: (lv_val_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2327:5: lv_val_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnorderedGroupVal8064); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getUnorderedGroupVal_ValIDTerminalRuleCall_1_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleUnorderedGroupVal"


    // $ANTLR start "entryRuleUnorderedGroupValDelegate"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2340:1: entryRuleUnorderedGroupValDelegate : ruleUnorderedGroupValDelegate EOF ;
    public final void entryRuleUnorderedGroupValDelegate() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2340:35: ( ruleUnorderedGroupValDelegate EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2341:2: ruleUnorderedGroupValDelegate EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupValDelegateElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroupValDelegate_in_entryRuleUnorderedGroupValDelegate8095);
            ruleUnorderedGroupValDelegate();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedGroupValDelegate8101); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleUnorderedGroupValDelegate"


    // $ANTLR start "ruleUnorderedGroupValDelegate"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2349:1: ruleUnorderedGroupValDelegate : ruleUnorderedGroupVal2 ;
    public final void ruleUnorderedGroupValDelegate() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2349:30: ( ruleUnorderedGroupVal2 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2350:2: ruleUnorderedGroupVal2
            {

            		markComposite(elementTypeProvider.getUnorderedGroupValDelegate_UnorderedGroupVal2ParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroupVal2_in_ruleUnorderedGroupValDelegate8117);
            ruleUnorderedGroupVal2();

            state._fsp--;


            		doneComposite();
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleUnorderedGroupValDelegate"


    // $ANTLR start "entryRuleUnorderedGroupVal2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2360:1: entryRuleUnorderedGroupVal2 : ruleUnorderedGroupVal2 EOF ;
    public final void entryRuleUnorderedGroupVal2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2360:28: ( ruleUnorderedGroupVal2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2361:2: ruleUnorderedGroupVal2 EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupVal2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroupVal2_in_entryRuleUnorderedGroupVal28133);
            ruleUnorderedGroupVal2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedGroupVal28139); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleUnorderedGroupVal2"


    // $ANTLR start "ruleUnorderedGroupVal2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2369:1: ruleUnorderedGroupVal2 : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final void ruleUnorderedGroupVal2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2369:23: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2370:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2370:2: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2371:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleUnorderedGroupVal28162); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnorderedGroupVal2_Kw2Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2378:3: ( (lv_val_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2379:4: (lv_val_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2379:4: (lv_val_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2380:5: lv_val_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnorderedGroupVal28189); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getUnorderedGroupVal2_ValIDTerminalRuleCall_1_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleUnorderedGroupVal2"


    // $ANTLR start "entryRuleUnorderedGroupOptional"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2393:1: entryRuleUnorderedGroupOptional : ruleUnorderedGroupOptional EOF ;
    public final void entryRuleUnorderedGroupOptional() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2393:32: ( ruleUnorderedGroupOptional EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2394:2: ruleUnorderedGroupOptional EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupOptionalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroupOptional_in_entryRuleUnorderedGroupOptional8220);
            ruleUnorderedGroupOptional();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedGroupOptional8226); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleUnorderedGroupOptional"


    // $ANTLR start "ruleUnorderedGroupOptional"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2402:1: ruleUnorderedGroupOptional : (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) ) ;
    public final void ruleUnorderedGroupOptional() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;
        Token otherlv_5=null;
        Token lv_va2_6_0=null;
        Token otherlv_7=null;
        Token lv_val3_8_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2402:27: ( (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2403:2: (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2403:2: (otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2404:3: otherlv_0= '#25' () ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleUnorderedGroupOptional8249); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnorderedGroupOptional_NumberSignDigitTwoDigitFiveKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2411:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2412:4: 
            {

            				precedeComposite(elementTypeProvider.getUnorderedGroupOptional_UnorderedGroupOptionalAction_1ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2417:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2418:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2418:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2419:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2());
            				
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2422:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2423:6: ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2423:6: ( ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) ) )*
            loop36:
            do {
                int alt36=4;
                int LA36_0 = input.LA(1);

                if ( LA36_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0) ) {
                    alt36=1;
                }
                else if ( LA36_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1) ) {
                    alt36=2;
                }
                else if ( LA36_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2) ) {
                    alt36=3;
                }


                switch (alt36) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2424:4: ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2424:4: ({...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2425:5: {...}? => ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2425:119: ( ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2426:6: ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2429:9: ({...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2429:10: {...}? => (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "true");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2429:19: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2429:20: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) )
            	    {

            	    									markLeaf();
            	    								
            	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleUnorderedGroupOptional8340); 

            	    									doneLeaf(otherlv_3, elementTypeProvider.getUnorderedGroupOptional_Kw1Keyword_2_0_0ElementType());
            	    								
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2436:9: ( (lv_val1_4_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2437:10: (lv_val1_4_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2437:10: (lv_val1_4_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2438:11: lv_val1_4_0= RULE_ID
            	    {

            	    											markLeaf();
            	    										
            	    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnorderedGroupOptional8397); 

            	    											doneLeaf(lv_val1_4_0, elementTypeProvider.getUnorderedGroupOptional_Val1IDTerminalRuleCall_2_0_1_0ElementType());
            	    										

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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2453:4: ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2453:4: ({...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2454:5: {...}? => ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2454:119: ( ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2455:6: ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2458:9: ({...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2458:10: {...}? => (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "true");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2458:19: (otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2458:20: otherlv_5= 'kw2' ( (lv_va2_6_0= RULE_ID ) )
            	    {

            	    									markLeaf();
            	    								
            	    otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleUnorderedGroupOptional8506); 

            	    									doneLeaf(otherlv_5, elementTypeProvider.getUnorderedGroupOptional_Kw2Keyword_2_1_0ElementType());
            	    								
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2465:9: ( (lv_va2_6_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2466:10: (lv_va2_6_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2466:10: (lv_va2_6_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2467:11: lv_va2_6_0= RULE_ID
            	    {

            	    											markLeaf();
            	    										
            	    lv_va2_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnorderedGroupOptional8563); 

            	    											doneLeaf(lv_va2_6_0, elementTypeProvider.getUnorderedGroupOptional_Va2IDTerminalRuleCall_2_1_1_0ElementType());
            	    										

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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2482:4: ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2482:4: ({...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2483:5: {...}? => ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2483:119: ( ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2484:6: ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupOptionalAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2487:9: ({...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2487:10: {...}? => (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupOptional", "true");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2487:19: (otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2487:20: otherlv_7= 'kw3' ( (lv_val3_8_0= RULE_ID ) )
            	    {

            	    									markLeaf();
            	    								
            	    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleUnorderedGroupOptional8672); 

            	    									doneLeaf(otherlv_7, elementTypeProvider.getUnorderedGroupOptional_Kw3Keyword_2_2_0ElementType());
            	    								
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2494:9: ( (lv_val3_8_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2495:10: (lv_val3_8_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2495:10: (lv_val3_8_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2496:11: lv_val3_8_0= RULE_ID
            	    {

            	    											markLeaf();
            	    										
            	    lv_val3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnorderedGroupOptional8729); 

            	    											doneLeaf(lv_val3_8_0, elementTypeProvider.getUnorderedGroupOptional_Val3IDTerminalRuleCall_2_2_1_0ElementType());
            	    										

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
        return ;
    }
    // $ANTLR end "ruleUnorderedGroupOptional"


    // $ANTLR start "entryRuleUnorderedGroupBoolean"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2522:1: entryRuleUnorderedGroupBoolean : ruleUnorderedGroupBoolean EOF ;
    public final void entryRuleUnorderedGroupBoolean() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2522:31: ( ruleUnorderedGroupBoolean EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2523:2: ruleUnorderedGroupBoolean EOF
            {
             markComposite(elementTypeProvider.getUnorderedGroupBooleanElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroupBoolean_in_entryRuleUnorderedGroupBoolean8836);
            ruleUnorderedGroupBoolean();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedGroupBoolean8842); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleUnorderedGroupBoolean"


    // $ANTLR start "ruleUnorderedGroupBoolean"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2531:1: ruleUnorderedGroupBoolean : (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) ) ;
    public final void ruleUnorderedGroupBoolean() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_3_0=null;
        Token lv_val2_4_0=null;
        Token lv_val3_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2531:26: ( (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2532:2: (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2532:2: (otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2533:3: otherlv_0= '#26' () ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleUnorderedGroupBoolean8865); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnorderedGroupBoolean_NumberSignDigitTwoDigitSixKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2540:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2541:4: 
            {

            				precedeComposite(elementTypeProvider.getUnorderedGroupBoolean_UnorderedGroupBooleanAction_1ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2546:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2547:4: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2547:4: ( ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2548:5: ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
            				
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2551:5: ( ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2552:6: ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2552:6: ( ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) ) )*
            loop37:
            do {
                int alt37=4;
                int LA37_0 = input.LA(1);

                if ( LA37_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0) ) {
                    alt37=1;
                }
                else if ( LA37_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1) ) {
                    alt37=2;
                }
                else if ( LA37_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2) ) {
                    alt37=3;
                }


                switch (alt37) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2553:4: ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2553:4: ({...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2554:5: {...}? => ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2554:118: ( ({...}? => ( (lv_val1_3_0= 'kw1' ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2555:6: ({...}? => ( (lv_val1_3_0= 'kw1' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2558:9: ({...}? => ( (lv_val1_3_0= 'kw1' ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2558:10: {...}? => ( (lv_val1_3_0= 'kw1' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "true");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2558:19: ( (lv_val1_3_0= 'kw1' ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2558:20: (lv_val1_3_0= 'kw1' )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2558:20: (lv_val1_3_0= 'kw1' )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2559:10: lv_val1_3_0= 'kw1'
            	    {

            	    										markLeaf();
            	    									
            	    lv_val1_3_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleUnorderedGroupBoolean8968); 

            	    										doneLeaf(lv_val1_3_0, elementTypeProvider.getUnorderedGroupBoolean_Val1Kw1Keyword_2_0_0ElementType());
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2573:4: ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2573:4: ({...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2574:5: {...}? => ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2574:118: ( ({...}? => ( (lv_val2_4_0= 'kw2' ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2575:6: ({...}? => ( (lv_val2_4_0= 'kw2' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2578:9: ({...}? => ( (lv_val2_4_0= 'kw2' ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2578:10: {...}? => ( (lv_val2_4_0= 'kw2' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "true");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2578:19: ( (lv_val2_4_0= 'kw2' ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2578:20: (lv_val2_4_0= 'kw2' )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2578:20: (lv_val2_4_0= 'kw2' )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2579:10: lv_val2_4_0= 'kw2'
            	    {

            	    										markLeaf();
            	    									
            	    lv_val2_4_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleUnorderedGroupBoolean9077); 

            	    										doneLeaf(lv_val2_4_0, elementTypeProvider.getUnorderedGroupBoolean_Val2Kw2Keyword_2_1_0ElementType());
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2593:4: ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2593:4: ({...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2594:5: {...}? => ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2594:118: ( ({...}? => ( (lv_val3_5_0= 'kw3' ) ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2595:6: ({...}? => ( (lv_val3_5_0= 'kw3' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedGroupBooleanAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2598:9: ({...}? => ( (lv_val3_5_0= 'kw3' ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2598:10: {...}? => ( (lv_val3_5_0= 'kw3' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedGroupBoolean", "true");
            	    }
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2598:19: ( (lv_val3_5_0= 'kw3' ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2598:20: (lv_val3_5_0= 'kw3' )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2598:20: (lv_val3_5_0= 'kw3' )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2599:10: lv_val3_5_0= 'kw3'
            	    {

            	    										markLeaf();
            	    									
            	    lv_val3_5_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleUnorderedGroupBoolean9186); 

            	    										doneLeaf(lv_val3_5_0, elementTypeProvider.getUnorderedGroupBoolean_Val3Kw3Keyword_2_2_0ElementType());
            	    									

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
        return ;
    }
    // $ANTLR end "ruleUnorderedGroupBoolean"


    // $ANTLR start "entryRuleComplex1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2624:1: entryRuleComplex1 : ruleComplex1 EOF ;
    public final void entryRuleComplex1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2624:18: ( ruleComplex1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2625:2: ruleComplex1 EOF
            {
             markComposite(elementTypeProvider.getComplex1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleComplex1_in_entryRuleComplex19281);
            ruleComplex1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleComplex19287); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleComplex1"


    // $ANTLR start "ruleComplex1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2633:1: ruleComplex1 : (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* ) ;
    public final void ruleComplex1() throws RecognitionException {
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2633:13: ( (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2634:2: (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2634:2: (otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2635:3: otherlv_0= '#27' () (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )? (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )? ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleComplex19310); 

            			doneLeaf(otherlv_0, elementTypeProvider.getComplex1_NumberSignDigitTwoDigitSevenKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2642:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2643:4: 
            {

            				precedeComposite(elementTypeProvider.getComplex1_Complex1Action_1ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2648:3: (otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==16) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2649:4: otherlv_2= 'kw1' ( (lv_val1_3_0= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleComplex19343); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getComplex1_Kw1Keyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2656:4: ( (lv_val1_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2657:5: (lv_val1_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2657:5: (lv_val1_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2658:6: lv_val1_3_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleComplex19375); 

                    						doneLeaf(lv_val1_3_0, elementTypeProvider.getComplex1_Val1IDTerminalRuleCall_2_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2668:3: (otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==17) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2669:4: otherlv_4= 'kw2' ( (lv_val2_5_0= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleComplex19414); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getComplex1_Kw2Keyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2676:4: ( (lv_val2_5_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2677:5: (lv_val2_5_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2677:5: (lv_val2_5_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2678:6: lv_val2_5_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleComplex19446); 

                    						doneLeaf(lv_val2_5_0, elementTypeProvider.getComplex1_Val2IDTerminalRuleCall_3_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2688:3: ( (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) ) | (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) ) | (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) ) | (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2689:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2689:4: (otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2690:5: otherlv_6= 'kw3' ( (lv_val3_7_0= RULE_ID ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleComplex19492); 

            	    					doneLeaf(otherlv_6, elementTypeProvider.getComplex1_Kw3Keyword_4_0_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2697:5: ( (lv_val3_7_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2698:6: (lv_val3_7_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2698:6: (lv_val3_7_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2699:7: lv_val3_7_0= RULE_ID
            	    {

            	    							markLeaf();
            	    						
            	    lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleComplex19529); 

            	    							doneLeaf(lv_val3_7_0, elementTypeProvider.getComplex1_Val3IDTerminalRuleCall_4_0_1_0ElementType());
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2710:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2710:4: (otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2711:5: otherlv_8= 'kw4' ( (lv_val4_9_0= RULE_ID ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_8=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleComplex19583); 

            	    					doneLeaf(otherlv_8, elementTypeProvider.getComplex1_Kw4Keyword_4_1_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2718:5: ( (lv_val4_9_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2719:6: (lv_val4_9_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2719:6: (lv_val4_9_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2720:7: lv_val4_9_0= RULE_ID
            	    {

            	    							markLeaf();
            	    						
            	    lv_val4_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleComplex19620); 

            	    							doneLeaf(lv_val4_9_0, elementTypeProvider.getComplex1_Val4IDTerminalRuleCall_4_1_1_0ElementType());
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2731:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2731:4: (otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2732:5: otherlv_10= 'kw5' ( (lv_val5_11_0= RULE_ID ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_10=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleComplex19674); 

            	    					doneLeaf(otherlv_10, elementTypeProvider.getComplex1_Kw5Keyword_4_2_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2739:5: ( (lv_val5_11_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2740:6: (lv_val5_11_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2740:6: (lv_val5_11_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2741:7: lv_val5_11_0= RULE_ID
            	    {

            	    							markLeaf();
            	    						
            	    lv_val5_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleComplex19711); 

            	    							doneLeaf(lv_val5_11_0, elementTypeProvider.getComplex1_Val5IDTerminalRuleCall_4_2_1_0ElementType());
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2752:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2752:4: (otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2753:5: otherlv_12= 'kw6' ( (lv_val6_13_0= RULE_ID ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_12=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleComplex19765); 

            	    					doneLeaf(otherlv_12, elementTypeProvider.getComplex1_Kw6Keyword_4_3_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2760:5: ( (lv_val6_13_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2761:6: (lv_val6_13_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2761:6: (lv_val6_13_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2762:7: lv_val6_13_0= RULE_ID
            	    {

            	    							markLeaf();
            	    						
            	    lv_val6_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleComplex19802); 

            	    							doneLeaf(lv_val6_13_0, elementTypeProvider.getComplex1_Val6IDTerminalRuleCall_4_3_1_0ElementType());
            	    						

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
        return ;
    }
    // $ANTLR end "ruleComplex1"


    // $ANTLR start "entryRuleOptionalDouble"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2777:1: entryRuleOptionalDouble : ruleOptionalDouble EOF ;
    public final void entryRuleOptionalDouble() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2777:24: ( ruleOptionalDouble EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2778:2: ruleOptionalDouble EOF
            {
             markComposite(elementTypeProvider.getOptionalDoubleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalDouble_in_entryRuleOptionalDouble9849);
            ruleOptionalDouble();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalDouble9855); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleOptionalDouble"


    // $ANTLR start "ruleOptionalDouble"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2786:1: ruleOptionalDouble : (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? ) ;
    public final void ruleOptionalDouble() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2786:19: ( (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2787:2: (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2787:2: (otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2788:3: otherlv_0= '#28' ( (lv_double0_1_0= ruleDOUBLE ) ) ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleOptionalDouble9878); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOptionalDouble_NumberSignDigitTwoDigitEightKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2795:3: ( (lv_double0_1_0= ruleDOUBLE ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2796:4: (lv_double0_1_0= ruleDOUBLE )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2796:4: (lv_double0_1_0= ruleDOUBLE )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2797:5: lv_double0_1_0= ruleDOUBLE
            {

            					markComposite(elementTypeProvider.getOptionalDouble_Double0DOUBLEParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_ruleOptionalDouble9905);
            ruleDOUBLE();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2806:3: ( ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_INT) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2807:4: ( (lv_double1_2_0= ruleDOUBLE ) ) ( (lv_double2_3_0= ruleDOUBLE ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2807:4: ( (lv_double1_2_0= ruleDOUBLE ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2808:5: (lv_double1_2_0= ruleDOUBLE )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2808:5: (lv_double1_2_0= ruleDOUBLE )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2809:6: lv_double1_2_0= ruleDOUBLE
                    {

                    						markComposite(elementTypeProvider.getOptionalDouble_Double1DOUBLEParserRuleCall_2_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_ruleOptionalDouble9951);
                    ruleDOUBLE();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2818:4: ( (lv_double2_3_0= ruleDOUBLE ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2819:5: (lv_double2_3_0= ruleDOUBLE )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2819:5: (lv_double2_3_0= ruleDOUBLE )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2820:6: lv_double2_3_0= ruleDOUBLE
                    {

                    						markComposite(elementTypeProvider.getOptionalDouble_Double2DOUBLEParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_ruleOptionalDouble9996);
                    ruleDOUBLE();

                    state._fsp--;


                    						doneComposite();
                    					

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
        return ;
    }
    // $ANTLR end "ruleOptionalDouble"


    // $ANTLR start "entryRuleDOUBLE"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2834:1: entryRuleDOUBLE : ruleDOUBLE EOF ;
    public final void entryRuleDOUBLE() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2834:16: ( ruleDOUBLE EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2835:2: ruleDOUBLE EOF
            {
             markComposite(elementTypeProvider.getDOUBLEElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE10035);
            ruleDOUBLE();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDOUBLE10041); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2843:1: ruleDOUBLE : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final void ruleDOUBLE() throws RecognitionException {
        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2843:11: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2844:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2844:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2845:3: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {

            			markLeaf();
            		
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDOUBLE10064); 

            			doneLeaf(this_INT_0, elementTypeProvider.getDOUBLE_INTTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2852:3: (kw= '.' this_INT_2= RULE_INT )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==51) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2853:4: kw= '.' this_INT_2= RULE_INT
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleDOUBLE10084); 

                    				doneLeaf(kw, elementTypeProvider.getDOUBLE_FullStopKeyword_1_0ElementType());
                    			

                    				markLeaf();
                    			
                    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDOUBLE10101); 

                    				doneLeaf(this_INT_2, elementTypeProvider.getDOUBLE_INTTerminalRuleCall_1_1ElementType());
                    			

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
        return ;
    }
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "entryRuleNullValueGenerated"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2872:1: entryRuleNullValueGenerated : ruleNullValueGenerated EOF ;
    public final void entryRuleNullValueGenerated() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2872:28: ( ruleNullValueGenerated EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2873:2: ruleNullValueGenerated EOF
            {
             markComposite(elementTypeProvider.getNullValueGeneratedElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNullValueGenerated_in_entryRuleNullValueGenerated10127);
            ruleNullValueGenerated();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullValueGenerated10133); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNullValueGenerated"


    // $ANTLR start "ruleNullValueGenerated"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2881:1: ruleNullValueGenerated : (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) ) ;
    public final void ruleNullValueGenerated() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2881:23: ( (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2882:2: (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2882:2: (otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2883:3: otherlv_0= '#29' ( (lv_value_1_0= ruleNULL_STRING ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleNullValueGenerated10156); 

            			doneLeaf(otherlv_0, elementTypeProvider.getNullValueGenerated_NumberSignDigitTwoDigitNineKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2890:3: ( (lv_value_1_0= ruleNULL_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2891:4: (lv_value_1_0= ruleNULL_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2891:4: (lv_value_1_0= ruleNULL_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2892:5: lv_value_1_0= ruleNULL_STRING
            {

            					markComposite(elementTypeProvider.getNullValueGenerated_ValueNULL_STRINGParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleNULL_STRING_in_ruleNullValueGenerated10183);
            ruleNULL_STRING();

            state._fsp--;


            					doneComposite();
            				

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
        return ;
    }
    // $ANTLR end "ruleNullValueGenerated"


    // $ANTLR start "entryRuleNullValueInterpreted"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2905:1: entryRuleNullValueInterpreted : ruleNullValueInterpreted EOF ;
    public final void entryRuleNullValueInterpreted() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2905:30: ( ruleNullValueInterpreted EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2906:2: ruleNullValueInterpreted EOF
            {
             markComposite(elementTypeProvider.getNullValueInterpretedElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNullValueInterpreted_in_entryRuleNullValueInterpreted10214);
            ruleNullValueInterpreted();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullValueInterpreted10220); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNullValueInterpreted"


    // $ANTLR start "ruleNullValueInterpreted"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2914:1: ruleNullValueInterpreted : (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? ) ;
    public final void ruleNullValueInterpreted() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_foo_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2914:25: ( (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2915:2: (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2915:2: (otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2916:3: otherlv_0= '#30' ( (lv_value_1_0= ruleNULL_STRING ) ) ( (lv_foo_2_0= RULE_ID ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNullValueInterpreted10243); 

            			doneLeaf(otherlv_0, elementTypeProvider.getNullValueInterpreted_NumberSignDigitThreeDigitZeroKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2923:3: ( (lv_value_1_0= ruleNULL_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2924:4: (lv_value_1_0= ruleNULL_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2924:4: (lv_value_1_0= ruleNULL_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2925:5: lv_value_1_0= ruleNULL_STRING
            {

            					markComposite(elementTypeProvider.getNullValueInterpreted_ValueNULL_STRINGParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleNULL_STRING_in_ruleNullValueInterpreted10270);
            ruleNULL_STRING();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2934:3: ( (lv_foo_2_0= RULE_ID ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2935:4: (lv_foo_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2935:4: (lv_foo_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2936:5: lv_foo_2_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_foo_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNullValueInterpreted10308); 

                    					doneLeaf(lv_foo_2_0, elementTypeProvider.getNullValueInterpreted_FooIDTerminalRuleCall_2_0ElementType());
                    				

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
        return ;
    }
    // $ANTLR end "ruleNullValueInterpreted"


    // $ANTLR start "entryRuleNULL_STRING"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2949:1: entryRuleNULL_STRING : ruleNULL_STRING EOF ;
    public final void entryRuleNULL_STRING() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2949:21: ( ruleNULL_STRING EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2950:2: ruleNULL_STRING EOF
            {
             markComposite(elementTypeProvider.getNULL_STRINGElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNULL_STRING_in_entryRuleNULL_STRING10340);
            ruleNULL_STRING();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNULL_STRING10346); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNULL_STRING"


    // $ANTLR start "ruleNULL_STRING"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2958:1: ruleNULL_STRING : this_STRING_0= RULE_STRING ;
    public final void ruleNULL_STRING() throws RecognitionException {
        Token this_STRING_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2958:16: (this_STRING_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2959:2: this_STRING_0= RULE_STRING
            {

            		markLeaf();
            	
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNULL_STRING10364); 

            		doneLeaf(this_STRING_0, elementTypeProvider.getNULL_STRING_STRINGTerminalRuleCallElementType());
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleNULL_STRING"


    // $ANTLR start "entryRuleNullCrossRefGenerated"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2969:1: entryRuleNullCrossRefGenerated : ruleNullCrossRefGenerated EOF ;
    public final void entryRuleNullCrossRefGenerated() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2969:31: ( ruleNullCrossRefGenerated EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2970:2: ruleNullCrossRefGenerated EOF
            {
             markComposite(elementTypeProvider.getNullCrossRefGeneratedElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNullCrossRefGenerated_in_entryRuleNullCrossRefGenerated10380);
            ruleNullCrossRefGenerated();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullCrossRefGenerated10386); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNullCrossRefGenerated"


    // $ANTLR start "ruleNullCrossRefGenerated"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2978:1: ruleNullCrossRefGenerated : (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) ) ;
    public final void ruleNullCrossRefGenerated() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2978:26: ( (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2979:2: (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2979:2: (otherlv_0= '#31' ( (otherlv_1= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2980:3: otherlv_0= '#31' ( (otherlv_1= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleNullCrossRefGenerated10409); 

            			doneLeaf(otherlv_0, elementTypeProvider.getNullCrossRefGenerated_NumberSignDigitThreeDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2987:3: ( (otherlv_1= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2988:4: (otherlv_1= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2988:4: (otherlv_1= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:2989:5: otherlv_1= RULE_ID
            {

            					markLeaf();
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNullCrossRefGenerated10436); 

            					doneLeaf(otherlv_1, elementTypeProvider.getNullCrossRefGenerated_RefEObjectCrossReference_1_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleNullCrossRefGenerated"


    // $ANTLR start "entryRuleNullCrossRefInterpreted"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3002:1: entryRuleNullCrossRefInterpreted : ruleNullCrossRefInterpreted EOF ;
    public final void entryRuleNullCrossRefInterpreted() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3002:33: ( ruleNullCrossRefInterpreted EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3003:2: ruleNullCrossRefInterpreted EOF
            {
             markComposite(elementTypeProvider.getNullCrossRefInterpretedElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNullCrossRefInterpreted_in_entryRuleNullCrossRefInterpreted10467);
            ruleNullCrossRefInterpreted();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullCrossRefInterpreted10473); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNullCrossRefInterpreted"


    // $ANTLR start "ruleNullCrossRefInterpreted"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3011:1: ruleNullCrossRefInterpreted : (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? ) ;
    public final void ruleNullCrossRefInterpreted() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_foo_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3011:28: ( (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3012:2: (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3012:2: (otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3013:3: otherlv_0= '#32' ( (otherlv_1= RULE_ID ) ) ( (lv_foo_2_0= RULE_ID ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleNullCrossRefInterpreted10496); 

            			doneLeaf(otherlv_0, elementTypeProvider.getNullCrossRefInterpreted_NumberSignDigitThreeDigitTwoKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3020:3: ( (otherlv_1= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3021:4: (otherlv_1= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3021:4: (otherlv_1= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3022:5: otherlv_1= RULE_ID
            {

            					markLeaf();
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNullCrossRefInterpreted10523); 

            					doneLeaf(otherlv_1, elementTypeProvider.getNullCrossRefInterpreted_RefEObjectCrossReference_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3031:3: ( (lv_foo_2_0= RULE_ID ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3032:4: (lv_foo_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3032:4: (lv_foo_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3033:5: lv_foo_2_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_foo_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNullCrossRefInterpreted10561); 

                    					doneLeaf(lv_foo_2_0, elementTypeProvider.getNullCrossRefInterpreted_FooIDTerminalRuleCall_2_0ElementType());
                    				

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
        return ;
    }
    // $ANTLR end "ruleNullCrossRefInterpreted"


    // $ANTLR start "ruleDefEnum1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3046:1: ruleDefEnum1 : (enumLiteral_0= 'kw1' ) ;
    public final void ruleDefEnum1() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3046:13: ( (enumLiteral_0= 'kw1' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3047:2: (enumLiteral_0= 'kw1' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3047:2: (enumLiteral_0= 'kw1' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3048:3: enumLiteral_0= 'kw1'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDefEnum110600); 

            			doneLeaf(enumLiteral_0, elementTypeProvider.getDefEnum1_Kw1EnumLiteralDeclarationElementType());
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleDefEnum1"


    // $ANTLR start "ruleDefEnum2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3059:1: ruleDefEnum2 : (enumLiteral_0= 'kw2' ) ;
    public final void ruleDefEnum2() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3059:13: ( (enumLiteral_0= 'kw2' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3060:2: (enumLiteral_0= 'kw2' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3060:2: (enumLiteral_0= 'kw2' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3061:3: enumLiteral_0= 'kw2'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDefEnum210627); 

            			doneLeaf(enumLiteral_0, elementTypeProvider.getDefEnum2_Kw2EnumLiteralDeclarationElementType());
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleDefEnum2"


    // $ANTLR start "ruleDefEnum3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3072:1: ruleDefEnum3 : (enumLiteral_0= 'kw3' ) ;
    public final void ruleDefEnum3() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3072:13: ( (enumLiteral_0= 'kw3' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3073:2: (enumLiteral_0= 'kw3' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3073:2: (enumLiteral_0= 'kw3' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/serializer/idea/parser/antlr/internal/PsiInternalSequencerTestLanguage.g:3074:3: enumLiteral_0= 'kw3'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleDefEnum310654); 

            			doneLeaf(enumLiteral_0, elementTypeProvider.getDefEnum3_Kw3EnumLiteralDeclarationElementType());
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
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
            return "1880:3: ( ( ( (lv_val_1_0= RULE_ID ) ) ( (lv_val_2_0= RULE_ID ) )+ ) | ( ( (lv_val_3_0= RULE_ID ) )+ ( (lv_flag_4_0= 'kw1' ) ) ) )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleGroup_in_ruleModel96 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAlternative_in_ruleModel142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicities_in_ruleModel188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupMultiplicities_in_ruleModel234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeMultiplicities_in_ruleModel280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList1_in_ruleModel326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList2_in_ruleModel372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList1_in_ruleModel418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList2_in_ruleModel464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleKeywords_in_ruleModel510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleKeywordsOrID_in_ruleModel556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleTerminals_in_ruleModel602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiKeywords_in_ruleModel648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiKeywordsOrID_in_ruleModel694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiTerminals_in_ruleModel740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleEnum_in_ruleModel786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleCrossReference_in_ruleModel832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReference_in_ruleModel878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDependentAlternative1_in_ruleModel924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDependentAlternative2_in_ruleModel970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptional_in_ruleModel1016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFloat_in_ruleModel1062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedAlternative_in_ruleModel1108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_ruleModel1154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroupOptional_in_ruleModel1200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroupBoolean_in_ruleModel1246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComplex1_in_ruleModel1292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalDouble_in_ruleModel1338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullValueGenerated_in_ruleModel1384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullValueInterpreted_in_ruleModel1430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullCrossRefGenerated_in_ruleModel1476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullCrossRefInterpreted_in_ruleModel1522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup1553 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleGroup1559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSimpleGroup1582 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup1609 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup1647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative1678 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAlternative1684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSimpleAlternative1707 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_16_in_ruleSimpleAlternative1734 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative1771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSimpleAlternative1825 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative1862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities1908 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleMultiplicities1914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleSimpleMultiplicities1937 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1964 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleSimpleMultiplicities1989 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities2016 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleSimpleMultiplicities2042 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities2069 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_19_in_ruleSimpleMultiplicities2095 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities2122 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities2154 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupMultiplicities2160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleGroupMultiplicities2183 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2210 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleGroupMultiplicities2235 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2270 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2315 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleGroupMultiplicities2348 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2383 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2428 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_19_in_ruleGroupMultiplicities2461 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2496 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2541 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities2580 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeMultiplicities2586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAlternativeMultiplicities2609 = new BitSet(new long[]{0x0000000000030010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2644 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_16_in_ruleAlternativeMultiplicities2690 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2727 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleAlternativeMultiplicities2768 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2803 = new BitSet(new long[]{0x0000000000480010L});
        public static final BitSet FOLLOW_19_in_ruleAlternativeMultiplicities2849 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2886 = new BitSet(new long[]{0x0000000000480010L});
        public static final BitSet FOLLOW_22_in_ruleAlternativeMultiplicities2927 = new BitSet(new long[]{0x0000000000800012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2962 = new BitSet(new long[]{0x0000000000800012L});
        public static final BitSet FOLLOW_23_in_ruleAlternativeMultiplicities3008 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities3045 = new BitSet(new long[]{0x0000000000800012L});
        public static final BitSet FOLLOW_ruleList1_in_entryRuleList13092 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList13098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleList13121 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList13148 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleList13179 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList13211 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleList2_in_entryRuleList23250 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList23256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleList23279 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList23327 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleList23364 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList23401 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleAltList1_in_entryRuleAltList13449 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAltList13455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleAltList13478 = new BitSet(new long[]{0x0000000000030010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList13522 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList13574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleAltList13628 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList13665 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList13717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleAltList13771 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList13808 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList13860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList2_in_entryRuleAltList23907 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAltList23913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleAltList23936 = new BitSet(new long[]{0x0000000020000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList23980 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList24032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleAltList24086 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList24123 = new BitSet(new long[]{0x0000000002000010L});
        public static final BitSet FOLLOW_25_in_ruleAltList24166 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList24208 = new BitSet(new long[]{0x0000000002000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList24270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleKeywords_in_entryRuleSingleKeywords4316 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleKeywords4322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleSingleKeywords4345 = new BitSet(new long[]{0x00000000000B0000L});
        public static final BitSet FOLLOW_16_in_ruleSingleKeywords4380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSingleKeywords4414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleSingleKeywords4448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleKeywordsOrID_in_entryRuleSingleKeywordsOrID4486 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleKeywordsOrID4492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleSingleKeywordsOrID4515 = new BitSet(new long[]{0x00000000000B0010L});
        public static final BitSet FOLLOW_16_in_ruleSingleKeywordsOrID4550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSingleKeywordsOrID4584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleSingleKeywordsOrID4618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleKeywordsOrID4652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleTerminals_in_entryRuleSingleTerminals4690 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleTerminals4696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleSingleTerminals4719 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_RULE_ID1_in_ruleSingleTerminals4754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID2_in_ruleSingleTerminals4788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleEnum_in_entryRuleSingleEnum4826 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleEnum4832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSingleEnum4855 = new BitSet(new long[]{0x00000000000B0000L});
        public static final BitSet FOLLOW_ruleDefEnum1_in_ruleSingleEnum4890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefEnum2_in_ruleSingleEnum4924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefEnum3_in_ruleSingleEnum4958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleCrossReference_in_entryRuleSingleCrossReference4996 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleCrossReference5002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleSingleCrossReference5025 = new BitSet(new long[]{0x00000000000000E0L});
        public static final BitSet FOLLOW_RULE_ID1_in_ruleSingleCrossReference5060 = new BitSet(new long[]{0x00000000000000E0L});
        public static final BitSet FOLLOW_RULE_ID2_in_ruleSingleCrossReference5094 = new BitSet(new long[]{0x00000000000000E0L});
        public static final BitSet FOLLOW_RULE_ID3_in_ruleSingleCrossReference5128 = new BitSet(new long[]{0x00000000000000E0L});
        public static final BitSet FOLLOW_RULE_ID1_in_ruleSingleCrossReference5181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID2_in_ruleSingleCrossReference5235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID3_in_ruleSingleCrossReference5289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReference_in_entryRuleSingleContainmentReference5327 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleContainmentReference5333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleSingleContainmentReference5356 = new BitSet(new long[]{0x00000000000B0000L});
        public static final BitSet FOLLOW_ruleSingleContainmentReferenceChild1_in_ruleSingleContainmentReference5391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReferenceChild2_in_ruleSingleContainmentReference5425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReferenceChild3_in_ruleSingleContainmentReference5459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReferenceChild1_in_entryRuleSingleContainmentReferenceChild15497 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleContainmentReferenceChild15503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleSingleContainmentReferenceChild15532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReferenceChild2_in_entryRuleSingleContainmentReferenceChild25557 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleContainmentReferenceChild25563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSingleContainmentReferenceChild25592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleContainmentReferenceChild3_in_entryRuleSingleContainmentReferenceChild35617 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleContainmentReferenceChild35623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleSingleContainmentReferenceChild35652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiKeywords_in_entryRuleMultiKeywords5677 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiKeywords5683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleMultiKeywords5706 = new BitSet(new long[]{0x00000000000B0000L});
        public static final BitSet FOLLOW_16_in_ruleMultiKeywords5741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMultiKeywords5775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleMultiKeywords5809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiKeywordsOrID_in_entryRuleMultiKeywordsOrID5847 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiKeywordsOrID5853 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleMultiKeywordsOrID5876 = new BitSet(new long[]{0x00000000000B0010L});
        public static final BitSet FOLLOW_16_in_ruleMultiKeywordsOrID5911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMultiKeywordsOrID5945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleMultiKeywordsOrID5979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMultiKeywordsOrID6013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiTerminals_in_entryRuleMultiTerminals6051 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiTerminals6057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleMultiTerminals6080 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_RULE_ID1_in_ruleMultiTerminals6115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID2_in_ruleMultiTerminals6149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDependentAlternative1_in_entryRuleDependentAlternative16187 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDependentAlternative16193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleDependentAlternative16216 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDependentAlternative16251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDependentAlternative16314 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDependentAlternative16366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDependentAlternative2_in_entryRuleDependentAlternative26412 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDependentAlternative26418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleDependentAlternative26441 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDependentAlternative26485 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDependentAlternative26537 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDependentAlternative26609 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleDependentAlternative26662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptional_in_entryRuleOptional6708 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptional6714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleOptional6737 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleOptional6764 = new BitSet(new long[]{0x0000000000000102L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleOptional6810 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleOptional6855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFloat_in_entryRuleFloat6894 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFloat6900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleFloat6923 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleFloat6950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedAlternative_in_entryRuleUnorderedAlternative6970 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedAlternative6976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleUnorderedAlternative6999 = new BitSet(new long[]{0x0000000000030112L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnorderedAlternative7047 = new BitSet(new long[]{0x0000000000030112L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUnorderedAlternative7101 = new BitSet(new long[]{0x0000000000030112L});
        public static final BitSet FOLLOW_ruleUnorderedAlternativeVal_in_ruleUnorderedAlternative7155 = new BitSet(new long[]{0x0000000000030112L});
        public static final BitSet FOLLOW_ruleUnorderedAlternativeValDelegate_in_ruleUnorderedAlternative7209 = new BitSet(new long[]{0x0000000000030112L});
        public static final BitSet FOLLOW_ruleUnorderedAlternativeVal_in_entryRuleUnorderedAlternativeVal7248 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedAlternativeVal7254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleUnorderedAlternativeVal7277 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnorderedAlternativeVal7304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedAlternativeValDelegate_in_entryRuleUnorderedAlternativeValDelegate7335 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedAlternativeValDelegate7341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedAlternativeVal2_in_ruleUnorderedAlternativeValDelegate7357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedAlternativeVal2_in_entryRuleUnorderedAlternativeVal27373 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedAlternativeVal27379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleUnorderedAlternativeVal27402 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnorderedAlternativeVal27429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup7460 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedGroup7466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleUnorderedGroup7489 = new BitSet(new long[]{0x0000000000030110L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnorderedGroup7579 = new BitSet(new long[]{0x0000000000030112L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUnorderedGroup7688 = new BitSet(new long[]{0x0000000000030112L});
        public static final BitSet FOLLOW_ruleUnorderedGroupVal_in_ruleUnorderedGroup7797 = new BitSet(new long[]{0x0000000000030112L});
        public static final BitSet FOLLOW_ruleUnorderedGroupValDelegate_in_ruleUnorderedGroup7906 = new BitSet(new long[]{0x0000000000030112L});
        public static final BitSet FOLLOW_ruleUnorderedGroupVal_in_entryRuleUnorderedGroupVal8008 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedGroupVal8014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleUnorderedGroupVal8037 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnorderedGroupVal8064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroupValDelegate_in_entryRuleUnorderedGroupValDelegate8095 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedGroupValDelegate8101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroupVal2_in_ruleUnorderedGroupValDelegate8117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroupVal2_in_entryRuleUnorderedGroupVal28133 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedGroupVal28139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleUnorderedGroupVal28162 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnorderedGroupVal28189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroupOptional_in_entryRuleUnorderedGroupOptional8220 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedGroupOptional8226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleUnorderedGroupOptional8249 = new BitSet(new long[]{0x00000000000B0002L});
        public static final BitSet FOLLOW_16_in_ruleUnorderedGroupOptional8340 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnorderedGroupOptional8397 = new BitSet(new long[]{0x00000000000B0002L});
        public static final BitSet FOLLOW_17_in_ruleUnorderedGroupOptional8506 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnorderedGroupOptional8563 = new BitSet(new long[]{0x00000000000B0002L});
        public static final BitSet FOLLOW_19_in_ruleUnorderedGroupOptional8672 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnorderedGroupOptional8729 = new BitSet(new long[]{0x00000000000B0002L});
        public static final BitSet FOLLOW_ruleUnorderedGroupBoolean_in_entryRuleUnorderedGroupBoolean8836 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedGroupBoolean8842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleUnorderedGroupBoolean8865 = new BitSet(new long[]{0x00000000000B0002L});
        public static final BitSet FOLLOW_16_in_ruleUnorderedGroupBoolean8968 = new BitSet(new long[]{0x00000000000B0002L});
        public static final BitSet FOLLOW_17_in_ruleUnorderedGroupBoolean9077 = new BitSet(new long[]{0x00000000000B0002L});
        public static final BitSet FOLLOW_19_in_ruleUnorderedGroupBoolean9186 = new BitSet(new long[]{0x00000000000B0002L});
        public static final BitSet FOLLOW_ruleComplex1_in_entryRuleComplex19281 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleComplex19287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleComplex19310 = new BitSet(new long[]{0x0002000000CB0002L});
        public static final BitSet FOLLOW_16_in_ruleComplex19343 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleComplex19375 = new BitSet(new long[]{0x0002000000CA0002L});
        public static final BitSet FOLLOW_17_in_ruleComplex19414 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleComplex19446 = new BitSet(new long[]{0x0002000000C80002L});
        public static final BitSet FOLLOW_19_in_ruleComplex19492 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleComplex19529 = new BitSet(new long[]{0x0002000000C80002L});
        public static final BitSet FOLLOW_22_in_ruleComplex19583 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleComplex19620 = new BitSet(new long[]{0x0002000000C80002L});
        public static final BitSet FOLLOW_23_in_ruleComplex19674 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleComplex19711 = new BitSet(new long[]{0x0002000000C80002L});
        public static final BitSet FOLLOW_49_in_ruleComplex19765 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleComplex19802 = new BitSet(new long[]{0x0002000000C80002L});
        public static final BitSet FOLLOW_ruleOptionalDouble_in_entryRuleOptionalDouble9849 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalDouble9855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleOptionalDouble9878 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_ruleOptionalDouble9905 = new BitSet(new long[]{0x0000000000000102L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_ruleOptionalDouble9951 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_ruleOptionalDouble9996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE10035 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDOUBLE10041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDOUBLE10064 = new BitSet(new long[]{0x0008000000000002L});
        public static final BitSet FOLLOW_51_in_ruleDOUBLE10084 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDOUBLE10101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullValueGenerated_in_entryRuleNullValueGenerated10127 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullValueGenerated10133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleNullValueGenerated10156 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_ruleNULL_STRING_in_ruleNullValueGenerated10183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullValueInterpreted_in_entryRuleNullValueInterpreted10214 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullValueInterpreted10220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleNullValueInterpreted10243 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_ruleNULL_STRING_in_ruleNullValueInterpreted10270 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNullValueInterpreted10308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNULL_STRING_in_entryRuleNULL_STRING10340 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNULL_STRING10346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNULL_STRING10364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullCrossRefGenerated_in_entryRuleNullCrossRefGenerated10380 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullCrossRefGenerated10386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleNullCrossRefGenerated10409 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNullCrossRefGenerated10436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullCrossRefInterpreted_in_entryRuleNullCrossRefInterpreted10467 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullCrossRefInterpreted10473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleNullCrossRefInterpreted10496 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNullCrossRefInterpreted10523 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNullCrossRefInterpreted10561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleDefEnum110600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleDefEnum210627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleDefEnum310654 = new BitSet(new long[]{0x0000000000000002L});
    }


}