package org.eclipse.xtext.validation.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.validation.services.ConcreteSyntaxValidationTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalConcreteSyntaxValidationTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'kw1'", "'kw2'", "'#3'", "'kw3'", "'#4'", "'#5'", "'kw4'", "'kw5'", "'#6'", "'#7'", "'#8'", "'#9'", "'#10'", "'#11'", "'#12'", "'#13'", "'#14'", "'#15'", "'#16'", "'group'", "'#17'", "','", "'#18'", "'#19'", "'#20'", "'#21'", "'#22'", "'#23'", "'kw'", "'#24'", "'#25'", "'#26'", "'#27'", "'short'", "'one'", "'long'", "'extra'", "'two'", "'#28'", "'lit1'", "'lit2'"
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
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
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
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public PsiInternalConcreteSyntaxValidationTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalConcreteSyntaxValidationTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalConcreteSyntaxValidationTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g"; }



    	protected ConcreteSyntaxValidationTestLanguageGrammarAccess grammarAccess;

    	protected ConcreteSyntaxValidationTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalConcreteSyntaxValidationTestLanguageParser(PsiBuilder builder, TokenStream input, ConcreteSyntaxValidationTestLanguageElementTypeProvider elementTypeProvider, ConcreteSyntaxValidationTestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:51:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:59:1: ruleModel : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:59:10: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:60:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:60:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )
            int alt1=28;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 15:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            case 18:
                {
                alt1=5;
                }
                break;
            case 21:
                {
                alt1=6;
                }
                break;
            case 22:
                {
                alt1=7;
                }
                break;
            case 23:
                {
                alt1=8;
                }
                break;
            case 24:
                {
                alt1=9;
                }
                break;
            case 25:
                {
                alt1=10;
                }
                break;
            case 26:
                {
                alt1=11;
                }
                break;
            case 27:
                {
                alt1=12;
                }
                break;
            case 28:
                {
                alt1=13;
                }
                break;
            case 29:
                {
                alt1=14;
                }
                break;
            case 30:
                {
                alt1=15;
                }
                break;
            case 31:
                {
                alt1=16;
                }
                break;
            case 33:
                {
                alt1=17;
                }
                break;
            case 35:
                {
                alt1=18;
                }
                break;
            case 16:
            case 36:
                {
                alt1=19;
                }
                break;
            case 37:
                {
                alt1=20;
                }
                break;
            case 38:
                {
                alt1=21;
                }
                break;
            case 39:
                {
                alt1=22;
                }
                break;
            case 40:
                {
                alt1=23;
                }
                break;
            case 42:
                {
                alt1=24;
                }
                break;
            case 43:
                {
                alt1=25;
                }
                break;
            case 44:
                {
                alt1=26;
                }
                break;
            case 45:
                {
                alt1=27;
                }
                break;
            case 51:
                {
                alt1=28;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:61:3: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:61:3: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:62:4: (lv_x1_0_0= ruleSimpleGroup )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:62:4: (lv_x1_0_0= ruleSimpleGroup )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:63:5: lv_x1_0_0= ruleSimpleGroup
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:73:3: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:73:3: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:74:4: (lv_x2_1_0= ruleSimpleAlternative )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:74:4: (lv_x2_1_0= ruleSimpleAlternative )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:75:5: lv_x2_1_0= ruleSimpleAlternative
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:85:3: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:85:3: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:86:4: (lv_x3_2_0= ruleSimpleMultiplicities )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:86:4: (lv_x3_2_0= ruleSimpleMultiplicities )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:87:5: lv_x3_2_0= ruleSimpleMultiplicities
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:97:3: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:97:3: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:98:4: (lv_x4_3_0= ruleGroupMultiplicities )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:98:4: (lv_x4_3_0= ruleGroupMultiplicities )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:99:5: lv_x4_3_0= ruleGroupMultiplicities
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:109:3: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:109:3: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:110:4: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:110:4: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:111:5: lv_x5_4_0= ruleAlternativeMultiplicities
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:121:3: ( (lv_x6_5_0= ruleAssignedAction ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:121:3: ( (lv_x6_5_0= ruleAssignedAction ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:122:4: (lv_x6_5_0= ruleAssignedAction )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:122:4: (lv_x6_5_0= ruleAssignedAction )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:123:5: lv_x6_5_0= ruleAssignedAction
                    {

                    					markComposite(elementTypeProvider.getModel_X6AssignedActionParserRuleCall_5_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleAssignedAction_in_ruleModel326);
                    ruleAssignedAction();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:133:3: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:133:3: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:134:4: (lv_x7_6_0= ruleAssignedActionSecond )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:134:4: (lv_x7_6_0= ruleAssignedActionSecond )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:135:5: lv_x7_6_0= ruleAssignedActionSecond
                    {

                    					markComposite(elementTypeProvider.getModel_X7AssignedActionSecondParserRuleCall_6_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleAssignedActionSecond_in_ruleModel372);
                    ruleAssignedActionSecond();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:145:3: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:145:3: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:146:4: (lv_x8_7_0= ruleUnassignedAction1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:146:4: (lv_x8_7_0= ruleUnassignedAction1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:147:5: lv_x8_7_0= ruleUnassignedAction1
                    {

                    					markComposite(elementTypeProvider.getModel_X8UnassignedAction1ParserRuleCall_7_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction1_in_ruleModel418);
                    ruleUnassignedAction1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 9 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:157:3: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:157:3: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:158:4: (lv_x9_8_0= ruleUnassignedAction2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:158:4: (lv_x9_8_0= ruleUnassignedAction2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:159:5: lv_x9_8_0= ruleUnassignedAction2
                    {

                    					markComposite(elementTypeProvider.getModel_X9UnassignedAction2ParserRuleCall_8_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction2_in_ruleModel464);
                    ruleUnassignedAction2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 10 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:169:3: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:169:3: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:170:4: (lv_x10_9_0= ruleUnassignedAction3 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:170:4: (lv_x10_9_0= ruleUnassignedAction3 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:171:5: lv_x10_9_0= ruleUnassignedAction3
                    {

                    					markComposite(elementTypeProvider.getModel_X10UnassignedAction3ParserRuleCall_9_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction3_in_ruleModel510);
                    ruleUnassignedAction3();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 11 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:181:3: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:181:3: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:182:4: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:182:4: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:183:5: lv_x11_10_0= ruleUnassignedRuleCall1
                    {

                    					markComposite(elementTypeProvider.getModel_X11UnassignedRuleCall1ParserRuleCall_10_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1_in_ruleModel556);
                    ruleUnassignedRuleCall1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 12 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:193:3: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:193:3: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:194:4: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:194:4: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:195:5: lv_x12_11_0= ruleUnassignedRuleCall2
                    {

                    					markComposite(elementTypeProvider.getModel_X12UnassignedRuleCall2ParserRuleCall_11_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2_in_ruleModel602);
                    ruleUnassignedRuleCall2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 13 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:205:3: ( (lv_x13_12_0= ruleCombination1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:205:3: ( (lv_x13_12_0= ruleCombination1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:206:4: (lv_x13_12_0= ruleCombination1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:206:4: (lv_x13_12_0= ruleCombination1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:207:5: lv_x13_12_0= ruleCombination1
                    {

                    					markComposite(elementTypeProvider.getModel_X13Combination1ParserRuleCall_12_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleCombination1_in_ruleModel648);
                    ruleCombination1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 14 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:217:3: ( (lv_x14_13_0= ruleCombination2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:217:3: ( (lv_x14_13_0= ruleCombination2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:218:4: (lv_x14_13_0= ruleCombination2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:218:4: (lv_x14_13_0= ruleCombination2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:219:5: lv_x14_13_0= ruleCombination2
                    {

                    					markComposite(elementTypeProvider.getModel_X14Combination2ParserRuleCall_13_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleCombination2_in_ruleModel694);
                    ruleCombination2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 15 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:229:3: ( (lv_x15_14_0= ruleCombination3 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:229:3: ( (lv_x15_14_0= ruleCombination3 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:230:4: (lv_x15_14_0= ruleCombination3 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:230:4: (lv_x15_14_0= ruleCombination3 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:231:5: lv_x15_14_0= ruleCombination3
                    {

                    					markComposite(elementTypeProvider.getModel_X15Combination3ParserRuleCall_14_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleCombination3_in_ruleModel740);
                    ruleCombination3();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 16 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:241:3: ( (lv_x16_15_0= ruleCombination4 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:241:3: ( (lv_x16_15_0= ruleCombination4 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:242:4: (lv_x16_15_0= ruleCombination4 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:242:4: (lv_x16_15_0= ruleCombination4 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:243:5: lv_x16_15_0= ruleCombination4
                    {

                    					markComposite(elementTypeProvider.getModel_X16Combination4ParserRuleCall_15_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleCombination4_in_ruleModel786);
                    ruleCombination4();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 17 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:253:3: ( (lv_x17_16_0= ruleList1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:253:3: ( (lv_x17_16_0= ruleList1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:254:4: (lv_x17_16_0= ruleList1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:254:4: (lv_x17_16_0= ruleList1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:255:5: lv_x17_16_0= ruleList1
                    {

                    					markComposite(elementTypeProvider.getModel_X17List1ParserRuleCall_16_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleList1_in_ruleModel832);
                    ruleList1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 18 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:265:3: ( (lv_x18_17_0= ruleList2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:265:3: ( (lv_x18_17_0= ruleList2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:266:4: (lv_x18_17_0= ruleList2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:266:4: (lv_x18_17_0= ruleList2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:267:5: lv_x18_17_0= ruleList2
                    {

                    					markComposite(elementTypeProvider.getModel_X18List2ParserRuleCall_17_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleList2_in_ruleModel878);
                    ruleList2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 19 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:277:3: ( (lv_x19_18_0= ruleList3 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:277:3: ( (lv_x19_18_0= ruleList3 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:278:4: (lv_x19_18_0= ruleList3 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:278:4: (lv_x19_18_0= ruleList3 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:279:5: lv_x19_18_0= ruleList3
                    {

                    					markComposite(elementTypeProvider.getModel_X19List3ParserRuleCall_18_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleList3_in_ruleModel924);
                    ruleList3();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 20 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:289:3: ( (lv_x20_19_0= ruleList4 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:289:3: ( (lv_x20_19_0= ruleList4 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:290:4: (lv_x20_19_0= ruleList4 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:290:4: (lv_x20_19_0= ruleList4 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:291:5: lv_x20_19_0= ruleList4
                    {

                    					markComposite(elementTypeProvider.getModel_X20List4ParserRuleCall_19_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleList4_in_ruleModel970);
                    ruleList4();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 21 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:301:3: ( (lv_x21_20_0= ruleList5 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:301:3: ( (lv_x21_20_0= ruleList5 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:302:4: (lv_x21_20_0= ruleList5 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:302:4: (lv_x21_20_0= ruleList5 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:303:5: lv_x21_20_0= ruleList5
                    {

                    					markComposite(elementTypeProvider.getModel_X21List5ParserRuleCall_20_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleList5_in_ruleModel1016);
                    ruleList5();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 22 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:313:3: ( (lv_x22_21_0= ruleAltList1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:313:3: ( (lv_x22_21_0= ruleAltList1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:314:4: (lv_x22_21_0= ruleAltList1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:314:4: (lv_x22_21_0= ruleAltList1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:315:5: lv_x22_21_0= ruleAltList1
                    {

                    					markComposite(elementTypeProvider.getModel_X22AltList1ParserRuleCall_21_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleAltList1_in_ruleModel1062);
                    ruleAltList1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 23 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:325:3: ( (lv_x23_22_0= ruleAltList2 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:325:3: ( (lv_x23_22_0= ruleAltList2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:326:4: (lv_x23_22_0= ruleAltList2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:326:4: (lv_x23_22_0= ruleAltList2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:327:5: lv_x23_22_0= ruleAltList2
                    {

                    					markComposite(elementTypeProvider.getModel_X23AltList2ParserRuleCall_22_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleAltList2_in_ruleModel1108);
                    ruleAltList2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 24 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:337:3: ( (lv_x24_23_0= ruleTransientObject ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:337:3: ( (lv_x24_23_0= ruleTransientObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:338:4: (lv_x24_23_0= ruleTransientObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:338:4: (lv_x24_23_0= ruleTransientObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:339:5: lv_x24_23_0= ruleTransientObject
                    {

                    					markComposite(elementTypeProvider.getModel_X24TransientObjectParserRuleCall_23_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleTransientObject_in_ruleModel1154);
                    ruleTransientObject();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 25 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:349:3: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:349:3: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:350:4: (lv_x25_24_0= ruleTransientSerializeables1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:350:4: (lv_x25_24_0= ruleTransientSerializeables1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:351:5: lv_x25_24_0= ruleTransientSerializeables1
                    {

                    					markComposite(elementTypeProvider.getModel_X25TransientSerializeables1ParserRuleCall_24_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleTransientSerializeables1_in_ruleModel1200);
                    ruleTransientSerializeables1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 26 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:361:3: ( (lv_x26_25_0= ruleStaticSimplification ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:361:3: ( (lv_x26_25_0= ruleStaticSimplification ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:362:4: (lv_x26_25_0= ruleStaticSimplification )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:362:4: (lv_x26_25_0= ruleStaticSimplification )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:363:5: lv_x26_25_0= ruleStaticSimplification
                    {

                    					markComposite(elementTypeProvider.getModel_X26StaticSimplificationParserRuleCall_25_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleStaticSimplification_in_ruleModel1246);
                    ruleStaticSimplification();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 27 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:373:3: ( (lv_x27_26_0= ruleTwoVersion ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:373:3: ( (lv_x27_26_0= ruleTwoVersion ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:374:4: (lv_x27_26_0= ruleTwoVersion )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:374:4: (lv_x27_26_0= ruleTwoVersion )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:375:5: lv_x27_26_0= ruleTwoVersion
                    {

                    					markComposite(elementTypeProvider.getModel_X27TwoVersionParserRuleCall_26_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleTwoVersion_in_ruleModel1292);
                    ruleTwoVersion();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 28 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:385:3: ( (lv_x28_27_0= ruleHeuristic1 ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:385:3: ( (lv_x28_27_0= ruleHeuristic1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:386:4: (lv_x28_27_0= ruleHeuristic1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:386:4: (lv_x28_27_0= ruleHeuristic1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:387:5: lv_x28_27_0= ruleHeuristic1
                    {

                    					markComposite(elementTypeProvider.getModel_X28Heuristic1ParserRuleCall_27_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleHeuristic1_in_ruleModel1338);
                    ruleHeuristic1();

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:400:1: entryRuleSimpleGroup : ruleSimpleGroup EOF ;
    public final void entryRuleSimpleGroup() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:400:21: ( ruleSimpleGroup EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:401:2: ruleSimpleGroup EOF
            {
             markComposite(elementTypeProvider.getSimpleGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup1369);
            ruleSimpleGroup();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleGroup1375); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:409:1: ruleSimpleGroup : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final void ruleSimpleGroup() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:409:16: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:410:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:410:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:411:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSimpleGroup1398); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSimpleGroup_NumberSignDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:418:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:419:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:419:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:420:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup1425); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getSimpleGroup_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:429:3: ( (lv_val2_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:430:4: (lv_val2_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:430:4: (lv_val2_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:431:5: lv_val2_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup1463); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:444:1: entryRuleSimpleAlternative : ruleSimpleAlternative EOF ;
    public final void entryRuleSimpleAlternative() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:444:27: ( ruleSimpleAlternative EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:445:2: ruleSimpleAlternative EOF
            {
             markComposite(elementTypeProvider.getSimpleAlternativeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative1494);
            ruleSimpleAlternative();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleAlternative1500); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:453:1: ruleSimpleAlternative : (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final void ruleSimpleAlternative() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val2_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:453:22: ( (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:454:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:454:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:455:3: otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSimpleAlternative1523); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSimpleAlternative_NumberSignDigitTwoKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:462:3: ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:463:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:463:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:464:5: otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSimpleAlternative1550); 

                    					doneLeaf(otherlv_1, elementTypeProvider.getSimpleAlternative_Kw1Keyword_1_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:471:5: ( (lv_val1_2_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:472:6: (lv_val1_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:472:6: (lv_val1_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:473:7: lv_val1_2_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative1587); 

                    							doneLeaf(lv_val1_2_0, elementTypeProvider.getSimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:484:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:484:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:485:5: otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSimpleAlternative1641); 

                    					doneLeaf(otherlv_3, elementTypeProvider.getSimpleAlternative_Kw2Keyword_1_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:492:5: ( (lv_val2_4_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:493:6: (lv_val2_4_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:493:6: (lv_val2_4_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:494:7: lv_val2_4_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val2_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative1678); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:509:1: entryRuleSimpleMultiplicities : ruleSimpleMultiplicities EOF ;
    public final void entryRuleSimpleMultiplicities() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:509:30: ( ruleSimpleMultiplicities EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:510:2: ruleSimpleMultiplicities EOF
            {
             markComposite(elementTypeProvider.getSimpleMultiplicitiesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities1724);
            ruleSimpleMultiplicities();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleMultiplicities1730); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:518:1: ruleSimpleMultiplicities : (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:518:25: ( (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:519:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:519:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:520:3: otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSimpleMultiplicities1753); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSimpleMultiplicities_NumberSignDigitThreeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:527:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:528:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:528:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:529:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1780); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getSimpleMultiplicities_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSimpleMultiplicities1805); 

            			doneLeaf(otherlv_2, elementTypeProvider.getSimpleMultiplicities_Kw1Keyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:545:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:546:4: (lv_val2_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:546:4: (lv_val2_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:547:5: lv_val2_3_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1832); 

                    					doneLeaf(lv_val2_3_0, elementTypeProvider.getSimpleMultiplicities_Val2IDTerminalRuleCall_3_0ElementType());
                    				

                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSimpleMultiplicities1858); 

            			doneLeaf(otherlv_4, elementTypeProvider.getSimpleMultiplicities_Kw2Keyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:563:3: ( (lv_val3_5_0= RULE_ID ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:564:4: (lv_val3_5_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:564:4: (lv_val3_5_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:565:5: lv_val3_5_0= RULE_ID
            	    {

            	    					markLeaf();
            	    				
            	    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1885); 

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
            		
            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSimpleMultiplicities1911); 

            			doneLeaf(otherlv_6, elementTypeProvider.getSimpleMultiplicities_Kw3Keyword_6ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:581:3: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:582:4: (lv_val4_7_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:582:4: (lv_val4_7_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:583:5: lv_val4_7_0= RULE_ID
            	    {

            	    					markLeaf();
            	    				
            	    lv_val4_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1938); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:596:1: entryRuleGroupMultiplicities : ruleGroupMultiplicities EOF ;
    public final void entryRuleGroupMultiplicities() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:596:29: ( ruleGroupMultiplicities EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:597:2: ruleGroupMultiplicities EOF
            {
             markComposite(elementTypeProvider.getGroupMultiplicitiesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities1970);
            ruleGroupMultiplicities();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupMultiplicities1976); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:605:1: ruleGroupMultiplicities : (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:605:24: ( (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:606:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:606:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:607:3: otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGroupMultiplicities1999); 

            			doneLeaf(otherlv_0, elementTypeProvider.getGroupMultiplicities_NumberSignDigitFourKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:614:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:615:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:615:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:616:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2026); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getGroupMultiplicities_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGroupMultiplicities2051); 

            			doneLeaf(otherlv_2, elementTypeProvider.getGroupMultiplicities_Kw1Keyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:632:3: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:633:4: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:633:4: ( (lv_val2_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:634:5: (lv_val2_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:634:5: (lv_val2_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:635:6: lv_val2_3_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2086); 

                    						doneLeaf(lv_val2_3_0, elementTypeProvider.getGroupMultiplicities_Val2IDTerminalRuleCall_3_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:644:4: ( (lv_val3_4_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:645:5: (lv_val3_4_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:645:5: (lv_val3_4_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:646:6: lv_val3_4_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2131); 

                    						doneLeaf(lv_val3_4_0, elementTypeProvider.getGroupMultiplicities_Val3IDTerminalRuleCall_3_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleGroupMultiplicities2164); 

            			doneLeaf(otherlv_5, elementTypeProvider.getGroupMultiplicities_Kw2Keyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:663:3: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:664:4: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:664:4: ( (lv_val4_6_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:665:5: (lv_val4_6_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:665:5: (lv_val4_6_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:666:6: lv_val4_6_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2199); 

            	    						doneLeaf(lv_val4_6_0, elementTypeProvider.getGroupMultiplicities_Val4IDTerminalRuleCall_5_0_0ElementType());
            	    					

            	    }


            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:675:4: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:676:5: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:676:5: (lv_val5_7_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:677:6: lv_val5_7_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2244); 

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
            		
            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleGroupMultiplicities2277); 

            			doneLeaf(otherlv_8, elementTypeProvider.getGroupMultiplicities_Kw3Keyword_6ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:694:3: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:695:4: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:695:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:696:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:696:5: (lv_val6_9_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:697:6: lv_val6_9_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2312); 

            	    						doneLeaf(lv_val6_9_0, elementTypeProvider.getGroupMultiplicities_Val6IDTerminalRuleCall_7_0_0ElementType());
            	    					

            	    }


            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:706:4: ( (lv_val7_10_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:707:5: (lv_val7_10_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:707:5: (lv_val7_10_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:708:6: lv_val7_10_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val7_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities2357); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:722:1: entryRuleAlternativeMultiplicities : ruleAlternativeMultiplicities EOF ;
    public final void entryRuleAlternativeMultiplicities() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:722:35: ( ruleAlternativeMultiplicities EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:723:2: ruleAlternativeMultiplicities EOF
            {
             markComposite(elementTypeProvider.getAlternativeMultiplicitiesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities2396);
            ruleAlternativeMultiplicities();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeMultiplicities2402); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:731:1: ruleAlternativeMultiplicities : (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:731:30: ( (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:732:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:732:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:733:3: otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAlternativeMultiplicities2425); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAlternativeMultiplicities_NumberSignDigitFiveKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:740:3: ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==13) ) {
                alt9=2;
            }
            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:741:4: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:741:4: ( (lv_val2_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:742:5: (lv_val2_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:742:5: (lv_val2_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:743:6: lv_val2_1_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2460); 

                    						doneLeaf(lv_val2_1_0, elementTypeProvider.getAlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:753:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:753:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:754:5: otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAlternativeMultiplicities2506); 

                    					doneLeaf(otherlv_2, elementTypeProvider.getAlternativeMultiplicities_Kw1Keyword_1_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:761:5: ( (lv_val3_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:762:6: (lv_val3_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:762:6: (lv_val3_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:763:7: lv_val3_3_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2543); 

                    							doneLeaf(lv_val3_3_0, elementTypeProvider.getAlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAlternativeMultiplicities2584); 

            			doneLeaf(otherlv_4, elementTypeProvider.getAlternativeMultiplicities_Kw2Keyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:781:3: ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }
                else if ( (LA10_0==16) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:782:4: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:782:4: ( (lv_val4_5_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:783:5: (lv_val4_5_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:783:5: (lv_val4_5_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:784:6: lv_val4_5_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2619); 

            	    						doneLeaf(lv_val4_5_0, elementTypeProvider.getAlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:794:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:794:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:795:5: otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleAlternativeMultiplicities2665); 

            	    					doneLeaf(otherlv_6, elementTypeProvider.getAlternativeMultiplicities_Kw3Keyword_3_1_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:802:5: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:803:6: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:803:6: (lv_val5_7_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:804:7: lv_val5_7_0= RULE_ID
            	    {

            	    							markLeaf();
            	    						
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2702); 

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
            		
            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAlternativeMultiplicities2743); 

            			doneLeaf(otherlv_8, elementTypeProvider.getAlternativeMultiplicities_Kw4Keyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:822:3: ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }
                else if ( (LA11_0==20) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:823:4: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:823:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:824:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:824:5: (lv_val6_9_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:825:6: lv_val6_9_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2778); 

            	    						doneLeaf(lv_val6_9_0, elementTypeProvider.getAlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:835:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:835:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:836:5: otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAlternativeMultiplicities2824); 

            	    					doneLeaf(otherlv_10, elementTypeProvider.getAlternativeMultiplicities_Kw5Keyword_5_1_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:843:5: ( (lv_val7_11_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:844:6: (lv_val7_11_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:844:6: (lv_val7_11_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:845:7: lv_val7_11_0= RULE_ID
            	    {

            	    							markLeaf();
            	    						
            	    lv_val7_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2861); 

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


    // $ANTLR start "entryRuleAssignedAction"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:860:1: entryRuleAssignedAction : ruleAssignedAction EOF ;
    public final void entryRuleAssignedAction() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:860:24: ( ruleAssignedAction EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:861:2: ruleAssignedAction EOF
            {
             markComposite(elementTypeProvider.getAssignedActionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignedAction_in_entryRuleAssignedAction2908);
            ruleAssignedAction();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignedAction2914); 

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
    // $ANTLR end "entryRuleAssignedAction"


    // $ANTLR start "ruleAssignedAction"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:869:1: ruleAssignedAction : (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) ;
    public final void ruleAssignedAction() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:869:19: ( (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:870:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:870:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:871:3: otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAssignedAction2937); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAssignedAction_NumberSignDigitSixKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:878:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:879:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:879:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:880:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedAction2964); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getAssignedAction_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:889:3: ( () ( (lv_val1_3_0= RULE_ID ) ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:890:4: () ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:890:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:891:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAssignedAction_AssignedActionChildAction_2_0ElementType());
            	    					doneComposite();
            	    				

            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:896:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:897:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:897:5: (lv_val1_3_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:898:6: lv_val1_3_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedAction3026); 

            	    						doneLeaf(lv_val1_3_0, elementTypeProvider.getAssignedAction_Val1IDTerminalRuleCall_2_1_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
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
    // $ANTLR end "ruleAssignedAction"


    // $ANTLR start "entryRuleAssignedActionSecond"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:912:1: entryRuleAssignedActionSecond : ruleAssignedActionSecond EOF ;
    public final void entryRuleAssignedActionSecond() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:912:30: ( ruleAssignedActionSecond EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:913:2: ruleAssignedActionSecond EOF
            {
             markComposite(elementTypeProvider.getAssignedActionSecondElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignedActionSecond_in_entryRuleAssignedActionSecond3065);
            ruleAssignedActionSecond();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignedActionSecond3071); 

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
    // $ANTLR end "entryRuleAssignedActionSecond"


    // $ANTLR start "ruleAssignedActionSecond"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:921:1: ruleAssignedActionSecond : (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) ;
    public final void ruleAssignedActionSecond() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:921:25: ( (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:922:2: (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:922:2: (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:923:3: otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleAssignedActionSecond3094); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAssignedActionSecond_NumberSignDigitSevenKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:930:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:931:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:931:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:932:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedActionSecond3121); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getAssignedActionSecond_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAssignedActionSecond3146); 

            			doneLeaf(otherlv_2, elementTypeProvider.getAssignedActionSecond_Kw1Keyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:948:3: ( (lv_val2_3_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:949:4: (lv_val2_3_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:949:4: (lv_val2_3_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:950:5: lv_val2_3_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedActionSecond3173); 

            					doneLeaf(lv_val2_3_0, elementTypeProvider.getAssignedActionSecond_Val2IDTerminalRuleCall_3_0ElementType());
            				

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
    // $ANTLR end "ruleAssignedActionSecond"


    // $ANTLR start "entryRuleUnassignedAction1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:963:1: entryRuleUnassignedAction1 : ruleUnassignedAction1 EOF ;
    public final void entryRuleUnassignedAction1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:963:27: ( ruleUnassignedAction1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:964:2: ruleUnassignedAction1 EOF
            {
             markComposite(elementTypeProvider.getUnassignedAction1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction1_in_entryRuleUnassignedAction13204);
            ruleUnassignedAction1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction13210); 

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
    // $ANTLR end "entryRuleUnassignedAction1"


    // $ANTLR start "ruleUnassignedAction1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:972:1: ruleUnassignedAction1 : ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final void ruleUnassignedAction1() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:972:22: ( ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:973:2: ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:973:2: ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:974:3: () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:974:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:975:4: 
            {

            				precedeComposite(elementTypeProvider.getUnassignedAction1_UnassignedAction1Action_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleUnassignedAction13246); 

            			doneLeaf(otherlv_1, elementTypeProvider.getUnassignedAction1_NumberSignDigitEightKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:987:3: ( (lv_val1_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:988:4: (lv_val1_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:988:4: (lv_val1_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:989:5: lv_val1_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction13273); 

            					doneLeaf(lv_val1_2_0, elementTypeProvider.getUnassignedAction1_Val1IDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:998:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:999:4: (lv_val2_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:999:4: (lv_val2_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1000:5: lv_val2_3_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction13311); 

                    					doneLeaf(lv_val2_3_0, elementTypeProvider.getUnassignedAction1_Val2IDTerminalRuleCall_3_0ElementType());
                    				

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
    // $ANTLR end "ruleUnassignedAction1"


    // $ANTLR start "entryRuleUnassignedAction2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1013:1: entryRuleUnassignedAction2 : ruleUnassignedAction2 EOF ;
    public final void entryRuleUnassignedAction2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1013:27: ( ruleUnassignedAction2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1014:2: ruleUnassignedAction2 EOF
            {
             markComposite(elementTypeProvider.getUnassignedAction2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction2_in_entryRuleUnassignedAction23343);
            ruleUnassignedAction2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction23349); 

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
    // $ANTLR end "entryRuleUnassignedAction2"


    // $ANTLR start "ruleUnassignedAction2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1022:1: ruleUnassignedAction2 : ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final void ruleUnassignedAction2() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1022:22: ( ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1023:2: ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1023:2: ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1024:3: () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1024:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1025:4: 
            {

            				precedeComposite(elementTypeProvider.getUnassignedAction2_UnassignedAction2SubAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleUnassignedAction23385); 

            			doneLeaf(otherlv_1, elementTypeProvider.getUnassignedAction2_NumberSignDigitNineKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1037:3: ( (lv_val1_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1038:4: (lv_val1_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1038:4: (lv_val1_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1039:5: lv_val1_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction23412); 

            					doneLeaf(lv_val1_2_0, elementTypeProvider.getUnassignedAction2_Val1IDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1048:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1049:4: (lv_val2_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1049:4: (lv_val2_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1050:5: lv_val2_3_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction23450); 

                    					doneLeaf(lv_val2_3_0, elementTypeProvider.getUnassignedAction2_Val2IDTerminalRuleCall_3_0ElementType());
                    				

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
    // $ANTLR end "ruleUnassignedAction2"


    // $ANTLR start "entryRuleUnassignedAction3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1063:1: entryRuleUnassignedAction3 : ruleUnassignedAction3 EOF ;
    public final void entryRuleUnassignedAction3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1063:27: ( ruleUnassignedAction3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1064:2: ruleUnassignedAction3 EOF
            {
             markComposite(elementTypeProvider.getUnassignedAction3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction3_in_entryRuleUnassignedAction33482);
            ruleUnassignedAction3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction33488); 

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
    // $ANTLR end "entryRuleUnassignedAction3"


    // $ANTLR start "ruleUnassignedAction3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1072:1: ruleUnassignedAction3 : (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) ;
    public final void ruleUnassignedAction3() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_val1_5_0=null;
        Token lv_val2_6_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1072:22: ( (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1073:2: (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1073:2: (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1074:3: otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleUnassignedAction33511); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnassignedAction3_NumberSignDigitOneDigitZeroKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1081:3: ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            else if ( (LA15_0==14) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1082:4: (otherlv_1= 'kw1' () )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1082:4: (otherlv_1= 'kw1' () )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1083:5: otherlv_1= 'kw1' ()
                    {

                    					markLeaf();
                    				
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleUnassignedAction33538); 

                    					doneLeaf(otherlv_1, elementTypeProvider.getUnassignedAction3_Kw1Keyword_1_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1090:5: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1091:6: 
                    {

                    						precedeComposite(elementTypeProvider.getUnassignedAction3_UnassignedAction2Sub1Action_1_0_1ElementType());
                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1098:4: (otherlv_3= 'kw2' () )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1098:4: (otherlv_3= 'kw2' () )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1099:5: otherlv_3= 'kw2' ()
                    {

                    					markLeaf();
                    				
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleUnassignedAction33596); 

                    					doneLeaf(otherlv_3, elementTypeProvider.getUnassignedAction3_Kw2Keyword_1_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1106:5: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1107:6: 
                    {

                    						precedeComposite(elementTypeProvider.getUnassignedAction3_UnassignedAction2Sub2Action_1_1_1ElementType());
                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1114:3: ( (lv_val1_5_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1115:4: (lv_val1_5_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1115:4: (lv_val1_5_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1116:5: lv_val1_5_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction33653); 

            					doneLeaf(lv_val1_5_0, elementTypeProvider.getUnassignedAction3_Val1IDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1125:3: ( (lv_val2_6_0= RULE_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1126:4: (lv_val2_6_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1126:4: (lv_val2_6_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1127:5: lv_val2_6_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_val2_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction33691); 

                    					doneLeaf(lv_val2_6_0, elementTypeProvider.getUnassignedAction3_Val2IDTerminalRuleCall_3_0ElementType());
                    				

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
    // $ANTLR end "ruleUnassignedAction3"


    // $ANTLR start "entryRuleUnassignedRuleCall1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1140:1: entryRuleUnassignedRuleCall1 : ruleUnassignedRuleCall1 EOF ;
    public final void entryRuleUnassignedRuleCall1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1140:29: ( ruleUnassignedRuleCall1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1141:2: ruleUnassignedRuleCall1 EOF
            {
             markComposite(elementTypeProvider.getUnassignedRuleCall1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1_in_entryRuleUnassignedRuleCall13723);
            ruleUnassignedRuleCall1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall13729); 

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
    // $ANTLR end "entryRuleUnassignedRuleCall1"


    // $ANTLR start "ruleUnassignedRuleCall1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1149:1: ruleUnassignedRuleCall1 : (otherlv_0= '#11' ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final void ruleUnassignedRuleCall1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val2_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1149:24: ( (otherlv_0= '#11' ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1150:2: (otherlv_0= '#11' ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1150:2: (otherlv_0= '#11' ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1151:3: otherlv_0= '#11' ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleUnassignedRuleCall13752); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnassignedRuleCall1_NumberSignDigitOneDigitOneKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getUnassignedRuleCall1_UnassignedRuleCall1SubParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1Sub_in_ruleUnassignedRuleCall13764);
            ruleUnassignedRuleCall1Sub();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1165:3: ( (lv_val2_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1166:4: (lv_val2_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1166:4: (lv_val2_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1167:5: lv_val2_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall13791); 

            					doneLeaf(lv_val2_2_0, elementTypeProvider.getUnassignedRuleCall1_Val2IDTerminalRuleCall_2_0ElementType());
            				

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
    // $ANTLR end "ruleUnassignedRuleCall1"


    // $ANTLR start "entryRuleUnassignedRuleCall1Sub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1180:1: entryRuleUnassignedRuleCall1Sub : ruleUnassignedRuleCall1Sub EOF ;
    public final void entryRuleUnassignedRuleCall1Sub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1180:32: ( ruleUnassignedRuleCall1Sub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1181:2: ruleUnassignedRuleCall1Sub EOF
            {
             markComposite(elementTypeProvider.getUnassignedRuleCall1SubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1Sub_in_entryRuleUnassignedRuleCall1Sub3822);
            ruleUnassignedRuleCall1Sub();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall1Sub3828); 

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
    // $ANTLR end "entryRuleUnassignedRuleCall1Sub"


    // $ANTLR start "ruleUnassignedRuleCall1Sub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1189:1: ruleUnassignedRuleCall1Sub : ( (lv_val1_0_0= RULE_ID ) ) ;
    public final void ruleUnassignedRuleCall1Sub() throws RecognitionException {
        Token lv_val1_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1189:27: ( ( (lv_val1_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1190:2: ( (lv_val1_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1190:2: ( (lv_val1_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1191:3: (lv_val1_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1191:3: (lv_val1_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1192:4: lv_val1_0_0= RULE_ID
            {

            				markLeaf();
            			
            lv_val1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall1Sub3857); 

            				doneLeaf(lv_val1_0_0, elementTypeProvider.getUnassignedRuleCall1Sub_Val1IDTerminalRuleCall_0ElementType());
            			

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
    // $ANTLR end "ruleUnassignedRuleCall1Sub"


    // $ANTLR start "entryRuleUnassignedRuleCall2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1204:1: entryRuleUnassignedRuleCall2 : ruleUnassignedRuleCall2 EOF ;
    public final void entryRuleUnassignedRuleCall2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1204:29: ( ruleUnassignedRuleCall2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1205:2: ruleUnassignedRuleCall2 EOF
            {
             markComposite(elementTypeProvider.getUnassignedRuleCall2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2_in_entryRuleUnassignedRuleCall23882);
            ruleUnassignedRuleCall2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall23888); 

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
    // $ANTLR end "entryRuleUnassignedRuleCall2"


    // $ANTLR start "ruleUnassignedRuleCall2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1213:1: ruleUnassignedRuleCall2 : (otherlv_0= '#12' ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final void ruleUnassignedRuleCall2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val2_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1213:24: ( (otherlv_0= '#12' ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1214:2: (otherlv_0= '#12' ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1214:2: (otherlv_0= '#12' ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1215:3: otherlv_0= '#12' ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleUnassignedRuleCall23911); 

            			doneLeaf(otherlv_0, elementTypeProvider.getUnassignedRuleCall2_NumberSignDigitOneDigitTwoKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getUnassignedRuleCall2_UnassignedRuleCall2SubParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2Sub_in_ruleUnassignedRuleCall23923);
            ruleUnassignedRuleCall2Sub();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1229:3: ( (lv_val2_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1230:4: (lv_val2_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1230:4: (lv_val2_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1231:5: lv_val2_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall23950); 

            					doneLeaf(lv_val2_2_0, elementTypeProvider.getUnassignedRuleCall2_Val2IDTerminalRuleCall_2_0ElementType());
            				

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
    // $ANTLR end "ruleUnassignedRuleCall2"


    // $ANTLR start "entryRuleUnassignedRuleCall2Sub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1244:1: entryRuleUnassignedRuleCall2Sub : ruleUnassignedRuleCall2Sub EOF ;
    public final void entryRuleUnassignedRuleCall2Sub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1244:32: ( ruleUnassignedRuleCall2Sub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1245:2: ruleUnassignedRuleCall2Sub EOF
            {
             markComposite(elementTypeProvider.getUnassignedRuleCall2SubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2Sub_in_entryRuleUnassignedRuleCall2Sub3981);
            ruleUnassignedRuleCall2Sub();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall2Sub3987); 

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
    // $ANTLR end "entryRuleUnassignedRuleCall2Sub"


    // $ANTLR start "ruleUnassignedRuleCall2Sub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1253:1: ruleUnassignedRuleCall2Sub : () ;
    public final void ruleUnassignedRuleCall2Sub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1253:27: ( () )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1254:2: ()
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1254:2: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1255:3: 
            {

            			precedeComposite(elementTypeProvider.getUnassignedRuleCall2Sub_UnassignedRuleCall2SubActionActionElementType());
            			doneComposite();
            		

            }


            }

        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleUnassignedRuleCall2Sub"


    // $ANTLR start "entryRuleCombination1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1263:1: entryRuleCombination1 : ruleCombination1 EOF ;
    public final void entryRuleCombination1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1263:22: ( ruleCombination1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1264:2: ruleCombination1 EOF
            {
             markComposite(elementTypeProvider.getCombination1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination1_in_entryRuleCombination14020);
            ruleCombination1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination14026); 

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
    // $ANTLR end "entryRuleCombination1"


    // $ANTLR start "ruleCombination1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1272:1: ruleCombination1 : (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) ;
    public final void ruleCombination1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token lv_val3_5_0=null;
        Token lv_val4_6_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1272:17: ( (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1273:2: (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1273:2: (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1274:3: otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCombination14049); 

            			doneLeaf(otherlv_0, elementTypeProvider.getCombination1_NumberSignDigitOneDigitThreeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1281:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1282:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1282:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1283:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination14076); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getCombination1_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1292:3: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1293:4: otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCombination14107); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getCombination1_Kw1Keyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1300:4: ( (lv_val2_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1301:5: (lv_val2_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1301:5: (lv_val2_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1302:6: lv_val2_3_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination14139); 

                    						doneLeaf(lv_val2_3_0, elementTypeProvider.getCombination1_Val2IDTerminalRuleCall_2_1_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1311:4: ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==14) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==RULE_ID) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1312:5: (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1312:5: (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1313:6: otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )
                            {

                            						markLeaf();
                            					
                            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCombination14184); 

                            						doneLeaf(otherlv_4, elementTypeProvider.getCombination1_Kw2Keyword_2_2_0_0ElementType());
                            					
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1320:6: ( (lv_val3_5_0= RULE_ID ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1321:7: (lv_val3_5_0= RULE_ID )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1321:7: (lv_val3_5_0= RULE_ID )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1322:8: lv_val3_5_0= RULE_ID
                            {

                            								markLeaf();
                            							
                            lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination14226); 

                            								doneLeaf(lv_val3_5_0, elementTypeProvider.getCombination1_Val3IDTerminalRuleCall_2_2_0_1_0ElementType());
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1333:5: ( (lv_val4_6_0= RULE_ID ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1333:5: ( (lv_val4_6_0= RULE_ID ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1334:6: (lv_val4_6_0= RULE_ID )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1334:6: (lv_val4_6_0= RULE_ID )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1335:7: lv_val4_6_0= RULE_ID
                            {

                            							markLeaf();
                            						
                            lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination14297); 

                            							doneLeaf(lv_val4_6_0, elementTypeProvider.getCombination1_Val4IDTerminalRuleCall_2_2_1_0ElementType());
                            						

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleCombination1"


    // $ANTLR start "entryRuleCombination2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1350:1: entryRuleCombination2 : ruleCombination2 EOF ;
    public final void entryRuleCombination2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1350:22: ( ruleCombination2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1351:2: ruleCombination2 EOF
            {
             markComposite(elementTypeProvider.getCombination2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination2_in_entryRuleCombination24344);
            ruleCombination2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination24350); 

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
    // $ANTLR end "entryRuleCombination2"


    // $ANTLR start "ruleCombination2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1359:1: ruleCombination2 : (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) ;
    public final void ruleCombination2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;
        Token lv_val4_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1359:17: ( (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1360:2: (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1360:2: (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1361:3: otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCombination24373); 

            			doneLeaf(otherlv_0, elementTypeProvider.getCombination2_NumberSignDigitOneDigitFourKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1368:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1369:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1369:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1370:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination24400); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getCombination2_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1379:3: ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==13) ) {
                alt20=1;
            }
            else if ( (LA20_0==EOF||LA20_0==RULE_ID) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1380:4: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1380:4: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1381:5: otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCombination24438); 

                    					doneLeaf(otherlv_2, elementTypeProvider.getCombination2_Kw1Keyword_2_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1388:5: ( (lv_val2_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1389:6: (lv_val2_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1389:6: (lv_val2_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1390:7: lv_val2_3_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination24475); 

                    							doneLeaf(lv_val2_3_0, elementTypeProvider.getCombination2_Val2IDTerminalRuleCall_2_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1401:4: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1401:4: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1402:5: ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1402:5: ( (lv_val3_4_0= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1403:6: (lv_val3_4_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1403:6: (lv_val3_4_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1404:7: lv_val3_4_0= RULE_ID
                    	    {

                    	    							markLeaf();
                    	    						
                    	    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination24546); 

                    	    							doneLeaf(lv_val3_4_0, elementTypeProvider.getCombination2_Val3IDTerminalRuleCall_2_1_0_0ElementType());
                    	    						

                    	    }


                    	    }

                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1413:5: ( (lv_val4_5_0= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1414:6: (lv_val4_5_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1414:6: (lv_val4_5_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1415:7: lv_val4_5_0= RULE_ID
                    	    {

                    	    							markLeaf();
                    	    						
                    	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination24598); 

                    	    							doneLeaf(lv_val4_5_0, elementTypeProvider.getCombination2_Val4IDTerminalRuleCall_2_1_1_0ElementType());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
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
    // $ANTLR end "ruleCombination2"


    // $ANTLR start "entryRuleCombination3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1430:1: entryRuleCombination3 : ruleCombination3 EOF ;
    public final void entryRuleCombination3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1430:22: ( ruleCombination3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1431:2: ruleCombination3 EOF
            {
             markComposite(elementTypeProvider.getCombination3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination3_in_entryRuleCombination34645);
            ruleCombination3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination34651); 

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
    // $ANTLR end "entryRuleCombination3"


    // $ANTLR start "ruleCombination3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1439:1: ruleCombination3 : (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) ;
    public final void ruleCombination3() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token lv_val3_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1439:17: ( (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1440:2: (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1440:2: (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1441:3: otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleCombination34674); 

            			doneLeaf(otherlv_0, elementTypeProvider.getCombination3_NumberSignDigitOneDigitFiveKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1448:3: ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
            loop21:
            do {
                int alt21=4;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt21=1;
                    }
                    break;
                case RULE_INT:
                    {
                    alt21=2;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt21=3;
                    }
                    break;

                }

                switch (alt21) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1449:4: ( (lv_val1_1_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1449:4: ( (lv_val1_1_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1450:5: (lv_val1_1_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1450:5: (lv_val1_1_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1451:6: lv_val1_1_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination34709); 

            	    						doneLeaf(lv_val1_1_0, elementTypeProvider.getCombination3_Val1IDTerminalRuleCall_1_0_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1461:4: ( (lv_val2_2_0= RULE_INT ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1461:4: ( (lv_val2_2_0= RULE_INT ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1462:5: (lv_val2_2_0= RULE_INT )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1462:5: (lv_val2_2_0= RULE_INT )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1463:6: lv_val2_2_0= RULE_INT
            	    {

            	    						markLeaf();
            	    					
            	    lv_val2_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCombination34763); 

            	    						doneLeaf(lv_val2_2_0, elementTypeProvider.getCombination3_Val2INTTerminalRuleCall_1_1_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1473:4: ( (lv_val3_3_0= RULE_STRING ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1473:4: ( (lv_val3_3_0= RULE_STRING ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1474:5: (lv_val3_3_0= RULE_STRING )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1474:5: (lv_val3_3_0= RULE_STRING )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1475:6: lv_val3_3_0= RULE_STRING
            	    {

            	    						markLeaf();
            	    					
            	    lv_val3_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCombination34817); 

            	    						doneLeaf(lv_val3_3_0, elementTypeProvider.getCombination3_Val3STRINGTerminalRuleCall_1_2_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // $ANTLR end "ruleCombination3"


    // $ANTLR start "entryRuleCombination4"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1489:1: entryRuleCombination4 : ruleCombination4 EOF ;
    public final void entryRuleCombination4() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1489:22: ( ruleCombination4 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1490:2: ruleCombination4 EOF
            {
             markComposite(elementTypeProvider.getCombination4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination4_in_entryRuleCombination44856);
            ruleCombination4();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination44862); 

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
    // $ANTLR end "entryRuleCombination4"


    // $ANTLR start "ruleCombination4"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1498:1: ruleCombination4 : (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) ;
    public final void ruleCombination4() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1498:17: ( (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1499:2: (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1499:2: (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1500:3: otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleCombination44885); 

            			doneLeaf(otherlv_0, elementTypeProvider.getCombination4_NumberSignDigitOneDigitSixKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1507:3: (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==32) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1508:4: otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleCombination44905); 

            	    				doneLeaf(otherlv_1, elementTypeProvider.getCombination4_GroupKeyword_1_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1515:4: ( (lv_val1_2_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1516:5: (lv_val1_2_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1516:5: (lv_val1_2_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1517:6: lv_val1_2_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination44937); 

            	    						doneLeaf(lv_val1_2_0, elementTypeProvider.getCombination4_Val1IDTerminalRuleCall_1_1_0ElementType());
            	    					

            	    }


            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1526:4: ( (lv_val2_3_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1527:5: (lv_val2_3_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1527:5: (lv_val2_3_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1528:6: lv_val2_3_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination44982); 

            	    						doneLeaf(lv_val2_3_0, elementTypeProvider.getCombination4_Val2IDTerminalRuleCall_1_2_0ElementType());
            	    					

            	    }


            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1537:4: ( (lv_val3_4_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1538:5: (lv_val3_4_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1538:5: (lv_val3_4_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1539:6: lv_val3_4_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination45027); 

            	    						doneLeaf(lv_val3_4_0, elementTypeProvider.getCombination4_Val3IDTerminalRuleCall_1_3_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
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
    // $ANTLR end "ruleCombination4"


    // $ANTLR start "entryRuleList1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1553:1: entryRuleList1 : ruleList1 EOF ;
    public final void entryRuleList1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1553:15: ( ruleList1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1554:2: ruleList1 EOF
            {
             markComposite(elementTypeProvider.getList1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleList1_in_entryRuleList15066);
            ruleList1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList15072); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1562:1: ruleList1 : (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final void ruleList1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1562:10: ( (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1563:2: (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1563:2: (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1564:3: otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleList15095); 

            			doneLeaf(otherlv_0, elementTypeProvider.getList1_NumberSignDigitOneDigitSevenKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1571:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1572:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1572:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1573:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList15122); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getList1_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1582:3: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==34) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1583:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleList15153); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getList1_CommaKeyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1590:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1591:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1591:5: (lv_val1_3_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1592:6: lv_val1_3_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList15185); 

            	    						doneLeaf(lv_val1_3_0, elementTypeProvider.getList1_Val1IDTerminalRuleCall_2_1_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1606:1: entryRuleList2 : ruleList2 EOF ;
    public final void entryRuleList2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1606:15: ( ruleList2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1607:2: ruleList2 EOF
            {
             markComposite(elementTypeProvider.getList2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleList2_in_entryRuleList25224);
            ruleList2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList25230); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1615:1: ruleList2 : (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) ;
    public final void ruleList2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1615:10: ( (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1616:2: (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1616:2: (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1617:3: otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleList25253); 

            			doneLeaf(otherlv_0, elementTypeProvider.getList2_NumberSignDigitOneDigitEightKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1624:3: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1625:4: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1625:4: ( (lv_val1_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1626:5: (lv_val1_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1626:5: (lv_val1_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1627:6: lv_val1_1_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList25288); 

                    						doneLeaf(lv_val1_1_0, elementTypeProvider.getList2_Val1IDTerminalRuleCall_1_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1636:4: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==34) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1637:5: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleList25325); 

                    	    					doneLeaf(otherlv_2, elementTypeProvider.getList2_CommaKeyword_1_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1644:5: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1645:6: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1645:6: (lv_val1_3_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1646:7: lv_val1_3_0= RULE_ID
                    	    {

                    	    							markLeaf();
                    	    						
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList25362); 

                    	    							doneLeaf(lv_val1_3_0, elementTypeProvider.getList2_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
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


    // $ANTLR start "entryRuleList3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1661:1: entryRuleList3 : ruleList3 EOF ;
    public final void entryRuleList3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1661:15: ( ruleList3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1662:2: ruleList3 EOF
            {
             markComposite(elementTypeProvider.getList3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleList3_in_entryRuleList35410);
            ruleList3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList35416); 

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
    // $ANTLR end "entryRuleList3"


    // $ANTLR start "ruleList3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1670:1: ruleList3 : ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) ;
    public final void ruleList3() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1670:10: ( ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1671:2: ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1671:2: ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==36) ) {
                alt27=1;
            }
            else if ( (LA27_0==16) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1672:3: (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1672:3: (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1673:4: otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleList35445); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getList3_NumberSignDigitOneDigitNineKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1680:4: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1681:5: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1681:5: ( (lv_val1_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1682:6: (lv_val1_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1682:6: (lv_val1_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1683:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList35486); 

                    							doneLeaf(lv_val1_1_0, elementTypeProvider.getList3_Val1IDTerminalRuleCall_0_1_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1692:5: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==34) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1693:6: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {

                    	    						markLeaf();
                    	    					
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleList35529); 

                    	    						doneLeaf(otherlv_2, elementTypeProvider.getList3_CommaKeyword_0_1_1_0ElementType());
                    	    					
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1700:6: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1701:7: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1701:7: (lv_val1_3_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1702:8: lv_val1_3_0= RULE_ID
                    	    {

                    	    								markLeaf();
                    	    							
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList35571); 

                    	    								doneLeaf(lv_val1_3_0, elementTypeProvider.getList3_Val1IDTerminalRuleCall_0_1_1_1_0ElementType());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1715:3: (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1715:3: (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1716:4: otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleList35635); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getList3_Kw3Keyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1723:4: ( (lv_val2_5_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1724:5: (lv_val2_5_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1724:5: (lv_val2_5_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1725:6: lv_val2_5_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList35667); 

                    						doneLeaf(lv_val2_5_0, elementTypeProvider.getList3_Val2IDTerminalRuleCall_1_1_0ElementType());
                    					

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
        return ;
    }
    // $ANTLR end "ruleList3"


    // $ANTLR start "entryRuleList4"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1739:1: entryRuleList4 : ruleList4 EOF ;
    public final void entryRuleList4() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1739:15: ( ruleList4 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1740:2: ruleList4 EOF
            {
             markComposite(elementTypeProvider.getList4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleList4_in_entryRuleList45705);
            ruleList4();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList45711); 

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
    // $ANTLR end "entryRuleList4"


    // $ANTLR start "ruleList4"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1748:1: ruleList4 : (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ;
    public final void ruleList4() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1748:10: ( (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1749:2: (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1749:2: (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1750:3: otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleList45734); 

            			doneLeaf(otherlv_0, elementTypeProvider.getList4_NumberSignDigitTwoDigitZeroKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1757:3: ( (lv_val1_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1758:4: (lv_val1_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1758:4: (lv_val1_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1759:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList45761); 

            					doneLeaf(lv_val1_1_0, elementTypeProvider.getList4_Val1IDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1768:3: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==34) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1769:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleList45792); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getList4_CommaKeyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1776:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1777:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1777:5: (lv_val1_3_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1778:6: lv_val1_3_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList45824); 

            	    						doneLeaf(lv_val1_3_0, elementTypeProvider.getList4_Val1IDTerminalRuleCall_2_1_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleList45857); 

            			doneLeaf(otherlv_4, elementTypeProvider.getList4_Kw3Keyword_3ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1795:3: ( (lv_val2_5_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1796:4: (lv_val2_5_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1796:4: (lv_val2_5_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1797:5: lv_val2_5_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList45884); 

            					doneLeaf(lv_val2_5_0, elementTypeProvider.getList4_Val2IDTerminalRuleCall_4_0ElementType());
            				

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
    // $ANTLR end "ruleList4"


    // $ANTLR start "entryRuleList5"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1810:1: entryRuleList5 : ruleList5 EOF ;
    public final void entryRuleList5() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1810:15: ( ruleList5 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1811:2: ruleList5 EOF
            {
             markComposite(elementTypeProvider.getList5ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleList5_in_entryRuleList55915);
            ruleList5();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList55921); 

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
    // $ANTLR end "entryRuleList5"


    // $ANTLR start "ruleList5"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1819:1: ruleList5 : (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) ;
    public final void ruleList5() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;
        Token lv_val3_6_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1819:10: ( (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1820:2: (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1820:2: (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1821:3: otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleList55944); 

            			doneLeaf(otherlv_0, elementTypeProvider.getList5_NumberSignDigitTwoDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1828:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==EOF) ) {
                    alt30=2;
                }
                else if ( (LA30_1==16||LA30_1==34) ) {
                    alt30=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1829:4: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1829:4: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1830:5: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1830:5: ( (lv_val1_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1831:6: (lv_val1_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1831:6: (lv_val1_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1832:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList55988); 

                    							doneLeaf(lv_val1_1_0, elementTypeProvider.getList5_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1841:5: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==34) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1842:6: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {

                    	    						markLeaf();
                    	    					
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleList56031); 

                    	    						doneLeaf(otherlv_2, elementTypeProvider.getList5_CommaKeyword_1_0_1_0ElementType());
                    	    					
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1849:6: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1850:7: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1850:7: (lv_val1_3_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1851:8: lv_val1_3_0= RULE_ID
                    	    {

                    	    								markLeaf();
                    	    							
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList56073); 

                    	    								doneLeaf(lv_val1_3_0, elementTypeProvider.getList5_Val1IDTerminalRuleCall_1_0_1_1_0ElementType());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    					markLeaf();
                    				
                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleList56118); 

                    					doneLeaf(otherlv_4, elementTypeProvider.getList5_Kw3Keyword_1_0_2ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1868:5: ( (lv_val2_5_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1869:6: (lv_val2_5_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1869:6: (lv_val2_5_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1870:7: lv_val2_5_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList56155); 

                    							doneLeaf(lv_val2_5_0, elementTypeProvider.getList5_Val2IDTerminalRuleCall_1_0_3_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1881:4: ( (lv_val3_6_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1881:4: ( (lv_val3_6_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1882:5: (lv_val3_6_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1882:5: (lv_val3_6_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1883:6: lv_val3_6_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList56217); 

                    						doneLeaf(lv_val3_6_0, elementTypeProvider.getList5_Val3IDTerminalRuleCall_1_1_0ElementType());
                    					

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
    // $ANTLR end "ruleList5"


    // $ANTLR start "entryRuleAltList1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1897:1: entryRuleAltList1 : ruleAltList1 EOF ;
    public final void entryRuleAltList1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1897:18: ( ruleAltList1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1898:2: ruleAltList1 EOF
            {
             markComposite(elementTypeProvider.getAltList1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAltList1_in_entryRuleAltList16255);
            ruleAltList1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAltList16261); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1906:1: ruleAltList1 : (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1906:13: ( (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1907:2: (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1907:2: (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1908:3: otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleAltList16284); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAltList1_NumberSignDigitTwoDigitTwoKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1915:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            int alt32=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt32=1;
                }
                break;
            case 13:
                {
                alt32=2;
                }
                break;
            case 14:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1916:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1916:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1917:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1917:5: ( (lv_val1_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1918:6: (lv_val1_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1918:6: (lv_val1_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1919:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList16328); 

                    							doneLeaf(lv_val1_1_0, elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1928:5: ( (lv_val2_2_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1929:6: (lv_val2_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1929:6: (lv_val2_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1930:7: lv_val2_2_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList16380); 

                    							doneLeaf(lv_val2_2_0, elementTypeProvider.getAltList1_Val2IDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1941:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1941:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1942:5: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAltList16434); 

                    					doneLeaf(otherlv_3, elementTypeProvider.getAltList1_Kw1Keyword_1_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1949:5: ( (lv_val1_4_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1950:6: (lv_val1_4_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1950:6: (lv_val1_4_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1951:7: lv_val1_4_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList16471); 

                    							doneLeaf(lv_val1_4_0, elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1960:5: ( (lv_val3_5_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1961:6: (lv_val3_5_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1961:6: (lv_val3_5_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1962:7: lv_val3_5_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList16523); 

                    							doneLeaf(lv_val3_5_0, elementTypeProvider.getAltList1_Val3IDTerminalRuleCall_1_1_2_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1973:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1973:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1974:5: otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )?
                    {

                    					markLeaf();
                    				
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAltList16577); 

                    					doneLeaf(otherlv_6, elementTypeProvider.getAltList1_Kw2Keyword_1_2_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1981:5: ( (lv_val1_7_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1982:6: (lv_val1_7_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1982:6: (lv_val1_7_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1983:7: lv_val1_7_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList16614); 

                    							doneLeaf(lv_val1_7_0, elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_2_1_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1992:5: ( (lv_val4_8_0= RULE_ID ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==RULE_ID) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1993:6: (lv_val4_8_0= RULE_ID )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1993:6: (lv_val4_8_0= RULE_ID )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:1994:7: lv_val4_8_0= RULE_ID
                            {

                            							markLeaf();
                            						
                            lv_val4_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList16666); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2009:1: entryRuleAltList2 : ruleAltList2 EOF ;
    public final void entryRuleAltList2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2009:18: ( ruleAltList2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2010:2: ruleAltList2 EOF
            {
             markComposite(elementTypeProvider.getAltList2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAltList2_in_entryRuleAltList26713);
            ruleAltList2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAltList26719); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2018:1: ruleAltList2 : (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2018:13: ( (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2019:2: (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2019:2: (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2020:3: otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleAltList26742); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAltList2_NumberSignDigitTwoDigitThreeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2027:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                alt34=1;
            }
            else if ( (LA34_0==41) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2028:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2028:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2029:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2029:5: ( (lv_val1_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2030:6: (lv_val1_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2030:6: (lv_val1_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2031:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList26786); 

                    							doneLeaf(lv_val1_1_0, elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2040:5: ( (lv_val2_2_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2041:6: (lv_val2_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2041:6: (lv_val2_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2042:7: lv_val2_2_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList26838); 

                    							doneLeaf(lv_val2_2_0, elementTypeProvider.getAltList2_Val2IDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2053:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2053:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2054:5: otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_3=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleAltList26892); 

                    					doneLeaf(otherlv_3, elementTypeProvider.getAltList2_KwKeyword_1_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2061:5: ( (lv_val1_4_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2062:6: (lv_val1_4_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2062:6: (lv_val1_4_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2063:7: lv_val1_4_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList26929); 

                    							doneLeaf(lv_val1_4_0, elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2072:5: (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==34) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2073:6: otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) )
                    	    {

                    	    						markLeaf();
                    	    					
                    	    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAltList26972); 

                    	    						doneLeaf(otherlv_5, elementTypeProvider.getAltList2_CommaKeyword_1_1_2_0ElementType());
                    	    					
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2080:6: ( (lv_val1_6_0= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2081:7: (lv_val1_6_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2081:7: (lv_val1_6_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2082:8: lv_val1_6_0= RULE_ID
                    	    {

                    	    								markLeaf();
                    	    							
                    	    lv_val1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList27014); 

                    	    								doneLeaf(lv_val1_6_0, elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_1_2_1_0ElementType());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2092:5: ( (lv_val3_7_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2093:6: (lv_val3_7_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2093:6: (lv_val3_7_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2094:7: lv_val3_7_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList27076); 

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


    // $ANTLR start "entryRuleTransientObject"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2109:1: entryRuleTransientObject : ruleTransientObject EOF ;
    public final void entryRuleTransientObject() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2109:25: ( ruleTransientObject EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2110:2: ruleTransientObject EOF
            {
             markComposite(elementTypeProvider.getTransientObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTransientObject_in_entryRuleTransientObject7122);
            ruleTransientObject();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransientObject7128); 

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
    // $ANTLR end "entryRuleTransientObject"


    // $ANTLR start "ruleTransientObject"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2118:1: ruleTransientObject : (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) ;
    public final void ruleTransientObject() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2118:20: ( (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2119:2: (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2119:2: (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2120:3: otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleTransientObject7151); 

            			doneLeaf(otherlv_0, elementTypeProvider.getTransientObject_NumberSignDigitTwoDigitFourKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2127:3: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2128:4: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2128:4: ( (lv_val1_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2129:5: (lv_val1_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2129:5: (lv_val1_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2130:6: lv_val1_1_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientObject7186); 

                    						doneLeaf(lv_val1_1_0, elementTypeProvider.getTransientObject_Val1IDTerminalRuleCall_1_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2139:4: ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2140:5: (lv_nested_2_0= ruleTransientObjectSub )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2140:5: (lv_nested_2_0= ruleTransientObjectSub )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2141:6: lv_nested_2_0= ruleTransientObjectSub
                    {

                    						markComposite(elementTypeProvider.getTransientObject_NestedTransientObjectSubParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleTransientObjectSub_in_ruleTransientObject7231);
                    ruleTransientObjectSub();

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
    // $ANTLR end "ruleTransientObject"


    // $ANTLR start "entryRuleTransientObjectSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2155:1: entryRuleTransientObjectSub : ruleTransientObjectSub EOF ;
    public final void entryRuleTransientObjectSub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2155:28: ( ruleTransientObjectSub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2156:2: ruleTransientObjectSub EOF
            {
             markComposite(elementTypeProvider.getTransientObjectSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTransientObjectSub_in_entryRuleTransientObjectSub7270);
            ruleTransientObjectSub();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransientObjectSub7276); 

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
    // $ANTLR end "entryRuleTransientObjectSub"


    // $ANTLR start "ruleTransientObjectSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2164:1: ruleTransientObjectSub : ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) ;
    public final void ruleTransientObjectSub() throws RecognitionException {
        Token lv_val2_0_0=null;
        Token lv_val3_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2164:23: ( ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2165:2: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2165:2: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2166:3: ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2166:3: ( (lv_val2_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2167:4: (lv_val2_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2167:4: (lv_val2_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2168:5: lv_val2_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val2_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientObjectSub7312); 

            					doneLeaf(lv_val2_0_0, elementTypeProvider.getTransientObjectSub_Val2IDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2177:3: ( (lv_val3_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2178:4: (lv_val3_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2178:4: (lv_val3_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2179:5: lv_val3_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val3_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientObjectSub7350); 

            					doneLeaf(lv_val3_1_0, elementTypeProvider.getTransientObjectSub_Val3IDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleTransientObjectSub"


    // $ANTLR start "entryRuleTransientSerializeables1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2192:1: entryRuleTransientSerializeables1 : ruleTransientSerializeables1 EOF ;
    public final void entryRuleTransientSerializeables1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2192:34: ( ruleTransientSerializeables1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2193:2: ruleTransientSerializeables1 EOF
            {
             markComposite(elementTypeProvider.getTransientSerializeables1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTransientSerializeables1_in_entryRuleTransientSerializeables17381);
            ruleTransientSerializeables1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransientSerializeables17387); 

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
    // $ANTLR end "entryRuleTransientSerializeables1"


    // $ANTLR start "ruleTransientSerializeables1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2201:1: ruleTransientSerializeables1 : (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) ;
    public final void ruleTransientSerializeables1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_int1_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2201:29: ( (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2202:2: (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2202:2: (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2203:3: otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleTransientSerializeables17410); 

            			doneLeaf(otherlv_0, elementTypeProvider.getTransientSerializeables1_NumberSignDigitTwoDigitFiveKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2210:3: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                int LA36_1 = input.LA(2);

                if ( ((LA36_1>=52 && LA36_1<=53)) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2211:4: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2211:4: ( (lv_val1_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2212:5: (lv_val1_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2212:5: (lv_val1_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2213:6: lv_val1_1_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientSerializeables17445); 

                    						doneLeaf(lv_val1_1_0, elementTypeProvider.getTransientSerializeables1_Val1IDTerminalRuleCall_1_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2222:4: ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2223:5: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2223:5: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2224:6: lv_enum1_2_0= ruleTransientSerializeables1Enum
                    {

                    						markComposite(elementTypeProvider.getTransientSerializeables1_Enum1TransientSerializeables1EnumEnumRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleTransientSerializeables1Enum_in_ruleTransientSerializeables17490);
                    ruleTransientSerializeables1Enum();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2234:3: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2235:4: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2235:4: ( (lv_val2_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2236:5: (lv_val2_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2236:5: (lv_val2_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2237:6: lv_val2_3_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientSerializeables17544); 

                    						doneLeaf(lv_val2_3_0, elementTypeProvider.getTransientSerializeables1_Val2IDTerminalRuleCall_2_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2246:4: ( (lv_int1_4_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2247:5: (lv_int1_4_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2247:5: (lv_int1_4_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2248:6: lv_int1_4_0= RULE_INT
                    {

                    						markLeaf();
                    					
                    lv_int1_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTransientSerializeables17589); 

                    						doneLeaf(lv_int1_4_0, elementTypeProvider.getTransientSerializeables1_Int1INTTerminalRuleCall_2_1_0ElementType());
                    					

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
    // $ANTLR end "ruleTransientSerializeables1"


    // $ANTLR start "entryRuleStaticSimplification"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2262:1: entryRuleStaticSimplification : ruleStaticSimplification EOF ;
    public final void entryRuleStaticSimplification() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2262:30: ( ruleStaticSimplification EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2263:2: ruleStaticSimplification EOF
            {
             markComposite(elementTypeProvider.getStaticSimplificationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleStaticSimplification_in_entryRuleStaticSimplification7628);
            ruleStaticSimplification();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStaticSimplification7634); 

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
    // $ANTLR end "entryRuleStaticSimplification"


    // $ANTLR start "ruleStaticSimplification"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2271:1: ruleStaticSimplification : (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) ) ;
    public final void ruleStaticSimplification() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_val3_8_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2271:25: ( (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2272:2: (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2272:2: (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2273:3: otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleStaticSimplification7657); 

            			doneLeaf(otherlv_0, elementTypeProvider.getStaticSimplification_NumberSignDigitTwoDigitSixKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2280:3: (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt38=1;
                }
                break;
            case 14:
                {
                alt38=2;
                }
                break;
            case RULE_ID:
                {
                int LA38_3 = input.LA(2);

                if ( (LA38_3==RULE_ID||LA38_3==14) ) {
                    alt38=3;
                }
                else if ( (LA38_3==16) ) {
                    alt38=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2281:4: otherlv_1= 'kw1'
                    {

                    				markLeaf();
                    			
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleStaticSimplification7677); 

                    				doneLeaf(otherlv_1, elementTypeProvider.getStaticSimplification_Kw1Keyword_1_0ElementType());
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2289:4: ()
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2289:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2290:5: 
                    {

                    					precedeComposite(elementTypeProvider.getStaticSimplification_EmptyAlternativeSubAction_1_1ElementType());
                    					doneComposite();
                    				

                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2296:4: ( (lv_val1_3_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2296:4: ( (lv_val1_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2297:5: (lv_val1_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2297:5: (lv_val1_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2298:6: lv_val1_3_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStaticSimplification7743); 

                    						doneLeaf(lv_val1_3_0, elementTypeProvider.getStaticSimplification_Val1IDTerminalRuleCall_1_2_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2308:3: (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==14) ) {
                alt39=1;
            }
            else if ( (LA39_0==RULE_ID) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2309:4: otherlv_4= 'kw2'
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleStaticSimplification7781); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getStaticSimplification_Kw2Keyword_2_0ElementType());
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2317:4: ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2317:4: ( (lv_val2_5_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2318:5: (lv_val2_5_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2318:5: (lv_val2_5_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2319:6: lv_val2_5_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStaticSimplification7822); 

                    						doneLeaf(lv_val2_5_0, elementTypeProvider.getStaticSimplification_Val2IDTerminalRuleCall_2_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2329:3: (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2330:4: otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )?
            {

            				markLeaf();
            			
            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleStaticSimplification7860); 

            				doneLeaf(otherlv_6, elementTypeProvider.getStaticSimplification_Kw3Keyword_3_0ElementType());
            			
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2337:4: (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==19) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2338:5: otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+
                    {

                    					markLeaf();
                    				
                    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleStaticSimplification7884); 

                    					doneLeaf(otherlv_7, elementTypeProvider.getStaticSimplification_Kw4Keyword_3_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2345:5: ( (lv_val3_8_0= RULE_ID ) )+
                    int cnt40=0;
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_ID) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2346:6: (lv_val3_8_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2346:6: (lv_val3_8_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2347:7: lv_val3_8_0= RULE_ID
                    	    {

                    	    							markLeaf();
                    	    						
                    	    lv_val3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStaticSimplification7921); 

                    	    							doneLeaf(lv_val3_8_0, elementTypeProvider.getStaticSimplification_Val3IDTerminalRuleCall_3_1_1_0ElementType());
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt40 >= 1 ) break loop40;
                                EarlyExitException eee =
                                    new EarlyExitException(40, input);
                                throw eee;
                        }
                        cnt40++;
                    } while (true);


                    }
                    break;

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
    // $ANTLR end "ruleStaticSimplification"


    // $ANTLR start "entryRuleTwoVersion"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2362:1: entryRuleTwoVersion : ruleTwoVersion EOF ;
    public final void entryRuleTwoVersion() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2362:20: ( ruleTwoVersion EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2363:2: ruleTwoVersion EOF
            {
             markComposite(elementTypeProvider.getTwoVersionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoVersion_in_entryRuleTwoVersion7969);
            ruleTwoVersion();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoVersion7975); 

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
    // $ANTLR end "entryRuleTwoVersion"


    // $ANTLR start "ruleTwoVersion"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2371:1: ruleTwoVersion : (otherlv_0= '#27' ( ruleTwoVersionNo1 | ruleTwoVersionNo2 ) ) ;
    public final void ruleTwoVersion() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2371:15: ( (otherlv_0= '#27' ( ruleTwoVersionNo1 | ruleTwoVersionNo2 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2372:2: (otherlv_0= '#27' ( ruleTwoVersionNo1 | ruleTwoVersionNo2 ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2372:2: (otherlv_0= '#27' ( ruleTwoVersionNo1 | ruleTwoVersionNo2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2373:3: otherlv_0= '#27' ( ruleTwoVersionNo1 | ruleTwoVersionNo2 )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleTwoVersion7998); 

            			doneLeaf(otherlv_0, elementTypeProvider.getTwoVersion_NumberSignDigitTwoDigitSevenKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2380:3: ( ruleTwoVersionNo1 | ruleTwoVersionNo2 )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 48:
                    {
                    alt42=2;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA42_3 = input.LA(3);

                    if ( (LA42_3==48) ) {
                        alt42=2;
                    }
                    else if ( (LA42_3==46) ) {
                        alt42=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 46:
                    {
                    alt42=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2381:4: ruleTwoVersionNo1
                    {

                    				markComposite(elementTypeProvider.getTwoVersion_TwoVersionNo1ParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTwoVersionNo1_in_ruleTwoVersion8016);
                    ruleTwoVersionNo1();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2389:4: ruleTwoVersionNo2
                    {

                    				markComposite(elementTypeProvider.getTwoVersion_TwoVersionNo2ParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTwoVersionNo2_in_ruleTwoVersion8040);
                    ruleTwoVersionNo2();

                    state._fsp--;


                    				doneComposite();
                    			

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
    // $ANTLR end "ruleTwoVersion"


    // $ANTLR start "entryRuleTwoVersionNo1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2401:1: entryRuleTwoVersionNo1 : ruleTwoVersionNo1 EOF ;
    public final void entryRuleTwoVersionNo1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2401:23: ( ruleTwoVersionNo1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2402:2: ruleTwoVersionNo1 EOF
            {
             markComposite(elementTypeProvider.getTwoVersionNo1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoVersionNo1_in_entryRuleTwoVersionNo18065);
            ruleTwoVersionNo1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoVersionNo18071); 

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
    // $ANTLR end "entryRuleTwoVersionNo1"


    // $ANTLR start "ruleTwoVersionNo1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2410:1: ruleTwoVersionNo1 : ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? ) ;
    public final void ruleTwoVersionNo1() throws RecognitionException {
        Token lv_shared1_0_0=null;
        Token lv_shared2_1_0=null;
        Token otherlv_2=null;
        Token lv_shared3_3_0=null;
        Token lv_shared3_4_0=null;
        Token otherlv_5=null;
        Token lv_version1_6_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2410:18: ( ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2411:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2411:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2412:3: ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2412:3: ( (lv_shared1_0_0= RULE_ID ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==RULE_ID) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2413:4: (lv_shared1_0_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2413:4: (lv_shared1_0_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2414:5: lv_shared1_0_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_shared1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo18107); 

                    					doneLeaf(lv_shared1_0_0, elementTypeProvider.getTwoVersionNo1_Shared1IDTerminalRuleCall_0_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2423:3: ( (lv_shared2_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2424:4: (lv_shared2_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2424:4: (lv_shared2_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2425:5: lv_shared2_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_shared2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo18146); 

            					doneLeaf(lv_shared2_1_0, elementTypeProvider.getTwoVersionNo1_Shared2IDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleTwoVersionNo18171); 

            			doneLeaf(otherlv_2, elementTypeProvider.getTwoVersionNo1_ShortKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2441:3: ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2442:4: ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2442:4: ( (lv_shared3_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2443:5: (lv_shared3_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2443:5: (lv_shared3_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2444:6: lv_shared3_3_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_shared3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo18206); 

                    						doneLeaf(lv_shared3_3_0, elementTypeProvider.getTwoVersionNo1_Shared3IDTerminalRuleCall_3_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2453:4: ( (lv_shared3_4_0= RULE_ID ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==RULE_ID) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2454:5: (lv_shared3_4_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2454:5: (lv_shared3_4_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2455:6: lv_shared3_4_0= RULE_ID
                    	    {

                    	    						markLeaf();
                    	    					
                    	    lv_shared3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo18251); 

                    	    						doneLeaf(lv_shared3_4_0, elementTypeProvider.getTwoVersionNo1_Shared3IDTerminalRuleCall_3_1_0ElementType());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleTwoVersionNo18285); 

            			doneLeaf(otherlv_5, elementTypeProvider.getTwoVersionNo1_OneKeyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2472:3: ( (lv_version1_6_0= RULE_ID ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2473:4: (lv_version1_6_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2473:4: (lv_version1_6_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2474:5: lv_version1_6_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_version1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo18312); 

                    					doneLeaf(lv_version1_6_0, elementTypeProvider.getTwoVersionNo1_Version1IDTerminalRuleCall_5_0ElementType());
                    				

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
    // $ANTLR end "ruleTwoVersionNo1"


    // $ANTLR start "entryRuleTwoVersionNo2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2487:1: entryRuleTwoVersionNo2 : ruleTwoVersionNo2 EOF ;
    public final void entryRuleTwoVersionNo2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2487:23: ( ruleTwoVersionNo2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2488:2: ruleTwoVersionNo2 EOF
            {
             markComposite(elementTypeProvider.getTwoVersionNo2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoVersionNo2_in_entryRuleTwoVersionNo28344);
            ruleTwoVersionNo2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoVersionNo28350); 

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
    // $ANTLR end "entryRuleTwoVersionNo2"


    // $ANTLR start "ruleTwoVersionNo2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2496:1: ruleTwoVersionNo2 : ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? ) ;
    public final void ruleTwoVersionNo2() throws RecognitionException {
        Token lv_shared1_0_0=null;
        Token lv_shared2_1_0=null;
        Token otherlv_2=null;
        Token lv_shared3_3_0=null;
        Token lv_shared3_4_0=null;
        Token otherlv_5=null;
        Token lv_extra1_6_0=null;
        Token lv_extra2_7_0=null;
        Token lv_extra3_8_0=null;
        Token otherlv_9=null;
        Token lv_extra4_10_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2496:18: ( ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2497:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2497:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2498:3: ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2498:3: ( (lv_shared1_0_0= RULE_ID ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_ID) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==RULE_ID) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2499:4: (lv_shared1_0_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2499:4: (lv_shared1_0_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2500:5: lv_shared1_0_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_shared1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo28386); 

                    					doneLeaf(lv_shared1_0_0, elementTypeProvider.getTwoVersionNo2_Shared1IDTerminalRuleCall_0_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2509:3: ( (lv_shared2_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2510:4: (lv_shared2_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2510:4: (lv_shared2_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2511:5: lv_shared2_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_shared2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo28425); 

            					doneLeaf(lv_shared2_1_0, elementTypeProvider.getTwoVersionNo2_Shared2IDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleTwoVersionNo28450); 

            			doneLeaf(otherlv_2, elementTypeProvider.getTwoVersionNo2_LongKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2527:3: ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2528:4: ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2528:4: ( (lv_shared3_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2529:5: (lv_shared3_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2529:5: (lv_shared3_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2530:6: lv_shared3_3_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_shared3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo28485); 

                    						doneLeaf(lv_shared3_3_0, elementTypeProvider.getTwoVersionNo2_Shared3IDTerminalRuleCall_3_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2539:4: ( (lv_shared3_4_0= RULE_ID ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==RULE_ID) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2540:5: (lv_shared3_4_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2540:5: (lv_shared3_4_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2541:6: lv_shared3_4_0= RULE_ID
                    	    {

                    	    						markLeaf();
                    	    					
                    	    lv_shared3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo28530); 

                    	    						doneLeaf(lv_shared3_4_0, elementTypeProvider.getTwoVersionNo2_Shared3IDTerminalRuleCall_3_1_0ElementType());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleTwoVersionNo28564); 

            			doneLeaf(otherlv_5, elementTypeProvider.getTwoVersionNo2_ExtraKeyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2558:3: ( (lv_extra1_6_0= RULE_ID ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==RULE_ID) ) {
                    int LA50_3 = input.LA(3);

                    if ( (LA50_3==RULE_ID) ) {
                        alt50=1;
                    }
                }
                else if ( (LA50_1==EOF||LA50_1==50) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2559:4: (lv_extra1_6_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2559:4: (lv_extra1_6_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2560:5: lv_extra1_6_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_extra1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo28591); 

                    					doneLeaf(lv_extra1_6_0, elementTypeProvider.getTwoVersionNo2_Extra1IDTerminalRuleCall_5_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2569:3: ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )?
            int alt51=3;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                alt51=1;
            }
            else if ( (LA51_0==50) ) {
                alt51=2;
            }
            switch (alt51) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2570:4: ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2570:4: ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2571:5: ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2571:5: ( (lv_extra2_7_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2572:6: (lv_extra2_7_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2572:6: (lv_extra2_7_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2573:7: lv_extra2_7_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_extra2_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo28647); 

                    							doneLeaf(lv_extra2_7_0, elementTypeProvider.getTwoVersionNo2_Extra2IDTerminalRuleCall_6_0_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2582:5: ( (lv_extra3_8_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2583:6: (lv_extra3_8_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2583:6: (lv_extra3_8_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2584:7: lv_extra3_8_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_extra3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo28699); 

                    							doneLeaf(lv_extra3_8_0, elementTypeProvider.getTwoVersionNo2_Extra3IDTerminalRuleCall_6_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2595:4: (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2595:4: (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2596:5: otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_9=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleTwoVersionNo28753); 

                    					doneLeaf(otherlv_9, elementTypeProvider.getTwoVersionNo2_TwoKeyword_6_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2603:5: ( (lv_extra4_10_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2604:6: (lv_extra4_10_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2604:6: (lv_extra4_10_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2605:7: lv_extra4_10_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_extra4_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo28790); 

                    							doneLeaf(lv_extra4_10_0, elementTypeProvider.getTwoVersionNo2_Extra4IDTerminalRuleCall_6_1_1_0ElementType());
                    						

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
    // $ANTLR end "ruleTwoVersionNo2"


    // $ANTLR start "entryRuleHeuristic1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2620:1: entryRuleHeuristic1 : ruleHeuristic1 EOF ;
    public final void entryRuleHeuristic1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2620:20: ( ruleHeuristic1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2621:2: ruleHeuristic1 EOF
            {
             markComposite(elementTypeProvider.getHeuristic1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleHeuristic1_in_entryRuleHeuristic18837);
            ruleHeuristic1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHeuristic18843); 

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
    // $ANTLR end "entryRuleHeuristic1"


    // $ANTLR start "ruleHeuristic1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2629:1: ruleHeuristic1 : (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* ) ;
    public final void ruleHeuristic1() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_a_2_0=null;
        Token lv_b_3_0=null;
        Token otherlv_4=null;
        Token lv_a_5_0=null;
        Token lv_c_6_0=null;
        Token otherlv_7=null;
        Token lv_b_8_0=null;
        Token lv_c_9_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2629:15: ( (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2630:2: (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2630:2: (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2631:3: otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleHeuristic18866); 

            			doneLeaf(otherlv_0, elementTypeProvider.getHeuristic1_NumberSignDigitTwoDigitEightKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2638:3: (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==13) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2639:4: otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleHeuristic18886); 

            	    				doneLeaf(otherlv_1, elementTypeProvider.getHeuristic1_Kw1Keyword_1_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2646:4: ( (lv_a_2_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2647:5: (lv_a_2_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2647:5: (lv_a_2_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2648:6: lv_a_2_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_a_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic18918); 

            	    						doneLeaf(lv_a_2_0, elementTypeProvider.getHeuristic1_AIDTerminalRuleCall_1_1_0ElementType());
            	    					

            	    }


            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2657:4: ( (lv_b_3_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2658:5: (lv_b_3_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2658:5: (lv_b_3_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2659:6: lv_b_3_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_b_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic18963); 

            	    						doneLeaf(lv_b_3_0, elementTypeProvider.getHeuristic1_BIDTerminalRuleCall_1_2_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2669:3: (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==14) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2670:4: otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleHeuristic19002); 

            	    				doneLeaf(otherlv_4, elementTypeProvider.getHeuristic1_Kw2Keyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2677:4: ( (lv_a_5_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2678:5: (lv_a_5_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2678:5: (lv_a_5_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2679:6: lv_a_5_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_a_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic19034); 

            	    						doneLeaf(lv_a_5_0, elementTypeProvider.getHeuristic1_AIDTerminalRuleCall_2_1_0ElementType());
            	    					

            	    }


            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2688:4: ( (lv_c_6_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2689:5: (lv_c_6_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2689:5: (lv_c_6_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2690:6: lv_c_6_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_c_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic19079); 

            	    						doneLeaf(lv_c_6_0, elementTypeProvider.getHeuristic1_CIDTerminalRuleCall_2_2_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2700:3: (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==16) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2701:4: otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleHeuristic19118); 

            	    				doneLeaf(otherlv_7, elementTypeProvider.getHeuristic1_Kw3Keyword_3_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2708:4: ( (lv_b_8_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2709:5: (lv_b_8_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2709:5: (lv_b_8_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2710:6: lv_b_8_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_b_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic19150); 

            	    						doneLeaf(lv_b_8_0, elementTypeProvider.getHeuristic1_BIDTerminalRuleCall_3_1_0ElementType());
            	    					

            	    }


            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2719:4: ( (lv_c_9_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2720:5: (lv_c_9_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2720:5: (lv_c_9_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2721:6: lv_c_9_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_c_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic19195); 

            	    						doneLeaf(lv_c_9_0, elementTypeProvider.getHeuristic1_CIDTerminalRuleCall_3_2_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
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
    // $ANTLR end "ruleHeuristic1"


    // $ANTLR start "ruleTransientSerializeables1Enum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2735:1: ruleTransientSerializeables1Enum : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) ;
    public final void ruleTransientSerializeables1Enum() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2735:33: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2736:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2736:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==52) ) {
                alt55=1;
            }
            else if ( (LA55_0==53) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2737:3: (enumLiteral_0= 'lit1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2737:3: (enumLiteral_0= 'lit1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2738:4: enumLiteral_0= 'lit1'
                    {

                    				markLeaf();
                    			
                    enumLiteral_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleTransientSerializeables1Enum9247); 

                    				doneLeaf(enumLiteral_0, elementTypeProvider.getTransientSerializeables1Enum_Lit1EnumLiteralDeclaration_0ElementType());
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2747:3: (enumLiteral_1= 'lit2' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2747:3: (enumLiteral_1= 'lit2' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/validation/idea/parser/antlr/internal/PsiInternalConcreteSyntaxValidationTestLanguage.g:2748:4: enumLiteral_1= 'lit2'
                    {

                    				markLeaf();
                    			
                    enumLiteral_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTransientSerializeables1Enum9280); 

                    				doneLeaf(enumLiteral_1, elementTypeProvider.getTransientSerializeables1Enum_Lit2EnumLiteralDeclaration_1ElementType());
                    			

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
    // $ANTLR end "ruleTransientSerializeables1Enum"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleGroup_in_ruleModel96 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAlternative_in_ruleModel142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicities_in_ruleModel188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupMultiplicities_in_ruleModel234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeMultiplicities_in_ruleModel280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignedAction_in_ruleModel326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignedActionSecond_in_ruleModel372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction1_in_ruleModel418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction2_in_ruleModel464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction3_in_ruleModel510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1_in_ruleModel556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2_in_ruleModel602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination1_in_ruleModel648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination2_in_ruleModel694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination3_in_ruleModel740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination4_in_ruleModel786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList1_in_ruleModel832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList2_in_ruleModel878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList3_in_ruleModel924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList4_in_ruleModel970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList5_in_ruleModel1016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList1_in_ruleModel1062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList2_in_ruleModel1108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientObject_in_ruleModel1154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientSerializeables1_in_ruleModel1200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStaticSimplification_in_ruleModel1246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoVersion_in_ruleModel1292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHeuristic1_in_ruleModel1338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup1369 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleGroup1375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSimpleGroup1398 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup1425 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup1463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative1494 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAlternative1500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleSimpleAlternative1523 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleSimpleAlternative1550 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative1587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSimpleAlternative1641 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative1678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities1724 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleMultiplicities1730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSimpleMultiplicities1753 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1780 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSimpleMultiplicities1805 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1832 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSimpleMultiplicities1858 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1885 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleSimpleMultiplicities1911 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1938 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities1970 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupMultiplicities1976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleGroupMultiplicities1999 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2026 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleGroupMultiplicities2051 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2086 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2131 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleGroupMultiplicities2164 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2199 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2244 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleGroupMultiplicities2277 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2312 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities2357 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities2396 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeMultiplicities2402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleAlternativeMultiplicities2425 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2460 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_13_in_ruleAlternativeMultiplicities2506 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2543 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAlternativeMultiplicities2584 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2619 = new BitSet(new long[]{0x0000000000090010L});
        public static final BitSet FOLLOW_16_in_ruleAlternativeMultiplicities2665 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2702 = new BitSet(new long[]{0x0000000000090010L});
        public static final BitSet FOLLOW_19_in_ruleAlternativeMultiplicities2743 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2778 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_20_in_ruleAlternativeMultiplicities2824 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities2861 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_ruleAssignedAction_in_entryRuleAssignedAction2908 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignedAction2914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAssignedAction2937 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedAction2964 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedAction3026 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAssignedActionSecond_in_entryRuleAssignedActionSecond3065 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignedActionSecond3071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleAssignedActionSecond3094 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedActionSecond3121 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleAssignedActionSecond3146 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedActionSecond3173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction1_in_entryRuleUnassignedAction13204 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction13210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleUnassignedAction13246 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction13273 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction13311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction2_in_entryRuleUnassignedAction23343 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction23349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleUnassignedAction23385 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction23412 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction23450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction3_in_entryRuleUnassignedAction33482 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction33488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleUnassignedAction33511 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleUnassignedAction33538 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_14_in_ruleUnassignedAction33596 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction33653 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction33691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1_in_entryRuleUnassignedRuleCall13723 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall13729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleUnassignedRuleCall13752 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1Sub_in_ruleUnassignedRuleCall13764 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall13791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1Sub_in_entryRuleUnassignedRuleCall1Sub3822 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall1Sub3828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall1Sub3857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2_in_entryRuleUnassignedRuleCall23882 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall23888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnassignedRuleCall23911 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2Sub_in_ruleUnassignedRuleCall23923 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall23950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2Sub_in_entryRuleUnassignedRuleCall2Sub3981 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall2Sub3987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination1_in_entryRuleCombination14020 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination14026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleCombination14049 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination14076 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleCombination14107 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination14139 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleCombination14184 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination14226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination14297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination2_in_entryRuleCombination24344 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination24350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleCombination24373 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination24400 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_13_in_ruleCombination24438 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination24475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination24546 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination24598 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleCombination3_in_entryRuleCombination34645 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination34651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleCombination34674 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination34709 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCombination34763 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCombination34817 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_ruleCombination4_in_entryRuleCombination44856 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination44862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleCombination44885 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleCombination44905 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination44937 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination44982 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination45027 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_ruleList1_in_entryRuleList15066 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList15072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleList15095 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList15122 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList15153 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList15185 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_ruleList2_in_entryRuleList25224 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList25230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleList25253 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList25288 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList25325 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList25362 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_ruleList3_in_entryRuleList35410 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList35416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleList35445 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList35486 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList35529 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList35571 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_16_in_ruleList35635 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList35667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList4_in_entryRuleList45705 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList45711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleList45734 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList45761 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_34_in_ruleList45792 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList45824 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_16_in_ruleList45857 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList45884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList5_in_entryRuleList55915 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList55921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleList55944 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList55988 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_34_in_ruleList56031 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList56073 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_16_in_ruleList56118 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList56155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList56217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList1_in_entryRuleAltList16255 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAltList16261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleAltList16284 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList16328 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList16380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleAltList16434 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList16471 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList16523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleAltList16577 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList16614 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList16666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList2_in_entryRuleAltList26713 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAltList26719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleAltList26742 = new BitSet(new long[]{0x0000020000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList26786 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList26838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleAltList26892 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList26929 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_34_in_ruleAltList26972 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList27014 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList27076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientObject_in_entryRuleTransientObject7122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransientObject7128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleTransientObject7151 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientObject7186 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTransientObjectSub_in_ruleTransientObject7231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientObjectSub_in_entryRuleTransientObjectSub7270 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransientObjectSub7276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientObjectSub7312 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientObjectSub7350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientSerializeables1_in_entryRuleTransientSerializeables17381 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransientSerializeables17387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleTransientSerializeables17410 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientSerializeables17445 = new BitSet(new long[]{0x0030000000000000L});
        public static final BitSet FOLLOW_ruleTransientSerializeables1Enum_in_ruleTransientSerializeables17490 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientSerializeables17544 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTransientSerializeables17589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStaticSimplification_in_entryRuleStaticSimplification7628 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStaticSimplification7634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleStaticSimplification7657 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_13_in_ruleStaticSimplification7677 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStaticSimplification7743 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleStaticSimplification7781 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStaticSimplification7822 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleStaticSimplification7860 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleStaticSimplification7884 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStaticSimplification7921 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleTwoVersion_in_entryRuleTwoVersion7969 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoVersion7975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleTwoVersion7998 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTwoVersionNo1_in_ruleTwoVersion8016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoVersionNo2_in_ruleTwoVersion8040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoVersionNo1_in_entryRuleTwoVersionNo18065 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoVersionNo18071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo18107 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo18146 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_46_in_ruleTwoVersionNo18171 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo18206 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo18251 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_47_in_ruleTwoVersionNo18285 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo18312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoVersionNo2_in_entryRuleTwoVersionNo28344 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoVersionNo28350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo28386 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo28425 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleTwoVersionNo28450 = new BitSet(new long[]{0x0002000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo28485 = new BitSet(new long[]{0x0002000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo28530 = new BitSet(new long[]{0x0002000000000010L});
        public static final BitSet FOLLOW_49_in_ruleTwoVersionNo28564 = new BitSet(new long[]{0x0004000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo28591 = new BitSet(new long[]{0x0004000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo28647 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo28699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleTwoVersionNo28753 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo28790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHeuristic1_in_entryRuleHeuristic18837 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHeuristic18843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleHeuristic18866 = new BitSet(new long[]{0x0000000000016002L});
        public static final BitSet FOLLOW_13_in_ruleHeuristic18886 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic18918 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic18963 = new BitSet(new long[]{0x0000000000016002L});
        public static final BitSet FOLLOW_14_in_ruleHeuristic19002 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic19034 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic19079 = new BitSet(new long[]{0x0000000000014002L});
        public static final BitSet FOLLOW_16_in_ruleHeuristic19118 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic19150 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic19195 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_52_in_ruleTransientSerializeables1Enum9247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleTransientSerializeables1Enum9280 = new BitSet(new long[]{0x0000000000000002L});
    }


}