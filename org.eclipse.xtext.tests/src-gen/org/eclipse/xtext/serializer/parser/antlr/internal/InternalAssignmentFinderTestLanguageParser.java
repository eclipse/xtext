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
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAssignmentFinderTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_TERMINAL1", "RULE_TERMINAL2", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#00'", "'#01'", "'#02'", "'#03'", "'#04'", "'#05'", "'#06'", "'#07'", "'#08'", "'#09'", "'kw1'", "'kw2'", "'%foo'", "'true'", "'false'", "'lit3'", "'lit1'", "'lit2'"
    };
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int RULE_TERMINAL1=4;
    public static final int RULE_TERMINAL2=5;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int RULE_ID=6;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalAssignmentFinderTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAssignmentFinderTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAssignmentFinderTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalAssignmentFinderTestLanguage.g"; }



     	private AssignmentFinderTestLanguageGrammarAccess grammarAccess;

        public InternalAssignmentFinderTestLanguageParser(TokenStream input, AssignmentFinderTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected AssignmentFinderTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalAssignmentFinderTestLanguage.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalAssignmentFinderTestLanguage.g:66:2: iv_ruleModel= ruleModel EOF
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
    // InternalAssignmentFinderTestLanguage.g:72:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) ) | (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) ) | (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_keywordVal_1_0 = null;

        EObject lv_terminalVal_3_0 = null;

        EObject lv_enumVal_5_0 = null;

        EObject lv_keywordBool_7_0 = null;

        EObject lv_terminalBool_9_0 = null;

        EObject lv_enumBool_11_0 = null;

        EObject lv_mixedBool_13_0 = null;

        EObject lv_mixedValue_15_0 = null;

        EObject lv_containmentRef_17_0 = null;

        EObject lv_crossRef_19_0 = null;



        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:78:2: ( ( (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) ) | (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) ) | (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:79:2: ( (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) ) | (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) ) | (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:79:2: ( (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) ) | (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) ) | (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) ) | (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) ) | (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) ) | (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) ) | (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) ) | (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) ) | (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) ) | (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) ) )
            int alt1=10;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt1=1;
                }
                break;
            case 14:
                {
                alt1=2;
                }
                break;
            case 15:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            case 18:
                {
                alt1=6;
                }
                break;
            case 19:
                {
                alt1=7;
                }
                break;
            case 20:
                {
                alt1=8;
                }
                break;
            case 21:
                {
                alt1=9;
                }
                break;
            case 22:
                {
                alt1=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:80:3: (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:80:3: (otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) ) )
                    // InternalAssignmentFinderTestLanguage.g:81:4: otherlv_0= '#00' ( (lv_keywordVal_1_0= ruleKeywordVal ) )
                    {
                    otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getModelAccess().getNumberSignDigitZeroDigitZeroKeyword_0_0());
                    			
                    // InternalAssignmentFinderTestLanguage.g:85:4: ( (lv_keywordVal_1_0= ruleKeywordVal ) )
                    // InternalAssignmentFinderTestLanguage.g:86:5: (lv_keywordVal_1_0= ruleKeywordVal )
                    {
                    // InternalAssignmentFinderTestLanguage.g:86:5: (lv_keywordVal_1_0= ruleKeywordVal )
                    // InternalAssignmentFinderTestLanguage.g:87:6: lv_keywordVal_1_0= ruleKeywordVal
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getKeywordValKeywordValParserRuleCall_0_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_keywordVal_1_0=ruleKeywordVal();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"keywordVal",
                    							lv_keywordVal_1_0,
                    							"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.KeywordVal");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:106:3: (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:106:3: (otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) ) )
                    // InternalAssignmentFinderTestLanguage.g:107:4: otherlv_2= '#01' ( (lv_terminalVal_3_0= ruleTerminalVal ) )
                    {
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getNumberSignDigitZeroDigitOneKeyword_1_0());
                    			
                    // InternalAssignmentFinderTestLanguage.g:111:4: ( (lv_terminalVal_3_0= ruleTerminalVal ) )
                    // InternalAssignmentFinderTestLanguage.g:112:5: (lv_terminalVal_3_0= ruleTerminalVal )
                    {
                    // InternalAssignmentFinderTestLanguage.g:112:5: (lv_terminalVal_3_0= ruleTerminalVal )
                    // InternalAssignmentFinderTestLanguage.g:113:6: lv_terminalVal_3_0= ruleTerminalVal
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getTerminalValTerminalValParserRuleCall_1_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_terminalVal_3_0=ruleTerminalVal();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"terminalVal",
                    							lv_terminalVal_3_0,
                    							"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.TerminalVal");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssignmentFinderTestLanguage.g:132:3: (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:132:3: (otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) ) )
                    // InternalAssignmentFinderTestLanguage.g:133:4: otherlv_4= '#02' ( (lv_enumVal_5_0= ruleEnumVal ) )
                    {
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getModelAccess().getNumberSignDigitZeroDigitTwoKeyword_2_0());
                    			
                    // InternalAssignmentFinderTestLanguage.g:137:4: ( (lv_enumVal_5_0= ruleEnumVal ) )
                    // InternalAssignmentFinderTestLanguage.g:138:5: (lv_enumVal_5_0= ruleEnumVal )
                    {
                    // InternalAssignmentFinderTestLanguage.g:138:5: (lv_enumVal_5_0= ruleEnumVal )
                    // InternalAssignmentFinderTestLanguage.g:139:6: lv_enumVal_5_0= ruleEnumVal
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getEnumValEnumValParserRuleCall_2_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_enumVal_5_0=ruleEnumVal();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"enumVal",
                    							lv_enumVal_5_0,
                    							"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.EnumVal");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAssignmentFinderTestLanguage.g:158:3: (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:158:3: (otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) ) )
                    // InternalAssignmentFinderTestLanguage.g:159:4: otherlv_6= '#03' ( (lv_keywordBool_7_0= ruleKeywordBool ) )
                    {
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getNumberSignDigitZeroDigitThreeKeyword_3_0());
                    			
                    // InternalAssignmentFinderTestLanguage.g:163:4: ( (lv_keywordBool_7_0= ruleKeywordBool ) )
                    // InternalAssignmentFinderTestLanguage.g:164:5: (lv_keywordBool_7_0= ruleKeywordBool )
                    {
                    // InternalAssignmentFinderTestLanguage.g:164:5: (lv_keywordBool_7_0= ruleKeywordBool )
                    // InternalAssignmentFinderTestLanguage.g:165:6: lv_keywordBool_7_0= ruleKeywordBool
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getKeywordBoolKeywordBoolParserRuleCall_3_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_keywordBool_7_0=ruleKeywordBool();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"keywordBool",
                    							lv_keywordBool_7_0,
                    							"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.KeywordBool");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAssignmentFinderTestLanguage.g:184:3: (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:184:3: (otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) ) )
                    // InternalAssignmentFinderTestLanguage.g:185:4: otherlv_8= '#04' ( (lv_terminalBool_9_0= ruleTerminalBool ) )
                    {
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getModelAccess().getNumberSignDigitZeroDigitFourKeyword_4_0());
                    			
                    // InternalAssignmentFinderTestLanguage.g:189:4: ( (lv_terminalBool_9_0= ruleTerminalBool ) )
                    // InternalAssignmentFinderTestLanguage.g:190:5: (lv_terminalBool_9_0= ruleTerminalBool )
                    {
                    // InternalAssignmentFinderTestLanguage.g:190:5: (lv_terminalBool_9_0= ruleTerminalBool )
                    // InternalAssignmentFinderTestLanguage.g:191:6: lv_terminalBool_9_0= ruleTerminalBool
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getTerminalBoolTerminalBoolParserRuleCall_4_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_terminalBool_9_0=ruleTerminalBool();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"terminalBool",
                    							lv_terminalBool_9_0,
                    							"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.TerminalBool");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalAssignmentFinderTestLanguage.g:210:3: (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:210:3: (otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) ) )
                    // InternalAssignmentFinderTestLanguage.g:211:4: otherlv_10= '#05' ( (lv_enumBool_11_0= ruleEnumBool ) )
                    {
                    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getModelAccess().getNumberSignDigitZeroDigitFiveKeyword_5_0());
                    			
                    // InternalAssignmentFinderTestLanguage.g:215:4: ( (lv_enumBool_11_0= ruleEnumBool ) )
                    // InternalAssignmentFinderTestLanguage.g:216:5: (lv_enumBool_11_0= ruleEnumBool )
                    {
                    // InternalAssignmentFinderTestLanguage.g:216:5: (lv_enumBool_11_0= ruleEnumBool )
                    // InternalAssignmentFinderTestLanguage.g:217:6: lv_enumBool_11_0= ruleEnumBool
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getEnumBoolEnumBoolParserRuleCall_5_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_enumBool_11_0=ruleEnumBool();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"enumBool",
                    							lv_enumBool_11_0,
                    							"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.EnumBool");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalAssignmentFinderTestLanguage.g:236:3: (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:236:3: (otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) ) )
                    // InternalAssignmentFinderTestLanguage.g:237:4: otherlv_12= '#06' ( (lv_mixedBool_13_0= ruleMixedBool ) )
                    {
                    otherlv_12=(Token)match(input,19,FollowSets000.FOLLOW_6); 

                    				newLeafNode(otherlv_12, grammarAccess.getModelAccess().getNumberSignDigitZeroDigitSixKeyword_6_0());
                    			
                    // InternalAssignmentFinderTestLanguage.g:241:4: ( (lv_mixedBool_13_0= ruleMixedBool ) )
                    // InternalAssignmentFinderTestLanguage.g:242:5: (lv_mixedBool_13_0= ruleMixedBool )
                    {
                    // InternalAssignmentFinderTestLanguage.g:242:5: (lv_mixedBool_13_0= ruleMixedBool )
                    // InternalAssignmentFinderTestLanguage.g:243:6: lv_mixedBool_13_0= ruleMixedBool
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getMixedBoolMixedBoolParserRuleCall_6_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_mixedBool_13_0=ruleMixedBool();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"mixedBool",
                    							lv_mixedBool_13_0,
                    							"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.MixedBool");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalAssignmentFinderTestLanguage.g:262:3: (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:262:3: (otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) ) )
                    // InternalAssignmentFinderTestLanguage.g:263:4: otherlv_14= '#07' ( (lv_mixedValue_15_0= ruleMixedValue ) )
                    {
                    otherlv_14=(Token)match(input,20,FollowSets000.FOLLOW_7); 

                    				newLeafNode(otherlv_14, grammarAccess.getModelAccess().getNumberSignDigitZeroDigitSevenKeyword_7_0());
                    			
                    // InternalAssignmentFinderTestLanguage.g:267:4: ( (lv_mixedValue_15_0= ruleMixedValue ) )
                    // InternalAssignmentFinderTestLanguage.g:268:5: (lv_mixedValue_15_0= ruleMixedValue )
                    {
                    // InternalAssignmentFinderTestLanguage.g:268:5: (lv_mixedValue_15_0= ruleMixedValue )
                    // InternalAssignmentFinderTestLanguage.g:269:6: lv_mixedValue_15_0= ruleMixedValue
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getMixedValueMixedValueParserRuleCall_7_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_mixedValue_15_0=ruleMixedValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"mixedValue",
                    							lv_mixedValue_15_0,
                    							"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.MixedValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalAssignmentFinderTestLanguage.g:288:3: (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:288:3: (otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) ) )
                    // InternalAssignmentFinderTestLanguage.g:289:4: otherlv_16= '#08' ( (lv_containmentRef_17_0= ruleContainmentRef ) )
                    {
                    otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_16, grammarAccess.getModelAccess().getNumberSignDigitZeroDigitEightKeyword_8_0());
                    			
                    // InternalAssignmentFinderTestLanguage.g:293:4: ( (lv_containmentRef_17_0= ruleContainmentRef ) )
                    // InternalAssignmentFinderTestLanguage.g:294:5: (lv_containmentRef_17_0= ruleContainmentRef )
                    {
                    // InternalAssignmentFinderTestLanguage.g:294:5: (lv_containmentRef_17_0= ruleContainmentRef )
                    // InternalAssignmentFinderTestLanguage.g:295:6: lv_containmentRef_17_0= ruleContainmentRef
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getContainmentRefContainmentRefParserRuleCall_8_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_containmentRef_17_0=ruleContainmentRef();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"containmentRef",
                    							lv_containmentRef_17_0,
                    							"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.ContainmentRef");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalAssignmentFinderTestLanguage.g:314:3: (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:314:3: (otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) ) )
                    // InternalAssignmentFinderTestLanguage.g:315:4: otherlv_18= '#09' ( (lv_crossRef_19_0= ruleCrossRef ) )
                    {
                    otherlv_18=(Token)match(input,22,FollowSets000.FOLLOW_8); 

                    				newLeafNode(otherlv_18, grammarAccess.getModelAccess().getNumberSignDigitZeroDigitNineKeyword_9_0());
                    			
                    // InternalAssignmentFinderTestLanguage.g:319:4: ( (lv_crossRef_19_0= ruleCrossRef ) )
                    // InternalAssignmentFinderTestLanguage.g:320:5: (lv_crossRef_19_0= ruleCrossRef )
                    {
                    // InternalAssignmentFinderTestLanguage.g:320:5: (lv_crossRef_19_0= ruleCrossRef )
                    // InternalAssignmentFinderTestLanguage.g:321:6: lv_crossRef_19_0= ruleCrossRef
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getCrossRefCrossRefParserRuleCall_9_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_crossRef_19_0=ruleCrossRef();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"crossRef",
                    							lv_crossRef_19_0,
                    							"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.CrossRef");
                    						afterParserOrEnumRuleCall();
                    					

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleKeywordVal"
    // InternalAssignmentFinderTestLanguage.g:343:1: entryRuleKeywordVal returns [EObject current=null] : iv_ruleKeywordVal= ruleKeywordVal EOF ;
    public final EObject entryRuleKeywordVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywordVal = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:343:51: (iv_ruleKeywordVal= ruleKeywordVal EOF )
            // InternalAssignmentFinderTestLanguage.g:344:2: iv_ruleKeywordVal= ruleKeywordVal EOF
            {
             newCompositeNode(grammarAccess.getKeywordValRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKeywordVal=ruleKeywordVal();

            state._fsp--;

             current =iv_ruleKeywordVal; 
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
    // $ANTLR end "entryRuleKeywordVal"


    // $ANTLR start "ruleKeywordVal"
    // InternalAssignmentFinderTestLanguage.g:350:1: ruleKeywordVal returns [EObject current=null] : ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) ;
    public final EObject ruleKeywordVal() throws RecognitionException {
        EObject current = null;

        Token lv_kw_0_0=null;
        Token lv_kw_1_0=null;


        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:356:2: ( ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:357:2: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:357:2: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==23) ) {
                alt2=1;
            }
            else if ( (LA2_0==24) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:358:3: ( (lv_kw_0_0= 'kw1' ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:358:3: ( (lv_kw_0_0= 'kw1' ) )
                    // InternalAssignmentFinderTestLanguage.g:359:4: (lv_kw_0_0= 'kw1' )
                    {
                    // InternalAssignmentFinderTestLanguage.g:359:4: (lv_kw_0_0= 'kw1' )
                    // InternalAssignmentFinderTestLanguage.g:360:5: lv_kw_0_0= 'kw1'
                    {
                    lv_kw_0_0=(Token)match(input,23,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_kw_0_0, grammarAccess.getKeywordValAccess().getKwKw1Keyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getKeywordValRule());
                    					}
                    					setWithLastConsumed(current, "kw", lv_kw_0_0, "kw1");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:373:3: ( (lv_kw_1_0= 'kw2' ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:373:3: ( (lv_kw_1_0= 'kw2' ) )
                    // InternalAssignmentFinderTestLanguage.g:374:4: (lv_kw_1_0= 'kw2' )
                    {
                    // InternalAssignmentFinderTestLanguage.g:374:4: (lv_kw_1_0= 'kw2' )
                    // InternalAssignmentFinderTestLanguage.g:375:5: lv_kw_1_0= 'kw2'
                    {
                    lv_kw_1_0=(Token)match(input,24,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_kw_1_0, grammarAccess.getKeywordValAccess().getKwKw2Keyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getKeywordValRule());
                    					}
                    					setWithLastConsumed(current, "kw", lv_kw_1_0, "kw2");
                    				

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
    // $ANTLR end "ruleKeywordVal"


    // $ANTLR start "entryRuleTerminalVal"
    // InternalAssignmentFinderTestLanguage.g:391:1: entryRuleTerminalVal returns [EObject current=null] : iv_ruleTerminalVal= ruleTerminalVal EOF ;
    public final EObject entryRuleTerminalVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalVal = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:391:52: (iv_ruleTerminalVal= ruleTerminalVal EOF )
            // InternalAssignmentFinderTestLanguage.g:392:2: iv_ruleTerminalVal= ruleTerminalVal EOF
            {
             newCompositeNode(grammarAccess.getTerminalValRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalVal=ruleTerminalVal();

            state._fsp--;

             current =iv_ruleTerminalVal; 
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
    // $ANTLR end "entryRuleTerminalVal"


    // $ANTLR start "ruleTerminalVal"
    // InternalAssignmentFinderTestLanguage.g:398:1: ruleTerminalVal returns [EObject current=null] : ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) ;
    public final EObject ruleTerminalVal() throws RecognitionException {
        EObject current = null;

        Token lv_term_0_0=null;
        Token lv_term_1_0=null;
        Token lv_term_2_0=null;


        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:404:2: ( ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:405:2: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:405:2: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_TERMINAL1:
                {
                alt3=1;
                }
                break;
            case RULE_TERMINAL2:
                {
                alt3=2;
                }
                break;
            case 25:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:406:3: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:406:3: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    // InternalAssignmentFinderTestLanguage.g:407:4: (lv_term_0_0= RULE_TERMINAL1 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:407:4: (lv_term_0_0= RULE_TERMINAL1 )
                    // InternalAssignmentFinderTestLanguage.g:408:5: lv_term_0_0= RULE_TERMINAL1
                    {
                    lv_term_0_0=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_term_0_0, grammarAccess.getTerminalValAccess().getTermTerminal1TerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTerminalValRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"term",
                    						lv_term_0_0,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.Terminal1");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:425:3: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:425:3: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    // InternalAssignmentFinderTestLanguage.g:426:4: (lv_term_1_0= RULE_TERMINAL2 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:426:4: (lv_term_1_0= RULE_TERMINAL2 )
                    // InternalAssignmentFinderTestLanguage.g:427:5: lv_term_1_0= RULE_TERMINAL2
                    {
                    lv_term_1_0=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_term_1_0, grammarAccess.getTerminalValAccess().getTermTerminal2TerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTerminalValRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"term",
                    						lv_term_1_0,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.Terminal2");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssignmentFinderTestLanguage.g:444:3: ( (lv_term_2_0= '%foo' ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:444:3: ( (lv_term_2_0= '%foo' ) )
                    // InternalAssignmentFinderTestLanguage.g:445:4: (lv_term_2_0= '%foo' )
                    {
                    // InternalAssignmentFinderTestLanguage.g:445:4: (lv_term_2_0= '%foo' )
                    // InternalAssignmentFinderTestLanguage.g:446:5: lv_term_2_0= '%foo'
                    {
                    lv_term_2_0=(Token)match(input,25,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_term_2_0, grammarAccess.getTerminalValAccess().getTermFooKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTerminalValRule());
                    					}
                    					setWithLastConsumed(current, "term", lv_term_2_0, "%foo");
                    				

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
    // $ANTLR end "ruleTerminalVal"


    // $ANTLR start "entryRuleEnumVal"
    // InternalAssignmentFinderTestLanguage.g:462:1: entryRuleEnumVal returns [EObject current=null] : iv_ruleEnumVal= ruleEnumVal EOF ;
    public final EObject entryRuleEnumVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumVal = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:462:48: (iv_ruleEnumVal= ruleEnumVal EOF )
            // InternalAssignmentFinderTestLanguage.g:463:2: iv_ruleEnumVal= ruleEnumVal EOF
            {
             newCompositeNode(grammarAccess.getEnumValRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumVal=ruleEnumVal();

            state._fsp--;

             current =iv_ruleEnumVal; 
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
    // $ANTLR end "entryRuleEnumVal"


    // $ANTLR start "ruleEnumVal"
    // InternalAssignmentFinderTestLanguage.g:469:1: ruleEnumVal returns [EObject current=null] : ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) ;
    public final EObject ruleEnumVal() throws RecognitionException {
        EObject current = null;

        Enumerator lv_en_0_0 = null;

        Enumerator lv_en_1_0 = null;



        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:475:2: ( ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:476:2: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:476:2: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==29) ) {
                alt4=1;
            }
            else if ( (LA4_0==30) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:477:3: ( (lv_en_0_0= ruleEnum1 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:477:3: ( (lv_en_0_0= ruleEnum1 ) )
                    // InternalAssignmentFinderTestLanguage.g:478:4: (lv_en_0_0= ruleEnum1 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:478:4: (lv_en_0_0= ruleEnum1 )
                    // InternalAssignmentFinderTestLanguage.g:479:5: lv_en_0_0= ruleEnum1
                    {

                    					newCompositeNode(grammarAccess.getEnumValAccess().getEnEnum1EnumRuleCall_0_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_en_0_0=ruleEnum1();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEnumValRule());
                    					}
                    					set(
                    						current,
                    						"en",
                    						lv_en_0_0,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.Enum1");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:497:3: ( (lv_en_1_0= ruleEnum2 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:497:3: ( (lv_en_1_0= ruleEnum2 ) )
                    // InternalAssignmentFinderTestLanguage.g:498:4: (lv_en_1_0= ruleEnum2 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:498:4: (lv_en_1_0= ruleEnum2 )
                    // InternalAssignmentFinderTestLanguage.g:499:5: lv_en_1_0= ruleEnum2
                    {

                    					newCompositeNode(grammarAccess.getEnumValAccess().getEnEnum2EnumRuleCall_1_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_en_1_0=ruleEnum2();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEnumValRule());
                    					}
                    					set(
                    						current,
                    						"en",
                    						lv_en_1_0,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.Enum2");
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
    // $ANTLR end "ruleEnumVal"


    // $ANTLR start "entryRuleKeywordBool"
    // InternalAssignmentFinderTestLanguage.g:520:1: entryRuleKeywordBool returns [EObject current=null] : iv_ruleKeywordBool= ruleKeywordBool EOF ;
    public final EObject entryRuleKeywordBool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywordBool = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:520:52: (iv_ruleKeywordBool= ruleKeywordBool EOF )
            // InternalAssignmentFinderTestLanguage.g:521:2: iv_ruleKeywordBool= ruleKeywordBool EOF
            {
             newCompositeNode(grammarAccess.getKeywordBoolRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKeywordBool=ruleKeywordBool();

            state._fsp--;

             current =iv_ruleKeywordBool; 
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
    // $ANTLR end "entryRuleKeywordBool"


    // $ANTLR start "ruleKeywordBool"
    // InternalAssignmentFinderTestLanguage.g:527:1: ruleKeywordBool returns [EObject current=null] : ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) ;
    public final EObject ruleKeywordBool() throws RecognitionException {
        EObject current = null;

        Token lv_kw_0_0=null;
        Token lv_kw_1_0=null;


        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:533:2: ( ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:534:2: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:534:2: ( ( (lv_kw_0_0= 'kw1' ) ) | ( (lv_kw_1_0= 'kw2' ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==23) ) {
                alt5=1;
            }
            else if ( (LA5_0==24) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:535:3: ( (lv_kw_0_0= 'kw1' ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:535:3: ( (lv_kw_0_0= 'kw1' ) )
                    // InternalAssignmentFinderTestLanguage.g:536:4: (lv_kw_0_0= 'kw1' )
                    {
                    // InternalAssignmentFinderTestLanguage.g:536:4: (lv_kw_0_0= 'kw1' )
                    // InternalAssignmentFinderTestLanguage.g:537:5: lv_kw_0_0= 'kw1'
                    {
                    lv_kw_0_0=(Token)match(input,23,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_kw_0_0, grammarAccess.getKeywordBoolAccess().getKwKw1Keyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getKeywordBoolRule());
                    					}
                    					setWithLastConsumed(current, "kw", lv_kw_0_0 != null, "kw1");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:550:3: ( (lv_kw_1_0= 'kw2' ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:550:3: ( (lv_kw_1_0= 'kw2' ) )
                    // InternalAssignmentFinderTestLanguage.g:551:4: (lv_kw_1_0= 'kw2' )
                    {
                    // InternalAssignmentFinderTestLanguage.g:551:4: (lv_kw_1_0= 'kw2' )
                    // InternalAssignmentFinderTestLanguage.g:552:5: lv_kw_1_0= 'kw2'
                    {
                    lv_kw_1_0=(Token)match(input,24,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_kw_1_0, grammarAccess.getKeywordBoolAccess().getKwKw2Keyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getKeywordBoolRule());
                    					}
                    					setWithLastConsumed(current, "kw", lv_kw_1_0 != null, "kw2");
                    				

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
    // $ANTLR end "ruleKeywordBool"


    // $ANTLR start "entryRuleTerminalBool"
    // InternalAssignmentFinderTestLanguage.g:568:1: entryRuleTerminalBool returns [EObject current=null] : iv_ruleTerminalBool= ruleTerminalBool EOF ;
    public final EObject entryRuleTerminalBool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalBool = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:568:53: (iv_ruleTerminalBool= ruleTerminalBool EOF )
            // InternalAssignmentFinderTestLanguage.g:569:2: iv_ruleTerminalBool= ruleTerminalBool EOF
            {
             newCompositeNode(grammarAccess.getTerminalBoolRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalBool=ruleTerminalBool();

            state._fsp--;

             current =iv_ruleTerminalBool; 
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
    // $ANTLR end "entryRuleTerminalBool"


    // $ANTLR start "ruleTerminalBool"
    // InternalAssignmentFinderTestLanguage.g:575:1: ruleTerminalBool returns [EObject current=null] : ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) ;
    public final EObject ruleTerminalBool() throws RecognitionException {
        EObject current = null;

        Token lv_term_0_0=null;
        Token lv_term_1_0=null;
        Token lv_term_2_0=null;


        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:581:2: ( ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:582:2: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:582:2: ( ( (lv_term_0_0= RULE_TERMINAL1 ) ) | ( (lv_term_1_0= RULE_TERMINAL2 ) ) | ( (lv_term_2_0= '%foo' ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_TERMINAL1:
                {
                alt6=1;
                }
                break;
            case RULE_TERMINAL2:
                {
                alt6=2;
                }
                break;
            case 25:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:583:3: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:583:3: ( (lv_term_0_0= RULE_TERMINAL1 ) )
                    // InternalAssignmentFinderTestLanguage.g:584:4: (lv_term_0_0= RULE_TERMINAL1 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:584:4: (lv_term_0_0= RULE_TERMINAL1 )
                    // InternalAssignmentFinderTestLanguage.g:585:5: lv_term_0_0= RULE_TERMINAL1
                    {
                    lv_term_0_0=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_term_0_0, grammarAccess.getTerminalBoolAccess().getTermTerminal1TerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTerminalBoolRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"term",
                    						lv_term_0_0 != null,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.Terminal1");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:602:3: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:602:3: ( (lv_term_1_0= RULE_TERMINAL2 ) )
                    // InternalAssignmentFinderTestLanguage.g:603:4: (lv_term_1_0= RULE_TERMINAL2 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:603:4: (lv_term_1_0= RULE_TERMINAL2 )
                    // InternalAssignmentFinderTestLanguage.g:604:5: lv_term_1_0= RULE_TERMINAL2
                    {
                    lv_term_1_0=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_term_1_0, grammarAccess.getTerminalBoolAccess().getTermTerminal2TerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTerminalBoolRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"term",
                    						lv_term_1_0 != null,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.Terminal2");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAssignmentFinderTestLanguage.g:621:3: ( (lv_term_2_0= '%foo' ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:621:3: ( (lv_term_2_0= '%foo' ) )
                    // InternalAssignmentFinderTestLanguage.g:622:4: (lv_term_2_0= '%foo' )
                    {
                    // InternalAssignmentFinderTestLanguage.g:622:4: (lv_term_2_0= '%foo' )
                    // InternalAssignmentFinderTestLanguage.g:623:5: lv_term_2_0= '%foo'
                    {
                    lv_term_2_0=(Token)match(input,25,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_term_2_0, grammarAccess.getTerminalBoolAccess().getTermFooKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTerminalBoolRule());
                    					}
                    					setWithLastConsumed(current, "term", lv_term_2_0 != null, "%foo");
                    				

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
    // $ANTLR end "ruleTerminalBool"


    // $ANTLR start "entryRuleEnumBool"
    // InternalAssignmentFinderTestLanguage.g:639:1: entryRuleEnumBool returns [EObject current=null] : iv_ruleEnumBool= ruleEnumBool EOF ;
    public final EObject entryRuleEnumBool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumBool = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:639:49: (iv_ruleEnumBool= ruleEnumBool EOF )
            // InternalAssignmentFinderTestLanguage.g:640:2: iv_ruleEnumBool= ruleEnumBool EOF
            {
             newCompositeNode(grammarAccess.getEnumBoolRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumBool=ruleEnumBool();

            state._fsp--;

             current =iv_ruleEnumBool; 
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
    // $ANTLR end "entryRuleEnumBool"


    // $ANTLR start "ruleEnumBool"
    // InternalAssignmentFinderTestLanguage.g:646:1: ruleEnumBool returns [EObject current=null] : ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) ;
    public final EObject ruleEnumBool() throws RecognitionException {
        EObject current = null;

        Enumerator lv_en_0_0 = null;

        Enumerator lv_en_1_0 = null;



        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:652:2: ( ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:653:2: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:653:2: ( ( (lv_en_0_0= ruleEnum1 ) ) | ( (lv_en_1_0= ruleEnum2 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==29) ) {
                alt7=1;
            }
            else if ( (LA7_0==30) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:654:3: ( (lv_en_0_0= ruleEnum1 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:654:3: ( (lv_en_0_0= ruleEnum1 ) )
                    // InternalAssignmentFinderTestLanguage.g:655:4: (lv_en_0_0= ruleEnum1 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:655:4: (lv_en_0_0= ruleEnum1 )
                    // InternalAssignmentFinderTestLanguage.g:656:5: lv_en_0_0= ruleEnum1
                    {

                    					newCompositeNode(grammarAccess.getEnumBoolAccess().getEnEnum1EnumRuleCall_0_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_en_0_0=ruleEnum1();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEnumBoolRule());
                    					}
                    					set(
                    						current,
                    						"en",
                    						lv_en_0_0 != null,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.Enum1");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:674:3: ( (lv_en_1_0= ruleEnum2 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:674:3: ( (lv_en_1_0= ruleEnum2 ) )
                    // InternalAssignmentFinderTestLanguage.g:675:4: (lv_en_1_0= ruleEnum2 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:675:4: (lv_en_1_0= ruleEnum2 )
                    // InternalAssignmentFinderTestLanguage.g:676:5: lv_en_1_0= ruleEnum2
                    {

                    					newCompositeNode(grammarAccess.getEnumBoolAccess().getEnEnum2EnumRuleCall_1_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_en_1_0=ruleEnum2();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEnumBoolRule());
                    					}
                    					set(
                    						current,
                    						"en",
                    						lv_en_1_0 != null,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.Enum2");
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
    // $ANTLR end "ruleEnumBool"


    // $ANTLR start "entryRuleMixedBool"
    // InternalAssignmentFinderTestLanguage.g:697:1: entryRuleMixedBool returns [EObject current=null] : iv_ruleMixedBool= ruleMixedBool EOF ;
    public final EObject entryRuleMixedBool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMixedBool = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:697:50: (iv_ruleMixedBool= ruleMixedBool EOF )
            // InternalAssignmentFinderTestLanguage.g:698:2: iv_ruleMixedBool= ruleMixedBool EOF
            {
             newCompositeNode(grammarAccess.getMixedBoolRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMixedBool=ruleMixedBool();

            state._fsp--;

             current =iv_ruleMixedBool; 
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
    // $ANTLR end "entryRuleMixedBool"


    // $ANTLR start "ruleMixedBool"
    // InternalAssignmentFinderTestLanguage.g:704:1: ruleMixedBool returns [EObject current=null] : ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) ) ;
    public final EObject ruleMixedBool() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;
        AntlrDatatypeRuleToken lv_val_1_0 = null;



        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:710:2: ( ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:711:2: ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:711:2: ( ( (lv_val_0_0= 'kw1' ) ) | ( (lv_val_1_0= ruleBoolean ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=26 && LA8_0<=27)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:712:3: ( (lv_val_0_0= 'kw1' ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:712:3: ( (lv_val_0_0= 'kw1' ) )
                    // InternalAssignmentFinderTestLanguage.g:713:4: (lv_val_0_0= 'kw1' )
                    {
                    // InternalAssignmentFinderTestLanguage.g:713:4: (lv_val_0_0= 'kw1' )
                    // InternalAssignmentFinderTestLanguage.g:714:5: lv_val_0_0= 'kw1'
                    {
                    lv_val_0_0=(Token)match(input,23,FollowSets000.FOLLOW_2); 

                    					newLeafNode(lv_val_0_0, grammarAccess.getMixedBoolAccess().getValKw1Keyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMixedBoolRule());
                    					}
                    					setWithLastConsumed(current, "val", lv_val_0_0 != null, "kw1");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:727:3: ( (lv_val_1_0= ruleBoolean ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:727:3: ( (lv_val_1_0= ruleBoolean ) )
                    // InternalAssignmentFinderTestLanguage.g:728:4: (lv_val_1_0= ruleBoolean )
                    {
                    // InternalAssignmentFinderTestLanguage.g:728:4: (lv_val_1_0= ruleBoolean )
                    // InternalAssignmentFinderTestLanguage.g:729:5: lv_val_1_0= ruleBoolean
                    {

                    					newCompositeNode(grammarAccess.getMixedBoolAccess().getValBooleanParserRuleCall_1_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_1_0=ruleBoolean();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getMixedBoolRule());
                    					}
                    					set(
                    						current,
                    						"val",
                    						lv_val_1_0,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.Boolean");
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
    // $ANTLR end "ruleMixedBool"


    // $ANTLR start "entryRuleBoolean"
    // InternalAssignmentFinderTestLanguage.g:750:1: entryRuleBoolean returns [String current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final String entryRuleBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBoolean = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:750:47: (iv_ruleBoolean= ruleBoolean EOF )
            // InternalAssignmentFinderTestLanguage.g:751:2: iv_ruleBoolean= ruleBoolean EOF
            {
             newCompositeNode(grammarAccess.getBooleanRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean.getText(); 
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
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalAssignmentFinderTestLanguage.g:757:1: ruleBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:763:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalAssignmentFinderTestLanguage.g:764:2: (kw= 'true' | kw= 'false' )
            {
            // InternalAssignmentFinderTestLanguage.g:764:2: (kw= 'true' | kw= 'false' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            else if ( (LA9_0==27) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:765:3: kw= 'true'
                    {
                    kw=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:771:3: kw= 'false'
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBooleanAccess().getFalseKeyword_1());
                    		

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
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleMixedValue"
    // InternalAssignmentFinderTestLanguage.g:780:1: entryRuleMixedValue returns [EObject current=null] : iv_ruleMixedValue= ruleMixedValue EOF ;
    public final EObject entryRuleMixedValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMixedValue = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:780:51: (iv_ruleMixedValue= ruleMixedValue EOF )
            // InternalAssignmentFinderTestLanguage.g:781:2: iv_ruleMixedValue= ruleMixedValue EOF
            {
             newCompositeNode(grammarAccess.getMixedValueRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMixedValue=ruleMixedValue();

            state._fsp--;

             current =iv_ruleMixedValue; 
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
    // $ANTLR end "entryRuleMixedValue"


    // $ANTLR start "ruleMixedValue"
    // InternalAssignmentFinderTestLanguage.g:787:1: ruleMixedValue returns [EObject current=null] : ( ( (lv_val_0_0= ruleEnum1 ) ) | ( (lv_val_1_0= ruleDatEnum ) ) ) ;
    public final EObject ruleMixedValue() throws RecognitionException {
        EObject current = null;

        Enumerator lv_val_0_0 = null;

        AntlrDatatypeRuleToken lv_val_1_0 = null;



        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:793:2: ( ( ( (lv_val_0_0= ruleEnum1 ) ) | ( (lv_val_1_0= ruleDatEnum ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:794:2: ( ( (lv_val_0_0= ruleEnum1 ) ) | ( (lv_val_1_0= ruleDatEnum ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:794:2: ( ( (lv_val_0_0= ruleEnum1 ) ) | ( (lv_val_1_0= ruleDatEnum ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            else if ( (LA10_0==28) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:795:3: ( (lv_val_0_0= ruleEnum1 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:795:3: ( (lv_val_0_0= ruleEnum1 ) )
                    // InternalAssignmentFinderTestLanguage.g:796:4: (lv_val_0_0= ruleEnum1 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:796:4: (lv_val_0_0= ruleEnum1 )
                    // InternalAssignmentFinderTestLanguage.g:797:5: lv_val_0_0= ruleEnum1
                    {

                    					newCompositeNode(grammarAccess.getMixedValueAccess().getValEnum1EnumRuleCall_0_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_0_0=ruleEnum1();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getMixedValueRule());
                    					}
                    					set(
                    						current,
                    						"val",
                    						lv_val_0_0,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.Enum1");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:815:3: ( (lv_val_1_0= ruleDatEnum ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:815:3: ( (lv_val_1_0= ruleDatEnum ) )
                    // InternalAssignmentFinderTestLanguage.g:816:4: (lv_val_1_0= ruleDatEnum )
                    {
                    // InternalAssignmentFinderTestLanguage.g:816:4: (lv_val_1_0= ruleDatEnum )
                    // InternalAssignmentFinderTestLanguage.g:817:5: lv_val_1_0= ruleDatEnum
                    {

                    					newCompositeNode(grammarAccess.getMixedValueAccess().getValDatEnumParserRuleCall_1_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_1_0=ruleDatEnum();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getMixedValueRule());
                    					}
                    					set(
                    						current,
                    						"val",
                    						lv_val_1_0,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.DatEnum");
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
    // $ANTLR end "ruleMixedValue"


    // $ANTLR start "entryRuleDatEnum"
    // InternalAssignmentFinderTestLanguage.g:838:1: entryRuleDatEnum returns [String current=null] : iv_ruleDatEnum= ruleDatEnum EOF ;
    public final String entryRuleDatEnum() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatEnum = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:838:47: (iv_ruleDatEnum= ruleDatEnum EOF )
            // InternalAssignmentFinderTestLanguage.g:839:2: iv_ruleDatEnum= ruleDatEnum EOF
            {
             newCompositeNode(grammarAccess.getDatEnumRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatEnum=ruleDatEnum();

            state._fsp--;

             current =iv_ruleDatEnum.getText(); 
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
    // $ANTLR end "entryRuleDatEnum"


    // $ANTLR start "ruleDatEnum"
    // InternalAssignmentFinderTestLanguage.g:845:1: ruleDatEnum returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'lit3' ;
    public final AntlrDatatypeRuleToken ruleDatEnum() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:851:2: (kw= 'lit3' )
            // InternalAssignmentFinderTestLanguage.g:852:2: kw= 'lit3'
            {
            kw=(Token)match(input,28,FollowSets000.FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getDatEnumAccess().getLit3Keyword());
            	

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
    // $ANTLR end "ruleDatEnum"


    // $ANTLR start "entryRuleContainmentRef"
    // InternalAssignmentFinderTestLanguage.g:860:1: entryRuleContainmentRef returns [EObject current=null] : iv_ruleContainmentRef= ruleContainmentRef EOF ;
    public final EObject entryRuleContainmentRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentRef = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:860:55: (iv_ruleContainmentRef= ruleContainmentRef EOF )
            // InternalAssignmentFinderTestLanguage.g:861:2: iv_ruleContainmentRef= ruleContainmentRef EOF
            {
             newCompositeNode(grammarAccess.getContainmentRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContainmentRef=ruleContainmentRef();

            state._fsp--;

             current =iv_ruleContainmentRef; 
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
    // $ANTLR end "entryRuleContainmentRef"


    // $ANTLR start "ruleContainmentRef"
    // InternalAssignmentFinderTestLanguage.g:867:1: ruleContainmentRef returns [EObject current=null] : ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) ) ;
    public final EObject ruleContainmentRef() throws RecognitionException {
        EObject current = null;

        EObject lv_ctx_0_0 = null;

        EObject lv_ctx_1_0 = null;



        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:873:2: ( ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:874:2: ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:874:2: ( ( (lv_ctx_0_0= ruleContainmentRef1 ) ) | ( (lv_ctx_1_0= ruleContainmentRef2 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            else if ( (LA11_0==24) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:875:3: ( (lv_ctx_0_0= ruleContainmentRef1 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:875:3: ( (lv_ctx_0_0= ruleContainmentRef1 ) )
                    // InternalAssignmentFinderTestLanguage.g:876:4: (lv_ctx_0_0= ruleContainmentRef1 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:876:4: (lv_ctx_0_0= ruleContainmentRef1 )
                    // InternalAssignmentFinderTestLanguage.g:877:5: lv_ctx_0_0= ruleContainmentRef1
                    {

                    					newCompositeNode(grammarAccess.getContainmentRefAccess().getCtxContainmentRef1ParserRuleCall_0_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ctx_0_0=ruleContainmentRef1();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getContainmentRefRule());
                    					}
                    					set(
                    						current,
                    						"ctx",
                    						lv_ctx_0_0,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.ContainmentRef1");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:895:3: ( (lv_ctx_1_0= ruleContainmentRef2 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:895:3: ( (lv_ctx_1_0= ruleContainmentRef2 ) )
                    // InternalAssignmentFinderTestLanguage.g:896:4: (lv_ctx_1_0= ruleContainmentRef2 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:896:4: (lv_ctx_1_0= ruleContainmentRef2 )
                    // InternalAssignmentFinderTestLanguage.g:897:5: lv_ctx_1_0= ruleContainmentRef2
                    {

                    					newCompositeNode(grammarAccess.getContainmentRefAccess().getCtxContainmentRef2ParserRuleCall_1_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ctx_1_0=ruleContainmentRef2();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getContainmentRefRule());
                    					}
                    					set(
                    						current,
                    						"ctx",
                    						lv_ctx_1_0,
                    						"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.ContainmentRef2");
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
    // $ANTLR end "ruleContainmentRef"


    // $ANTLR start "entryRuleContainmentRef1"
    // InternalAssignmentFinderTestLanguage.g:918:1: entryRuleContainmentRef1 returns [EObject current=null] : iv_ruleContainmentRef1= ruleContainmentRef1 EOF ;
    public final EObject entryRuleContainmentRef1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentRef1 = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:918:56: (iv_ruleContainmentRef1= ruleContainmentRef1 EOF )
            // InternalAssignmentFinderTestLanguage.g:919:2: iv_ruleContainmentRef1= ruleContainmentRef1 EOF
            {
             newCompositeNode(grammarAccess.getContainmentRef1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContainmentRef1=ruleContainmentRef1();

            state._fsp--;

             current =iv_ruleContainmentRef1; 
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
    // $ANTLR end "entryRuleContainmentRef1"


    // $ANTLR start "ruleContainmentRef1"
    // InternalAssignmentFinderTestLanguage.g:925:1: ruleContainmentRef1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) ) ;
    public final EObject ruleContainmentRef1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;


        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:931:2: ( (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:932:2: (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:932:2: (otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) ) )
            // InternalAssignmentFinderTestLanguage.g:933:3: otherlv_0= 'kw1' ( (lv_val1_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getContainmentRef1Access().getKw1Keyword_0());
            		
            // InternalAssignmentFinderTestLanguage.g:937:3: ( (lv_val1_1_0= RULE_ID ) )
            // InternalAssignmentFinderTestLanguage.g:938:4: (lv_val1_1_0= RULE_ID )
            {
            // InternalAssignmentFinderTestLanguage.g:938:4: (lv_val1_1_0= RULE_ID )
            // InternalAssignmentFinderTestLanguage.g:939:5: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_val1_1_0, grammarAccess.getContainmentRef1Access().getVal1IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContainmentRef1Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"val1",
            						lv_val1_1_0,
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
    // $ANTLR end "ruleContainmentRef1"


    // $ANTLR start "entryRuleContainmentRef2"
    // InternalAssignmentFinderTestLanguage.g:959:1: entryRuleContainmentRef2 returns [EObject current=null] : iv_ruleContainmentRef2= ruleContainmentRef2 EOF ;
    public final EObject entryRuleContainmentRef2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentRef2 = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:959:56: (iv_ruleContainmentRef2= ruleContainmentRef2 EOF )
            // InternalAssignmentFinderTestLanguage.g:960:2: iv_ruleContainmentRef2= ruleContainmentRef2 EOF
            {
             newCompositeNode(grammarAccess.getContainmentRef2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContainmentRef2=ruleContainmentRef2();

            state._fsp--;

             current =iv_ruleContainmentRef2; 
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
    // $ANTLR end "entryRuleContainmentRef2"


    // $ANTLR start "ruleContainmentRef2"
    // InternalAssignmentFinderTestLanguage.g:966:1: ruleContainmentRef2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) ) ;
    public final EObject ruleContainmentRef2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val2_1_0=null;


        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:972:2: ( (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:973:2: (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:973:2: (otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) ) )
            // InternalAssignmentFinderTestLanguage.g:974:3: otherlv_0= 'kw2' ( (lv_val2_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getContainmentRef2Access().getKw2Keyword_0());
            		
            // InternalAssignmentFinderTestLanguage.g:978:3: ( (lv_val2_1_0= RULE_ID ) )
            // InternalAssignmentFinderTestLanguage.g:979:4: (lv_val2_1_0= RULE_ID )
            {
            // InternalAssignmentFinderTestLanguage.g:979:4: (lv_val2_1_0= RULE_ID )
            // InternalAssignmentFinderTestLanguage.g:980:5: lv_val2_1_0= RULE_ID
            {
            lv_val2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_val2_1_0, grammarAccess.getContainmentRef2Access().getVal2IDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContainmentRef2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"val2",
            						lv_val2_1_0,
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
    // $ANTLR end "ruleContainmentRef2"


    // $ANTLR start "entryRuleCrossRef"
    // InternalAssignmentFinderTestLanguage.g:1000:1: entryRuleCrossRef returns [EObject current=null] : iv_ruleCrossRef= ruleCrossRef EOF ;
    public final EObject entryRuleCrossRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossRef = null;


        try {
            // InternalAssignmentFinderTestLanguage.g:1000:49: (iv_ruleCrossRef= ruleCrossRef EOF )
            // InternalAssignmentFinderTestLanguage.g:1001:2: iv_ruleCrossRef= ruleCrossRef EOF
            {
             newCompositeNode(grammarAccess.getCrossRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCrossRef=ruleCrossRef();

            state._fsp--;

             current =iv_ruleCrossRef; 
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
    // $ANTLR end "entryRuleCrossRef"


    // $ANTLR start "ruleCrossRef"
    // InternalAssignmentFinderTestLanguage.g:1007:1: ruleCrossRef returns [EObject current=null] : ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) ) ;
    public final EObject ruleCrossRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:1013:2: ( ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:1014:2: ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:1014:2: ( ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) ) )
            // InternalAssignmentFinderTestLanguage.g:1015:3: ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) ) ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) )
            {
            // InternalAssignmentFinderTestLanguage.g:1015:3: ( ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) ) )
            // InternalAssignmentFinderTestLanguage.g:1016:4: ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) )
            {
            // InternalAssignmentFinderTestLanguage.g:1016:4: ( (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 ) )
            // InternalAssignmentFinderTestLanguage.g:1017:5: (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 )
            {
            // InternalAssignmentFinderTestLanguage.g:1017:5: (lv_name_0_1= RULE_TERMINAL1 | lv_name_0_2= RULE_TERMINAL2 )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_TERMINAL1) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_TERMINAL2) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:1018:6: lv_name_0_1= RULE_TERMINAL1
                    {
                    lv_name_0_1=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_8); 

                    						newLeafNode(lv_name_0_1, grammarAccess.getCrossRefAccess().getNameTerminal1TerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCrossRefRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_0_1,
                    							"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.Terminal1");
                    					

                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:1033:6: lv_name_0_2= RULE_TERMINAL2
                    {
                    lv_name_0_2=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_8); 

                    						newLeafNode(lv_name_0_2, grammarAccess.getCrossRefAccess().getNameTerminal2TerminalRuleCall_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCrossRefRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_0_2,
                    							"org.eclipse.xtext.serializer.AssignmentFinderTestLanguage.Terminal2");
                    					

                    }
                    break;

            }


            }


            }

            // InternalAssignmentFinderTestLanguage.g:1050:3: ( ( (otherlv_1= RULE_TERMINAL1 ) ) | ( (otherlv_2= RULE_TERMINAL2 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_TERMINAL1) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_TERMINAL2) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalAssignmentFinderTestLanguage.g:1051:4: ( (otherlv_1= RULE_TERMINAL1 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:1051:4: ( (otherlv_1= RULE_TERMINAL1 ) )
                    // InternalAssignmentFinderTestLanguage.g:1052:5: (otherlv_1= RULE_TERMINAL1 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:1052:5: (otherlv_1= RULE_TERMINAL1 )
                    // InternalAssignmentFinderTestLanguage.g:1053:6: otherlv_1= RULE_TERMINAL1
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCrossRefRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_TERMINAL1,FollowSets000.FOLLOW_2); 

                    						newLeafNode(otherlv_1, grammarAccess.getCrossRefAccess().getCrossRefCrossRefCrossReference_1_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAssignmentFinderTestLanguage.g:1065:4: ( (otherlv_2= RULE_TERMINAL2 ) )
                    {
                    // InternalAssignmentFinderTestLanguage.g:1065:4: ( (otherlv_2= RULE_TERMINAL2 ) )
                    // InternalAssignmentFinderTestLanguage.g:1066:5: (otherlv_2= RULE_TERMINAL2 )
                    {
                    // InternalAssignmentFinderTestLanguage.g:1066:5: (otherlv_2= RULE_TERMINAL2 )
                    // InternalAssignmentFinderTestLanguage.g:1067:6: otherlv_2= RULE_TERMINAL2
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCrossRefRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_TERMINAL2,FollowSets000.FOLLOW_2); 

                    						newLeafNode(otherlv_2, grammarAccess.getCrossRefAccess().getCrossRefCrossRefCrossReference_1_1_0());
                    					

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
    // $ANTLR end "ruleCrossRef"


    // $ANTLR start "ruleEnum1"
    // InternalAssignmentFinderTestLanguage.g:1083:1: ruleEnum1 returns [Enumerator current=null] : (enumLiteral_0= 'lit1' ) ;
    public final Enumerator ruleEnum1() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:1089:2: ( (enumLiteral_0= 'lit1' ) )
            // InternalAssignmentFinderTestLanguage.g:1090:2: (enumLiteral_0= 'lit1' )
            {
            // InternalAssignmentFinderTestLanguage.g:1090:2: (enumLiteral_0= 'lit1' )
            // InternalAssignmentFinderTestLanguage.g:1091:3: enumLiteral_0= 'lit1'
            {
            enumLiteral_0=(Token)match(input,29,FollowSets000.FOLLOW_2); 

            			current = grammarAccess.getEnum1Access().getLit1EnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getEnum1Access().getLit1EnumLiteralDeclaration());
            		

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
    // $ANTLR end "ruleEnum1"


    // $ANTLR start "ruleEnum2"
    // InternalAssignmentFinderTestLanguage.g:1100:1: ruleEnum2 returns [Enumerator current=null] : (enumLiteral_0= 'lit2' ) ;
    public final Enumerator ruleEnum2() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalAssignmentFinderTestLanguage.g:1106:2: ( (enumLiteral_0= 'lit2' ) )
            // InternalAssignmentFinderTestLanguage.g:1107:2: (enumLiteral_0= 'lit2' )
            {
            // InternalAssignmentFinderTestLanguage.g:1107:2: (enumLiteral_0= 'lit2' )
            // InternalAssignmentFinderTestLanguage.g:1108:3: enumLiteral_0= 'lit2'
            {
            enumLiteral_0=(Token)match(input,30,FollowSets000.FOLLOW_2); 

            			current = grammarAccess.getEnum2Access().getLit2EnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getEnum2Access().getLit2EnumLiteralDeclaration());
            		

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
    // $ANTLR end "ruleEnum2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000002000030L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000C800000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L});
    }


}