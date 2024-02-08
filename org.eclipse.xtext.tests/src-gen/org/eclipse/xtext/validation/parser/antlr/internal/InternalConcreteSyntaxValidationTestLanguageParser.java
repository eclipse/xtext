package org.eclipse.xtext.validation.parser.antlr.internal;

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
import org.eclipse.xtext.validation.services.ConcreteSyntaxValidationTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalConcreteSyntaxValidationTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'kw1'", "'kw2'", "'#3'", "'kw3'", "'#4'", "'#5'", "'kw4'", "'kw5'", "'#6'", "'#7'", "'#8'", "'#9'", "'#10'", "'#11'", "'#12'", "'#13'", "'#14'", "'#15'", "'#16'", "'group'", "'#17'", "','", "'#18'", "'#19'", "'#20'", "'#21'", "'#22'", "'#23'", "'kw'", "'#24'", "'#25'", "'#26'", "'#27'", "'short'", "'one'", "'long'", "'extra'", "'two'", "'#28'", "'lit1'", "'lit2'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalConcreteSyntaxValidationTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConcreteSyntaxValidationTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConcreteSyntaxValidationTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalConcreteSyntaxValidationTestLanguage.g"; }



     	private ConcreteSyntaxValidationTestLanguageGrammarAccess grammarAccess;

        public InternalConcreteSyntaxValidationTestLanguageParser(TokenStream input, ConcreteSyntaxValidationTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected ConcreteSyntaxValidationTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalConcreteSyntaxValidationTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:70:46: (iv_ruleModel= ruleModel EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:71:2: iv_ruleModel= ruleModel EOF
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
    // InternalConcreteSyntaxValidationTestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) ) ;
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

        EObject lv_x15_14_0 = null;

        EObject lv_x16_15_0 = null;

        EObject lv_x17_16_0 = null;

        EObject lv_x18_17_0 = null;

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



        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:83:2: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:84:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:84:2: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:85:3: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:85:3: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:86:4: (lv_x1_0_0= ruleSimpleGroup )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:86:4: (lv_x1_0_0= ruleSimpleGroup )
                    // InternalConcreteSyntaxValidationTestLanguage.g:87:5: lv_x1_0_0= ruleSimpleGroup
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
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.SimpleGroup");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:105:3: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:105:3: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:106:4: (lv_x2_1_0= ruleSimpleAlternative )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:106:4: (lv_x2_1_0= ruleSimpleAlternative )
                    // InternalConcreteSyntaxValidationTestLanguage.g:107:5: lv_x2_1_0= ruleSimpleAlternative
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
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.SimpleAlternative");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:125:3: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:125:3: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:126:4: (lv_x3_2_0= ruleSimpleMultiplicities )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:126:4: (lv_x3_2_0= ruleSimpleMultiplicities )
                    // InternalConcreteSyntaxValidationTestLanguage.g:127:5: lv_x3_2_0= ruleSimpleMultiplicities
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
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.SimpleMultiplicities");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:145:3: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:145:3: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:146:4: (lv_x4_3_0= ruleGroupMultiplicities )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:146:4: (lv_x4_3_0= ruleGroupMultiplicities )
                    // InternalConcreteSyntaxValidationTestLanguage.g:147:5: lv_x4_3_0= ruleGroupMultiplicities
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
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.GroupMultiplicities");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:165:3: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:165:3: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:166:4: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:166:4: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    // InternalConcreteSyntaxValidationTestLanguage.g:167:5: lv_x5_4_0= ruleAlternativeMultiplicities
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
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.AlternativeMultiplicities");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:185:3: ( (lv_x6_5_0= ruleAssignedAction ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:185:3: ( (lv_x6_5_0= ruleAssignedAction ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:186:4: (lv_x6_5_0= ruleAssignedAction )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:186:4: (lv_x6_5_0= ruleAssignedAction )
                    // InternalConcreteSyntaxValidationTestLanguage.g:187:5: lv_x6_5_0= ruleAssignedAction
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX6AssignedActionParserRuleCall_5_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x6_5_0=ruleAssignedAction();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x6",
                    						lv_x6_5_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.AssignedAction");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:205:3: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:205:3: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:206:4: (lv_x7_6_0= ruleAssignedActionSecond )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:206:4: (lv_x7_6_0= ruleAssignedActionSecond )
                    // InternalConcreteSyntaxValidationTestLanguage.g:207:5: lv_x7_6_0= ruleAssignedActionSecond
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX7AssignedActionSecondParserRuleCall_6_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x7_6_0=ruleAssignedActionSecond();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x7",
                    						lv_x7_6_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.AssignedActionSecond");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:225:3: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:225:3: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:226:4: (lv_x8_7_0= ruleUnassignedAction1 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:226:4: (lv_x8_7_0= ruleUnassignedAction1 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:227:5: lv_x8_7_0= ruleUnassignedAction1
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX8UnassignedAction1ParserRuleCall_7_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x8_7_0=ruleUnassignedAction1();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x8",
                    						lv_x8_7_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.UnassignedAction1");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:245:3: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:245:3: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:246:4: (lv_x9_8_0= ruleUnassignedAction2 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:246:4: (lv_x9_8_0= ruleUnassignedAction2 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:247:5: lv_x9_8_0= ruleUnassignedAction2
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX9UnassignedAction2ParserRuleCall_8_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x9_8_0=ruleUnassignedAction2();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x9",
                    						lv_x9_8_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.UnassignedAction2");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:265:3: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:265:3: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:266:4: (lv_x10_9_0= ruleUnassignedAction3 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:266:4: (lv_x10_9_0= ruleUnassignedAction3 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:267:5: lv_x10_9_0= ruleUnassignedAction3
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX10UnassignedAction3ParserRuleCall_9_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x10_9_0=ruleUnassignedAction3();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x10",
                    						lv_x10_9_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.UnassignedAction3");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:285:3: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:285:3: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:286:4: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:286:4: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:287:5: lv_x11_10_0= ruleUnassignedRuleCall1
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX11UnassignedRuleCall1ParserRuleCall_10_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x11_10_0=ruleUnassignedRuleCall1();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x11",
                    						lv_x11_10_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.UnassignedRuleCall1");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:305:3: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:305:3: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:306:4: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:306:4: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:307:5: lv_x12_11_0= ruleUnassignedRuleCall2
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX12UnassignedRuleCall2ParserRuleCall_11_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x12_11_0=ruleUnassignedRuleCall2();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x12",
                    						lv_x12_11_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.UnassignedRuleCall2");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:325:3: ( (lv_x13_12_0= ruleCombination1 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:325:3: ( (lv_x13_12_0= ruleCombination1 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:326:4: (lv_x13_12_0= ruleCombination1 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:326:4: (lv_x13_12_0= ruleCombination1 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:327:5: lv_x13_12_0= ruleCombination1
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX13Combination1ParserRuleCall_12_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x13_12_0=ruleCombination1();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x13",
                    						lv_x13_12_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.Combination1");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:345:3: ( (lv_x14_13_0= ruleCombination2 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:345:3: ( (lv_x14_13_0= ruleCombination2 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:346:4: (lv_x14_13_0= ruleCombination2 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:346:4: (lv_x14_13_0= ruleCombination2 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:347:5: lv_x14_13_0= ruleCombination2
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX14Combination2ParserRuleCall_13_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x14_13_0=ruleCombination2();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x14",
                    						lv_x14_13_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.Combination2");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 15 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:365:3: ( (lv_x15_14_0= ruleCombination3 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:365:3: ( (lv_x15_14_0= ruleCombination3 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:366:4: (lv_x15_14_0= ruleCombination3 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:366:4: (lv_x15_14_0= ruleCombination3 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:367:5: lv_x15_14_0= ruleCombination3
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX15Combination3ParserRuleCall_14_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x15_14_0=ruleCombination3();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x15",
                    						lv_x15_14_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.Combination3");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 16 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:385:3: ( (lv_x16_15_0= ruleCombination4 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:385:3: ( (lv_x16_15_0= ruleCombination4 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:386:4: (lv_x16_15_0= ruleCombination4 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:386:4: (lv_x16_15_0= ruleCombination4 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:387:5: lv_x16_15_0= ruleCombination4
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX16Combination4ParserRuleCall_15_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x16_15_0=ruleCombination4();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x16",
                    						lv_x16_15_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.Combination4");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 17 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:405:3: ( (lv_x17_16_0= ruleList1 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:405:3: ( (lv_x17_16_0= ruleList1 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:406:4: (lv_x17_16_0= ruleList1 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:406:4: (lv_x17_16_0= ruleList1 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:407:5: lv_x17_16_0= ruleList1
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX17List1ParserRuleCall_16_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x17_16_0=ruleList1();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x17",
                    						lv_x17_16_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.List1");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 18 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:425:3: ( (lv_x18_17_0= ruleList2 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:425:3: ( (lv_x18_17_0= ruleList2 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:426:4: (lv_x18_17_0= ruleList2 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:426:4: (lv_x18_17_0= ruleList2 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:427:5: lv_x18_17_0= ruleList2
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX18List2ParserRuleCall_17_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x18_17_0=ruleList2();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x18",
                    						lv_x18_17_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.List2");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 19 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:445:3: ( (lv_x19_18_0= ruleList3 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:445:3: ( (lv_x19_18_0= ruleList3 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:446:4: (lv_x19_18_0= ruleList3 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:446:4: (lv_x19_18_0= ruleList3 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:447:5: lv_x19_18_0= ruleList3
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX19List3ParserRuleCall_18_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x19_18_0=ruleList3();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x19",
                    						lv_x19_18_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.List3");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 20 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:465:3: ( (lv_x20_19_0= ruleList4 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:465:3: ( (lv_x20_19_0= ruleList4 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:466:4: (lv_x20_19_0= ruleList4 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:466:4: (lv_x20_19_0= ruleList4 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:467:5: lv_x20_19_0= ruleList4
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX20List4ParserRuleCall_19_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x20_19_0=ruleList4();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x20",
                    						lv_x20_19_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.List4");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 21 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:485:3: ( (lv_x21_20_0= ruleList5 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:485:3: ( (lv_x21_20_0= ruleList5 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:486:4: (lv_x21_20_0= ruleList5 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:486:4: (lv_x21_20_0= ruleList5 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:487:5: lv_x21_20_0= ruleList5
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX21List5ParserRuleCall_20_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x21_20_0=ruleList5();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x21",
                    						lv_x21_20_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.List5");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 22 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:505:3: ( (lv_x22_21_0= ruleAltList1 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:505:3: ( (lv_x22_21_0= ruleAltList1 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:506:4: (lv_x22_21_0= ruleAltList1 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:506:4: (lv_x22_21_0= ruleAltList1 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:507:5: lv_x22_21_0= ruleAltList1
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX22AltList1ParserRuleCall_21_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x22_21_0=ruleAltList1();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x22",
                    						lv_x22_21_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.AltList1");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 23 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:525:3: ( (lv_x23_22_0= ruleAltList2 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:525:3: ( (lv_x23_22_0= ruleAltList2 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:526:4: (lv_x23_22_0= ruleAltList2 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:526:4: (lv_x23_22_0= ruleAltList2 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:527:5: lv_x23_22_0= ruleAltList2
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX23AltList2ParserRuleCall_22_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x23_22_0=ruleAltList2();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x23",
                    						lv_x23_22_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.AltList2");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 24 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:545:3: ( (lv_x24_23_0= ruleTransientObject ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:545:3: ( (lv_x24_23_0= ruleTransientObject ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:546:4: (lv_x24_23_0= ruleTransientObject )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:546:4: (lv_x24_23_0= ruleTransientObject )
                    // InternalConcreteSyntaxValidationTestLanguage.g:547:5: lv_x24_23_0= ruleTransientObject
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX24TransientObjectParserRuleCall_23_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x24_23_0=ruleTransientObject();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x24",
                    						lv_x24_23_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.TransientObject");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 25 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:565:3: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:565:3: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:566:4: (lv_x25_24_0= ruleTransientSerializeables1 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:566:4: (lv_x25_24_0= ruleTransientSerializeables1 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:567:5: lv_x25_24_0= ruleTransientSerializeables1
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX25TransientSerializeables1ParserRuleCall_24_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x25_24_0=ruleTransientSerializeables1();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x25",
                    						lv_x25_24_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.TransientSerializeables1");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 26 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:585:3: ( (lv_x26_25_0= ruleStaticSimplification ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:585:3: ( (lv_x26_25_0= ruleStaticSimplification ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:586:4: (lv_x26_25_0= ruleStaticSimplification )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:586:4: (lv_x26_25_0= ruleStaticSimplification )
                    // InternalConcreteSyntaxValidationTestLanguage.g:587:5: lv_x26_25_0= ruleStaticSimplification
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX26StaticSimplificationParserRuleCall_25_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x26_25_0=ruleStaticSimplification();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x26",
                    						lv_x26_25_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.StaticSimplification");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 27 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:605:3: ( (lv_x27_26_0= ruleTwoVersion ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:605:3: ( (lv_x27_26_0= ruleTwoVersion ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:606:4: (lv_x27_26_0= ruleTwoVersion )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:606:4: (lv_x27_26_0= ruleTwoVersion )
                    // InternalConcreteSyntaxValidationTestLanguage.g:607:5: lv_x27_26_0= ruleTwoVersion
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX27TwoVersionParserRuleCall_26_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x27_26_0=ruleTwoVersion();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x27",
                    						lv_x27_26_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.TwoVersion");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 28 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:625:3: ( (lv_x28_27_0= ruleHeuristic1 ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:625:3: ( (lv_x28_27_0= ruleHeuristic1 ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:626:4: (lv_x28_27_0= ruleHeuristic1 )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:626:4: (lv_x28_27_0= ruleHeuristic1 )
                    // InternalConcreteSyntaxValidationTestLanguage.g:627:5: lv_x28_27_0= ruleHeuristic1
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getX28Heuristic1ParserRuleCall_27_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_x28_27_0=ruleHeuristic1();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"x28",
                    						lv_x28_27_0,
                    						"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.Heuristic1");
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
    // InternalConcreteSyntaxValidationTestLanguage.g:648:1: entryRuleSimpleGroup returns [EObject current=null] : iv_ruleSimpleGroup= ruleSimpleGroup EOF ;
    public final EObject entryRuleSimpleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleGroup = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:648:52: (iv_ruleSimpleGroup= ruleSimpleGroup EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:649:2: iv_ruleSimpleGroup= ruleSimpleGroup EOF
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
    // InternalConcreteSyntaxValidationTestLanguage.g:655:1: ruleSimpleGroup returns [EObject current=null] : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:661:2: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:662:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:662:2: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:663:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSimpleGroupAccess().getNumberSignDigitOneKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:667:3: ( (lv_val1_1_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:668:4: (lv_val1_1_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:668:4: (lv_val1_1_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:669:5: lv_val1_1_0= RULE_ID
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

            // InternalConcreteSyntaxValidationTestLanguage.g:685:3: ( (lv_val2_2_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:686:4: (lv_val2_2_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:686:4: (lv_val2_2_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:687:5: lv_val2_2_0= RULE_ID
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
    // InternalConcreteSyntaxValidationTestLanguage.g:707:1: entryRuleSimpleAlternative returns [EObject current=null] : iv_ruleSimpleAlternative= ruleSimpleAlternative EOF ;
    public final EObject entryRuleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAlternative = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:707:58: (iv_ruleSimpleAlternative= ruleSimpleAlternative EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:708:2: iv_ruleSimpleAlternative= ruleSimpleAlternative EOF
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
    // InternalConcreteSyntaxValidationTestLanguage.g:714:1: ruleSimpleAlternative returns [EObject current=null] : (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val2_4_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:720:2: ( (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:721:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:721:2: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:722:3: otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getSimpleAlternativeAccess().getNumberSignDigitTwoKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:726:3: ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:727:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:727:4: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:728:5: otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_1, grammarAccess.getSimpleAlternativeAccess().getKw1Keyword_1_0_0());
                    				
                    // InternalConcreteSyntaxValidationTestLanguage.g:732:5: ( (lv_val1_2_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:733:6: (lv_val1_2_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:733:6: (lv_val1_2_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:734:7: lv_val1_2_0= RULE_ID
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:752:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:752:4: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:753:5: otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_3, grammarAccess.getSimpleAlternativeAccess().getKw2Keyword_1_1_0());
                    				
                    // InternalConcreteSyntaxValidationTestLanguage.g:757:5: ( (lv_val2_4_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:758:6: (lv_val2_4_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:758:6: (lv_val2_4_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:759:7: lv_val2_4_0= RULE_ID
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
    // InternalConcreteSyntaxValidationTestLanguage.g:781:1: entryRuleSimpleMultiplicities returns [EObject current=null] : iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF ;
    public final EObject entryRuleSimpleMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMultiplicities = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:781:61: (iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:782:2: iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF
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
    // InternalConcreteSyntaxValidationTestLanguage.g:788:1: ruleSimpleMultiplicities returns [EObject current=null] : (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
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
            // InternalConcreteSyntaxValidationTestLanguage.g:794:2: ( (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:795:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:795:2: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // InternalConcreteSyntaxValidationTestLanguage.g:796:3: otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSimpleMultiplicitiesAccess().getNumberSignDigitThreeKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:800:3: ( (lv_val1_1_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:801:4: (lv_val1_1_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:801:4: (lv_val1_1_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:802:5: lv_val1_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getSimpleMultiplicitiesAccess().getKw1Keyword_2());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:822:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:823:4: (lv_val2_3_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:823:4: (lv_val2_3_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:824:5: lv_val2_3_0= RULE_ID
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

            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getSimpleMultiplicitiesAccess().getKw2Keyword_4());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:844:3: ( (lv_val3_5_0= RULE_ID ) )+
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
            	    // InternalConcreteSyntaxValidationTestLanguage.g:845:4: (lv_val3_5_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:845:4: (lv_val3_5_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:846:5: lv_val3_5_0= RULE_ID
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

            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_6, grammarAccess.getSimpleMultiplicitiesAccess().getKw3Keyword_6());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:866:3: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalConcreteSyntaxValidationTestLanguage.g:867:4: (lv_val4_7_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:867:4: (lv_val4_7_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:868:5: lv_val4_7_0= RULE_ID
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
    // InternalConcreteSyntaxValidationTestLanguage.g:888:1: entryRuleGroupMultiplicities returns [EObject current=null] : iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF ;
    public final EObject entryRuleGroupMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupMultiplicities = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:888:60: (iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:889:2: iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF
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
    // InternalConcreteSyntaxValidationTestLanguage.g:895:1: ruleGroupMultiplicities returns [EObject current=null] : (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
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
            // InternalConcreteSyntaxValidationTestLanguage.g:901:2: ( (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:902:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:902:2: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // InternalConcreteSyntaxValidationTestLanguage.g:903:3: otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGroupMultiplicitiesAccess().getNumberSignDigitFourKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:907:3: ( (lv_val1_1_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:908:4: (lv_val1_1_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:908:4: (lv_val1_1_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:909:5: lv_val1_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getGroupMultiplicitiesAccess().getKw1Keyword_2());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:929:3: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:930:4: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:930:4: ( (lv_val2_3_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:931:5: (lv_val2_3_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:931:5: (lv_val2_3_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:932:6: lv_val2_3_0= RULE_ID
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

                    // InternalConcreteSyntaxValidationTestLanguage.g:948:4: ( (lv_val3_4_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:949:5: (lv_val3_4_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:949:5: (lv_val3_4_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:950:6: lv_val3_4_0= RULE_ID
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

            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getGroupMultiplicitiesAccess().getKw2Keyword_4());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:971:3: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
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
            	    // InternalConcreteSyntaxValidationTestLanguage.g:972:4: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:972:4: ( (lv_val4_6_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:973:5: (lv_val4_6_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:973:5: (lv_val4_6_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:974:6: lv_val4_6_0= RULE_ID
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

            	    // InternalConcreteSyntaxValidationTestLanguage.g:990:4: ( (lv_val5_7_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:991:5: (lv_val5_7_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:991:5: (lv_val5_7_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:992:6: lv_val5_7_0= RULE_ID
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

            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_8, grammarAccess.getGroupMultiplicitiesAccess().getKw3Keyword_6());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1013:3: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1014:4: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1014:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1015:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1015:5: (lv_val6_9_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1016:6: lv_val6_9_0= RULE_ID
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

            	    // InternalConcreteSyntaxValidationTestLanguage.g:1032:4: ( (lv_val7_10_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1033:5: (lv_val7_10_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1033:5: (lv_val7_10_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1034:6: lv_val7_10_0= RULE_ID
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
    // InternalConcreteSyntaxValidationTestLanguage.g:1055:1: entryRuleAlternativeMultiplicities returns [EObject current=null] : iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF ;
    public final EObject entryRuleAlternativeMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeMultiplicities = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1055:66: (iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1056:2: iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF
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
    // InternalConcreteSyntaxValidationTestLanguage.g:1062:1: ruleAlternativeMultiplicities returns [EObject current=null] : (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
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
            // InternalConcreteSyntaxValidationTestLanguage.g:1068:2: ( (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1069:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1069:2: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // InternalConcreteSyntaxValidationTestLanguage.g:1070:3: otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getAlternativeMultiplicitiesAccess().getNumberSignDigitFiveKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1074:3: ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:1075:4: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1075:4: ( (lv_val2_1_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1076:5: (lv_val2_1_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1076:5: (lv_val2_1_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1077:6: lv_val2_1_0= RULE_ID
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:1094:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1094:4: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1095:5: otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_2, grammarAccess.getAlternativeMultiplicitiesAccess().getKw1Keyword_1_1_0());
                    				
                    // InternalConcreteSyntaxValidationTestLanguage.g:1099:5: ( (lv_val3_3_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1100:6: (lv_val3_3_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1100:6: (lv_val3_3_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1101:7: lv_val3_3_0= RULE_ID
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

            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getAlternativeMultiplicitiesAccess().getKw2Keyword_2());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1123:3: ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
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
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1124:4: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1124:4: ( (lv_val4_5_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1125:5: (lv_val4_5_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1125:5: (lv_val4_5_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1126:6: lv_val4_5_0= RULE_ID
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
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1143:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1143:4: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1144:5: otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            	    					newLeafNode(otherlv_6, grammarAccess.getAlternativeMultiplicitiesAccess().getKw3Keyword_3_1_0());
            	    				
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1148:5: ( (lv_val5_7_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1149:6: (lv_val5_7_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1149:6: (lv_val5_7_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1150:7: lv_val5_7_0= RULE_ID
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

            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_12); 

            			newLeafNode(otherlv_8, grammarAccess.getAlternativeMultiplicitiesAccess().getKw4Keyword_4());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1172:3: ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
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
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1173:4: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1173:4: ( (lv_val6_9_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1174:5: (lv_val6_9_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1174:5: (lv_val6_9_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1175:6: lv_val6_9_0= RULE_ID
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
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1192:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1192:4: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1193:5: otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {
            	    otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            	    					newLeafNode(otherlv_10, grammarAccess.getAlternativeMultiplicitiesAccess().getKw5Keyword_5_1_0());
            	    				
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1197:5: ( (lv_val7_11_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1198:6: (lv_val7_11_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1198:6: (lv_val7_11_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1199:7: lv_val7_11_0= RULE_ID
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


    // $ANTLR start "entryRuleAssignedAction"
    // InternalConcreteSyntaxValidationTestLanguage.g:1221:1: entryRuleAssignedAction returns [EObject current=null] : iv_ruleAssignedAction= ruleAssignedAction EOF ;
    public final EObject entryRuleAssignedAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignedAction = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1221:55: (iv_ruleAssignedAction= ruleAssignedAction EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1222:2: iv_ruleAssignedAction= ruleAssignedAction EOF
            {
             newCompositeNode(grammarAccess.getAssignedActionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignedAction=ruleAssignedAction();

            state._fsp--;

             current =iv_ruleAssignedAction; 
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
    // $ANTLR end "entryRuleAssignedAction"


    // $ANTLR start "ruleAssignedAction"
    // InternalConcreteSyntaxValidationTestLanguage.g:1228:1: ruleAssignedAction returns [EObject current=null] : (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) ;
    public final EObject ruleAssignedAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1234:2: ( (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1235:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1235:2: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            // InternalConcreteSyntaxValidationTestLanguage.g:1236:3: otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAssignedActionAccess().getNumberSignDigitSixKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1240:3: ( (lv_val1_1_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1241:4: (lv_val1_1_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1241:4: (lv_val1_1_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:1242:5: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					newLeafNode(lv_val1_1_0, grammarAccess.getAssignedActionAccess().getVal1IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignedActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"val1",
            						lv_val1_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalConcreteSyntaxValidationTestLanguage.g:1258:3: ( () ( (lv_val1_3_0= RULE_ID ) ) )+
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
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1259:4: () ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1259:4: ()
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1260:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAssignedActionAccess().getAssignedActionChildAction_2_0(),
            	    						current);
            	    				

            	    }

            	    // InternalConcreteSyntaxValidationTestLanguage.g:1266:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1267:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1267:5: (lv_val1_3_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1268:6: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            	    						newLeafNode(lv_val1_3_0, grammarAccess.getAssignedActionAccess().getVal1IDTerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getAssignedActionRule());
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
    // $ANTLR end "ruleAssignedAction"


    // $ANTLR start "entryRuleAssignedActionSecond"
    // InternalConcreteSyntaxValidationTestLanguage.g:1289:1: entryRuleAssignedActionSecond returns [EObject current=null] : iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF ;
    public final EObject entryRuleAssignedActionSecond() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignedActionSecond = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1289:61: (iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1290:2: iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF
            {
             newCompositeNode(grammarAccess.getAssignedActionSecondRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignedActionSecond=ruleAssignedActionSecond();

            state._fsp--;

             current =iv_ruleAssignedActionSecond; 
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
    // $ANTLR end "entryRuleAssignedActionSecond"


    // $ANTLR start "ruleAssignedActionSecond"
    // InternalConcreteSyntaxValidationTestLanguage.g:1296:1: ruleAssignedActionSecond returns [EObject current=null] : (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) ;
    public final EObject ruleAssignedActionSecond() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1302:2: ( (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1303:2: (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1303:2: (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1304:3: otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAssignedActionSecondAccess().getNumberSignDigitSevenKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1308:3: ( (lv_val1_1_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1309:4: (lv_val1_1_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1309:4: (lv_val1_1_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:1310:5: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					newLeafNode(lv_val1_1_0, grammarAccess.getAssignedActionSecondAccess().getVal1IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignedActionSecondRule());
            					}
            					setWithLastConsumed(
            						current,
            						"val1",
            						lv_val1_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getAssignedActionSecondAccess().getKw1Keyword_2());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1330:3: ( (lv_val2_3_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1331:4: (lv_val2_3_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1331:4: (lv_val2_3_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:1332:5: lv_val2_3_0= RULE_ID
            {
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_val2_3_0, grammarAccess.getAssignedActionSecondAccess().getVal2IDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignedActionSecondRule());
            					}
            					setWithLastConsumed(
            						current,
            						"val2",
            						lv_val2_3_0,
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
    // $ANTLR end "ruleAssignedActionSecond"


    // $ANTLR start "entryRuleUnassignedAction1"
    // InternalConcreteSyntaxValidationTestLanguage.g:1352:1: entryRuleUnassignedAction1 returns [EObject current=null] : iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF ;
    public final EObject entryRuleUnassignedAction1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction1 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1352:58: (iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1353:2: iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF
            {
             newCompositeNode(grammarAccess.getUnassignedAction1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedAction1=ruleUnassignedAction1();

            state._fsp--;

             current =iv_ruleUnassignedAction1; 
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
    // $ANTLR end "entryRuleUnassignedAction1"


    // $ANTLR start "ruleUnassignedAction1"
    // InternalConcreteSyntaxValidationTestLanguage.g:1359:1: ruleUnassignedAction1 returns [EObject current=null] : ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1365:2: ( ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1366:2: ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1366:2: ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // InternalConcreteSyntaxValidationTestLanguage.g:1367:3: () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1367:3: ()
            // InternalConcreteSyntaxValidationTestLanguage.g:1368:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUnassignedAction1Access().getUnassignedAction1Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getUnassignedAction1Access().getNumberSignDigitEightKeyword_1());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1378:3: ( (lv_val1_2_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1379:4: (lv_val1_2_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1379:4: (lv_val1_2_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:1380:5: lv_val1_2_0= RULE_ID
            {
            lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					newLeafNode(lv_val1_2_0, grammarAccess.getUnassignedAction1Access().getVal1IDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnassignedAction1Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"val1",
            						lv_val1_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalConcreteSyntaxValidationTestLanguage.g:1396:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:1397:4: (lv_val2_3_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1397:4: (lv_val2_3_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1398:5: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_val2_3_0, grammarAccess.getUnassignedAction1Access().getVal2IDTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnassignedAction1Rule());
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
    // $ANTLR end "ruleUnassignedAction1"


    // $ANTLR start "entryRuleUnassignedAction2"
    // InternalConcreteSyntaxValidationTestLanguage.g:1418:1: entryRuleUnassignedAction2 returns [EObject current=null] : iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF ;
    public final EObject entryRuleUnassignedAction2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction2 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1418:58: (iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1419:2: iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF
            {
             newCompositeNode(grammarAccess.getUnassignedAction2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedAction2=ruleUnassignedAction2();

            state._fsp--;

             current =iv_ruleUnassignedAction2; 
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
    // $ANTLR end "entryRuleUnassignedAction2"


    // $ANTLR start "ruleUnassignedAction2"
    // InternalConcreteSyntaxValidationTestLanguage.g:1425:1: ruleUnassignedAction2 returns [EObject current=null] : ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1431:2: ( ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1432:2: ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1432:2: ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // InternalConcreteSyntaxValidationTestLanguage.g:1433:3: () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1433:3: ()
            // InternalConcreteSyntaxValidationTestLanguage.g:1434:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUnassignedAction2Access().getUnassignedAction2SubAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getUnassignedAction2Access().getNumberSignDigitNineKeyword_1());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1444:3: ( (lv_val1_2_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1445:4: (lv_val1_2_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1445:4: (lv_val1_2_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:1446:5: lv_val1_2_0= RULE_ID
            {
            lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					newLeafNode(lv_val1_2_0, grammarAccess.getUnassignedAction2Access().getVal1IDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnassignedAction2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"val1",
            						lv_val1_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalConcreteSyntaxValidationTestLanguage.g:1462:3: ( (lv_val2_3_0= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:1463:4: (lv_val2_3_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1463:4: (lv_val2_3_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1464:5: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_val2_3_0, grammarAccess.getUnassignedAction2Access().getVal2IDTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnassignedAction2Rule());
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
    // $ANTLR end "ruleUnassignedAction2"


    // $ANTLR start "entryRuleUnassignedAction3"
    // InternalConcreteSyntaxValidationTestLanguage.g:1484:1: entryRuleUnassignedAction3 returns [EObject current=null] : iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF ;
    public final EObject entryRuleUnassignedAction3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction3 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1484:58: (iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1485:2: iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF
            {
             newCompositeNode(grammarAccess.getUnassignedAction3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedAction3=ruleUnassignedAction3();

            state._fsp--;

             current =iv_ruleUnassignedAction3; 
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
    // $ANTLR end "entryRuleUnassignedAction3"


    // $ANTLR start "ruleUnassignedAction3"
    // InternalConcreteSyntaxValidationTestLanguage.g:1491:1: ruleUnassignedAction3 returns [EObject current=null] : (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_val1_5_0=null;
        Token lv_val2_6_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1497:2: ( (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1498:2: (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1498:2: (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            // InternalConcreteSyntaxValidationTestLanguage.g:1499:3: otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getUnassignedAction3Access().getNumberSignDigitOneDigitZeroKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1503:3: ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) )
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:1504:4: (otherlv_1= 'kw1' () )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1504:4: (otherlv_1= 'kw1' () )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1505:5: otherlv_1= 'kw1' ()
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_1, grammarAccess.getUnassignedAction3Access().getKw1Keyword_1_0_0());
                    				
                    // InternalConcreteSyntaxValidationTestLanguage.g:1509:5: ()
                    // InternalConcreteSyntaxValidationTestLanguage.g:1510:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getUnassignedAction3Access().getUnassignedAction2Sub1Action_1_0_1(),
                    							current);
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:1518:4: (otherlv_3= 'kw2' () )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1518:4: (otherlv_3= 'kw2' () )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1519:5: otherlv_3= 'kw2' ()
                    {
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_3, grammarAccess.getUnassignedAction3Access().getKw2Keyword_1_1_0());
                    				
                    // InternalConcreteSyntaxValidationTestLanguage.g:1523:5: ()
                    // InternalConcreteSyntaxValidationTestLanguage.g:1524:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getUnassignedAction3Access().getUnassignedAction2Sub2Action_1_1_1(),
                    							current);
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalConcreteSyntaxValidationTestLanguage.g:1532:3: ( (lv_val1_5_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1533:4: (lv_val1_5_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1533:4: (lv_val1_5_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:1534:5: lv_val1_5_0= RULE_ID
            {
            lv_val1_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					newLeafNode(lv_val1_5_0, grammarAccess.getUnassignedAction3Access().getVal1IDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnassignedAction3Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"val1",
            						lv_val1_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalConcreteSyntaxValidationTestLanguage.g:1550:3: ( (lv_val2_6_0= RULE_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:1551:4: (lv_val2_6_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1551:4: (lv_val2_6_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1552:5: lv_val2_6_0= RULE_ID
                    {
                    lv_val2_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_val2_6_0, grammarAccess.getUnassignedAction3Access().getVal2IDTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnassignedAction3Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"val2",
                    						lv_val2_6_0,
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
    // $ANTLR end "ruleUnassignedAction3"


    // $ANTLR start "entryRuleUnassignedRuleCall1"
    // InternalConcreteSyntaxValidationTestLanguage.g:1572:1: entryRuleUnassignedRuleCall1 returns [EObject current=null] : iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF ;
    public final EObject entryRuleUnassignedRuleCall1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall1 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1572:60: (iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1573:2: iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF
            {
             newCompositeNode(grammarAccess.getUnassignedRuleCall1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedRuleCall1=ruleUnassignedRuleCall1();

            state._fsp--;

             current =iv_ruleUnassignedRuleCall1; 
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
    // $ANTLR end "entryRuleUnassignedRuleCall1"


    // $ANTLR start "ruleUnassignedRuleCall1"
    // InternalConcreteSyntaxValidationTestLanguage.g:1579:1: ruleUnassignedRuleCall1 returns [EObject current=null] : (otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleUnassignedRuleCall1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val2_2_0=null;
        EObject this_UnassignedRuleCall1Sub_1 = null;



        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1585:2: ( (otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1586:2: (otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1586:2: (otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1587:3: otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getUnassignedRuleCall1Access().getNumberSignDigitOneDigitOneKeyword_0());
            		

            			newCompositeNode(grammarAccess.getUnassignedRuleCall1Access().getUnassignedRuleCall1SubParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_UnassignedRuleCall1Sub_1=ruleUnassignedRuleCall1Sub();

            state._fsp--;


            			current = this_UnassignedRuleCall1Sub_1;
            			afterParserOrEnumRuleCall();
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1599:3: ( (lv_val2_2_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1600:4: (lv_val2_2_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1600:4: (lv_val2_2_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:1601:5: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_val2_2_0, grammarAccess.getUnassignedRuleCall1Access().getVal2IDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnassignedRuleCall1Rule());
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
    // $ANTLR end "ruleUnassignedRuleCall1"


    // $ANTLR start "entryRuleUnassignedRuleCall1Sub"
    // InternalConcreteSyntaxValidationTestLanguage.g:1621:1: entryRuleUnassignedRuleCall1Sub returns [EObject current=null] : iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF ;
    public final EObject entryRuleUnassignedRuleCall1Sub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall1Sub = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1621:63: (iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1622:2: iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF
            {
             newCompositeNode(grammarAccess.getUnassignedRuleCall1SubRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedRuleCall1Sub=ruleUnassignedRuleCall1Sub();

            state._fsp--;

             current =iv_ruleUnassignedRuleCall1Sub; 
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
    // $ANTLR end "entryRuleUnassignedRuleCall1Sub"


    // $ANTLR start "ruleUnassignedRuleCall1Sub"
    // InternalConcreteSyntaxValidationTestLanguage.g:1628:1: ruleUnassignedRuleCall1Sub returns [EObject current=null] : ( (lv_val1_0_0= RULE_ID ) ) ;
    public final EObject ruleUnassignedRuleCall1Sub() throws RecognitionException {
        EObject current = null;

        Token lv_val1_0_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1634:2: ( ( (lv_val1_0_0= RULE_ID ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1635:2: ( (lv_val1_0_0= RULE_ID ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1635:2: ( (lv_val1_0_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1636:3: (lv_val1_0_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1636:3: (lv_val1_0_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:1637:4: lv_val1_0_0= RULE_ID
            {
            lv_val1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				newLeafNode(lv_val1_0_0, grammarAccess.getUnassignedRuleCall1SubAccess().getVal1IDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getUnassignedRuleCall1SubRule());
            				}
            				setWithLastConsumed(
            					current,
            					"val1",
            					lv_val1_0_0,
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
    // $ANTLR end "ruleUnassignedRuleCall1Sub"


    // $ANTLR start "entryRuleUnassignedRuleCall2"
    // InternalConcreteSyntaxValidationTestLanguage.g:1656:1: entryRuleUnassignedRuleCall2 returns [EObject current=null] : iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF ;
    public final EObject entryRuleUnassignedRuleCall2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall2 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1656:60: (iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1657:2: iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF
            {
             newCompositeNode(grammarAccess.getUnassignedRuleCall2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedRuleCall2=ruleUnassignedRuleCall2();

            state._fsp--;

             current =iv_ruleUnassignedRuleCall2; 
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
    // $ANTLR end "entryRuleUnassignedRuleCall2"


    // $ANTLR start "ruleUnassignedRuleCall2"
    // InternalConcreteSyntaxValidationTestLanguage.g:1663:1: ruleUnassignedRuleCall2 returns [EObject current=null] : (otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleUnassignedRuleCall2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val2_2_0=null;
        EObject this_UnassignedRuleCall2Sub_1 = null;



        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1669:2: ( (otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1670:2: (otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1670:2: (otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1671:3: otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getUnassignedRuleCall2Access().getNumberSignDigitOneDigitTwoKeyword_0());
            		

            			newCompositeNode(grammarAccess.getUnassignedRuleCall2Access().getUnassignedRuleCall2SubParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_UnassignedRuleCall2Sub_1=ruleUnassignedRuleCall2Sub();

            state._fsp--;


            			current = this_UnassignedRuleCall2Sub_1;
            			afterParserOrEnumRuleCall();
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1683:3: ( (lv_val2_2_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1684:4: (lv_val2_2_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1684:4: (lv_val2_2_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:1685:5: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_val2_2_0, grammarAccess.getUnassignedRuleCall2Access().getVal2IDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnassignedRuleCall2Rule());
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
    // $ANTLR end "ruleUnassignedRuleCall2"


    // $ANTLR start "entryRuleUnassignedRuleCall2Sub"
    // InternalConcreteSyntaxValidationTestLanguage.g:1705:1: entryRuleUnassignedRuleCall2Sub returns [EObject current=null] : iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF ;
    public final EObject entryRuleUnassignedRuleCall2Sub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall2Sub = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1705:63: (iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1706:2: iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF
            {
             newCompositeNode(grammarAccess.getUnassignedRuleCall2SubRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedRuleCall2Sub=ruleUnassignedRuleCall2Sub();

            state._fsp--;

             current =iv_ruleUnassignedRuleCall2Sub; 
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
    // $ANTLR end "entryRuleUnassignedRuleCall2Sub"


    // $ANTLR start "ruleUnassignedRuleCall2Sub"
    // InternalConcreteSyntaxValidationTestLanguage.g:1712:1: ruleUnassignedRuleCall2Sub returns [EObject current=null] : () ;
    public final EObject ruleUnassignedRuleCall2Sub() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1718:2: ( () )
            // InternalConcreteSyntaxValidationTestLanguage.g:1719:2: ()
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1719:2: ()
            // InternalConcreteSyntaxValidationTestLanguage.g:1720:3: 
            {

            			current = forceCreateModelElement(
            				grammarAccess.getUnassignedRuleCall2SubAccess().getUnassignedRuleCall2SubActionAction(),
            				current);
            		

            }


            }


            	leaveRule();

        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnassignedRuleCall2Sub"


    // $ANTLR start "entryRuleCombination1"
    // InternalConcreteSyntaxValidationTestLanguage.g:1729:1: entryRuleCombination1 returns [EObject current=null] : iv_ruleCombination1= ruleCombination1 EOF ;
    public final EObject entryRuleCombination1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination1 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1729:53: (iv_ruleCombination1= ruleCombination1 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1730:2: iv_ruleCombination1= ruleCombination1 EOF
            {
             newCompositeNode(grammarAccess.getCombination1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCombination1=ruleCombination1();

            state._fsp--;

             current =iv_ruleCombination1; 
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
    // $ANTLR end "entryRuleCombination1"


    // $ANTLR start "ruleCombination1"
    // InternalConcreteSyntaxValidationTestLanguage.g:1736:1: ruleCombination1 returns [EObject current=null] : (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) ;
    public final EObject ruleCombination1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token lv_val3_5_0=null;
        Token lv_val4_6_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1742:2: ( (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1743:2: (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1743:2: (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            // InternalConcreteSyntaxValidationTestLanguage.g:1744:3: otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCombination1Access().getNumberSignDigitOneDigitThreeKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1748:3: ( (lv_val1_1_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1749:4: (lv_val1_1_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1749:4: (lv_val1_1_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:1750:5: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            					newLeafNode(lv_val1_1_0, grammarAccess.getCombination1Access().getVal1IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCombination1Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"val1",
            						lv_val1_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalConcreteSyntaxValidationTestLanguage.g:1766:3: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:1767:4: otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getCombination1Access().getKw1Keyword_2_0());
                    			
                    // InternalConcreteSyntaxValidationTestLanguage.g:1771:4: ( (lv_val2_3_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1772:5: (lv_val2_3_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1772:5: (lv_val2_3_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1773:6: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    						newLeafNode(lv_val2_3_0, grammarAccess.getCombination1Access().getVal2IDTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCombination1Rule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"val2",
                    							lv_val2_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalConcreteSyntaxValidationTestLanguage.g:1789:4: ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
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
                            // InternalConcreteSyntaxValidationTestLanguage.g:1790:5: (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            {
                            // InternalConcreteSyntaxValidationTestLanguage.g:1790:5: (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            // InternalConcreteSyntaxValidationTestLanguage.g:1791:6: otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )
                            {
                            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                            						newLeafNode(otherlv_4, grammarAccess.getCombination1Access().getKw2Keyword_2_2_0_0());
                            					
                            // InternalConcreteSyntaxValidationTestLanguage.g:1795:6: ( (lv_val3_5_0= RULE_ID ) )
                            // InternalConcreteSyntaxValidationTestLanguage.g:1796:7: (lv_val3_5_0= RULE_ID )
                            {
                            // InternalConcreteSyntaxValidationTestLanguage.g:1796:7: (lv_val3_5_0= RULE_ID )
                            // InternalConcreteSyntaxValidationTestLanguage.g:1797:8: lv_val3_5_0= RULE_ID
                            {
                            lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            								newLeafNode(lv_val3_5_0, grammarAccess.getCombination1Access().getVal3IDTerminalRuleCall_2_2_0_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getCombination1Rule());
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
                        case 2 :
                            // InternalConcreteSyntaxValidationTestLanguage.g:1815:5: ( (lv_val4_6_0= RULE_ID ) )
                            {
                            // InternalConcreteSyntaxValidationTestLanguage.g:1815:5: ( (lv_val4_6_0= RULE_ID ) )
                            // InternalConcreteSyntaxValidationTestLanguage.g:1816:6: (lv_val4_6_0= RULE_ID )
                            {
                            // InternalConcreteSyntaxValidationTestLanguage.g:1816:6: (lv_val4_6_0= RULE_ID )
                            // InternalConcreteSyntaxValidationTestLanguage.g:1817:7: lv_val4_6_0= RULE_ID
                            {
                            lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            							newLeafNode(lv_val4_6_0, grammarAccess.getCombination1Access().getVal4IDTerminalRuleCall_2_2_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getCombination1Rule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"val4",
                            								lv_val4_6_0,
                            								"org.eclipse.xtext.common.Terminals.ID");
                            						

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
    // $ANTLR end "ruleCombination1"


    // $ANTLR start "entryRuleCombination2"
    // InternalConcreteSyntaxValidationTestLanguage.g:1839:1: entryRuleCombination2 returns [EObject current=null] : iv_ruleCombination2= ruleCombination2 EOF ;
    public final EObject entryRuleCombination2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination2 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1839:53: (iv_ruleCombination2= ruleCombination2 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1840:2: iv_ruleCombination2= ruleCombination2 EOF
            {
             newCompositeNode(grammarAccess.getCombination2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCombination2=ruleCombination2();

            state._fsp--;

             current =iv_ruleCombination2; 
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
    // $ANTLR end "entryRuleCombination2"


    // $ANTLR start "ruleCombination2"
    // InternalConcreteSyntaxValidationTestLanguage.g:1846:1: ruleCombination2 returns [EObject current=null] : (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) ;
    public final EObject ruleCombination2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;
        Token lv_val4_5_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1852:2: ( (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1853:2: (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1853:2: (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1854:3: otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCombination2Access().getNumberSignDigitOneDigitFourKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1858:3: ( (lv_val1_1_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1859:4: (lv_val1_1_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1859:4: (lv_val1_1_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:1860:5: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            					newLeafNode(lv_val1_1_0, grammarAccess.getCombination2Access().getVal1IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCombination2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"val1",
            						lv_val1_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalConcreteSyntaxValidationTestLanguage.g:1876:3: ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:1877:4: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1877:4: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1878:5: otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_2, grammarAccess.getCombination2Access().getKw1Keyword_2_0_0());
                    				
                    // InternalConcreteSyntaxValidationTestLanguage.g:1882:5: ( (lv_val2_3_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1883:6: (lv_val2_3_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1883:6: (lv_val2_3_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:1884:7: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							newLeafNode(lv_val2_3_0, grammarAccess.getCombination2Access().getVal2IDTerminalRuleCall_2_0_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getCombination2Rule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"val2",
                    								lv_val2_3_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:1902:4: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:1902:4: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:1903:5: ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) )
                    	    {
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:1903:5: ( (lv_val3_4_0= RULE_ID ) )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:1904:6: (lv_val3_4_0= RULE_ID )
                    	    {
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:1904:6: (lv_val3_4_0= RULE_ID )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:1905:7: lv_val3_4_0= RULE_ID
                    	    {
                    	    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    	    							newLeafNode(lv_val3_4_0, grammarAccess.getCombination2Access().getVal3IDTerminalRuleCall_2_1_0_0());
                    	    						

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getCombination2Rule());
                    	    							}
                    	    							addWithLastConsumed(
                    	    								current,
                    	    								"val3",
                    	    								lv_val3_4_0,
                    	    								"org.eclipse.xtext.common.Terminals.ID");
                    	    						

                    	    }


                    	    }

                    	    // InternalConcreteSyntaxValidationTestLanguage.g:1921:5: ( (lv_val4_5_0= RULE_ID ) )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:1922:6: (lv_val4_5_0= RULE_ID )
                    	    {
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:1922:6: (lv_val4_5_0= RULE_ID )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:1923:7: lv_val4_5_0= RULE_ID
                    	    {
                    	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    	    							newLeafNode(lv_val4_5_0, grammarAccess.getCombination2Access().getVal4IDTerminalRuleCall_2_1_1_0());
                    	    						

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getCombination2Rule());
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

                    	default :
                    	    break loop19;
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
    // $ANTLR end "ruleCombination2"


    // $ANTLR start "entryRuleCombination3"
    // InternalConcreteSyntaxValidationTestLanguage.g:1945:1: entryRuleCombination3 returns [EObject current=null] : iv_ruleCombination3= ruleCombination3 EOF ;
    public final EObject entryRuleCombination3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination3 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1945:53: (iv_ruleCombination3= ruleCombination3 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:1946:2: iv_ruleCombination3= ruleCombination3 EOF
            {
             newCompositeNode(grammarAccess.getCombination3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCombination3=ruleCombination3();

            state._fsp--;

             current =iv_ruleCombination3; 
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
    // $ANTLR end "entryRuleCombination3"


    // $ANTLR start "ruleCombination3"
    // InternalConcreteSyntaxValidationTestLanguage.g:1952:1: ruleCombination3 returns [EObject current=null] : (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) ;
    public final EObject ruleCombination3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token lv_val3_3_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:1958:2: ( (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:1959:2: (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:1959:2: (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            // InternalConcreteSyntaxValidationTestLanguage.g:1960:3: otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getCombination3Access().getNumberSignDigitOneDigitFiveKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:1964:3: ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
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
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1965:4: ( (lv_val1_1_0= RULE_ID ) )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1965:4: ( (lv_val1_1_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1966:5: (lv_val1_1_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1966:5: (lv_val1_1_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1967:6: lv_val1_1_0= RULE_ID
            	    {
            	    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

            	    						newLeafNode(lv_val1_1_0, grammarAccess.getCombination3Access().getVal1IDTerminalRuleCall_1_0_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getCombination3Rule());
            	    						}
            	    						setWithLastConsumed(
            	    							current,
            	    							"val1",
            	    							lv_val1_1_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1984:4: ( (lv_val2_2_0= RULE_INT ) )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1984:4: ( (lv_val2_2_0= RULE_INT ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1985:5: (lv_val2_2_0= RULE_INT )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1985:5: (lv_val2_2_0= RULE_INT )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:1986:6: lv_val2_2_0= RULE_INT
            	    {
            	    lv_val2_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_15); 

            	    						newLeafNode(lv_val2_2_0, grammarAccess.getCombination3Access().getVal2INTTerminalRuleCall_1_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getCombination3Rule());
            	    						}
            	    						setWithLastConsumed(
            	    							current,
            	    							"val2",
            	    							lv_val2_2_0,
            	    							"org.eclipse.xtext.common.Terminals.INT");
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2003:4: ( (lv_val3_3_0= RULE_STRING ) )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2003:4: ( (lv_val3_3_0= RULE_STRING ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2004:5: (lv_val3_3_0= RULE_STRING )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2004:5: (lv_val3_3_0= RULE_STRING )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2005:6: lv_val3_3_0= RULE_STRING
            	    {
            	    lv_val3_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_15); 

            	    						newLeafNode(lv_val3_3_0, grammarAccess.getCombination3Access().getVal3STRINGTerminalRuleCall_1_2_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getCombination3Rule());
            	    						}
            	    						setWithLastConsumed(
            	    							current,
            	    							"val3",
            	    							lv_val3_3_0,
            	    							"org.eclipse.xtext.common.Terminals.STRING");
            	    					

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
    // $ANTLR end "ruleCombination3"


    // $ANTLR start "entryRuleCombination4"
    // InternalConcreteSyntaxValidationTestLanguage.g:2026:1: entryRuleCombination4 returns [EObject current=null] : iv_ruleCombination4= ruleCombination4 EOF ;
    public final EObject entryRuleCombination4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination4 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2026:53: (iv_ruleCombination4= ruleCombination4 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:2027:2: iv_ruleCombination4= ruleCombination4 EOF
            {
             newCompositeNode(grammarAccess.getCombination4Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCombination4=ruleCombination4();

            state._fsp--;

             current =iv_ruleCombination4; 
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
    // $ANTLR end "entryRuleCombination4"


    // $ANTLR start "ruleCombination4"
    // InternalConcreteSyntaxValidationTestLanguage.g:2033:1: ruleCombination4 returns [EObject current=null] : (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) ;
    public final EObject ruleCombination4() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2039:2: ( (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2040:2: (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2040:2: (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            // InternalConcreteSyntaxValidationTestLanguage.g:2041:3: otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getCombination4Access().getNumberSignDigitOneDigitSixKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:2045:3: (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
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
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2046:4: otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_3); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCombination4Access().getGroupKeyword_1_0());
            	    			
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2050:4: ( (lv_val1_2_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2051:5: (lv_val1_2_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2051:5: (lv_val1_2_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2052:6: lv_val1_2_0= RULE_ID
            	    {
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						newLeafNode(lv_val1_2_0, grammarAccess.getCombination4Access().getVal1IDTerminalRuleCall_1_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getCombination4Rule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"val1",
            	    							lv_val1_2_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }

            	    // InternalConcreteSyntaxValidationTestLanguage.g:2068:4: ( (lv_val2_3_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2069:5: (lv_val2_3_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2069:5: (lv_val2_3_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2070:6: lv_val2_3_0= RULE_ID
            	    {
            	    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						newLeafNode(lv_val2_3_0, grammarAccess.getCombination4Access().getVal2IDTerminalRuleCall_1_2_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getCombination4Rule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"val2",
            	    							lv_val2_3_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }

            	    // InternalConcreteSyntaxValidationTestLanguage.g:2086:4: ( (lv_val3_4_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2087:5: (lv_val3_4_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2087:5: (lv_val3_4_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2088:6: lv_val3_4_0= RULE_ID
            	    {
            	    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); 

            	    						newLeafNode(lv_val3_4_0, grammarAccess.getCombination4Access().getVal3IDTerminalRuleCall_1_3_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getCombination4Rule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"val3",
            	    							lv_val3_4_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

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
    // $ANTLR end "ruleCombination4"


    // $ANTLR start "entryRuleList1"
    // InternalConcreteSyntaxValidationTestLanguage.g:2109:1: entryRuleList1 returns [EObject current=null] : iv_ruleList1= ruleList1 EOF ;
    public final EObject entryRuleList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList1 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2109:46: (iv_ruleList1= ruleList1 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:2110:2: iv_ruleList1= ruleList1 EOF
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
    // InternalConcreteSyntaxValidationTestLanguage.g:2116:1: ruleList1 returns [EObject current=null] : (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleList1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2122:2: ( (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2123:2: (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2123:2: (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // InternalConcreteSyntaxValidationTestLanguage.g:2124:3: otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getList1Access().getNumberSignDigitOneDigitSevenKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:2128:3: ( (lv_val1_1_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2129:4: (lv_val1_1_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2129:4: (lv_val1_1_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:2130:5: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

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

            // InternalConcreteSyntaxValidationTestLanguage.g:2146:3: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==34) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2147:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

            	    				newLeafNode(otherlv_2, grammarAccess.getList1Access().getCommaKeyword_2_0());
            	    			
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2151:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2152:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2152:5: (lv_val1_3_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2153:6: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

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
            	    break loop23;
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
    // InternalConcreteSyntaxValidationTestLanguage.g:2174:1: entryRuleList2 returns [EObject current=null] : iv_ruleList2= ruleList2 EOF ;
    public final EObject entryRuleList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList2 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2174:46: (iv_ruleList2= ruleList2 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:2175:2: iv_ruleList2= ruleList2 EOF
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
    // InternalConcreteSyntaxValidationTestLanguage.g:2181:1: ruleList2 returns [EObject current=null] : (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) ;
    public final EObject ruleList2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2187:2: ( (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2188:2: (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2188:2: (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            // InternalConcreteSyntaxValidationTestLanguage.g:2189:3: otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getList2Access().getNumberSignDigitOneDigitEightKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:2193:3: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:2194:4: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2194:4: ( (lv_val1_1_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2195:5: (lv_val1_1_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2195:5: (lv_val1_1_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2196:6: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

                    						newLeafNode(lv_val1_1_0, grammarAccess.getList2Access().getVal1IDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getList2Rule());
                    						}
                    						addWithLastConsumed(
                    							current,
                    							"val1",
                    							lv_val1_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalConcreteSyntaxValidationTestLanguage.g:2212:4: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==34) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2213:5: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getList2Access().getCommaKeyword_1_1_0());
                    	    				
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2217:5: ( (lv_val1_3_0= RULE_ID ) )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2218:6: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2218:6: (lv_val1_3_0= RULE_ID )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2219:7: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

                    	    							newLeafNode(lv_val1_3_0, grammarAccess.getList2Access().getVal1IDTerminalRuleCall_1_1_1_0());
                    	    						

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getList2Rule());
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
                    	    break loop24;
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


    // $ANTLR start "entryRuleList3"
    // InternalConcreteSyntaxValidationTestLanguage.g:2241:1: entryRuleList3 returns [EObject current=null] : iv_ruleList3= ruleList3 EOF ;
    public final EObject entryRuleList3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList3 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2241:46: (iv_ruleList3= ruleList3 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:2242:2: iv_ruleList3= ruleList3 EOF
            {
             newCompositeNode(grammarAccess.getList3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleList3=ruleList3();

            state._fsp--;

             current =iv_ruleList3; 
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
    // $ANTLR end "entryRuleList3"


    // $ANTLR start "ruleList3"
    // InternalConcreteSyntaxValidationTestLanguage.g:2248:1: ruleList3 returns [EObject current=null] : ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) ;
    public final EObject ruleList3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2254:2: ( ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2255:2: ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2255:2: ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:2256:3: (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2256:3: (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2257:4: otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    {
                    otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getList3Access().getNumberSignDigitOneDigitNineKeyword_0_0());
                    			
                    // InternalConcreteSyntaxValidationTestLanguage.g:2261:4: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2262:5: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2262:5: ( (lv_val1_1_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2263:6: (lv_val1_1_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2263:6: (lv_val1_1_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2264:7: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

                    							newLeafNode(lv_val1_1_0, grammarAccess.getList3Access().getVal1IDTerminalRuleCall_0_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getList3Rule());
                    							}
                    							addWithLastConsumed(
                    								current,
                    								"val1",
                    								lv_val1_1_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }

                    // InternalConcreteSyntaxValidationTestLanguage.g:2280:5: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==34) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2281:6: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    	    						newLeafNode(otherlv_2, grammarAccess.getList3Access().getCommaKeyword_0_1_1_0());
                    	    					
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2285:6: ( (lv_val1_3_0= RULE_ID ) )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2286:7: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2286:7: (lv_val1_3_0= RULE_ID )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2287:8: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); 

                    	    								newLeafNode(lv_val1_3_0, grammarAccess.getList3Access().getVal1IDTerminalRuleCall_0_1_1_1_0());
                    	    							

                    	    								if (current==null) {
                    	    									current = createModelElement(grammarAccess.getList3Rule());
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
                    	    break loop26;
                        }
                    } while (true);


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:2307:3: (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2307:3: (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2308:4: otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getList3Access().getKw3Keyword_1_0());
                    			
                    // InternalConcreteSyntaxValidationTestLanguage.g:2312:4: ( (lv_val2_5_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2313:5: (lv_val2_5_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2313:5: (lv_val2_5_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2314:6: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_val2_5_0, grammarAccess.getList3Access().getVal2IDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getList3Rule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"val2",
                    							lv_val2_5_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


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
    // $ANTLR end "ruleList3"


    // $ANTLR start "entryRuleList4"
    // InternalConcreteSyntaxValidationTestLanguage.g:2335:1: entryRuleList4 returns [EObject current=null] : iv_ruleList4= ruleList4 EOF ;
    public final EObject entryRuleList4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList4 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2335:46: (iv_ruleList4= ruleList4 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:2336:2: iv_ruleList4= ruleList4 EOF
            {
             newCompositeNode(grammarAccess.getList4Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleList4=ruleList4();

            state._fsp--;

             current =iv_ruleList4; 
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
    // $ANTLR end "entryRuleList4"


    // $ANTLR start "ruleList4"
    // InternalConcreteSyntaxValidationTestLanguage.g:2342:1: ruleList4 returns [EObject current=null] : (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ;
    public final EObject ruleList4() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2348:2: ( (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2349:2: (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2349:2: (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2350:3: otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getList4Access().getNumberSignDigitTwoDigitZeroKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:2354:3: ( (lv_val1_1_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2355:4: (lv_val1_1_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2355:4: (lv_val1_1_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:2356:5: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

            					newLeafNode(lv_val1_1_0, grammarAccess.getList4Access().getVal1IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getList4Rule());
            					}
            					addWithLastConsumed(
            						current,
            						"val1",
            						lv_val1_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalConcreteSyntaxValidationTestLanguage.g:2372:3: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==34) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2373:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

            	    				newLeafNode(otherlv_2, grammarAccess.getList4Access().getCommaKeyword_2_0());
            	    			
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2377:4: ( (lv_val1_3_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2378:5: (lv_val1_3_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2378:5: (lv_val1_3_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:2379:6: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

            	    						newLeafNode(lv_val1_3_0, grammarAccess.getList4Access().getVal1IDTerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getList4Rule());
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
            	    break loop28;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getList4Access().getKw3Keyword_3());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:2400:3: ( (lv_val2_5_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2401:4: (lv_val2_5_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2401:4: (lv_val2_5_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:2402:5: lv_val2_5_0= RULE_ID
            {
            lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_val2_5_0, grammarAccess.getList4Access().getVal2IDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getList4Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"val2",
            						lv_val2_5_0,
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
    // $ANTLR end "ruleList4"


    // $ANTLR start "entryRuleList5"
    // InternalConcreteSyntaxValidationTestLanguage.g:2422:1: entryRuleList5 returns [EObject current=null] : iv_ruleList5= ruleList5 EOF ;
    public final EObject entryRuleList5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList5 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2422:46: (iv_ruleList5= ruleList5 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:2423:2: iv_ruleList5= ruleList5 EOF
            {
             newCompositeNode(grammarAccess.getList5Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleList5=ruleList5();

            state._fsp--;

             current =iv_ruleList5; 
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
    // $ANTLR end "entryRuleList5"


    // $ANTLR start "ruleList5"
    // InternalConcreteSyntaxValidationTestLanguage.g:2429:1: ruleList5 returns [EObject current=null] : (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) ;
    public final EObject ruleList5() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;
        Token lv_val3_6_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2435:2: ( (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2436:2: (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2436:2: (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2437:3: otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getList5Access().getNumberSignDigitTwoDigitOneKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:2441:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:2442:4: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2442:4: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2443:5: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2443:5: ( (lv_val1_1_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2444:6: (lv_val1_1_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2444:6: (lv_val1_1_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2445:7: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

                    							newLeafNode(lv_val1_1_0, grammarAccess.getList5Access().getVal1IDTerminalRuleCall_1_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getList5Rule());
                    							}
                    							addWithLastConsumed(
                    								current,
                    								"val1",
                    								lv_val1_1_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }

                    // InternalConcreteSyntaxValidationTestLanguage.g:2461:5: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==34) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2462:6: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    	    						newLeafNode(otherlv_2, grammarAccess.getList5Access().getCommaKeyword_1_0_1_0());
                    	    					
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2466:6: ( (lv_val1_3_0= RULE_ID ) )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2467:7: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2467:7: (lv_val1_3_0= RULE_ID )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2468:8: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

                    	    								newLeafNode(lv_val1_3_0, grammarAccess.getList5Access().getVal1IDTerminalRuleCall_1_0_1_1_0());
                    	    							

                    	    								if (current==null) {
                    	    									current = createModelElement(grammarAccess.getList5Rule());
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
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_4, grammarAccess.getList5Access().getKw3Keyword_1_0_2());
                    				
                    // InternalConcreteSyntaxValidationTestLanguage.g:2489:5: ( (lv_val2_5_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2490:6: (lv_val2_5_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2490:6: (lv_val2_5_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2491:7: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							newLeafNode(lv_val2_5_0, grammarAccess.getList5Access().getVal2IDTerminalRuleCall_1_0_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getList5Rule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"val2",
                    								lv_val2_5_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:2509:4: ( (lv_val3_6_0= RULE_ID ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2509:4: ( (lv_val3_6_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2510:5: (lv_val3_6_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2510:5: (lv_val3_6_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2511:6: lv_val3_6_0= RULE_ID
                    {
                    lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_val3_6_0, grammarAccess.getList5Access().getVal3IDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getList5Rule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"val3",
                    							lv_val3_6_0,
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
    // $ANTLR end "ruleList5"


    // $ANTLR start "entryRuleAltList1"
    // InternalConcreteSyntaxValidationTestLanguage.g:2532:1: entryRuleAltList1 returns [EObject current=null] : iv_ruleAltList1= ruleAltList1 EOF ;
    public final EObject entryRuleAltList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltList1 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2532:49: (iv_ruleAltList1= ruleAltList1 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:2533:2: iv_ruleAltList1= ruleAltList1 EOF
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
    // InternalConcreteSyntaxValidationTestLanguage.g:2539:1: ruleAltList1 returns [EObject current=null] : (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) ;
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
            // InternalConcreteSyntaxValidationTestLanguage.g:2545:2: ( (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2546:2: (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2546:2: (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2547:3: otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getAltList1Access().getNumberSignDigitTwoDigitTwoKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:2551:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:2552:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2552:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2553:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2553:5: ( (lv_val1_1_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2554:6: (lv_val1_1_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2554:6: (lv_val1_1_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2555:7: lv_val1_1_0= RULE_ID
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

                    // InternalConcreteSyntaxValidationTestLanguage.g:2571:5: ( (lv_val2_2_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2572:6: (lv_val2_2_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2572:6: (lv_val2_2_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2573:7: lv_val2_2_0= RULE_ID
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:2591:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2591:4: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2592:5: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_3, grammarAccess.getAltList1Access().getKw1Keyword_1_1_0());
                    				
                    // InternalConcreteSyntaxValidationTestLanguage.g:2596:5: ( (lv_val1_4_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2597:6: (lv_val1_4_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2597:6: (lv_val1_4_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2598:7: lv_val1_4_0= RULE_ID
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

                    // InternalConcreteSyntaxValidationTestLanguage.g:2614:5: ( (lv_val3_5_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2615:6: (lv_val3_5_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2615:6: (lv_val3_5_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2616:7: lv_val3_5_0= RULE_ID
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:2634:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2634:4: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2635:5: otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )?
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_6, grammarAccess.getAltList1Access().getKw2Keyword_1_2_0());
                    				
                    // InternalConcreteSyntaxValidationTestLanguage.g:2639:5: ( (lv_val1_7_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2640:6: (lv_val1_7_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2640:6: (lv_val1_7_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2641:7: lv_val1_7_0= RULE_ID
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

                    // InternalConcreteSyntaxValidationTestLanguage.g:2657:5: ( (lv_val4_8_0= RULE_ID ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==RULE_ID) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalConcreteSyntaxValidationTestLanguage.g:2658:6: (lv_val4_8_0= RULE_ID )
                            {
                            // InternalConcreteSyntaxValidationTestLanguage.g:2658:6: (lv_val4_8_0= RULE_ID )
                            // InternalConcreteSyntaxValidationTestLanguage.g:2659:7: lv_val4_8_0= RULE_ID
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
    // InternalConcreteSyntaxValidationTestLanguage.g:2681:1: entryRuleAltList2 returns [EObject current=null] : iv_ruleAltList2= ruleAltList2 EOF ;
    public final EObject entryRuleAltList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltList2 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2681:49: (iv_ruleAltList2= ruleAltList2 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:2682:2: iv_ruleAltList2= ruleAltList2 EOF
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
    // InternalConcreteSyntaxValidationTestLanguage.g:2688:1: ruleAltList2 returns [EObject current=null] : (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) ;
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
            // InternalConcreteSyntaxValidationTestLanguage.g:2694:2: ( (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2695:2: (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2695:2: (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2696:3: otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getAltList2Access().getNumberSignDigitTwoDigitThreeKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:2700:3: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:2701:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2701:4: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2702:5: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2702:5: ( (lv_val1_1_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2703:6: (lv_val1_1_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2703:6: (lv_val1_1_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2704:7: lv_val1_1_0= RULE_ID
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

                    // InternalConcreteSyntaxValidationTestLanguage.g:2720:5: ( (lv_val2_2_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2721:6: (lv_val2_2_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2721:6: (lv_val2_2_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2722:7: lv_val2_2_0= RULE_ID
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:2740:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2740:4: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2741:5: otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,41,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_3, grammarAccess.getAltList2Access().getKwKeyword_1_1_0());
                    				
                    // InternalConcreteSyntaxValidationTestLanguage.g:2745:5: ( (lv_val1_4_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2746:6: (lv_val1_4_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2746:6: (lv_val1_4_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2747:7: lv_val1_4_0= RULE_ID
                    {
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

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

                    // InternalConcreteSyntaxValidationTestLanguage.g:2763:5: (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==34) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2764:6: otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) )
                    	    {
                    	    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_3); 

                    	    						newLeafNode(otherlv_5, grammarAccess.getAltList2Access().getCommaKeyword_1_1_2_0());
                    	    					
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2768:6: ( (lv_val1_6_0= RULE_ID ) )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2769:7: (lv_val1_6_0= RULE_ID )
                    	    {
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2769:7: (lv_val1_6_0= RULE_ID )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:2770:8: lv_val1_6_0= RULE_ID
                    	    {
                    	    lv_val1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

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
                    	    break loop33;
                        }
                    } while (true);

                    // InternalConcreteSyntaxValidationTestLanguage.g:2787:5: ( (lv_val3_7_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2788:6: (lv_val3_7_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2788:6: (lv_val3_7_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2789:7: lv_val3_7_0= RULE_ID
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


    // $ANTLR start "entryRuleTransientObject"
    // InternalConcreteSyntaxValidationTestLanguage.g:2811:1: entryRuleTransientObject returns [EObject current=null] : iv_ruleTransientObject= ruleTransientObject EOF ;
    public final EObject entryRuleTransientObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransientObject = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2811:56: (iv_ruleTransientObject= ruleTransientObject EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:2812:2: iv_ruleTransientObject= ruleTransientObject EOF
            {
             newCompositeNode(grammarAccess.getTransientObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransientObject=ruleTransientObject();

            state._fsp--;

             current =iv_ruleTransientObject; 
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
    // $ANTLR end "entryRuleTransientObject"


    // $ANTLR start "ruleTransientObject"
    // InternalConcreteSyntaxValidationTestLanguage.g:2818:1: ruleTransientObject returns [EObject current=null] : (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) ;
    public final EObject ruleTransientObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        EObject lv_nested_2_0 = null;



        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2824:2: ( (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2825:2: (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2825:2: (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            // InternalConcreteSyntaxValidationTestLanguage.g:2826:3: otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getTransientObjectAccess().getNumberSignDigitTwoDigitFourKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:2830:3: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:2831:4: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2831:4: ( (lv_val1_1_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2832:5: (lv_val1_1_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2832:5: (lv_val1_1_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2833:6: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    						newLeafNode(lv_val1_1_0, grammarAccess.getTransientObjectAccess().getVal1IDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTransientObjectRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"val1",
                    							lv_val1_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalConcreteSyntaxValidationTestLanguage.g:2849:4: ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2850:5: (lv_nested_2_0= ruleTransientObjectSub )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2850:5: (lv_nested_2_0= ruleTransientObjectSub )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2851:6: lv_nested_2_0= ruleTransientObjectSub
                    {

                    						newCompositeNode(grammarAccess.getTransientObjectAccess().getNestedTransientObjectSubParserRuleCall_1_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_nested_2_0=ruleTransientObjectSub();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransientObjectRule());
                    						}
                    						set(
                    							current,
                    							"nested",
                    							lv_nested_2_0,
                    							"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.TransientObjectSub");
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
    // $ANTLR end "ruleTransientObject"


    // $ANTLR start "entryRuleTransientObjectSub"
    // InternalConcreteSyntaxValidationTestLanguage.g:2873:1: entryRuleTransientObjectSub returns [EObject current=null] : iv_ruleTransientObjectSub= ruleTransientObjectSub EOF ;
    public final EObject entryRuleTransientObjectSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransientObjectSub = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2873:59: (iv_ruleTransientObjectSub= ruleTransientObjectSub EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:2874:2: iv_ruleTransientObjectSub= ruleTransientObjectSub EOF
            {
             newCompositeNode(grammarAccess.getTransientObjectSubRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransientObjectSub=ruleTransientObjectSub();

            state._fsp--;

             current =iv_ruleTransientObjectSub; 
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
    // $ANTLR end "entryRuleTransientObjectSub"


    // $ANTLR start "ruleTransientObjectSub"
    // InternalConcreteSyntaxValidationTestLanguage.g:2880:1: ruleTransientObjectSub returns [EObject current=null] : ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) ;
    public final EObject ruleTransientObjectSub() throws RecognitionException {
        EObject current = null;

        Token lv_val2_0_0=null;
        Token lv_val3_1_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2886:2: ( ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2887:2: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2887:2: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2888:3: ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2888:3: ( (lv_val2_0_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2889:4: (lv_val2_0_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2889:4: (lv_val2_0_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:2890:5: lv_val2_0_0= RULE_ID
            {
            lv_val2_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					newLeafNode(lv_val2_0_0, grammarAccess.getTransientObjectSubAccess().getVal2IDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransientObjectSubRule());
            					}
            					setWithLastConsumed(
            						current,
            						"val2",
            						lv_val2_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalConcreteSyntaxValidationTestLanguage.g:2906:3: ( (lv_val3_1_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2907:4: (lv_val3_1_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2907:4: (lv_val3_1_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:2908:5: lv_val3_1_0= RULE_ID
            {
            lv_val3_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_val3_1_0, grammarAccess.getTransientObjectSubAccess().getVal3IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransientObjectSubRule());
            					}
            					setWithLastConsumed(
            						current,
            						"val3",
            						lv_val3_1_0,
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
    // $ANTLR end "ruleTransientObjectSub"


    // $ANTLR start "entryRuleTransientSerializeables1"
    // InternalConcreteSyntaxValidationTestLanguage.g:2928:1: entryRuleTransientSerializeables1 returns [EObject current=null] : iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF ;
    public final EObject entryRuleTransientSerializeables1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransientSerializeables1 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2928:65: (iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:2929:2: iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF
            {
             newCompositeNode(grammarAccess.getTransientSerializeables1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransientSerializeables1=ruleTransientSerializeables1();

            state._fsp--;

             current =iv_ruleTransientSerializeables1; 
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
    // $ANTLR end "entryRuleTransientSerializeables1"


    // $ANTLR start "ruleTransientSerializeables1"
    // InternalConcreteSyntaxValidationTestLanguage.g:2935:1: ruleTransientSerializeables1 returns [EObject current=null] : (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) ;
    public final EObject ruleTransientSerializeables1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_int1_4_0=null;
        Enumerator lv_enum1_2_0 = null;



        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:2941:2: ( (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:2942:2: (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:2942:2: (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            // InternalConcreteSyntaxValidationTestLanguage.g:2943:3: otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            {
            otherlv_0=(Token)match(input,43,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getTransientSerializeables1Access().getNumberSignDigitTwoDigitFiveKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:2947:3: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )?
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:2948:4: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2948:4: ( (lv_val1_1_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2949:5: (lv_val1_1_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2949:5: (lv_val1_1_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2950:6: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

                    						newLeafNode(lv_val1_1_0, grammarAccess.getTransientSerializeables1Access().getVal1IDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTransientSerializeables1Rule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"val1",
                    							lv_val1_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalConcreteSyntaxValidationTestLanguage.g:2966:4: ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2967:5: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2967:5: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2968:6: lv_enum1_2_0= ruleTransientSerializeables1Enum
                    {

                    						newCompositeNode(grammarAccess.getTransientSerializeables1Access().getEnum1TransientSerializeables1EnumEnumRuleCall_1_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_enum1_2_0=ruleTransientSerializeables1Enum();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransientSerializeables1Rule());
                    						}
                    						set(
                    							current,
                    							"enum1",
                    							lv_enum1_2_0,
                    							"org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage.TransientSerializeables1Enum");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalConcreteSyntaxValidationTestLanguage.g:2986:3: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:2987:4: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2987:4: ( (lv_val2_3_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2988:5: (lv_val2_3_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:2988:5: (lv_val2_3_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:2989:6: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_23); 

                    						newLeafNode(lv_val2_3_0, grammarAccess.getTransientSerializeables1Access().getVal2IDTerminalRuleCall_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTransientSerializeables1Rule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"val2",
                    							lv_val2_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalConcreteSyntaxValidationTestLanguage.g:3005:4: ( (lv_int1_4_0= RULE_INT ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3006:5: (lv_int1_4_0= RULE_INT )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3006:5: (lv_int1_4_0= RULE_INT )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3007:6: lv_int1_4_0= RULE_INT
                    {
                    lv_int1_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_int1_4_0, grammarAccess.getTransientSerializeables1Access().getInt1INTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTransientSerializeables1Rule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"int1",
                    							lv_int1_4_0,
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
    // $ANTLR end "ruleTransientSerializeables1"


    // $ANTLR start "entryRuleStaticSimplification"
    // InternalConcreteSyntaxValidationTestLanguage.g:3028:1: entryRuleStaticSimplification returns [EObject current=null] : iv_ruleStaticSimplification= ruleStaticSimplification EOF ;
    public final EObject entryRuleStaticSimplification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStaticSimplification = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:3028:61: (iv_ruleStaticSimplification= ruleStaticSimplification EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:3029:2: iv_ruleStaticSimplification= ruleStaticSimplification EOF
            {
             newCompositeNode(grammarAccess.getStaticSimplificationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStaticSimplification=ruleStaticSimplification();

            state._fsp--;

             current =iv_ruleStaticSimplification; 
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
    // $ANTLR end "entryRuleStaticSimplification"


    // $ANTLR start "ruleStaticSimplification"
    // InternalConcreteSyntaxValidationTestLanguage.g:3035:1: ruleStaticSimplification returns [EObject current=null] : (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) ) ;
    public final EObject ruleStaticSimplification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_val3_8_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:3041:2: ( (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:3042:2: (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3042:2: (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:3043:3: otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? )
            {
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getStaticSimplificationAccess().getNumberSignDigitTwoDigitSixKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:3047:3: (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) )
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

                if ( (LA38_3==16) ) {
                    alt38=2;
                }
                else if ( (LA38_3==RULE_ID||LA38_3==14) ) {
                    alt38=3;
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:3048:4: otherlv_1= 'kw1'
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getStaticSimplificationAccess().getKw1Keyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:3053:4: ()
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3053:4: ()
                    // InternalConcreteSyntaxValidationTestLanguage.g:3054:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStaticSimplificationAccess().getEmptyAlternativeSubAction_1_1(),
                    						current);
                    				

                    }


                    }
                    break;
                case 3 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:3061:4: ( (lv_val1_3_0= RULE_ID ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3061:4: ( (lv_val1_3_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3062:5: (lv_val1_3_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3062:5: (lv_val1_3_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3063:6: lv_val1_3_0= RULE_ID
                    {
                    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    						newLeafNode(lv_val1_3_0, grammarAccess.getStaticSimplificationAccess().getVal1IDTerminalRuleCall_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStaticSimplificationRule());
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

            // InternalConcreteSyntaxValidationTestLanguage.g:3080:3: (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) )
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:3081:4: otherlv_4= 'kw2'
                    {
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_24); 

                    				newLeafNode(otherlv_4, grammarAccess.getStaticSimplificationAccess().getKw2Keyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:3086:4: ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3086:4: ( (lv_val2_5_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3087:5: (lv_val2_5_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3087:5: (lv_val2_5_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3088:6: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_24); 

                    						newLeafNode(lv_val2_5_0, grammarAccess.getStaticSimplificationAccess().getVal2IDTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStaticSimplificationRule());
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

            // InternalConcreteSyntaxValidationTestLanguage.g:3105:3: (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? )
            // InternalConcreteSyntaxValidationTestLanguage.g:3106:4: otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )?
            {
            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_25); 

            				newLeafNode(otherlv_6, grammarAccess.getStaticSimplificationAccess().getKw3Keyword_3_0());
            			
            // InternalConcreteSyntaxValidationTestLanguage.g:3110:4: (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==19) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:3111:5: otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+
                    {
                    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_7, grammarAccess.getStaticSimplificationAccess().getKw4Keyword_3_1_0());
                    				
                    // InternalConcreteSyntaxValidationTestLanguage.g:3115:5: ( (lv_val3_8_0= RULE_ID ) )+
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
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3116:6: (lv_val3_8_0= RULE_ID )
                    	    {
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3116:6: (lv_val3_8_0= RULE_ID )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3117:7: lv_val3_8_0= RULE_ID
                    	    {
                    	    lv_val3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    	    							newLeafNode(lv_val3_8_0, grammarAccess.getStaticSimplificationAccess().getVal3IDTerminalRuleCall_3_1_1_0());
                    	    						

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getStaticSimplificationRule());
                    	    							}
                    	    							setWithLastConsumed(
                    	    								current,
                    	    								"val3",
                    	    								lv_val3_8_0,
                    	    								"org.eclipse.xtext.common.Terminals.ID");
                    	    						

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
    // $ANTLR end "ruleStaticSimplification"


    // $ANTLR start "entryRuleTwoVersion"
    // InternalConcreteSyntaxValidationTestLanguage.g:3139:1: entryRuleTwoVersion returns [EObject current=null] : iv_ruleTwoVersion= ruleTwoVersion EOF ;
    public final EObject entryRuleTwoVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoVersion = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:3139:51: (iv_ruleTwoVersion= ruleTwoVersion EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:3140:2: iv_ruleTwoVersion= ruleTwoVersion EOF
            {
             newCompositeNode(grammarAccess.getTwoVersionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTwoVersion=ruleTwoVersion();

            state._fsp--;

             current =iv_ruleTwoVersion; 
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
    // $ANTLR end "entryRuleTwoVersion"


    // $ANTLR start "ruleTwoVersion"
    // InternalConcreteSyntaxValidationTestLanguage.g:3146:1: ruleTwoVersion returns [EObject current=null] : (otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) ) ;
    public final EObject ruleTwoVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TwoVersionNo1_1 = null;

        EObject this_TwoVersionNo2_2 = null;



        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:3152:2: ( (otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:3153:2: (otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3153:2: (otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:3154:3: otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 )
            {
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTwoVersionAccess().getNumberSignDigitTwoDigitSevenKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:3158:3: (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    int LA42_2 = input.LA(3);

                    if ( (LA42_2==48) ) {
                        alt42=2;
                    }
                    else if ( (LA42_2==46) ) {
                        alt42=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case 48:
                    {
                    alt42=2;
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:3159:4: this_TwoVersionNo1_1= ruleTwoVersionNo1
                    {

                    				newCompositeNode(grammarAccess.getTwoVersionAccess().getTwoVersionNo1ParserRuleCall_1_0());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TwoVersionNo1_1=ruleTwoVersionNo1();

                    state._fsp--;


                    				current = this_TwoVersionNo1_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:3168:4: this_TwoVersionNo2_2= ruleTwoVersionNo2
                    {

                    				newCompositeNode(grammarAccess.getTwoVersionAccess().getTwoVersionNo2ParserRuleCall_1_1());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TwoVersionNo2_2=ruleTwoVersionNo2();

                    state._fsp--;


                    				current = this_TwoVersionNo2_2;
                    				afterParserOrEnumRuleCall();
                    			

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
    // $ANTLR end "ruleTwoVersion"


    // $ANTLR start "entryRuleTwoVersionNo1"
    // InternalConcreteSyntaxValidationTestLanguage.g:3181:1: entryRuleTwoVersionNo1 returns [EObject current=null] : iv_ruleTwoVersionNo1= ruleTwoVersionNo1 EOF ;
    public final EObject entryRuleTwoVersionNo1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoVersionNo1 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:3181:54: (iv_ruleTwoVersionNo1= ruleTwoVersionNo1 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:3182:2: iv_ruleTwoVersionNo1= ruleTwoVersionNo1 EOF
            {
             newCompositeNode(grammarAccess.getTwoVersionNo1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTwoVersionNo1=ruleTwoVersionNo1();

            state._fsp--;

             current =iv_ruleTwoVersionNo1; 
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
    // $ANTLR end "entryRuleTwoVersionNo1"


    // $ANTLR start "ruleTwoVersionNo1"
    // InternalConcreteSyntaxValidationTestLanguage.g:3188:1: ruleTwoVersionNo1 returns [EObject current=null] : ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? ) ;
    public final EObject ruleTwoVersionNo1() throws RecognitionException {
        EObject current = null;

        Token lv_shared1_0_0=null;
        Token lv_shared2_1_0=null;
        Token otherlv_2=null;
        Token lv_shared3_3_0=null;
        Token lv_shared3_4_0=null;
        Token otherlv_5=null;
        Token lv_version1_6_0=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:3194:2: ( ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:3195:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3195:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? )
            // InternalConcreteSyntaxValidationTestLanguage.g:3196:3: ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )?
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3196:3: ( (lv_shared1_0_0= RULE_ID ) )?
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:3197:4: (lv_shared1_0_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3197:4: (lv_shared1_0_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3198:5: lv_shared1_0_0= RULE_ID
                    {
                    lv_shared1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    					newLeafNode(lv_shared1_0_0, grammarAccess.getTwoVersionNo1Access().getShared1IDTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTwoVersionNo1Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"shared1",
                    						lv_shared1_0_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            // InternalConcreteSyntaxValidationTestLanguage.g:3214:3: ( (lv_shared2_1_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:3215:4: (lv_shared2_1_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3215:4: (lv_shared2_1_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:3216:5: lv_shared2_1_0= RULE_ID
            {
            lv_shared2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            					newLeafNode(lv_shared2_1_0, grammarAccess.getTwoVersionNo1Access().getShared2IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTwoVersionNo1Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"shared2",
            						lv_shared2_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,46,FollowSets000.FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getTwoVersionNo1Access().getShortKeyword_2());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:3236:3: ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:3237:4: ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )*
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3237:4: ( (lv_shared3_3_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3238:5: (lv_shared3_3_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3238:5: (lv_shared3_3_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3239:6: lv_shared3_3_0= RULE_ID
                    {
                    lv_shared3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_27); 

                    						newLeafNode(lv_shared3_3_0, grammarAccess.getTwoVersionNo1Access().getShared3IDTerminalRuleCall_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTwoVersionNo1Rule());
                    						}
                    						addWithLastConsumed(
                    							current,
                    							"shared3",
                    							lv_shared3_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalConcreteSyntaxValidationTestLanguage.g:3255:4: ( (lv_shared3_4_0= RULE_ID ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==RULE_ID) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3256:5: (lv_shared3_4_0= RULE_ID )
                    	    {
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3256:5: (lv_shared3_4_0= RULE_ID )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3257:6: lv_shared3_4_0= RULE_ID
                    	    {
                    	    lv_shared3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_27); 

                    	    						newLeafNode(lv_shared3_4_0, grammarAccess.getTwoVersionNo1Access().getShared3IDTerminalRuleCall_3_1_0());
                    	    					

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getTwoVersionNo1Rule());
                    	    						}
                    	    						addWithLastConsumed(
                    	    							current,
                    	    							"shared3",
                    	    							lv_shared3_4_0,
                    	    							"org.eclipse.xtext.common.Terminals.ID");
                    	    					

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

            otherlv_5=(Token)match(input,47,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_5, grammarAccess.getTwoVersionNo1Access().getOneKeyword_4());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:3278:3: ( (lv_version1_6_0= RULE_ID ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:3279:4: (lv_version1_6_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3279:4: (lv_version1_6_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3280:5: lv_version1_6_0= RULE_ID
                    {
                    lv_version1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_version1_6_0, grammarAccess.getTwoVersionNo1Access().getVersion1IDTerminalRuleCall_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTwoVersionNo1Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"version1",
                    						lv_version1_6_0,
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
    // $ANTLR end "ruleTwoVersionNo1"


    // $ANTLR start "entryRuleTwoVersionNo2"
    // InternalConcreteSyntaxValidationTestLanguage.g:3300:1: entryRuleTwoVersionNo2 returns [EObject current=null] : iv_ruleTwoVersionNo2= ruleTwoVersionNo2 EOF ;
    public final EObject entryRuleTwoVersionNo2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoVersionNo2 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:3300:54: (iv_ruleTwoVersionNo2= ruleTwoVersionNo2 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:3301:2: iv_ruleTwoVersionNo2= ruleTwoVersionNo2 EOF
            {
             newCompositeNode(grammarAccess.getTwoVersionNo2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTwoVersionNo2=ruleTwoVersionNo2();

            state._fsp--;

             current =iv_ruleTwoVersionNo2; 
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
    // $ANTLR end "entryRuleTwoVersionNo2"


    // $ANTLR start "ruleTwoVersionNo2"
    // InternalConcreteSyntaxValidationTestLanguage.g:3307:1: ruleTwoVersionNo2 returns [EObject current=null] : ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? ) ;
    public final EObject ruleTwoVersionNo2() throws RecognitionException {
        EObject current = null;

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


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:3313:2: ( ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:3314:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3314:2: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? )
            // InternalConcreteSyntaxValidationTestLanguage.g:3315:3: ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )?
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3315:3: ( (lv_shared1_0_0= RULE_ID ) )?
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:3316:4: (lv_shared1_0_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3316:4: (lv_shared1_0_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3317:5: lv_shared1_0_0= RULE_ID
                    {
                    lv_shared1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    					newLeafNode(lv_shared1_0_0, grammarAccess.getTwoVersionNo2Access().getShared1IDTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTwoVersionNo2Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"shared1",
                    						lv_shared1_0_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            // InternalConcreteSyntaxValidationTestLanguage.g:3333:3: ( (lv_shared2_1_0= RULE_ID ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:3334:4: (lv_shared2_1_0= RULE_ID )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3334:4: (lv_shared2_1_0= RULE_ID )
            // InternalConcreteSyntaxValidationTestLanguage.g:3335:5: lv_shared2_1_0= RULE_ID
            {
            lv_shared2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_28); 

            					newLeafNode(lv_shared2_1_0, grammarAccess.getTwoVersionNo2Access().getShared2IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTwoVersionNo2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"shared2",
            						lv_shared2_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,48,FollowSets000.FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getTwoVersionNo2Access().getLongKeyword_2());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:3355:3: ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:3356:4: ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )*
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3356:4: ( (lv_shared3_3_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3357:5: (lv_shared3_3_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3357:5: (lv_shared3_3_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3358:6: lv_shared3_3_0= RULE_ID
                    {
                    lv_shared3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

                    						newLeafNode(lv_shared3_3_0, grammarAccess.getTwoVersionNo2Access().getShared3IDTerminalRuleCall_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTwoVersionNo2Rule());
                    						}
                    						addWithLastConsumed(
                    							current,
                    							"shared3",
                    							lv_shared3_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalConcreteSyntaxValidationTestLanguage.g:3374:4: ( (lv_shared3_4_0= RULE_ID ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==RULE_ID) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3375:5: (lv_shared3_4_0= RULE_ID )
                    	    {
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3375:5: (lv_shared3_4_0= RULE_ID )
                    	    // InternalConcreteSyntaxValidationTestLanguage.g:3376:6: lv_shared3_4_0= RULE_ID
                    	    {
                    	    lv_shared3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

                    	    						newLeafNode(lv_shared3_4_0, grammarAccess.getTwoVersionNo2Access().getShared3IDTerminalRuleCall_3_1_0());
                    	    					

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getTwoVersionNo2Rule());
                    	    						}
                    	    						addWithLastConsumed(
                    	    							current,
                    	    							"shared3",
                    	    							lv_shared3_4_0,
                    	    							"org.eclipse.xtext.common.Terminals.ID");
                    	    					

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

            otherlv_5=(Token)match(input,49,FollowSets000.FOLLOW_30); 

            			newLeafNode(otherlv_5, grammarAccess.getTwoVersionNo2Access().getExtraKeyword_4());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:3397:3: ( (lv_extra1_6_0= RULE_ID ) )?
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:3398:4: (lv_extra1_6_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3398:4: (lv_extra1_6_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3399:5: lv_extra1_6_0= RULE_ID
                    {
                    lv_extra1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_30); 

                    					newLeafNode(lv_extra1_6_0, grammarAccess.getTwoVersionNo2Access().getExtra1IDTerminalRuleCall_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTwoVersionNo2Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"extra1",
                    						lv_extra1_6_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            // InternalConcreteSyntaxValidationTestLanguage.g:3415:3: ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )?
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:3416:4: ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3416:4: ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3417:5: ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3417:5: ( (lv_extra2_7_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3418:6: (lv_extra2_7_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3418:6: (lv_extra2_7_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3419:7: lv_extra2_7_0= RULE_ID
                    {
                    lv_extra2_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    							newLeafNode(lv_extra2_7_0, grammarAccess.getTwoVersionNo2Access().getExtra2IDTerminalRuleCall_6_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTwoVersionNo2Rule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"extra2",
                    								lv_extra2_7_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }

                    // InternalConcreteSyntaxValidationTestLanguage.g:3435:5: ( (lv_extra3_8_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3436:6: (lv_extra3_8_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3436:6: (lv_extra3_8_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3437:7: lv_extra3_8_0= RULE_ID
                    {
                    lv_extra3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							newLeafNode(lv_extra3_8_0, grammarAccess.getTwoVersionNo2Access().getExtra3IDTerminalRuleCall_6_0_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTwoVersionNo2Rule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"extra3",
                    								lv_extra3_8_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:3455:4: (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3455:4: (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3456:5: otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) )
                    {
                    otherlv_9=(Token)match(input,50,FollowSets000.FOLLOW_3); 

                    					newLeafNode(otherlv_9, grammarAccess.getTwoVersionNo2Access().getTwoKeyword_6_1_0());
                    				
                    // InternalConcreteSyntaxValidationTestLanguage.g:3460:5: ( (lv_extra4_10_0= RULE_ID ) )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3461:6: (lv_extra4_10_0= RULE_ID )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3461:6: (lv_extra4_10_0= RULE_ID )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3462:7: lv_extra4_10_0= RULE_ID
                    {
                    lv_extra4_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							newLeafNode(lv_extra4_10_0, grammarAccess.getTwoVersionNo2Access().getExtra4IDTerminalRuleCall_6_1_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTwoVersionNo2Rule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"extra4",
                    								lv_extra4_10_0,
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
    // $ANTLR end "ruleTwoVersionNo2"


    // $ANTLR start "entryRuleHeuristic1"
    // InternalConcreteSyntaxValidationTestLanguage.g:3484:1: entryRuleHeuristic1 returns [EObject current=null] : iv_ruleHeuristic1= ruleHeuristic1 EOF ;
    public final EObject entryRuleHeuristic1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeuristic1 = null;


        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:3484:51: (iv_ruleHeuristic1= ruleHeuristic1 EOF )
            // InternalConcreteSyntaxValidationTestLanguage.g:3485:2: iv_ruleHeuristic1= ruleHeuristic1 EOF
            {
             newCompositeNode(grammarAccess.getHeuristic1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleHeuristic1=ruleHeuristic1();

            state._fsp--;

             current =iv_ruleHeuristic1; 
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
    // $ANTLR end "entryRuleHeuristic1"


    // $ANTLR start "ruleHeuristic1"
    // InternalConcreteSyntaxValidationTestLanguage.g:3491:1: ruleHeuristic1 returns [EObject current=null] : (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* ) ;
    public final EObject ruleHeuristic1() throws RecognitionException {
        EObject current = null;

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


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:3497:2: ( (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:3498:2: (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3498:2: (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* )
            // InternalConcreteSyntaxValidationTestLanguage.g:3499:3: otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_31); 

            			newLeafNode(otherlv_0, grammarAccess.getHeuristic1Access().getNumberSignDigitTwoDigitEightKeyword_0());
            		
            // InternalConcreteSyntaxValidationTestLanguage.g:3503:3: (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==13) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3504:4: otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

            	    				newLeafNode(otherlv_1, grammarAccess.getHeuristic1Access().getKw1Keyword_1_0());
            	    			
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3508:4: ( (lv_a_2_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3509:5: (lv_a_2_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3509:5: (lv_a_2_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3510:6: lv_a_2_0= RULE_ID
            	    {
            	    lv_a_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						newLeafNode(lv_a_2_0, grammarAccess.getHeuristic1Access().getAIDTerminalRuleCall_1_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getHeuristic1Rule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"a",
            	    							lv_a_2_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }

            	    // InternalConcreteSyntaxValidationTestLanguage.g:3526:4: ( (lv_b_3_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3527:5: (lv_b_3_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3527:5: (lv_b_3_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3528:6: lv_b_3_0= RULE_ID
            	    {
            	    lv_b_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_31); 

            	    						newLeafNode(lv_b_3_0, grammarAccess.getHeuristic1Access().getBIDTerminalRuleCall_1_2_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getHeuristic1Rule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"b",
            	    							lv_b_3_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            // InternalConcreteSyntaxValidationTestLanguage.g:3545:3: (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==14) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3546:4: otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            	    				newLeafNode(otherlv_4, grammarAccess.getHeuristic1Access().getKw2Keyword_2_0());
            	    			
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3550:4: ( (lv_a_5_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3551:5: (lv_a_5_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3551:5: (lv_a_5_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3552:6: lv_a_5_0= RULE_ID
            	    {
            	    lv_a_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						newLeafNode(lv_a_5_0, grammarAccess.getHeuristic1Access().getAIDTerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getHeuristic1Rule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"a",
            	    							lv_a_5_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }

            	    // InternalConcreteSyntaxValidationTestLanguage.g:3568:4: ( (lv_c_6_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3569:5: (lv_c_6_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3569:5: (lv_c_6_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3570:6: lv_c_6_0= RULE_ID
            	    {
            	    lv_c_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); 

            	    						newLeafNode(lv_c_6_0, grammarAccess.getHeuristic1Access().getCIDTerminalRuleCall_2_2_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getHeuristic1Rule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"c",
            	    							lv_c_6_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // InternalConcreteSyntaxValidationTestLanguage.g:3587:3: (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==16) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3588:4: otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) )
            	    {
            	    otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_3); 

            	    				newLeafNode(otherlv_7, grammarAccess.getHeuristic1Access().getKw3Keyword_3_0());
            	    			
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3592:4: ( (lv_b_8_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3593:5: (lv_b_8_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3593:5: (lv_b_8_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3594:6: lv_b_8_0= RULE_ID
            	    {
            	    lv_b_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    						newLeafNode(lv_b_8_0, grammarAccess.getHeuristic1Access().getBIDTerminalRuleCall_3_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getHeuristic1Rule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"b",
            	    							lv_b_8_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }

            	    // InternalConcreteSyntaxValidationTestLanguage.g:3610:4: ( (lv_c_9_0= RULE_ID ) )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3611:5: (lv_c_9_0= RULE_ID )
            	    {
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3611:5: (lv_c_9_0= RULE_ID )
            	    // InternalConcreteSyntaxValidationTestLanguage.g:3612:6: lv_c_9_0= RULE_ID
            	    {
            	    lv_c_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_33); 

            	    						newLeafNode(lv_c_9_0, grammarAccess.getHeuristic1Access().getCIDTerminalRuleCall_3_2_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getHeuristic1Rule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"c",
            	    							lv_c_9_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

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
    // $ANTLR end "ruleHeuristic1"


    // $ANTLR start "ruleTransientSerializeables1Enum"
    // InternalConcreteSyntaxValidationTestLanguage.g:3633:1: ruleTransientSerializeables1Enum returns [Enumerator current=null] : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) ;
    public final Enumerator ruleTransientSerializeables1Enum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalConcreteSyntaxValidationTestLanguage.g:3639:2: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) )
            // InternalConcreteSyntaxValidationTestLanguage.g:3640:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            {
            // InternalConcreteSyntaxValidationTestLanguage.g:3640:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
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
                    // InternalConcreteSyntaxValidationTestLanguage.g:3641:3: (enumLiteral_0= 'lit1' )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3641:3: (enumLiteral_0= 'lit1' )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3642:4: enumLiteral_0= 'lit1'
                    {
                    enumLiteral_0=(Token)match(input,52,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getTransientSerializeables1EnumAccess().getLit1EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTransientSerializeables1EnumAccess().getLit1EnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalConcreteSyntaxValidationTestLanguage.g:3649:3: (enumLiteral_1= 'lit2' )
                    {
                    // InternalConcreteSyntaxValidationTestLanguage.g:3649:3: (enumLiteral_1= 'lit2' )
                    // InternalConcreteSyntaxValidationTestLanguage.g:3650:4: enumLiteral_1= 'lit2'
                    {
                    enumLiteral_1=(Token)match(input,53,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getTransientSerializeables1EnumAccess().getLit2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTransientSerializeables1EnumAccess().getLit2EnumLiteralDeclaration_1());
                    			

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