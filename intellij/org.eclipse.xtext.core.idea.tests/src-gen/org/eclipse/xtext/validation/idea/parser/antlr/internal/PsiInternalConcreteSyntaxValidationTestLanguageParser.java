package org.eclipse.xtext.validation.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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
    public String getGrammarFileName() { return "PsiInternalConcreteSyntaxValidationTestLanguage.g"; }



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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) ) ;
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

        Boolean lv_x13_12_0 = null;

        Boolean lv_x14_13_0 = null;

        Boolean lv_x15_14_0 = null;

        Boolean lv_x16_15_0 = null;

        Boolean lv_x17_16_0 = null;

        Boolean lv_x18_17_0 = null;

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


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:60:1: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:61:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:61:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:62:3: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:62:3: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:63:4: (lv_x1_0_0= ruleSimpleGroup )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:63:4: (lv_x1_0_0= ruleSimpleGroup )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:64:5: lv_x1_0_0= ruleSimpleGroup
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:78:3: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:78:3: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:79:4: (lv_x2_1_0= ruleSimpleAlternative )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:79:4: (lv_x2_1_0= ruleSimpleAlternative )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:80:5: lv_x2_1_0= ruleSimpleAlternative
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:94:3: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:94:3: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:95:4: (lv_x3_2_0= ruleSimpleMultiplicities )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:95:4: (lv_x3_2_0= ruleSimpleMultiplicities )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:96:5: lv_x3_2_0= ruleSimpleMultiplicities
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:110:3: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:110:3: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:111:4: (lv_x4_3_0= ruleGroupMultiplicities )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:111:4: (lv_x4_3_0= ruleGroupMultiplicities )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:112:5: lv_x4_3_0= ruleGroupMultiplicities
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:126:3: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:126:3: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:127:4: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:127:4: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:128:5: lv_x5_4_0= ruleAlternativeMultiplicities
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:142:3: ( (lv_x6_5_0= ruleAssignedAction ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:142:3: ( (lv_x6_5_0= ruleAssignedAction ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:143:4: (lv_x6_5_0= ruleAssignedAction )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:143:4: (lv_x6_5_0= ruleAssignedAction )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:144:5: lv_x6_5_0= ruleAssignedAction
                    {

                    					markComposite(elementTypeProvider.getModel_X6AssignedActionParserRuleCall_5_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x6_5_0=ruleAssignedAction();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:158:3: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:158:3: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:159:4: (lv_x7_6_0= ruleAssignedActionSecond )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:159:4: (lv_x7_6_0= ruleAssignedActionSecond )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:160:5: lv_x7_6_0= ruleAssignedActionSecond
                    {

                    					markComposite(elementTypeProvider.getModel_X7AssignedActionSecondParserRuleCall_6_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x7_6_0=ruleAssignedActionSecond();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:174:3: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:174:3: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:175:4: (lv_x8_7_0= ruleUnassignedAction1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:175:4: (lv_x8_7_0= ruleUnassignedAction1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:176:5: lv_x8_7_0= ruleUnassignedAction1
                    {

                    					markComposite(elementTypeProvider.getModel_X8UnassignedAction1ParserRuleCall_7_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x8_7_0=ruleUnassignedAction1();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:190:3: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:190:3: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:191:4: (lv_x9_8_0= ruleUnassignedAction2 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:191:4: (lv_x9_8_0= ruleUnassignedAction2 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:192:5: lv_x9_8_0= ruleUnassignedAction2
                    {

                    					markComposite(elementTypeProvider.getModel_X9UnassignedAction2ParserRuleCall_8_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x9_8_0=ruleUnassignedAction2();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:206:3: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:206:3: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:207:4: (lv_x10_9_0= ruleUnassignedAction3 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:207:4: (lv_x10_9_0= ruleUnassignedAction3 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:208:5: lv_x10_9_0= ruleUnassignedAction3
                    {

                    					markComposite(elementTypeProvider.getModel_X10UnassignedAction3ParserRuleCall_9_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x10_9_0=ruleUnassignedAction3();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:222:3: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:222:3: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:223:4: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:223:4: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:224:5: lv_x11_10_0= ruleUnassignedRuleCall1
                    {

                    					markComposite(elementTypeProvider.getModel_X11UnassignedRuleCall1ParserRuleCall_10_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x11_10_0=ruleUnassignedRuleCall1();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:238:3: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:238:3: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:239:4: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:239:4: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:240:5: lv_x12_11_0= ruleUnassignedRuleCall2
                    {

                    					markComposite(elementTypeProvider.getModel_X12UnassignedRuleCall2ParserRuleCall_11_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x12_11_0=ruleUnassignedRuleCall2();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:254:3: ( (lv_x13_12_0= ruleCombination1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:254:3: ( (lv_x13_12_0= ruleCombination1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:255:4: (lv_x13_12_0= ruleCombination1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:255:4: (lv_x13_12_0= ruleCombination1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:256:5: lv_x13_12_0= ruleCombination1
                    {

                    					markComposite(elementTypeProvider.getModel_X13Combination1ParserRuleCall_12_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x13_12_0=ruleCombination1();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:270:3: ( (lv_x14_13_0= ruleCombination2 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:270:3: ( (lv_x14_13_0= ruleCombination2 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:271:4: (lv_x14_13_0= ruleCombination2 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:271:4: (lv_x14_13_0= ruleCombination2 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:272:5: lv_x14_13_0= ruleCombination2
                    {

                    					markComposite(elementTypeProvider.getModel_X14Combination2ParserRuleCall_13_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x14_13_0=ruleCombination2();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:286:3: ( (lv_x15_14_0= ruleCombination3 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:286:3: ( (lv_x15_14_0= ruleCombination3 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:287:4: (lv_x15_14_0= ruleCombination3 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:287:4: (lv_x15_14_0= ruleCombination3 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:288:5: lv_x15_14_0= ruleCombination3
                    {

                    					markComposite(elementTypeProvider.getModel_X15Combination3ParserRuleCall_14_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x15_14_0=ruleCombination3();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:302:3: ( (lv_x16_15_0= ruleCombination4 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:302:3: ( (lv_x16_15_0= ruleCombination4 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:303:4: (lv_x16_15_0= ruleCombination4 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:303:4: (lv_x16_15_0= ruleCombination4 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:304:5: lv_x16_15_0= ruleCombination4
                    {

                    					markComposite(elementTypeProvider.getModel_X16Combination4ParserRuleCall_15_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x16_15_0=ruleCombination4();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:318:3: ( (lv_x17_16_0= ruleList1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:318:3: ( (lv_x17_16_0= ruleList1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:319:4: (lv_x17_16_0= ruleList1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:319:4: (lv_x17_16_0= ruleList1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:320:5: lv_x17_16_0= ruleList1
                    {

                    					markComposite(elementTypeProvider.getModel_X17List1ParserRuleCall_16_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x17_16_0=ruleList1();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:334:3: ( (lv_x18_17_0= ruleList2 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:334:3: ( (lv_x18_17_0= ruleList2 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:335:4: (lv_x18_17_0= ruleList2 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:335:4: (lv_x18_17_0= ruleList2 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:336:5: lv_x18_17_0= ruleList2
                    {

                    					markComposite(elementTypeProvider.getModel_X18List2ParserRuleCall_17_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x18_17_0=ruleList2();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:350:3: ( (lv_x19_18_0= ruleList3 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:350:3: ( (lv_x19_18_0= ruleList3 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:351:4: (lv_x19_18_0= ruleList3 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:351:4: (lv_x19_18_0= ruleList3 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:352:5: lv_x19_18_0= ruleList3
                    {

                    					markComposite(elementTypeProvider.getModel_X19List3ParserRuleCall_18_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x19_18_0=ruleList3();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:366:3: ( (lv_x20_19_0= ruleList4 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:366:3: ( (lv_x20_19_0= ruleList4 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:367:4: (lv_x20_19_0= ruleList4 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:367:4: (lv_x20_19_0= ruleList4 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:368:5: lv_x20_19_0= ruleList4
                    {

                    					markComposite(elementTypeProvider.getModel_X20List4ParserRuleCall_19_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x20_19_0=ruleList4();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:382:3: ( (lv_x21_20_0= ruleList5 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:382:3: ( (lv_x21_20_0= ruleList5 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:383:4: (lv_x21_20_0= ruleList5 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:383:4: (lv_x21_20_0= ruleList5 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:384:5: lv_x21_20_0= ruleList5
                    {

                    					markComposite(elementTypeProvider.getModel_X21List5ParserRuleCall_20_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x21_20_0=ruleList5();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:398:3: ( (lv_x22_21_0= ruleAltList1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:398:3: ( (lv_x22_21_0= ruleAltList1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:399:4: (lv_x22_21_0= ruleAltList1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:399:4: (lv_x22_21_0= ruleAltList1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:400:5: lv_x22_21_0= ruleAltList1
                    {

                    					markComposite(elementTypeProvider.getModel_X22AltList1ParserRuleCall_21_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x22_21_0=ruleAltList1();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:414:3: ( (lv_x23_22_0= ruleAltList2 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:414:3: ( (lv_x23_22_0= ruleAltList2 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:415:4: (lv_x23_22_0= ruleAltList2 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:415:4: (lv_x23_22_0= ruleAltList2 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:416:5: lv_x23_22_0= ruleAltList2
                    {

                    					markComposite(elementTypeProvider.getModel_X23AltList2ParserRuleCall_22_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x23_22_0=ruleAltList2();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:430:3: ( (lv_x24_23_0= ruleTransientObject ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:430:3: ( (lv_x24_23_0= ruleTransientObject ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:431:4: (lv_x24_23_0= ruleTransientObject )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:431:4: (lv_x24_23_0= ruleTransientObject )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:432:5: lv_x24_23_0= ruleTransientObject
                    {

                    					markComposite(elementTypeProvider.getModel_X24TransientObjectParserRuleCall_23_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x24_23_0=ruleTransientObject();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:446:3: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:446:3: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:447:4: (lv_x25_24_0= ruleTransientSerializeables1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:447:4: (lv_x25_24_0= ruleTransientSerializeables1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:448:5: lv_x25_24_0= ruleTransientSerializeables1
                    {

                    					markComposite(elementTypeProvider.getModel_X25TransientSerializeables1ParserRuleCall_24_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x25_24_0=ruleTransientSerializeables1();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:462:3: ( (lv_x26_25_0= ruleStaticSimplification ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:462:3: ( (lv_x26_25_0= ruleStaticSimplification ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:463:4: (lv_x26_25_0= ruleStaticSimplification )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:463:4: (lv_x26_25_0= ruleStaticSimplification )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:464:5: lv_x26_25_0= ruleStaticSimplification
                    {

                    					markComposite(elementTypeProvider.getModel_X26StaticSimplificationParserRuleCall_25_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x26_25_0=ruleStaticSimplification();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:478:3: ( (lv_x27_26_0= ruleTwoVersion ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:478:3: ( (lv_x27_26_0= ruleTwoVersion ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:479:4: (lv_x27_26_0= ruleTwoVersion )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:479:4: (lv_x27_26_0= ruleTwoVersion )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:480:5: lv_x27_26_0= ruleTwoVersion
                    {

                    					markComposite(elementTypeProvider.getModel_X27TwoVersionParserRuleCall_26_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x27_26_0=ruleTwoVersion();

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:494:3: ( (lv_x28_27_0= ruleHeuristic1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:494:3: ( (lv_x28_27_0= ruleHeuristic1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:495:4: (lv_x28_27_0= ruleHeuristic1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:495:4: (lv_x28_27_0= ruleHeuristic1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:496:5: lv_x28_27_0= ruleHeuristic1
                    {

                    					markComposite(elementTypeProvider.getModel_X28Heuristic1ParserRuleCall_27_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x28_27_0=ruleHeuristic1();

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:513:1: entryRuleSimpleGroup returns [Boolean current=false] : iv_ruleSimpleGroup= ruleSimpleGroup EOF ;
    public final Boolean entryRuleSimpleGroup() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimpleGroup = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:513:53: (iv_ruleSimpleGroup= ruleSimpleGroup EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:514:2: iv_ruleSimpleGroup= ruleSimpleGroup EOF
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:520:1: ruleSimpleGroup returns [Boolean current=false] : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleSimpleGroup() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:521:1: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:522:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:522:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:523:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSimpleGroup_NumberSignDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:530:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:531:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:531:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:532:5: lv_val1_1_0= RULE_ID
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

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:547:3: ( (lv_val2_2_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:548:4: (lv_val2_2_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:548:4: (lv_val2_2_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:549:5: lv_val2_2_0= RULE_ID
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:568:1: entryRuleSimpleAlternative returns [Boolean current=false] : iv_ruleSimpleAlternative= ruleSimpleAlternative EOF ;
    public final Boolean entryRuleSimpleAlternative() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimpleAlternative = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:568:59: (iv_ruleSimpleAlternative= ruleSimpleAlternative EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:569:2: iv_ruleSimpleAlternative= ruleSimpleAlternative EOF
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:575:1: ruleSimpleAlternative returns [Boolean current=false] : (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final Boolean ruleSimpleAlternative() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val2_4_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:576:1: ( (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:577:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:577:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:578:3: otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {

            			markLeaf(elementTypeProvider.getSimpleAlternative_NumberSignDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:585:3: ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:586:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:586:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:587:5: otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getSimpleAlternative_Kw1Keyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:594:5: ( (lv_val1_2_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:595:6: (lv_val1_2_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:595:6: (lv_val1_2_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:596:7: lv_val1_2_0= RULE_ID
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:613:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:613:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:614:5: otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getSimpleAlternative_Kw2Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:621:5: ( (lv_val2_4_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:622:6: (lv_val2_4_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:622:6: (lv_val2_4_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:623:7: lv_val2_4_0= RULE_ID
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:644:1: entryRuleSimpleMultiplicities returns [Boolean current=false] : iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF ;
    public final Boolean entryRuleSimpleMultiplicities() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimpleMultiplicities = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:644:62: (iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:645:2: iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:651:1: ruleSimpleMultiplicities returns [Boolean current=false] : (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:652:1: ( (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:653:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:653:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:654:3: otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {

            			markLeaf(elementTypeProvider.getSimpleMultiplicities_NumberSignDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:661:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:662:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:662:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:663:5: lv_val1_1_0= RULE_ID
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
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:685:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:686:4: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:686:4: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:687:5: lv_val2_3_0= RULE_ID
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
            		
            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:709:3: ( (lv_val3_5_0= RULE_ID ) )+
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:710:4: (lv_val3_5_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:710:4: (lv_val3_5_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:711:5: lv_val3_5_0= RULE_ID
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
            		
            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_6);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:733:3: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:734:4: (lv_val4_7_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:734:4: (lv_val4_7_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:735:5: lv_val4_7_0= RULE_ID
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:754:1: entryRuleGroupMultiplicities returns [Boolean current=false] : iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF ;
    public final Boolean entryRuleGroupMultiplicities() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGroupMultiplicities = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:754:61: (iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:755:2: iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:761:1: ruleGroupMultiplicities returns [Boolean current=false] : (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:762:1: ( (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:763:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:763:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:764:3: otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getGroupMultiplicities_NumberSignDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:771:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:772:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:772:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:773:5: lv_val1_1_0= RULE_ID
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
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:795:3: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:796:4: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:796:4: ( (lv_val2_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:797:5: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:797:5: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:798:6: lv_val2_3_0= RULE_ID
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

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:813:4: ( (lv_val3_4_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:814:5: (lv_val3_4_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:814:5: (lv_val3_4_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:815:6: lv_val3_4_0= RULE_ID
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
            		
            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_5);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:838:3: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:839:4: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:839:4: ( (lv_val4_6_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:840:5: (lv_val4_6_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:840:5: (lv_val4_6_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:841:6: lv_val4_6_0= RULE_ID
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

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:856:4: ( (lv_val5_7_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:857:5: (lv_val5_7_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:857:5: (lv_val5_7_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:858:6: lv_val5_7_0= RULE_ID
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
            		
            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_8);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:881:3: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:882:4: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:882:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:883:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:883:5: (lv_val6_9_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:884:6: lv_val6_9_0= RULE_ID
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

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:899:4: ( (lv_val7_10_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:900:5: (lv_val7_10_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:900:5: (lv_val7_10_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:901:6: lv_val7_10_0= RULE_ID
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:921:1: entryRuleAlternativeMultiplicities returns [Boolean current=false] : iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF ;
    public final Boolean entryRuleAlternativeMultiplicities() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAlternativeMultiplicities = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:921:67: (iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:922:2: iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:928:1: ruleAlternativeMultiplicities returns [Boolean current=false] : (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:929:1: ( (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:930:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:930:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:931:3: otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {

            			markLeaf(elementTypeProvider.getAlternativeMultiplicities_NumberSignDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:938:3: ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:939:4: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:939:4: ( (lv_val2_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:940:5: (lv_val2_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:940:5: (lv_val2_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:941:6: lv_val2_1_0= RULE_ID
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:957:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:957:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:958:5: otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw1Keyword_1_1_0ElementType());
                    				
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:965:5: ( (lv_val3_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:966:6: (lv_val3_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:966:6: (lv_val3_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:967:7: lv_val3_3_0= RULE_ID
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
            		
            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:991:3: ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:992:4: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:992:4: ( (lv_val4_5_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:993:5: (lv_val4_5_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:993:5: (lv_val4_5_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:994:6: lv_val4_5_0= RULE_ID
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1010:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1010:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1011:5: otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw3Keyword_3_1_0ElementType());
            	    				
            	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_6);
            	    				
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1018:5: ( (lv_val5_7_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1019:6: (lv_val5_7_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1019:6: (lv_val5_7_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1020:7: lv_val5_7_0= RULE_ID
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
            		
            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_12); 

            			doneLeaf(otherlv_8);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1044:3: ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1045:4: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1045:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1046:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1046:5: (lv_val6_9_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1047:6: lv_val6_9_0= RULE_ID
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1063:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1063:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1064:5: otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw5Keyword_5_1_0ElementType());
            	    				
            	    otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_10);
            	    				
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1071:5: ( (lv_val7_11_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1072:6: (lv_val7_11_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1072:6: (lv_val7_11_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1073:7: lv_val7_11_0= RULE_ID
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


    // $ANTLR start "entryRuleAssignedAction"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1094:1: entryRuleAssignedAction returns [Boolean current=false] : iv_ruleAssignedAction= ruleAssignedAction EOF ;
    public final Boolean entryRuleAssignedAction() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAssignedAction = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1094:56: (iv_ruleAssignedAction= ruleAssignedAction EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1095:2: iv_ruleAssignedAction= ruleAssignedAction EOF
            {
             markComposite(elementTypeProvider.getAssignedActionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignedAction=ruleAssignedAction();

            state._fsp--;

             current =iv_ruleAssignedAction; 
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
    // $ANTLR end "entryRuleAssignedAction"


    // $ANTLR start "ruleAssignedAction"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1101:1: ruleAssignedAction returns [Boolean current=false] : (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) ;
    public final Boolean ruleAssignedAction() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1102:1: ( (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1103:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1103:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1104:3: otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+
            {

            			markLeaf(elementTypeProvider.getAssignedAction_NumberSignDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1111:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1112:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1112:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1113:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAssignedAction_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1128:3: ( () ( (lv_val1_3_0= RULE_ID ) ) )+
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1129:4: () ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1129:4: ()
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1130:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAssignedAction_AssignedActionChildAction_2_0ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1136:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1137:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1137:5: (lv_val1_3_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1138:6: lv_val1_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getAssignedAction_Val1IDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

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
        return current;
    }
    // $ANTLR end "ruleAssignedAction"


    // $ANTLR start "entryRuleAssignedActionSecond"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1158:1: entryRuleAssignedActionSecond returns [Boolean current=false] : iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF ;
    public final Boolean entryRuleAssignedActionSecond() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAssignedActionSecond = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1158:62: (iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1159:2: iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF
            {
             markComposite(elementTypeProvider.getAssignedActionSecondElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignedActionSecond=ruleAssignedActionSecond();

            state._fsp--;

             current =iv_ruleAssignedActionSecond; 
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
    // $ANTLR end "entryRuleAssignedActionSecond"


    // $ANTLR start "ruleAssignedActionSecond"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1165:1: ruleAssignedActionSecond returns [Boolean current=false] : (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) ;
    public final Boolean ruleAssignedActionSecond() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1166:1: ( (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1167:2: (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1167:2: (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1168:3: otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getAssignedActionSecond_NumberSignDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1175:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1176:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1176:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1177:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAssignedActionSecond_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getAssignedActionSecond_Kw1Keyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1199:3: ( (lv_val2_3_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1200:4: (lv_val2_3_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1200:4: (lv_val2_3_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1201:5: lv_val2_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAssignedActionSecond_Val2IDTerminalRuleCall_3_0ElementType());
            				
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val2_3_0);
            				

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
    // $ANTLR end "ruleAssignedActionSecond"


    // $ANTLR start "entryRuleUnassignedAction1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1220:1: entryRuleUnassignedAction1 returns [Boolean current=false] : iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF ;
    public final Boolean entryRuleUnassignedAction1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnassignedAction1 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1220:59: (iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1221:2: iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF
            {
             markComposite(elementTypeProvider.getUnassignedAction1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedAction1=ruleUnassignedAction1();

            state._fsp--;

             current =iv_ruleUnassignedAction1; 
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
    // $ANTLR end "entryRuleUnassignedAction1"


    // $ANTLR start "ruleUnassignedAction1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1227:1: ruleUnassignedAction1 returns [Boolean current=false] : ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final Boolean ruleUnassignedAction1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1228:1: ( ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1229:2: ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1229:2: ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1230:3: () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1230:3: ()
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1231:4: 
            {

            				precedeComposite(elementTypeProvider.getUnassignedAction1_UnassignedAction1Action_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getUnassignedAction1_NumberSignDigitEightKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1244:3: ( (lv_val1_2_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1245:4: (lv_val1_2_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1245:4: (lv_val1_2_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1246:5: lv_val1_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnassignedAction1_Val1IDTerminalRuleCall_2_0ElementType());
            				
            lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_2_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1261:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1262:4: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1262:4: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1263:5: lv_val2_3_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getUnassignedAction1_Val2IDTerminalRuleCall_3_0ElementType());
                    				
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_val2_3_0);
                    				

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
    // $ANTLR end "ruleUnassignedAction1"


    // $ANTLR start "entryRuleUnassignedAction2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1282:1: entryRuleUnassignedAction2 returns [Boolean current=false] : iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF ;
    public final Boolean entryRuleUnassignedAction2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnassignedAction2 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1282:59: (iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1283:2: iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF
            {
             markComposite(elementTypeProvider.getUnassignedAction2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedAction2=ruleUnassignedAction2();

            state._fsp--;

             current =iv_ruleUnassignedAction2; 
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
    // $ANTLR end "entryRuleUnassignedAction2"


    // $ANTLR start "ruleUnassignedAction2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1289:1: ruleUnassignedAction2 returns [Boolean current=false] : ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final Boolean ruleUnassignedAction2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1290:1: ( ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1291:2: ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1291:2: ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1292:3: () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1292:3: ()
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1293:4: 
            {

            				precedeComposite(elementTypeProvider.getUnassignedAction2_UnassignedAction2SubAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getUnassignedAction2_NumberSignDigitNineKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1306:3: ( (lv_val1_2_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1307:4: (lv_val1_2_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1307:4: (lv_val1_2_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1308:5: lv_val1_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnassignedAction2_Val1IDTerminalRuleCall_2_0ElementType());
            				
            lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_2_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1323:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1324:4: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1324:4: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1325:5: lv_val2_3_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getUnassignedAction2_Val2IDTerminalRuleCall_3_0ElementType());
                    				
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_val2_3_0);
                    				

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
    // $ANTLR end "ruleUnassignedAction2"


    // $ANTLR start "entryRuleUnassignedAction3"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1344:1: entryRuleUnassignedAction3 returns [Boolean current=false] : iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF ;
    public final Boolean entryRuleUnassignedAction3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnassignedAction3 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1344:59: (iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1345:2: iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF
            {
             markComposite(elementTypeProvider.getUnassignedAction3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedAction3=ruleUnassignedAction3();

            state._fsp--;

             current =iv_ruleUnassignedAction3; 
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
    // $ANTLR end "entryRuleUnassignedAction3"


    // $ANTLR start "ruleUnassignedAction3"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1351:1: ruleUnassignedAction3 returns [Boolean current=false] : (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) ;
    public final Boolean ruleUnassignedAction3() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_val1_5_0=null;
        Token lv_val2_6_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1352:1: ( (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1353:2: (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1353:2: (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1354:3: otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )?
            {

            			markLeaf(elementTypeProvider.getUnassignedAction3_NumberSignDigitOneDigitZeroKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1361:3: ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1362:4: (otherlv_1= 'kw1' () )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1362:4: (otherlv_1= 'kw1' () )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1363:5: otherlv_1= 'kw1' ()
                    {

                    					markLeaf(elementTypeProvider.getUnassignedAction3_Kw1Keyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1370:5: ()
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1371:6: 
                    {

                    						precedeComposite(elementTypeProvider.getUnassignedAction3_UnassignedAction2Sub1Action_1_0_1ElementType());
                    						doneComposite();
                    						associateWithSemanticElement();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1379:4: (otherlv_3= 'kw2' () )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1379:4: (otherlv_3= 'kw2' () )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1380:5: otherlv_3= 'kw2' ()
                    {

                    					markLeaf(elementTypeProvider.getUnassignedAction3_Kw2Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1387:5: ()
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1388:6: 
                    {

                    						precedeComposite(elementTypeProvider.getUnassignedAction3_UnassignedAction2Sub2Action_1_1_1ElementType());
                    						doneComposite();
                    						associateWithSemanticElement();
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1396:3: ( (lv_val1_5_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1397:4: (lv_val1_5_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1397:4: (lv_val1_5_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1398:5: lv_val1_5_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnassignedAction3_Val1IDTerminalRuleCall_2_0ElementType());
            				
            lv_val1_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_5_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1413:3: ( (lv_val2_6_0= RULE_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1414:4: (lv_val2_6_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1414:4: (lv_val2_6_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1415:5: lv_val2_6_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getUnassignedAction3_Val2IDTerminalRuleCall_3_0ElementType());
                    				
                    lv_val2_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_val2_6_0);
                    				

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
    // $ANTLR end "ruleUnassignedAction3"


    // $ANTLR start "entryRuleUnassignedRuleCall1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1434:1: entryRuleUnassignedRuleCall1 returns [Boolean current=false] : iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF ;
    public final Boolean entryRuleUnassignedRuleCall1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnassignedRuleCall1 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1434:61: (iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1435:2: iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF
            {
             markComposite(elementTypeProvider.getUnassignedRuleCall1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedRuleCall1=ruleUnassignedRuleCall1();

            state._fsp--;

             current =iv_ruleUnassignedRuleCall1; 
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
    // $ANTLR end "entryRuleUnassignedRuleCall1"


    // $ANTLR start "ruleUnassignedRuleCall1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1441:1: ruleUnassignedRuleCall1 returns [Boolean current=false] : (otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleUnassignedRuleCall1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val2_2_0=null;
        Boolean this_UnassignedRuleCall1Sub_1 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1442:1: ( (otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1443:2: (otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1443:2: (otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1444:3: otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getUnassignedRuleCall1_NumberSignDigitOneDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getUnassignedRuleCall1_UnassignedRuleCall1SubParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_UnassignedRuleCall1Sub_1=ruleUnassignedRuleCall1Sub();

            state._fsp--;


            			current = this_UnassignedRuleCall1Sub_1;
            			doneComposite();
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1459:3: ( (lv_val2_2_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1460:4: (lv_val2_2_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1460:4: (lv_val2_2_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1461:5: lv_val2_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnassignedRuleCall1_Val2IDTerminalRuleCall_2_0ElementType());
            				
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
    // $ANTLR end "ruleUnassignedRuleCall1"


    // $ANTLR start "entryRuleUnassignedRuleCall1Sub"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1480:1: entryRuleUnassignedRuleCall1Sub returns [Boolean current=false] : iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF ;
    public final Boolean entryRuleUnassignedRuleCall1Sub() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnassignedRuleCall1Sub = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1480:64: (iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1481:2: iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF
            {
             markComposite(elementTypeProvider.getUnassignedRuleCall1SubElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedRuleCall1Sub=ruleUnassignedRuleCall1Sub();

            state._fsp--;

             current =iv_ruleUnassignedRuleCall1Sub; 
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
    // $ANTLR end "entryRuleUnassignedRuleCall1Sub"


    // $ANTLR start "ruleUnassignedRuleCall1Sub"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1487:1: ruleUnassignedRuleCall1Sub returns [Boolean current=false] : ( (lv_val1_0_0= RULE_ID ) ) ;
    public final Boolean ruleUnassignedRuleCall1Sub() throws RecognitionException {
        Boolean current = false;

        Token lv_val1_0_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1488:1: ( ( (lv_val1_0_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1489:2: ( (lv_val1_0_0= RULE_ID ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1489:2: ( (lv_val1_0_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1490:3: (lv_val1_0_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1490:3: (lv_val1_0_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1491:4: lv_val1_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getUnassignedRuleCall1Sub_Val1IDTerminalRuleCall_0ElementType());
            			
            lv_val1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				doneLeaf(lv_val1_0_0);
            			

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
    // $ANTLR end "ruleUnassignedRuleCall1Sub"


    // $ANTLR start "entryRuleUnassignedRuleCall2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1509:1: entryRuleUnassignedRuleCall2 returns [Boolean current=false] : iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF ;
    public final Boolean entryRuleUnassignedRuleCall2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnassignedRuleCall2 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1509:61: (iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1510:2: iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF
            {
             markComposite(elementTypeProvider.getUnassignedRuleCall2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedRuleCall2=ruleUnassignedRuleCall2();

            state._fsp--;

             current =iv_ruleUnassignedRuleCall2; 
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
    // $ANTLR end "entryRuleUnassignedRuleCall2"


    // $ANTLR start "ruleUnassignedRuleCall2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1516:1: ruleUnassignedRuleCall2 returns [Boolean current=false] : (otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleUnassignedRuleCall2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val2_2_0=null;
        Boolean this_UnassignedRuleCall2Sub_1 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1517:1: ( (otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1518:2: (otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1518:2: (otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1519:3: otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getUnassignedRuleCall2_NumberSignDigitOneDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getUnassignedRuleCall2_UnassignedRuleCall2SubParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_UnassignedRuleCall2Sub_1=ruleUnassignedRuleCall2Sub();

            state._fsp--;


            			current = this_UnassignedRuleCall2Sub_1;
            			doneComposite();
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1534:3: ( (lv_val2_2_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1535:4: (lv_val2_2_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1535:4: (lv_val2_2_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1536:5: lv_val2_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnassignedRuleCall2_Val2IDTerminalRuleCall_2_0ElementType());
            				
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
    // $ANTLR end "ruleUnassignedRuleCall2"


    // $ANTLR start "entryRuleUnassignedRuleCall2Sub"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1555:1: entryRuleUnassignedRuleCall2Sub returns [Boolean current=false] : iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF ;
    public final Boolean entryRuleUnassignedRuleCall2Sub() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnassignedRuleCall2Sub = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1555:64: (iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1556:2: iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF
            {
             markComposite(elementTypeProvider.getUnassignedRuleCall2SubElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedRuleCall2Sub=ruleUnassignedRuleCall2Sub();

            state._fsp--;

             current =iv_ruleUnassignedRuleCall2Sub; 
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
    // $ANTLR end "entryRuleUnassignedRuleCall2Sub"


    // $ANTLR start "ruleUnassignedRuleCall2Sub"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1562:1: ruleUnassignedRuleCall2Sub returns [Boolean current=false] : () ;
    public final Boolean ruleUnassignedRuleCall2Sub() throws RecognitionException {
        Boolean current = false;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1563:1: ( () )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1564:2: ()
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1564:2: ()
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1565:3: 
            {

            			precedeComposite(elementTypeProvider.getUnassignedRuleCall2Sub_UnassignedRuleCall2SubActionActionElementType());
            			doneComposite();
            			associateWithSemanticElement();
            		

            }


            }

        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnassignedRuleCall2Sub"


    // $ANTLR start "entryRuleCombination1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1574:1: entryRuleCombination1 returns [Boolean current=false] : iv_ruleCombination1= ruleCombination1 EOF ;
    public final Boolean entryRuleCombination1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCombination1 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1574:54: (iv_ruleCombination1= ruleCombination1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1575:2: iv_ruleCombination1= ruleCombination1 EOF
            {
             markComposite(elementTypeProvider.getCombination1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCombination1=ruleCombination1();

            state._fsp--;

             current =iv_ruleCombination1; 
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
    // $ANTLR end "entryRuleCombination1"


    // $ANTLR start "ruleCombination1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1581:1: ruleCombination1 returns [Boolean current=false] : (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) ;
    public final Boolean ruleCombination1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token lv_val3_5_0=null;
        Token lv_val4_6_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1582:1: ( (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1583:2: (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1583:2: (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1584:3: otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            {

            			markLeaf(elementTypeProvider.getCombination1_NumberSignDigitOneDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1591:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1592:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1592:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1593:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getCombination1_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1608:3: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1609:4: otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
                    {

                    				markLeaf(elementTypeProvider.getCombination1_Kw1Keyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1616:4: ( (lv_val2_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1617:5: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1617:5: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1618:6: lv_val2_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getCombination1_Val2IDTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val2_3_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1633:4: ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
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
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1634:5: (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            {
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1634:5: (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1635:6: otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )
                            {

                            						markLeaf(elementTypeProvider.getCombination1_Kw2Keyword_2_2_0_0ElementType());
                            					
                            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                            						doneLeaf(otherlv_4);
                            					
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1642:6: ( (lv_val3_5_0= RULE_ID ) )
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1643:7: (lv_val3_5_0= RULE_ID )
                            {
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1643:7: (lv_val3_5_0= RULE_ID )
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1644:8: lv_val3_5_0= RULE_ID
                            {

                            								markLeaf(elementTypeProvider.getCombination1_Val3IDTerminalRuleCall_2_2_0_1_0ElementType());
                            							
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
                        case 2 :
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1661:5: ( (lv_val4_6_0= RULE_ID ) )
                            {
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1661:5: ( (lv_val4_6_0= RULE_ID ) )
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1662:6: (lv_val4_6_0= RULE_ID )
                            {
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1662:6: (lv_val4_6_0= RULE_ID )
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1663:7: lv_val4_6_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getCombination1_Val4IDTerminalRuleCall_2_2_1_0ElementType());
                            						
                            lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            							doneLeaf(lv_val4_6_0);
                            						

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
        return current;
    }
    // $ANTLR end "ruleCombination1"


    // $ANTLR start "entryRuleCombination2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1684:1: entryRuleCombination2 returns [Boolean current=false] : iv_ruleCombination2= ruleCombination2 EOF ;
    public final Boolean entryRuleCombination2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCombination2 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1684:54: (iv_ruleCombination2= ruleCombination2 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1685:2: iv_ruleCombination2= ruleCombination2 EOF
            {
             markComposite(elementTypeProvider.getCombination2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCombination2=ruleCombination2();

            state._fsp--;

             current =iv_ruleCombination2; 
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
    // $ANTLR end "entryRuleCombination2"


    // $ANTLR start "ruleCombination2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1691:1: ruleCombination2 returns [Boolean current=false] : (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) ;
    public final Boolean ruleCombination2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;
        Token lv_val4_5_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1692:1: ( (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1693:2: (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1693:2: (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1694:3: otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
            {

            			markLeaf(elementTypeProvider.getCombination2_NumberSignDigitOneDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1701:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1702:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1702:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1703:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getCombination2_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1718:3: ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1719:4: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1719:4: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1720:5: otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getCombination2_Kw1Keyword_2_0_0ElementType());
                    				
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1727:5: ( (lv_val2_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1728:6: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1728:6: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1729:7: lv_val2_3_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getCombination2_Val2IDTerminalRuleCall_2_0_1_0ElementType());
                    						
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val2_3_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1746:4: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1746:4: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1747:5: ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1747:5: ( (lv_val3_4_0= RULE_ID ) )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1748:6: (lv_val3_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1748:6: (lv_val3_4_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1749:7: lv_val3_4_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getCombination2_Val3IDTerminalRuleCall_2_1_0_0ElementType());
                    	    						
                    	    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

                    	    							doneLeaf(lv_val3_4_0);
                    	    						

                    	    }


                    	    }

                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1764:5: ( (lv_val4_5_0= RULE_ID ) )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1765:6: (lv_val4_5_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1765:6: (lv_val4_5_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1766:7: lv_val4_5_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getCombination2_Val4IDTerminalRuleCall_2_1_1_0ElementType());
                    	    						
                    	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

                    	    							doneLeaf(lv_val4_5_0);
                    	    						

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
        return current;
    }
    // $ANTLR end "ruleCombination2"


    // $ANTLR start "entryRuleCombination3"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1787:1: entryRuleCombination3 returns [Boolean current=false] : iv_ruleCombination3= ruleCombination3 EOF ;
    public final Boolean entryRuleCombination3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCombination3 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1787:54: (iv_ruleCombination3= ruleCombination3 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1788:2: iv_ruleCombination3= ruleCombination3 EOF
            {
             markComposite(elementTypeProvider.getCombination3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCombination3=ruleCombination3();

            state._fsp--;

             current =iv_ruleCombination3; 
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
    // $ANTLR end "entryRuleCombination3"


    // $ANTLR start "ruleCombination3"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1794:1: ruleCombination3 returns [Boolean current=false] : (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) ;
    public final Boolean ruleCombination3() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token lv_val3_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1795:1: ( (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1796:2: (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1796:2: (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1797:3: otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
            {

            			markLeaf(elementTypeProvider.getCombination3_NumberSignDigitOneDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_15); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1804:3: ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1805:4: ( (lv_val1_1_0= RULE_ID ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1805:4: ( (lv_val1_1_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1806:5: (lv_val1_1_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1806:5: (lv_val1_1_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1807:6: lv_val1_1_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getCombination3_Val1IDTerminalRuleCall_1_0_0ElementType());
            	    					
            	    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_val1_1_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1823:4: ( (lv_val2_2_0= RULE_INT ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1823:4: ( (lv_val2_2_0= RULE_INT ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1824:5: (lv_val2_2_0= RULE_INT )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1824:5: (lv_val2_2_0= RULE_INT )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1825:6: lv_val2_2_0= RULE_INT
            	    {

            	    						markLeaf(elementTypeProvider.getCombination3_Val2INTTerminalRuleCall_1_1_0ElementType());
            	    					
            	    lv_val2_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_15); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_val2_2_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1841:4: ( (lv_val3_3_0= RULE_STRING ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1841:4: ( (lv_val3_3_0= RULE_STRING ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1842:5: (lv_val3_3_0= RULE_STRING )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1842:5: (lv_val3_3_0= RULE_STRING )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1843:6: lv_val3_3_0= RULE_STRING
            	    {

            	    						markLeaf(elementTypeProvider.getCombination3_Val3STRINGTerminalRuleCall_1_2_0ElementType());
            	    					
            	    lv_val3_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_15); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_val3_3_0);
            	    					

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
        return current;
    }
    // $ANTLR end "ruleCombination3"


    // $ANTLR start "entryRuleCombination4"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1863:1: entryRuleCombination4 returns [Boolean current=false] : iv_ruleCombination4= ruleCombination4 EOF ;
    public final Boolean entryRuleCombination4() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCombination4 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1863:54: (iv_ruleCombination4= ruleCombination4 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1864:2: iv_ruleCombination4= ruleCombination4 EOF
            {
             markComposite(elementTypeProvider.getCombination4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCombination4=ruleCombination4();

            state._fsp--;

             current =iv_ruleCombination4; 
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
    // $ANTLR end "entryRuleCombination4"


    // $ANTLR start "ruleCombination4"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1870:1: ruleCombination4 returns [Boolean current=false] : (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) ;
    public final Boolean ruleCombination4() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1871:1: ( (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1872:2: (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1872:2: (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1873:3: otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
            {

            			markLeaf(elementTypeProvider.getCombination4_NumberSignDigitOneDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1880:3: (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1881:4: otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getCombination4_GroupKeyword_1_0ElementType());
            	    			
            	    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_1);
            	    			
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1888:4: ( (lv_val1_2_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1889:5: (lv_val1_2_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1889:5: (lv_val1_2_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1890:6: lv_val1_2_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getCombination4_Val1IDTerminalRuleCall_1_1_0ElementType());
            	    					
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_val1_2_0);
            	    					

            	    }


            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1905:4: ( (lv_val2_3_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1906:5: (lv_val2_3_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1906:5: (lv_val2_3_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1907:6: lv_val2_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getCombination4_Val2IDTerminalRuleCall_1_2_0ElementType());
            	    					
            	    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_val2_3_0);
            	    					

            	    }


            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1922:4: ( (lv_val3_4_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1923:5: (lv_val3_4_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1923:5: (lv_val3_4_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1924:6: lv_val3_4_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getCombination4_Val3IDTerminalRuleCall_1_3_0ElementType());
            	    					
            	    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_val3_4_0);
            	    					

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
        return current;
    }
    // $ANTLR end "ruleCombination4"


    // $ANTLR start "entryRuleList1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1944:1: entryRuleList1 returns [Boolean current=false] : iv_ruleList1= ruleList1 EOF ;
    public final Boolean entryRuleList1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleList1 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1944:47: (iv_ruleList1= ruleList1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1945:2: iv_ruleList1= ruleList1 EOF
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1951:1: ruleList1 returns [Boolean current=false] : (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final Boolean ruleList1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1952:1: ( (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1953:2: (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1953:2: (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1954:3: otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getList1_NumberSignDigitOneDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1961:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1962:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1962:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1963:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getList1_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1978:3: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==34) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1979:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getList1_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1986:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1987:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1987:5: (lv_val1_3_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1988:6: lv_val1_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getList1_Val1IDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

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
        return current;
    }
    // $ANTLR end "ruleList1"


    // $ANTLR start "entryRuleList2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2008:1: entryRuleList2 returns [Boolean current=false] : iv_ruleList2= ruleList2 EOF ;
    public final Boolean entryRuleList2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleList2 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2008:47: (iv_ruleList2= ruleList2 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2009:2: iv_ruleList2= ruleList2 EOF
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2015:1: ruleList2 returns [Boolean current=false] : (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) ;
    public final Boolean ruleList2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2016:1: ( (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2017:2: (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2017:2: (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2018:3: otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            {

            			markLeaf(elementTypeProvider.getList2_NumberSignDigitOneDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2025:3: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2026:4: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2026:4: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2027:5: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2027:5: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2028:6: lv_val1_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getList2_Val1IDTerminalRuleCall_1_0_0ElementType());
                    					
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val1_1_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2043:4: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==34) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2044:5: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getList2_CommaKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2051:5: ( (lv_val1_3_0= RULE_ID ) )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2052:6: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2052:6: (lv_val1_3_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2053:7: lv_val1_3_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getList2_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    	    						
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

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
        return current;
    }
    // $ANTLR end "ruleList2"


    // $ANTLR start "entryRuleList3"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2074:1: entryRuleList3 returns [Boolean current=false] : iv_ruleList3= ruleList3 EOF ;
    public final Boolean entryRuleList3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleList3 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2074:47: (iv_ruleList3= ruleList3 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2075:2: iv_ruleList3= ruleList3 EOF
            {
             markComposite(elementTypeProvider.getList3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleList3=ruleList3();

            state._fsp--;

             current =iv_ruleList3; 
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
    // $ANTLR end "entryRuleList3"


    // $ANTLR start "ruleList3"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2081:1: ruleList3 returns [Boolean current=false] : ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) ;
    public final Boolean ruleList3() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2082:1: ( ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2083:2: ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2083:2: ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2084:3: (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2084:3: (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2085:4: otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    {

                    				markLeaf(elementTypeProvider.getList3_NumberSignDigitOneDigitNineKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2092:4: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2093:5: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2093:5: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2094:6: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2094:6: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2095:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getList3_Val1IDTerminalRuleCall_0_1_0_0ElementType());
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val1_1_0);
                    						

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2110:5: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==34) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2111:6: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {

                    	    						markLeaf(elementTypeProvider.getList3_CommaKeyword_0_1_1_0ElementType());
                    	    					
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    	    						doneLeaf(otherlv_2);
                    	    					
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2118:6: ( (lv_val1_3_0= RULE_ID ) )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2119:7: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2119:7: (lv_val1_3_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2120:8: lv_val1_3_0= RULE_ID
                    	    {

                    	    								markLeaf(elementTypeProvider.getList3_Val1IDTerminalRuleCall_0_1_1_1_0ElementType());
                    	    							
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

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
                    	    break loop26;
                        }
                    } while (true);


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2139:3: (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2139:3: (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2140:4: otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getList3_Kw3Keyword_1_0ElementType());
                    			
                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2147:4: ( (lv_val2_5_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2148:5: (lv_val2_5_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2148:5: (lv_val2_5_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2149:6: lv_val2_5_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getList3_Val2IDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val2_5_0);
                    					

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
    // $ANTLR end "ruleList3"


    // $ANTLR start "entryRuleList4"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2169:1: entryRuleList4 returns [Boolean current=false] : iv_ruleList4= ruleList4 EOF ;
    public final Boolean entryRuleList4() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleList4 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2169:47: (iv_ruleList4= ruleList4 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2170:2: iv_ruleList4= ruleList4 EOF
            {
             markComposite(elementTypeProvider.getList4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleList4=ruleList4();

            state._fsp--;

             current =iv_ruleList4; 
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
    // $ANTLR end "entryRuleList4"


    // $ANTLR start "ruleList4"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2176:1: ruleList4 returns [Boolean current=false] : (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ;
    public final Boolean ruleList4() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2177:1: ( (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2178:2: (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2178:2: (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2179:3: otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getList4_NumberSignDigitTwoDigitZeroKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2186:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2187:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2187:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2188:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getList4_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2203:3: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==34) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2204:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getList4_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2211:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2212:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2212:5: (lv_val1_3_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2213:6: lv_val1_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getList4_Val1IDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

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
            	    break loop28;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getList4_Kw3Keyword_3ElementType());
            		
            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2236:3: ( (lv_val2_5_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2237:4: (lv_val2_5_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2237:4: (lv_val2_5_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2238:5: lv_val2_5_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getList4_Val2IDTerminalRuleCall_4_0ElementType());
            				
            lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val2_5_0);
            				

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
    // $ANTLR end "ruleList4"


    // $ANTLR start "entryRuleList5"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2257:1: entryRuleList5 returns [Boolean current=false] : iv_ruleList5= ruleList5 EOF ;
    public final Boolean entryRuleList5() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleList5 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2257:47: (iv_ruleList5= ruleList5 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2258:2: iv_ruleList5= ruleList5 EOF
            {
             markComposite(elementTypeProvider.getList5ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleList5=ruleList5();

            state._fsp--;

             current =iv_ruleList5; 
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
    // $ANTLR end "entryRuleList5"


    // $ANTLR start "ruleList5"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2264:1: ruleList5 returns [Boolean current=false] : (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) ;
    public final Boolean ruleList5() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;
        Token lv_val3_6_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2265:1: ( (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2266:2: (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2266:2: (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2267:3: otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
            {

            			markLeaf(elementTypeProvider.getList5_NumberSignDigitTwoDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2274:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==16||LA30_1==34) ) {
                    alt30=1;
                }
                else if ( (LA30_1==EOF) ) {
                    alt30=2;
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2275:4: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2275:4: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2276:5: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2276:5: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2277:6: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2277:6: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2278:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getList5_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val1_1_0);
                    						

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2293:5: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==34) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2294:6: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {

                    	    						markLeaf(elementTypeProvider.getList5_CommaKeyword_1_0_1_0ElementType());
                    	    					
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    	    						doneLeaf(otherlv_2);
                    	    					
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2301:6: ( (lv_val1_3_0= RULE_ID ) )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2302:7: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2302:7: (lv_val1_3_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2303:8: lv_val1_3_0= RULE_ID
                    	    {

                    	    								markLeaf(elementTypeProvider.getList5_Val1IDTerminalRuleCall_1_0_1_1_0ElementType());
                    	    							
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

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
                    	    break loop29;
                        }
                    } while (true);


                    					markLeaf(elementTypeProvider.getList5_Kw3Keyword_1_0_2ElementType());
                    				
                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_4);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2326:5: ( (lv_val2_5_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2327:6: (lv_val2_5_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2327:6: (lv_val2_5_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2328:7: lv_val2_5_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getList5_Val2IDTerminalRuleCall_1_0_3_0ElementType());
                    						
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val2_5_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2345:4: ( (lv_val3_6_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2345:4: ( (lv_val3_6_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2346:5: (lv_val3_6_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2346:5: (lv_val3_6_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2347:6: lv_val3_6_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getList5_Val3IDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val3_6_0);
                    					

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
    // $ANTLR end "ruleList5"


    // $ANTLR start "entryRuleAltList1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2367:1: entryRuleAltList1 returns [Boolean current=false] : iv_ruleAltList1= ruleAltList1 EOF ;
    public final Boolean entryRuleAltList1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAltList1 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2367:50: (iv_ruleAltList1= ruleAltList1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2368:2: iv_ruleAltList1= ruleAltList1 EOF
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2374:1: ruleAltList1 returns [Boolean current=false] : (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2375:1: ( (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2376:2: (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2376:2: (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2377:3: otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            {

            			markLeaf(elementTypeProvider.getAltList1_NumberSignDigitTwoDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2384:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2385:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2385:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2386:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2386:5: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2387:6: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2387:6: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2388:7: lv_val1_1_0= RULE_ID
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

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2403:5: ( (lv_val2_2_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2404:6: (lv_val2_2_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2404:6: (lv_val2_2_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2405:7: lv_val2_2_0= RULE_ID
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2422:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2422:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2423:5: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getAltList1_Kw1Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2430:5: ( (lv_val1_4_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2431:6: (lv_val1_4_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2431:6: (lv_val1_4_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2432:7: lv_val1_4_0= RULE_ID
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

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2447:5: ( (lv_val3_5_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2448:6: (lv_val3_5_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2448:6: (lv_val3_5_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2449:7: lv_val3_5_0= RULE_ID
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2466:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2466:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2467:5: otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )?
                    {

                    					markLeaf(elementTypeProvider.getAltList1_Kw2Keyword_1_2_0ElementType());
                    				
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_6);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2474:5: ( (lv_val1_7_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2475:6: (lv_val1_7_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2475:6: (lv_val1_7_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2476:7: lv_val1_7_0= RULE_ID
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

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2491:5: ( (lv_val4_8_0= RULE_ID ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==RULE_ID) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2492:6: (lv_val4_8_0= RULE_ID )
                            {
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2492:6: (lv_val4_8_0= RULE_ID )
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2493:7: lv_val4_8_0= RULE_ID
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2514:1: entryRuleAltList2 returns [Boolean current=false] : iv_ruleAltList2= ruleAltList2 EOF ;
    public final Boolean entryRuleAltList2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAltList2 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2514:50: (iv_ruleAltList2= ruleAltList2 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2515:2: iv_ruleAltList2= ruleAltList2 EOF
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2521:1: ruleAltList2 returns [Boolean current=false] : (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2522:1: ( (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2523:2: (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2523:2: (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2524:3: otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            {

            			markLeaf(elementTypeProvider.getAltList2_NumberSignDigitTwoDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2531:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2532:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2532:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2533:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2533:5: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2534:6: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2534:6: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2535:7: lv_val1_1_0= RULE_ID
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

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2550:5: ( (lv_val2_2_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2551:6: (lv_val2_2_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2551:6: (lv_val2_2_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2552:7: lv_val2_2_0= RULE_ID
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2569:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2569:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2570:5: otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getAltList2_KwKeyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,41,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2577:5: ( (lv_val1_4_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2578:6: (lv_val1_4_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2578:6: (lv_val1_4_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2579:7: lv_val1_4_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    						
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_val1_4_0);
                    						

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2594:5: (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==34) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2595:6: otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) )
                    	    {

                    	    						markLeaf(elementTypeProvider.getAltList2_CommaKeyword_1_1_2_0ElementType());
                    	    					
                    	    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    	    						doneLeaf(otherlv_5);
                    	    					
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2602:6: ( (lv_val1_6_0= RULE_ID ) )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2603:7: (lv_val1_6_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2603:7: (lv_val1_6_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2604:8: lv_val1_6_0= RULE_ID
                    	    {

                    	    								markLeaf(elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_1_2_1_0ElementType());
                    	    							
                    	    lv_val1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

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
                    	    break loop33;
                        }
                    } while (true);

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2620:5: ( (lv_val3_7_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2621:6: (lv_val3_7_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2621:6: (lv_val3_7_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2622:7: lv_val3_7_0= RULE_ID
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


    // $ANTLR start "entryRuleTransientObject"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2643:1: entryRuleTransientObject returns [Boolean current=false] : iv_ruleTransientObject= ruleTransientObject EOF ;
    public final Boolean entryRuleTransientObject() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTransientObject = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2643:57: (iv_ruleTransientObject= ruleTransientObject EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2644:2: iv_ruleTransientObject= ruleTransientObject EOF
            {
             markComposite(elementTypeProvider.getTransientObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransientObject=ruleTransientObject();

            state._fsp--;

             current =iv_ruleTransientObject; 
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
    // $ANTLR end "entryRuleTransientObject"


    // $ANTLR start "ruleTransientObject"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2650:1: ruleTransientObject returns [Boolean current=false] : (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) ;
    public final Boolean ruleTransientObject() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Boolean lv_nested_2_0 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2651:1: ( (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2652:2: (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2652:2: (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2653:3: otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            {

            			markLeaf(elementTypeProvider.getTransientObject_NumberSignDigitTwoDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2660:3: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2661:4: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2661:4: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2662:5: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2662:5: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2663:6: lv_val1_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTransientObject_Val1IDTerminalRuleCall_1_0_0ElementType());
                    					
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val1_1_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2678:4: ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2679:5: (lv_nested_2_0= ruleTransientObjectSub )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2679:5: (lv_nested_2_0= ruleTransientObjectSub )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2680:6: lv_nested_2_0= ruleTransientObjectSub
                    {

                    						markComposite(elementTypeProvider.getTransientObject_NestedTransientObjectSubParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_nested_2_0=ruleTransientObjectSub();

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
    // $ANTLR end "ruleTransientObject"


    // $ANTLR start "entryRuleTransientObjectSub"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2698:1: entryRuleTransientObjectSub returns [Boolean current=false] : iv_ruleTransientObjectSub= ruleTransientObjectSub EOF ;
    public final Boolean entryRuleTransientObjectSub() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTransientObjectSub = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2698:60: (iv_ruleTransientObjectSub= ruleTransientObjectSub EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2699:2: iv_ruleTransientObjectSub= ruleTransientObjectSub EOF
            {
             markComposite(elementTypeProvider.getTransientObjectSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransientObjectSub=ruleTransientObjectSub();

            state._fsp--;

             current =iv_ruleTransientObjectSub; 
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
    // $ANTLR end "entryRuleTransientObjectSub"


    // $ANTLR start "ruleTransientObjectSub"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2705:1: ruleTransientObjectSub returns [Boolean current=false] : ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleTransientObjectSub() throws RecognitionException {
        Boolean current = false;

        Token lv_val2_0_0=null;
        Token lv_val3_1_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2706:1: ( ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2707:2: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2707:2: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2708:3: ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2708:3: ( (lv_val2_0_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2709:4: (lv_val2_0_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2709:4: (lv_val2_0_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2710:5: lv_val2_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTransientObjectSub_Val2IDTerminalRuleCall_0_0ElementType());
            				
            lv_val2_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val2_0_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2725:3: ( (lv_val3_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2726:4: (lv_val3_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2726:4: (lv_val3_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2727:5: lv_val3_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTransientObjectSub_Val3IDTerminalRuleCall_1_0ElementType());
            				
            lv_val3_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_val3_1_0);
            				

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
    // $ANTLR end "ruleTransientObjectSub"


    // $ANTLR start "entryRuleTransientSerializeables1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2746:1: entryRuleTransientSerializeables1 returns [Boolean current=false] : iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF ;
    public final Boolean entryRuleTransientSerializeables1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTransientSerializeables1 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2746:66: (iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2747:2: iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF
            {
             markComposite(elementTypeProvider.getTransientSerializeables1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransientSerializeables1=ruleTransientSerializeables1();

            state._fsp--;

             current =iv_ruleTransientSerializeables1; 
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
    // $ANTLR end "entryRuleTransientSerializeables1"


    // $ANTLR start "ruleTransientSerializeables1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2753:1: ruleTransientSerializeables1 returns [Boolean current=false] : (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) ;
    public final Boolean ruleTransientSerializeables1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_int1_4_0=null;
        Boolean lv_enum1_2_0 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2754:1: ( (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2755:2: (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2755:2: (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2756:3: otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            {

            			markLeaf(elementTypeProvider.getTransientSerializeables1_NumberSignDigitTwoDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,43,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2763:3: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )?
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2764:4: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2764:4: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2765:5: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2765:5: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2766:6: lv_val1_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTransientSerializeables1_Val1IDTerminalRuleCall_1_0_0ElementType());
                    					
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val1_1_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2781:4: ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2782:5: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2782:5: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2783:6: lv_enum1_2_0= ruleTransientSerializeables1Enum
                    {

                    						markComposite(elementTypeProvider.getTransientSerializeables1_Enum1TransientSerializeables1EnumEnumRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_enum1_2_0=ruleTransientSerializeables1Enum();

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

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2797:3: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2798:4: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2798:4: ( (lv_val2_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2799:5: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2799:5: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2800:6: lv_val2_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTransientSerializeables1_Val2IDTerminalRuleCall_2_0_0ElementType());
                    					
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_23); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_val2_3_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2815:4: ( (lv_int1_4_0= RULE_INT ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2816:5: (lv_int1_4_0= RULE_INT )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2816:5: (lv_int1_4_0= RULE_INT )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2817:6: lv_int1_4_0= RULE_INT
                    {

                    						markLeaf(elementTypeProvider.getTransientSerializeables1_Int1INTTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_int1_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_int1_4_0);
                    					

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
    // $ANTLR end "ruleTransientSerializeables1"


    // $ANTLR start "entryRuleStaticSimplification"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2837:1: entryRuleStaticSimplification returns [Boolean current=false] : iv_ruleStaticSimplification= ruleStaticSimplification EOF ;
    public final Boolean entryRuleStaticSimplification() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleStaticSimplification = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2837:62: (iv_ruleStaticSimplification= ruleStaticSimplification EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2838:2: iv_ruleStaticSimplification= ruleStaticSimplification EOF
            {
             markComposite(elementTypeProvider.getStaticSimplificationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStaticSimplification=ruleStaticSimplification();

            state._fsp--;

             current =iv_ruleStaticSimplification; 
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
    // $ANTLR end "entryRuleStaticSimplification"


    // $ANTLR start "ruleStaticSimplification"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2844:1: ruleStaticSimplification returns [Boolean current=false] : (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) ) ;
    public final Boolean ruleStaticSimplification() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_val3_8_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2845:1: ( (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2846:2: (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2846:2: (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2847:3: otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? )
            {

            			markLeaf(elementTypeProvider.getStaticSimplification_NumberSignDigitTwoDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2854:3: (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2855:4: otherlv_1= 'kw1'
                    {

                    				markLeaf(elementTypeProvider.getStaticSimplification_Kw1Keyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_1);
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2863:4: ()
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2863:4: ()
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2864:5: 
                    {

                    					precedeComposite(elementTypeProvider.getStaticSimplification_EmptyAlternativeSubAction_1_1ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2871:4: ( (lv_val1_3_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2871:4: ( (lv_val1_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2872:5: (lv_val1_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2872:5: (lv_val1_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2873:6: lv_val1_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getStaticSimplification_Val1IDTerminalRuleCall_1_2_0ElementType());
                    					
                    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

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

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2889:3: (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2890:4: otherlv_4= 'kw2'
                    {

                    				markLeaf(elementTypeProvider.getStaticSimplification_Kw2Keyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_24); 

                    				doneLeaf(otherlv_4);
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2898:4: ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2898:4: ( (lv_val2_5_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2899:5: (lv_val2_5_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2899:5: (lv_val2_5_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2900:6: lv_val2_5_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getStaticSimplification_Val2IDTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_24); 

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

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2916:3: (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2917:4: otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )?
            {

            				markLeaf(elementTypeProvider.getStaticSimplification_Kw3Keyword_3_0ElementType());
            			
            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_25); 

            				doneLeaf(otherlv_6);
            			
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2924:4: (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==19) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2925:5: otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+
                    {

                    					markLeaf(elementTypeProvider.getStaticSimplification_Kw4Keyword_3_1_0ElementType());
                    				
                    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_7);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2932:5: ( (lv_val3_8_0= RULE_ID ) )+
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
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2933:6: (lv_val3_8_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2933:6: (lv_val3_8_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2934:7: lv_val3_8_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getStaticSimplification_Val3IDTerminalRuleCall_3_1_1_0ElementType());
                    	    						
                    	    lv_val3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

                    	    							doneLeaf(lv_val3_8_0);
                    	    						

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
        return current;
    }
    // $ANTLR end "ruleStaticSimplification"


    // $ANTLR start "entryRuleTwoVersion"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2955:1: entryRuleTwoVersion returns [Boolean current=false] : iv_ruleTwoVersion= ruleTwoVersion EOF ;
    public final Boolean entryRuleTwoVersion() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTwoVersion = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2955:52: (iv_ruleTwoVersion= ruleTwoVersion EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2956:2: iv_ruleTwoVersion= ruleTwoVersion EOF
            {
             markComposite(elementTypeProvider.getTwoVersionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTwoVersion=ruleTwoVersion();

            state._fsp--;

             current =iv_ruleTwoVersion; 
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
    // $ANTLR end "entryRuleTwoVersion"


    // $ANTLR start "ruleTwoVersion"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2962:1: ruleTwoVersion returns [Boolean current=false] : (otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) ) ;
    public final Boolean ruleTwoVersion() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_TwoVersionNo1_1 = null;

        Boolean this_TwoVersionNo2_2 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2963:1: ( (otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2964:2: (otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2964:2: (otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2965:3: otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 )
            {

            			markLeaf(elementTypeProvider.getTwoVersion_NumberSignDigitTwoDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2972:3: (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 46:
                    {
                    alt42=1;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA42_3 = input.LA(3);

                    if ( (LA42_3==46) ) {
                        alt42=1;
                    }
                    else if ( (LA42_3==48) ) {
                        alt42=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 48:
                    {
                    alt42=2;
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2973:4: this_TwoVersionNo1_1= ruleTwoVersionNo1
                    {

                    				markComposite(elementTypeProvider.getTwoVersion_TwoVersionNo1ParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TwoVersionNo1_1=ruleTwoVersionNo1();

                    state._fsp--;


                    				current = this_TwoVersionNo1_1;
                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2982:4: this_TwoVersionNo2_2= ruleTwoVersionNo2
                    {

                    				markComposite(elementTypeProvider.getTwoVersion_TwoVersionNo2ParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TwoVersionNo2_2=ruleTwoVersionNo2();

                    state._fsp--;


                    				current = this_TwoVersionNo2_2;
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
        return current;
    }
    // $ANTLR end "ruleTwoVersion"


    // $ANTLR start "entryRuleTwoVersionNo1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2995:1: entryRuleTwoVersionNo1 returns [Boolean current=false] : iv_ruleTwoVersionNo1= ruleTwoVersionNo1 EOF ;
    public final Boolean entryRuleTwoVersionNo1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTwoVersionNo1 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2995:55: (iv_ruleTwoVersionNo1= ruleTwoVersionNo1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2996:2: iv_ruleTwoVersionNo1= ruleTwoVersionNo1 EOF
            {
             markComposite(elementTypeProvider.getTwoVersionNo1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTwoVersionNo1=ruleTwoVersionNo1();

            state._fsp--;

             current =iv_ruleTwoVersionNo1; 
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
    // $ANTLR end "entryRuleTwoVersionNo1"


    // $ANTLR start "ruleTwoVersionNo1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3002:1: ruleTwoVersionNo1 returns [Boolean current=false] : ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? ) ;
    public final Boolean ruleTwoVersionNo1() throws RecognitionException {
        Boolean current = false;

        Token lv_shared1_0_0=null;
        Token lv_shared2_1_0=null;
        Token otherlv_2=null;
        Token lv_shared3_3_0=null;
        Token lv_shared3_4_0=null;
        Token otherlv_5=null;
        Token lv_version1_6_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3003:1: ( ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3004:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3004:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3005:3: ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )?
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3005:3: ( (lv_shared1_0_0= RULE_ID ) )?
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3006:4: (lv_shared1_0_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3006:4: (lv_shared1_0_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3007:5: lv_shared1_0_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getTwoVersionNo1_Shared1IDTerminalRuleCall_0_0ElementType());
                    				
                    lv_shared1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_shared1_0_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3022:3: ( (lv_shared2_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3023:4: (lv_shared2_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3023:4: (lv_shared2_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3024:5: lv_shared2_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTwoVersionNo1_Shared2IDTerminalRuleCall_1_0ElementType());
            				
            lv_shared2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_shared2_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getTwoVersionNo1_ShortKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,46,FollowSets000.FOLLOW_27); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3046:3: ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3047:4: ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )*
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3047:4: ( (lv_shared3_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3048:5: (lv_shared3_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3048:5: (lv_shared3_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3049:6: lv_shared3_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTwoVersionNo1_Shared3IDTerminalRuleCall_3_0_0ElementType());
                    					
                    lv_shared3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_27); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_shared3_3_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3064:4: ( (lv_shared3_4_0= RULE_ID ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==RULE_ID) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3065:5: (lv_shared3_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3065:5: (lv_shared3_4_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3066:6: lv_shared3_4_0= RULE_ID
                    	    {

                    	    						markLeaf(elementTypeProvider.getTwoVersionNo1_Shared3IDTerminalRuleCall_3_1_0ElementType());
                    	    					
                    	    lv_shared3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_27); 

                    	    						if(!current) {
                    	    							associateWithSemanticElement();
                    	    							current = true;
                    	    						}
                    	    					

                    	    						doneLeaf(lv_shared3_4_0);
                    	    					

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


            			markLeaf(elementTypeProvider.getTwoVersionNo1_OneKeyword_4ElementType());
            		
            otherlv_5=(Token)match(input,47,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_5);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3089:3: ( (lv_version1_6_0= RULE_ID ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3090:4: (lv_version1_6_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3090:4: (lv_version1_6_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3091:5: lv_version1_6_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getTwoVersionNo1_Version1IDTerminalRuleCall_5_0ElementType());
                    				
                    lv_version1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_version1_6_0);
                    				

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
    // $ANTLR end "ruleTwoVersionNo1"


    // $ANTLR start "entryRuleTwoVersionNo2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3110:1: entryRuleTwoVersionNo2 returns [Boolean current=false] : iv_ruleTwoVersionNo2= ruleTwoVersionNo2 EOF ;
    public final Boolean entryRuleTwoVersionNo2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTwoVersionNo2 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3110:55: (iv_ruleTwoVersionNo2= ruleTwoVersionNo2 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3111:2: iv_ruleTwoVersionNo2= ruleTwoVersionNo2 EOF
            {
             markComposite(elementTypeProvider.getTwoVersionNo2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTwoVersionNo2=ruleTwoVersionNo2();

            state._fsp--;

             current =iv_ruleTwoVersionNo2; 
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
    // $ANTLR end "entryRuleTwoVersionNo2"


    // $ANTLR start "ruleTwoVersionNo2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3117:1: ruleTwoVersionNo2 returns [Boolean current=false] : ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? ) ;
    public final Boolean ruleTwoVersionNo2() throws RecognitionException {
        Boolean current = false;

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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3118:1: ( ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3119:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3119:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3120:3: ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )?
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3120:3: ( (lv_shared1_0_0= RULE_ID ) )?
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3121:4: (lv_shared1_0_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3121:4: (lv_shared1_0_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3122:5: lv_shared1_0_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getTwoVersionNo2_Shared1IDTerminalRuleCall_0_0ElementType());
                    				
                    lv_shared1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_shared1_0_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3137:3: ( (lv_shared2_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3138:4: (lv_shared2_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3138:4: (lv_shared2_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3139:5: lv_shared2_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTwoVersionNo2_Shared2IDTerminalRuleCall_1_0ElementType());
            				
            lv_shared2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_28); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_shared2_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getTwoVersionNo2_LongKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,48,FollowSets000.FOLLOW_29); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3161:3: ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3162:4: ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )*
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3162:4: ( (lv_shared3_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3163:5: (lv_shared3_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3163:5: (lv_shared3_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3164:6: lv_shared3_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTwoVersionNo2_Shared3IDTerminalRuleCall_3_0_0ElementType());
                    					
                    lv_shared3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_shared3_3_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3179:4: ( (lv_shared3_4_0= RULE_ID ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==RULE_ID) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3180:5: (lv_shared3_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3180:5: (lv_shared3_4_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3181:6: lv_shared3_4_0= RULE_ID
                    	    {

                    	    						markLeaf(elementTypeProvider.getTwoVersionNo2_Shared3IDTerminalRuleCall_3_1_0ElementType());
                    	    					
                    	    lv_shared3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

                    	    						if(!current) {
                    	    							associateWithSemanticElement();
                    	    							current = true;
                    	    						}
                    	    					

                    	    						doneLeaf(lv_shared3_4_0);
                    	    					

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


            			markLeaf(elementTypeProvider.getTwoVersionNo2_ExtraKeyword_4ElementType());
            		
            otherlv_5=(Token)match(input,49,FollowSets000.FOLLOW_30); 

            			doneLeaf(otherlv_5);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3204:3: ( (lv_extra1_6_0= RULE_ID ) )?
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3205:4: (lv_extra1_6_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3205:4: (lv_extra1_6_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3206:5: lv_extra1_6_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getTwoVersionNo2_Extra1IDTerminalRuleCall_5_0ElementType());
                    				
                    lv_extra1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_30); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_extra1_6_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3221:3: ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )?
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3222:4: ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3222:4: ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3223:5: ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3223:5: ( (lv_extra2_7_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3224:6: (lv_extra2_7_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3224:6: (lv_extra2_7_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3225:7: lv_extra2_7_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTwoVersionNo2_Extra2IDTerminalRuleCall_6_0_0_0ElementType());
                    						
                    lv_extra2_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_extra2_7_0);
                    						

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3240:5: ( (lv_extra3_8_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3241:6: (lv_extra3_8_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3241:6: (lv_extra3_8_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3242:7: lv_extra3_8_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTwoVersionNo2_Extra3IDTerminalRuleCall_6_0_1_0ElementType());
                    						
                    lv_extra3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_extra3_8_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3259:4: (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3259:4: (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3260:5: otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getTwoVersionNo2_TwoKeyword_6_1_0ElementType());
                    				
                    otherlv_9=(Token)match(input,50,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_9);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3267:5: ( (lv_extra4_10_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3268:6: (lv_extra4_10_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3268:6: (lv_extra4_10_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3269:7: lv_extra4_10_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTwoVersionNo2_Extra4IDTerminalRuleCall_6_1_1_0ElementType());
                    						
                    lv_extra4_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							doneLeaf(lv_extra4_10_0);
                    						

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
    // $ANTLR end "ruleTwoVersionNo2"


    // $ANTLR start "entryRuleHeuristic1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3290:1: entryRuleHeuristic1 returns [Boolean current=false] : iv_ruleHeuristic1= ruleHeuristic1 EOF ;
    public final Boolean entryRuleHeuristic1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleHeuristic1 = null;


        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3290:52: (iv_ruleHeuristic1= ruleHeuristic1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3291:2: iv_ruleHeuristic1= ruleHeuristic1 EOF
            {
             markComposite(elementTypeProvider.getHeuristic1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleHeuristic1=ruleHeuristic1();

            state._fsp--;

             current =iv_ruleHeuristic1; 
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
    // $ANTLR end "entryRuleHeuristic1"


    // $ANTLR start "ruleHeuristic1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3297:1: ruleHeuristic1 returns [Boolean current=false] : (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* ) ;
    public final Boolean ruleHeuristic1() throws RecognitionException {
        Boolean current = false;

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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3298:1: ( (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3299:2: (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3299:2: (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3300:3: otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getHeuristic1_NumberSignDigitTwoDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_31); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3307:3: (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==13) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3308:4: otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getHeuristic1_Kw1Keyword_1_0ElementType());
            	    			
            	    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_1);
            	    			
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3315:4: ( (lv_a_2_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3316:5: (lv_a_2_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3316:5: (lv_a_2_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3317:6: lv_a_2_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getHeuristic1_AIDTerminalRuleCall_1_1_0ElementType());
            	    					
            	    lv_a_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_a_2_0);
            	    					

            	    }


            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3332:4: ( (lv_b_3_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3333:5: (lv_b_3_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3333:5: (lv_b_3_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3334:6: lv_b_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getHeuristic1_BIDTerminalRuleCall_1_2_0ElementType());
            	    					
            	    lv_b_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_31); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_b_3_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3350:3: (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==14) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3351:4: otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getHeuristic1_Kw2Keyword_2_0ElementType());
            	    			
            	    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_4);
            	    			
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3358:4: ( (lv_a_5_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3359:5: (lv_a_5_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3359:5: (lv_a_5_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3360:6: lv_a_5_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getHeuristic1_AIDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_a_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_a_5_0);
            	    					

            	    }


            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3375:4: ( (lv_c_6_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3376:5: (lv_c_6_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3376:5: (lv_c_6_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3377:6: lv_c_6_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getHeuristic1_CIDTerminalRuleCall_2_2_0ElementType());
            	    					
            	    lv_c_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_c_6_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3393:3: (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==16) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3394:4: otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getHeuristic1_Kw3Keyword_3_0ElementType());
            	    			
            	    otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_7);
            	    			
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3401:4: ( (lv_b_8_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3402:5: (lv_b_8_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3402:5: (lv_b_8_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3403:6: lv_b_8_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getHeuristic1_BIDTerminalRuleCall_3_1_0ElementType());
            	    					
            	    lv_b_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_b_8_0);
            	    					

            	    }


            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3418:4: ( (lv_c_9_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3419:5: (lv_c_9_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3419:5: (lv_c_9_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3420:6: lv_c_9_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getHeuristic1_CIDTerminalRuleCall_3_2_0ElementType());
            	    					
            	    lv_c_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_33); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_c_9_0);
            	    					

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
        return current;
    }
    // $ANTLR end "ruleHeuristic1"


    // $ANTLR start "ruleTransientSerializeables1Enum"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3440:1: ruleTransientSerializeables1Enum returns [Boolean current=false] : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) ;
    public final Boolean ruleTransientSerializeables1Enum() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3441:1: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3442:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:3442:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3443:3: (enumLiteral_0= 'lit1' )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3443:3: (enumLiteral_0= 'lit1' )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3444:4: enumLiteral_0= 'lit1'
                    {

                    				markLeaf(elementTypeProvider.getTransientSerializeables1Enum_Lit1EnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,52,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3453:3: (enumLiteral_1= 'lit2' )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3453:3: (enumLiteral_1= 'lit2' )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:3454:4: enumLiteral_1= 'lit2'
                    {

                    				markLeaf(elementTypeProvider.getTransientSerializeables1Enum_Lit2EnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,53,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

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
    // $ANTLR end "ruleTransientSerializeables1Enum"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000090010L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000020000000010L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0030000000000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0002000000000010L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0004000000000012L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000016002L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000014002L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000010002L});
    }


}