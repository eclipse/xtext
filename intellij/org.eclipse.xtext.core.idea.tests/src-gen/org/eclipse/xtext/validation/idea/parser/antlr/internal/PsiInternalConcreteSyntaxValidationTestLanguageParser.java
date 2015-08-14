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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:58:1: ruleModel : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:58:10: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:59:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:59:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:60:3: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:60:3: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:61:4: (lv_x1_0_0= ruleSimpleGroup )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:61:4: (lv_x1_0_0= ruleSimpleGroup )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:62:5: lv_x1_0_0= ruleSimpleGroup
                    {

                    					markComposite(elementTypeProvider.getModel_X1SimpleGroupParserRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSimpleGroup();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:72:3: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:72:3: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:73:4: (lv_x2_1_0= ruleSimpleAlternative )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:73:4: (lv_x2_1_0= ruleSimpleAlternative )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:74:5: lv_x2_1_0= ruleSimpleAlternative
                    {

                    					markComposite(elementTypeProvider.getModel_X2SimpleAlternativeParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSimpleAlternative();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:84:3: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:84:3: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:85:4: (lv_x3_2_0= ruleSimpleMultiplicities )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:85:4: (lv_x3_2_0= ruleSimpleMultiplicities )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:86:5: lv_x3_2_0= ruleSimpleMultiplicities
                    {

                    					markComposite(elementTypeProvider.getModel_X3SimpleMultiplicitiesParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSimpleMultiplicities();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:96:3: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:96:3: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:97:4: (lv_x4_3_0= ruleGroupMultiplicities )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:97:4: (lv_x4_3_0= ruleGroupMultiplicities )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:98:5: lv_x4_3_0= ruleGroupMultiplicities
                    {

                    					markComposite(elementTypeProvider.getModel_X4GroupMultiplicitiesParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleGroupMultiplicities();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:108:3: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:108:3: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:109:4: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:109:4: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:110:5: lv_x5_4_0= ruleAlternativeMultiplicities
                    {

                    					markComposite(elementTypeProvider.getModel_X5AlternativeMultiplicitiesParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAlternativeMultiplicities();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:120:3: ( (lv_x6_5_0= ruleAssignedAction ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:120:3: ( (lv_x6_5_0= ruleAssignedAction ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:121:4: (lv_x6_5_0= ruleAssignedAction )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:121:4: (lv_x6_5_0= ruleAssignedAction )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:122:5: lv_x6_5_0= ruleAssignedAction
                    {

                    					markComposite(elementTypeProvider.getModel_X6AssignedActionParserRuleCall_5_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAssignedAction();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:132:3: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:132:3: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:133:4: (lv_x7_6_0= ruleAssignedActionSecond )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:133:4: (lv_x7_6_0= ruleAssignedActionSecond )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:134:5: lv_x7_6_0= ruleAssignedActionSecond
                    {

                    					markComposite(elementTypeProvider.getModel_X7AssignedActionSecondParserRuleCall_6_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAssignedActionSecond();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 8 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:144:3: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:144:3: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:145:4: (lv_x8_7_0= ruleUnassignedAction1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:145:4: (lv_x8_7_0= ruleUnassignedAction1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:146:5: lv_x8_7_0= ruleUnassignedAction1
                    {

                    					markComposite(elementTypeProvider.getModel_X8UnassignedAction1ParserRuleCall_7_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUnassignedAction1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 9 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:156:3: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:156:3: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:157:4: (lv_x9_8_0= ruleUnassignedAction2 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:157:4: (lv_x9_8_0= ruleUnassignedAction2 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:158:5: lv_x9_8_0= ruleUnassignedAction2
                    {

                    					markComposite(elementTypeProvider.getModel_X9UnassignedAction2ParserRuleCall_8_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUnassignedAction2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 10 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:168:3: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:168:3: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:169:4: (lv_x10_9_0= ruleUnassignedAction3 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:169:4: (lv_x10_9_0= ruleUnassignedAction3 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:170:5: lv_x10_9_0= ruleUnassignedAction3
                    {

                    					markComposite(elementTypeProvider.getModel_X10UnassignedAction3ParserRuleCall_9_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUnassignedAction3();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 11 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:180:3: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:180:3: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:181:4: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:181:4: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:182:5: lv_x11_10_0= ruleUnassignedRuleCall1
                    {

                    					markComposite(elementTypeProvider.getModel_X11UnassignedRuleCall1ParserRuleCall_10_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUnassignedRuleCall1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 12 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:192:3: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:192:3: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:193:4: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:193:4: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:194:5: lv_x12_11_0= ruleUnassignedRuleCall2
                    {

                    					markComposite(elementTypeProvider.getModel_X12UnassignedRuleCall2ParserRuleCall_11_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUnassignedRuleCall2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 13 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:204:3: ( (lv_x13_12_0= ruleCombination1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:204:3: ( (lv_x13_12_0= ruleCombination1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:205:4: (lv_x13_12_0= ruleCombination1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:205:4: (lv_x13_12_0= ruleCombination1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:206:5: lv_x13_12_0= ruleCombination1
                    {

                    					markComposite(elementTypeProvider.getModel_X13Combination1ParserRuleCall_12_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCombination1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 14 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:216:3: ( (lv_x14_13_0= ruleCombination2 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:216:3: ( (lv_x14_13_0= ruleCombination2 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:217:4: (lv_x14_13_0= ruleCombination2 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:217:4: (lv_x14_13_0= ruleCombination2 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:218:5: lv_x14_13_0= ruleCombination2
                    {

                    					markComposite(elementTypeProvider.getModel_X14Combination2ParserRuleCall_13_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCombination2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 15 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:228:3: ( (lv_x15_14_0= ruleCombination3 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:228:3: ( (lv_x15_14_0= ruleCombination3 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:229:4: (lv_x15_14_0= ruleCombination3 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:229:4: (lv_x15_14_0= ruleCombination3 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:230:5: lv_x15_14_0= ruleCombination3
                    {

                    					markComposite(elementTypeProvider.getModel_X15Combination3ParserRuleCall_14_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCombination3();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 16 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:240:3: ( (lv_x16_15_0= ruleCombination4 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:240:3: ( (lv_x16_15_0= ruleCombination4 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:241:4: (lv_x16_15_0= ruleCombination4 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:241:4: (lv_x16_15_0= ruleCombination4 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:242:5: lv_x16_15_0= ruleCombination4
                    {

                    					markComposite(elementTypeProvider.getModel_X16Combination4ParserRuleCall_15_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCombination4();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 17 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:252:3: ( (lv_x17_16_0= ruleList1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:252:3: ( (lv_x17_16_0= ruleList1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:253:4: (lv_x17_16_0= ruleList1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:253:4: (lv_x17_16_0= ruleList1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:254:5: lv_x17_16_0= ruleList1
                    {

                    					markComposite(elementTypeProvider.getModel_X17List1ParserRuleCall_16_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleList1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 18 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:264:3: ( (lv_x18_17_0= ruleList2 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:264:3: ( (lv_x18_17_0= ruleList2 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:265:4: (lv_x18_17_0= ruleList2 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:265:4: (lv_x18_17_0= ruleList2 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:266:5: lv_x18_17_0= ruleList2
                    {

                    					markComposite(elementTypeProvider.getModel_X18List2ParserRuleCall_17_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleList2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 19 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:276:3: ( (lv_x19_18_0= ruleList3 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:276:3: ( (lv_x19_18_0= ruleList3 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:277:4: (lv_x19_18_0= ruleList3 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:277:4: (lv_x19_18_0= ruleList3 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:278:5: lv_x19_18_0= ruleList3
                    {

                    					markComposite(elementTypeProvider.getModel_X19List3ParserRuleCall_18_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleList3();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 20 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:288:3: ( (lv_x20_19_0= ruleList4 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:288:3: ( (lv_x20_19_0= ruleList4 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:289:4: (lv_x20_19_0= ruleList4 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:289:4: (lv_x20_19_0= ruleList4 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:290:5: lv_x20_19_0= ruleList4
                    {

                    					markComposite(elementTypeProvider.getModel_X20List4ParserRuleCall_19_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleList4();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 21 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:300:3: ( (lv_x21_20_0= ruleList5 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:300:3: ( (lv_x21_20_0= ruleList5 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:301:4: (lv_x21_20_0= ruleList5 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:301:4: (lv_x21_20_0= ruleList5 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:302:5: lv_x21_20_0= ruleList5
                    {

                    					markComposite(elementTypeProvider.getModel_X21List5ParserRuleCall_20_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleList5();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 22 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:312:3: ( (lv_x22_21_0= ruleAltList1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:312:3: ( (lv_x22_21_0= ruleAltList1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:313:4: (lv_x22_21_0= ruleAltList1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:313:4: (lv_x22_21_0= ruleAltList1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:314:5: lv_x22_21_0= ruleAltList1
                    {

                    					markComposite(elementTypeProvider.getModel_X22AltList1ParserRuleCall_21_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAltList1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 23 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:324:3: ( (lv_x23_22_0= ruleAltList2 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:324:3: ( (lv_x23_22_0= ruleAltList2 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:325:4: (lv_x23_22_0= ruleAltList2 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:325:4: (lv_x23_22_0= ruleAltList2 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:326:5: lv_x23_22_0= ruleAltList2
                    {

                    					markComposite(elementTypeProvider.getModel_X23AltList2ParserRuleCall_22_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAltList2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 24 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:336:3: ( (lv_x24_23_0= ruleTransientObject ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:336:3: ( (lv_x24_23_0= ruleTransientObject ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:337:4: (lv_x24_23_0= ruleTransientObject )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:337:4: (lv_x24_23_0= ruleTransientObject )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:338:5: lv_x24_23_0= ruleTransientObject
                    {

                    					markComposite(elementTypeProvider.getModel_X24TransientObjectParserRuleCall_23_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTransientObject();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 25 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:348:3: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:348:3: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:349:4: (lv_x25_24_0= ruleTransientSerializeables1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:349:4: (lv_x25_24_0= ruleTransientSerializeables1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:350:5: lv_x25_24_0= ruleTransientSerializeables1
                    {

                    					markComposite(elementTypeProvider.getModel_X25TransientSerializeables1ParserRuleCall_24_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTransientSerializeables1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 26 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:360:3: ( (lv_x26_25_0= ruleStaticSimplification ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:360:3: ( (lv_x26_25_0= ruleStaticSimplification ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:361:4: (lv_x26_25_0= ruleStaticSimplification )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:361:4: (lv_x26_25_0= ruleStaticSimplification )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:362:5: lv_x26_25_0= ruleStaticSimplification
                    {

                    					markComposite(elementTypeProvider.getModel_X26StaticSimplificationParserRuleCall_25_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleStaticSimplification();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 27 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:372:3: ( (lv_x27_26_0= ruleTwoVersion ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:372:3: ( (lv_x27_26_0= ruleTwoVersion ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:373:4: (lv_x27_26_0= ruleTwoVersion )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:373:4: (lv_x27_26_0= ruleTwoVersion )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:374:5: lv_x27_26_0= ruleTwoVersion
                    {

                    					markComposite(elementTypeProvider.getModel_X27TwoVersionParserRuleCall_26_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTwoVersion();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 28 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:384:3: ( (lv_x28_27_0= ruleHeuristic1 ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:384:3: ( (lv_x28_27_0= ruleHeuristic1 ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:385:4: (lv_x28_27_0= ruleHeuristic1 )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:385:4: (lv_x28_27_0= ruleHeuristic1 )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:386:5: lv_x28_27_0= ruleHeuristic1
                    {

                    					markComposite(elementTypeProvider.getModel_X28Heuristic1ParserRuleCall_27_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:399:1: entryRuleSimpleGroup : ruleSimpleGroup EOF ;
    public final void entryRuleSimpleGroup() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:399:21: ( ruleSimpleGroup EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:400:2: ruleSimpleGroup EOF
            {
             markComposite(elementTypeProvider.getSimpleGroupElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSimpleGroup();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:405:1: ruleSimpleGroup : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final void ruleSimpleGroup() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:405:16: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:406:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:406:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:407:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSimpleGroup_NumberSignDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:414:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:415:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:415:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:416:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimpleGroup_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:425:3: ( (lv_val2_2_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:426:4: (lv_val2_2_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:426:4: (lv_val2_2_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:427:5: lv_val2_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimpleGroup_Val2IDTerminalRuleCall_2_0ElementType());
            				
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
        return ;
    }
    // $ANTLR end "ruleSimpleGroup"


    // $ANTLR start "entryRuleSimpleAlternative"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:440:1: entryRuleSimpleAlternative : ruleSimpleAlternative EOF ;
    public final void entryRuleSimpleAlternative() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:440:27: ( ruleSimpleAlternative EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:441:2: ruleSimpleAlternative EOF
            {
             markComposite(elementTypeProvider.getSimpleAlternativeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSimpleAlternative();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:446:1: ruleSimpleAlternative : (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final void ruleSimpleAlternative() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val2_4_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:446:22: ( (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:447:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:447:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:448:3: otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {

            			markLeaf(elementTypeProvider.getSimpleAlternative_NumberSignDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:455:3: ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:456:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:456:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:457:5: otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getSimpleAlternative_Kw1Keyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:464:5: ( (lv_val1_2_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:465:6: (lv_val1_2_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:465:6: (lv_val1_2_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:466:7: lv_val1_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getSimpleAlternative_Val1IDTerminalRuleCall_1_0_1_0ElementType());
                    						
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_val1_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:477:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:477:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:478:5: otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getSimpleAlternative_Kw2Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:485:5: ( (lv_val2_4_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:486:6: (lv_val2_4_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:486:6: (lv_val2_4_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:487:7: lv_val2_4_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getSimpleAlternative_Val2IDTerminalRuleCall_1_1_1_0ElementType());
                    						
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
        return ;
    }
    // $ANTLR end "ruleSimpleAlternative"


    // $ANTLR start "entryRuleSimpleMultiplicities"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:502:1: entryRuleSimpleMultiplicities : ruleSimpleMultiplicities EOF ;
    public final void entryRuleSimpleMultiplicities() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:502:30: ( ruleSimpleMultiplicities EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:503:2: ruleSimpleMultiplicities EOF
            {
             markComposite(elementTypeProvider.getSimpleMultiplicitiesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSimpleMultiplicities();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:508:1: ruleSimpleMultiplicities : (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:508:25: ( (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:509:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:509:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:510:3: otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {

            			markLeaf(elementTypeProvider.getSimpleMultiplicities_NumberSignDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:517:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:518:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:518:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:519:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimpleMultiplicities_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getSimpleMultiplicities_Kw1Keyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:535:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:536:4: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:536:4: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:537:5: lv_val2_3_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getSimpleMultiplicities_Val2IDTerminalRuleCall_3_0ElementType());
                    				
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    					doneLeaf(lv_val2_3_0);
                    				

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getSimpleMultiplicities_Kw2Keyword_4ElementType());
            		
            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:553:3: ( (lv_val3_5_0= RULE_ID ) )+
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:554:4: (lv_val3_5_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:554:4: (lv_val3_5_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:555:5: lv_val3_5_0= RULE_ID
            	    {

            	    					markLeaf(elementTypeProvider.getSimpleMultiplicities_Val3IDTerminalRuleCall_5_0ElementType());
            	    				
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
            		
            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_6);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:571:3: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:572:4: (lv_val4_7_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:572:4: (lv_val4_7_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:573:5: lv_val4_7_0= RULE_ID
            	    {

            	    					markLeaf(elementTypeProvider.getSimpleMultiplicities_Val4IDTerminalRuleCall_7_0ElementType());
            	    				
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
        return ;
    }
    // $ANTLR end "ruleSimpleMultiplicities"


    // $ANTLR start "entryRuleGroupMultiplicities"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:586:1: entryRuleGroupMultiplicities : ruleGroupMultiplicities EOF ;
    public final void entryRuleGroupMultiplicities() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:586:29: ( ruleGroupMultiplicities EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:587:2: ruleGroupMultiplicities EOF
            {
             markComposite(elementTypeProvider.getGroupMultiplicitiesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGroupMultiplicities();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:592:1: ruleGroupMultiplicities : (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:592:24: ( (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:593:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:593:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:594:3: otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getGroupMultiplicities_NumberSignDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:601:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:602:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:602:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:603:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getGroupMultiplicities_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getGroupMultiplicities_Kw1Keyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:619:3: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:620:4: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:620:4: ( (lv_val2_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:621:5: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:621:5: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:622:6: lv_val2_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val2IDTerminalRuleCall_3_0_0ElementType());
                    					
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    						doneLeaf(lv_val2_3_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:631:4: ( (lv_val3_4_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:632:5: (lv_val3_4_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:632:5: (lv_val3_4_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:633:6: lv_val3_4_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val3IDTerminalRuleCall_3_1_0ElementType());
                    					
                    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    						doneLeaf(lv_val3_4_0);
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getGroupMultiplicities_Kw2Keyword_4ElementType());
            		
            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_5);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:650:3: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:651:4: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:651:4: ( (lv_val4_6_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:652:5: (lv_val4_6_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:652:5: (lv_val4_6_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:653:6: lv_val4_6_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val4IDTerminalRuleCall_5_0_0ElementType());
            	    					
            	    lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						doneLeaf(lv_val4_6_0);
            	    					

            	    }


            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:662:4: ( (lv_val5_7_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:663:5: (lv_val5_7_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:663:5: (lv_val5_7_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:664:6: lv_val5_7_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val5IDTerminalRuleCall_5_1_0ElementType());
            	    					
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
            		
            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_8);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:681:3: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:682:4: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:682:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:683:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:683:5: (lv_val6_9_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:684:6: lv_val6_9_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val6IDTerminalRuleCall_7_0_0ElementType());
            	    					
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						doneLeaf(lv_val6_9_0);
            	    					

            	    }


            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:693:4: ( (lv_val7_10_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:694:5: (lv_val7_10_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:694:5: (lv_val7_10_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:695:6: lv_val7_10_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getGroupMultiplicities_Val7IDTerminalRuleCall_7_1_0ElementType());
            	    					
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
        return ;
    }
    // $ANTLR end "ruleGroupMultiplicities"


    // $ANTLR start "entryRuleAlternativeMultiplicities"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:709:1: entryRuleAlternativeMultiplicities : ruleAlternativeMultiplicities EOF ;
    public final void entryRuleAlternativeMultiplicities() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:709:35: ( ruleAlternativeMultiplicities EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:710:2: ruleAlternativeMultiplicities EOF
            {
             markComposite(elementTypeProvider.getAlternativeMultiplicitiesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAlternativeMultiplicities();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:715:1: ruleAlternativeMultiplicities : (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:715:30: ( (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:716:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:716:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:717:3: otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {

            			markLeaf(elementTypeProvider.getAlternativeMultiplicities_NumberSignDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:724:3: ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:725:4: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:725:4: ( (lv_val2_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:726:5: (lv_val2_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:726:5: (lv_val2_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:727:6: lv_val2_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val2IDTerminalRuleCall_1_0_0ElementType());
                    					
                    lv_val2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    						doneLeaf(lv_val2_1_0);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:737:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:737:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:738:5: otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw1Keyword_1_1_0ElementType());
                    				
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:745:5: ( (lv_val3_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:746:6: (lv_val3_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:746:6: (lv_val3_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:747:7: lv_val3_3_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val3IDTerminalRuleCall_1_1_1_0ElementType());
                    						
                    lv_val3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

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
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:765:3: ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:766:4: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:766:4: ( (lv_val4_5_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:767:5: (lv_val4_5_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:767:5: (lv_val4_5_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:768:6: lv_val4_5_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val4IDTerminalRuleCall_3_0_0ElementType());
            	    					
            	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            	    						doneLeaf(lv_val4_5_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:778:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:778:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:779:5: otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw3Keyword_3_1_0ElementType());
            	    				
            	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_6);
            	    				
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:786:5: ( (lv_val5_7_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:787:6: (lv_val5_7_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:787:6: (lv_val5_7_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:788:7: lv_val5_7_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val5IDTerminalRuleCall_3_1_1_0ElementType());
            	    						
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
            		
            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_12); 

            			doneLeaf(otherlv_8);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:806:3: ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:807:4: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:807:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:808:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:808:5: (lv_val6_9_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:809:6: lv_val6_9_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val6IDTerminalRuleCall_5_0_0ElementType());
            	    					
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    						doneLeaf(lv_val6_9_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:819:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:819:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:820:5: otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getAlternativeMultiplicities_Kw5Keyword_5_1_0ElementType());
            	    				
            	    otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            	    					doneLeaf(otherlv_10);
            	    				
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:827:5: ( (lv_val7_11_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:828:6: (lv_val7_11_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:828:6: (lv_val7_11_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:829:7: lv_val7_11_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getAlternativeMultiplicities_Val7IDTerminalRuleCall_5_1_1_0ElementType());
            	    						
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
        return ;
    }
    // $ANTLR end "ruleAlternativeMultiplicities"


    // $ANTLR start "entryRuleAssignedAction"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:844:1: entryRuleAssignedAction : ruleAssignedAction EOF ;
    public final void entryRuleAssignedAction() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:844:24: ( ruleAssignedAction EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:845:2: ruleAssignedAction EOF
            {
             markComposite(elementTypeProvider.getAssignedActionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignedAction();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:850:1: ruleAssignedAction : (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) ;
    public final void ruleAssignedAction() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:850:19: ( (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:851:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:851:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:852:3: otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+
            {

            			markLeaf(elementTypeProvider.getAssignedAction_NumberSignDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:859:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:860:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:860:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:861:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAssignedAction_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:870:3: ( () ( (lv_val1_3_0= RULE_ID ) ) )+
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:871:4: () ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:871:4: ()
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:872:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAssignedAction_AssignedActionChildAction_2_0ElementType());
            	    					doneComposite();
            	    				

            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:877:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:878:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:878:5: (lv_val1_3_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:879:6: lv_val1_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getAssignedAction_Val1IDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

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
        return ;
    }
    // $ANTLR end "ruleAssignedAction"


    // $ANTLR start "entryRuleAssignedActionSecond"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:893:1: entryRuleAssignedActionSecond : ruleAssignedActionSecond EOF ;
    public final void entryRuleAssignedActionSecond() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:893:30: ( ruleAssignedActionSecond EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:894:2: ruleAssignedActionSecond EOF
            {
             markComposite(elementTypeProvider.getAssignedActionSecondElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignedActionSecond();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:899:1: ruleAssignedActionSecond : (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) ;
    public final void ruleAssignedActionSecond() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:899:25: ( (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:900:2: (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:900:2: (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:901:3: otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getAssignedActionSecond_NumberSignDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:908:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:909:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:909:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:910:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAssignedActionSecond_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getAssignedActionSecond_Kw1Keyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:926:3: ( (lv_val2_3_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:927:4: (lv_val2_3_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:927:4: (lv_val2_3_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:928:5: lv_val2_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAssignedActionSecond_Val2IDTerminalRuleCall_3_0ElementType());
            				
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleAssignedActionSecond"


    // $ANTLR start "entryRuleUnassignedAction1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:941:1: entryRuleUnassignedAction1 : ruleUnassignedAction1 EOF ;
    public final void entryRuleUnassignedAction1() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:941:27: ( ruleUnassignedAction1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:942:2: ruleUnassignedAction1 EOF
            {
             markComposite(elementTypeProvider.getUnassignedAction1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnassignedAction1();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:947:1: ruleUnassignedAction1 : ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final void ruleUnassignedAction1() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:947:22: ( ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:948:2: ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:948:2: ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:949:3: () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:949:3: ()
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:950:4: 
            {

            				precedeComposite(elementTypeProvider.getUnassignedAction1_UnassignedAction1Action_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getUnassignedAction1_NumberSignDigitEightKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:962:3: ( (lv_val1_2_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:963:4: (lv_val1_2_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:963:4: (lv_val1_2_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:964:5: lv_val1_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnassignedAction1_Val1IDTerminalRuleCall_2_0ElementType());
            				
            lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					doneLeaf(lv_val1_2_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:973:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:974:4: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:974:4: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:975:5: lv_val2_3_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getUnassignedAction1_Val2IDTerminalRuleCall_3_0ElementType());
                    				
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleUnassignedAction1"


    // $ANTLR start "entryRuleUnassignedAction2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:988:1: entryRuleUnassignedAction2 : ruleUnassignedAction2 EOF ;
    public final void entryRuleUnassignedAction2() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:988:27: ( ruleUnassignedAction2 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:989:2: ruleUnassignedAction2 EOF
            {
             markComposite(elementTypeProvider.getUnassignedAction2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnassignedAction2();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:994:1: ruleUnassignedAction2 : ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final void ruleUnassignedAction2() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:994:22: ( ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:995:2: ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:995:2: ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:996:3: () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:996:3: ()
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:997:4: 
            {

            				precedeComposite(elementTypeProvider.getUnassignedAction2_UnassignedAction2SubAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getUnassignedAction2_NumberSignDigitNineKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1009:3: ( (lv_val1_2_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1010:4: (lv_val1_2_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1010:4: (lv_val1_2_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1011:5: lv_val1_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnassignedAction2_Val1IDTerminalRuleCall_2_0ElementType());
            				
            lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					doneLeaf(lv_val1_2_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1020:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1021:4: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1021:4: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1022:5: lv_val2_3_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getUnassignedAction2_Val2IDTerminalRuleCall_3_0ElementType());
                    				
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleUnassignedAction2"


    // $ANTLR start "entryRuleUnassignedAction3"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1035:1: entryRuleUnassignedAction3 : ruleUnassignedAction3 EOF ;
    public final void entryRuleUnassignedAction3() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1035:27: ( ruleUnassignedAction3 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1036:2: ruleUnassignedAction3 EOF
            {
             markComposite(elementTypeProvider.getUnassignedAction3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnassignedAction3();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1041:1: ruleUnassignedAction3 : (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) ;
    public final void ruleUnassignedAction3() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_val1_5_0=null;
        Token lv_val2_6_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1041:22: ( (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1042:2: (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1042:2: (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1043:3: otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )?
            {

            			markLeaf(elementTypeProvider.getUnassignedAction3_NumberSignDigitOneDigitZeroKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1050:3: ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1051:4: (otherlv_1= 'kw1' () )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1051:4: (otherlv_1= 'kw1' () )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1052:5: otherlv_1= 'kw1' ()
                    {

                    					markLeaf(elementTypeProvider.getUnassignedAction3_Kw1Keyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1059:5: ()
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1060:6: 
                    {

                    						precedeComposite(elementTypeProvider.getUnassignedAction3_UnassignedAction2Sub1Action_1_0_1ElementType());
                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1067:4: (otherlv_3= 'kw2' () )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1067:4: (otherlv_3= 'kw2' () )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1068:5: otherlv_3= 'kw2' ()
                    {

                    					markLeaf(elementTypeProvider.getUnassignedAction3_Kw2Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1075:5: ()
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1076:6: 
                    {

                    						precedeComposite(elementTypeProvider.getUnassignedAction3_UnassignedAction2Sub2Action_1_1_1ElementType());
                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1083:3: ( (lv_val1_5_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1084:4: (lv_val1_5_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1084:4: (lv_val1_5_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1085:5: lv_val1_5_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnassignedAction3_Val1IDTerminalRuleCall_2_0ElementType());
            				
            lv_val1_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					doneLeaf(lv_val1_5_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1094:3: ( (lv_val2_6_0= RULE_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1095:4: (lv_val2_6_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1095:4: (lv_val2_6_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1096:5: lv_val2_6_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getUnassignedAction3_Val2IDTerminalRuleCall_3_0ElementType());
                    				
                    lv_val2_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleUnassignedAction3"


    // $ANTLR start "entryRuleUnassignedRuleCall1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1109:1: entryRuleUnassignedRuleCall1 : ruleUnassignedRuleCall1 EOF ;
    public final void entryRuleUnassignedRuleCall1() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1109:29: ( ruleUnassignedRuleCall1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1110:2: ruleUnassignedRuleCall1 EOF
            {
             markComposite(elementTypeProvider.getUnassignedRuleCall1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnassignedRuleCall1();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1115:1: ruleUnassignedRuleCall1 : (otherlv_0= '#11' ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final void ruleUnassignedRuleCall1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val2_2_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1115:24: ( (otherlv_0= '#11' ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1116:2: (otherlv_0= '#11' ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1116:2: (otherlv_0= '#11' ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1117:3: otherlv_0= '#11' ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getUnassignedRuleCall1_NumberSignDigitOneDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getUnassignedRuleCall1_UnassignedRuleCall1SubParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            ruleUnassignedRuleCall1Sub();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1131:3: ( (lv_val2_2_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1132:4: (lv_val2_2_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1132:4: (lv_val2_2_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1133:5: lv_val2_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnassignedRuleCall1_Val2IDTerminalRuleCall_2_0ElementType());
            				
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
        return ;
    }
    // $ANTLR end "ruleUnassignedRuleCall1"


    // $ANTLR start "entryRuleUnassignedRuleCall1Sub"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1146:1: entryRuleUnassignedRuleCall1Sub : ruleUnassignedRuleCall1Sub EOF ;
    public final void entryRuleUnassignedRuleCall1Sub() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1146:32: ( ruleUnassignedRuleCall1Sub EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1147:2: ruleUnassignedRuleCall1Sub EOF
            {
             markComposite(elementTypeProvider.getUnassignedRuleCall1SubElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnassignedRuleCall1Sub();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1152:1: ruleUnassignedRuleCall1Sub : ( (lv_val1_0_0= RULE_ID ) ) ;
    public final void ruleUnassignedRuleCall1Sub() throws RecognitionException {
        Token lv_val1_0_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1152:27: ( ( (lv_val1_0_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1153:2: ( (lv_val1_0_0= RULE_ID ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1153:2: ( (lv_val1_0_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1154:3: (lv_val1_0_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1154:3: (lv_val1_0_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1155:4: lv_val1_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getUnassignedRuleCall1Sub_Val1IDTerminalRuleCall_0ElementType());
            			
            lv_val1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleUnassignedRuleCall1Sub"


    // $ANTLR start "entryRuleUnassignedRuleCall2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1167:1: entryRuleUnassignedRuleCall2 : ruleUnassignedRuleCall2 EOF ;
    public final void entryRuleUnassignedRuleCall2() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1167:29: ( ruleUnassignedRuleCall2 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1168:2: ruleUnassignedRuleCall2 EOF
            {
             markComposite(elementTypeProvider.getUnassignedRuleCall2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnassignedRuleCall2();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1173:1: ruleUnassignedRuleCall2 : (otherlv_0= '#12' ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final void ruleUnassignedRuleCall2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val2_2_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1173:24: ( (otherlv_0= '#12' ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1174:2: (otherlv_0= '#12' ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1174:2: (otherlv_0= '#12' ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1175:3: otherlv_0= '#12' ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getUnassignedRuleCall2_NumberSignDigitOneDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getUnassignedRuleCall2_UnassignedRuleCall2SubParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            ruleUnassignedRuleCall2Sub();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1189:3: ( (lv_val2_2_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1190:4: (lv_val2_2_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1190:4: (lv_val2_2_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1191:5: lv_val2_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getUnassignedRuleCall2_Val2IDTerminalRuleCall_2_0ElementType());
            				
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
        return ;
    }
    // $ANTLR end "ruleUnassignedRuleCall2"


    // $ANTLR start "entryRuleUnassignedRuleCall2Sub"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1204:1: entryRuleUnassignedRuleCall2Sub : ruleUnassignedRuleCall2Sub EOF ;
    public final void entryRuleUnassignedRuleCall2Sub() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1204:32: ( ruleUnassignedRuleCall2Sub EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1205:2: ruleUnassignedRuleCall2Sub EOF
            {
             markComposite(elementTypeProvider.getUnassignedRuleCall2SubElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnassignedRuleCall2Sub();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1210:1: ruleUnassignedRuleCall2Sub : () ;
    public final void ruleUnassignedRuleCall2Sub() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1210:27: ( () )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1211:2: ()
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1211:2: ()
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1212:3: 
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1220:1: entryRuleCombination1 : ruleCombination1 EOF ;
    public final void entryRuleCombination1() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1220:22: ( ruleCombination1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1221:2: ruleCombination1 EOF
            {
             markComposite(elementTypeProvider.getCombination1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCombination1();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1226:1: ruleCombination1 : (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) ;
    public final void ruleCombination1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token lv_val3_5_0=null;
        Token lv_val4_6_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1226:17: ( (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1227:2: (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1227:2: (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1228:3: otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            {

            			markLeaf(elementTypeProvider.getCombination1_NumberSignDigitOneDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1235:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1236:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1236:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1237:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getCombination1_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1246:3: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1247:4: otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
                    {

                    				markLeaf(elementTypeProvider.getCombination1_Kw1Keyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1254:4: ( (lv_val2_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1255:5: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1255:5: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1256:6: lv_val2_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getCombination1_Val2IDTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    						doneLeaf(lv_val2_3_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1265:4: ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
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
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1266:5: (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            {
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1266:5: (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1267:6: otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )
                            {

                            						markLeaf(elementTypeProvider.getCombination1_Kw2Keyword_2_2_0_0ElementType());
                            					
                            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                            						doneLeaf(otherlv_4);
                            					
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1274:6: ( (lv_val3_5_0= RULE_ID ) )
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1275:7: (lv_val3_5_0= RULE_ID )
                            {
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1275:7: (lv_val3_5_0= RULE_ID )
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1276:8: lv_val3_5_0= RULE_ID
                            {

                            								markLeaf(elementTypeProvider.getCombination1_Val3IDTerminalRuleCall_2_2_0_1_0ElementType());
                            							
                            lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            								doneLeaf(lv_val3_5_0);
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1287:5: ( (lv_val4_6_0= RULE_ID ) )
                            {
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1287:5: ( (lv_val4_6_0= RULE_ID ) )
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1288:6: (lv_val4_6_0= RULE_ID )
                            {
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1288:6: (lv_val4_6_0= RULE_ID )
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1289:7: lv_val4_6_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getCombination1_Val4IDTerminalRuleCall_2_2_1_0ElementType());
                            						
                            lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleCombination1"


    // $ANTLR start "entryRuleCombination2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1304:1: entryRuleCombination2 : ruleCombination2 EOF ;
    public final void entryRuleCombination2() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1304:22: ( ruleCombination2 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1305:2: ruleCombination2 EOF
            {
             markComposite(elementTypeProvider.getCombination2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCombination2();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1310:1: ruleCombination2 : (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) ;
    public final void ruleCombination2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;
        Token lv_val4_5_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1310:17: ( (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1311:2: (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1311:2: (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1312:3: otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
            {

            			markLeaf(elementTypeProvider.getCombination2_NumberSignDigitOneDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1319:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1320:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1320:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1321:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getCombination2_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1330:3: ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1331:4: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1331:4: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1332:5: otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getCombination2_Kw1Keyword_2_0_0ElementType());
                    				
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1339:5: ( (lv_val2_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1340:6: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1340:6: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1341:7: lv_val2_3_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getCombination2_Val2IDTerminalRuleCall_2_0_1_0ElementType());
                    						
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_val2_3_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1352:4: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1352:4: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1353:5: ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1353:5: ( (lv_val3_4_0= RULE_ID ) )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1354:6: (lv_val3_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1354:6: (lv_val3_4_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1355:7: lv_val3_4_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getCombination2_Val3IDTerminalRuleCall_2_1_0_0ElementType());
                    	    						
                    	    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    	    							doneLeaf(lv_val3_4_0);
                    	    						

                    	    }


                    	    }

                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1364:5: ( (lv_val4_5_0= RULE_ID ) )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1365:6: (lv_val4_5_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1365:6: (lv_val4_5_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1366:7: lv_val4_5_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getCombination2_Val4IDTerminalRuleCall_2_1_1_0ElementType());
                    	    						
                    	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

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
        return ;
    }
    // $ANTLR end "ruleCombination2"


    // $ANTLR start "entryRuleCombination3"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1381:1: entryRuleCombination3 : ruleCombination3 EOF ;
    public final void entryRuleCombination3() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1381:22: ( ruleCombination3 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1382:2: ruleCombination3 EOF
            {
             markComposite(elementTypeProvider.getCombination3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCombination3();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1387:1: ruleCombination3 : (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) ;
    public final void ruleCombination3() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token lv_val3_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1387:17: ( (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1388:2: (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1388:2: (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1389:3: otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
            {

            			markLeaf(elementTypeProvider.getCombination3_NumberSignDigitOneDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_15); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1396:3: ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1397:4: ( (lv_val1_1_0= RULE_ID ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1397:4: ( (lv_val1_1_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1398:5: (lv_val1_1_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1398:5: (lv_val1_1_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1399:6: lv_val1_1_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getCombination3_Val1IDTerminalRuleCall_1_0_0ElementType());
            	    					
            	    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

            	    						doneLeaf(lv_val1_1_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1409:4: ( (lv_val2_2_0= RULE_INT ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1409:4: ( (lv_val2_2_0= RULE_INT ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1410:5: (lv_val2_2_0= RULE_INT )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1410:5: (lv_val2_2_0= RULE_INT )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1411:6: lv_val2_2_0= RULE_INT
            	    {

            	    						markLeaf(elementTypeProvider.getCombination3_Val2INTTerminalRuleCall_1_1_0ElementType());
            	    					
            	    lv_val2_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_15); 

            	    						doneLeaf(lv_val2_2_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1421:4: ( (lv_val3_3_0= RULE_STRING ) )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1421:4: ( (lv_val3_3_0= RULE_STRING ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1422:5: (lv_val3_3_0= RULE_STRING )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1422:5: (lv_val3_3_0= RULE_STRING )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1423:6: lv_val3_3_0= RULE_STRING
            	    {

            	    						markLeaf(elementTypeProvider.getCombination3_Val3STRINGTerminalRuleCall_1_2_0ElementType());
            	    					
            	    lv_val3_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_15); 

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
        return ;
    }
    // $ANTLR end "ruleCombination3"


    // $ANTLR start "entryRuleCombination4"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1437:1: entryRuleCombination4 : ruleCombination4 EOF ;
    public final void entryRuleCombination4() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1437:22: ( ruleCombination4 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1438:2: ruleCombination4 EOF
            {
             markComposite(elementTypeProvider.getCombination4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCombination4();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1443:1: ruleCombination4 : (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) ;
    public final void ruleCombination4() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1443:17: ( (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1444:2: (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1444:2: (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1445:3: otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
            {

            			markLeaf(elementTypeProvider.getCombination4_NumberSignDigitOneDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1452:3: (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
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
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1453:4: otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getCombination4_GroupKeyword_1_0ElementType());
            	    			
            	    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_1);
            	    			
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1460:4: ( (lv_val1_2_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1461:5: (lv_val1_2_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1461:5: (lv_val1_2_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1462:6: lv_val1_2_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getCombination4_Val1IDTerminalRuleCall_1_1_0ElementType());
            	    					
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						doneLeaf(lv_val1_2_0);
            	    					

            	    }


            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1471:4: ( (lv_val2_3_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1472:5: (lv_val2_3_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1472:5: (lv_val2_3_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1473:6: lv_val2_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getCombination4_Val2IDTerminalRuleCall_1_2_0ElementType());
            	    					
            	    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						doneLeaf(lv_val2_3_0);
            	    					

            	    }


            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1482:4: ( (lv_val3_4_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1483:5: (lv_val3_4_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1483:5: (lv_val3_4_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1484:6: lv_val3_4_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getCombination4_Val3IDTerminalRuleCall_1_3_0ElementType());
            	    					
            	    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); 

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
        return ;
    }
    // $ANTLR end "ruleCombination4"


    // $ANTLR start "entryRuleList1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1498:1: entryRuleList1 : ruleList1 EOF ;
    public final void entryRuleList1() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1498:15: ( ruleList1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1499:2: ruleList1 EOF
            {
             markComposite(elementTypeProvider.getList1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleList1();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1504:1: ruleList1 : (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final void ruleList1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1504:10: ( (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1505:2: (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1505:2: (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1506:3: otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getList1_NumberSignDigitOneDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1513:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1514:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1514:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1515:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getList1_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1524:3: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==34) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1525:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getList1_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1532:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1533:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1533:5: (lv_val1_3_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1534:6: lv_val1_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getList1_Val1IDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

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
        return ;
    }
    // $ANTLR end "ruleList1"


    // $ANTLR start "entryRuleList2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1548:1: entryRuleList2 : ruleList2 EOF ;
    public final void entryRuleList2() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1548:15: ( ruleList2 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1549:2: ruleList2 EOF
            {
             markComposite(elementTypeProvider.getList2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleList2();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1554:1: ruleList2 : (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) ;
    public final void ruleList2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1554:10: ( (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1555:2: (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1555:2: (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1556:3: otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            {

            			markLeaf(elementTypeProvider.getList2_NumberSignDigitOneDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1563:3: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1564:4: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1564:4: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1565:5: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1565:5: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1566:6: lv_val1_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getList2_Val1IDTerminalRuleCall_1_0_0ElementType());
                    					
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

                    						doneLeaf(lv_val1_1_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1575:4: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==34) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1576:5: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getList2_CommaKeyword_1_1_0ElementType());
                    	    				
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    	    					doneLeaf(otherlv_2);
                    	    				
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1583:5: ( (lv_val1_3_0= RULE_ID ) )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1584:6: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1584:6: (lv_val1_3_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1585:7: lv_val1_3_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getList2_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    	    						
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

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
        return ;
    }
    // $ANTLR end "ruleList2"


    // $ANTLR start "entryRuleList3"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1600:1: entryRuleList3 : ruleList3 EOF ;
    public final void entryRuleList3() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1600:15: ( ruleList3 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1601:2: ruleList3 EOF
            {
             markComposite(elementTypeProvider.getList3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleList3();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1606:1: ruleList3 : ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) ;
    public final void ruleList3() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1606:10: ( ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1607:2: ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1607:2: ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1608:3: (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1608:3: (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1609:4: otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    {

                    				markLeaf(elementTypeProvider.getList3_NumberSignDigitOneDigitNineKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1616:4: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1617:5: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1617:5: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1618:6: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1618:6: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1619:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getList3_Val1IDTerminalRuleCall_0_1_0_0ElementType());
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

                    							doneLeaf(lv_val1_1_0);
                    						

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1628:5: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==34) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1629:6: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {

                    	    						markLeaf(elementTypeProvider.getList3_CommaKeyword_0_1_1_0ElementType());
                    	    					
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    	    						doneLeaf(otherlv_2);
                    	    					
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1636:6: ( (lv_val1_3_0= RULE_ID ) )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1637:7: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1637:7: (lv_val1_3_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1638:8: lv_val1_3_0= RULE_ID
                    	    {

                    	    								markLeaf(elementTypeProvider.getList3_Val1IDTerminalRuleCall_0_1_1_1_0ElementType());
                    	    							
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1651:3: (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1651:3: (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1652:4: otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getList3_Kw3Keyword_1_0ElementType());
                    			
                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1659:4: ( (lv_val2_5_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1660:5: (lv_val2_5_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1660:5: (lv_val2_5_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1661:6: lv_val2_5_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getList3_Val2IDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleList3"


    // $ANTLR start "entryRuleList4"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1675:1: entryRuleList4 : ruleList4 EOF ;
    public final void entryRuleList4() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1675:15: ( ruleList4 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1676:2: ruleList4 EOF
            {
             markComposite(elementTypeProvider.getList4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleList4();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1681:1: ruleList4 : (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ;
    public final void ruleList4() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1681:10: ( (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1682:2: (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1682:2: (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1683:3: otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getList4_NumberSignDigitTwoDigitZeroKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1690:3: ( (lv_val1_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1691:4: (lv_val1_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1691:4: (lv_val1_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1692:5: lv_val1_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getList4_Val1IDTerminalRuleCall_1_0ElementType());
            				
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

            					doneLeaf(lv_val1_1_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1701:3: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==34) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1702:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getList4_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1709:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1710:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1710:5: (lv_val1_3_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1711:6: lv_val1_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getList4_Val1IDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

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
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1728:3: ( (lv_val2_5_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1729:4: (lv_val2_5_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1729:4: (lv_val2_5_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1730:5: lv_val2_5_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getList4_Val2IDTerminalRuleCall_4_0ElementType());
            				
            lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleList4"


    // $ANTLR start "entryRuleList5"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1743:1: entryRuleList5 : ruleList5 EOF ;
    public final void entryRuleList5() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1743:15: ( ruleList5 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1744:2: ruleList5 EOF
            {
             markComposite(elementTypeProvider.getList5ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleList5();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1749:1: ruleList5 : (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) ;
    public final void ruleList5() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;
        Token lv_val3_6_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1749:10: ( (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1750:2: (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1750:2: (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1751:3: otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
            {

            			markLeaf(elementTypeProvider.getList5_NumberSignDigitTwoDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1758:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1759:4: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1759:4: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1760:5: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1760:5: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1761:6: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1761:6: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1762:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getList5_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

                    							doneLeaf(lv_val1_1_0);
                    						

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1771:5: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==34) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1772:6: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {

                    	    						markLeaf(elementTypeProvider.getList5_CommaKeyword_1_0_1_0ElementType());
                    	    					
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    	    						doneLeaf(otherlv_2);
                    	    					
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1779:6: ( (lv_val1_3_0= RULE_ID ) )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1780:7: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1780:7: (lv_val1_3_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1781:8: lv_val1_3_0= RULE_ID
                    	    {

                    	    								markLeaf(elementTypeProvider.getList5_Val1IDTerminalRuleCall_1_0_1_1_0ElementType());
                    	    							
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

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
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1798:5: ( (lv_val2_5_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1799:6: (lv_val2_5_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1799:6: (lv_val2_5_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1800:7: lv_val2_5_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getList5_Val2IDTerminalRuleCall_1_0_3_0ElementType());
                    						
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_val2_5_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1811:4: ( (lv_val3_6_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1811:4: ( (lv_val3_6_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1812:5: (lv_val3_6_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1812:5: (lv_val3_6_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1813:6: lv_val3_6_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getList5_Val3IDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleList5"


    // $ANTLR start "entryRuleAltList1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1827:1: entryRuleAltList1 : ruleAltList1 EOF ;
    public final void entryRuleAltList1() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1827:18: ( ruleAltList1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1828:2: ruleAltList1 EOF
            {
             markComposite(elementTypeProvider.getAltList1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAltList1();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1833:1: ruleAltList1 : (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1833:13: ( (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1834:2: (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1834:2: (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1835:3: otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            {

            			markLeaf(elementTypeProvider.getAltList1_NumberSignDigitTwoDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1842:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1843:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1843:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1844:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1844:5: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1845:6: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1845:6: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1846:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							doneLeaf(lv_val1_1_0);
                    						

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1855:5: ( (lv_val2_2_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1856:6: (lv_val2_2_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1856:6: (lv_val2_2_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1857:7: lv_val2_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val2IDTerminalRuleCall_1_0_1_0ElementType());
                    						
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_val2_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1868:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1868:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1869:5: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getAltList1_Kw1Keyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1876:5: ( (lv_val1_4_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1877:6: (lv_val1_4_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1877:6: (lv_val1_4_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1878:7: lv_val1_4_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    						
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							doneLeaf(lv_val1_4_0);
                    						

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1887:5: ( (lv_val3_5_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1888:6: (lv_val3_5_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1888:6: (lv_val3_5_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1889:7: lv_val3_5_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val3IDTerminalRuleCall_1_1_2_0ElementType());
                    						
                    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_val3_5_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1900:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1900:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1901:5: otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )?
                    {

                    					markLeaf(elementTypeProvider.getAltList1_Kw2Keyword_1_2_0ElementType());
                    				
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_6);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1908:5: ( (lv_val1_7_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1909:6: (lv_val1_7_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1909:6: (lv_val1_7_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1910:7: lv_val1_7_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList1_Val1IDTerminalRuleCall_1_2_1_0ElementType());
                    						
                    lv_val1_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    							doneLeaf(lv_val1_7_0);
                    						

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1919:5: ( (lv_val4_8_0= RULE_ID ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==RULE_ID) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1920:6: (lv_val4_8_0= RULE_ID )
                            {
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1920:6: (lv_val4_8_0= RULE_ID )
                            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1921:7: lv_val4_8_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getAltList1_Val4IDTerminalRuleCall_1_2_2_0ElementType());
                            						
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
        return ;
    }
    // $ANTLR end "ruleAltList1"


    // $ANTLR start "entryRuleAltList2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1936:1: entryRuleAltList2 : ruleAltList2 EOF ;
    public final void entryRuleAltList2() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1936:18: ( ruleAltList2 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1937:2: ruleAltList2 EOF
            {
             markComposite(elementTypeProvider.getAltList2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAltList2();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1942:1: ruleAltList2 : (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1942:13: ( (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1943:2: (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1943:2: (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1944:3: otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            {

            			markLeaf(elementTypeProvider.getAltList2_NumberSignDigitTwoDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:1951:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1952:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1952:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1953:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1953:5: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1954:6: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1954:6: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1955:7: lv_val1_1_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_0_0_0ElementType());
                    						
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							doneLeaf(lv_val1_1_0);
                    						

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1964:5: ( (lv_val2_2_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1965:6: (lv_val2_2_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1965:6: (lv_val2_2_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1966:7: lv_val2_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val2IDTerminalRuleCall_1_0_1_0ElementType());
                    						
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_val2_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1977:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1977:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1978:5: otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getAltList2_KwKeyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,41,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1985:5: ( (lv_val1_4_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1986:6: (lv_val1_4_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1986:6: (lv_val1_4_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1987:7: lv_val1_4_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_1_1_0ElementType());
                    						
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    							doneLeaf(lv_val1_4_0);
                    						

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1996:5: (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==34) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:1997:6: otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) )
                    	    {

                    	    						markLeaf(elementTypeProvider.getAltList2_CommaKeyword_1_1_2_0ElementType());
                    	    					
                    	    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    	    						doneLeaf(otherlv_5);
                    	    					
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2004:6: ( (lv_val1_6_0= RULE_ID ) )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2005:7: (lv_val1_6_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2005:7: (lv_val1_6_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2006:8: lv_val1_6_0= RULE_ID
                    	    {

                    	    								markLeaf(elementTypeProvider.getAltList2_Val1IDTerminalRuleCall_1_1_2_1_0ElementType());
                    	    							
                    	    lv_val1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    	    								doneLeaf(lv_val1_6_0);
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2016:5: ( (lv_val3_7_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2017:6: (lv_val3_7_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2017:6: (lv_val3_7_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2018:7: lv_val3_7_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getAltList2_Val3IDTerminalRuleCall_1_1_3_0ElementType());
                    						
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
        return ;
    }
    // $ANTLR end "ruleAltList2"


    // $ANTLR start "entryRuleTransientObject"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2033:1: entryRuleTransientObject : ruleTransientObject EOF ;
    public final void entryRuleTransientObject() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2033:25: ( ruleTransientObject EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2034:2: ruleTransientObject EOF
            {
             markComposite(elementTypeProvider.getTransientObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTransientObject();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2039:1: ruleTransientObject : (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) ;
    public final void ruleTransientObject() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2039:20: ( (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2040:2: (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2040:2: (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2041:3: otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            {

            			markLeaf(elementTypeProvider.getTransientObject_NumberSignDigitTwoDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2048:3: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2049:4: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2049:4: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2050:5: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2050:5: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2051:6: lv_val1_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTransientObject_Val1IDTerminalRuleCall_1_0_0ElementType());
                    					
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    						doneLeaf(lv_val1_1_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2060:4: ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2061:5: (lv_nested_2_0= ruleTransientObjectSub )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2061:5: (lv_nested_2_0= ruleTransientObjectSub )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2062:6: lv_nested_2_0= ruleTransientObjectSub
                    {

                    						markComposite(elementTypeProvider.getTransientObject_NestedTransientObjectSubParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2076:1: entryRuleTransientObjectSub : ruleTransientObjectSub EOF ;
    public final void entryRuleTransientObjectSub() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2076:28: ( ruleTransientObjectSub EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2077:2: ruleTransientObjectSub EOF
            {
             markComposite(elementTypeProvider.getTransientObjectSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTransientObjectSub();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2082:1: ruleTransientObjectSub : ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) ;
    public final void ruleTransientObjectSub() throws RecognitionException {
        Token lv_val2_0_0=null;
        Token lv_val3_1_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2082:23: ( ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2083:2: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2083:2: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2084:3: ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2084:3: ( (lv_val2_0_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2085:4: (lv_val2_0_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2085:4: (lv_val2_0_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2086:5: lv_val2_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTransientObjectSub_Val2IDTerminalRuleCall_0_0ElementType());
            				
            lv_val2_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_val2_0_0);
            				

            }


            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2095:3: ( (lv_val3_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2096:4: (lv_val3_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2096:4: (lv_val3_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2097:5: lv_val3_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTransientObjectSub_Val3IDTerminalRuleCall_1_0ElementType());
            				
            lv_val3_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleTransientObjectSub"


    // $ANTLR start "entryRuleTransientSerializeables1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2110:1: entryRuleTransientSerializeables1 : ruleTransientSerializeables1 EOF ;
    public final void entryRuleTransientSerializeables1() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2110:34: ( ruleTransientSerializeables1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2111:2: ruleTransientSerializeables1 EOF
            {
             markComposite(elementTypeProvider.getTransientSerializeables1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTransientSerializeables1();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2116:1: ruleTransientSerializeables1 : (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) ;
    public final void ruleTransientSerializeables1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_int1_4_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2116:29: ( (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2117:2: (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2117:2: (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2118:3: otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            {

            			markLeaf(elementTypeProvider.getTransientSerializeables1_NumberSignDigitTwoDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,43,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2125:3: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )?
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2126:4: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2126:4: ( (lv_val1_1_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2127:5: (lv_val1_1_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2127:5: (lv_val1_1_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2128:6: lv_val1_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTransientSerializeables1_Val1IDTerminalRuleCall_1_0_0ElementType());
                    					
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

                    						doneLeaf(lv_val1_1_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2137:4: ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2138:5: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2138:5: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2139:6: lv_enum1_2_0= ruleTransientSerializeables1Enum
                    {

                    						markComposite(elementTypeProvider.getTransientSerializeables1_Enum1TransientSerializeables1EnumEnumRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    ruleTransientSerializeables1Enum();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2149:3: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2150:4: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2150:4: ( (lv_val2_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2151:5: (lv_val2_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2151:5: (lv_val2_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2152:6: lv_val2_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTransientSerializeables1_Val2IDTerminalRuleCall_2_0_0ElementType());
                    					
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_23); 

                    						doneLeaf(lv_val2_3_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2161:4: ( (lv_int1_4_0= RULE_INT ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2162:5: (lv_int1_4_0= RULE_INT )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2162:5: (lv_int1_4_0= RULE_INT )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2163:6: lv_int1_4_0= RULE_INT
                    {

                    						markLeaf(elementTypeProvider.getTransientSerializeables1_Int1INTTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_int1_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleTransientSerializeables1"


    // $ANTLR start "entryRuleStaticSimplification"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2177:1: entryRuleStaticSimplification : ruleStaticSimplification EOF ;
    public final void entryRuleStaticSimplification() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2177:30: ( ruleStaticSimplification EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2178:2: ruleStaticSimplification EOF
            {
             markComposite(elementTypeProvider.getStaticSimplificationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleStaticSimplification();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2183:1: ruleStaticSimplification : (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2183:25: ( (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2184:2: (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2184:2: (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2185:3: otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? )
            {

            			markLeaf(elementTypeProvider.getStaticSimplification_NumberSignDigitTwoDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2192:3: (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2193:4: otherlv_1= 'kw1'
                    {

                    				markLeaf(elementTypeProvider.getStaticSimplification_Kw1Keyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_1);
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2201:4: ()
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2201:4: ()
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2202:5: 
                    {

                    					precedeComposite(elementTypeProvider.getStaticSimplification_EmptyAlternativeSubAction_1_1ElementType());
                    					doneComposite();
                    				

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2208:4: ( (lv_val1_3_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2208:4: ( (lv_val1_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2209:5: (lv_val1_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2209:5: (lv_val1_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2210:6: lv_val1_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getStaticSimplification_Val1IDTerminalRuleCall_1_2_0ElementType());
                    					
                    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    						doneLeaf(lv_val1_3_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2220:3: (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2221:4: otherlv_4= 'kw2'
                    {

                    				markLeaf(elementTypeProvider.getStaticSimplification_Kw2Keyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_24); 

                    				doneLeaf(otherlv_4);
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2229:4: ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2229:4: ( (lv_val2_5_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2230:5: (lv_val2_5_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2230:5: (lv_val2_5_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2231:6: lv_val2_5_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getStaticSimplification_Val2IDTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_24); 

                    						doneLeaf(lv_val2_5_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2241:3: (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2242:4: otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )?
            {

            				markLeaf(elementTypeProvider.getStaticSimplification_Kw3Keyword_3_0ElementType());
            			
            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_25); 

            				doneLeaf(otherlv_6);
            			
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2249:4: (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==19) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2250:5: otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+
                    {

                    					markLeaf(elementTypeProvider.getStaticSimplification_Kw4Keyword_3_1_0ElementType());
                    				
                    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_7);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2257:5: ( (lv_val3_8_0= RULE_ID ) )+
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
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2258:6: (lv_val3_8_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2258:6: (lv_val3_8_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2259:7: lv_val3_8_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getStaticSimplification_Val3IDTerminalRuleCall_3_1_1_0ElementType());
                    	    						
                    	    lv_val3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

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
        return ;
    }
    // $ANTLR end "ruleStaticSimplification"


    // $ANTLR start "entryRuleTwoVersion"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2274:1: entryRuleTwoVersion : ruleTwoVersion EOF ;
    public final void entryRuleTwoVersion() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2274:20: ( ruleTwoVersion EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2275:2: ruleTwoVersion EOF
            {
             markComposite(elementTypeProvider.getTwoVersionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTwoVersion();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2280:1: ruleTwoVersion : (otherlv_0= '#27' ( ruleTwoVersionNo1 | ruleTwoVersionNo2 ) ) ;
    public final void ruleTwoVersion() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2280:15: ( (otherlv_0= '#27' ( ruleTwoVersionNo1 | ruleTwoVersionNo2 ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2281:2: (otherlv_0= '#27' ( ruleTwoVersionNo1 | ruleTwoVersionNo2 ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2281:2: (otherlv_0= '#27' ( ruleTwoVersionNo1 | ruleTwoVersionNo2 ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2282:3: otherlv_0= '#27' ( ruleTwoVersionNo1 | ruleTwoVersionNo2 )
            {

            			markLeaf(elementTypeProvider.getTwoVersion_NumberSignDigitTwoDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2289:3: ( ruleTwoVersionNo1 | ruleTwoVersionNo2 )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    int LA42_2 = input.LA(3);

                    if ( (LA42_2==46) ) {
                        alt42=1;
                    }
                    else if ( (LA42_2==48) ) {
                        alt42=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case 46:
                    {
                    alt42=1;
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2290:4: ruleTwoVersionNo1
                    {

                    				markComposite(elementTypeProvider.getTwoVersion_TwoVersionNo1ParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTwoVersionNo1();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2298:4: ruleTwoVersionNo2
                    {

                    				markComposite(elementTypeProvider.getTwoVersion_TwoVersionNo2ParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2310:1: entryRuleTwoVersionNo1 : ruleTwoVersionNo1 EOF ;
    public final void entryRuleTwoVersionNo1() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2310:23: ( ruleTwoVersionNo1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2311:2: ruleTwoVersionNo1 EOF
            {
             markComposite(elementTypeProvider.getTwoVersionNo1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTwoVersionNo1();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2316:1: ruleTwoVersionNo1 : ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? ) ;
    public final void ruleTwoVersionNo1() throws RecognitionException {
        Token lv_shared1_0_0=null;
        Token lv_shared2_1_0=null;
        Token otherlv_2=null;
        Token lv_shared3_3_0=null;
        Token lv_shared3_4_0=null;
        Token otherlv_5=null;
        Token lv_version1_6_0=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2316:18: ( ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2317:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2317:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2318:3: ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )?
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2318:3: ( (lv_shared1_0_0= RULE_ID ) )?
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2319:4: (lv_shared1_0_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2319:4: (lv_shared1_0_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2320:5: lv_shared1_0_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getTwoVersionNo1_Shared1IDTerminalRuleCall_0_0ElementType());
                    				
                    lv_shared1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    					doneLeaf(lv_shared1_0_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2329:3: ( (lv_shared2_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2330:4: (lv_shared2_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2330:4: (lv_shared2_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2331:5: lv_shared2_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTwoVersionNo1_Shared2IDTerminalRuleCall_1_0ElementType());
            				
            lv_shared2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            					doneLeaf(lv_shared2_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getTwoVersionNo1_ShortKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,46,FollowSets000.FOLLOW_27); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2347:3: ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2348:4: ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )*
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2348:4: ( (lv_shared3_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2349:5: (lv_shared3_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2349:5: (lv_shared3_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2350:6: lv_shared3_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTwoVersionNo1_Shared3IDTerminalRuleCall_3_0_0ElementType());
                    					
                    lv_shared3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_27); 

                    						doneLeaf(lv_shared3_3_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2359:4: ( (lv_shared3_4_0= RULE_ID ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==RULE_ID) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2360:5: (lv_shared3_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2360:5: (lv_shared3_4_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2361:6: lv_shared3_4_0= RULE_ID
                    	    {

                    	    						markLeaf(elementTypeProvider.getTwoVersionNo1_Shared3IDTerminalRuleCall_3_1_0ElementType());
                    	    					
                    	    lv_shared3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_27); 

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
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2378:3: ( (lv_version1_6_0= RULE_ID ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2379:4: (lv_version1_6_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2379:4: (lv_version1_6_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2380:5: lv_version1_6_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getTwoVersionNo1_Version1IDTerminalRuleCall_5_0ElementType());
                    				
                    lv_version1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleTwoVersionNo1"


    // $ANTLR start "entryRuleTwoVersionNo2"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2393:1: entryRuleTwoVersionNo2 : ruleTwoVersionNo2 EOF ;
    public final void entryRuleTwoVersionNo2() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2393:23: ( ruleTwoVersionNo2 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2394:2: ruleTwoVersionNo2 EOF
            {
             markComposite(elementTypeProvider.getTwoVersionNo2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTwoVersionNo2();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2399:1: ruleTwoVersionNo2 : ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2399:18: ( ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2400:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2400:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2401:3: ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )?
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2401:3: ( (lv_shared1_0_0= RULE_ID ) )?
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2402:4: (lv_shared1_0_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2402:4: (lv_shared1_0_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2403:5: lv_shared1_0_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getTwoVersionNo2_Shared1IDTerminalRuleCall_0_0ElementType());
                    				
                    lv_shared1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    					doneLeaf(lv_shared1_0_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2412:3: ( (lv_shared2_1_0= RULE_ID ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2413:4: (lv_shared2_1_0= RULE_ID )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2413:4: (lv_shared2_1_0= RULE_ID )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2414:5: lv_shared2_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTwoVersionNo2_Shared2IDTerminalRuleCall_1_0ElementType());
            				
            lv_shared2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_28); 

            					doneLeaf(lv_shared2_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getTwoVersionNo2_LongKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,48,FollowSets000.FOLLOW_29); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2430:3: ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2431:4: ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )*
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2431:4: ( (lv_shared3_3_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2432:5: (lv_shared3_3_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2432:5: (lv_shared3_3_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2433:6: lv_shared3_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getTwoVersionNo2_Shared3IDTerminalRuleCall_3_0_0ElementType());
                    					
                    lv_shared3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

                    						doneLeaf(lv_shared3_3_0);
                    					

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2442:4: ( (lv_shared3_4_0= RULE_ID ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==RULE_ID) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2443:5: (lv_shared3_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2443:5: (lv_shared3_4_0= RULE_ID )
                    	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2444:6: lv_shared3_4_0= RULE_ID
                    	    {

                    	    						markLeaf(elementTypeProvider.getTwoVersionNo2_Shared3IDTerminalRuleCall_3_1_0ElementType());
                    	    					
                    	    lv_shared3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

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
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2461:3: ( (lv_extra1_6_0= RULE_ID ) )?
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2462:4: (lv_extra1_6_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2462:4: (lv_extra1_6_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2463:5: lv_extra1_6_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getTwoVersionNo2_Extra1IDTerminalRuleCall_5_0ElementType());
                    				
                    lv_extra1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_30); 

                    					doneLeaf(lv_extra1_6_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2472:3: ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )?
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2473:4: ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2473:4: ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2474:5: ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2474:5: ( (lv_extra2_7_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2475:6: (lv_extra2_7_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2475:6: (lv_extra2_7_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2476:7: lv_extra2_7_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTwoVersionNo2_Extra2IDTerminalRuleCall_6_0_0_0ElementType());
                    						
                    lv_extra2_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							doneLeaf(lv_extra2_7_0);
                    						

                    }


                    }

                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2485:5: ( (lv_extra3_8_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2486:6: (lv_extra3_8_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2486:6: (lv_extra3_8_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2487:7: lv_extra3_8_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTwoVersionNo2_Extra3IDTerminalRuleCall_6_0_1_0ElementType());
                    						
                    lv_extra3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_extra3_8_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2498:4: (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2498:4: (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2499:5: otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getTwoVersionNo2_TwoKeyword_6_1_0ElementType());
                    				
                    otherlv_9=(Token)match(input,50,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_9);
                    				
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2506:5: ( (lv_extra4_10_0= RULE_ID ) )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2507:6: (lv_extra4_10_0= RULE_ID )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2507:6: (lv_extra4_10_0= RULE_ID )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2508:7: lv_extra4_10_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTwoVersionNo2_Extra4IDTerminalRuleCall_6_1_1_0ElementType());
                    						
                    lv_extra4_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleTwoVersionNo2"


    // $ANTLR start "entryRuleHeuristic1"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2523:1: entryRuleHeuristic1 : ruleHeuristic1 EOF ;
    public final void entryRuleHeuristic1() throws RecognitionException {
        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2523:20: ( ruleHeuristic1 EOF )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2524:2: ruleHeuristic1 EOF
            {
             markComposite(elementTypeProvider.getHeuristic1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleHeuristic1();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2529:1: ruleHeuristic1 : (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* ) ;
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
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2529:15: ( (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2530:2: (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2530:2: (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2531:3: otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getHeuristic1_NumberSignDigitTwoDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_31); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2538:3: (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==13) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2539:4: otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getHeuristic1_Kw1Keyword_1_0ElementType());
            	    			
            	    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_1);
            	    			
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2546:4: ( (lv_a_2_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2547:5: (lv_a_2_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2547:5: (lv_a_2_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2548:6: lv_a_2_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getHeuristic1_AIDTerminalRuleCall_1_1_0ElementType());
            	    					
            	    lv_a_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						doneLeaf(lv_a_2_0);
            	    					

            	    }


            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2557:4: ( (lv_b_3_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2558:5: (lv_b_3_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2558:5: (lv_b_3_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2559:6: lv_b_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getHeuristic1_BIDTerminalRuleCall_1_2_0ElementType());
            	    					
            	    lv_b_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_31); 

            	    						doneLeaf(lv_b_3_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2569:3: (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==14) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2570:4: otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getHeuristic1_Kw2Keyword_2_0ElementType());
            	    			
            	    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_4);
            	    			
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2577:4: ( (lv_a_5_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2578:5: (lv_a_5_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2578:5: (lv_a_5_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2579:6: lv_a_5_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getHeuristic1_AIDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_a_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						doneLeaf(lv_a_5_0);
            	    					

            	    }


            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2588:4: ( (lv_c_6_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2589:5: (lv_c_6_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2589:5: (lv_c_6_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2590:6: lv_c_6_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getHeuristic1_CIDTerminalRuleCall_2_2_0ElementType());
            	    					
            	    lv_c_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); 

            	    						doneLeaf(lv_c_6_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2600:3: (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==16) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2601:4: otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getHeuristic1_Kw3Keyword_3_0ElementType());
            	    			
            	    otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_7);
            	    			
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2608:4: ( (lv_b_8_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2609:5: (lv_b_8_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2609:5: (lv_b_8_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2610:6: lv_b_8_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getHeuristic1_BIDTerminalRuleCall_3_1_0ElementType());
            	    					
            	    lv_b_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						doneLeaf(lv_b_8_0);
            	    					

            	    }


            	    }

            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2619:4: ( (lv_c_9_0= RULE_ID ) )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2620:5: (lv_c_9_0= RULE_ID )
            	    {
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2620:5: (lv_c_9_0= RULE_ID )
            	    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2621:6: lv_c_9_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getHeuristic1_CIDTerminalRuleCall_3_2_0ElementType());
            	    					
            	    lv_c_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_33); 

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
        return ;
    }
    // $ANTLR end "ruleHeuristic1"


    // $ANTLR start "ruleTransientSerializeables1Enum"
    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2635:1: ruleTransientSerializeables1Enum : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) ;
    public final void ruleTransientSerializeables1Enum() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2635:33: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) )
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2636:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            {
            // PsiInternalConcreteSyntaxValidationTestLanguage.g:2636:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
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
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2637:3: (enumLiteral_0= 'lit1' )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2637:3: (enumLiteral_0= 'lit1' )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2638:4: enumLiteral_0= 'lit1'
                    {

                    				markLeaf(elementTypeProvider.getTransientSerializeables1Enum_Lit1EnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,52,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2647:3: (enumLiteral_1= 'lit2' )
                    {
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2647:3: (enumLiteral_1= 'lit2' )
                    // PsiInternalConcreteSyntaxValidationTestLanguage.g:2648:4: enumLiteral_1= 'lit2'
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
        return ;
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